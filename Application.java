import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        String setChars = settingChars(args);
        System.out.print(setChars);
    }

    private static String settingChars(String[] args) {
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

    @Test
    public void noParam() {
        String[] args = {};
        String out = Application.settingChars(args);
        Assertions.assertEquals("Missing parameter.\n", out);
    }

    @Test
    public void withParam0() {
        String[] args = {"0"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("\n", out);
    }

    @Test
    public void withParam1() {
        String[] args = {"1"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("x\n", out);
    }

    @Test
    public void withParam2() {
        String[] args = {"2"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("xx\n", out);
    }

    @Test
    public void withParam0y() {
        String[] args = {"0", "y"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("\n", out);
    }

    @Test
    public void withParam1y() {
        String[] args = {"1", "y"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("y\n", out);
    }

    @Test
    public void withParam2y() {
        String[] args = {"2", "y"};
        String out = Application.settingChars(args);
        Assertions.assertEquals("yy\n", out);
    }
}
