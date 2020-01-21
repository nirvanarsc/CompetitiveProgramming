package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P_1057 {

    // Bucket Sort
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        final List<int[]>[] buckets = new ArrayList[2001];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                final int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new int[] { i, j });
            }
        }

        final boolean[] bikeVisited = new boolean[bikes.length];
        final int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        for (List<int[]> bucket : buckets) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    final int w = bucket.get(i)[0];
                    final int b = bucket.get(i)[1];
                    if (!bikeVisited[b] && result[w] == -1) {
                        result[w] = b;
                        bikeVisited[b] = true;
                    }
                }
            }
        }
        return result;
    }

    // Priority Queue
    public int[] assignBikesPQ(int[][] workers, int[][] bikes) {
        final boolean[] visited = new boolean[bikes.length];
        final int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        int count = 0;
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0] && a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                final int dist = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                q.add(new int[] { dist, i, j });
            }
        }

        while (count < workers.length) {
            final int[] curr = q.remove();
            if (res[curr[1]] == -1 && !visited[curr[2]]) {
                res[curr[1]] = curr[2];
                visited[curr[2]] = true;
                count++;
            }
        }

        return res;
    }

    // Lazy Priority Queue
    public int[] assignBikesPQLazy(int[][] workers, int[][] bikes) {
        final boolean[] visited = new boolean[bikes.length];
        final int[] res = new int[workers.length];
        int count = 0;
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0] && a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < workers.length; i++) {
            q.offer(helper(workers, i, bikes, visited));
        }

        while (!q.isEmpty() && count < workers.length) {
            final int[] curr = q.poll();
            if (visited[curr[2]]) {
                q.offer(helper(workers, curr[1], bikes, visited));
            } else {
                res[curr[1]] = curr[2];
                visited[curr[2]] = true;
                count++;
            }
        }
        return res;
    }

    private static int[] helper(int[][] workers, int i, int[][] bikes, boolean[] visited) {
        int min = Integer.MAX_VALUE, indexJ = -1;
        for (int j = 0; j < bikes.length; j++) {
            if (!visited[j]) {
                final int dist = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                if (dist < min) {
                    min = dist;
                    indexJ = j;
                }
            }
        }
        return new int[] { min, i, indexJ };
    }
}
