import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RemoveAddGetRandom {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static ArrayList<Integer> ar = new ArrayList<>();

    static Random r = new Random();

    RemoveAddGetRandom() {
//        map = new HashMap<>();
//        ar = new ArrayList<>();
//        r = new Random();
    }

    public static void insert(int a) {
        ar.add(a);
        map.put(a, ar.size() - 1);

    }

    public static int remove(int val) {
        int idx = map.get(val);
        ar.set(idx, ar.get(ar.size() - 1));
        ar.remove(ar.size() - 1);
        map.put(ar.get(idx), idx);
        return -1;

    }

    public static void getRandom() {
        int idx = r.nextInt(ar.size());
        System.out.println(ar.get(idx));
    }

    public static void main(String[] args) {
        insert(5);
        insert(10);
        insert(15);
        insert(11);
        insert(89);
        insert(3);
        getRandom();
        getRandom();
        getRandom();
        remove(5);
        remove(15);
        remove(3);
        getRandom();


    }
}
