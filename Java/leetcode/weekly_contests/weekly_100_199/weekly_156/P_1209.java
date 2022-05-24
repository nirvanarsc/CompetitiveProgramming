package leetcode.weekly_contests.weekly_100_199.weekly_156;

public class P_1209 {

    public String removeDuplicates(String s, int k) {
        final int[] stack = new int[(int) (1e5 + 5)];
        final int[] count = new int[(int) (1e5 + 5)];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            idx = removeK(k, count, idx);
            if (idx > 0 && stack[idx - 1] == s.charAt(i)) {
                count[idx - 1]++;
            } else {
                stack[idx] = s.charAt(i);
                count[idx++] = 1;
            }
        }
        idx = removeK(k, count, idx);
        final StringBuilder sb = new StringBuilder();
        while (idx > 0) {
            final char c = (char) stack[idx - 1];
            final int times = count[--idx];
            //noinspection StringRepeatCanBeUsed
            for (int i = 0; i < times; i++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    private static int removeK(int k, int[] count, int idx) {
        while (idx > 0 && count[idx - 1] >= k) {
            count[idx - 1] -= k;
            if (count[idx - 1] == 0) {
                idx--;
            }
        }
        return idx;
    }
}
