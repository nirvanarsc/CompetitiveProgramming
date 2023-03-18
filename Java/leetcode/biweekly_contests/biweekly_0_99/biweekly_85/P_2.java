package leetcode.biweekly_contests.biweekly_0_99.biweekly_85;

public class P_2 {

    public int secondsToRemoveOccurrences(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int res;
        for (res = 0; true; res++) {
            boolean done = true;
            for (int i = 0; i < n - 1; i++) {
                if (w[i] == '0' && w[i + 1] == '1') {
                    done = false;
                    w[i] = '1';
                    w[i + 1] = '0';
                    i++;
                }
            }
            if (done) {
                break;
            }
        }
        return res;
    }
}
