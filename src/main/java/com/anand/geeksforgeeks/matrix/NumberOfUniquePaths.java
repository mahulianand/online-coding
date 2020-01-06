package com.anand.geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.sun.beans.util.Cache;

/*
Given a M X N matrix with initial position at top-left corner, 
find the number of possible unique paths to reach the bottom right corner of the grid from the initial position.


NOTE: Possible moves can be either down or right at any point in time, i.e., 
we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].
 

Input: 

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an two integers A and B depicting the size of the grid.

Output:

Print the number of unique paths to reach bottom-right corner from the top-left corner.


Constraints:

1 ≤ T ≤ 30
1 ≤ M ≤ 15
1 ≤ N ≤ 15

Example:

Input
2
2 2
3 4
Output
2
10
 * */
public class NumberOfUniquePaths {
	
	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				cache.clear();
				int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
				int M = array[0];
				int N = array[1];

				int startX = 0;
				int startY = M-1;

				int endX = N-1;
				int endY = 0;

				for(int i=0;i< N-1; i++) {
					String key = i + "_" + 0;
					cache.put(key, 1);
				}
				
				for(int i=0;i< M-1; i++) {
					String key = 0 + "_" + i;
					cache.put(key, 1);
				}
				
				int count = getPossiblePathCount(startX, startY, endX, endY, M, N);
//				System.out.println(cache);
				System.out.println(count);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int getPossiblePathCount(int startX, int startY, int endX, int endY, int m, int n) {
		int returnValue = -1;
		
		String key = startX + "_" + startY;
		
		if(cache.containsKey(key)) {
			returnValue = cache.get(key);
			System.out.println("(" + startX + ", " + startY + ") => (" + endX + ", " + endY + ") [M: " + m + " , N: " + n
					+ ", ReturnValue : " + returnValue + "] ~ From Cache");
			return returnValue;
		}
		
		if (startX > n || startX < 0 || startY > m || startY < 0) {
			returnValue = 0;
		}
		if (startX == endX && startY == endY) {
			returnValue = 1;
		}
		if (returnValue < 0) {
			returnValue = getPossiblePathCount(startX + 1, startY, endX, endY, m, n)
					+ getPossiblePathCount(startX, startY - 1, endX, endY, m, n);
		}

		cache.put(key, returnValue);
		
		System.out.println("(" + startX + ", " + startY + ") => (" + endX + ", " + endY + ") [M: " + m + " , N: " + n
				+ ", ReturnValue : " + returnValue + "]");

		return returnValue;
	}

}
