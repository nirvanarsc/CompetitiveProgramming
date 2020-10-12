package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public final class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] array = Arrays.stream(in.nextLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
            final Integer[] spots = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(spots, (a, b) -> Integer.compare(array[b], array[a]));
            final TreeSet<Integer> treeSet = new TreeSet<>();
            int j = 0;
            int largest = treeSet.size();
            for (int k = -1; k < n; k++) {
                if (k >= 0) {
                    treeSet.remove(spots[k]);
                }
                j = compute(n, array, spots, treeSet, j);
                largest = Math.max(largest, treeSet.size());
            }
            System.out.println(n - largest);
        }
    }

    private static int compute(int n, int[] array, Integer[] spots, TreeSet<Integer> treeSet, int j) {
        while (j < n) {
            final Integer lower = treeSet.lower(spots[j]);
            final Integer higher = treeSet.higher(spots[j]);
            if ((lower != null && array[lower] > array[spots[j]]) ||
                (higher != null && array[higher] < array[spots[j]])) {
                break;
            }
            treeSet.add(spots[j]);
            j++;
        }
        return j;
    }
}
