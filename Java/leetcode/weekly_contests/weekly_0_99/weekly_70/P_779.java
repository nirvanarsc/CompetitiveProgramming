package leetcode.weekly_contests.weekly_0_99.weekly_70;

public class P_779 {

    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) % 2;
    }
}
