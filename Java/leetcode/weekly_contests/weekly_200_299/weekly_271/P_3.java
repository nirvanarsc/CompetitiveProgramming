package leetcode.weekly_contests.weekly_200_299.weekly_271;

public class P_3 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0;
        int r = plants.length - 1;
        int res = 0;
        int ll = capacityA;
        int rr = capacityB;
        while (l < r) {
            if (plants[l] > ll) {
                res++;
                ll = capacityA - plants[l];
            } else {
                ll -= plants[l];
            }
            if (plants[r] > rr) {
                res++;
                rr = capacityB - plants[r];
            } else {
                rr -= plants[r];
            }
            l++;
            r--;
        }
        if (l == r) {
            if (ll >= rr) {
                if (plants[l] > ll) {
                    res++;
                }
            } else {
                if (plants[r] > rr) {
                    res++;
                }
            }
        }
        return res;
    }
}
