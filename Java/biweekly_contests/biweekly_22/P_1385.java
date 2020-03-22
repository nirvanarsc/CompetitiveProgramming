package biweekly_contests.biweekly_22;

public class P_1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int num : arr1) {
            boolean allMatch = true;
            for (int num2 : arr2) {
                if (Math.abs(num - num2) <= d) {
                    allMatch = false;
                    break;
                }
            }
            if(allMatch) {
                res++;
            }
        }
        return res;
    }
}
