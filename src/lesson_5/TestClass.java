package lesson_5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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

public class TestClass {

    @Test
    public void whenAddElementToSimpleHashMap() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put(1, "Apple");
        assertThat("Apple", is(simpleHashMap.get(1)));
    }

    @Test
    public void whenAddNullToSimpleHashMap() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put(null, "Apple");
        assertThat("Apple", is(simpleHashMap.get(null)));
    }

    @Test
    public void whenAddNull2ToSimpleHashMap() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put(1, null);
        assertNotNull(simpleHashMap);
    }

    @Test
    public void whenRemoveElementFromSimpleHashMap() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put(1, "Apple");
        simpleHashMap.remove(1);
        assertThat(null, is(simpleHashMap.get(1)));
    }

    @Test
    public void whenGetSizeFromSimpleHashMap() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put(1, "Apple");
        simpleHashMap.put(2, "Samsung");
        assertThat(2, is(simpleHashMap.size()));
    }


}
