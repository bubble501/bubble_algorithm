package bubble.twopointer;

/**
 * ContainerWIthMostWater
 */
public class ContainerWithMostWater {
    public int solve(int[] height) {
        if (height == null || height.length < 2) return 0;
        int i = 0; 
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j])* (j - i));
            if (height[i]<height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
    
}