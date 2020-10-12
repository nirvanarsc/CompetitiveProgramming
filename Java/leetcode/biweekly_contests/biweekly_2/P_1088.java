package leetcode.biweekly_contests.biweekly_2;

import java.util.HashMap;
import java.util.Map;

public class P_1088 {

    private static final char[][] pairs =
            { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
    private static final int[] DIGITS = { 0, 1, 6, 8, 9 };
    private static final Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    public int confusingNumberII(int n) {
        final String nStr = Integer.toString(n);
        final int[] res = { getTotalNum(nStr) };
        for (int i = 1; i <= nStr.length(); i++) {
            dfs(new char[i], nStr, 0, i - 1, res);
        }
        return res[0];
    }

    private static void dfs(char[] curr, String num, int left, int right, int[] res) {
        if (left > right) {
            if (curr.length < num.length() || new String(curr).compareTo(num) <= 0) {
                res[0]--;
            }
        } else {
            for (char[] pair : pairs) {
                curr[left] = pair[0];
                curr[right] = pair[1];
                if (left == right && pair[0] != pair[1]) { continue; }
                if (curr[0] == '0' && curr.length > 1) { continue; }
                dfs(curr, num, left + 1, right - 1, res);
            }
        }
    }

    private static int getTotalNum(String str) {
        if (str.isEmpty()) { return 1; }
        int tempRes = count(str.charAt(0)) * (int) Math.pow(5, str.length() - 1);
        final char first = str.charAt(0);
        if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
            tempRes += getTotalNum(str.substring(1));
        }
        return tempRes;
    }

    private static int count(char c) {
        int count = 0;
        for (char[] pair : pairs) {
            if (c > pair[0]) {
                count++;
            }
        }
        return count;
    }

    public int confusingNumberIIBF(int n) {
        final int[] res = { n == 1000000000 ? 1 : 0 };
        recurse(0, n, 0, res);
        return res[0];
    }

    public static boolean isConfusing(int n) {
        long res = 0;
        int copy = n;
        while (copy != 0) {
            res = res * 10 + map.get(copy % 10);
            copy /= 10;
        }
        return n != res;
    }

    private static void recurse(int num, int limit, int p, int[] res) {
        if (p > 9 || num > limit) { return; }
        if (isConfusing(num)) { res[0]++; }

        for (int d : DIGITS) {
            if (p == 0 && d == 0) { continue; }
            recurse((num * 10) + d, limit, p + 1, res);
        }
    }
}
