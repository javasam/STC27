public class Helicopter {
    public static void main(String[] args) {
        Copter copter = new Quadcopter("First", 6);
        copter.fly();
    }

    interface Fly {
        void fly();
    }

    static abstract class Copter implements Fly {
        int screwCount;
    }

    private static class Quadcopter extends Copter {

        protected String copterName;

        public Quadcopter(String copterName, int screwCount) {
            this.copterName = copterName;
            this.screwCount = screwCount;
        }

        public void fly() {
            System.out.println("I can fly, " + "my name: " + copterName + ", screw count: " + screwCount);
        }
    }

}