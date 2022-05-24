package leetcode.weekly_contests.weekly_200_299.weekly_274;

public class P_2 {

    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = -1;
        for (String s : bank) {
            final int curr = f(s.toCharArray());
            if (curr == 0) {
                continue;
            }
            if (prev != -1) {
                res += prev * curr;
            }
            prev = curr;
        }
        return res;
    }

    private static int f(char[] w) {
        int res = 0;
        for (char c : w) {
            res += c - '0';
        }
        return res;
    }
}
