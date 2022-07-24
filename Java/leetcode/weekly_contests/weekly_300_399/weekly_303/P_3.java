package leetcode.weekly_contests.weekly_300_399.weekly_303;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_3 {

    class FoodRatings {

        class Pair {
            String name;
            int rating;

            Pair(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }
        }

        Map<String, TreeSet<Pair>> map;
        Map<String, Pair> idx;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            map = new HashMap<>();
            idx = new HashMap<>();
            final Comparator<Pair> comparator = (a, b) -> a.rating == b.rating
                                                          ? b.name.compareTo(a.name)
                                                          : Integer.compare(a.rating, b.rating);
            final int n = foods.length;
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(cuisines[i], val -> new TreeSet<>(comparator))
                   .add(new Pair(foods[i], ratings[i]));
                idx.put(foods[i], new Pair(cuisines[i], ratings[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            final Pair cuisine = idx.get(food);
            map.get(cuisine.name).remove(new Pair(food, cuisine.rating));
            map.get(cuisine.name).add(new Pair(food, newRating));
            idx.remove(food);
            idx.put(food, new Pair(cuisine.name, newRating));
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).last().name;
        }
    }
}
