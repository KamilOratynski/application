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
        String table = character.repeat(count * count);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < count * count; i++) {
                System.out.print(table.charAt(i));
            }
            System.out.println();
            String token = scanner.next();
            if (token.equals("q")) {
                return;
            }
            table = apply(table, token);
        }
    }

    public static String apply(String s, String token) {
        int index = Integer.parseInt(token.replaceAll("[^\\d]", ""));
        String c = token.replaceAll("[^A-Za-z]", "");
        return s.substring(0, index - 1) + c + s.substring(index);
    }

    @Test
    public void applyToken() {
        Assertions.assertEquals("a", Application.apply("y", "1a"));
        Assertions.assertEquals("ya", Application.apply("yy", "2a"));
        Assertions.assertEquals("ay", Application.apply("yy", "1a"));
        Assertions.assertEquals("yyyyyyyyya", Application.apply("yyyyyyyyyy", "10a"));
        Assertions.assertEquals("asdyyyyyya", Application.apply("asdyyyyyyy", "10a"));
    }
}
