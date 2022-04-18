package leetcode.biweekly_contests.biweekly_76;

public class P_2 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (long i = 0; true; i++) {
            final long curr = i * cost1;
            final long rem = total - curr;
            if (rem < 0) {
                break;
            }
            final long add = rem / cost2;
            res += add + 1;
        }
        return res;
    }
}
