import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing parameter.");
            return;
        }
        int count = Integer.parseInt(args[0]);
        String character = "x";
        if (args.length > 1) {
            character = args[1];
        }
        String out = character.repeat(count) + "\n";
        System.out.print(out);
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String token = scanner.next();
            if (token.equals("q")) {
                return;
            }
            out = apply(out, token);
            System.out.print(out);
        }
    }

    public static String apply(String s, String token) {
        int index = Integer.parseInt(token.substring(0, 1));
        char c = token.charAt(1);
        return s.substring(0, index - 1) + c + s.substring(index);
    }

    @Test
    public void applyToken() {
        Assertions.assertEquals("a", Application.apply("y", "1a"));
        Assertions.assertEquals("ya", Application.apply("yy", "2a"));
        Assertions.assertEquals("ay", Application.apply("yy", "1a"));
    }
}
