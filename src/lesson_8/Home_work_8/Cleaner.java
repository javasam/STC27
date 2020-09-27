package lesson_8.Home_work_8;

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

class Cleaner {

    void cleanUpAll(Object object, Set<String> fieldsToCleanUp, Set<String> fieldsToOutput) throws IllegalAccessException {
        mapCleaner(object, fieldsToCleanUp);
        cleanUp(object, fieldsToCleanUp);
        convertToString(object, fieldsToOutput);
    }

    void cleanUp(Object object, Set<String> fieldsToCleanUp) throws IllegalAccessException {
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

    String convertToString(Object object, Set<String> fieldsToOutput) throws IllegalAccessException {
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

    void mapCleaner(Object object, Set<String> strings) {
        if (object instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) object;
            for (String string : strings) {
                if (map.containsKey(Integer.parseInt(string))) {
                    map.remove(Integer.parseInt(string));
                } else throw new IllegalArgumentException();
            }
        }
    }
}