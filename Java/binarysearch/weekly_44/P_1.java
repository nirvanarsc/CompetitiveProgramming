package binarysearch.weekly_44;

public class P_1 {

    public int solve(String s) {
        final int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                int j = i;
                int curr = 0;
                while (j < n && '0' <= s.charAt(j) && s.charAt(j) <= '9') {
                    curr = curr * 10 + s.charAt(j) - '0';
                    j++;
                }
                res += curr;
                i = j - 1;
            }
        }
        return res;
    }
}
