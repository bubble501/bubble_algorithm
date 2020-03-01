package bubble.monotone;
import java.util.*;

/**
 * LargestRectangleInHistogram
 */
public class LargestRectangleInHistogram {
    public int execute(int[] heights) {
        if (heights==null || heights.length < 1 ) return 0;
        int res = 0;
        int len = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (deque.peek() != -1 && heights[i] <= heights[deque.peek()]) {
                res = Math.max(res, heights[deque.pop()]*(i-deque.peek() -1));
            }
            deque.push(i);
        }

        while (deque.peek()!= -1) {
            res = Math.max(res, heights[deque.pop()]*(len - deque.peek()-1));
        }
        return res;
    }
}
