package leetcode.medium;

public class P_245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean turn = true;
        int w1 = -1, w2 = -1, res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    if (turn) {
                        w1 = i;
                    } else {
                        w2 = i;
                    }
                    turn ^= true;
                }
            } else {
                if (words[i].equals(word1)) { w1 = i; }
                if (words[i].equals(word2)) { w2 = i; }
            }
            if (w1 != -1 && w2 != -1) {
                res = Math.min(res, Math.abs(w1 - w2));
            }
        }
        return res;
    }
}
