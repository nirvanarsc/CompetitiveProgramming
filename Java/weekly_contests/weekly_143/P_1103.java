package weekly_contests.weekly_143;

public class P_1103 {

    public int[] distributeCandies(int candies, int num_people) {
        final int[] res = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            res[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return res;
    }
}
