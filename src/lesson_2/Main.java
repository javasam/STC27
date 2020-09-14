package lesson_2;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Спроектировать и реализовать класс, реализующий коллекцию типа "хеш-таблица" (hash-map),
 * или двунаправленная хеш-таблица (bi-map), без использования стандартных или библиотечных
 * реализаций коллекций (можно использовать массивы). В качестве ключей и значений могут
 * использоваться любые объекты. В коллекции должны быть методы добавления, обновления,
 * получения, удаления элемента, проверка наличия элемента по ключу (и по значению в случае
 * двунаправленной таблицы), получение количества элементов в коллекции. В случае совершения
 * недопустимых операций выбрасывать исключения. Протестировать работоспособность с помощью
 * юнит-тестов, включая положительные (при корректных операциях с коллекцией она ведет себя
 * корректно), и негативные тесты (исключения при некоректных операциях).
 */

public class Main {
    public static void main(String[] args) {
        /**
         * Create and fill SimpleHashMap.
         */
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(1, "Apple");
        simpleHashMap.put(2, "Banana");
        simpleHashMap.put(3, "Cherry");

        /**
         * Display SimpleHashMap methods: size, get, toString, remove.
         */
        System.out.println("HashMap size: " + simpleHashMap.size());
        System.out.println("HashMap get element by key " + simpleHashMap.get(2));
        System.out.println(simpleHashMap.toString());
        simpleHashMap.remove(1);
        System.out.println("Removed element: " + simpleHashMap.get(1));
        /**
         * Display iterator opportunities
         */
        Iterator<SimpleEntry> itr = simpleHashMap.iterator();
        while (itr.hasNext()) {
            SimpleEntry simpleEntry = itr.next();
            System.out.println("Key: " + simpleEntry.getKey() + " Value: " + simpleEntry.getValue());
        }
    }
}
