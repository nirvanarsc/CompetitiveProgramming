package hard;

import java.util.ArrayList;
import java.util.List;

public class P_282 {

    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        final char[] nums = num.toCharArray();
        final char[] sb = new char[2 * num.length()];
        long curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = curr * 10 + (nums[i] - '0');
            sb[i] = nums[i];
            dfs(nums, i + 1, target, curr, curr, sb, i + 1);
            if (curr == 0) {
                break;
            }
        }
        return res;
    }

    private void dfs(char[] num, int idx, long tar, long val, long pre, char[] sb, int len) {
        if (idx == num.length && tar == val) {
            res.add(new String(sb, 0, len));
        }
        long curr = 0;
        int j = len + 1;
        for (int i = idx; i < num.length; i++) {
            curr = curr * 10 + (num[i] - '0');
            if (curr < 10 && i > idx) {
                break;
            }
            sb[j++] = num[i];
            sb[len] = '+';
            dfs(num, i + 1, tar, val + curr, curr, sb, j);
            sb[len] = '-';
            dfs(num, i + 1, tar, val - curr, -curr, sb, j);
            sb[len] = '*';
            dfs(num, i + 1, tar, val - pre + pre * curr, pre * curr, sb, j);
        }
    }
}
