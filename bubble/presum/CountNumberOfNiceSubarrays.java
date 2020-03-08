package bubble.presum;
import java.util.*;

/**
 * CountNumberOfNiceSubarrays
 */
public class CountNumberOfNiceSubarrays {

    static class SlideWindowsArray {
        public int solve(int[] nums, int k) {
            int[] visited = new int[nums.length + 1];
            visited[0] = 1;
            int cur = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                cur += (nums[i] % 2) == 1 ? 1: 0;
                visited[cur]++;
                result += (cur-k) >= 0? visited[cur-k] : 0;
            }
            return result;
        }
    }

    static class SlideWindowsHashMap {
        public int solve(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0 ,1);
            int cur = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                cur += (nums[i]%2)==1 ? 1: 0;
                map.put(cur, map.getOrDefault(cur, 0) +1);
                System.out.println(map.toString());
                System.out.println("%d:  %d  : %d".formatted(i, nums[i], map.getOrDefault(cur-k, 0)));
                result += map.getOrDefault(cur-k, 0);
            }
            return result;
        }
    }

    static class SlideWindows {
        public int solve(int[] nums, int k) {
            return cnt(nums, k) - cnt(nums, k-1);
        }

        private int cnt(int[] nums, int k) {
            int start = 0, end =0, cnt = 0, res =0;
            while (end < nums.length) {
                if (nums[end++] % 2 == 1) {
                    ++cnt;
                }
                while (cnt > k) {
                    if (nums[start++] % 2 == 1) {
                        --cnt;
                    }
                    res += end -start;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SlideWindowsHashMap instance = new SlideWindowsHashMap();
        int[] nums ={2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2};
        int k = 2;
        System.out.println(instance.solve(nums, 1));
    }
}