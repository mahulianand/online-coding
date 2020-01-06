package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 
	Input:
	The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 
	Output:
	Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 
	Constraints:
	1 <= T <= 200
	1 <= N <= 1000
	-100 <= A[i] <= 100
 * 
 * */
public class KandaneAlgorithm {

	public static void main(String[] args) {
//		 test();
		long start = System.currentTimeMillis();
		List<Integer> prevLevNumbers = new ArrayList<>();
		List<Integer> nextLevNumbers = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int maxSum = Integer.MIN_VALUE;
			int noOfTests = Integer.parseInt(line);

			for (int j = 0; j < noOfTests; j++) {
				line = br.readLine();
				line = br.readLine();

				String[] numbers = line.split(" ");

				prevLevNumbers.clear();
				nextLevNumbers.clear();
				int lastNum = 0;
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < numbers.length; i++) {
					prevLevNumbers.add(0);
					int number = Integer.parseInt(numbers[i]);
					if(number > max) {
						max = number;
					}
					
					if (lastNum > 0 && number > 0) {
						nextLevNumbers.set(nextLevNumbers.size() - 1, lastNum + number);
						lastNum += number;
					} else if (lastNum < 0 && number < 0 && lastNum != max) {
						nextLevNumbers.set(nextLevNumbers.size() - 1, lastNum + number);
						lastNum += number;
					} else {
						nextLevNumbers.add(number);
						lastNum = number;
					}
				}
				System.out.println(/* Arrays.toString(nextLevNumbers.toArray()) +" :: "+ */ findMaxSum(prevLevNumbers,
						nextLevNumbers, maxSum));
			}
		} catch (Exception e) {
		}
		long end = System.currentTimeMillis();
		System.out.println("Time Required : " + (end - start) + " milliseconds");

	}

	private static void test() {
		int T = 200;
		int N = 1000;
		System.out.println(T);
		for (int j = 0; j < T; j++) {
			System.out.println(N);
			for (int i = 1; i <= N; i++) {
				System.out.print(Integer.valueOf(50 - (int) (Math.random() * 100))*2 + " ");
			}
			System.out.println();
		}

	}

	private static int findMaxSum(List<Integer> prevLevNumbers, List<Integer> nextLevNumbers, int maxSum) {
		System.out.println("In findMaxSum(). prevLevNumbers : " + Arrays.toString(prevLevNumbers.toArray()) + ", nextLevNumbers : " + Arrays.toString(nextLevNumbers.toArray()) + ", maxSum : " + maxSum);
		if (nextLevNumbers.size() == 1) {
			if (nextLevNumbers.get(0) > maxSum) {
				return nextLevNumbers.get(0);
			}
		}
		List<Integer> newNextLevNumbers = new ArrayList<>();
		for (int i = 0; i < nextLevNumbers.size() - 1; i++) {
			int n1 = nextLevNumbers.get(i);
			int n2 = nextLevNumbers.get(i + 1);
			int n3 = prevLevNumbers.get(i + 1);
			newNextLevNumbers.add(n1 + n2 - n3);
			if (n1 > maxSum) {
				maxSum = n1;
			}
			if (n2 > maxSum) {
				maxSum = n2;
			}
		}
		if (!newNextLevNumbers.isEmpty()) {
			return findMaxSum(nextLevNumbers, newNextLevNumbers, maxSum);
		}
		return maxSum;
	}

	/*
	 * private static int findMaxSum(List<Integer> prevLevNumbers, List<Integer>
	 * nextLevNumbers, int maxSum) { if (levelWiseNumbers.size() == 1) { if
	 * (levelWiseNumbers.get(0) > maxSum) { return levelWiseNumbers.get(0); } } if
	 * (levelWiseNumbers.size() % 2 != 0) { levelWiseNumbers.add(0); } List<Integer>
	 * NextlevelWiseNumbers = new ArrayList<>(); for (int i = 0; i <
	 * levelWiseNumbers.size() - 1; i += 2) { int n1 = levelWiseNumbers.get(i); int
	 * n2 = levelWiseNumbers.get(i + 1); NextlevelWiseNumbers.add(n1 + n2); if (n1 >
	 * maxSum) { maxSum = n1; } if (n2 > maxSum) { maxSum = n2; } } if
	 * (!NextlevelWiseNumbers.isEmpty()) { return findMaxSum(NextlevelWiseNumbers,
	 * maxSum); } return maxSum; }
	 */

}
