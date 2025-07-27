package leetcode.weekly_contests.weekly_400_499.weekly_457;

public class P_4 {

    public int minMoves(int sx, int sy, int tx, int ty) {
        int res = 0;
        while (sx != tx || sy != ty) {
            if (sx > tx || sy > ty) {
                return -1;
            }
            if (tx > ty) {
                if (tx > ty * 2) {
                    if (tx % 2 != 0) {
                        return -1;
                    }
                    tx >>= 1;
                } else {
                    tx -= ty;
                }
            } else if (tx < ty) {
                if (ty > tx * 2) {
                    if (ty % 2 != 0) {
                        return -1;
                    }
                    ty >>= 1;
                } else {
                    ty -= tx;
                }
            } else {
                if (sx == 0) {
                    tx = 0;
                } else if (sy == 0) {
                    ty = 0;
                } else {
                    return -1;
                }
            }
            res++;
        }
        return res;
    }
}
