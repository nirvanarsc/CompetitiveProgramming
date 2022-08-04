package leetcode.weekly_contests.weekly_0_99.weekly_90;

public class P_858 {

    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p % 2 == 0) {
            return 2;
        }
        if (q % 2 == 0) {
            return 0;
        }
        return 1;
    }
}
