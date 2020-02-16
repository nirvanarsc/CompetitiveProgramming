package weekly_176;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1352 {

    static class ProductOfNumbersPrefix {
        List<Integer> prefix;

        ProductOfNumbersPrefix() {
            prefix = new ArrayList<>(Collections.singletonList(1));
        }

        public void add(int a) {
            if (a > 0) {
                prefix.add(prefix.get(prefix.size() - 1) * a);
            } else {
                prefix.clear();
                prefix.add(1);
            }
        }

        public int getProduct(int k) {
            final int n = prefix.size();
            return k < n ? prefix.get(n - 1) / prefix.get(n - k - 1) : 0;
        }
    }

    static class ProductOfNumbers {
        List<Integer> nums;
        int prod = 1;

        ProductOfNumbers() {
            nums = new ArrayList<>();
        }

        public void add(int num) {
            prod *= num;
            nums.add(num);
        }

        public int getProduct(int k) {
            if (k == nums.size()) {
                return prod;
            }
            int res = 1;
            for (int i = nums.size() - k; i < nums.size(); i++) {
                res *= nums.get(i);
                if (res == 0) {
                    return 0;
                }
            }
            return res;
        }
    }
}
