package leetcode.weekly_contests.weekly_200_299.weekly_200;

public class P_1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    final int currA = Math.abs(arr[i] - arr[j]);
                    final int currB = Math.abs(arr[j] - arr[k]);
                    final int currC = Math.abs(arr[i] - arr[k]);
                    if (currA <= a && currB <= b && currC <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
