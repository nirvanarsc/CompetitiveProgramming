package weekly_contests.smarking_1;

import java.util.ArrayList;
import java.util.List;

public class P_438 {

    public List<Integer> findAnagrams(String s, String p) {
        final int[] map = new int[128];
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        int j = 0, k = p.length();
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) {
                k--;
            }
            while (k == 0) {
                if (i - j + 1 == p.length()) {
                    res.add(j);
                }
                if (++map[s.charAt(j++)] > 0) {
                    k++;
                }
            }
        }
        return res;
    }
}
