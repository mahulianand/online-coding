package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Write a program to sort an array of 0's,1's and 2's in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.

Output: 
Print the sorted array of 0's, 1's and 2's.

Constraints: 

1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 2

Example:

Input :

2
5
0 2 1 2 0
3
0 1 0
 

Output:

0 0 1 2 2
0 0 1
 * */
public class SortAnArrayOf0s1sAnd2s {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] numbers = br.readLine().split(" ");
				System.out.println();
				Arrays.stream(numbers).mapToInt(Integer::parseInt).sorted().forEach(n-> System.out.print(n + " "));
			}
			
		} catch (IOException e) {
		}

	}

}
