package lesson_8.Home_work_8.test;

import lesson_8.Home_work_8.logic.Cleaner;
import lesson_8.Home_work_8.pojo.Person;
import lesson_8.Home_work_8.pojo.PrimitiveClass;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestClass {
    Cleaner cleaner = new Cleaner();
    List<String> list = new ArrayList<>();

    @Test
    public void whenAddObjectToCleanup_thenCleanFields() throws IllegalAccessException {
        list.clear();
        list.add("5555 6666 7777 8888");
        list.add("3333 6666 7374 8888");
        Set<String> fieldsToClean = new HashSet<>();
        Set<String> fieldsToOutput = new HashSet<>();
        fieldsToClean.add("id");
        fieldsToClean.add("name");
        fieldsToClean.add("address");
        Person person = new Person(1, "Ivan", "Lenina str", "+7 999 123 12 34", list);
        String test = "Object{id=0, name='null', address='null', cellPhone='+7 999 123 12 34', cardNumbers=[5555 6666 7777 8888, 3333 6666 7374 8888]}";
        cleaner.cleanUpAll(person, fieldsToClean, fieldsToOutput);
        assertThat(test, is(person.toString()));
    }

    @Test
    public void whenAddObjectToCleanup_thenGetFieldsToString() throws IllegalAccessException {
        Cleaner cleaner = new Cleaner();
        List<String> list = new ArrayList<>();
        list.add("5555 6666 7777 8888");
        list.add("3333 6666 7374 8888");
        Set<String> fieldsToClean = new HashSet<>();
        Set<String> fieldsToOutput = new HashSet<>();
        fieldsToOutput.add("cellPhone");
        fieldsToClean.add("id");
        fieldsToClean.add("name");
        fieldsToClean.add("address");
        Person person = new Person(1, "Ivan", "Lenina str", "+7 999 123 12 34", list);
        String testClean = "Object{id=0, name='null', address='null', cellPhone='+7 999 123 12 34', cardNumbers=[5555 6666 7777 8888, 3333 6666 7374 8888]}";
        String testOutput = "+7 999 123 12 34";
        String resultOutput = cleaner.cleanUpAll(person, fieldsToClean, fieldsToOutput);
        assertThat(testClean, is(person.toString()));
        assertThat(testOutput, is(resultOutput));
    }

    @Test
    public void whenAddPersonToCleanup_thenCleanPrimitiveAndWrappers() throws IllegalAccessException {
        PrimitiveClass primitiveClass = new PrimitiveClass((byte) 126, (short) 126, 126, 126L, 126f, 126.9d, true, true);
        Cleaner cleaner = new Cleaner();
        Set<String> fieldsToClean = new HashSet<>();
        Set<String> fieldsToOutput = new HashSet<>();
        fieldsToClean.add("aByte");
        fieldsToClean.add("aShort");
        fieldsToClean.add("integer");
        fieldsToClean.add("aLong");
        fieldsToClean.add("aFloat");
        fieldsToClean.add("aDouble");
        fieldsToClean.add("aBoolean");
        fieldsToClean.add("bool");
        cleaner.cleanUpAll(primitiveClass, fieldsToClean, fieldsToOutput);
        String test = "Person{aByte=null, aShort=null, integer=null, aLong=null, aFloat=null, aDouble=null, aBoolean=null, bool=false}";
        assertThat(test, is(primitiveClass.toString()));

    }

    @Test
    public void whenCallMethodMapCleaner_thenMapCleaned() throws IllegalAccessException {
        Cleaner cleaner = new Cleaner();
        Map<String, String> hashMap = new HashMap<>();
        Set<String> fieldToCleanUp = new HashSet<>();
        Set<String> fieldToOutput = new HashSet<>();
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
        fieldToCleanUp.add("1");
        cleaner.cleanUpAll(hashMap, fieldToCleanUp, fieldToOutput);
        assertThat("{2=2, 3=3}", is(hashMap.toString()));
    }
}
