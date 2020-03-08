package bubble.interval;
import java.util.*;

import javax.naming.ldap.ManageReferralControl;

/**
 * IntervalListIntersections
 */
public class IntervalListIntersections {
    public static final int STATE_BOTH = 2;
    public static final int STATE_SINGLE = 1;
    public static final int STATE_EMPTY = 0;

    public static final int A = 1;
    public static final int B = 2;

    class Point {
        int value;
        int belongTo;
        boolean isOpen;
    }
    public List<int[]> solve(int[][] a, int[][] b) {
        ArrayList<int[]> timeline = new ArrayList<>();
        for (int[] p : a) {
            timeline.add(new int[]{p[0], A});
            timeline.add(new int[]{p[1], -A});
        }

        for (int[] p : b) {
            timeline.add(new int[]{p[0], B});
            timeline.add(new int[]{p[1], -B});
        }

        timeline.sort((e1, e2)-> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int curState= STATE_EMPTY;
        List<int[]> ans = new ArrayList<>();
        int curStart = 0;
        int curEnd = 0;
        for (int[] p : timeline) {
            if (p[1] > 0) {
                curState = curState + 1;
                if (curState == STATE_BOTH) {
                    curStart = p[0];
                } 
            } else {
                curState = curState - 1;
                if (curState == STATE_SINGLE) {
                    curEnd = p[0];
                    ans.add(new int[] {curStart, curEnd});
                }
            }  
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        IntervalListIntersections ins = new IntervalListIntersections();
        List<int[]> ans = ins.solve(A, B);
        for (int[] item : ans) {
            System.out.println("[" + item[0] + ","+ item[1]+ "]");
        } 
    }
}