package com.anand.geeksforgeeks.bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Write a program to find the sum of bit differences in all pairs that can be formed from array elements n. Bit difference of a pair (x, y) is a count of different bits at same positions in binary representations of x and y. For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).

Input: The first line of input contains an integer T denoting the number of test cases. First line of the test case will contain an array of elements n.
Output: The sum of bit differences of all pairs that can be formed by given array.
Constraints:

1 <=T<= 100

1 <=N<= 10

1 <=a[i]<= 10
Example:

Input:

2
2 
1 2
3 
1 3 5

Output:
4
8
 * */
public class SumOfBitDifferences {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

				int out = 0;
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						out += f(array[i], array[j]);
					}
				}
				System.out.println(out );

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
