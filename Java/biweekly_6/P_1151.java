package biweekly_6;

public class P_1151 {

    public int minSwaps(int[] data) {
        int target = 0;
        for (int d : data) {
            target += d;
        }
        int res = Integer.MAX_VALUE, curr = 0;
        for (int j = 0; j < data.length; j++) {
            if (j >= target) {
                res = Math.min(res, curr);
                if (data[j - target] == 0) {
                    curr--;
                }
            }
            if (data[j] == 0) {
                curr++;
            }
        }
        return res;
    }
}
