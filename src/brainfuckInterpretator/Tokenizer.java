package brainfuckInterpretator;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tokenizer {
    private final String tokenTypes = "><+-.,[]";

    public ArrayList<String> getTokens(String code) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(code, tokenTypes, true);

        while(tokenizer.hasMoreTokens())
            tokens.add(tokenizer.nextToken());

        return tokens;
    }
}
