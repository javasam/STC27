/**
 * Класс для приема входного параметра в виде строки, метод stringInput обрезает лишние пробелы.
 * args String
 */
public class Calc {
    Integer stringInput(String inputString) {
        return Integer.parseInt(inputString.trim().substring(2));
    }
}
