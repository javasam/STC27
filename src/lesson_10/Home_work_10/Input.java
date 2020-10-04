package lesson_10.Home_work_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Class to build *.java file and compile them
 */
public class Input {
    private static Logger log = Logger.getLogger(Input.class.getName());

    /**
     * Input string from console
     *
     * @throws IOException
     */
    void input(String PATH_TO_JAVA_FILE) throws IOException {

        if (new File(PATH_TO_JAVA_FILE).exists()) {
            File file = new File(PATH_TO_JAVA_FILE);
            if (file.createNewFile()) {
                log.info("File " + file.getAbsolutePath() + " created");
            }
        }
        try (FileWriter fileWriter = new FileWriter(PATH_TO_JAVA_FILE);) {
            String firstString;
            Scanner input = new Scanner(System.in);
            log.info("Start Scanner");
            firstString = "public class ClassToLoad { public void doWork() {";
            System.out.println("Input string: \n");
            fileWriter.write(firstString);
            log.info("File " + PATH_TO_JAVA_FILE + " written");

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
            log.info("*.java file ready");
        }
    }
}
