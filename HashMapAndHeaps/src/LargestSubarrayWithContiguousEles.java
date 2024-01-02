import java.util.HashSet;

public class LargestSubarrayWithContiguousEles {
    public static void main(String[] args) {
        System.out.println("We will find the largest contiguous subarray in the array");

        int[] arr = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0};
        findContiguousSubArray(arr);

    }

    private static void findContiguousSubArray(int[] arr) {

        int ans = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            set.add(arr[i]);
//            int min = arr[i];
//            int max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                min = Math.min(arr[j], min);
                max = Math.max(arr[j], max);
                if (max - min == j - i) {
                    ans = Math.max(ans, j - i + 1);
                }

            }
        }
        System.out.println(ans);
    }
}
