import java.util.ArrayList;
import java.util.List;

public final class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz2(15));
    }

    public static List<String> fizzBuzz(int n) {
        final List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            final StringBuilder curr = new StringBuilder();
            if (i % 3 == 0) {
                curr.append("Fizz");
            }
            if (i % 5 == 0) {
                curr.append("Buzz");
            }
            if (curr.length() == 0) {
                curr.append(i);
            }
            res.add(curr.toString());
        }
        return res;
    }

    public static List<String> fizzBuzz2(int n) {
        final List<String> res = new ArrayList<>();
        for (int i = 1, fizz = 3, buzz = 5; i <= n; i++) {
            final StringBuilder curr = new StringBuilder();
            if (i == fizz) {
                fizz += 3;
                curr.append("Fizz");
            }
            if (i == buzz) {
                buzz += 5;
                curr.append("Buzz");
            }
            if (curr.length() == 0) {
                curr.append(i);
            }
            res.add(curr.toString());
        }
        return res;
    }

    private FizzBuzz() {}
}
