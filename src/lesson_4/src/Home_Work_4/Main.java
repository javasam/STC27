package Home_Work_4;

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
    public static void main(String[] args) {
        //GenerateArray generateArray = new GenerateArray();

        /**
         * Compare test, return 0 if equals
         */
        Person[] person = new Person[2];
        person[0] = new Person();
        person[0].setSex("MAN");
        person[0].setName(Names.ABIGAIL);
        person[0].setAge(27);
        person[1] = new Person();
        person[1].setSex("MAN");
        person[1].setName(Names.CLARA);
        person[1].setAge(22);
        System.out.println("person = " + person[0]);
        System.out.println("person = " + person[1]);
        System.out.println(person[0].compareTo(person[1]));
        System.out.println("!!!! " + person[1].getName().toString().compareTo(person[0].getName().toString()));

        /*for (Person array : generateArray.generatorArrayOfPersons(5)) {
            array.toString();
        }*/

        //person = generateArray.generatorArrayOfPersons(10);
        /*SortingOption1 sortingOption1 = new SortingOption1();
        sortingOption1.sort(person);*/

    }
}
