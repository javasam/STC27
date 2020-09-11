import java.util.Random;

public class Generator {
    int randomGenerator(int min, int max) {
        Random random = new Random();
        Random random2 = new Random();
        return random.nextInt(min) - random2.nextInt(max);
    }

    double[] array(int number) throws NegativeNumberException {
        double[] array = new double[number];
        for (int i = 0; i < number; i++) {
            array[i] = randomGenerator(400, 1);
            System.out.print(array[i] + " ");
            if (array[i] < 0) {
                throw new NegativeNumberException("Сгенерировано отрицательное число");
            }
        }
        return array;
    }

}

