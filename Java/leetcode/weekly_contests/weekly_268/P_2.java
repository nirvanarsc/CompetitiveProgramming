package leetcode.weekly_contests.weekly_268;

public class P_2 {

    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        final int n = plants.length;
        int curr = capacity;
        for (int i = 0; i < n; i++) {
            if (curr < plants[i]) {
                final int t = (plants[i] + capacity - 1) / capacity;
                if (plants[i] % capacity != 0) {
                    curr = capacity - plants[i] % capacity;
                } else {
                    curr = 0;
                }
                res += t * (i + i + 1);
            } else {
                curr -= plants[i];
                res += 1;
            }
        }
        return res;
    }
}
