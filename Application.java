import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: app <times> [char]\n\n" +
                    "<times> parameter defines length and width of chars displayed.\n" +
                    "Chars replace position starts at 1 and ends with <times> squared.\n" +
                    "Commands:\n" +
                    "   1a - means position 1 and char 'a' to replace\n" +
                    "    q - quit");
            return;
        }
        int count = Integer.parseInt(args[0]);
        String character = "x";
        if (args.length > 1) {
            character = args[1];
        }
        String out = "";
        int length = 0;
        for (int i = 0; i < count; i++) {
            out += character.repeat(count) + "\n";
            if (i == 0) {
                length = out.length();
            }
        }
        System.out.print(out);
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String token = scanner.next();
            if (token.equals("q")) {
                return;
            }
            out = apply(out, token, length);
            System.out.print(out);
        }
    }

    public static String apply(String s, String token, int length) {
        int index = Integer.parseInt(token.replaceAll("[^\\d]", ""));
        String c = token.replaceAll("[^A-Za-z]", "");
        for (int i = 1; i < length; i++) {
            if (index >= length * i) {
                index += 1;
            }
        }
        if (index > s.length()) {
            return "Position of char to be replaced is too high.\n";
        }
        return s.substring(0, index - 1) + c + s.substring(index);
    }

    @Test
    public void applyToken() {
        Assertions.assertEquals("a", Application.apply("y", "1a", 2));
        Assertions.assertEquals("ya", Application.apply("yy", "2a", 3));
        Assertions.assertEquals("ay", Application.apply("yy", "1a", 2));
        Assertions.assertEquals("yyyyyyyyya", Application.apply("yyyyyyyyyy", "10a", 11));
        Assertions.assertEquals("asdyyyyyya", Application.apply("asdyyyyyyy", "10a", 11));
    }
}
