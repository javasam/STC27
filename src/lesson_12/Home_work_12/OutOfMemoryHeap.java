package lesson_12.Home_work_12;

/**
 * 1. Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться,
 * чтобы GC имел возможность очищать часть памяти. Через некоторое время программа должна
 * завершиться с ошибкой OutOfMemoryError c пометкой Java Heap Space.
 * <p>
 * 2. Сделать чтобы ошибка OutOfMemoryError была в Permanent Generation (или Metaspace)
 */

public class OutOfMemoryHeap {
    public static void main(String[] args) {
        int[] arrays = new int[1000000000];
    }

}
