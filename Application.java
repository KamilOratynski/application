import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String out = run(args);
        System.out.print(out);
    }

    private static String run(String[] args) {
        if (args.length == 0 || args[0].equals("0")) {
            return "Missing parameter.\n";
        }

        int count = Integer.parseInt(args[0]);
        String out = "";
        for (int i = 0; i < count; i++) {
            if (args.length == 1) {
                out += "x";
            } else {
                out += args[1];
            }
        }
        out += "\n";

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.length() != 2) {
            return "Missing parameter.\n";
        }
        int index = Integer.parseInt(input.substring(0, 1));
        char newLetter = input.charAt(1);
        if (count < index || index == 0) {
            return "Missing parameter.\n";
        }
        return out.substring(0, index - 1) + newLetter + out.substring(index);
    }

    @Test
    public void noParam() {
        System.setIn(new ByteArrayInputStream("2z".getBytes()));
        String out = Application.run(new String[]{});
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withWrongParamToChange0() {
        System.setIn(new ByteArrayInputStream("0w".getBytes()));
        String out = Application.run(new String[]{"1", "y"});
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withSmallParamToChange() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        String out = Application.run(new String[]{"1", "y"});
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withParam0AndLargeParamToChange() {
        System.setIn(new ByteArrayInputStream("2z".getBytes()));
        String out = Application.run(new String[]{"0"});
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withParam1AndChangeHim() {
        System.setIn(new ByteArrayInputStream("1z".getBytes()));
        String out = Application.run(new String[]{"1"});
        Assertions.assertEquals("z\n", out);
    }

    @Test
    public void withParam2AndChangeFirst() {
        System.setIn(new ByteArrayInputStream("1z".getBytes()));
        String out = Application.run(new String[]{"2"});
        Assertions.assertEquals("zx\n", out);
    }

    @Test
    public void withParam2AndChangeSecond() {
        System.setIn(new ByteArrayInputStream("2z".getBytes()));
        String out = Application.run(new String[]{"2"});
        Assertions.assertEquals("xz\n", out);
    }

    @Test
    public void withParam2yAndChangeFirst() {
        System.setIn(new ByteArrayInputStream("1z".getBytes()));
        String out = Application.run(new String[]{"2", "y"});
        Assertions.assertEquals("zy\n", out);
    }

    @Test
    public void withParam2yAndChangeSecond() {
        System.setIn(new ByteArrayInputStream("2z".getBytes()));
        String out = Application.run(new String[]{"2", "y"});
        Assertions.assertEquals("yz\n", out);
    }
}
