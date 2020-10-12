package leetcode.weekly_contests.weekly_209;

public class P_1611 {

    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        final int highest = Integer.highestOneBit(n);
        final int cost = (highest << 1) - 1;
        return cost - minimumOneBitOperations(n ^ highest);
    }
}
