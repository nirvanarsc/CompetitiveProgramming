package leetcode.biweekly_contests.biweekly_19;

public class P_1342 {

    public int numberOfSteps(int num) {
        if (num <= 1) {
            return num;
        }
        return numberOfSteps(num / 2) + 1 + num % 2;
    }
}
