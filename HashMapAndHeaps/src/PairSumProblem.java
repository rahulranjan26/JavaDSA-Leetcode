import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PairSumProblem {
    public static void main(String[] args) {
        System.out.println("We will learn about pair sum in this question.");
        HashSet<Integer> map = new HashSet<>();

        boolean flag = false;

        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(2, 9, 3, 5, 8, 6, 4));
        for (int i = 0; i < arrList.size() - 1; i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                int temp = arrList.get(i) + arrList.get(j);
                if (map.contains(temp)) {
                    System.out.println(true);
                    flag = true;
                    break;
                }
                map.add(temp);
            }
            if (flag)
                break;

        }
        System.out.println(false);
    }
}
