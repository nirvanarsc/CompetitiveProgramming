package leetcode.biweekly_contests.biweekly_25;

public class P_1432 {

    public int maxDiff(int num) {
        final String str = String.valueOf(num);
        final char[] chars1 = str.toCharArray();
        final char[] chars2 = str.toCharArray();
        char curr = '*';
        char sub = '*';
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == '9') {
                continue;
            }
            if (curr == '*') {
                curr = chars1[i];
                sub = '9';
            }
            if (chars1[i] == curr) {
                chars1[i] = sub;
            }
        }
        curr = '*';
        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] == '1' || chars2[i] == '0') {
                continue;
            }
            if (curr == '*') {
                curr = chars2[i];
                sub = i > 0 ? '0' : '1';
            }
            if (chars2[i] == curr) {
                chars2[i] = sub;
            }
        }
        return Integer.parseInt(new String(chars1)) - Integer.parseInt(new String(chars2));
    }
}
