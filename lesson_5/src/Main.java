public class Main {
    public static void main(String[] args) {
        MapClass mapClass = new MapClass();
        mapClass.putToMap(10);
        mapClass.showMap(mapClass.mapShift(mapClass.putToMap(10)));
    }
}
