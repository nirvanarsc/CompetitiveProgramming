package biweekly_5;

import java.util.ArrayList;
import java.util.List;

public class P_1134 {

    public boolean isArmstrong(int n) {
        int copy = n;
        final List<Integer> digits = new ArrayList<>();
        while (copy != 0) {
            digits.add(copy % 10);
            copy /= 10;
        }
        double c = 0;
        final int k = digits.size();
        for (int num : digits) {
            c += Math.pow(num, k);
        }
        return Double.compare(c, n) == 0;
    }
}
