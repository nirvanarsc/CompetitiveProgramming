package leetcode.weekly_contests.weekly_130;

public class P_1017 {

    public String base2(int N) {
        final StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N >>= 1;
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public String baseNeg2(int N) {
        final StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N = -(N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }
}
