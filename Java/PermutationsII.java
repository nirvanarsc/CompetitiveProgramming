import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PermutationsII {

    public static void main(String[] args) {
        permuteUnique(new int[] { 1, 2, 1 }).forEach(System.out::println);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
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

    private PermutationsII() {}
}
