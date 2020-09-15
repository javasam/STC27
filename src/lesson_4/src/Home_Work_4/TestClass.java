package Home_Work_4;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void whenAddPersonThenGetTheSame() {
        Person person = new Person();
        Sex sex = new Sex();
        person.setSex(sex.woman);
        person.setAge(23);
        person.setName(Names.ABIGAIL);
        assertThat("Person{age=23, sex=WOMAN, name='ABIGAIL'}", is(person.toString()));
    }

    @Test
    public void whenSortingArrayThenGetSortedArray() {
        Person[] person = new Person[3];
        Person[] personSorted = new Person[3];
        Sex sex = new Sex();

        person[0] = new Person(23, sex.woman, Names.SOPHIA);
        person[1] = new Person(34, sex.woman, Names.ABIGAIL);
        person[2] = new Person(54, sex.man, Names.MICHAEL);

        personSorted[0] = new Person(54, sex.man, Names.MICHAEL);
        personSorted[1] = new Person(34, sex.woman, Names.ABIGAIL);
        personSorted[2] = new Person(23, sex.woman, Names.SOPHIA);

        Arrays.sort(person, new PersonCompareBySex().thenComparing(new PersonCompare()));

        assertThat(Arrays.toString(person), is(Arrays.toString(personSorted)));
    }

    @Test
    public void whenCallGenerateArrayMethodThenGetArray() {
        GenerateArray generateArray = new GenerateArray();
        Person[] person = generateArray.generatorArrayOfPersons(10);
        assertThat(10, is(person.length));
    }

}
