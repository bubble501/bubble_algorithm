package bubble.interval;
import java.util.*;

/**
 * RightIntervalSolution
 */
public class RightIntervalSolution {
    public int[] find(int[][] intervals) {
        int [] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = -1;
        }
        List<int[]> timeline = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            timeline.add(new int[]{intervals[i][0], i, 1});
            timeline.add(new int[]{intervals[i][1], i, -1});
        }
        timeline.sort((a, b)->a[0]==b[0]? a[2]-b[2] : a[0]-b[0]); 
        for (int i = 0; i < timeline.size(); i++) {
            int[] point = timeline.get(i);
            if (point[2]==-1) {
                for (int j = i+1; j < timeline.size(); j++) {
                    if(timeline.get(j)[2] == 1) {
                        res[point[1]] = timeline.get(j)[1]; 
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};
        RightIntervalSolution ris = new RightIntervalSolution();
        int[] res =ris.find(intervals);
        System.out.println(Arrays.toString(res));
    }
}