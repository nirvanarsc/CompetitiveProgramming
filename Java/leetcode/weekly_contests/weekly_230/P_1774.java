package leetcode.weekly_contests.weekly_230;

public class P_1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        final int n = toppingCosts.length * 2;
        final int[] masks = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            int cost = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    cost += toppingCosts[i % toppingCosts.length];
                }
            }
            masks[mask] = cost;
        }
        int res = (int) 1e9;
        int closest = (int) 1e9;
        for (int b : baseCosts) {
            for (int mask : masks) {
                final int abs = Math.abs(b + mask - target);
                if (abs < closest) {
                    closest = abs;
                    res = b + mask;
                } else if (abs == closest) {
                    if (b + mask < res) {
                        res = b + mask;
                    }
                }
            }
        }
        return res;
    }

    public int closestCostSubmasks(int[] baseCosts, int[] toppingCosts, int target) {
        int res = (int) 1e9;
        int closest = (int) 1e9;
        final int m = toppingCosts.length;
        final int[] costs = new int[1 << m];
        for (int mask = 0; mask < 1 << m; mask++) {
            int curr = 0;
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) != 0) {
                    curr += toppingCosts[j];
                }
            }
            costs[mask] = curr;
        }
        for (int b : baseCosts) {
            for (int mask = 0; mask < (1 << toppingCosts.length); mask++) {
                final int abs = Math.abs(b + costs[mask] - target);
                if (abs < closest) {
                    closest = abs;
                    res = b + costs[mask];
                } else if (abs == closest) {
                    if (b + costs[mask] < res) {
                        res = b + costs[mask];
                    }
                }
                for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
                    for (int i = 0; i < toppingCosts.length; i++) {
                        final int curr = b + costs[mask] + costs[subMask];
                        if (Math.abs(curr - target) < closest) {
                            closest = Math.abs(curr - target);
                            res = curr;
                        } else if (Math.abs(curr - target) == closest) {
                            if (curr < res) {
                                res = curr;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
