package foobar.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class A {

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 3, 1, 4, 1 }));
        System.out.println(solution(new int[] { 3, 1, 4, 1, 5, 9 }));
        System.out.println(solution(new int[] { 3, 5, 5 }));
        System.out.println(solution(new int[] { 3, 7, 7 }));
        System.out.println(solution(new int[] { 5 }));
    }

    /*
     * For the number to be divisible by 3, the sum of its digits needs to be divisible by 3.
     * If the sum has a remainder 1 mod 3, we need to:
     *  - remove the smallest digit that gives a remainder 1 mod 3
     *  - if there are no digits with remainder 1 mod 3, remove the 2 smallest digits that give remainder 2 mod 3
     * If the sum has a remainder 2 mod 3, we need to:
     *  - remove the smallest digit that has a remainder 2 mod 3
     *  - if there are no digits with remainder 2 mod 3, remove the 2 smallest digits that give remainder 1 mod 3
     */
    public static int solution(int[] l) {
        // remainder 1 mod 3
        final List<Integer> r1 = new ArrayList<>();
        // remainder 2 mod 3
        final List<Integer> r2 = new ArrayList<>();
        // remainder 0 mod 3;
        final List<Integer> r0 = new ArrayList<>();
        int total = 0;
        for (int num : l) {
            if (num % 3 == 0) {
                r0.add(num);
            } else if (num % 3 == 1) {
                r1.add(num);
            } else {
                r2.add(num);
            }
            total = (total + num) % 3;
        }
        final List<Integer> ok = new ArrayList<>(r0);
        if (total == 0) {
            ok.addAll(r1);
            ok.addAll(r2);
        } else if (total == 1) {
            Collections.sort(r1);
            Collections.sort(r2);
            if (!r1.isEmpty()) {
                for (int i = 1; i < r1.size(); i++) { ok.add(r1.get(i)); }
                ok.addAll(r2);
            } else {
                for (int i = 2; i < r2.size(); i++) { ok.add(r2.get(i)); }
            }
        } else if (total == 2) {
            Collections.sort(r1);
            Collections.sort(r2);
            if (!r2.isEmpty()) {
                for (int i = 1; i < r2.size(); i++) { ok.add(r2.get(i)); }
                ok.addAll(r1);
            } else {
                for (int i = 2; i < r1.size(); i++) { ok.add(r1.get(i)); }
            }
        }
        ok.sort(Collections.reverseOrder());
        int res = 0;
        for (int num : ok) {
            res = res * 10 + num;
        }
        return res;
    }
}
