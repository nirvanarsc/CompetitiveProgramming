package leetcode.weekly_contests.weekly_142;

public class P_1093 {

    public double[] sampleStats(int[] count) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, sum = 0, mostFreq = 0, mode = 0;
        int totalC = 0, curr = 0, mid1 = -1, mid2 = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                totalC += count[i];
                sum += count[i] * i;
                if (count[i] > mostFreq) {
                    mostFreq = count[i];
                    mode = i;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            curr += count[i];
            if (mid1 == -1 && curr >= (totalC / 2)) {
                mid1 = i;
            }
            if (mid2 == -1 && curr >= (totalC / 2) + 1) {
                mid2 = i;
            }
        }
        return new double[] { min, max, sum / totalC, totalC % 2 == 0 ? ((mid1 + mid2) / 2.0) : mid2, mode };
    }
}
