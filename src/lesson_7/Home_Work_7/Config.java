package lesson_7.Home_Work_7;

import java.awt.*;

public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 30;
    public static final int SLEEP_TIME = 100;

    public static Color getColor(CellStatus cellStatus) {
        switch (cellStatus) {

            case NONE:
                return Color.BLACK;
            case BORN:
                return Color.PINK;
            case LIVE:
                return Color.GREEN;
            case DIED:
                return Color.GRAY;
            default:
                return Color.RED;
        }
    }

}
