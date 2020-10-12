package codeforces.educational_87;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int q = in.nextInt();
        in.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            list.add(in.nextInt());
        }
        in.nextLine();
        for (int t = 0; t < q; t++) {
            int i = in.nextInt();
            if (i < 0) {
                list.remove(findKthLargest(list, list.size() + i + 1));
            } else {
                list.add(i);
            }
        }
        System.out.println(list.isEmpty() ? 0 : list.get(0));
    }

    public static int findKthLargest(List<Integer> nums, int k) {
        return select(nums, k - 1);
    }

    // Quick Select
    private static int select(List<Integer> nums, int k) {
        int left = 0, right = nums.size() - 1;
        while (true) {
            if (left == right) {
                return left;
            }
            int pivotIndex = medianOf3(nums, left, right);
            pivotIndex = partition(nums, left, right, pivotIndex);
            if (pivotIndex == k) {
                return k;
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    //Use median-of-three strategy to choose pivot
    private static int medianOf3(List<Integer> nums, int left, int right) {
        final int mid = left + (right - left) / 2;
        if (nums.get(right) > nums.get(left)) { swap(nums, left, right); }
        if (nums.get(right) > nums.get(mid)) { swap(nums, right, mid); }
        if (nums.get(mid) > nums.get(left)) { swap(nums, left, mid); }
        return mid;
    }

    private static int partition(List<Integer> nums, int left, int right, int pivotIndex) {
        final int pivotValue = nums.get(pivotIndex);
        swap(nums, pivotIndex, right);
        int index = left;
        for (int i = left; i < right; ++i) {
            if (nums.get(i) > pivotValue) {
                swap(nums, index, i);
                ++index;
            }
        }
        swap(nums, right, index);
        return index;
    }

    private static void swap(List<Integer> nums, int a, int b) {
        Collections.swap(nums, a, b);
    }
}
