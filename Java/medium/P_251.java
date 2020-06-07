package medium;

@SuppressWarnings("unused")
public class P_251 {

    static class Vector2D {

        int i, j;
        int[][] v;

        Vector2D(int[][] v) {
            this.v = v;
        }

        public int next() {
            if (!hasNext()) {
                return -1;
            }
            return v[i][j++];
        }

        public boolean hasNext() {
            while (i < v.length && j == v[i].length) {
                i++;
                j = 0;
            }
            return i < v.length;
        }
    }
}
