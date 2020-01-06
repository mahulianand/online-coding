package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Given a sorted array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.

 

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.

 


Output:

In each separate line print the number that appears only once in the array.


Constraints:

1 <= T <= 70
1 <= N <= 100
0 <= A[i] <= 100000


Example:

Input:

1
11
1 1 2 2 3 3 4 50 50 65 65

Output:

4

 
 * */
public class FindTheElementThatAppearsOnceInSortedArray {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				boolean done = false;
				for (int i = 0; i < numbers.length - 1; i++) {
					if (numbers[i] == numbers[i + 1]) {
						i++;
					} else {
						System.out.println(numbers[i]);
						done = true;
						break;
					}
				}
				
				if(!done){
					System.out.println(numbers[numbers.length - 1]);
				}
			}

		} catch (IOException e) {
		}
	}

}
