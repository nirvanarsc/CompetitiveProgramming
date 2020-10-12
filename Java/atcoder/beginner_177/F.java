package atcoder.beginner_177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int[] a = new int[h];
        final int[] b = new int[h];
        for (int i = 0; i < h; i++) {
            a[i] = fs.nextInt() - 1;
            b[i] = fs.nextInt();
        }
        final SortedMap<Integer, Integer> currToOrigin = new TreeMap<>();
        for (int i = 0; i < w; i++) {
            currToOrigin.put(i, i);
        }
        final int[] gaps = new int[w];
        final int[] results = new int[h];
        gaps[0] = w;
        Arrays.fill(results, -1);
        int minGapIndex = 0, maxGapIndex = 0;
        for (int i = 0; (i < h) && !currToOrigin.isEmpty(); i++) {
            final SortedMap<Integer, Integer> subMap = currToOrigin.subMap(a[i], b[i]);
            if (!subMap.isEmpty()) {
                final int maxOrigin = subMap.get(subMap.lastKey());
                subMap.forEach((key, value) -> gaps[key - value]--);
                subMap.clear();
                if ((b[i] < w) && !currToOrigin.containsKey(b[i])) {
                    currToOrigin.put(b[i], maxOrigin);
                    gaps[b[i] - maxOrigin]++;
                    maxGapIndex = Math.max(maxGapIndex, b[i] - maxOrigin);
                }
                while ((minGapIndex <= maxGapIndex) && (0 == gaps[minGapIndex])) {
                    minGapIndex++;
                }
            }
            results[i] = (minGapIndex <= maxGapIndex) ? minGapIndex + i + 1 : -1;
        }
        Arrays.stream(results).forEach(System.out::println);
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
