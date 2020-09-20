package lesson_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        ;
        simpleHashMap.put(1, "Apple");
        simpleHashMap.put(2, "Samsung");
        assertThat(2, is(simpleHashMap.size()));
    }


}
