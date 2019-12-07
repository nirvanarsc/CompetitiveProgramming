public final class TrappingRainWater {

    public static int trap(int[] height) {
        int res = 0, start = 0, end = height.length - 1;
        int mL = 0, mR = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                if (height[start] >= mL) {
                    mL = height[start];
                } else {
                    res += mL - height[start];
                }
                start++;
            } else {
                if (height[end] >= mR) {
                    mR = height[end];
                } else {
                    res += mR - height[end];
                }
                end--;
            }
        }

        return res;
    }

    public static int trapBruteForce(int[] height) {
        int mL, mR, res = 0;
        for (int i = 0; i < height.length; i++) {
            mL = max(0, i - 1, height);
            mR = max(i + 1, height.length - 1, height);
            res += Math.min(mL, mR) >= height[i] ? Math.min(mL, mR) - height[i] : 0;
        }
        return res;
    }

    public static int max(int begin, int end, int[] arr) {
        int max = 0;
        for (int i = begin; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(trapBruteForce(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    private TrappingRainWater() {}
}
