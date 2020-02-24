package weekly_contests.weekly_142;

public class P_1095 {

    interface MountainArray {
        int get(int index);

        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0;
        int peak = findPeakIdx(mountainArr);
        while (lo <= peak) {
            final int mid = lo + peak >>> 1;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                lo = mid + 1;
            } else {
                peak = mid - 1;
            }
        }

        lo = peak;
        int hi = mountainArr.length() - 1;
        while (lo <= hi) {
            final int mid = lo + hi >>> 1;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static int findPeakIdx(MountainArray mountainArray) {
        int lo = 0;
        int hi = mountainArray.length();

        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (mountainArray.get(mid) > mountainArray.get(lo)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
