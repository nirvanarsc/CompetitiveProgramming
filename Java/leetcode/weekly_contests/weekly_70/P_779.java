package leetcode.weekly_contests.weekly_70;

public class P_779 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int kthGrammar(int N, int K) {
        int res = 0;
        for (int i = 0; i < Integer.bitCount(K - 1); i++) {
            res ^= 1;
        }
        return res;
    }
}
