package leetcode.weekly_contests.weekly_300_399.weekly_324;

public class P_1 {

    public int similarPairs(String[] words) {
        final int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (f(words[i]) == f(words[j])) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int f(String w) {
        int mask = 0;
        for (char c : w.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
}
