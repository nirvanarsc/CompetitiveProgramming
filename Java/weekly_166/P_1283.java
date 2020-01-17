package weekly_166;

public final class P_1283 {

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = (int) 1e6;

        while (low < high) {
            final int mid = (high - low) / 2 + low;
            int sum = 0;
            for (int n : nums) {
                sum += (n + mid - 1) / mid;
            }
            if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[] { 1, 2, 5, 9 }, 6));
        System.out.println(smallestDivisor(new int[] { 2, 3, 5, 7, 11 }, 11));
        System.out.println(smallestDivisor(new int[] { 19 }, 5));
        System.out.println(smallestDivisor(new int[] { 1, 2, 3 }, 6));
        System.out.println(smallestDivisor(new int[] { 962551, 933661, 905225, 923035, 990560 }, 10));
        System.out.println(smallestDivisor(new int[] {
                46480, 71852, 4544, 23598, 962, 66567, 66601, 90661, 30701, 30463, 76184, 35590, 50634, 82516,
                3847, 83498, 40938, 82092, 17753, 21195, 3748, 94798, 77080, 49254, 24184, 81610, 80045, 69248,
                10776, 45690, 59496, 15406, 38198, 47381, 13353, 93106, 71420, 14775, 99118, 6866, 62300, 57444,
                3966, 91603, 56289, 26752, 16439, 96836, 80050, 14948, 14487, 3034, 79113, 23445, 78123, 91204,
                77022, 36837, 38978, 94389, 77331, 523, 42947, 25830, 55630, 45936, 76823, 32614, 49959, 5111,
                74080, 59558, 79203, 93414, 11356, 87885, 50858, 4490, 11503, 35141, 4446, 52051, 75511, 41767,
                64622, 61572, 28298, 21584, 77878, 99083, 47585, 75926, 84968, 12477, 86333, 55299, 99291,
                47402, 82539, 19070
        }, 549));
    }

    private P_1283() {}
}
