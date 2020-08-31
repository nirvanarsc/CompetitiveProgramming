package medium;

public class P_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int curr = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                res = i + 1;
                curr = 0;
            }
        }
        return (totalGas < totalCost) ? -1 : res;
    }
}
