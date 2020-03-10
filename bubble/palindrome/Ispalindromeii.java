package bubble.palindrome;

/**
 * Ispalindromeii
 * Delete at most 1 charater.
 */
public class Ispalindromeii {

    public boolean solve(String s) {
        if (isPalindrome(s)) return true;
        int l = 0, r = s.length() -1;
        while (l < r) {
            if (s.charAt(l)!= s.charAt(r)) {
                if (isPalindrome(s.substring(l+1, r+1))) return true;
                if (isPalindrome(s.substring(l, r))) return true;
                return false;
            }
            l++;
            r--;

        }
        return true;
    }

    private boolean isPalindrome(String s) {
        if (s==null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i)!= s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        Ispalindromeii instance = new Ispalindromeii();
        System.out.println(instance.solve(s));
    }
}