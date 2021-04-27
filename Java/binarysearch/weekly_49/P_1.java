package binarysearch.weekly_49;

public class P_1 {

    public boolean solve(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                boolean ok = true;
                for (int j = i, k = 0; k < nums.length; j++, k++) {
                    if (nums[j % nums.length] != k + 1) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
                ok = true;
                for (int j = i, k = 0; k < nums.length; j--, k++) {
                    if (nums[(j + nums.length) % nums.length] != k + 1) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
