package lesson_7.Home_Work_7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static lesson_7.Home_Work_7.Config.*;

public class InitCell {

    Cell[][] cells;
    JFrame frame;

    /**
     * Инициализирует cell на рабочем поле. Загружает параметры начальной фигуры из файла.
     * Структура файла 2 2 2 4 3 3 3 4 4 3, т.е. координаты x y cell, в данном случа это "глайдер"
     *
     * @throws IOException
     */

    void initCell() throws IOException {
        String URL_SHAPE = "https://raw.githubusercontent.com/javasam/STC27/master/src/lesson_7/Home_Work_7/shape.txt";
        ArrayList<Integer> arrayList = parser(new URL(URL_SHAPE));
        cells = new Cell[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                cells[x][y] = new Cell(x, y);
                frame.add(cells[x][y]);
            }
        }
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int sx = -1; sx <= +1; sx++) {
                    for (int sy = -1; sy <= +1; sy++) {
                        if (!(sx == 0 && sy == 0)) {
                            cells[x][y].cellAction.addNeighbors(cells
                                    [(x + sx + WIDTH) % WIDTH]
                                    [(y + sy + HEIGHT) % HEIGHT].cellAction);
                        }
                    }
                }
            }
        }
        startShape(arrayList);
        System.out.println("Shape Loaded!!!");
    }

    /**
     * Start shape Glider
     */
    private void startShape(ArrayList<Integer> arrayList) {
        int qy;
        int qx;
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i = i + 2) {
                qx = (Integer) arrayList.toArray()[i];
                qy = (Integer) arrayList.toArray()[i + 1];
                cells[qx][qy].cellAction.cellStatus = CellStatus.LIVE;
                cells[qx][qy].setColor();
            }
        }
    }

    void initTimer() {
        TimerListener timerListener = new TimerListener();
        Timer timer = new Timer(SHAPE_SPEED, timerListener);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flag = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flag = !flag;
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    if (flag) {
                        cells[x][y].setColorForLive();
                    } else {
                        cells[x][y].setColorForOthers();

                    }
                }
            }
        }
    }
}