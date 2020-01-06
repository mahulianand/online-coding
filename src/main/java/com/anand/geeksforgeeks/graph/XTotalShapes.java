package com.anand.geeksforgeeks.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
Given N * M string array of O's and X's
Return the number of 'X' total shapes. 'X' shape consists of one or more adjacent X's (diagonals not included).

Example (1):

OOOXOOO
OXXXXXO
OXOOOXO

answer is 1 , shapes are  :
(i)     X
    X X X X
    X     X
 

Example (2):

XXX
OOO
XXX

answer is 2, shapes are
(i)  XXX

(ii) XXX

Input:
The first line of input takes the number of test cases, T.
Then T test cases follow. Each of the T test cases takes 2 input lines.
The first line of each test case have two integers N and M.
The second line of N space separated strings follow which indicate the elements in the array.

Output:

Print number of shapes.

Constraints:

1<=T<=100

1<=N,M<=50

Example:

Input:
2
4 7
OOOOXXO OXOXOOX XXXXOXO OXXXOOO
10 3
XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO

Output:
4
6
 * */
public class XTotalShapes {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] lengths = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
				String[] array = br.readLine().trim().split(" ");

				int m = lengths[0];
				int n = lengths[1];

				List<String> unique = new ArrayList<>();
				for (int i = 0; i < m; i++) {
					String line = array[i];
					for (int j = 0; j < n; j++) {

						if (line.charAt(j) != 'X') {
							continue;
						}

						unique.add(i + "_" + j);
					}
				}
				Collections.sort(unique);
				System.out.println(unique.toString());
				String[] keys = unique.toArray(new String[0]);
				for (int k = 0; k < keys.length; k++) {
					String key = keys[k];
					String[] split = key.split("_");
					int i = Integer.parseInt(split[0]);
					int j = Integer.parseInt(split[1]);

					if (!unique.contains(key)) {
						unique.add(key);
					}
					
					String up = String.valueOf(i - 1) + "_" + j;
					String left = String.valueOf(i) + "_" + String.valueOf(j - 1);

					String down = String.valueOf(i + 1) + "_" + j;
					String right = String.valueOf(i) + "_" + String.valueOf(j + 1);

					if (unique.contains(up)) {
						unique.remove(up);
					}

					if (unique.contains(left)) {
						unique.remove(left);
					}

					if (unique.contains(down)) {
						unique.remove(down);
					}

					if (unique.contains(right)) {
						unique.remove(right);
					}
				}
				System.out.println(unique.toString());
				System.out.println(unique.size());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] lengths = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
				String[] array = br.readLine().trim().split(" ");

				int m = lengths[0];
				int n = lengths[1];

				List<String> unique = new ArrayList<>();
				for (int i = 0; i < m; i++) {
					String line = array[i];
					for (int j = 0; j < n; j++) {

						if (line.charAt(j) != 'X') {
							continue;
						}

						unique.add(i + "_" + j);
					}
				}
				Collections.sort(unique);
				System.out.println(unique.toString());
				String[] keys = unique.toArray(new String[0]);
				for (int k = 0; k < keys.length; k++) {
					String key = keys[k];
					String[] split = key.split("_");
					int i = Integer.parseInt(split[0]);
					int j = Integer.parseInt(split[1]);

					if (!unique.contains(key)) {
						unique.add(key);
					}
					
					String up = String.valueOf(i - 1) + "_" + j;
					String left = String.valueOf(i) + "_" + String.valueOf(j - 1);

					String down = String.valueOf(i + 1) + "_" + j;
					String right = String.valueOf(i) + "_" + String.valueOf(j + 1);

					if (unique.contains(up)) {
						unique.remove(up);
					}

					if (unique.contains(left)) {
						unique.remove(left);
					}

					if (unique.contains(down)) {
						unique.remove(down);
					}

					if (unique.contains(right)) {
						unique.remove(right);
					}
				}
				System.out.println(unique.toString());
				System.out.println(unique.size());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
 * */
/*
 * public static void main(String[] args) { try { BufferedReader br = new
 * BufferedReader(new InputStreamReader(System.in)); int noOfTests =
 * Integer.parseInt(br.readLine());
 * 
 * for (int testNo = 0; testNo < noOfTests; testNo++) { int[] lengths =
 * Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).
 * toArray(); String[] array = br.readLine().trim().split(" ");
 * 
 * int m = lengths[0]; int n = lengths[1];
 * 
 * char[][] grid = new char[m][n]; for (int i = 0; i < m; i++) { String line =
 * array[i]; for (int j = 0; j < n; j++) { grid[i][j] = line.charAt(j); } }
 * 
 * int independentX = 0;
 * 
 * for (int i = 0; i < m; i++) { for (int j = 0; j < n; j++) { if (grid[i][j] ==
 * 'X') { try { if(grid[i-1][j] == 'X') { continue; } } catch (Exception e) {
 * 
 * }
 * 
 * try { if(grid[i-1][j-1] == 'X') { continue; } } catch (Exception e) {
 * 
 * }
 * 
 * try { if(grid[i+1][j] == 'X') { continue; } } catch (Exception e) {
 * 
 * }
 * 
 * try { if(grid[i+1][j+1] == 'X') { continue; } } catch (Exception e) {
 * 
 * }
 * 
 * independentX++; } } }
 * 
 * System.out.println(independentX);
 * 
 * } } catch (Exception e) { e.printStackTrace(); }
 * 
 * }
 */