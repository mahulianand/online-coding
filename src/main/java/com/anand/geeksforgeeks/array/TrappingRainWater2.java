package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Given n non-negative integers in array representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example:
Input:
3
2 0 2
Output:
2
Structure is like below
|  |
|_|
We can trap 2 units of water in the middle gap.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
Each test case contains an integer N followed by N numbers to be stored in array.

Output:
Print trap units of water in the middle gap.

Constraints:
1<=T<=100
3<=N<=100
0<=Arr[i]<10

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
 0

 * */
public class TrappingRainWater2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int size = Integer.parseInt(br.readLine());
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				int[] max = new int[size];
				max[0] = 0;
				max[size - 1] = 0;

				int quantity = 0;
				int frwdCurrentMax = numbers[0];
				int bckCurrentMax = numbers[size - 1];
				for (int i = 1; i < numbers.length - 1; i++) {
					if (numbers[i] < frwdCurrentMax && (max[i] ==0 ) || frwdCurrentMax < max[i]) {
						max[i] = frwdCurrentMax;
					} else {
						frwdCurrentMax = numbers[i];
					}
				}

				System.out.println(Arrays.toString(max));

				for (int i = 1; i < numbers.length - 1; i++) {
					if (numbers[size - i] < bckCurrentMax && (max[size - i] == 0 || bckCurrentMax < max[size - i])) {
						max[size - i] = bckCurrentMax;
					} else {
						bckCurrentMax = numbers[size - i];
					}
				}

//				for (int i = 1; i < numbers.length - 1; i++) {
//					if (numbers[i] < frwdCurrentMax && (max[i] ==0 ) || frwdCurrentMax < max[i]) {
//						max[i] = frwdCurrentMax;
//					} else {
//						frwdCurrentMax = numbers[i];
//					}
//				}

				System.out.println(Arrays.toString(max));

				for (int i = 0; i < max.length; i++) {
					if (max[i] > 0 && (max[i] - numbers[i]) > 0) {
						quantity += (max[i] - numbers[i]);
					}
				}

				System.out.println(quantity);
			}

		} catch (IOException e) {
		}
	}

}
