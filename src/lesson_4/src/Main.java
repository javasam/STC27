/**
 * Задача:
 * Составить программу генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
 * Пример входных данных: "    N=42"
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Если остаток больше целой части, то сохранить такое число в массив.
 * Результирующий массив отсортировать по убыванию и вывести на экран.
 * Предусмотреть, что первоначальные числа могут быть отрицательными, в этом случае генерировать исключение.
 */

public class Main {
    public static void main(String[] args) throws NegativeNumberException {
        Calc calc = new Calc();
        Generator generator = new Generator();
        Sqrt sqrt = new Sqrt();
        try {
            System.out.println(sqrt.sorting(sqrt.calculation
                    (generator.array(calc.stringInput("       N=100")), 9)));
        } catch (NegativeNumberException e) {
            System.out.println("1111");
        }


    }
}
