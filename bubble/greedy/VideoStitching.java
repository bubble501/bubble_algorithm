package bubble.greedy;
import java.util.*;
/**
 * VideoStitching
 */
public class VideoStitching {

    public int solve(int[][] clips, int t) {
        Arrays.sort(clips, (a, b)-> a[0]-b[0]);
        int count = 0, end = 0;
        for (int i = 0; i < clips.length; ) {
            if(clips[i][0] > end) {
                return -1;
            }
            int maxEnd = end;
            while (i < clips.length && clips[i][0] <= end) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }
            count++;
            end = maxEnd;
            if (end >= t) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}