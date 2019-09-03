import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        final Set<Integer> set = new HashSet<>();
        final int[] shorter = nums1.length > nums2.length ? nums2 : nums1;
        final int[] longer = shorter == nums1 ? nums2 : nums1;
        for (int i : longer) {
            if (contains(shorter, i)) {
                set.add(i);
            }
        }

        final int[] res = new int[set.size()];
        int i = 0;
        for (Integer k : set) {
            res[i++] = k;
        }

        return res;
    }

    private static boolean contains(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    private IntersectionOfTwoArrays() {}
}
