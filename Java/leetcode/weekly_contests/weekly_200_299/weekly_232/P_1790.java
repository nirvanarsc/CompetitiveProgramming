package leetcode.weekly_contests.weekly_200_299.weekly_232;

public class P_1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        final char[] w = s2.toCharArray();
        for (int i = 0; i < w.length; i++) {
            for (int j = i + 1; j < w.length; j++) {
                swap(w, i, j);
                if (s1.equals(new String(w))) {
                    return true;
                }
                swap(w, i, j);
            }
        }
        return false;
    }

    private static void swap(char[] w, int i, int j) {
        final char t = w[i];
        w[i] = w[j];
        w[j] = t;
    }
}
