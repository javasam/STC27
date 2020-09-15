package Home_Work_4;

import java.util.Comparator;

public class PersonCompareBySex implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}
