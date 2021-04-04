package leetcode.biweekly_contests.biweekly_49;

public class P_1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");
        if (w1.length < w2.length) {
            final String[] temp = w1;
            w1 = w2;
            w2 = temp;
        }
        int i = 0;
        int j = 0;
        int gap = 0;
        while (i < w1.length && j < w2.length) {
            if (!w1[i].equals(w2[j])) {
                int k = i;
                while (k < w1.length && !w1[k].equals(w2[j])) {
                    k++;
                }
                i = k;
                gap++;
            } else {
                i++;
                j++;
            }
        }
        if (i != w1.length) {
            gap++;
        }
        if (j != w2.length) {
            gap++;
        }
        return gap <= 1;
    }
}
