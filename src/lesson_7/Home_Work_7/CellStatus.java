package lesson_7.Home_Work_7;

public enum CellStatus {
    NONE,
    BORN,
    LIVE,
    DIED;

    /**
     * Шаг первый определяем статус клетки(cell) в зависимости от количества соседей
     *
     * @param around количетво соседей рядом
     * @return
     */

    public CellStatus stepOne(int around) {
        switch (this) {
            case NONE:
                return (around == 3) ? BORN : NONE;
            case LIVE:
                return (around <= 1 || around >= 4) ? DIED : LIVE;
            default:
                return this;
        }
    }

    /**
     * Шаг второй устанавливаем статус клетки(cell)
     *
     * @return статус
     */
    public CellStatus stepTwo() {
        switch (this) {
            case BORN:
                return LIVE;
            case DIED:
                return NONE;
            default:
                return this;
        }
    }

    public boolean isAlive() {
        return this == LIVE || this == DIED;
    }
}
