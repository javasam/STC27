package lesson_12.Home_work_12;

import org.junit.Test;

/**
 * 1. Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться,
 * чтобы GC имел возможность очищать часть памяти. Через некоторое время программа должна
 * завершиться с ошибкой OutOfMemoryError c пометкой Java Heap Space.
 * <p>
 * 2. Сделать чтобы ошибка OutOfMemoryError была в Permanent Generation (или Metaspace)
 */

public class TestClass {

    @Test
    public void whenStartMethodOutOFMemoryHeap() {
        StringFiller stringFiller = new StringFiller();
        try {
            stringFiller.outOfMemoryHeapSpace(Integer.MAX_VALUE);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.out.println("Test pass!!!");
        }
    }

    @Test
    public void whenStartMethodOutOfMemoryMeta() {
        for (int i = 0; i < 5; i++) {
            new OutOfMemoryMeta().start();
            System.out.println("Memory leak started: " + i);
        }
    }


}
