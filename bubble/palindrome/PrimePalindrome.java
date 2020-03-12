package bubble.palindrome;

/**
 * PrimePalindrome
 */
public class PrimePalindrome {

    public int solve(int n) {
        if (n <= 2) return 2;
        if (n == 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        int num = 0;
        for (int i = 0; i < 100000; i++) {
            String str = String.valueOf(i);
            if ((i & 1) == 0) {
                continue;
            }
            char[] str2 = new char[str.length()*2 -1];
            for (int j = 0; j < str.length(); j++) {
                str2[j] = str.charAt(j);
                if (j != (str.length()-1) ) {
                    str2[str.length()*2-2-j] = str.charAt(j);
                }
            } 
            num = Integer.parseInt(new String(str2));
            if (num >= n && isPrime(num)) return num;
        }
        return -1;
    }

    private boolean isPrime(int n) {
        if (n < 2 || (n&1)==0) return n == 2;
        for (int i = 3; i*i <= n; i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}