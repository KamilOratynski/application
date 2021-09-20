public class Application {

    public static void main(String[] args) {
        if (args.length != 0) {
            int j = Integer.parseInt(args[0]);
            for (int i = 0; i < j; i++) {
                System.out.print("x");
            }
        } else {
            System.out.print("xxxx");
        }
        System.out.println();
    }
}
