package com.anand.projecteular;

import java.math.BigInteger;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * <p>
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem48_SelfPowers {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger currentNum = BigInteger.valueOf(i);
            BigInteger pow = currentNum.pow(i);
            sum = sum.add(pow);
            System.out.println("Current Index : " + i + ", Current Number : " + currentNum + ", Sum : " + sum);
            System.out.println("Problem48_SelfPowers.main");
        }
    }



}
