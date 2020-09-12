import java.util.*;

public class MapClass {
    HashMap<String, String> hashMap = new HashMap<>();

    HashMap<String, String> putToMap(int count) {
        for (int i = 0; i < count; i++) {
            hashMap.put("Key " + i, "Value " + i * 2);
        }
        hashMap.put("Key 10", "Value 18");
        return hashMap;
    }

    void showMap(HashMap<List, String> inputHashMap) {
        for (Map.Entry<List, String> entry : inputHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    HashMap<List, String> mapShift(HashMap<String, String> inputHashMap) {
        HashMap<List, String> resultHashMap = new HashMap<>();
        List linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : inputHashMap.entrySet()) {
            linkedList.add(entry.getValue());
            resultHashMap.put(linkedList, entry.getKey());
        }
        return resultHashMap;
    }
}
