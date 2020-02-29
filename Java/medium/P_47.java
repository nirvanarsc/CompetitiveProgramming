package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = new ArrayList<>();
        for (int i : nums) {
            curr.add(i);
        }
        recurseSet(0, curr, res);
        return res;
    }

    private static void recurseSet(int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        final Set<Integer> seen = new HashSet<>();
        for (int k = i; k < curr.size(); k++) {
            if (!seen.contains(curr.get(k))) {
                seen.add(curr.get(k));
                Collections.swap(curr, i, k);
                recurseSet(i + 1, curr, res);
                Collections.swap(curr, i, k);
            }
        }
    }

    public List<List<Integer>> permuteUniqueNoSet(int[] nums) {
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
            if (shouldSwap(curr, i, k)) {
                Collections.swap(curr, k, i);
                recurse(i + 1, curr, res);
                Collections.swap(curr, k, i);
            }
        }
    }

    private static boolean shouldSwap(List<Integer> nums, int i, int j) {
        for (int k = i; k < j; k++) {
            if (nums.get(k).equals(nums.get(j))) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        while (!list.isEmpty()) {
            result.add(new ArrayList<>(list));
            list = nextPermutation(list);
        }
        return result;
    }

    public static List<Integer> nextPermutation(List<Integer> perm) {
        int idx = perm.size() - 2;
        while (idx >= 0 && perm.get(idx) >= perm.get(idx + 1)) {
            idx--;
        }

        if (idx == -1) {
            return Collections.emptyList();
        }

        int newIdx = perm.size() - 1;
        while (perm.get(newIdx) <= perm.get(idx)) {
            newIdx--;
        }

        Collections.swap(perm, idx, newIdx);
        Collections.reverse(perm.subList(idx + 1, perm.size()));
        return perm;
    }
}
