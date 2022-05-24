package leetcode.weekly_contests.weekly_200_299.weekly_229;

public class P_1769 {

    public int[] minOperations(String boxes) {
        final int n = boxes.length();
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) != '0') {
                    curr += Math.abs(i - j);
                }
            }
            res[i] = curr;
        }
        return res;
    }
}
