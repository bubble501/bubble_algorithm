package bubble.dfs;
import java.util.*;
/**
 * SubsetII
 */
public class SubsetII {
    public List<ArrayList<Integer>> solve(int[] s) {
        List<ArrayList<Integer>> res = new ArrayList<>();
        if (s == null || s.length == 0) return res;
        Arrays.sort(s);
        Stack<Integer> stack = new Stack<>();
        dfs(s, 0, stack, res);
        return res;
    }

    private void dfs(int[] s, int start, Stack<Integer> working, List<ArrayList<Integer>> res) {
        for (int i = start; i < s.length; i++) {
            if (i > start && s[i] == s[i-1]) continue;
            working.push(s[i]);
            res.add(new ArrayList<>(working));
            dfs(s, i+1, working, res);
            working.pop();
        }
    }
    
    public static void main(String[] args) {
        SubsetII ins = new SubsetII();
        int[] s = {1, 2, 2};
        List<ArrayList<Integer>> res = ins.solve(s);
        for (ArrayList<Integer> item : res) {
            System.out.println(item.toString());
        }
    }
}