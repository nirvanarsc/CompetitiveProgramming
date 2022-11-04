package leetcode.easy;

public class P_345 {

    public String reverseVowels(String s) {
        final int n = s.length();
        int l = 0;
        int r = n - 1;
        final String vowels = "aeiouAEIOU";
        final char[] w = s.toCharArray();
        while (l < r) {
            if (vowels.indexOf(w[l]) == -1) {
                l++;
            } else if (vowels.indexOf(w[r]) == -1) {
                r--;
            } else {
                final char t = w[l];
                w[l] = w[r];
                w[r] = t;
                l++;
                r--;
            }
        }
        return new String(w);
    }
}
