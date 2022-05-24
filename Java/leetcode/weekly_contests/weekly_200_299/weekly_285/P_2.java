package leetcode.weekly_contests.weekly_200_299.weekly_285;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public int countCollisions(String directions) {
        int n = directions.length();
        final char[] w = directions.toCharArray();
        final List<Integer> count = new ArrayList<>();
        final List<Character> chars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            count.add(j - i);
            chars.add(w[i]);
            i = j - 1;
        }
        n = count.size();
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (chars.get(i - 1) == 'R' && chars.get(i) == 'L') {
                res += count.get(i - 1) + count.get(i);
                i++;
            } else if (chars.get(i - 1) == 'R' && chars.get(i) == 'S') {
                res += count.get(i - 1);
            } else if (chars.get(i - 1) == 'S' && chars.get(i) == 'L') {
                res += count.get(i);
            }
        }
        return res;
    }
}
