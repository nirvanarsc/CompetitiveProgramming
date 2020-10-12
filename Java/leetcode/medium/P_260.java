package leetcode.medium;

public final class P_260 {

    public int[] singleNumber(int[] nums) {
        int targetXor = 0, first = 0, second = 0;
        for (int num : nums) {
            targetXor ^= num;
        }

        final int i = Integer.lowestOneBit(targetXor);

        for (int num : nums) {
            if ((num & i) != 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[] { first, second };
    }
}
