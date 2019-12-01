import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class NumberOfBurgers {

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices || tomatoSlices % 2 == 1) {
            return Collections.emptyList();
        }

        final int J = (tomatoSlices - (2 * cheeseSlices)) / 2;
        final int S = cheeseSlices - J;

        return Arrays.asList(J, S);
    }

    public static void main(String[] args) {
        System.out.println(numOfBurgers(16, 7));
        System.out.println(numOfBurgers(17, 4));
        System.out.println(numOfBurgers(4, 17));
        System.out.println(numOfBurgers(0, 0));
        System.out.println(numOfBurgers(2, 1));
    }

    private NumberOfBurgers() {}
}
