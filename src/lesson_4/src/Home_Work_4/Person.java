package Home_Work_4;

import java.util.Arrays;

public class Person {
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
}

