package lesson_7.Home_Work_7;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static lesson_7.Home_Work_7.Config.*;

public class Window implements Runnable {

    JFrame frame;
    Cell[][] cells;


    @Override
    public void run() {
        initFrame();
        initCell();
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

    void initCell() {
        cells = new Cell[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                CellAction cellAction = new CellAction();
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
        cells[2][2].cellAction.cellStatus = CellStatus.LIVE;
        cells[2][2].setColor();
        cells[2][4].cellAction.cellStatus = CellStatus.LIVE;
        cells[2][2].setColor();
        cells[3][3].cellAction.cellStatus = CellStatus.LIVE;
        cells[2][2].setColor();
        cells[3][4].cellAction.cellStatus = CellStatus.LIVE;
        cells[2][2].setColor();
        cells[4][3].cellAction.cellStatus = CellStatus.LIVE;
        cells[2][2].setColor();

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
