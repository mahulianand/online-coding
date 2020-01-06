package com.anand.projecteular;

import java.util.*;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 * <p>
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
 * <p>
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem49_PrimePermutations {
    public static void main(String[] args) {


        List<Integer> primeNumbers = getPrimeNumbers(10000);
        Map<String, List<Integer>> permutation = new HashMap<>();
        for (int primeNumber : primeNumbers) {
            char[] chars = String.valueOf(primeNumber).toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (key.equalsIgnoreCase("1478")) {
//                System.out.println(key+ " -- " + permutation.get(key));
            }
            if (permutation.containsKey(key)) {
                permutation.get(key).add(primeNumber);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(primeNumber);
                permutation.put(key, list);
            }
        }
        Set<String> strings = permutation.keySet();
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            List<Integer> a = permutation.get(next);

            if (a.size() > 2) {
                for (int i = 0; i < a.size(); i++) {
                    for (int j = i + 1; j < a.size(); j++) {
                        if (a.contains(a.get(j) + (a.get(j) - a.get(i)))) {
                            System.out.println("*********** Permutation : " + next + " Numbers : " + a.toString());
                        }
                    }
                }

            }

        }
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