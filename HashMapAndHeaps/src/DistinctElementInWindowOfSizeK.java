import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctElementInWindowOfSizeK {
    public static void main(String[] args) {
        System.out.println("We will learn a good strategy of acquire and release");

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(5);
        arr.addAll(Arrays.asList(2, 9, 7, 8, 3, 1, 5, 4, 7, 8, 0, 7, 9, 6, 7, 5, 9));
        int k = 10;
        findTheResult(arr, k);

    }

    private static void findTheResult(ArrayList<Integer> arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        for (int i = k - 1, j = 0; i < arr.size(); ) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
            int sz = map.size();
            ans.add(sz);
            int freq = map.get(arr.get(j));
            if (freq == 1) {
                map.remove(arr.get(j));
            } else {
                map.put(arr.get(j), freq - 1);
            }
            i++;
            j++;
        }
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
