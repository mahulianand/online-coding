package com.anand.projecteular;

import javax.management.AttributeList;
import java.util.HashSet;
import java.util.Set;

/*
* The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
* */
public class Problem47_DistinctPrimesFactors {
    private static Integer[] primeNumbers = null;

    public static void main(String[] args){
        primeNumbers = getPrimeNumbers(10000).toArray(new Integer[0]);
        int distinctPrimeFactors = 4;

        int number = 5;
        int consCount = 0;
        while(consCount <4){
            if(hasDistinctPrimesFactors(number) == distinctPrimeFactors){
                //System.out.println("Curr Number : " + number + ", Count :  "+ consCount);
                consCount++;
            }else{
                consCount = 0;
            }
            number++;
        }
        System.out.println(number);

    }

    private static int hasDistinctPrimesFactors(int number) {

        Set<Integer> factors = new HashSet<>();
        int n = number;
        for(int index = 0; index < primeNumbers.length; index++){
            if(number>= primeNumbers[index] && number%primeNumbers[index] == 0){
                factors.add(primeNumbers[index]);
                number = number / primeNumbers[index];
                index = -1;
            }
        }
        System.out.println("Number :  " + n + ", Remainder : "+number+" , Factors : " + factors.toString());
        if(number == 1)
        return  factors.size();
        else return 0;

//        for(Integer integer: primeNumbers){
//            if(number <= integer){
//                break;
//            }
//            while(number > integer && number % integer == 0 &&  hasDistinctPrimesFactors(number/integer, depth+1)){
//                //numbersWithDistinctPrimeFactors.add(number);
//                return true;
//            }
//        }
//        return false;
    }

    private static Set<Integer> getPrimeNumbers(int max) {
        Set<Integer> primeNumber = new HashSet<Integer>();
        primeNumber.add(2);
        primeNumber.add(3);
        primeNumber.add(5);
        primeNumber.add(7);

        for (int i = 11; i < max; i+=2) {
            if(i%2==0|| i%3==0 || i%5==0)
                continue;
            boolean isPrime= true;
            for(int primeNumber1: primeNumber){
                if(i%primeNumber1==0){
                    isPrime=false;break;
                }
            }
            if(isPrime){
                primeNumber.add(i);
            }
        }
        return primeNumber;
    }

}
