package leetcode.biweekly_contests.biweekly_19;

public class P_1342 {

    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                num--;
            } else {
                num >>= 1;
            }
            step++;
        }
        return step;
    }
}
