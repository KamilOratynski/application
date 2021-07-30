import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTests {

    private String setInputOutput(ByteArrayInputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        Application application = new Application(inputStream, ps);
        application.chooseAndPrintResult();
        String outputText = byteArrayOutputStream.toString();
        String key = "Choose a char: ";
        return outputText.substring(outputText.indexOf(key) + key.length()).trim();
    }

    @Test
    public void correctInputTest() {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("x".getBytes());
        //when
        String output = setInputOutput(inputStream);
        //then
        assertEquals(output, "xxxx");
    }

    @Test
    public void correctInputWithTwoCharTest() {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("xx".getBytes());
        //when
        String output = setInputOutput(inputStream);
        //then
        assertEquals(output, "xxxx");
    }

    @Test
    public void tooLongIncorrectOutputTest() {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("x".getBytes());
        //when
        String output = setInputOutput(inputStream);
        //then
        assertNotEquals(output, "xxxxx");
    }

    @Test
    public void tooSmallIncorrectOutputTest() {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("x".getBytes());
        //when
        String output = setInputOutput(inputStream);
        //then
        assertNotEquals(output, "xxx");
    }

    @Test
    public void incorrectInputWithNumberTest() {
        //given
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        //when
        String output = setInputOutput(inputStream);
        //then
        assertNotEquals(output, "xxxx");
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            ByteArrayInputStream inputStream = new ByteArrayInputStream("\n".getBytes());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            Application application = new Application(inputStream, ps);
            application.chooseAndPrintResult();
        });

        String expectedMessage = "String index out of range: 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
