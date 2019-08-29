import java.util.Arrays;

public final class LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[] { 2, 1, 2 }));
        System.out.println(largestPerimeter(new int[] { 1, 2, 1 }));
        System.out.println(largestPerimeter(new int[] { 3, 2, 3, 4 }));
        System.out.println(largestPerimeter(new int[] { 3, 6, 2, 3 }));
    }

    public static int largestPerimeter(int[] a) {
        Arrays.sort(a);

        for (int i = a.length - 1; i > 1; i--) {
            if (a[i] < a[i - 1] + a[i - 2]) {
                return a[i] + a[i - 1] + a[i - 2];
            }
        }

        return 0;
    }

    private LargestPerimeterTriangle() {}
}
