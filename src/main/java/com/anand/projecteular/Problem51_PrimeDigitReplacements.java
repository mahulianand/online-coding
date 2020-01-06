package com.anand.projecteular;

import java.util.*;

/*
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 * */
public class Problem51_PrimeDigitReplacements {
    public static void main(String[] args) {
        List<Integer> primeNumbers = getPrimeNumbers(1000000);
        Map<String, Integer> pattern = new HashMap<>();

        for (Integer n : primeNumbers){
            //if(n > 56000 && n < 56999){
                char[] chars = String.valueOf(n).toCharArray();
                for (int i = 0; i< chars.length; i++){
                    for (int j = i+1; j< chars.length; j++){
                        if(chars[i] == chars[j]){
                            char[] chars1 = String.valueOf(n).toCharArray();
                            chars1[i] = '*';
                            chars1[j] = '*';
                            String s1 = String.valueOf(chars1);
                            if(pattern.containsKey(s1)){
                                //System.out.println("Number : " + n + ", Pattern : " + s1);
                                pattern.put(s1, pattern.get(s1) + 1);
                            }else {
                                pattern.put(s1, 1);
                            }
                        }

                        for (int k = j+1; k< chars.length; k++){
                            if(chars[k] == chars[j] && chars[j] == chars[i]){
                                char[] chars1 = String.valueOf(n).toCharArray();
                                chars1[k] = '*';
                                chars1[i] = '*';
                                chars1[j] = '*';
                                String s1 = String.valueOf(chars1);
                                if(s1.equalsIgnoreCase("*2*3*3")){
                                    System.out.println("*2*3*3 :: " + n);
                                }
                                if(pattern.containsKey(s1)){
                                    //System.out.println("Number : " + n + ", Pattern : " + s1);
                                    if(pattern.get(s1) + 1 == 8){
                                        System.out.println("*** " + n);
                                    }
                                    pattern.put(s1, pattern.get(s1) + 1);
                                }else {
                                    pattern.put(s1, 1);
                                }
                            }
                        }
                    }



                }
            //}
        }

        Set<Map.Entry<String, Integer>> entries = pattern.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            if(entry.getValue() == 8 )
                System.out.println(entry);
        }
//
//        for (int len = 2; len < 3; len++) {
//            for (int noOfReplacableDigits = 1; noOfReplacableDigits < len; noOfReplacableDigits++) {
//
//
//
//
//            }
//        }

    }

    private static List<Integer> getPrimeNumbers(int max) {
        List<Integer> primeNumber = new ArrayList<>();
        primeNumber.add(2);
        primeNumber.add(3);
        primeNumber.add(5);
        primeNumber.add(7);

        for (int i = 11; i < max; i += 2) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)
                continue;
            boolean isPrime = true;
            for (int primeNumber1 : primeNumber) {
                if (i % primeNumber1 == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumber.add(i);
            }
        }
        return primeNumber;
    }
}
