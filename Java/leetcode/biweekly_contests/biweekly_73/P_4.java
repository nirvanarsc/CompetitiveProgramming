package leetcode.biweekly_contests.biweekly_73;

public class P_4 {

    public int minMovesToMakePalindrome(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (l < r) {
            if (w[l] != w[r]) {
                int i = l;
                int j = r;
                while (w[i] != w[r]) {
                    i++;
                }
                while (w[j] != w[l]) {
                    j--;
                }
                if (i == r) {
                    System.arraycopy(w, j + 1, w, j, r - j);
                    w[r] = w[l];
                    res += r - j;
                } else {
                    System.arraycopy(w, l, w, l + 1, i - l);
                    w[l] = w[r];
                    res += i - l;
                }
            }
            l++;
            r--;
        }
        return res;
    }
}
