package com.anand.projecteular;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 *
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 * */
public class Problem56_PowerfulDigitSum {

    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        int max = 0;
        double max_a = 0;
        double max_b = 0;
        for (a = 100; a > 1; a--) {
            for (b = 100; b > 1; b--) {
                //double pow = Math.pow(a, b);
                BigInteger a_bd = new BigInteger(a + "");
                BigInteger bd = a_bd.pow(b);
                String s = bd.toString();
                int sum = 0;
                for (int index = 0; index < s.length(); index++) {
                    sum += Integer.valueOf(s.charAt(index) + "");
                }
                if (sum > max) {
                    System.out.println("a = " + a + ", b = " + b + ", max sum = " + max + " sum = " + sum + ", pow = " + bd + ", s = "+ s);
                    max = sum;
                    max_a = a;
                    max_b = b;
                }

            }
        }
        System.out.println("a = " + max_a + ", b = " + max_b + ", max sum = " + max);
    }
}
