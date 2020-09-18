package lesson_7.Home_Work_7;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static lesson_7.Home_Work_7.Config.*;

public class Window implements Runnable {

    URL URL_WINDOW;

    {
        URL_WINDOW = new URL("https://raw.githubusercontent.com/javasam/STC27/master/src/lesson_7/Home_Work_7/config.txt");
    }

    URL URL_SHAPE;

    {
        URL_SHAPE = new URL("https://raw.githubusercontent.com/javasam/STC27/master/src/lesson_7/Home_Work_7/shape.txt");
    }

    JFrame frame;
    Cell[][] cells;

    public Window() throws MalformedURLException {
    }


    @Override
    public void run() {
        try {
            Config.configWindowsInit(
                    Config.parser(URL_WINDOW));
        } catch (IOException e) {
            e.printStackTrace();
        }
        initFrame();
        try {
            initCell();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initTimer();
    }

    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(WIDTH * SIZE, HEIGHT * SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("!!!THE LIFE!!!");
    }

    void initCell() throws IOException {
        ArrayList<Integer> arrayList = parser(URL_SHAPE);
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

        /**
         * Start shape Glider
         */
        int qx;
        int qy;
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i = i + 2) {
                qx = (Integer) arrayList.toArray()[i];
                qy = (Integer) arrayList.toArray()[i + 1];
                cells[qx][qy].cellAction.cellStatus = CellStatus.LIVE;
                cells[qx][qy].setColor();
            }
        }
        System.out.println("Shape Loaded!!!");
    }

    private void initTimer() {
        TimerListener timerListener = new TimerListener();
        Timer timer = new Timer(SLEEP_TIME, timerListener);
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
                        cells[x][y].step1();
                    } else {
                        cells[x][y].step2();

                    }
                }
            }
        }
    }
}
