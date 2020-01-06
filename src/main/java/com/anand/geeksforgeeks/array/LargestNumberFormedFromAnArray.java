package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
 Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.

The result is going to be very large, hence return the result in the form of a string.

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.


Output:

In each separate line print the largest number formed by arranging the elements of the array in the form of a string.


Constraints:

1 <= T <= 70
1 <= N <= 100
0 <= A[i] <= 1000


Example:

Input:

2
5
3 30 34 5 9
4
54 546 548 60

Output:

9534330
6054854654
 * */
public class LargestNumberFormedFromAnArray {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] numbers = br.readLine().split(" ");
				Arrays.sort(numbers, Collections.reverseOrder(new TextComparator()));
				System.out.println(Arrays.stream(numbers).collect(Collectors.joining()).toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class TextComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1)) {
			return 1;
		} else if (Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1)) {
			return -1;
		}
		return 0;
	}

}