package lesson_8.Home_work_8.pojo;

/**
 * Simple class for testing primitives
 */

public class PrimitiveClass extends Person {
    protected Byte aByte;
    protected Short aShort;
    protected Integer integer;
    protected Long aLong;
    protected Float aFloat;
    protected Double aDouble;
    protected Boolean aBoolean;
    protected boolean bool;

    public PrimitiveClass(Byte aByte, Short aShort, Integer integer, Long aLong, Float aFloat, Double aDouble, Boolean aBoolean, boolean bool) {
        this.aByte = aByte;
        this.aShort = aShort;
        this.integer = integer;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
        this.aBoolean = aBoolean;
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "Person{" +
                "aByte=" + aByte +
                ", aShort=" + aShort +
                ", integer=" + integer +
                ", aLong=" + aLong +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", aBoolean=" + aBoolean +
                ", bool=" + bool +
                '}';
    }
}
