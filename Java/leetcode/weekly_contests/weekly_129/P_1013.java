package leetcode.weekly_contests.weekly_129;

public class P_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int curr = 0, count = 0;
        for (int num : A) {
            curr += num;
            if (curr == sum / 3) {
                curr = 0;
                if (++count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
