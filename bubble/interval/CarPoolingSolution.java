package bubble.interval;
import java.util.*;

/**
 * CarPoolingSolution
 */
public class CarPoolingSolution {
    public boolean canPool(int[][] trips, int capacity) {
        SortedMap<Integer, Integer> sm = new TreeMap<>();
        for (int[] trip : trips) {
            sm.put(trip[1], sm.getOrDefault(trip[1], 0) + trip[0]);
            sm.put(trip[2], sm.getOrDefault(trip[2], 0) - trip[0]);
        }
        int load = 0;
        for(Integer key : sm.keySet()) {
            load += sm.getOrDefault(key, 0);
            if (load > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPoolingSolution cps = new CarPoolingSolution();
        int trips[][] = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        System.out.println(cps.canPool(trips, capacity));

    }
    
}