package leetcode.weekly_contests.weekly_400_499.weekly_442;

public class P_1 {

    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
