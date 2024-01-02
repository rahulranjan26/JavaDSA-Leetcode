import java.util.Arrays;
import java.util.HashSet;

public class HashCodeAndEqualsOverride {

    static class Pair {
        int a;
        String s;

        Pair(int a, String s) {
            this.a = a;
            this.s = s;
        }

        @Override
        public int hashCode() {
            return this.a % 31;
        }

        @Override
        public boolean equals(Object o) {
            Pair obj = (Pair) o;
            if (o == null)
                return false;
            if (this.a != obj.a)
                return false;
            if (!this.s.equals(obj.s))
                return false;

            return true;
        }

        @Override
        public String toString() {
            return this.a + " is a number and  " + this.s + " is a string";
        }

    }

    public static void main(String[] args) {
        System.out.println("We will work on overriding the Hashcode and Equals in hashmap");

//        Now lets just make two pair objs and put it in hashMap
        HashSet<Pair> set = new HashSet<>();
        Pair p1 = new Pair(10, "Raga");
        Pair p2 = new Pair(10, "Rag");
        set.add(p1);
        set.add(p2);


        System.out.println(Arrays.toString(set.toArray()));



    }
}
