package weekly_170;

public class P_1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        final int[] map = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            map[i + 1] = map[i] ^ arr[i];
        }

        final int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            res[idx++] = map[query[0]] ^ map[query[1] + 1];
        }

        return res;
    }
}
