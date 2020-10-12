package atcoder.grand_45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            final String s = in.nextLine();
            final List<Integer> left = new ArrayList<>();
            final List<Integer> right = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    left.add(arr[j]);
                } else {
                    right.add(arr[j]);
                }
            }
            final Set<Integer> leftS = new HashSet<>();
            final Set<Integer> rightS = new HashSet<>();
            dfs(left, leftS, 0, 0);
            dfs(right, rightS, 0, 0);
            System.out.println(leftS.equals(rightS) ? 0 : 1);
        }
    }

    public static void dfs(List<Integer> nums, Set<Integer> res, int curr, int idx) {
        res.add(curr);
        for (int i = idx; i < nums.size(); i++) {
            curr ^= nums.get(i);
            dfs(nums, res, curr, i + 1);
            curr ^= nums.get(i);
        }
    }
}
