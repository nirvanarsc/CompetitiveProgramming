package weekly_162;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        final List<Integer> up = new ArrayList<>();
        final List<Integer> bot = new ArrayList<>();
        for (int num : colsum) {
            if (num == 2) {
                up.add(1);
                bot.add(1);
                upper--;
                lower--;
            } else if (num == 1) {
                if (upper > lower) {
                    up.add(1);
                    bot.add(0);
                    upper--;
                } else {
                    up.add(0);
                    bot.add(1);
                    lower--;
                }
            } else {
                up.add(0);
                bot.add(0);
            }
        }
        return upper == 0 && lower == 0 ? Arrays.asList(up, bot) : Collections.emptyList();
    }
}
