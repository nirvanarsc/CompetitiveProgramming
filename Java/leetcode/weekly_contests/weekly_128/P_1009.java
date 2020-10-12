package leetcode.weekly_contests.weekly_128;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1009 {

    public int bitwiseComplement(int N) {
        if (N == 0) { return 1; }
        int mask = ~0;
        while ((N & mask) != 0) {
            mask <<= 1;
        }
        return N ^ ~mask;
    }

    public int bitwiseComplementLib(int N) {
        if (N == 0) { return 1; }
        return (Integer.highestOneBit(N << 1) - 1) ^ N;
    }
}
