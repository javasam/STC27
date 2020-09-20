package lesson_10.Home_work_v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassLoader extends ClassLoader {
    private Map classesHash = new HashMap();
    public final String[] classPath;

    public DynamicClassLoader(String[] classPath) {

        this.classPath = classPath;
    }

    protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        Class result = (Class) classesHash.get(name);
        if (result != null) {
            return result;
        }

        File f = findFile(name.replace('.', '/'), ".class");

        if (f == null) {
            return findSystemClass(name);
        }

        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(
                    "Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException(
                    "Format of class file incorrect for class "
                            + name + " : " + e);
        }
        classesHash.put(name, result);
        return result;
    }

    protected URL findResource(String name) {
        File f = findFile(name, "");
        if (f != null) {
            try {
                return new URL(f.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private File findFile(String name, String extension) {
        File f;
        for (int i = 0; i < classPath.length; i++) {
            f = new File((new File(classPath[i])).getPath()
                    + File.separatorChar
                    + name.replace('/',
                    File.separatorChar)
                    + extension);
            if (f.exists())
                return f;
        }
        return null;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
