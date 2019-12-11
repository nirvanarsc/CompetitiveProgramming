package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class P_46 {

    public static List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = new ArrayList<>();
        for (int i : nums) {
            curr.add(i);
        }
        recurse(0, curr, res);
        return res;
    }

    private static void recurse(int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int k = i; k < curr.size(); k++) {
            Collections.swap(curr, i, k);
            recurse(i + 1, curr, res);
            Collections.swap(curr, i, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }

    private P_46() {}
}
