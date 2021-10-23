import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String setChars = run(args);
        System.out.print(setChars);
        Scanner scanner = new Scanner(System.in);
        String replacedChars = settingCharReplace(setChars, scanner);
        System.out.print(replacedChars);
        String loop = replacedChars;
        while (!loop.equals("")) {
            String newString = settingCharReplace(loop, scanner);
            loop = newString;
            System.out.print(newString);
        }
    }

    private static String run(String[] args) {
        if (args.length == 0) {
            return "Missing parameter.\n";
        }
        int count = Integer.parseInt(args[0]);
        String character = "x";
        if (args.length > 1) {
            character = args[1];
        }

        String setChars = "";
        for (int i = 0; i < count; i++) {
            setChars += character;
        }
        setChars += "\n";
        return setChars;
    }

    public static String settingCharReplace(String setChars, Scanner scanner) {
        if (setChars.equals("Missing parameter.\n")) {
            return "";
        }
        String replacedChar = scanner.next();
        if (replacedChar.equals("q")) {
            return "";
        } else {
            int index = Integer.parseInt(replacedChar.substring(0, 1));
            char newChar = replacedChar.charAt(1);
            return setChars.substring(0, index - 1) + newChar + setChars.substring(index);
        }
    }

    @Test
    public void withParam1yReplace1a() {
        String[] args = {"1", "y"};
        String out = Application.run(args);
        String out1 = Application.settingCharReplace(out, new Scanner("1a"));
        Assertions.assertEquals("a\n", out1);
    }

    @Test
    public void withParam2yReplace2a() {
        String[] args = {"2", "y"};
        String out = Application.run(args);
        String out1 = Application.settingCharReplace(out, new Scanner("2a"));
        Assertions.assertEquals("ya\n", out1);
    }

    @Test
    public void withParam2yReplace1a() {
        String[] args = {"2", "y"};
        String out = Application.run(args);
        String out1 = Application.settingCharReplace(out, new Scanner("1a"));
        Assertions.assertEquals("ay\n", out1);
    }

    @Test
    public void noParam() {
        String[] args = {};
        String out = Application.run(args);
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withParam0() {
        String[] args = {"0"};
        String out = Application.run(args);
        Assertions.assertEquals("\n", out);
    }

    @Test
    public void withParam1() {
        String[] args = {"1"};
        String out = Application.run(args);
        Assertions.assertEquals("x\n", out);
    }

    @Test
    public void withParam2() {
        String[] args = {"2"};
        String out = Application.run(args);
        Assertions.assertEquals("xx\n", out);
    }

    @Test
    public void withParam0y() {
        String[] args = {"0", "y"};
        String out = Application.run(args);
        Assertions.assertEquals("\n", out);
    }

    @Test
    public void withParam1y() {
        String[] args = {"1", "y"};
        String out = Application.run(args);
        Assertions.assertEquals("y\n", out);
    }

    @Test
    public void withParam2y() {
        String[] args = {"2", "y"};
        String out = Application.run(args);
        Assertions.assertEquals("yy\n", out);
    }
}
