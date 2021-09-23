public class Application {

    public static void main(String[] args) {
        int count = 4;
        if (args.length > 0) {
            count = Integer.parseInt(args[0]);
        }
        for (int i = 0; i < count; i++) {
            System.out.print("x");
        }
        System.out.println();
    }
}
