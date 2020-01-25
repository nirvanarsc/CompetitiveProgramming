package hard;

public class P_1274 {

    @FunctionalInterface
    interface Sea {
        boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }

        final int midX = topRight[0] + bottomLeft[0] >>> 1;
        final int midY = topRight[1] + bottomLeft[1] >>> 1;
        return countShips(sea, new int[] { midX, midY }, bottomLeft) +
               countShips(sea, topRight, new int[] { midX + 1, midY + 1 }) +
               countShips(sea, new int[] { midX, topRight[1] }, new int[] { bottomLeft[0], midY + 1 }) +
               countShips(sea, new int[] { topRight[0], midY }, new int[] { midX + 1, bottomLeft[1] });
    }
}
