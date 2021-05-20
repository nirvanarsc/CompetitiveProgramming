package binarysearch.weekly_43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class P_4 {

    public int solve(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        final List<Integer> negA = new ArrayList<>();
        final List<Integer> negB = new ArrayList<>();
        final List<Integer> posA = new ArrayList<>();
        final List<Integer> posB = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) { negA.add(i); } else { posA.add(i); }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] < 0) { negB.add(i); } else { posB.add(i); }
        }
        final PriorityQueue<int[]> pq = new PriorityQueue<>((l, r) -> {

            return Integer.compare(a[r[0]] * b[r[1]],
                                   a[l[0]] * b[l[1]]);
        });
        final int positiveSet = posA.size() * posB.size() + negA.size() * negB.size();
        if (k >= positiveSet) {
            k -= positiveSet;
            if (!negA.isEmpty() && !posB.isEmpty()) {
                pq.offer(new int[] { negA.get(negA.size() - 1), posB.get(0), 3, 0 });
            }
            if (!posA.isEmpty() && !negB.isEmpty()) {
                pq.offer(new int[] { posA.get(0), negB.get(negB.size() - 1), 0, 3 });
            }
        } else {
            if (!negA.isEmpty() && !negB.isEmpty()) {
                pq.offer(new int[] { negA.get(0), negB.get(0), 2, 2 });
            }
            if (!posA.isEmpty() && !posB.isEmpty()) {
                pq.offer(new int[] { posA.get(posA.size() - 1), posB.get(posB.size() - 1), 1, 1 });
            }
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < k; i++) {
            final int[] curr = pq.remove();
            final int l = curr[0];
            final int r = curr[1];
            System.out.println(a[l] * b[r] + " " + l + " " + r);
            if (curr[2] == 0) {
                if (l < a.length - 1) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l + 1, r, curr[2], curr[3] });
                    }
                }
            } else if (curr[2] == 1) {
                if (l > 0) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l - 1, r, curr[2], curr[3] });
                    }
                }
            } else if (curr[2] == 2) {
                if (l < a.length - 1) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l + 1, r, curr[2], curr[3] });
                    }
                }
            } else {
                if (l > 0) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l - 1, r, curr[2], curr[3] });
                    }
                }
            }
            if (curr[3] == 0) {
                if (r < b.length - 1) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l, r + 1, curr[2], curr[3] });
                    }
                }
            } else if (curr[3] == 1) {
                if (r > 0) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l, r - 1, curr[2], curr[3] });
                    }
                }
            } else if (curr[3] == 2) {
                if (r < b.length - 1) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l, r + 1, curr[2], curr[3] });
                    }
                }
            } else {
                if (r > 0) {
                    if (add(seen, l + 1, r)) {
                        pq.offer(new int[] { l, r - 1, curr[2], curr[3] });
                    }
                }
            }
        }
        final int[] res = pq.remove();
        System.out.println(a[res[0]] * b[res[1]] + " " + res[0] + " " + res[1]);
        return a[res[0]] * b[res[1]];
    }

    private static boolean add(Set<String> set, int l, int r) {
        return set.add(l + "," + r);
    }

    public static void main(String[] args) {
        System.out.println(new P_4().solve(new int[] { 1, 0, 1 }, new int[] { 1, 2 }, 4));
    }
}
