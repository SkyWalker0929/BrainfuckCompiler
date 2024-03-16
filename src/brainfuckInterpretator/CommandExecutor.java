package brainfuckInterpretator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandExecutor {
    private InputStreamReader reader = new InputStreamReader(System.in);
    private ArrayList<Integer> tape = new ArrayList<>(30000);
    private int pointer = 0;
    private ArrayList<String> commands;
    private int i = 0;

    public void executeCommands(ArrayList<String> commands) throws IOException {
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
            case "." -> System.out.print((char) (int) tape.get(pointer));
            case "," -> tape.set(pointer, reader.read());
            case "[" -> {
                while(true) {
                    for(; i < commands.size(); i++) {
                        if(!commands.get(pointer).equals("]"))
                            execute(commands.get(i));
                        else if(tape.get(pointer) == 0)
                            break;
                    }
                }
            }
        }
    }
}
