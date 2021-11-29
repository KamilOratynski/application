import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: app <times> [char]\n\n" +
                    "<times> parameter defines length and width of chars displayed.\n" +
                    "Chars replace position starts at 1 and ends with <times> squared.\n\n" +
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
        for (int i = 0; i < count; i++) {
            out += character.repeat(count) + "\n";
        }
        System.out.print(out);
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String token = scanner.next();
            if (token.equals("q")) {
                return;
            }
            out = apply(out, token, count + 1);
            System.out.print(out);
        }
    }

    public static String apply(String s, String token, int row) {
        int index = Integer.parseInt(token.replaceAll("[^\\d]", ""));
        String c = token.replaceAll("[^A-Za-z]", "");
        for (int i = 1; i < row; i++) {
            if (index >= row * i) {
                index += 1;
            }
        }
        return s.substring(0, index - 1) + c + s.substring(index);
    }

    @Test
    public void applyToken() {
        Assertions.assertEquals("a\n", Application.apply("y\n", "1a", 2));
        Assertions.assertEquals("ay\nyy", Application.apply("yy\nyy", "1a", 3));
        Assertions.assertEquals("yy\nay", Application.apply("yy\nyy", "3a", 3));
        Assertions.assertEquals("yy\nya", Application.apply("yy\nyy", "4a", 3));
        Assertions.assertEquals("ayy\nyyy\nyyy", Application.apply("yyy\nyyy\nyyy", "1a", 4));
        Assertions.assertEquals("yyy\nayy\nyyy", Application.apply("yyy\nyyy\nyyy", "4a", 4));
        Assertions.assertEquals("yyy\nyyy\nayy", Application.apply("yyy\nyyy\nyyy", "7a", 4));
        Assertions.assertEquals("yyy\nyyy\nyya", Application.apply("yyy\nyyy\nyyy", "9a", 4));
        Assertions.assertEquals("yyyy\nyyyy\nyyyy\nyyya", Application.apply("yyyy\nyyyy\nyyyy\nyyyy", "16a", 5));
    }
}
