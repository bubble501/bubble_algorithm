package bubble.heap;
import java.util.*;

/**
 * SkyLine
 */
public class SkyLine {

    public List<int[]> solve(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        if (buildings == null || buildings.length < 1) return res;
        for (int[] b : buildings) {
            points.add(new int[] {b[0], -b[2]});
            points.add(new int[] {b[1], b[2]});
        }
        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> maxHeight = new PriorityQueue<>((a, b)-> b-a);
        maxHeight.offer(0);
        int pre = 0;
        for(int[] p : points) {
            if (p[1] < 0) {
                maxHeight.offer(-p[1]);
            } else {
                maxHeight.remove(p[1]);
            }
            int cur = maxHeight.peek();
            if (pre != cur) {
                res.add(new int[] {p[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}