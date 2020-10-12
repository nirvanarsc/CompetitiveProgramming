package leetcode.medium;

public class P_702 {

    static class ArrayReader {

        int get(int id) {
            return 0;
        }
    }

    public int search(ArrayReader reader, int target) {
        int endIdx = Integer.MAX_VALUE;
        int start = 0;

        while (start <= endIdx) {
            final int mid = endIdx + start >>> 1;
            if (reader.get(mid) == Integer.MAX_VALUE) {
                endIdx = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        while (start <= endIdx) {
            final int mid = endIdx + start >>> 1;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                endIdx = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
