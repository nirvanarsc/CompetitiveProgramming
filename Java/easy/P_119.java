package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class P_119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(Collections.singletonList(1));
        for (int i = 1; i <= rowIndex; i++) {
            final List<Integer> next = new ArrayList<>();
            for (int k = 0; k < i + 1; k++) {
                final int upLeft = k == 0 ? 0 : row.get(k - 1);
                final int up = k == i ? 0 : row.get(k);
                next.add(upLeft + up);
            }
            row = next;

        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    private P_119() {}
}
