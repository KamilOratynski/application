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
        String replacedChars = character.repeat(count) + "\n";
        System.out.print(replacedChars);
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String token = scanner.next();
            if (token.equals("q")) {
                return;
            }
            replacedChars = settingCharReplace(replacedChars, token);
            System.out.print(replacedChars);
        }
    }

    public static String settingCharReplace(String setChars, String token) {
        int index = Integer.parseInt(token.substring(0, 1));
        char newChar = token.charAt(1);
        return setChars.substring(0, index - 1) + newChar + setChars.substring(index);
    }

    @Test
    public void withParam1yReplace1a() {
        String out = Application.settingCharReplace("y", "1a");
        Assertions.assertEquals("a", out);
    }

    @Test
    public void withParam2yReplace2a() {
        String out = Application.settingCharReplace("yy", "2a");
        Assertions.assertEquals("ya", out);
    }

    @Test
    public void withParam2yReplace1a() {
        String out = Application.settingCharReplace("yy", "1a");
        Assertions.assertEquals("ay", out);
    }
}
