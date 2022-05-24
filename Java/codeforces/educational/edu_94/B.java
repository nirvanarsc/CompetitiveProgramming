package codeforces.educational.edu_94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 0; x < t; x++) {
            final int cap1 = fs.nextInt();
            final int cap2 = fs.nextInt();
            int swords = fs.nextInt(), axes = fs.nextInt();
            int sWeight = fs.nextInt(), aWeight = fs.nextInt();
            if (sWeight > aWeight) {
                int temp = swords;
                swords = axes;
                axes = temp;

                temp = sWeight;
                sWeight = aWeight;
                aWeight = temp;
            }
            long ans = 0;
            for (int toKeep = 0; toKeep <= swords; toKeep++) {
                if (toKeep * (long) sWeight > cap1) { continue; }
                final int oKeep = Math.min(swords - toKeep, cap2 / sWeight);
                final int myLeft = cap1 - toKeep * sWeight;
                final int hisLeft = cap2 - oKeep * sWeight;
                final int myAs = Math.min(myLeft / aWeight, axes);
                final int hisAs = Math.min(hisLeft / aWeight, axes - myAs);
                ans = Math.max(ans, toKeep + oKeep + myAs + hisAs);
            }
            System.out.println(ans);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
