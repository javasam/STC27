package lesson_8.Home_work_8.logic;

import java.util.Set;

public interface CleanFields {
    String cleanUpAll(Object object, Set<String> fieldsToCleanUp, Set<String> fieldsToOutput) throws IllegalAccessException;
}
