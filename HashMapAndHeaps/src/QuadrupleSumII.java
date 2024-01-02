import java.util.ArrayList;
import java.util.Arrays;

public class QuadrupleSumII {
    public static void main(String[] args) {
        System.out.println("Quadruple Sum number - 2");

        int[] arr = {5, 9, 3, 4, 9, 7, 4, 8, 5, 4, 9, 7, 3, 6, 1, 5, 8, 9, 3, 4, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int sum = 15;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((j != i + 1 && arr[j] == arr[j - 1]) || (i != 0 && arr[i] == arr[i - 1])) {
                    continue;
                }
                int si = j + 1;
                int ei = arr.length - 1;
                while (si < ei) {
                    int tempSum = arr[i] + arr[j] + arr[si] + arr[ei];
                    if (tempSum < sum)
                        si++;
                    else if (tempSum > sum) {
                        ei--;
                    } else {
                        ArrayList<Integer> tempAns = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[si], arr[ei]));
                        ans.add(tempAns);
                        si++;
                        ei--;
                        while (si < ei && arr[si] == arr[si - 1]) si++;
                        while (si < ei && arr[ei] == arr[ei - 1]) ei++;
                    }

                }


            }

        }

        System.out.println(ans);
    }
}
