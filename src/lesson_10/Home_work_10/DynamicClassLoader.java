package lesson_10.Home_work_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for load our class
 */
public class DynamicClassLoader extends ClassLoader {
    /**
     * Load class passed in parameters
     *
     * @param name - file_name for find
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            final byte[] bytes = Files.readAllBytes(Paths.get(name + ".class"));
            return defineClass(null, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException("Class not found");
    }
}
