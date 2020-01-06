package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer 'N' denoting the size of array and the size of subarray 'k'.
The second line contains 'N' space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 <= T <= 200
1 <= N <= 100
1 <= k <= N
0 <=A[i]<1000

Example:

Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90
 * */
public class MaximumOfAllSubarraysOfSizeK2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] testDesc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int k = testDesc[1];

				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				StringBuilder output = new StringBuilder();
				LinkedList<Integer> linkedList = new LinkedList<Integer>();

				int max = -1;
				for (int i = 0; i < numbers.length - k + 1; i++) {
					output.append(Arrays.stream(numbers).skip(i).limit(k).max().getAsInt()).append(" ");
					if(max < numbers[i]){
						max = numbers[i];
					}
					linkedList.addLast(numbers[i]);
					if (linkedList.size() > 3) {
						Integer removeFirst = linkedList.removeFirst();
					}
					if (linkedList.size() == 3) {
						output.append(linkedList.stream().max(Comparator.naturalOrder()).get().intValue()).append(" ");
					}
				}
				System.out.println(output.toString().trim());
			}
		} catch (Exception e) {

		}

	}

}
