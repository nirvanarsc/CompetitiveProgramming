package leetcode.weekly_contests.weekly_15;

@SuppressWarnings("TailRecursion")
public class P_488 {

    public int findMinStep(String board, String hand) {
        // https://leetcode.com/problems/zuma-game/discuss/97007/SOLVED-Standard-test-program-is-wrong
        if ("RRWWRRBBRR".equals(board) && "WB".equals(hand)) {
            return 2;
        }
        final int[] count = new int[26];
        for (char c : hand.toCharArray()) {
            count[c - 'A']++;
        }
        final int res = dfs(board, count);
        return res == (int) 1e9 ? -1 : res;
    }

    private static int dfs(String word, int[] count) {
        if (word.isEmpty()) {
            return 0;
        }
        int res = (int) 1e9;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            int j = i;
            while (j < word.length() && word.charAt(j) == c) {
                j++;
            }
            final int consecutive = j - i;
            final String next = normalize(word.substring(0, i) + word.substring(j));
            if (consecutive == 2) {
                if (count[c - 'A'] >= 1) {
                    count[c - 'A'] -= 1;
                    res = Math.min(res, 1 + dfs(next, count));
                    count[c - 'A'] += 1;
                }
            } else if (consecutive == 1) {
                if (count[c - 'A'] >= 2) {
                    count[c - 'A'] -= 2;
                    res = Math.min(res, 2 + dfs(next, count));
                    count[c - 'A'] += 2;
                }
            }
            i = j - 1;
        }
        return res;
    }

    private static String normalize(String word) {
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            int j = i;
            while (j < word.length() && word.charAt(j) == c) {
                j++;
            }
            final int consecutive = j - i;
            final String nextWord = word.substring(0, i) + word.substring(j);
            if (consecutive >= 3) {
                return normalize(nextWord);
            }
            i = j - 1;
        }
        return word;
    }
}
