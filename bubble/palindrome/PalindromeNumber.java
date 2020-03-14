package bubble.palindrome;

/**
 * PalindromeNumber
 */
public class PalindromeNumber {

    public boolean solve(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 12;
        PalindromeNumber instance = new PalindromeNumber();
        System.out.println(instance.solve(x));
    }
}