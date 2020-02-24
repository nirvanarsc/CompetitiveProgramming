package weekly_contests.weekly_173;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P_1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int vegan, int maxPrice, int maxDistance) {
        final List<List<Integer>> list = new ArrayList<>();
        for (int[] r : restaurants) {
            final List<Integer> restaurant = new ArrayList<>();
            for (int i : r) { restaurant.add(i); }
            list.add(restaurant);
        }
        final Comparator<List<Integer>> byRankAndIndex = (r1, r2) -> {
            if (r1.get(1).equals(r2.get(1))) {
                return Integer.compare(r2.get(0), r1.get(0));
            }
            return Integer.compare(r2.get(1), r1.get(1));
        };
        return list.stream()
                   .filter(r -> vegan == 0 ? true : r.get(2) == 1)
                   .filter(r -> r.get(3) <= maxPrice)
                   .filter(r -> r.get(4) <= maxDistance)
                   .sorted(byRankAndIndex)
                   .map(r -> r.get(0))
                   .collect(Collectors.toList());
    }
}
