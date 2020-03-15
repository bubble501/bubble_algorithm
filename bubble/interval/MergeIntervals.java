package bubble.interval;
import java.util.*;
/**
 * MergeIntervals
 */
public class MergeIntervals {
    List<int[]> solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals == null || intervals.length==0 || intervals[0].length!= 2) {
            return res;
        } 
        Arrays.sort(intervals, (a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for (int[] is : intervals) {
            if(res.isEmpty()==false && res.get(res.size()-1)[1] >= is[0]) {
                res.get(res.size()-1)[1] = is[1];
            } else {
                res.add(is);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals ins = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] is : ins.solve(intervals)) {
            System.out.println("["+ is[0] + "," + is[1]+ "]");
        }
         
    }
}