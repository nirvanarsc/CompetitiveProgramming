package leetcode.weekly_contests.weekly_115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        final Map<Integer, int[]> map = new HashMap<>();
        int[] slow = cells.clone();
        int[] fast = cells.clone();
        int i = 0;
        do {
            slow = f(slow);
            fast = f(f(fast));
            map.put(i++, slow);
        } while (!Arrays.equals(slow, fast));
        return map.get((N - 1) % i);
    }

    private static int[] f(int[] arr) {
        final int[] next = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == arr[i + 1]) {
                next[i] = 1;
            }
        }
        return next;
    }

    // 01111110 - reset first and last bit
    private static final int MASK = 0x7e;

    public int[] prisonAfterNDaysBitwise(int[] cells, int N) {
        final Map<Integer, Integer> map = new HashMap<>();
        int state = 0;
        for (int i = 0; i < cells.length; i++) {
            state |= cells[i] << i;
        }
        int slow = state;
        int fast = state;
        int cycle = 0;
        do {
            slow = next(slow);
            fast = next(next(fast));
            map.put(cycle++, slow);
        } while (slow != fast);
        final int target = map.get((N - 1) % cycle);
        final int[] res = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            if ((target & (1 << i)) != 0) {
                res[i] = 1;
            }
        }
        return res;
    }

    private static int next(int state) {
        final int left = state << 1;
        final int right = state >> 1;
        return MASK & ~(left ^ right);
    }
}
