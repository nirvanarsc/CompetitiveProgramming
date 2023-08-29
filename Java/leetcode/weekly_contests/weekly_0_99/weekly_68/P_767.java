package leetcode.weekly_contests.weekly_0_99.weekly_68;

import java.util.PriorityQueue;

public class P_767 {

    public String reorganizeString(String s) {
        final char[] w = s.toCharArray();
        final int[] freq = new int[26];
        for (char c : w) {
            freq[c - 'a']++;
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            pq.offer(new int[] { i, freq[i] });
        }
        final int n = w.length;
        final char[] res = new char[n];
        int idx = 0;
        while (!pq.isEmpty()) {
            final int[] pop = pq.remove();
            final char c = (char) (pop[0] + 'a');
            for (int i = 0; i < pop[1]; i++, idx += 2) {
                if (idx >= n) {
                    idx = 1;
                }
                res[idx] = c;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (res[i] == res[i + 1]) {
                return "";
            }
        }
        return new String(res);
    }
}
