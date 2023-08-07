package leetcode.weekly_contests.weekly_300_399.weekly_350;

public class P_1 {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank >= 5) {
            res += 50;
            mainTank -= 5;
            if (additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        return res + mainTank * 10;
    }
}
