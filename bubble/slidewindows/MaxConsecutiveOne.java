package bubble.slidewindows;

/**
 * MaxConsecutiveOne
 */
public class MaxConsecutiveOne {

    public int solve(int[] a, int k) {
        int maxOnes = Integer.MIN_VALUE;
        int numConversions = 0;
        int left = 0, right = 0;
        for (right = 0; right < a.length; right++) {
            if (a[right] == 0) {
                numConversions++;
            }
            while (numConversions > k) {
                if(a[left] == 0) {
                    numConversions--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right-left+1);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        MaxConsecutiveOne instance = new MaxConsecutiveOne();
        System.out.println(instance.solve(a, k));
    }
}