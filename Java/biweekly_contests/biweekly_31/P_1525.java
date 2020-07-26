package biweekly_contests.biweekly_31;

public class P_1525 {

    public int numSplits(String s) {
        final int[] total = new int[26];
        final int[] running = new int[26];
        int totalUniq = 0;
        int runningUniq = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            totalUniq += increment(total, c);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            final char c = s.charAt(i);
            runningUniq += increment(running, c);
            totalUniq -= decrement(total, c);
            if (runningUniq == totalUniq) {
                res++;
            }
        }
        return res;
    }

    private static int decrement(int[] total, char c) {
        if (--total[c - 'a'] == 0) {
            return 1;
        }
        return 0;
    }

    private static int increment(int[] running, char c) {
        if (running[c - 'a']++ == 0) {
            return 1;
        }
        return 0;
    }
}
