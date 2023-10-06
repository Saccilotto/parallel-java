package AppThreadJoining;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        ThreadJoining tj = new ThreadJoining();
        BigInteger result = tj.calculateResult(BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(3), BigInteger.valueOf(4));
        System.out.println(result);
    }
}
