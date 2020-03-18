package weekly_contests.weekly_93;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_868 {

    @SuppressWarnings("StatementWithEmptyBody")
    public int binaryGapString(int N) {
        final String str = Integer.toBinaryString(N);
        int i = -1, res = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '1') {
                if (i != -1) {
                    while (str.charAt(i++) != '1') { }
                    res = Math.max(res, j - i + 1);
                } else {
                    i = 0;
                }
            }
        }
        return res;
    }

    public int binaryGap(int N) {
        int max = 0, last = -1;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (((N >> i) & 1) == 1) {
                if (last >= 0) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
}
