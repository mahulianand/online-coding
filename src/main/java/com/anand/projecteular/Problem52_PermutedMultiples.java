package com.anand.projecteular;

import java.util.*;

/*
* It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
* */
public class Problem52_PermutedMultiples {
    public static void main(String[] args) {
        long number = 1;

        while (true) {
            String sortedChars1 = getSortedCharsForNumber(number);
            String sortedChars2 = getSortedCharsForNumber(number * 2);
            String sortedChars3 = getSortedCharsForNumber(number * 3);
            String sortedChars4 = getSortedCharsForNumber(number * 4);
            String sortedChars5 = getSortedCharsForNumber(number * 5);
            String sortedChars6 = getSortedCharsForNumber(number * 6);

            if (sortedChars1.equals(sortedChars2) && sortedChars2.equals(sortedChars3) && sortedChars3.equals(sortedChars4) && sortedChars4.equals(sortedChars5) && sortedChars5.equals(sortedChars6)) {

                System.out.println("number : " + number + ": number * 2 : "+(number*2)+"  :: sortedChars1 : " + sortedChars1 + " :: sortedChars2 : " + sortedChars2);
                break;
            }
            number++;
        }
    }

    private static String getSortedCharsForNumber(long number) {
        int[] array = Long.toString(number).chars().map(c -> c - '0').distinct().sorted().toArray();
        return Arrays.toString(array);
    }
}
