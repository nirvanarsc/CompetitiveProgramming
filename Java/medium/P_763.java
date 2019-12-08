package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_763 {

    public static List<Integer> partitionLabels(String string) {
        final List<Integer> res = new ArrayList<>();
        final int[] map = new int[26];
        int start = -1, travel = 0;

        for (int i = 0; i < string.length(); i++) {
            map[string.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < string.length(); i++) {
            final int target = map[string.charAt(i) - 'a'];
            travel = Math.max(travel, target);
            if (target == i && target == travel) {
                res.add(i - start);
                start = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    private P_763() {}
}
