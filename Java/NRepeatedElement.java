import java.util.HashSet;

public final class NRepeatedElement {

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
    }

    private static int repeatedNTimes(int[] a) {
        final HashSet<Integer> integers = new HashSet<>();

        for (int value : a) {
            if (integers.contains(value)) {
                return value;
            } else {
                integers.add(value);
            }

        }
        return 0;
    }

    private NRepeatedElement() {}
}
