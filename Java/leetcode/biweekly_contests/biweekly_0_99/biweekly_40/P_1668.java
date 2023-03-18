package leetcode.biweekly_contests.biweekly_0_99.biweekly_40;

public class P_1668 {

    public int maxRepeating(String sequence, String word) {
        final StringBuilder curr = new StringBuilder(word);
        int res = 0;
        while (sequence.contains(curr)) {
            curr.append(word);
            res++;
        }
        return res;
    }
}
