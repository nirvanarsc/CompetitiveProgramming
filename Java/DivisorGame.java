import java.util.stream.IntStream;

public final class DivisorGame {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 30).forEach(i -> System.out.println(i + "\t" + divisorGame(i)));
    }

    public static boolean divisorGame(int n) {
        return (n & 1) == 0;
    }

    private DivisorGame() {}
}
