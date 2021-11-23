import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9797)) {
            System.out.println("Server started.");

            while (true) {
                try (Socket client = serverSocket.accept()) {
                    System.out.println("Client answered.");

                    OutputStream clientOutput = client.getOutputStream();

                    if (args.length == 0) {
                        clientOutput.write(("Usage: app <times> [char]\n\n" +
                                "<times> parameter defines length and width of chars displayed.\n" +
                                "Chars replace position starts at 1 and ends with <times> squared.\n" +
                                "Commands:\n" +
                                "   1a - means position 1 and char 'a' to replace\n" +
                                "    q - quit").getBytes());
                    }

                    int count = Integer.parseInt(args[0]);
                    String character = "x";
                    if (args.length > 1) {
                        character = args[1];
                    }
                    String out = "";
                    int length = 0;
                    for (int i = 0; i < count; i++) {
                        out += character.repeat(count) + "\n";
                        if (i == 0) {
                            length = out.length();
                        }
                    }
                    clientOutput.write(out.getBytes());

                    Scanner scanner = new Scanner(System.in);
                    for (; ; ) {
                        String token = scanner.next();
                        if (token.equals("q")) {
                            return;
                        }
                        out = apply(out, token, length);
                        clientOutput.write(out.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String apply(String s, String token, int length) {
        int index = Integer.parseInt(token.replaceAll("[^\\d]", ""));
        String c = token.replaceAll("[^A-Za-z]", "");
        for (int i = 1; i < length; i++) {
            if (index >= length * i) {
                index += 1;
            }
        }
        return s.substring(0, index - 1) + c + s.substring(index);
    }

    @Test
    public void applyToken() {
        Assertions.assertEquals("a", Application.apply("y", "1a", 0));
        Assertions.assertEquals("ya", Application.apply("yy", "2a", 0));
        Assertions.assertEquals("ay", Application.apply("yy", "1a", 0));
        Assertions.assertEquals("yyyyyyyyya", Application.apply("yyyyyyyyyy", "10a", 0));
        Assertions.assertEquals("asdyyyyyya", Application.apply("asdyyyyyyy", "10a", 0));
    }
}
