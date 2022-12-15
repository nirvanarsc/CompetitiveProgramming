package leetcode.weekly_contests.weekly_300_399.weekly_322;

public class P_1 {

    public boolean isCircularSentence(String sentence) {
        final String[] w = sentence.split(" ");
        final int n = w.length;
        for (int i = 0; i < n; i++) {
            final int j = (i + 1) % n;
            if (w[i].charAt(w[i].length() - 1) != w[j].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
