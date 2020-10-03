package lesson_8.Home_work_8.logic;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * Необходимо реализовать метод void cleanup(Object object, Set<String> fieldsToCleanup,
 * Set<String> fieldsToOutput), принимающий любой объект и две коллекции строк. В объекте,
 * посредством reflection надо поля, перечисленные в fieldsToCleanup установить в значение null,
 * или, если поля примитивных типов в их значение по умолчанию. Поля, перечисленные в fieldsToOutput
 * сконвертировать в строку (вызвав toString у объектов, или String.valueOf для примитивных типов) и
 * вывести результат преобразования в консоль. Если переданный первым параметром объект является
 * реализацией интерфейса Map, то проделать аналогичные операции - для списка fieldsToCleanup
 * удалить ключи из мапы, для fieldsToOutput вывести в консоль значения, хранящиеся в мапе.
 * При отсутствии в объекте/мапе нужных полей/ключей - падать с IllegalArgumentException,
 * оставив объект неизменным.
 */

public class Cleaner implements CleanFields {

    /**
     * General method, which join two methods
     *
     * @param object          input Object
     * @param fieldsToCleanUp fields to clean
     * @param fieldsToOutput  fields to print
     * @throws IllegalAccessException
     */
    public String cleanUpAll(Object object, Set<String> fieldsToCleanUp, Set<String> fieldsToOutput) throws IllegalAccessException {
        mapCleaner(object, fieldsToCleanUp);
        cleanUp(object, fieldsToCleanUp);
        return convertToString(object, fieldsToOutput);
    }

    /**
     * Method to clean fields in Object
     *
     * @param object          Object to clean
     * @param fieldsToCleanUp Fields to clean
     * @throws IllegalAccessException
     */
    protected void cleanUp(Object object, Set<String> fieldsToCleanUp) throws IllegalAccessException {
        Field[] objectFields = object.getClass().getDeclaredFields();
        for (Field objectField : objectFields) {
            for (String fieldToClean : fieldsToCleanUp) {
                if (objectField.getName().equals(fieldToClean)) {
                    String temp = objectField.getType().toString();
                    if (temp.contains("int") || temp.contains("byte")
                            || temp.contains("long") || temp.contains("float")
                            || temp.contains("double") || temp.contains("short")) {
                        objectField.setInt(object, 0);
                    } else if (temp.contains("boolean")) {
                        objectField.setBoolean(object, false);
                    } else {
                        objectField.set(object, null);
                    }
                }
            }
        }
    }

    /**
     * Method to print fields from Object
     *
     * @param object         input Object
     * @param fieldsToOutput list fields to print
     * @return
     * @throws IllegalAccessException
     */
    protected String convertToString(Object object, Set<String> fieldsToOutput) throws IllegalAccessException {
        Field[] objectFields = object.getClass().getDeclaredFields();
        for (Field objectField : objectFields) {
            for (String fieldToOutput : fieldsToOutput) {
                if (objectField.getName().equals(fieldToOutput)) {
                    return objectField.get(object).toString();
                }
            }
        }
        return "No strings found!";
    }

    /**
     * Special method to clean Map in Object
     *
     * @param object  input Object
     * @param strings Set strings to clean
     */

    protected void mapCleaner(Object object, Set<String> strings) {
        if (object instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) object;
            for (String string : strings) {
                if (map.containsKey(string)) {
                    map.remove(string);
                } else throw new IllegalArgumentException();
            }
        }
    }
}