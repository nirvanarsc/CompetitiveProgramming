package leetcode.weekly_contests.weekly_100_199.weekly_137;

public class P_1047 {

    public String removeDuplicates(String s) {
        final int n = s.length();
        final char[] res = new char[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (size > 0 && res[size - 1] == s.charAt(i)) {
                size--;
            } else {
                res[size++] = s.charAt(i);
            }
        }
        return new String(res, 0, size);
    }
}
