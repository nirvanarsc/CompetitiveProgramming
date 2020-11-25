package binarysearch.weekly_34;

public class P_1 {

    public String solve(String s) {
        final char[] res = s.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') {
                final boolean[] available = new boolean[3];
                if (i > 0) {
                    available[res[i - 1] - '1'] = true;
                }
                if (i < (res.length - 1) && res[i + 1] != '?') {
                    available[res[i + 1] - '1'] = true;
                }
                for (int j = 0; j < available.length; j++) {
                    if (!available[j]) {
                        res[i] = (char) (j + '1');
                        break;
                    }
                }
            }
        }
        return new String(res);
    }
}
