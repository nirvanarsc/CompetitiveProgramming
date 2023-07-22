package leetcode.biweekly_contests.biweekly_100_199.biweekly_109;

import java.util.PriorityQueue;

public class P_2 {

    public String sortVowels(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final char[] res = new char[n];
        final PriorityQueue<Character> pq = new PriorityQueue<>(Character::compare);
        for (int i = 0; i < n; i++) {
            if ("aeiouAEIOU".indexOf(w[i]) != -1) {
                pq.offer(w[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if ("aeiouAEIOU".indexOf(w[i]) != -1) {
                res[i] = pq.remove();
            } else {
                res[i] = w[i];
            }
        }
        return new String(res);
    }
}
