package weekly_contests.smarking_3;

public class P_453 {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
