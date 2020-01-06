package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.


Output:

Print the maximum difference of the indexes i and j in a separate line.


Constraints:

1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 100


Example:

Input
2
2
1 10
4
3 5 4 2
Output
1
 * */
public class MaximumIndex {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

				int max = 0;
				for (int i = 0; i < array.length; i++) {
					for (int j = array.length - 1; j > i; j--) {
						int diff = j - i;
						if (diff > max && array[i] <= array[j]) {
							max = diff;
						}
					}
				}
				System.out.println(max);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
