package leetcode.weekly_contests.weekly_200_299.weekly_264;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public int countValidWords(String sentence) {
        final List<String> list = new ArrayList<>();
        final int n = sentence.length();
        final char[] w = sentence.toCharArray();
        for (int i = 0; i < n; i++) {
            if (w[i] != ' ') {
                int j = i;
                while (j < n && w[j] != ' ') {
                    j++;
                }
                list.add(sentence.substring(i, j));
                i = j - 1;
            }
        }
        int res = 0;
        for (String word : list) {
            if (f(word.toCharArray())) {
                res++;
            }
        }
        return res;
    }

    private static boolean f(char[] w) {
        int hyp = -1;
        int dig = 0;
        int pun = -1;
        final int n = w.length;
        for (int i = 0; i < n; i++) {
            if ('0' <= w[i] && w[i] <= '9') {
                dig++;
            } else if (w[i] == '-') {
                if (hyp != -1) {
                    return false;
                }
                hyp = i;
            } else if (w[i] == '!' || w[i] == '.' || w[i] == ',') {
                if (pun != -1) {
                    return false;
                }
                pun = i;
            }
        }
        return dig == 0
               && (pun == -1 || pun == (n - 1))
               && (hyp == -1 || (0 < hyp && hyp < (n - 1) && isLetter(w[hyp - 1]) && isLetter(w[hyp + 1])));
    }

    private static boolean isLetter(char c) {
        return 'a' <= c && c <= 'z';
    }
}
