import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubarrayWithSumEqualTo0 {
    public static void main(String[] args) {
        System.out.println("In here we will learn about the count of sub-arrays with sum 0");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        findAllSubarray(arrayList);
    }

    private static void findAllSubarray(ArrayList<Integer> arrayList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int prefix = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            prefix += arrayList.get(i);
            if (map.containsKey(prefix)) {
                ans = ans + map.get(prefix);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        System.out.println(ans);
    }
}
