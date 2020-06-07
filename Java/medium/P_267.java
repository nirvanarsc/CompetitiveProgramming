package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_267 {

    public List<String> generatePalindromes(String s) {
        int odds = 0;
        final int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (int freq : map) {
            odds += freq % 2;
        }
        if (odds > 1) {
            return Collections.emptyList();
        }
        char odd = '#';
        final char[] chars = new char[s.length() / 2];
        int idx = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0) {
                odd = (char) i;
            }
            for (int j = 0; j < map[i] / 2; j++) {
                chars[idx++] = (char) i;
            }
        }
        final List<String> res = new ArrayList<>();
        for (String w : permuteUnique(chars)) {
            res.add(w + (odd == '#' ? "" : odd) + new StringBuilder(w).reverse());
        }
        return res;
    }

    public List<String> permuteUnique(char[] nums) {
        final List<String> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new StringBuilder(), res);
        return res;
    }

    public void dfs(char[] nums, boolean[] used, StringBuilder curr, List<String> res) {
        if (curr.length() == nums.length) {
            res.add(new String(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) { continue; }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) { continue; }
            curr.append(nums[i]);
            used[i] = true;
            dfs(nums, used, curr, res);
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
