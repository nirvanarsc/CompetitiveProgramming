package binarysearch.weekly_43;

import java.util.HashSet;
import java.util.Set;

public class P_1 {

    public int solve(String[][] contacts) {
        final Set<String> seen = new HashSet<>();
        int res = 0;
        for (String[] contact : contacts) {
            boolean ok = true;
            for (String cc : contact) {
                ok &= seen.add(cc);
            }
            if (ok) {
                res++;
            }
        }
        return res;
    }
}
