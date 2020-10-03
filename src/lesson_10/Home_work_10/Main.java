package lesson_10.Home_work_10;

import java.lang.reflect.Method;

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

//please input: ### System.out.println("Test!!!"); ### or ### for (int i = 0; i < 10; i++) System.out.println(i); ###
public class Main {

    public static void main(String[] args) throws Exception {
        Compile compile = new Compile();
        String pathToJava = "./ClassToLoad.java";
        Input inputAndCompile = new Input();
        inputAndCompile.input(pathToJava);
        compile.compile(null, System.out, System.err, pathToJava);
        DynamicClassLoader dynamicClassLoader = new DynamicClassLoader();
        Class<?> clazz = dynamicClassLoader.findClass("ClassToLoad");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethods()[0];
        method.invoke(obj);
    }
}
