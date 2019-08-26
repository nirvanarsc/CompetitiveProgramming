import java.util.Arrays;

public final class DuplicateZeros {

    public static void main(String[] args) {
        final int[] ints = {1, 0, 2, 3, 0, 4, 5, 0, 6, 7, 0, 8, 9};
        final int[] ints2 = {1, 0, 2, 3, 0, 4, 5, 0, 6, 7, 0, 8, 9};
        System.out.println(Arrays.toString(ints));
        duplicateZeros(ints);
        duplicateZeros2(ints2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i + 1 < arr.length) {
                shift(arr, i++);
            }
        }
    }

    private static void shift(int[] arr, int i) {
        int end = arr.length - 1;
        while (end > i + 1) {
            arr[end] = arr[--end];
        }
        arr[end] = 0;
    }

    public static void duplicateZeros2(int[] arr) {
        int countZero = 0;
        for (int value : arr) {
            if (value == 0) {
                countZero++;
            }
        }
        final int len = arr.length + countZero;

        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            }
        }
    }

    private DuplicateZeros() {
    }
}
