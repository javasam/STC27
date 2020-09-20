package lesson_10.Home_work_v2;

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
