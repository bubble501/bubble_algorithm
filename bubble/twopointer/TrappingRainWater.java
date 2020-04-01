package bubble.twopointer;

public class TrappingRainWater {
    public int solve(int[] heights) {
        if(heights == null || heights.length < 2) return 0;
        int left = 0, right=heights.length-1, water = 0;
        int maxLeft = heights[left];
        int maxRight = heights[right];
        while (left < right) {
            if (heights[left] <= heights[right]) {
                left++;
                maxLeft = Math.max(maxLeft, heights[left]);
                water += (maxLeft-heights[left]);
            } else {
                right--;
                maxRight = Math.max(maxRight, heights[right]);
                water += (maxRight - heights[right]);
            }
        }
        return water;
    }
    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
        int[] heights = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(instance.solve(heights));
    }
}   