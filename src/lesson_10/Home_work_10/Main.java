package lesson_10.Home_work_10;

/**
 * Необходимо написать программу, выполняющую следующее:
 * 1. Программа с консоли построчно считывает код метода doWork. Код не должен требовать
 * импорта дополнительных классов.
 * 2. После ввода пустой строки считывание прекращается и считанные строки добавляются
 * в тело метода public void doWork() в файле SomeClass.java.
 * 3. Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * 4. Полученный файл подгружается в программу с помощью кастомного загрузчика
 * 5. Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра
 * объекта подгруженного класса)
 */

//please input: ### public String toString() { return "Test class!!!!"; }} ### in cmd
public class Main {

    public static void main(String[] args) throws Exception {
        InputAndCompile inputAndCompile = new InputAndCompile();
        inputAndCompile.input();
        inputAndCompile.compile(null, System.out, System.err);
        DynamicClassLoader dynamicClassLoader = new DynamicClassLoader();
        Class clazz = dynamicClassLoader.findClass("ClassToLoad");
        Object obj = clazz.newInstance();
        System.out.println(obj.toString());
    }
}
