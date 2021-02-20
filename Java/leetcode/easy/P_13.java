package leetcode.easy;

public class P_13 {

    public int romanToInt(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || map[w[i + 1] - 'A'] <= map[w[i] - 'A']) {
                res += map[w[i] - 'A'];
            } else {
                res -= map[w[i] - 'A'];
            }
        }
        return res;
    }
}
