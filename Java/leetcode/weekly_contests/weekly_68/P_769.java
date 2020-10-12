package leetcode.weekly_contests.weekly_68;

public class P_769 {

    public int maxChunksToSorted(int[] arr) {
        for (int i = 0, currMax = 0, res = 0; true; i++) {
            if (i == arr.length) {
                return res;
            }
            currMax = Math.max(currMax, arr[i]);
            if (currMax == i) {
                res++;
            }
        }
    }
}
