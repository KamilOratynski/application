import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        String out = run(args);
        System.out.print(out);
    }

    private static String run(String[] args) {
        if (args.length == 0) {
            return "Missing parameter.\n";
        }
        String out = "";
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; i++) {
            out += "x";
        }
        out += "\n";
        return out;
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
}
