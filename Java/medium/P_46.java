package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P_46 {

    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(0, curr, res);
        return res;
    }

    private static void dfs(int idx, List<Integer> curr, List<List<Integer>> res) {
        if (idx == curr.size()) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = idx; i < curr.size(); i++) {
            Collections.swap(curr, i, idx);
            dfs(idx + 1, curr, res);
            Collections.swap(curr, i, idx);
        }
    }
}
