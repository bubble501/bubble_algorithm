package bubble.slidewindows;

/**
 * MinimumSwap
 */
public class MinimumSwap {

    public int solve(int[] data) {
        int k = 0;
        for (int i : data) {
            if (i == 1) {
                k++;
            }
        }

        int res = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for (int end = 0; end < data.length; end++) {
            if (data[end]==0) {
                count++;
            }
            if (end - start + 1 > k) {
                if (data[start]==0) {
                    count--;
                }
            }
            if (end - start + 1 >= k) {
                if (count < res) {
                    res = count;
                }
            }
        }
        return res;
    }
}