import java.util.Arrays;

public final class HeightChecker {

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
    }

    public static int heightChecker(int[] heights) {
        int res = 0;
        final int length = heights.length;
        final int[] copy = Arrays.copyOf(heights, length);
        Arrays.sort(copy);
        for (int i = 0; i < length; i++) {
            if (heights[i] != copy[i]) {
                res++;
            }
        }
        return res;
    }

    private HeightChecker() {}
}
