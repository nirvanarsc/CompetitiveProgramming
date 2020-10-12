package leetcode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public class P_359 {

    static class LoggerCHM {

        ConcurrentHashMap<String, Integer> lastPrintTime;

        LoggerCHM() {
            lastPrintTime = new ConcurrentHashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            final Integer last = lastPrintTime.get(message);

            return last == null && lastPrintTime.put(message, timestamp) == null
                   || last != null && timestamp - last >= 10 && lastPrintTime.replace(message, last, timestamp);
        }
    }

    static class Logger {
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

    static class LoggerQueueSet {
        static class Entry {
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

    static class LoggerLHM {
        public Map<String, Integer> map;
        int lastSecond;

        LoggerLHM() {
            map = new LinkedHashMap<>() {
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
