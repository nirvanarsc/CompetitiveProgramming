package leetcode.biweekly_contests.biweekly_0_99.biweekly_49;

public class P_1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        final String[] l = sentence1.split(" ");
        final String[] r = sentence2.split(" ");
        int start = 0;
        int end1 = l.length - 1;
        int end2 = r.length - 1;
        if (l.length > r.length) {
            //noinspection TailRecursion
            return areSentencesSimilar(sentence2, sentence1);
        }
        while (start < l.length && l[start].equals(r[start])) {
            start++;
        }
        while (end1 >= 0 && l[end1].equals(r[end2])) {
            end1--;
            end2--;
        }
        return end1 < start;
    }
}
