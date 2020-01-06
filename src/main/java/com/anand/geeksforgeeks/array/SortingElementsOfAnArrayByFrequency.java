package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given an array of integers, sort the array according to frequency of elements. 
For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, 
then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}. 

If frequencies of two elements are same, print them in increasing order.


Input:

The first line of input contains an integer T denoting the number of test cases. 
The description of T test cases follows. 
The first line of each test case contains a single integer N denoting the size of array. 
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:

Print each sorted array in a seperate line. For each array its numbers should be seperated by space.


Constraints:

1 <= T <= 70
30 <= N <= 130
1 <= A [ i ] <= 60 


Example:

Input:

1
5
5 5 4 6 4

Output:

4 4 5 5 6 
 * */
public class SortingElementsOfAnArrayByFrequency {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();

				Arrays.stream(br.readLine().split(" "))
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
						.sorted(Comparator.<Entry>comparingInt(e -> Integer.parseInt((String) e.getKey())))
						.sorted(Comparator.comparing(Entry::getValue, Comparator.reverseOrder())).forEach(e -> Stream
								.generate(() -> e.getKey() + " ").limit(e.getValue()).forEach(System.out::print));
				System.out.println();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}