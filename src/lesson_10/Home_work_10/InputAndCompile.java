package lesson_10.Home_work_10;

import javax.tools.ToolProvider;
import java.io.*;
import java.util.Scanner;

/**
 * Class for build *.java file and compile them
 */
public class InputAndCompile {

    private static final String PATH_TO_JAVA_FILE = "./ClassToLoad.java";

    /**
     * Input string from console
     *
     * @throws IOException
     */
    void input() throws IOException {

        if (new File(PATH_TO_JAVA_FILE).exists()) {
            File file = new File(PATH_TO_JAVA_FILE);
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(PATH_TO_JAVA_FILE);
        String firstString;
        Scanner input = new Scanner(System.in);
        firstString = "public class ClassToLoad { public void doWork() {";
        System.out.println("Input string: \n");
        fileWriter.write(firstString);

        while (true) {
            String temp = input.nextLine();
            fileWriter.write(temp);
            fileWriter.write(" ");
            if (temp.equals("")) {
                break;
            }
        }
        input.close();
        String lastString = "}}";
        fileWriter.write(lastString);
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * Compile *.java file to *.class
     *
     * @param in
     * @param out
     * @param err
     * @throws InterruptedException
     */
    void compile(InputStream in, OutputStream out, OutputStream err) throws InterruptedException {
        ToolProvider.getSystemJavaCompiler().run(in, out, err, PATH_TO_JAVA_FILE);
        System.out.println("File: " + PATH_TO_JAVA_FILE + " Compiled!");
        Thread.sleep(2000);
    }
}
