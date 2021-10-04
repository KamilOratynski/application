import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        String out = run(args);
        System.out.print(out);
    }

    private static String run(String[] args) {
        if (args.length == 0) {
            return "java Application: missing parameter\n" +
                    "Usage: java Application <number> [character]\n\n" +
                    "Arguments:\n" +
                    "<number>    - set number of characters displaying\n" +
                    "[character] - set character to display, 'x' is displayed by default";
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
        return out;
    }

    @Test
    public void noParam() {
        String[] args = {};
        String out = Application.run(args);
        Assertions.assertEquals("java Application: missing parameter\n" +
                "Usage: java Application <number> [character]\n\n" +
                "Arguments:\n" +
                "<number>    - set number of characters displaying\n" +
                "[character] - set character to display, 'x' is displayed by default", out);
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
