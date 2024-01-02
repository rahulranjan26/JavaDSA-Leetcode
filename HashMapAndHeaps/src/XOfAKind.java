import java.util.HashMap;

public class XOfAKind {
    public static void main(String[] args) {
        System.out.println("We will do X of a kind problem");

        int[] num = {2, 2, 2, 4, 4, 4, 4, 5, 5, 5, 9, 9, 9};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : num
        ) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ans = 0;

        for (int x : map.keySet()
        ) {
            ans = gcd(map.get(x), ans);
        }
        if (ans >= 2)
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
