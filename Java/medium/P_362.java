package medium;

import java.util.Iterator;
import java.util.LinkedHashMap;

@SuppressWarnings("unused")
public class P_362 {

    static class HitCounter {
        private final int[] times;
        private final int[] hits;

        HitCounter() {
            times = new int[300];
            hits = new int[300];
        }

        public void hit(int timestamp) {
            final int index = timestamp % 300;
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int total = 0;
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) {
                    total += hits[i];
                }
            }
            return total;
        }
    }

    static class HitCounterLHM {
        LinkedHashMap<Integer, Integer> lhm;
        int hits;

        HitCounterLHM() {
            lhm = new LinkedHashMap<>();
        }

        public void hit(int timestamp) {
            lhm.merge(timestamp, 1, Integer::sum);
            hits++;
        }

        public int getHits(int timestamp) {
            final Iterator<Integer> iterator = lhm.keySet().iterator();
            while (iterator.hasNext()) {
                final Integer next = iterator.next();
                if (next <= timestamp - 300) {
                    hits -= lhm.get(next);
                    iterator.remove();
                } else {
                    break;
                }
            }
            return hits;
        }
    }
}
