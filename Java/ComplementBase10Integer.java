public class ComplementBase10Integer {

    public int bitwiseComplement(int num) {
        if (num == 0) {
            return 1;
        }

        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
