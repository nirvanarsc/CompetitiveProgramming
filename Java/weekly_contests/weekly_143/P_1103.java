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

    public static int[] distributeCandiesMath(int candies, int num_people) {
        final int end = (int) (1 + Math.sqrt(1L + 8L * candies)) / 2 - 1;
        final int last = candies - (end * (end + 1)) / 2;
        final int fullRounds = end / num_people;
        final int lastRound = end % num_people;
        final int[] res = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            if (i < lastRound) {
                res[i] = getArithmeticSum(fullRounds + 1, i + 1, num_people);
            } else if (i == lastRound) {
                res[i] = getArithmeticSum(fullRounds, i + 1, num_people) + last;
            } else {
                res[i] = getArithmeticSum(fullRounds, i + 1, num_people);
            }
        }
        return res;
    }

    private static int getArithmeticSum(int terms, int firstTerm, int d) {
        return (terms * (2 * firstTerm + (terms - 1) * d)) / 2;
    }
}
