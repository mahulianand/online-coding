package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Given an unsorted array of size N. 
Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated array elements.

Output:
For each test case, in a new line print the required element. If no such element present in array then print -1.

Constraints:
1<=T<=100
3<=N<=106
1<=A[i]<=106

Example:
Input:
3
4
4 2 5 7
3
11 9 12
6
4 3 2 7 8 9

Output:
5
-1
7
 * */
public class ElementWithLeftSideSmallerAndRightSideGreater {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).filter(a -> !a.isEmpty()).mapToInt(Integer::parseInt).toArray();
				int number = -1;
				for (int i = 1 ; i < numbers.length - 1; i++) {
					boolean isGreaterThanLeft = true;
					for (int j = 0; j < i; j++) {
						if (numbers[i] >= numbers[j]) {
							continue;
						} else {
							isGreaterThanLeft = false;
							break;
						}
					}

					if (!isGreaterThanLeft) {
						continue;
					}

					boolean isLessThanRight = true;
					for (int k = i; k < numbers.length; k++) {
						if (numbers[i] <= numbers[k]) {
							continue;
						} else {
							isLessThanRight = false;
							break;
						}
					}

					if (!isLessThanRight) {
						continue;
					}

					number = numbers[i];
					break;
				}

				System.out.println(number);
			}

		} catch (IOException e) {
		}
	}

}
