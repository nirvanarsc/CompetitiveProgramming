package leetcode.biweekly_contests.biweekly_55;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class MovieRentingSystem {
        Map<Integer, TreeSet<int[]>> movies;
        Map<Integer, Map<Integer, Integer>> shops;
        TreeSet<int[]> rented;

        public MovieRentingSystem(int n, int[][] entries) {
            movies = new HashMap<>();
            shops = new HashMap<>();
            // p, shopId, movieId
            rented = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] == b[1]
                                                            ? Integer.compare(a[2], b[2])
                                                            : Integer.compare(a[1], b[1])
                                                          : Integer.compare(a[0], b[0]));
            for (int[] entry : entries) {
                movies.computeIfAbsent(entry[1],
                                       val -> new TreeSet<>((a, b) -> a[0] == b[0]
                                                                      ? Integer.compare(a[1], b[1])
                                                                      : Integer.compare(a[0], b[0])))
                      .add(new int[] { entry[2], entry[0] });
                shops.computeIfAbsent(entry[0], val -> new HashMap<>()).put(entry[1], entry[2]);
            }
        }

        public List<Integer> search(int movie) {
            if (!movies.containsKey(movie)) {
                return Collections.emptyList();
            }
            final Iterator<int[]> iterator = movies.get(movie).iterator();
            final List<Integer> res = new ArrayList<>();
            while (res.size() < 5 && iterator.hasNext()) {
                res.add(iterator.next()[1]);
            }
            return res;
        }

        public void rent(int shop, int movie) {
            final int p = shops.get(shop).get(movie);
            movies.get(movie).remove(new int[] { p, shop });
            rented.add(new int[] { p, shop, movie });
        }

        public void drop(int shop, int movie) {
            final int p = shops.get(shop).get(movie);
            movies.get(movie).add(new int[] { p, shop });
            rented.remove(new int[] { p, shop, movie });
        }

        public List<List<Integer>> report() {
            final List<List<Integer>> res = new ArrayList<>();
            final Iterator<int[]> iterator = rented.iterator();
            while (res.size() < 5 && iterator.hasNext()) {
                final int[] curr = iterator.next();
                res.add(Arrays.asList(curr[1], curr[2]));
            }
            return res;
        }
    }
}
