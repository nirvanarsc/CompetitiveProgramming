package biweekly_contests.biweekly_24;

import java.util.ArrayList;
import java.util.List;

public class P_1415 {

    public String getHappyString(int n, int k) {
        final List<String> list = new ArrayList<>();
        gen(list, "", n);
        return k > list.size() ? "" : list.get(k - 1);
    }

    private static void gen(List<String> res, String curr, int n) {
        if (curr.length() == n) {
            res.add(curr);
            return;
        }
        for (char c : new char[] { 'a', 'b', 'c' }) {
            if (curr.isEmpty() || curr.charAt(curr.length() - 1) != c) {
                gen(res, curr + c, n);
            }
        }
    }
}
