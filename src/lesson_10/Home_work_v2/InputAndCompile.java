package lesson_10.Home_work_v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputAndCompile {

    String PATH_TO_JAVA_FILE = "C:\\STC27\\src\\lesson_10\\Home_work_v2\\test\\ClassToLoad.java";
    String PATH_TO_CLASS_FILE = "C:\\STC27\\src\\lesson_10\\Home_work_v2\\test\\ClassToLoad.class";
    String PATH_TO_JAVAC = "C:\\Program Files\\Java\\jdk1.8.0_261\\bin\\javac.exe";

    public void input() throws IOException {

        if (new File(PATH_TO_JAVA_FILE).exists()) {
            File file = new File(PATH_TO_JAVA_FILE);
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(PATH_TO_JAVA_FILE);
        String classBuilder;
        Scanner input = new Scanner(System.in);
        classBuilder = "package lesson_10.Home_work_v2.test; public class ClassToLoad { ";
        System.out.println("Input string: \n");
        fileWriter.write(classBuilder);

        while (true) {
            String temp = input.nextLine();
            fileWriter.write(temp);
            fileWriter.write(" ");
            if (temp.equals("")) {
                break;
            }
        }
        input.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public void compile() throws IOException {
        Runtime.getRuntime().exec(PATH_TO_JAVAC + " " + PATH_TO_JAVA_FILE);
        File file = new File(PATH_TO_CLASS_FILE);
        if (file.exists()) {
            System.out.println("*.java file compiled to *.class " + "C:\\STC27\\src\\lesson_10\\Home_work_v2\\test\\");
        }
    }
}
