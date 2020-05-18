package medium;

import java.util.ArrayList;
import java.util.List;

public class P_438 {

    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> res = new ArrayList<>();
        final int[] count = new int[128];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        int matches = p.length();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                matches--;
            }
            while (matches == 0) {
                if (i - j + 1 == p.length()) {
                    res.add(j);
                }
                if (++count[s.charAt(j++)] > 0) {
                    matches++;
                }
            }
        }
        return res;
    }
}
