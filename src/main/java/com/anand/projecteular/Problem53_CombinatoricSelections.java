package com.anand.projecteular;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
* There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3=10.

In general, nCr=n!r!(n−r)!, where r≤n, n!=n×(n−1)×...×3×2×1, and 0!=1.

It is not until n=23, that a value exceeds one-million: 23C10=1144066.

How many, not necessarily distinct, values of nCr for 1≤n≤100, are greater than one-million?
* */
public class Problem53_CombinatoricSelections {

    static Map<BigInteger, BigInteger> numberFactorial = new HashMap<>();

    public static void main(String[] args) {
        numberFactorial.put(BigInteger.ZERO, BigInteger.ONE);
        long count = 0;

        BigInteger hundred = BigInteger.TEN.pow(2);
        for (BigInteger n = BigInteger.ONE; n.compareTo(hundred) < 1; n = n.add(BigInteger.ONE)) {
            for (BigInteger r = BigInteger.ONE; r.compareTo(n) < 1; r=r.add(BigInteger.ONE)) {
                if (nCr(n, r).toString().length() > 6) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static BigInteger nCr(BigInteger n, BigInteger r) {
        return (factorial(n).divide(factorial(r).multiply(factorial(n.subtract(r)))));
    }

    private static BigInteger factorial(BigInteger n) {
        if (!numberFactorial.containsKey(n)) {
            numberFactorial.put(n, n.multiply(factorial(n.subtract(BigInteger.ONE))));
            System.out.println(numberFactorial);
        }
        return numberFactorial.get(n);
    }


}
