package leetcode.biweekly_contests.biweekly_0_99.biweekly_82;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_2 {

    static int busIdx;
    static int pIdx;
    static int m;
    static int n;

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        busIdx = 0;
        pIdx = 0;
        n = buses.length;
        m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        final Set<Integer> seen = new HashSet<>();
        for (int p : passengers) {
            seen.add(p);
        }
        int res = 0;
        while (hasNextBus()) {
            final int u = nextBus(buses);
            if (hasNextBus()) {
                for (int i = 0; i < capacity; i++) {
                    if (!hasNextPassenger()) {
                        break;
                    } else if (nextPassenger(passengers) > u) {
                        pIdx--;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < capacity; i++) {
                    if (!hasNextPassenger()) {
                        res = u;
                        break;
                    } else {
                        final int v = nextPassenger(passengers);
                        if (v > u) {
                            res = u;
                            break;
                        }
                        res = Math.max(res, v);
                    }
                }
                while (seen.contains(res)) {
                    res--;
                }
            }
        }
        return res;
    }

    private static int nextBus(int[] buses) {
        return buses[busIdx++];
    }

    private static int nextPassenger(int[] passengers) {
        return passengers[pIdx++];
    }

    private static boolean hasNextBus() {
        return busIdx < n;
    }

    private static boolean hasNextPassenger() {
        return pIdx < m;
    }
}
