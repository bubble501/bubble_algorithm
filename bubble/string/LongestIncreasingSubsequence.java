package bubble.string;
import java.util.*;

/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {
    public int solve(int arr[]) {
        TreeSet<Integer> set = new TreeSet<>((a, b)->a-b);
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) continue;
            Integer ceiling = set.ceiling(arr[i]);
            if (ceiling!=null) {
                set.remove(ceiling);
            }
            set.add(arr[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence ins = new LongestIncreasingSubsequence();
        int[] arr = {2, 6, 3, 4, 1, 2, 9, 5, 8};
        System.out.println(ins.solve(arr));
    }
    
}