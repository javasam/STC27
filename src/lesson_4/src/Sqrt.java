import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Sqrt {
    int[] calculation(double[] array, int kNumber) {
        int[] result = new int[array.length];
        int j = 0;
        System.out.println();
        for (int i = kNumber - 1; i < array.length - 1; i = i + kNumber) {
            if (array[i] > 0) {
                double sqrt = sqrt(array[i]); //вычисляем квадратный корень
                int ddd = (int) sqrt;         // целая часть результата
                System.out.println("целая часть числа: " + ddd);
                int sss = (int) ((sqrt - ddd) * 100);  // дробная часть результата
                System.out.println("дробная часть числа: " + sss);
                if (kNumber == Math.pow(ddd, 2)) {
                    System.out.println(kNumber);
                }
                if (sss > ddd) {
                    result[j++] = sss;
                }
            }
        }
        return result;
    }

    String sorting(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return Arrays.toString(array);
    }
}
