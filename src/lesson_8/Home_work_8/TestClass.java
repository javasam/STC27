package lesson_8.Home_work_8;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestClass {
    @Test
    public void whenAddObjectToCleanup_thenCleanFields() throws IllegalAccessException {
        Cleaner cleaner = new Cleaner();
        List<String> list = new ArrayList<>();
        list.add("5555 6666 7777 8888");
        list.add("3333 6666 7374 8888");
        Set<String> fieldsToClean = new HashSet<>();
        fieldsToClean.add("id");
        fieldsToClean.add("name");
        fieldsToClean.add("address");
        Person person = new Person(1, "Ivan", "Lenina str", "+7 999 123 12 34", list);
        String test = "Object{id=0, name='null', address='null', cellPhone='+7 999 123 12 34', cardNumbers=[5555 6666 7777 8888, 3333 6666 7374 8888]}";
        cleaner.cleanUp(person, fieldsToClean);
        assertThat(test, is(person.toString()));
    }

    @Test
    public void whenAddPersonToCleanup_thenCleanPrimitiveAndWrappers() throws IllegalAccessException {
        PrimitiveClass primitiveClass = new PrimitiveClass((byte) 126, (short) 126, 126, 126L, 126f, 126.9d, true, true);
        Cleaner cleaner = new Cleaner();
        Set<String> fieldsToClean = new HashSet<>();
        fieldsToClean.add("aByte");
        fieldsToClean.add("aShort");
        fieldsToClean.add("integer");
        fieldsToClean.add("aLong");
        fieldsToClean.add("aFloat");
        fieldsToClean.add("aDouble");
        fieldsToClean.add("aBoolean");
        fieldsToClean.add("bool");
        cleaner.cleanUp(primitiveClass, fieldsToClean);
        String test = "Person{aByte=null, aShort=null, integer=null, aLong=null, aFloat=null, aDouble=null, aBoolean=null, bool=false}";
        assertThat(test, is(primitiveClass.toString()));

    }

    @Test
    public void whenCallMethodMapCleaner_thenMapCleaned() {
        Cleaner cleaner = new Cleaner();
        Map<Integer, String> hashMap = new HashMap<>();
        Set<String> fieldToCleanUp = new HashSet<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        fieldToCleanUp.add("1");
        cleaner.mapCleaner(hashMap, fieldToCleanUp);
        assertThat("{2=2, 3=3}", is(hashMap.toString()));
    }
}
