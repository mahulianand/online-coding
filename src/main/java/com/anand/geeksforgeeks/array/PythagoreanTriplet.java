package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c^2.

Input:
The first line contains 'T' denoting the number of testcases. Then follows description of testcases.
Each case begins with a single positive integer N denoting the size of array.
The second line contains the N space separated positive integers denoting the elements of array A.

Output:
For each testcase, print "Yes" or  "No" whtether it is Pythagorean Triplet or not.

Constraints:
1<=T<=50
 1<=N<=100
 1<=A[i]<=100

Example:
Input:
1
5
3 2 4 6 5
Output:
Yes
 * */
public class PythagoreanTriplet {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				Set<Integer> allCombinations = new HashSet<>();
				Set<Integer> squares = new HashSet<>();
				for (int i = 0; i < numbers.length; i++) {
					squares.add(numbers[i] * numbers[i]);
					for (int j = i; j < numbers.length; j++) {
						allCombinations.add((numbers[i] * numbers[i]) + (numbers[j] * numbers[j]));
					}
				}
				squares.retainAll(allCombinations);
				if (squares.isEmpty()) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			}

		} catch (IOException e) {
		}
	}

}
