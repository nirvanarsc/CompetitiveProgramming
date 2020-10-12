package leetcode.medium;

public final class P_137 {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int curr = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    curr++;
                }
            }
            if (curr % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));
    }

    private P_137() {}
}
