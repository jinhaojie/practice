import java.util.HashMap;
import java.util.Map;

public class SimpleTest {

    public static void main(String[] args) {
        String a = "a";
        StringBuilder sb = new StringBuilder("b");

        System.out.println(a.contentEquals(sb));


        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "a");
        testMap.put(1, "b");
        testMap.put(3, "c");
        testMap.put(4, "c");
        testMap.put(5, "c");
        testMap.put(6, "c");
        testMap.put(7, "c");
        testMap.put(8, "c");
        testMap.put(9, "c");
    }
}
