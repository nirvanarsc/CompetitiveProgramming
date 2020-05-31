package biweekly_contests.biweekly_27;

import java.util.Arrays;

public class P_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
