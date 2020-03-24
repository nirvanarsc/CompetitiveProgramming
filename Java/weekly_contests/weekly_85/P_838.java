package weekly_contests.weekly_85;

public class P_838 {

    public String pushDominoes(String dominoes) {
        int i = 0;
        final char[] chars = dominoes.toCharArray();
        final int n = chars.length;
        while (i < n) {
            if (chars[i] == 'L') {
                int j = i - 1;
                while (j >= 0 && chars[j] == '.') {
                    chars[j] = 'L';
                    --j;
                }
                ++i;
            } else if (chars[i] == 'R') {
                int j = i + 1;
                while (j < n && chars[j] == '.') {
                    j++;
                }
                if (j == n || chars[j] == 'R') {
                    while (i < j) {
                        chars[i] = 'R';
                        ++i;
                    }
                } else {
                    final int t = j;
                    while (i < j) {
                        chars[i] = 'R';
                        chars[j] = 'L';
                        ++i;
                        --j;
                    }
                    i = t + 1;
                }
            } else {
                ++i;
            }
        }
        return new String(chars);
    }
}
