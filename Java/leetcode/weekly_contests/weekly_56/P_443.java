package leetcode.weekly_contests.weekly_56;

public class P_443 {

    public int compress(char[] chars) {
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            int k = i;
            while (k < chars.length && chars[i] == chars[k]) {
                count++;
                k++;
            }
            chars[j++] = chars[i];
            if (count > 1) {
                final String c = String.valueOf(count);
                for (int l = 0; l < c.length(); l++) {
                    chars[j++] = c.charAt(l);
                }
                i = k - 1;
            }
        }
        return j;
    }
}
