package Home_Work_4;

import java.util.Arrays;

public class Person implements Comparable<Person> {
    private int age;
    private String sex;
    private Names name;

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Names getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(Names name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int age, String sex, Names name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * первые идут мужчины
     * выше в списке тот, кто более старший
     * имена сортируются по алфавиту
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        if (o.getSex().equals("MAN") & o.getAge() > age) {
            return 0;
        }
        if (o.getSex().equals("MAN") & o.getAge() == age & o.getName().toString().compareTo(name.toString()) < 0) {
            return 0;
        }
        if (o.getSex().equals("WOMAN") & o.getAge() > age) {
            return 0;
        } else {
            return -1;
        }
    }
}
