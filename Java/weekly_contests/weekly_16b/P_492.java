package weekly_contests.weekly_16b;

public class P_492 {

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) {
            sqrt--;
        }
        return new int[] { area / sqrt, sqrt };
    }
}
