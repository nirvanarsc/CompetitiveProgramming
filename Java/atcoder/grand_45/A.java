package atcoder.grand_45;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final long[] arr = new long[n];
            final String[] w = in.nextLine().split(" ");
            for (int i = 0; i < w.length; i++) {
                arr[i] = Long.parseLong(w[i]);
            }
            final String s = in.nextLine();
            final Set<Long> left = new HashSet<>();
            final Set<Long> right = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    left.add(arr[j]);
                } else {
                    right.add(arr[j]);
                }
            }
            if (left.size() > right.size()) {
                System.out.println(1);
            } else if (left.size() < right.size()) {
                System.out.println(0);
            }
            final Set<Long> set = new HashSet<>();
            dfs(new ArrayList<>(left), set, 0, 0, true);
            dfs(new ArrayList<>(right), set, 0, 0, false);
            System.out.println(set.isEmpty() ? 0 : 1);
            System.out.flush();
        }
    }

    public static void dfs(List<Long> nums, Set<Long> res, long curr, int idx, boolean turn) {
        if (turn) {
            res.add(curr);
        } else {
            res.remove(curr);
        }
        for (int i = idx; i < nums.size(); i++) {
            curr ^= nums.get(i);
            dfs(nums, res, curr, i + 1, turn);
            curr ^= nums.get(i);
        }
    }
}
