package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. 
The converted array should be in form a < b > c < d > e < f.
The relative order of elements is same in the output i.e you have to iterate on the original array only.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the array in Zig-Zag fashion.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= A[i]<=10000

Example:
Input:
2
7
4 3 7 8 6 2 1
4
1 4 3 2
Output:
3 7 4 8 2 6 1
1 4 2 3


 * */
public class ConvertArrayIntoZigZagFashion {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				// a < b > c < d > e < f
				for (int i = 0; i < numbers.length - 1; i++) {
					if (i % 2 == 0) {
						if (numbers[i] > numbers[i + 1]) {
							int temp = numbers[i + 1];
							numbers[i + 1] = numbers[i];
							numbers[i] = temp;
						}
					}else{
						if (numbers[i ] < numbers[i + 1]) {
							int temp = numbers[i + 1];
							numbers[i + 1] = numbers[i];
							numbers[i] = temp;
						}
					} 
					// if(numbers[i] > numbers[i+2]){
					// int temp = numbers[i+2];
					// numbers[i+2] = numbers[i];
					// numbers[i] = temp;
					// }
				}

				String output = Arrays.toString(numbers);
				output = output.replaceAll(",", "");
				output = output.substring(1, output.length() - 1);
				System.out.println(output.trim());
			}

		} catch (IOException e) {
		}
	}

}
