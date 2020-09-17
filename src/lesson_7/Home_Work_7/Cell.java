package lesson_7.Home_Work_7;

import javax.swing.*;

import static lesson_7.Home_Work_7.Config.*;

public class Cell extends JPanel {

    CellAction cellAction;

    public Cell(int x, int y) {
        super();
        cellAction = new CellAction();
        setBounds(x * SIZE, y * SIZE, SIZE, SIZE);
        setBackground(Config.getColor(CellStatus.NONE));
    }

    public void initCells(int x, int y) {

    }

    public void setColor() {
        setBackground(Config.getColor(cellAction.cellStatus));
    }

    public void step1() {
        cellAction.step1();
        setColor();
    }

    public void step2() {
        cellAction.step2();
        setColor();
    }
}
