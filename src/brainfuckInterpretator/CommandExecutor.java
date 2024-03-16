package brainfuckInterpretator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandExecutor {
    private InputStreamReader reader = new InputStreamReader(System.in);
    private ArrayList<Integer> tape = new ArrayList<>();
    private int pointer = 0;
    private ArrayList<String> commands;
    private int i = 0;

    public void executeCommands(ArrayList<String> commands) throws IOException {
        for(int i = 0; i < 30000; i++) {
            tape.add(0);
        }

        this.commands = commands;
        for(; i < commands.size(); i++) {
           execute(commands.get(i));
        }
    }

    private void execute(String command) throws IOException {
        switch (command) {
            case ">" -> pointer++;
            case "<" -> pointer--;
            case "+" -> tape.set(pointer, tape.get(pointer) + 1);
            case "-" -> tape.set(pointer, tape.get(pointer) - 1);
            case "." -> System.out.print((char) tape.get(pointer).intValue());
            case "," -> tape.set(pointer, reader.read());
            case "[" -> {
                int startCycle = i;
                    while(true) {
                        i++;
                        if (commands.get(i).equals("]")) {
                            if(tape.get(pointer) == 0)
                                break;
                            i = startCycle;
                            continue;
                        }
                        execute(commands.get(i));
                    }
            }
        }
    }
}
