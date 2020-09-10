public class Eratosfen {

    public static void main(String[] args) {
        Eratosfen eratosfen = new Eratosfen();
        eratosfen.calc(100);
    }

    private void calc(int inputN) {
        int[] allNumbers = new int[inputN];
        //заполняем массив
        for (int i = 0; i < inputN; i++) {
            allNumbers[i] = i;
        }
        //начиная со второго элемента, обнуляем все элементы которые кратны i * 2, c шагом j + i
        for (int i = 2; i < inputN; i++) {
            for (int j = i * 2; j < inputN; j = j + i) {
                allNumbers[j] = 0;
            }
            // вывод на экран
            for (i = 0; i < inputN; i++) {
                if (allNumbers[i] != 0) {
                    System.out.print(allNumbers[i] + " ");
                }
            }
        }
    }
}
