package lesson_7.Home_Work_7;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Config {
    public static int SIZE;
    public static int WIDTH;
    public static int HEIGHT;
    public static int SLEEP_TIME;

    public static Color getColor(CellStatus cellStatus) {
        if (cellStatus == CellStatus.NONE) {
            return Color.BLACK;
        }
        return Color.GREEN;
    }

    static ArrayList<Integer> parser(URL url) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            for (String string : inputLine.split(" ")) {
                arrayList.add((Integer.parseInt(string)));
            }
        }
        in.close();
        return arrayList;
    }

    static void configWindowsInit(ArrayList<Integer> arrayList) {
        if (!arrayList.isEmpty()) {
            SIZE = (Integer) arrayList.toArray()[0];
            WIDTH = (Integer) arrayList.toArray()[1];
            HEIGHT = (Integer) arrayList.toArray()[2];
            SLEEP_TIME = (Integer) arrayList.toArray()[3];
        }
        System.out.println("Config loaded!!!");
    }
}
