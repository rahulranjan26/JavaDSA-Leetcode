import java.util.HashMap;

public class PairSumInTwoSortedArray {
    public static void main(String[] args) {
        System.out.println(
                "Here we will learn about the finding pairs of numbers in matrix with given sum"
        );
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[][] mat1 = {{1, 5, 6},
                {8, 10, 11},
                {15, 16, 18}};
        int[][] mat2 = {{2, 4, 7},
                {10, 11, 12},
                {13, 16, 20}};
        int ans = 0;
        int sum = 21;
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                mp.put(mat1[i][j], mp.getOrDefault(mat1[i][j], 0) + 1);
            }
        }
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (mp.containsKey(sum - mat2[i][j])) {
                    ans += mp.get(sum - mat2[i][j]);
                    System.out.println(mat2[i][j] + "-->" + (sum - mat2[i][j]));
                }
            }
        }
        System.out.println(ans);
    }
}
