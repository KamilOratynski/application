import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        String out = run(args);
        System.out.print(out);
    }

    private static String run(String[] args) {
        int count = 4;
        if (args.length > 0) {
            count = Integer.parseInt(args[0]);
        }

        String out = "";
        for (int i = 0; i < count; i++) {
            out += "x";
        }
        out += "\r\n";
        return out;
    }

    @Test
    public void test() {
        String args[] = {"0"};
        String out = Application.run(args);
        Assertions.assertEquals("\r\n", out);
    }

    @Test
    public void test2() {
        String args[] = {"1"};
        String out = Application.run(args);
        Assertions.assertEquals("x\r\n", out);
    }

    @Test
    public void test3() {
        String args[] = {"2"};
        String out = Application.run(args);
        Assertions.assertEquals("xx\r\n", out);
    }
}
