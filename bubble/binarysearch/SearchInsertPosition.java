package bubble.binarysearch;

/**
 * SearchInsertPosition
 */
public class SearchInsertPosition {
    public int solve(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}