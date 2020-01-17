package easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class P_359 {
    class Logger {
        Map<String, Integer> map;

        Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                if (map.get(message) <= timestamp - 10) {
                    map.put(message, timestamp);
                    return true;
                }
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }

    class LoggerQueueSet {
        class Entry {
            int timestamp;
            String msg;

            Entry(int timestamp, String msg) {
                this.timestamp = timestamp;
                this.msg = msg;
            }
        }

        Deque<Entry> pq;
        Set<String> set;

        LoggerQueueSet() {
            pq = new LinkedList<>();
            set = new HashSet<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            while (!pq.isEmpty() && timestamp - pq.peekLast().timestamp >= 10) {
                set.remove(pq.removeLast().msg);
            }
            if (set.contains(message)) {
                return false;
            }
            set.add(message);
            pq.addFirst(new Entry(timestamp, message));
            return true;
        }
    }

    class LoggerLHM {
        public Map<String, Integer> map;
        int lastSecond;

        LoggerLHM() {
            map = new LinkedHashMap<String, Integer>() {
                private static final long serialVersionUID = -3418750008137711818L;

                @Override
                protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                    return lastSecond - eldest.getValue() >= 10;
                }
            };
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            lastSecond = timestamp;
            if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
