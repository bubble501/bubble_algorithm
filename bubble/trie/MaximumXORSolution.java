package bubble.trie;
import java.util.*;

/**
 * MaximumXORSolution
 */
public class MaximumXORSolution {
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for (int i = 31; i >=0; i--) {
                int curBit = (num>>>i)&1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }  
    

        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num>>>i) &i;
                if (curNode.children[curBit^1]!= null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit^1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

    public static void main(String[] args) {
         Solution2 s = new Solution2();
         int[] nums = {8, 24};
         System.out.println(s.findMaximumXOR(nums));
    }
    
    static class Solution2 {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                mask = mask | (1 << i);
                Set<Integer> set = new HashSet<Integer>();
                for (int num: nums) {
                    set.add(num & mask);
                }
                int temp = max | (1 << i);

                for (int prefix : set) {
                    if (set.contains(prefix ^ temp)) {
                        max = temp;
                        break;
                    }
                }
            }
            return max;
        }
    }
}