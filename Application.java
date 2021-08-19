import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Choose number of characters:");
        Scanner scanner = new Scanner(System.in);
        int j = scanner.nextInt();
        for (int i = 0; i < j; i++) {
            System.out.print("x");
        }
    }

}
