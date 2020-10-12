package codeforces.global_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class D {

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
            int index = 0;
            final List<Integer> list = new ArrayList<>();
            final int[] mex = new int[n + 1];
            for (int i = 0; i < n; i++) {
                mex[arr[i]]++;
            }
            while (index < n) {
                int curr = 0;
                for (int i = 0; i <= n; i++) {
                    if (mex[i] <= 0) {
                        curr = i;
                        break;
                    }
                }
                if (curr == n) {
                    while (index < n && index == arr[index]) {
                        index++;
                    }
                    if (index == n) {
                        break;
                    }
                    mex[arr[index]]--;
                    arr[index] = curr;
                    list.add(index);
                } else {
                    final int temp = arr[curr];
                    arr[curr] = curr;
                    mex[temp]--;
                    mex[curr]++;
                    list.add(curr);
                }
            }
            System.out.println(list.size());
            for (int num : list) {
                System.out.print((num + 1) + " ");
            }
            System.out.println();
        }
    }
}
