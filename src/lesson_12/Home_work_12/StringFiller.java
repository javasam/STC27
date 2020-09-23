package lesson_12.Home_work_12;

import java.util.ArrayList;
import java.util.Scanner;

public class StringFiller {
    ArrayList<Integer> stringList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    class Object {
        Integer integer;
        ArrayList arrayList;

        public Object(Integer integer, ArrayList arrayList) {
            this.integer = integer;
            this.arrayList = arrayList;
        }
    }

    void outOfMemory(long count) {
        if (count == 0) {
            System.out.println("Input count: ");
            count = Long.parseLong(input.nextLine());
        }
        int innerCount = 0;
        for (int i = 0; i < count; i++) {
            stringList.add(i);
            Object object = new Object(i, stringList);
            if (i % 1_000_000 == 0) {
                System.out.println(i);
            }
            if (i != 0 && i % 999_999 == 0) {
                innerCount++;
                stringList.remove(i - innerCount);
            }
        }
        System.out.println("You didn't reach OutOFMemory Error, please restart program, and input \"count\" more than " + count);
    }
}
