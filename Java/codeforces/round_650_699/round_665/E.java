package codeforces.round_650_699.round_665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class E {

    static class Point {
        int x;
        int y;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            System.out.println(n);
        }
    }

    int countSquares(int[] verticalLines, int[] horizontalLines, Point startP, Point endP) {
        Arrays.sort(verticalLines);
        Arrays.sort(horizontalLines);
        final Map<Integer, Integer> horizontalSegmentCount = new HashMap<>();
        int topBound = startP.x;
        for (int horizontalLine : horizontalLines) {
            if (startP.x < horizontalLine && horizontalLine < endP.x && topBound != horizontalLine) {
                final int len = horizontalLine - topBound;
                horizontalSegmentCount.merge(len, 1, Integer::sum);
                topBound = horizontalLine;
            }
        }
        if (horizontalLines.length > 0 && topBound != endP.x) {
            horizontalSegmentCount.merge(endP.x - topBound, 1, Integer::sum);
        }
        int leftBound = startP.y;
        int squareCount = 0;
        for (int verticalLine : verticalLines) {
            if (startP.y < verticalLine && verticalLine <= endP.y && topBound != verticalLine) {
                final int len = verticalLine - leftBound;
                squareCount += horizontalSegmentCount.getOrDefault(len, 0);
                leftBound = verticalLine;
            }
        }
        if (verticalLines.length > 0 && topBound != endP.y) {
            squareCount += horizontalSegmentCount.getOrDefault(endP.y - topBound, 0);
        }

        return squareCount;
    }
}
