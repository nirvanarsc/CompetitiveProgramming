package codeforces.global_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Math.abs(in.nextInt());
            }
            in.nextLine();
            wiggleSort(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length - 1; i += 2) {
            if ((nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) ||
                (nums[i - 1] > nums[i] && nums[i] > nums[i + 1])) {
                nums[i] *= -1;
            }
        }
    }
}
