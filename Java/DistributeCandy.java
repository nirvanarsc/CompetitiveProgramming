import java.util.Arrays;

public final class DistributeCandy {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(90, 4)));
    }

    public static int[] distributeCandies(int candies, int n) {
        final int[] res = new int[n];
        for (int i = 0; candies > 0; ++i) {
            res[i % n] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return res;
    }

    private DistributeCandy() {}
}
