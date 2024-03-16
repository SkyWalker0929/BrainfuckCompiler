package brainfuckInterpretator;

import java.io.IOException;
import java.util.ArrayList;

public class BrainfuckInterpretator {
    private final Tokenizer tokenizer = new Tokenizer();
    CommandExecutor commandExecutor = new CommandExecutor();

    public void interpret(String code) {
        ArrayList<String> commands = tokenizer.getTokens(code);
        try {
            commandExecutor.executeCommands(commands);
        } catch (IOException e) {
            System.out.println("Unknown token");
            throw new RuntimeException(e);
        }
    }
}
