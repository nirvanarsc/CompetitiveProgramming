package leetcode.weekly_contests.weekly_200_299.weekly_214;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_1647 {

    public int minDeletions(String s) {
        final int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        final Set<Integer> seen = new HashSet<>();
        final List<Integer> freqs = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                freqs.add(f);
            }
        }
        freqs.sort(Comparator.reverseOrder());
        int delete = 0;
        for (int f : freqs) {
            if (seen.add(f)) {
                continue;
            } else {
                int val = f - 1;
                while (val > 0 && seen.contains(val)) {
                    val--;
                }
                if (val == 0) {
                    delete += f;
                } else {
                    delete += f - val;
                    seen.add(val);
                }
            }
        }
        return delete;
    }
}
