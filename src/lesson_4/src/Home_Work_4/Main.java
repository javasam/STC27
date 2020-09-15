package Home_Work_4;

import java.util.Arrays;

/**
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 * <p>
 * Реализовать два различных метода сортировки этого массива по правилам:
 * <p>
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого
 * <p>
 * алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 */

public class Main {
    public static void main(String[] args) throws IdenticalAgeNameException {
        GenerateArray generateArray = new GenerateArray();
        ArrayShow arrayShow = new ArrayShow();

        Person[] person;
        person = generateArray.generatorArrayOfPersons(10000);

        long start = System.currentTimeMillis();
        Arrays.sort(person, new PersonCompareBySex().thenComparing(new PersonCompare()));
        long end = System.currentTimeMillis() - start;
        System.out.println("Сортированный массив: ");
        arrayShow.showArray(person);
        System.out.println("Затраченное время на сортировку: " + end / 1000 + " sec");
    }
}
