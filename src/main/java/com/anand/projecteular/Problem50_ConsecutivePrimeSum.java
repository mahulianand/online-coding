package com.anand.projecteular;

import java.util.*;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * <p>
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * <p>
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * <p>
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem50_ConsecutivePrimeSum {
    public static void main(String[] args) {
        int max = 1000000;
        int limit = 1000000;
        List<Integer> primeNumbers = getPrimeNumbers(max);
        Set<Integer> hash = new HashSet<>(primeNumbers);
//        System.out.println(primeNumbers.toString());
        max = primeNumbers.size();

        int maxp = 0;
        int consecutiveprimescount = 0;
        int maxconsecutiveprimescount = 0;
        for (int i = 0; i < max; i++) {
            int sum = primeNumbers.get(i);
            consecutiveprimescount = 1;
            for (int j = i+1; j < max; j++) {
                sum = sum + primeNumbers.get(j);
                consecutiveprimescount++;
                if (sum > limit) {
                    break;
                }
                if (sum > maxp && consecutiveprimescount > maxconsecutiveprimescount  && hash.contains(sum)) {
                    maxconsecutiveprimescount = consecutiveprimescount;
                    maxp = sum;
                }
//                System.out.println("Sum : " + sum + ", Current Prime Number : " + primeNumbers.get(j) + ", consecutiveprimescount : " + consecutiveprimescount + ", Max consecutiveprimescount: " + maxconsecutiveprimescount);
            }
        }

        System.out.println(maxp);
}

    private static List<Integer> getPrimeNumbers(int max) {
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);

        for (int i = 11; i < max; i += 2) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 7; j < i / 2; j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
