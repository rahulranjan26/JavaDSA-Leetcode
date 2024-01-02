import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumEqualToK {
    public static void main(String[] args) {
        System.out.println("We will find the number of subarray with sum equal ko K");
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 5;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1));
        int preFix = 0;
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            preFix += arrayList.get(i);
            if (map.containsKey(preFix - k)) {
                count += map.get(preFix - k);
            }
            map.put(preFix, map.getOrDefault(preFix, 0) + 1);
        }
        System.out.println(count);


    }
}
