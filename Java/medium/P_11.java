package medium;

public final class P_11 {

    public static int maxArea(int[] height) {
        int start = 0, end = height.length - 1, res = 0;
        while (start < end) {
            res = Math.max(res, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    private P_11() {}
}
