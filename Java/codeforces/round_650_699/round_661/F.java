package codeforces.round_650_699.round_661;

import java.util.*;
import java.io.*;

public class F {
    static ArrayList<pair>[] g;
    static ArrayList<Integer> arr, revArr;
    static PriorityQueue<pair> pq;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            g = new ArrayList[n];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                g[u].add(new pair(v, w));
                g[v].add(new pair(u, w));
            }
            pq = new PriorityQueue<>();
            e = 0;
            dfs(0, -1);
            int c = 0;
//			System.out.println(e);

//            while (e > s) {
//                pair p = pq.poll();
//                e -= p.y * p.x - (p.y / 2) * p.x;
//                if (p.y / 2 != 0) {
//                    pq.add(new pair(p.x, p.y / 2));
//                }
//                c++;
//            }
            pw.println(c);
        }

        pw.flush();
        pw.close();

    }

    static boolean[] vis;
    static int[] p, h, tot, good;
    static long[] a;
    static long e;

    static int dfs(int node, int pa) {
        if (g[node].size() == 1 && pa != -1)
            return 1;
        int ans = 0;
        for (pair v : g[node]) {
            if (v.x != pa) {
                int x = dfs(v.x, node);
                e += x * v.y;
                System.out.println(x + " " + v.y);
                pq.add(new pair(x, v.y));
                ans += x;
            }
        }
        return ans;
    }

    static class pair implements Comparable<pair> {
        int x;
        long y;

        public pair(int d, long u) {
            x = d;
            y = u;
        }

        @Override
        public int compareTo(pair o) {
            // TODO Auto-generated method stub
            long x1 = y * x - (y / 2) * x;
            long x2 = o.y * o.x - (o.y / 2) * o.x;
            return Long.compare(x2, x1);
        }

    }

}
