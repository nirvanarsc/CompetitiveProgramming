package leetcode.medium;

public class P_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int curr = 0;
        int res = 0;
        final int n = gas.length;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                res = i + 1;
                curr = 0;
            }
        }
        return sum < 0 ? -1 : res;
    }
}
