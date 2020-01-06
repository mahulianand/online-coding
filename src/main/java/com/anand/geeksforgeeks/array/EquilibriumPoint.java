package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
 Given an array A your task is to tell at which position the equilibrium 
 first occurs in the array. Equilibrium position in an array is a position 
 such that the sum of elements below it is equal to the sum of elements after it.

Input:
The first line of input contains an integer T denoting the no of test cases 
then T test cases follow. First line of each test case contains an integer N 
denoting the size of the array. Then in the next line are N space separated 
values of the array A.

Output:
For each test case in a new  line print the position at which the elements 
are at equilibrium if no equilibrium point exists print -1.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3
 * */
public class EquilibriumPoint {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] numbers = br.readLine().split(" ");
				int ePoint = -1;
				if (numbers.length == 1) {
					ePoint = 1;
				} else {
					int[] nums = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
					int sum = Arrays.stream(nums).sum();

					int currentSum = 0;

					for (int index = 1; index < nums.length; index++) {
						currentSum += nums[index - 1];
						if (currentSum == (sum - currentSum - nums[index])) {
							ePoint = index + 1;
						}
					}
				}
				System.out.println(ePoint);
			}

		} catch (IOException e) {
		}

	}

}
