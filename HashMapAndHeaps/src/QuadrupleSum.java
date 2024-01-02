import java.util.ArrayList;
import java.util.Arrays;

public class QuadrupleSum {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "[" + this.first + "  " + this.second + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("We will find 4 number whose sum is equal to K");
        int[] arr = {5, 9, 3, 4, 9, 7, 4, 8, 5, 4, 9, 7, 3, 6, 1, 5, 8, 9, 3, 4, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int sum = 15;
        int si = 0;
        int ei = arr.length - 1;
        for (int i = si; i < ei; i++) {
            if (i != si && arr[i] == arr[i - 1]) continue;
            int rs = sum - arr[i];
            ArrayList<ArrayList<Integer>> pp = getThreeSum(arr, rs, i + 1);
            createFinalList(ans, pp, arr[i]);
        }
        System.out.println(ans);


//        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> getThreeSum(int[] numbers, int k, int start) {
        int si = start;
        int ei = numbers.length - 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = si; i < ei; i++) {
            if (i != si && numbers[i] == numbers[i - 1]) continue;
            int rs = k - numbers[i];
            ArrayList<ArrayList<Integer>> pp = getTwoNumber(numbers, rs, i + 1);
            createFinalList(ans, pp, numbers[i]);
        }
        return ans;

    }

    private static void createFinalList(ArrayList<ArrayList<Integer>> ans, ArrayList<ArrayList<Integer>> pp, int number) {
        for (ArrayList<Integer> p : pp) {
            p.add(number);
            ans.add(p);
        }
    }

    public static ArrayList<ArrayList<Integer>> getTwoNumber(int[] numbers, int k, int start) {
        int si = start;
        int ei = numbers.length - 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        while (si < ei) {
            int x1 = numbers[si];
            int x2 = numbers[ei];
            int sum = x1 + x2;
            if (sum == k) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(x1);
                al.add(x2);
                ans.add(al);
                si++;
                ei--;
                while (si < ei && numbers[si] == numbers[si - 1]) si++;
                while (si < ei && numbers[ei] == numbers[ei + 1]) ei--;
            } else if (sum > k) {
                ei--;
            } else
                si++;
        }
        return ans;
    }
}
