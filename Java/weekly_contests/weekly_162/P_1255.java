package weekly_contests.weekly_162;

public class P_1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        final int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        final int[] res = { Integer.MIN_VALUE };
        recurse(words, 0, freq, score, res, 0);
        return res[0];
    }

    private static void recurse(String[] words, int i, int[] chars, int[] score, int[] res, int curr) {
        if (i == words.length) {
            res[0] = Math.max(res[0], curr);
            return;
        }

        final int[] currWord = new int[26];
        for (char c : words[i].toCharArray()) {
            currWord[c - 'a']++;
        }
        boolean containsWord = true;
        for (int j = 0; j < 26; j++) {
            if (chars[j] < currWord[j]) {
                containsWord = false;
                break;
            }
        }
        if (containsWord) {
            int addScore = 0;
            for (int j = 0; j < 26; j++) {
                chars[j] -= currWord[j];
                addScore += currWord[j] * score[j];
            }
            recurse(words, i + 1, chars, score, res, addScore + curr);
            for (int j = 0; j < 26; j++) {
                chars[j] += currWord[j];
            }
        }
        recurse(words, i + 1, chars, score, res, curr);
    }
}
