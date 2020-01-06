package com.anand.geeksforgeeks.maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 Given N non-negative integers a_1, a_2, ..., a_n  where each represents a point at coordinate  (i, a_i) . 
 N vertical lines are drawn such that the two endpoints of line i is at  (i, a_i)  and (i, 0). 
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Input: 
The first line of input contains an integer T denoting the number of test cases. 
Each test case contains an integer N followed by N space separated integers.

Output:
For each test case, the output is the integer denoting the maximum area of water that can be contained 
( maximum area instead of maximum volume as working with 2D)

Constraints:
1<=T<=100
2<=N<=50

Example:
Input:
2
4
1 5 4 3 
5
3 1 2 4 5
Output
6
12

Explanation:
1. 5 and 3 are distance 2 apart. So the size of the base = 2. Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6.
2. 5 and 3 are distance 4 apart. So the size of the base = 4. Height of container = min(5, 3) = 3. So total area = 4 * 3 = 12.
 * */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				int maxArea = 0;
				for (int i = 0; i < array.length; i++) {
					for (int j = i + 1; j < array.length; j++) {
						
						int base = j - i;
						int height = Math.min(array[i], array[j]);
						int area = base * height;
						
						if(area > maxArea) {
							maxArea = area;
						}
					}
				}
				
				System.out.println(maxArea);
			}
		} catch (Exception e) {

		}
	}

}
