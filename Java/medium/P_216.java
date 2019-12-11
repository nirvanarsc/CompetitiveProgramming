package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> res = new ArrayList<>();
        recurse(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void recurse(int start, int target, int k, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= 9 && target >= i; i++) {
            curr.add(i);
            recurse(i + 1, target - i, k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }

    private P_216() {}
}
