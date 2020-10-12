package atcoder.beginner_175;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        final Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            count.merge(arr[i], 1, Integer::sum);
        }
        in.nextLine();
        arr = Arrays.stream(arr).distinct().sorted().toArray();

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        res += count.get(arr[i]) * count.get(arr[j]) * count.get(arr[k]);
                    }
                }
            }
        }
        System.out.println(res);
    }
}
