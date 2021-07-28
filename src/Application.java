import java.util.Scanner;

public class Application {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Choose a char: ");

        String s = sc.nextLine();
        char ch = s.charAt(0);

        for (char c = 'a'; c <= 'z'; c++) {
            if (ch == c) {
                for (int i = 0; i < 4; i++) {
                    System.out.print(c);
                }
            }
        }
    }
}
