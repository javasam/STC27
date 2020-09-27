package lesson_7.Home_Work_7;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

import static lesson_7.Home_Work_7.Config.*;

/**
 * Класс для создания основного окна игры
 * URL_WINDOW ссылка на фаил конфигурации размеров основного окна вида "20 40 30 100", параметры расположены по порядку,
 * SIZE, WIDTH, HEIGHT, SHAPE_SPEED, разделитель пробел.
 */

public class Window implements Runnable {

    InitCell initCell = new InitCell();

    @Override
    public void run() {
        String URL_WINDOW = "https://raw.githubusercontent.com/javasam/STC27/master/src/lesson_7/Home_Work_7/config.txt";
        try {
            Config.configWindowsInit(Config.parser(new URL(URL_WINDOW)));
            initFrame();
            initCell.initCell();
            initCell.initTimer();
        } catch (IOException e) {
            System.out.println("File not found: " + URL_WINDOW);
        }
    }

    /**
     * Инизиализация фрейма
     */

    void initFrame() {
        initCell.frame = new JFrame();
        initCell.frame.getContentPane().setLayout(null);
        initCell.frame.setSize(WIDTH * SIZE, HEIGHT * SIZE);
        initCell.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initCell.frame.setLocationRelativeTo(null);
        initCell.frame.setVisible(true);
        initCell.frame.setTitle("!!!THE LIFE!!!");
    }
}
