package lesson_7.Home_Work_7;

import java.util.ArrayList;

public class CellAction {
    ArrayList<CellAction> neighbors;
    CellStatus cellStatus;

    public CellAction() {
        cellStatus = CellStatus.NONE;
        neighbors = new ArrayList<>();
    }

    void addNeighbors(CellAction cellAction) {
        neighbors.add(cellAction);
    }

    void step1() {
        int around = countNearCells();
        cellStatus = cellStatus.stepOne(around);
    }

    void step2() {
        cellStatus = cellStatus.stepTwo();
    }

    int countNearCells() {
        int count = 0;
        for (CellAction neighbor : neighbors) {
            if (neighbor.cellStatus.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
