package leetcode.medium;

public class P_457 {

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Integer slow = i;
            Integer fast = next(nums, 0, i);
            final int dir = nums[i] > 0 ? 1 : -1;
            while (slow != null && fast != null && !slow.equals(fast)) {
                slow = next(nums, dir, slow);
                fast = next(nums, dir, next(nums, dir, fast));
            }
            if (slow != null && slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
    private static Integer next(int[] nums, int dir, Integer pos) {
        if (pos == null || dir * nums[pos] < 0) {
            return null;
        }
        final Integer next = Math.floorMod(pos + nums[pos], nums.length);
        return next.equals(pos) ? null : next;
    }
}
