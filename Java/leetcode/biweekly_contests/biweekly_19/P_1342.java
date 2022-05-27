package leetcode.biweekly_contests.biweekly_19;

public class P_1342 {

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 2 != 0) {
            return numberOfSteps(num - 1) + 1;
        }
        return numberOfSteps(num / 2) + 1;
    }
}
