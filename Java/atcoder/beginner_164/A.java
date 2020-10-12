package atcoder.beginner_164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import utils.DataStructures.TreeNode;

public final class A {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        return map.values()
                  .stream()
                  .map(list -> list
                          .stream()
                          .sorted((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                         : Integer.compare(a[1], b[1]))
                          .map(t -> t[0])
                          .collect(Collectors.toList()))
                  .collect(Collectors.toList());
    }

    private static void dfs(TreeNode root, TreeMap<Integer, List<int[]>> g, int d, int level) {
        if (root == null) {
            return;
        }
        g.computeIfAbsent(d, v -> new ArrayList<>()).add(new int[] { root.val, level });
        dfs(root.left, g, d - 1, level + 1);
        dfs(root.right, g, d + 1, level + 1);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int sheep = in.nextInt();
        final int wolves = in.nextInt();
        System.out.println(sheep <= wolves ? "unsafe" : "safe");
    }
}
