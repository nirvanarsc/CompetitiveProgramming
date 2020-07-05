package weekly_contests.weekly_196;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.BIT;

public class P_1505 {

    // O(n log n)
    public String minInteger(String num, int k) {
        final int n = num.length();
        final BIT bit = new BIT(n);
        final char[] ans = new char[n];
        final Map<Integer, Deque<Integer>> q = new HashMap<>();
        for (int i = 0; i < n; i++) {
            q.computeIfAbsent(num.charAt(i) - '0', v -> new ArrayDeque<>()).offerLast(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (q.getOrDefault(j, new ArrayDeque<>()).isEmpty()) {
                    continue;
                }
                final char c = (char) ('0' + j);
                final int e = q.get(j).getFirst();
                final int x = e + bit.query(e + 1);
                if (x <= k) {
                    q.get(j).removeFirst();
                    bit.add(e + 1, -1);
                    k -= x;
                    ans[i] = c;
                    break;
                }
            }
        }
        return new String(ans);
    }

    // O(n^2)
    public String minIntegerBF(String num, int k) {
        final char[] res = num.toCharArray();
        for (int i = 0; i < res.length; i++) {
            int idx = i;
            for (int j = 1; j <= k && i + j < res.length; j++) {
                if (res[i + j] < res[idx]) {
                    idx = i + j;
                }
                if (res[idx] == '0') {
                    break;
                }
            }
            final char temp = res[idx];
            System.arraycopy(res, i, res, i + 1, idx - i);
            res[i] = temp;
            k -= idx - i;
        }
        return String.valueOf(res);
    }
}
