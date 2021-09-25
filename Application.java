public class Application {

    private static void runTests() {
        test1();
        test2();
        test3();
    }

    public static void main(String[] args) {
        runTests();
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
        out += "\n";
        return out;
    }

    public static void test1() {
        String args[] = {"0"};
        String out = Application.run(args);
        assert "\n".equals(out);
    }

    public static void test2() {
        String args[] = {"1"};
        String out = Application.run(args);
        assert "x\n".equals(out);
    }

    public static void test3() {
        String args[] = {"2"};
        String out = Application.run(args);
        assert "xx\n".equals(out);
    }
}
