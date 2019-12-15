package weekly_167;

import java.util.ArrayList;
import java.util.List;

public class P_1291 {

    public List<Integer> sequentialDigits(int low, int high) {
        final int[] allNums = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789
        };
        final List<Integer> res = new ArrayList<>();
        for (int allNum : allNums) {
            if (allNum < low) { continue; }
            if (allNum > high) { break; }
            res.add(allNum);
        }
        return res;
    }

    public static List<Integer> sequentialDigits2(int low, int high) {
        final List<Integer> res = new ArrayList<>();
        int idx = 11;
        int threshold = 100;
        int t = 3;
        int seed = 12;
        for (int i = 12; i <= high; i += idx) {
            if (i + idx > threshold || i % 10 == 0 || i == 272933937) {
                seed *= 10;
                seed += t;
                t++;
                i = seed;
                threshold *= 10;
                idx *= 10;
                idx += 1;
            }
            if (low <= i && i <= high) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits2(10, 1000000000));
        System.out.println(sequentialDigits2(1111, 123456));
        System.out.println(sequentialDigits2(1111, 12346));
    }
}
