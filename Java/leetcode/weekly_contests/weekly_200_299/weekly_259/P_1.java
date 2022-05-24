package leetcode.weekly_contests.weekly_200_299.weekly_259;

public class P_1 {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations) {
            if (op.contains("+")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
