package leetcode.weekly_contests.weekly_114;

public class P_953 {

    public boolean isAlienSorted(String[] words, String order) {
        final int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!verify(words[i], words[i + 1], idx)) {
                return false;
            }
        }
        return true;
    }

    private static boolean verify(String l, String r, int[] idx) {
        for (int j = 0; j < l.length(); j++) {
            if (j >= r.length()) {
                return false;
            }
            final int u = l.charAt(j) - 'a';
            final int v = r.charAt(j) - 'a';
            if (idx[u] > idx[v]) {
                return false;
            } else if (idx[u] < idx[v]) {
                return true;
            }
        }
        return true;
    }
}
