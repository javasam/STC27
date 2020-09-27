package lesson_7.Home_Work_7;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Класс для определения параметров окна
 */

public class Config {
    static int SIZE;
    static int WIDTH;
    static int HEIGHT;
    static int SHAPE_SPEED;

    public static Color getColor(CellStatus cellStatus) {
        if (cellStatus == CellStatus.NONE) {
            return Color.BLACK;
        }
        return Color.GREEN;
    }

    /**
     * Метод для получения параметров по URL
     *
     * @param url - файл с параметрами
     * @return массив с параметрами
     * @throws IOException
     */

    static ArrayList<Integer> parser(URL url) throws IOException {
        ArrayList<Integer> paramsList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                for (String param : inputLine.split(" ")) {
                    paramsList.add(Integer.parseInt(param));
                }
            }
        }
        return paramsList;
    }

    /**
     * Сеттер параметров
     *
     * @param arrayList массив с параметрами
     */

    static void configWindowsInit(ArrayList<Integer> arrayList) {
        if (!arrayList.isEmpty()) {
            SIZE = arrayList.get(0);
            WIDTH = arrayList.get(1);
            HEIGHT = arrayList.get(2);
            SHAPE_SPEED = arrayList.get(3);
        }
        System.out.println("Config loaded!!!");
    }
}
