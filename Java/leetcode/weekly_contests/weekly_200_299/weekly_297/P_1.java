package leetcode.weekly_contests.weekly_200_299.weekly_297;

public class P_1 {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int take = Math.min(income, brackets[0][0]);
        income -= take;
        res += (take * brackets[0][1]) / 100.0;
        for (int i = 1; i < brackets.length; i++) {
            take = Math.min(income, brackets[i][0] - brackets[i - 1][0]);
            income -= take;
            res += (take * brackets[i][1]) / 100.0;
        }
        return res;
    }
}
