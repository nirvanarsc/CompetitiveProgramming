package weekly_contests.weekly_153;

public class P_1186 {

    public int maximumSum(int[] arr) {
        int del = arr[0], res = arr[0], keep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            del = Math.max(keep, del + arr[i]);
            keep = Math.max(keep + arr[i], arr[i]);
            res = Math.max(res, Math.max(del, keep));
        }
        return res;
    }
}
