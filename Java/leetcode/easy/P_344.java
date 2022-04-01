package leetcode.easy;

public class P_344 {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            final char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
