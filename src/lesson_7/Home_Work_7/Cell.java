package lesson_7.Home_Work_7;

import javax.swing.*;

import static lesson_7.Home_Work_7.Config.SIZE;

/**
 * Класс описывает ячейку
 */

public class Cell extends JPanel {

    CellAction cellAction;

    public Cell(int x, int y) {
        super();
        cellAction = new CellAction();
        setBounds(x * SIZE, y * SIZE, SIZE, SIZE);
        setBackground(Config.getColor(CellStatus.NONE));
    }

    /**
     * Устанавливает цвет ячейки
     */
    void setColor() {
        setBackground(Config.getColor(cellAction.cellStatus));
    }

    void setColorForLive() {
        cellAction.callStep1Method();
        setColor();
    }

    void setColorForOthers() {
        cellAction.callStep2Method();
        setColor();
    }
}
