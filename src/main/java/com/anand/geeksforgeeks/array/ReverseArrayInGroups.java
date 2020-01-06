package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Given an array, reverse every sub-array formed by consecutive k elements.

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.The second line of each test case contains N space separated integers denoting array elements.The third line of each test case consists of an integer K.

Output:
Corresponding to each test case, in a new line, print the modified array.

Constraints:

1 <= T <= 100
1 <= N <= 500
1 <= A[i] <= 500

Example:

Input
1
5
1 2 3 4 5
3

Output
3 2 1 5 4
 * */
public class ReverseArrayInGroups {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int n = Integer.parseInt(br.readLine());

				int tempN = n - 1;
				for (int i = 0; i < numbers.length; i++) {
					if ((tempN == 0) || (i >= tempN)) {
						tempN = ((i + n + (n / 2)) >= numbers.length) ? (numbers.length - 1) : (i + n + (n / 2));
						i = ((i + (n / 2)) > numbers.length ? numbers.length : (i + (n / 2)));
						
						if(n % 2 ==0){
							tempN--;
							i--;
						}
						continue;
					}
					int temp = numbers[tempN];
					numbers[tempN] = numbers[i];
					numbers[i] = temp;
					tempN--;
				}
				System.out.println(Arrays.toString(numbers));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
