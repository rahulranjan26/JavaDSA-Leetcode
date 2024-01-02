import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IfArrayIsDivisibleByK {
    public static void main(String[] args) {
        System.out.println("We will check if the array is divisible by K");
        ArrayList<Integer> myArray = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int K = scn.nextInt();
        for (int i = 0; i < n; i++) {
            myArray.add(scn.nextInt());
        }
        System.out.println(Arrays.toString(myArray.toArray()));
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < myArray.size(); i++) {
            int rem = myArray.get(i) % K;
            int of = freqMap.getOrDefault(rem, 0);
            freqMap.put(rem, of + 1);
        }
        for (int i : freqMap.keySet()) {
            if (i == 0) {
                int temp = freqMap.get(0);
                if (temp % 2 == 1) {
                    System.out.println(false);
                    break;
                }
            } else if (2 * i == K) {
                int temp = freqMap.get(i);
                if (temp % 2 == 1) {
                    System.out.println(false);
                    break;
                }
            } else {
                if (!freqMap.get(i).equals(freqMap.get(K - i))) {
                    System.out.println(false);
                    break;

                }
            }
        }
        System.out.println(true);
    }
}
