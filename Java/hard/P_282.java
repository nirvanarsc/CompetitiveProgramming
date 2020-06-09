package hard;

import java.util.ArrayList;
import java.util.List;

public class P_282 {

    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        backtrack(num.toCharArray(), 0, target, 0, 0, new char[2 * num.length()], 0);
        return res;
    }

    private void backtrack(char[] num, int idx, long tar, long val, long pre, char[] sb, int len) {
        if (idx == num.length && tar == val) {
            res.add(new String(sb, 0, len));
        }
        int j = idx == 0 ? len : len + 1;
        long curr = 0;
        for (int i = idx; i < num.length; i++) {
            curr = curr * 10 + (num[i] - '0');
            if (curr < 10 && i > idx) {
                break;
            }
            sb[j++] = num[i];
            if (idx == 0) {
                backtrack(num, i + 1, tar, val + curr, curr, sb, j);
                continue;
            }
            sb[len] = '+';
            backtrack(num, i + 1, tar, val + curr, curr, sb, j);
            sb[len] = '-';
            backtrack(num, i + 1, tar, val - curr, -curr, sb, j);
            sb[len] = '*';
            backtrack(num, i + 1, tar, val - pre + pre * curr, pre * curr, sb, j);
        }
    }
}
