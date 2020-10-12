package codeforces.round_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class A {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] < 0) {
                res.add(curr);
            }
            nums[curr - 1] *= -1;
        }
        return res;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            Arrays.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1] - arr[i] > 1) {
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
