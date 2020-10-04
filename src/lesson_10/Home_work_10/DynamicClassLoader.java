package lesson_10.Home_work_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Class for load our class
 */
public class DynamicClassLoader extends ClassLoader {
    private static Logger log = Logger.getLogger(DynamicClassLoader.class.getName());
    /**
     * Load class passed in parameters
     *
     * @param name - file_name to find class
     * @return Class
     * @throws ClassNotFoundException CNF
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            log.info("Starting read *.class file");
            final byte[] bytes = Files.readAllBytes(Paths.get(name + ".class"));
            log.info("*.class file read");
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            log.warning("Error class not found" + e);
        }
        throw new ClassNotFoundException("Class not found");
    }
}
