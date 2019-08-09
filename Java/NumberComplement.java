public final class NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement2(5));
        System.out.println(findComplement2(1));
    }

    public static int findComplement(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }

    public static int findComplement2(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    private NumberComplement() {}
}
