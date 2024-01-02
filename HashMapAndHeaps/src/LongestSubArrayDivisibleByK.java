

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayDivisibleByK {
    public static void main(String[] args) {
        System.out.println("This is program to find the longest subarray divisible by K");
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int prefix = 0;
        int count = 0;
        map.put(0, -1);
        int k = 7;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 8, -3, -9, -7, 4, 11, 2, 9, -16, 8, -4));
        for (int i = 0; i < arrayList.size(); i++) {
            prefix += arrayList.get(i);
            int rem = prefix % k;
            if (rem < 0) {
                rem += k;
            }
            if (map.containsKey(rem)) {
                int temp = i - map.get(rem);
                System.out.println(arrayList.subList(map.get(rem) + 1, i + 1));
                count += 1;
                if (temp > ans) {

                    ans = temp;
                }

            }
            map.put(rem, i);

//            System.out.println(ans);

        }
        System.out.println(ans + "  " + count);
    }
}
