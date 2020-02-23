package weekly_177;

public class P_1362 {

    public int[] closestDivisors(int num) {
        final int[] res1 = findMinProductDiff(num + 1);
        final int[] res2 = findMinProductDiff(num + 2);
        if (Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1])) {
            return res1;
        }
        return res2;
    }

    private static int[] findMinProductDiff(int num) {
        int sqrt = (int) Math.sqrt(num);
        while (num % sqrt != 0) {
            sqrt--;
        }
        return new int[] { sqrt, num / sqrt };
    }
}
