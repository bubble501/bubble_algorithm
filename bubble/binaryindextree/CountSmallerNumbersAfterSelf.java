package bubble.binaryindextree;
import java.util.*;
/**
 * CountSmallerNumbersAfterSelf
 * https://github.com/cherryljr/LintCode/blob/master/Count%20of%20Smaller%20Number%20before%20itself.java
 */
public class CountSmallerNumbersAfterSelf {

    int[] BITree;

    public List<Integer> solve(int[] nums) {
        if (nums == null || nums.length ==0) {
            return new ArrayList<Integer>();
        }
        int maxValue = Integer.MIN_VALUE;
        int minValue = Arrays.stream(nums).min().getAsInt();

        int [] diff = new int[nums.length];

        for (int i = 0; i < diff.length; i++) {
            diff[i] = nums[i] - minValue + 1;
            maxValue = Math.max(maxValue, diff[i]);
        }

        this.BITree = new int[maxValue+1];
        Integer[] rst = new Integer[nums.length];
        for (int i = nums.length -1; i>=0; i--) {
            rst[i] = query(diff[i]-1);
            update(diff[i]);
        }

        return Arrays.asList(rst);
    }

    private void update(int index) {
        while (index < BITree.length) {
            BITree[index]++;
            index += index & -index;
        }
    }

    private int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BITree[index];
            index -= index & -index;
        }
        return sum;
    }
}