package lesson_10.Home_work_v2;

/**
 * Необходимо написать программу, выполняющую следующее:
 * 1. Программа с консоли построчно считывает код метода doWork. Код не должен требовать импорта дополнительных классов.
 * 2. После ввода пустой строки считывание прекращается и считанные строки добавляются
 * в тело метода public void doWork() в файле SomeClass.java.
 * 3. Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * 4. Полученный файл подгружается в программу с помощью кастомного загрузчика
 * 5. Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 */


public class Main {

    public static void main(String[] args) throws Exception {
        ClassLoader loader;
        InputAndCompile inputAndCompile = new InputAndCompile();
        inputAndCompile.input();
        inputAndCompile.compile();
        loader = new DynamicClassLoader(new String[]{"."});
        Class clazz = Class.forName("lesson_10.Home_work_v2.test.ClassToLoad", true, loader);
        Object object = clazz.newInstance();
        System.out.println(object.toString());
    }
}
