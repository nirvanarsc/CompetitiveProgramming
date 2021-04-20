package binarysearch.weekly_54;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_4 {

    public double solve(String source, String target, String[] sources, String[] targets, double[] rates) {
        final Set<String> uniq = new HashSet<>(Arrays.asList(source, target));
        uniq.addAll(Arrays.asList(sources));
        uniq.addAll(Arrays.asList(targets));
        final Map<String, Integer> normalized = new HashMap<>();
        int n = 0;
        for (String s : uniq) {
            normalized.put(s, n++);
        }
        final double[] bf = bellmanFord(source, sources, targets, rates, normalized, n);
        for (double d : bf) {
            if (d == Double.POSITIVE_INFINITY) {
                return -1;
            }
        }
        final double res = bf[normalized.get(target)];
        return Double.compare(res, Double.MAX_VALUE) == 0 ? 0 : Math.pow(10, -res);
    }

    // Bellman-Ford O (V*E) == O(V^3)
    private static double[] bellmanFord(String start, String[] sources, String[] targets, double[] rates,
                                        Map<String, Integer> normalized, int n) {
        final double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[normalized.get(start)] = 0;
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                final int from = normalized.get(sources[j]);
                final int to = normalized.get(targets[j]);
                final double cost = -Math.log10(rates[j]);
                if (Double.compare(dist[from], Double.MAX_VALUE) == 0) {
                    continue;
                }
                dist[to] = Math.min(dist[to], dist[from] + cost);
            }
        }
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                final int from = normalized.get(sources[j]);
                final int to = normalized.get(targets[j]);
                final double cost = -Math.log10(rates[j]);
                if (Double.compare(dist[from], Double.MAX_VALUE) == 0) {
                    continue;
                }
                if (dist[from] + cost < dist[to]) {
                    dist[to] = Double.POSITIVE_INFINITY;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        final P_4 test = new P_4();
        System.out.println(test.solve("CAD", "AUD",
                                      new String[] { "CAD", "AUD" },
                                      new String[] { "AUD", "CAD" },
                                      new double[] { 2, 2 }));
        System.out.println(test.solve("USD", "BTC",
                                      new String[] { "BTC" },
                                      new String[] { "AUD" },
                                      new double[] { 0.503766095024085 }));
        System.out.println(test.solve("INR", "EUR",
                                      new String[] { "INR" },
                                      new String[] { "EUR" },
                                      new double[] { 0.1329527214839359 }));
        System.out.println(test.solve("AUD", "EUR",
                                      new String[] { "AUD", "INR" },
                                      new String[] { "INR", "EUR" },
                                      new double[] { 1.6843260422897357, 0.9204899833576703 }));
        System.out.println(test.solve("USD", "EUR",
                                      new String[] { "EUR", "USD" },
                                      new String[] { "BTC", "EUR" },
                                      new double[] { 0.003431620369875099, 0.913802576158635 }));
        System.out.println(test.solve("EUR", "USD",
                                      new String[] { "INR", "EUR", "EUR" },
                                      new String[] { "USD", "INR", "USD" },
                                      new double[] {
                                              1.5621444463863872, 1.969015778342403, 2.9071605375326732
                                      }));
    }
}
