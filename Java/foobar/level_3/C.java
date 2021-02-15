package foobar.level_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class C {

    private static final class Matrix {
        private final int rows;
        private final int columns;
        private final long[][] numerators;
        private final long[][] denominators;

        private Matrix(long[][] numerators, long[][] denominators) {
            rows = numerators.length;
            columns = numerators[0].length;
            this.numerators = numerators;
            this.denominators = denominators;
        }

        public void print() {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    System.out.printf("%d/%d ", numerators[row][column], denominators[row][column]);
                }
                System.out.println();
            }
        }

        // Returns the inverse of this matrix
        public Matrix inverse() {
            assert rows == columns;
            // Augment by identity matrix
            final Matrix tmp = new Matrix(new long[rows][columns * 2], new long[rows][columns * 2]);
            for (int row = 0; row < rows; row++) {
                System.arraycopy(numerators[row], 0, tmp.numerators[row], 0, columns);
                System.arraycopy(denominators[row], 0, tmp.denominators[row], 0, columns);
                tmp.numerators[row][row + columns] = 1;
                tmp.denominators[row][row + columns] = 1;
            }
            tmp.toReducedRowEchelonForm();
            final Matrix inv = new Matrix(new long[rows][columns], new long[rows][columns]);
            for (int row = 0; row < rows; row++) {
                System.arraycopy(tmp.numerators[row], columns, inv.numerators[row], 0, columns);
                System.arraycopy(tmp.denominators[row], columns, inv.denominators[row], 0, columns);
            }
            return inv;
        }

        // Converts this matrix into reduced row echelon form
        public void toReducedRowEchelonForm() {
            for (int row = 0, lead = 0; row < rows && lead < columns; row++, lead++) {
                int i = row;
                while (numerators[i][lead] == 0) {
                    if (++i == rows) {
                        i = row;
                        if (++lead == columns) {
                            return;
                        }
                    }
                }
                swapRows(i, row);
                if (denominators[row][lead] != 0) {
                    final long f1 = denominators[row][lead];
                    final long f2 = numerators[row][lead];
                    for (int column = 0; column < columns; column++) {
                        numerators[row][column] *= f1;
                        denominators[row][column] *= f2;
                        simplify(numerators[row], denominators[row], column);
                    }
                }
                for (int j = 0; j < rows; j++) {
                    if (j == row) {
                        continue;
                    }
                    final long i1 = numerators[j][lead];
                    final long i2 = denominators[j][lead];
                    for (int column = 0; column < columns; column++) {
                        final long f1 = i1 * numerators[row][column];
                        final long f2 = i2 * denominators[row][column];
                        if (denominators[j][column] == 0) {
                            numerators[j][column] = -f1;
                            denominators[j][column] = f2;
                        } else if (f2 != 0) {
                            subtract(j, column, f1, f2);
                        }
                        simplify(numerators[j], denominators[j], column);
                    }
                }
            }
        }

        private void subtract(int j, int column, long f1, long f2) {
            final long lcm = lcm(denominators[j][column], f2);
            numerators[j][column] = (numerators[j][column] * (lcm / denominators[j][column]))
                                    - (f1 * (lcm / f2));
            denominators[j][column] = lcm;
        }

        private static void add(Matrix result, int i, int j, long f1, long f2) {
            final long lcm = lcm(result.denominators[i][j], f2);
            result.numerators[i][j] = result.numerators[i][j] * (lcm / result.denominators[i][j])
                                      + (f1 * (lcm / f2));
            result.denominators[i][j] = lcm;
        }

        private static void simplify(long[] numerators, long[] denominators, int col) {
            if (numerators[col] != 0) {
                final long gcd = gcd(Math.abs(numerators[col]), denominators[col]);
                numerators[col] /= gcd;
                denominators[col] /= gcd;
            } else {
                denominators[col] = 0;
            }
        }

        // Returns the matrix product of a and b
        public static Matrix product(Matrix a, Matrix b) {
            assert a.columns == b.rows;
            final Matrix result = new Matrix(new long[a.rows][b.columns], new long[a.rows][b.columns]);
            for (int i = 0; i < a.rows; i++) {
                for (int k = 0; k < a.columns; k++) {
                    for (int j = 0; j < b.columns; j++) {
                        final long f1 = a.numerators[i][k] * b.numerators[k][j];
                        final long f2 = a.denominators[i][k] * b.denominators[k][j];
                        if (f1 == 0 || f2 == 0) {
                            continue;
                        }
                        if (result.denominators[i][j] == 0) {
                            result.numerators[i][j] = f1;
                            result.denominators[i][j] = f2;
                        } else {
                            add(result, i, j, f1, f2);
                        }
                        simplify(result.numerators[i], result.denominators[i], j);
                    }
                }
            }
            return result;
        }

        private void swapRows(int i, int j) {
            final long[] tmp1 = numerators[i];
            final long[] tmp2 = denominators[i];
            numerators[i] = numerators[j];
            numerators[j] = tmp1;
            denominators[i] = denominators[j];
            denominators[j] = tmp2;
        }

        private static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public static long lcm(long a, long b) {
            return (a * b) / gcd(a, b);
        }
    }

    // https://en.wikipedia.org/wiki/Absorbing_Markov_chain
    // https://math.libretexts.org/Bookshelves/Applied_Mathematics/Book%3A_Applied_Finite_Mathematics_(Sekhon_and_Bloom)/10%3A_Markov_Chains/10.04%3A_Absorbing_Markov_Chains
    public static int[] solution(int[][] m) {
        boolean isStartTerminal = true;
        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] > 0) {
                isStartTerminal = false;
                break;
            }
        }
        if (isStartTerminal || m.length == 1) {
            return new int[] { 1, 1 };
        }
        final List<Integer> terminalStates = new ArrayList<>();
        final List<Integer> transientStates = new ArrayList<>();
        final int rows = m.length;
        final int cols = m[0].length;
        final int[] sums = new int[rows];
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            boolean isTerminal = true;
            for (int j = 0; j < cols; j++) {
                if (m[i][j] != 0) {
                    isTerminal = false;
                }
                sum += m[i][j];
            }
            if (isTerminal) {
                terminalStates.add(i);
            } else {
                transientStates.add(i);
            }
            sums[i] = sum;
        }
        final int tSize = transientStates.size();
        final int termSize = terminalStates.size();
        if (termSize == 0) {
            return new int[] { 0, 1 };
        }
        // Q Matrix
        final long[][] qNums = new long[tSize][tSize];
        final long[][] qDenoms = new long[tSize][tSize];
        // R Matrix
        final long[][] rNums = new long[tSize][termSize];
        final long[][] rDenoms = new long[tSize][termSize];
        for (int i = 0; i < tSize; i++) {
            for (int j = 0; j < tSize; j++) {
                qNums[i][j] = m[transientStates.get(i)][transientStates.get(j)];
                qDenoms[i][j] = sums[transientStates.get(i)];
                Matrix.simplify(qNums[i], qDenoms[i], j);
            }
        }
        for (int i = 0; i < tSize; i++) {
            for (int j = 0; j < termSize; j++) {
                rNums[i][j] = m[transientStates.get(i)][terminalStates.get(j)];
                rDenoms[i][j] = sums[transientStates.get(i)];
                Matrix.simplify(rNums[i], rDenoms[i], j);
            }
        }
        // I - Q Matrix
        for (int i = 0; i < tSize; i++) {
            for (int j = 0; j < tSize; j++) {
                if (qDenoms[i][j] == 0) {
                    if (i == j) {
                        qNums[i][j] = 1;
                        qDenoms[i][j] = 1;
                    }
                } else {
                    if (i == j) {
                        qNums[i][j] = qDenoms[i][j] - qNums[i][j];
                        qDenoms[i][j] = qDenoms[i][j];
                    } else {
                        qNums[i][j] = -qNums[i][j];
                    }
                    Matrix.simplify(qNums[i], qDenoms[i], j);
                }
            }
        }
        final Matrix r = new Matrix(rNums, rDenoms);
        final Matrix qi = new Matrix(qNums, qDenoms);
        final Matrix inverse = qi.inverse();
        final Matrix result = Matrix.product(inverse, r);
        final int[] res = new int[termSize + 1];
        long lcm = 1;
        for (long denom : result.denominators[0]) {
            if (denom != 0) {
                lcm = Matrix.lcm(lcm, denom);
            }
        }
        for (int i = 0; i < termSize; i++) {
            if (result.denominators[0][i] != 0) {
                final long curr = result.numerators[0][i] * (lcm / result.denominators[0][i]);
                res[i] = (int) curr;
            }
        }
        res[termSize] = (int) lcm;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {
                { 0, 1, 0, 0, 0, 1 },
                { 4, 0, 0, 3, 2, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        })));
        System.out.println(Arrays.toString(solution(new int[][] {
                { 0, 0, 0, 0, 3, 5, 0, 0, 0, 2 },
                { 0, 0, 4, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 4, 4, 0, 0, 0, 1, 1 },
                { 13, 0, 0, 0, 0, 0, 2, 0, 0, 0 },
                { 0, 1, 8, 7, 0, 0, 0, 1, 3, 0 },
                { 1, 7, 0, 0, 0, 0, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        })));
        System.out.println(Arrays.toString(solution(new int[][] {
                { 0, 86, 61, 189, 0, 18, 12, 33, 66, 39 },
                { 0, 0, 2, 0, 0, 1, 0, 0, 0, 0 },
                { 15, 187, 0, 0, 18, 23, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        })));
        System.out.println(Arrays.toString(solution(new int[][] {
                { 0, 0, 12, 0, 15, 0, 0, 0, 1, 8 },
                { 0, 0, 60, 0, 0, 7, 13, 0, 0, 0 },
                { 0, 15, 0, 8, 7, 0, 0, 1, 9, 0 },
                { 23, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 37, 35, 0, 0, 0, 0, 3, 21, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        })));
        System.out.println(Arrays.toString(solution(new int[][] { { 0 }, })));
    }
}

