package Home_Work_4;

import java.util.Random;

public class GenerateArray {
    Person[] generatorArrayOfPersons(int count) {
        Person[] person = new Person[count];
        Sex sex = new Sex();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            person[i] = new Person();
            person[i].setAge(random.nextInt(100));
            person[i].setName(Names.values()[random.nextInt(21)]);
            if (i % (random.nextInt(4) + 1) == 0) {
                person[i].setSex(sex.man);
            } else {
                person[i].setSex(sex.woman);
            }
            System.out.println(person[i]);
        }
        return person;
    }
}
