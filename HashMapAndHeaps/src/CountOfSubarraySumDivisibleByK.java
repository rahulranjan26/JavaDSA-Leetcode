import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountOfSubarraySumDivisibleByK {
    public static void main(String[] args) {
        System.out.println("This is program to find the count of subarray divisible by K");
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int prefix = 0;
        int count = 0;
        map.put(0, 1);
        int k = 7;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 8, -3, -9, -7, 4, 11, 2, 9, -16, 8, -4));
        for (int i = 0; i < arrayList.size(); i++) {
            prefix += arrayList.get(i);
            int rem = prefix % k;
            if (rem < 0) {
                rem += k;
            }
            if (map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.getOrDefault(rem, 0) + 1);
            } else {
                map.put(rem, 1);
            }


//            System.out.println(ans);

        }
        System.out.println(ans + "  " + count);
    }
}
