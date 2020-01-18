package easy;

public class P_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int t = x;
        int reversed = 0;
        while (t != 0) {
            if (reversed > Integer.MAX_VALUE / 10) {
                return false;
            }
            reversed = reversed * 10 + t % 10;
            t /= 10;
        }
        return reversed == x;
    }
}
