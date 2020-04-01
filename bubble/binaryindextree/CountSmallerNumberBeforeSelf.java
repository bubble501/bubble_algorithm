package bubble.binaryindextree;
import java.util.*;

/**
 * CountSmallerNumberBeforeself
 */
public class CountSmallerNumberBeforeSelf {
    int[] BITree;

    public List<Integer> solve(int[] A){
        if (A == null || A.length==0) {
            return new ArrayList<>();
        }
        int minValue = Arrays.stream(A).min().getAsInt();
        int[] diff = Arrays.stream(A).map(elem -> elem-minValue +1).toArray();
        int maxValue = Arrays.stream(diff).max().getAsInt();

        BITree = new int[maxValue+1];
        Integer[] rst = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
           rst[i] = query(diff[i]-1);
           update(diff[i]); 
        }
        return Arrays.asList(rst);
    }

    private void update(int index) {
        while (index <BITree.length) {
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