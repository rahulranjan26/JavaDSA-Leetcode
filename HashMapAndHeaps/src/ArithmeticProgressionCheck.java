import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ArithmeticProgressionCheck {
    public static void main(String[] args) {
        System.out.println("We will learn about arithmetic progression");
        int[] arr = {17, 9, 5, 29, 1, 35, 13, 37, 21, 33};
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

        }
        int n = arr.length;
        int d = (max - min) / (n - 1);
        int a = min;
        for (int i = 0; i < arr.length; i++) {
            int temp = a + (i) * d;
            if (!set.contains(temp)) {
                System.out.println(false);
                break;
            }

        }
        System.out.println(true);

    }

}
