import java.util.HashMap;
import java.util.Scanner;

public class CompleteItinerary {
    public static void main(String[] args) {
        System.out.println("Hi Python");
//        Scanner scn = new Scanner(System.in);
        HashMap<String, String> cities = new HashMap<String, String>();
//        int n = scn.nextInt();
//        for (int i = 0; i < 4; i++) {
//            String start = scn.next();
//            String dest = scn.next();
//            cities.put(start, dest);
//        }
        cities.put("Chennai", "Bangalore");
        cities.put("Bombay", "Delhi");
        cities.put("Goa", "Chennai");
        cities.put("Delhi", "Goa");
        findItinerary(cities);

    }

    private static void findItinerary(HashMap<String, String> cities) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String st : cities.keySet()) {
            map.put(cities.get(st),false);
            if (map.containsKey(st)==false) {
                map.put(st, true);
            }
        }
        String start = "";
        for (String s : map.keySet()) {
            if (map.get(s)) {
                start = s;
            }
        }
//        System.out.println(start);

        String itinerary = "";
        while (true) {
            if (cities.containsKey(start)==true) {
                itinerary += start+"-->";
                start = cities.get(start);
            } else {
                itinerary += start;
                break;
            }
        }
        System.out.println(itinerary);
    }
}
