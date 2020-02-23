package biweekly_20;

import java.util.HashMap;
import java.util.Map;

public class P_1357 {

    static class Cashier {
        int discountAt;
        int customers;
        double discountPercentage;
        Map<Integer, Integer> productPriceMap;

        Cashier(int n, int discount, int[] products, int[] prices) {
            discountPercentage = 1 - (discount / 100.0);
            discountAt = n;
            productPriceMap = new HashMap<>();
            for (int i = 0; i < products.length; i++) {
                productPriceMap.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            double bill = 0;
            for (int i = 0; i < product.length; i++) {
                bill += productPriceMap.get(product[i]) * amount[i];
            }
            if (++customers % discountAt == 0) {
                customers = 0;
                bill *= discountPercentage;
            }
            return bill;
        }
    }
}
