package leetcode.weekly_contests.weekly_200_299.weekly_237;

public class P_1835 {

    // (a & b) ^ (a & c) ^ (a & d) = a & (b ^ c ^ d)
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor = 0;
        for (int num : arr2) {
            xor ^= num;
        }
        int res = 0;
        for (int num : arr1) {
            res ^= num & xor;
        }
        return res;
    }
}
