package leetcode.weekly_contests.weekly_129;

public class P_1015 {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int res = 1;
        for (int curr = 1; curr % k != 0; res++) {
            curr = (curr * 10 + 1) % k;
        }
        return res;
    }
}
