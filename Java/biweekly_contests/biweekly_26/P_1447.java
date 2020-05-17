package biweekly_contests.biweekly_26;

import java.util.ArrayList;
import java.util.List;

public class P_1447 {

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public List<String> simplifiedFractions(int n) {
        final List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }
}
