package com.anand.projecteular;

import java.math.BigInteger;

/*
* Square root convergents

Problem 57
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

2–√=1+12+12+12+…
By expanding this for the first four iterations, we get:

1+1/2=32=1.5
1+1/(2+1/2)=75=1.4
1+1/(2+1/(2+1/2))=1712=1.41666…
1+12+12+12+12=4129=1.41379…

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than the denominator?
* */
public class Problem57_SquareRootConvergents {
    public static void main(String[] args) {

        BigInteger num = BigInteger.valueOf(3);
        BigInteger deno = BigInteger.valueOf(2);

        BigInteger TWO = BigInteger.valueOf(2);

        long count = 0;
        for(int i=2; i<=1000; i++){

            BigInteger newnum = deno.multiply(TWO).add(num);
            BigInteger newdeno = num.add(deno);

            String numString = newnum.toString();
            String denoString = newdeno.toString();

            if(numString.length() > denoString.length()){
                count++;
                System.out.println(numString + "/" + denoString);
            }

            num = newnum;
            deno = newdeno;
        }

        System.out.println(count);
    }
}
