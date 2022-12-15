package lesson1;

import java.math.BigInteger;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter N (1 - 1000): ");
        var n = scanner.nextInt();

        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Wrong number");
        }
        var nNumber = n * (n + 1) / 2;
        System.out.println("T(n) = %d".formatted(nNumber));

        var fact = BigInteger.valueOf(1);
        for(int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Factorial = %d".formatted(fact));
    }
}
