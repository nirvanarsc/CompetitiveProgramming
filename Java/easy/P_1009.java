package easy;

public class P_1009 {

    public int bitwiseComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int mask = ~0;
        while ((num & mask) != 0) {
            mask <<= 1;
        }
        return num ^ ~mask;
    }
}
