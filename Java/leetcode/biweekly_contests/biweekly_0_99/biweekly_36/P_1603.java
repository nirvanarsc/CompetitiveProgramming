package leetcode.biweekly_contests.biweekly_0_99.biweekly_36;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1603 {

    class ParkingSystem {

        Map<Integer, Integer> park = new HashMap<>();

        ParkingSystem(int big, int medium, int small) {
            park.put(1, big);
            park.put(2, medium);
            park.put(3, small);
        }

        public boolean addCar(int carType) {
            if (park.get(carType) > 0) {
                park.merge(carType, -1, Integer::sum);
                return true;
            }
            return false;
        }
    }
}
