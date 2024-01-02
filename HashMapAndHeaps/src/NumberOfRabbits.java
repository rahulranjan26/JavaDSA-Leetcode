import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberOfRabbits {
    public static void main(String[] args) {
        System.out.println("We will work on rabbit hole problem");
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> rabbits = new ArrayList<>(Arrays.asList(2, 2, 3, 1, 0, 2, 2, 1, 3));
        for (int i : rabbits
        ) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            int group = key + 1;
            int number = map.get(key);
            int total = (int) Math.ceil(number * 1.0 / group);
            ans += total * group;
        }
        System.out.println(ans);

    }
}
