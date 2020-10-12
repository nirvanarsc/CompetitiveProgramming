package leetcode.weekly_contests.weekly_148;

public class P_1144 {

    public int movesToMakeZigzag(int[] nums) {
        int min1 = 0;
        int min2 = 0;
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length - 1; i++) {
            if (i % 2 == 0) {
                if (clone[i] >= clone[i + 1]) {
                    min1 += clone[i] - clone[i + 1] + 1;
                    clone[i] = clone[i + 1] - 1;
                }
            } else {
                if (clone[i] <= clone[i + 1]) {
                    min1 += clone[i + 1] - clone[i] + 1;
                    clone[i + 1] = clone[i] - 1;
                }
            }
        }
        clone = nums.clone();
        for (int i = 0; i < clone.length - 1; i++) {
            if (i % 2 == 0) {
                if (clone[i] <= clone[i + 1]) {
                    min2 += clone[i + 1] - clone[i] + 1;
                    clone[i + 1] = clone[i] - 1;
                }
            } else {
                if (clone[i] >= clone[i + 1]) {
                    min2 += clone[i] - clone[i + 1] + 1;
                    clone[i] = clone[i + 1] - 1;
                }
            }
        }
        return Math.min(min1, min2);
    }
}
