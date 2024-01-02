import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayWithEqual0And1 {
    public static void main(String[] args) {
        System.out.println("Find the Largest Subarray with equal 0 and 1");

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, 1));

        findResult(arr);
    }

    private static void findResult(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            prefixSum += arr.get(i);
            if (map.containsKey(prefixSum)) {
                int temp = i - map.get(prefixSum);
                if (temp > ans) {
                    ans = temp;
                }
            } else {
                map.put(prefixSum, i);
            }

        }
        System.out.println(ans);
    }
}
