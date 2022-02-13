package leetcode.weekly_contests.weekly_280;

public class P_1 {

    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            res++;
        }
        return res;
    }
}
