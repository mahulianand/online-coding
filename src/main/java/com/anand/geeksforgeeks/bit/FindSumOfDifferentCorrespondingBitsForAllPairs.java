package com.anand.geeksforgeeks.bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 We define f (X, Y) as number of different corresponding bits in binary representation of X and Y. 
 For example, f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. 
 The first and the third bit differ, so f (2, 7) = 2.

You are given an array of N integers, A1, A2 ,�, AN. 
Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 <= i, j <= N. Return the answer modulo 109+7.

Input:

The first line of each input consists of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.


Output:

In each separate line print sum of all pairs for (i, j) such that 1 <= i, j <= N and return the answer modulo 109+7.


Constraints:

1 <= T <= 70
1 <= N <= 100
-2,147,483,648 <= A[i] <= 2,147,483,647


Example:

Input:

2
2
2 4
3
1 3 5

Output:

4
8

Working:

A = [1, 3, 5] 

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8
 * */
public class FindSumOfDifferentCorrespondingBitsForAllPairs {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			Integer TenRaisedToNine = Double.valueOf(Math.pow(10, 9)).intValue();
			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

				int out = 0;
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						out += f(array[i], array[j]);
					}
				}
				System.out.println(out % TenRaisedToNine);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int f(int i, int j) {
		String binaryX = Integer.toBinaryString(i);
		String binaryY = Integer.toBinaryString(j);

		int maxLength = binaryX.length() > binaryY.length() ? binaryX.length() : binaryY.length();

//		System.out.println("X : " + i + " ("+binaryX+") :: Y : " + j + " ("+binaryY+")");
		int mismatchCount = 0;

		int xLen = binaryX.length() -1 ;
		int yLen = binaryY.length() - 1;
		
		for (int k = maxLength - 1; k >= 0; k--) {
			char xChar = xLen < 0 ? '0' : binaryX.charAt(xLen--);
			char yChar = yLen < 0 ? '0' : binaryY.charAt(yLen--);

			if (xChar != yChar) {
				mismatchCount++;
			}
		}
//		System.out.println("f("+i+","+j+") = " + mismatchCount);
		return mismatchCount;
	}

}
