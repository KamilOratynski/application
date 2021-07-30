import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {

    private Scanner scanner;
    private PrintStream printStream;

    public Application(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public static void main(String[] args) {
        Application application = new Application(System.in, System.out);
        application.chooseAndPrintResult();
    }

    public void chooseAndPrintResult() {
        printStream.print("Choose a char: ");
        String s = scanner.nextLine();
        char ch = s.charAt(0);
        for (char c = 'a'; c <= 'z'; c++) {
            if (ch == c) {
                for (int i = 0; i < 4; i++) {
                    printStream.print(c);
                }
            }
        }
    }
}