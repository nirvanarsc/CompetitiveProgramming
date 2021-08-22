package leetcode.weekly_contests.weekly_255;

public class P_2 {

    public String findDifferentBinaryString(String[] nums) {
        final int n = nums.length;
        final boolean[] seen = new boolean[1 << n];
        for (String s : nums) {
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    mask |= 1 << i;
                }
            }
            seen[mask] = true;
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            if (!seen[mask]) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }
}
