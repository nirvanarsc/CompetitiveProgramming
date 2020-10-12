package leetcode.weekly_contests.weekly_27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_556 {

    public int nextGreaterElement(int n) {
        final List<Integer> list = new ArrayList<>();
        for (char c : String.valueOf(n).toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        final List<Integer> next = nextPermutation(list);
        if (next.isEmpty()) {
            return -1;
        }
        final long reduce = next.stream().mapToLong(Integer::intValue).reduce(0L, (a, b) -> a * 10 + b);
        return reduce <= Integer.MAX_VALUE ? (int) reduce : -1;
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
