package lesson_10.Home_work_10;

import javax.tools.ToolProvider;
import java.io.InputStream;
import java.io.OutputStream;

public class Compile {

    /**
     * Compile *.java file to *.class
     *
     * @param in
     * @param out
     * @param err
     * @param PATH_TO_JAVA_FILE path to *.java file
     * @throws InterruptedException
     */

    void compile(InputStream in, OutputStream out, OutputStream err, String PATH_TO_JAVA_FILE) throws InterruptedException {
        ToolProvider.getSystemJavaCompiler().run(in, out, err, PATH_TO_JAVA_FILE);
        System.out.println("File: " + PATH_TO_JAVA_FILE + " Compiled!");
    }
}
