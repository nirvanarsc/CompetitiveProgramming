import java.util.Arrays;

public final class NextGreaterElementI {

    public static void main(String[] args) {
        final int[] res1 = nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        final int[] res2 = nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int[] map = new int[10001];
        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }

        final int[] res = new int[nums1.length];
        int idx = 0;

        outer:
        for (int i : nums1) {
            for (int j = map[i]; j < nums2.length; j++) {
                if (i < nums2[j]) {
                    res[idx++] = nums2[j];
                    continue outer;
                }
            }
            res[idx++] = -1;
        }

        return res;
    }

    private NextGreaterElementI() {}
}
