import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTests {

    @Test
    public void correctPrint() {
        //given
        Application app = new Application();
        //when
        String print = app.print();
        //then
        Assertions.assertEquals("xxxx", print);
    }

    @Test
    public void incorrectTooLongPrint() {
        //given
        Application app = new Application();
        //when
        String print = app.print();
        //then
        Assertions.assertNotEquals("xxxxx", print);
    }

    @Test
    public void incorrectTooSmallPrint() {
        //given
        Application app = new Application();
        //when
        String print = app.print();
        //then
        Assertions.assertNotEquals("xxx", print);
    }

}
