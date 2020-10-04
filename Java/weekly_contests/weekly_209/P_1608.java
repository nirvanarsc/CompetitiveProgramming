package weekly_contests.weekly_209;

public class P_1608 {

    public int specialArray(int[] nums) {
        for (int x = 0; x <= 1000; x++) {
            int curr = 0;
            for (int val : nums) {
                if (val >= x) {
                    curr++;
                }
            }
            if (curr == x) {
                return curr;
            }
        }
        return -1;
    }
}
