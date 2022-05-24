package leetcode.weekly_contests.weekly_200_299.weekly_219;

public class P_1689 {

    public int minPartitions(String n) {
        int res = 0;
        for (char c: n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }
}
