package leetcode.weekly_contests.weekly_250;

public class P_1 {

    public int canBeTypedWords(String text, String brokenLetters) {
        final String[] w = text.split(" ");
        final int[] map = new int[26];
        for (char c : brokenLetters.toCharArray()) {
            map[c - 'a'] = 1;
        }
        int res = 0;
        for (String word : w) {
            if (ok(word, map)) {
                res++;
            }
        }
        return res;
    }

    private static boolean ok(String word, int[] map) {
        for (char c : word.toCharArray()) {
            if (map[c - 'a'] == 1) {
                return false;
            }
        }
        return true;
    }
}
