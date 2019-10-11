import java.util.*;
import java.math.BigInteger;

public class diagonalCut {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        BigInteger m = s1.nextBigInteger();
        BigInteger n = s1.nextBigInteger();
        BigInteger numRepeatingCells = m.gcd(n);
        BigInteger reducedM = m.divide(numRepeatingCells);
        BigInteger reducedN = n.divide(numRepeatingCells);

        BigInteger numEatableSquares;
        // If both odd
        if (reducedM.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1))
                && reducedN.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1))) {
            numEatableSquares = numRepeatingCells;
        } else {
            numEatableSquares = BigInteger.valueOf(0);
        }
        System.out.println(numEatableSquares);
    }
}
