import java.util.Scanner;

public class Application {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Choose a letter: ");

        String s = sc.nextLine();
        char ch = s.charAt(0);

        boolean isLetter = Character.isLetter(ch);
        char[] b = s.toCharArray();

        if (isLetter && b.length == 1) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (ch == c) {
                    for (int i = 0; i < 4; i++) {
                        System.out.print(c);
                    }
                }
            }
        } else {
            System.out.println("Selected character isn't a letter or is more than one. Choose only one letter!");
        }
    }
}
