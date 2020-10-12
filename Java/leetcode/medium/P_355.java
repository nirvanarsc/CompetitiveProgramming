package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

@SuppressWarnings("unused")
public class P_355 {

    static class Twitter {
        static class Tweet {
            private final int id;
            private final int time;
            private Tweet next;

            Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        static class User {
            private final int id;
            public Set<Integer> followed;
            public Tweet head;

            User(int userId) {
                followed = new HashSet<>();
                id = userId;
                follow(id);
            }

            public void follow(int userId) {
                followed.add(userId);
            }

            public void unfollow(int userId) {
                if (userId != id) {
                    followed.remove(userId);
                }
            }

            public void post(int tweetId) {
                final Tweet curr = new Tweet(tweetId, timestamp);
                timestamp++;
                curr.next = head;
                head = curr;
            }
        }

        private final Map<Integer, User> userMap;
        private static int timestamp;

        Twitter() {
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            userMap.computeIfAbsent(userId, v -> new User(userId)).post(tweetId);
        }

        public void follow(int followerId, int followeeId) {
            userMap.putIfAbsent(followeeId, new User(followeeId));
            userMap.computeIfAbsent(followerId, v-> new User(followerId)).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                return;
            }
            userMap.get(followerId).unfollow(followeeId);
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) {
                return Collections.emptyList();
            }
            final List<Integer> res = new ArrayList<>();
            final Set<Integer> users = userMap.get(userId).followed;
            final PriorityQueue<Tweet> pq =
                    new PriorityQueue<>(users.size(), (a, b) -> Integer.compare(b.time, a.time));
            for (int id : users) {
                final Tweet twt = userMap.get(id).head;
                if (twt != null) {
                    pq.add(twt);
                }
            }
            while (!pq.isEmpty() && res.size() < 10) {
                final Tweet tweet = pq.poll();
                res.add(tweet.id);
                if (tweet.next != null) {
                    pq.add(tweet.next);
                }
            }
            return res;
        }
    }
}
