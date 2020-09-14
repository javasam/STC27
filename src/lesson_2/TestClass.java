package lesson_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestClass {

    @Test
    public void whenAddElementToSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(1, "Apple");
        assertThat("Apple", is(simpleHashMap.get(1)));
    }

    @Test
    public void whenAddNullToSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(null, "Apple");
    }

    @Test
    public void whenAddNull2ToSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(1, null);
    }

    @Test
    public void whenRemoveElementFromSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(1, "Apple");
        simpleHashMap.remove(1);
        assertThat(null, is(simpleHashMap.get(1)));
    }

    @Test
    public void whenGetSizeFromSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(1, "Apple");
        simpleHashMap.put(2, "Samsung");
        assertThat(2, is(simpleHashMap.size()));
    }


}
