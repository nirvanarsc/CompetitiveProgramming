package leetcode.weekly_contests.weekly_129;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1015 {

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int curr = 0;
        for (int l = 1; l < (int) (1e5 + 5); l++) {
            curr = ((curr * 10) + 1) % K;
            if (curr == 0) {
                return l;
            }
        }
        return -1;
    }
}
