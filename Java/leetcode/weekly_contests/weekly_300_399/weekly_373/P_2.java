package leetcode.weekly_contests.weekly_300_399.weekly_373;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class P_2 {

    public int beautifulSubstrings(String s, int k) {
        int l = 1;
        while ((l * l) % (k * 4) != 0) {
            l++;
        }
        final int n = s.length();
        final String vowels = "aeiou";
        final Map<Integer, Integer>[] seen = new HashMap[l];
        for (int i = 0; i < l; i++) {
            seen[i] = new HashMap<>();
        }
        seen[0].put(0, 1);
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += vowels.indexOf(s.charAt(i)) != -1 ? 1 : -1;
            res += seen[(i + 1) % l].getOrDefault(curr, 0);
            seen[(i + 1) % l].merge(curr, 1, Integer::sum);
        }
        return res;
    }
}
