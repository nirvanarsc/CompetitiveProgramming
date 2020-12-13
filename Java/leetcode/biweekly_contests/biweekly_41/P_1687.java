package leetcode.biweekly_contests.biweekly_41;

public class P_1687 {

    // TODO revisit
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        final int n = boxes.length;
        final int[] dp = new int[n + 1];
        int sum = 0;
        int start = 0;
        int diff = 0;
        final boolean[] consecutive = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            if (boxes[i][0] != boxes[i + 1][0]) { consecutive[i] = true; }
        }
        for (int i = 0; i < n; i++) {
            if (i - start == maxBoxes) {
                sum -= boxes[start][1];
                if (consecutive[start]) { diff--; }
                start++;
            }
            sum += boxes[i][1];
            if (i > 0 && consecutive[i - 1]) { diff++; }
            while (sum > maxWeight) {
                sum -= boxes[start][1];
                if (consecutive[start]) { diff--; }
                start++;
            }
            while (start < i && dp[start] == dp[start + 1]) {
                sum -= boxes[start][1];
                if (consecutive[start]) { diff--; }
                start++;
            }
            dp[i + 1] = diff + 2 + dp[start];
        }
        return dp[n];
    }
}
