package weekly_contests.weekly_114;

public class P_953 {

    public boolean isAlienSorted(String[] words, String order) {
        final int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], map) == 1) {
                return false;
            }
        }
        return true;
    }

    private static int compare(String w1, String w2, int[] map) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            if (map[w1.charAt(i) - 'a'] != map[w2.charAt(i) - 'a']) {
                return map[w1.charAt(i) - 'a'] < map[w2.charAt(i) - 'a'] ? -1 : 1;
            }
        }
        return w1.length() < w2.length() ? -1 : 1;
    }
}
