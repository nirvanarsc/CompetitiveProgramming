package leetcode.weekly_contests.weekly_200_299.weekly_276;

public class P_2 {

    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1) {
            if (target % 2 != 0) {
                res++;
                target--;
            } else if (maxDoubles > 0) {
                res++;
                target /= 2;
                maxDoubles--;
            } else {
                res += target - 1;
                target = 1;
            }
        }
        return res;
    }
}
