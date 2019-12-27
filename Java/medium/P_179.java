package medium;

import java.util.Arrays;

public class P_179 {

    public String largestNumber(int[] nums) {
        final StringBuilder sb = new StringBuilder();
        final String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (y + x).compareTo(x + y));
        for (String str : strings) {
            sb.append(str);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
