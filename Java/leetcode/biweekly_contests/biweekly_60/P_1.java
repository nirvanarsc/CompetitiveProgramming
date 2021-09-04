package leetcode.biweekly_contests.biweekly_60;

public class P_1 {

    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if(curr == sum) {
                return i;
            }
            curr += nums[i];
        }
        return -1;
    }
}
