public final class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        final int globalMid = (nums1.length + nums2.length + 1) / 2;
        int lowA = 0;
        int highA = nums1.length;

        while (lowA <= highA) {
            final int midA = (lowA + highA) >>> 1;
            final int midB = globalMid - midA;

            final int maxLeftX = (midA == 0) ? Integer.MIN_VALUE : nums1[midA - 1];
            final int minRightX = (midA == nums1.length) ? Integer.MAX_VALUE : nums1[midA];

            final int maxLeftY = (midB == 0) ? Integer.MIN_VALUE : nums2[midB - 1];
            final int minRightY = (midB == nums2.length) ? Integer.MAX_VALUE : nums2[midB];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return 0.5 * (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY));
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                highA = midA - 1;
            } else {
                lowA = midA + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 3, 8, 9, 15 },
                                                  new int[] { 7, 11, 18, 19, 21, 25 }));
    }

    private MedianTwoSortedArrays() {}
}
