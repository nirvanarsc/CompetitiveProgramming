package weekly_contests.weekly_205;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class P_1576 {

    public String modifyString(String s) {
        final char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if (i > 0 && arr[i - 1] == c) { continue; }
                    if (i + 1 < arr.length && arr[i + 1] == c) { continue; }
                    arr[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

    public String modifyStringBF(String s) {
        final int n = s.length();
        final char[] res = s.toCharArray();
        final List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int end = i;
                while (end < s.length() && s.charAt(end) == '?') {
                    end++;
                }
                intervals.add(new int[] { i, end - 1 });
                i = end - 1;
            }
        }
        for (int[] interval : intervals) {
            Set<Character> set = getAll();
            final int l = interval[0] - 1;
            final int r = interval[1] + 1;
            if (l >= 0) {
                set.remove(res[l]);
            }
            if (r < n) {
                set.remove(res[r]);
            }
            Iterator<Character> iterator = set.iterator();
            for (int i = interval[0]; i <= interval[1]; i++) {
                if (!iterator.hasNext()) {
                    set = getAll();
                    set.remove(res[i - 1]);
                    if (r < n) {
                        set.remove(res[r]);
                    }
                    iterator = set.iterator();
                }
                res[i] = iterator.next();
            }
        }
        return new String(res);
    }

    private static Set<Character> getAll() {
        final Set<Character> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            set.add(c);
        }
        return set;
    }
}
