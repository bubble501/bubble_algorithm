package bubble.heap;

import java.util.*;

/**
 * CheapestFilghtsWithinKStops
 */
public class CheapestFilghtsWithinKStops {
    class Flight {
        int src;
        int dst;
        int price;
        public Flight(int src, int dst, int price) {
            this.src = src;
             this.dst = dst;
            this.price = price;
        }
    }

    class Stop {
        int id, cost, count;
        public Stop(int id, int cost, int count) {
            this.id = id;
            this.cost = cost;
            this.count = count;
        }
    }

    public int solve(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, ArrayList<Flight>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], a -> new ArrayList<>()).add(
                new Flight(flight[0], flight[1], flight[2])
            );
        }

        PriorityQueue<Stop> q = new PriorityQueue<>((s1, s2)->s1.cost-s2.cost);
        q.offer(new Stop(src, 0, K));
        while (!q.isEmpty()) {
            Stop cur = q.poll();
            if (cur.id == dst) {
                return cur.cost;
            }
            if (cur.count > 0) {
                List<Flight> list = map.get(cur.id);
                if (list == null) {
                    continue;
                }
                for (Flight f : list) {
                    q.offer(new Stop(f.dst, f.price+cur.cost, cur.count-1));
                }
            }
        }
        int res = 0;
        return res;
    }
    
}