package leetcode.weekly_contests.weekly_100_199.weekly_106;

public class P_922 {

    public int[] sortArrayByParityII(int[] nums) {
        final int n = nums.length;
        final int[] map = new int[1001];
        for (int num : nums) {
            map[num]++;
        }
        int even = 0;
        int odd = 1;
        for (int i = 0; i < n; i += 2) {
            while (map[even] == 0) { even += 2; }
            nums[i] = even;
            map[even]--;
        }
        for (int i = 1; i < n; i += 2) {
            while (map[odd] == 0) { odd += 2; }
            nums[i] = odd;
            map[odd]--;
        }
        return nums;
    }
}
