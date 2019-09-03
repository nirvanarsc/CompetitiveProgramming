public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, curr = 0;

        for (int i : nums) {
            if (i == 0) {
                res = Math.max(curr, res);
                curr = 0;
            } else {
                curr++;
            }
        }

        return Math.max(curr, res);
    }
}
