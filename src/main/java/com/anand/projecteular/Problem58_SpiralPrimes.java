package com.anand.projecteular;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers
lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
* */
public class Problem58_SpiralPrimes {

    static Set<BigInteger> primeNumbers = new HashSet<>();
    static List<BigInteger> primeNumberList = new ArrayList<>();

    public static void main(String[] args) {

        primeNumbers.add(new BigInteger("2"));
        primeNumbers.add(new BigInteger("3"));
        primeNumbers.add(new BigInteger("5"));
        primeNumbers.add(new BigInteger("7"));

        primeNumberList.add(new BigInteger("2"));
        primeNumberList.add(new BigInteger("3"));
        primeNumberList.add(new BigInteger("5"));
        primeNumberList.add(new BigInteger("7"));

        BigInteger num = BigInteger.ONE;

        BigInteger two = new BigInteger("2");
        double primeNumCount = 0;
        double totalCount = 1;
        int sideLength = 1;
        double percentage = 100;
        //int length = 1;
        BigInteger length = BigInteger.ONE;
        //for(int length = 1; length < 127 ; length++){
        while(percentage > 10) {
            for(int n = 0; n < 4; n++){
                num = num.add(length.multiply(two));
                if(isPrimeNumbers(num)){
                    //System.out.println("Prime Number : " + num );
                    primeNumCount++;

                    System.out.println("Side Length : " +sideLength+ ", Current Number : " +num+", Length : " + length + ", Prime Count : " + primeNumCount + ", Total Count : " + totalCount + ", Percentage : " + percentage);
                }
                //System.out.println(num );
                totalCount++;
            }
            length = length.add(BigInteger.ONE);
            sideLength+=2;
            percentage = ((primeNumCount * 100)/totalCount);
            //System.out.println("Number : " + num);
            //if(percentage < 11)

        }


    }

    private static boolean isPrimeNumbers(BigInteger number) {
        if(primeNumbers.contains(number)){
            return true;
        }

        for (BigInteger primeNumber1 : primeNumberList) {
            if (number.mod(primeNumber1).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        primeNumbers.add(number);
        primeNumberList.add(number);
        //System.out.println(primeNumberList.toString());
        return true;
    }

}
