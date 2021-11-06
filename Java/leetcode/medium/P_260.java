package leetcode.medium;

public final class P_260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int L = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                for (int num : nums) {
                    if ((num & (1 << i)) != 0) {
                        L ^= num;
                    }
                }
                break;
            }
        }
        return new int[] { L, xor ^ L };
    }
}
