package pramp;

import java.util.Arrays;

public final class ArrayQuadruplet {

    public static final int[] EMPTY_ARRAY = new int[0];

    private static int[] findArrayQuadruplet(int[] arr, int s) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            final int[] ints = threeSum(arr, s - arr[i], i);
            if (ints.length > 0) {
                return new int[] { arr[i], ints[0], ints[1], ints[2] };
            }
        }
        return EMPTY_ARRAY;
    }

    private static int[] twoSum(int[] arr, int s, int ignoreIdx1, int ignoreIdx2) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (start == ignoreIdx1 || start == ignoreIdx2) {
                start++;
                continue;
            }
            if (end == ignoreIdx1 || end == ignoreIdx2) {
                end--;
                continue;
            }
            if (arr[start] + arr[end] > s) {
                end--;
            } else if (arr[start] + arr[end] == s) {
                return new int[] { arr[start], arr[end] };
            } else {
                start++;
            }
        }

        return EMPTY_ARRAY;
    }

    private static int[] threeSum(int[] arr, int s, int ignoreIdx) {
        for (int i = 0; i < arr.length; i++) {
            if (i == ignoreIdx) { continue; }
            final int[] ints = twoSum(arr, s - arr[i], ignoreIdx, i);
            if (ints.length > 0) {
                return new int[] { arr[i], ints[0], ints[1] };
            }
        }
        return EMPTY_ARRAY;
    }

    private static int[] fourSum(int[] arr, int s) {
        if (arr.length < 4) {
            return EMPTY_ARRAY;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                final int findTwoSum = s - (arr[i] + arr[j]);
                int start = j + 1;
                int end = arr.length - 1;
                while (start < end) {
                    if (arr[start] + arr[end] > findTwoSum) {
                        end--;
                    } else if (arr[start] + arr[end] == findTwoSum) {
                        return new int[] { arr[i], arr[j], arr[start], arr[end] };
                    } else {
                        start++;
                    }
                }
            }
        }

        return EMPTY_ARRAY;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[] { 4, 4, 4, 2 }, 16)));
        System.out.println(Arrays.toString(fourSum(new int[] { 2, 7, 4, 0, 9, 5, 1, 3 }, 20)));
    }
}
