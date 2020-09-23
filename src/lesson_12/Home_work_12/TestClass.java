package lesson_12.Home_work_12;

import org.junit.Test;

public class TestClass {

    @Test
    public void whenStartMethodFiller() {
        StringFiller stringFiller = new StringFiller();
        try {
            stringFiller.outOfMemory(Long.MAX_VALUE);
        } catch (OutOfMemoryError e) {
            System.out.println("Test pass!!!");
        }
    }
}
