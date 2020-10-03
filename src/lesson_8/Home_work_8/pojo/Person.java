package lesson_8.Home_work_8.pojo;

import java.util.List;

/**
 * Simple class Person
 */

public class Person {
    protected int id;
    protected String name;
    protected String address;
    protected String cellPhone;
    protected List<String> cardNumbers;

    public Person(int id, String name, String address, String cellPhone, List<String> cardNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellPhone = cellPhone;
        this.cardNumbers = cardNumbers;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", cardNumbers=" + cardNumbers +
                '}';
    }
}
