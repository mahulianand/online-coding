package com.anand.geeksforgeeks.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class UglyNumbers {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> primeNumbers = getPrimeNumbers();
        List<Integer> uglyNumbers = getUglyNumbers(primeNumbers);

        int noOfTests = Integer.parseInt(br.readLine());
        for(int i=0; i< noOfTests; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(uglyNumbers.get(n-1));
        }

        br.close();
    }

    public static List<Integer> getUglyNumbers(List<Integer> primeNumbers){
        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        int n = 2;
        while(uglyNumbers.size() < 10000){

            if(n % 2 ==0 || n % 3 ==0 || n % 5 ==0){


                int i=3;
                int p=primeNumbers.get(i);
                boolean isUgly = true;
                while(p < n && i < primeNumbers.size() - 1){
                    isUgly = true;
                    if(n % p ==0 ){
                        isUgly = false; break;
                    }
                    p = primeNumbers.get(++i);
                }
                if(isUgly){
                    uglyNumbers.add(n);
                }
            }
            n++;
        }

        return uglyNumbers;


    }

    public static List<Integer> getPrimeNumbers(){
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        for(int i=5; primeNumbers.size() < 10000; i+=2){
            boolean isPrime = true;
            for(int j=2; j<i;j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }
}
