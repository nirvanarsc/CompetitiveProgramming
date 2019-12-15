package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class P_89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(Collections.singletonList(0));
        for (int i = 1; i <= n; i++) {
            final List<Integer> curr = new ArrayList<>(list);
            Collections.reverse(list);
            for (int t : list) {
                t |= 1 << (i - 1);
                curr.add(t);
            }
            list = curr;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    private P_89() {}
}
