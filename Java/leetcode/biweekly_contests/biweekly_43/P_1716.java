package leetcode.biweekly_contests.biweekly_43;

public class P_1716 {

    public int totalMoney(int n) {
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                curr++;
            }
            res += curr + (i % 7);
        }
        return res;
    }
}
