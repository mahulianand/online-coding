package com.anand.geeksforgeeks.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

	public static void main(String[] args) throws Exception {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] input = new int[] { 3, 0, 6, 5, 0, 8, 4, 0, 0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 8, 7, 0, 0, 0, 0, 3, 1, 0, 0,
				3, 0, 1, 0, 0, 8, 0, 9, 0, 0, 8, 6, 3, 0, 0, 5, 0, 5, 0, 0, 9, 0, 6, 0, 0, 1, 3, 0, 0, 0, 0, 2, 5, 0, 0,
				0, 0, 0, 0, 0, 0, 7, 4, 0, 0, 5, 2, 0, 6, 3, 0, 0 };

		List<Integer> processedIndex = new ArrayList<>();
		List<Integer> ignoreIndex = new ArrayList<>();

		for (int index = 0; index < input.length; index++) {
			if (input[index] != 0) {
				ignoreIndex.add(index);
			}
		}

		boolean backtrack = false;
		for (int index = 0; index < input.length; index++) {
			System.out.println(index);
			if (ignoreIndex.contains(index)) {
				if (backtrack) {
					index--;
				}
				continue;
			}

			for (int n = 1; n < 10; n++) {
				input[index] = n;
				if (isValid(input)) {
					processedIndex.add(index);
					backtrack = false;
					break;
				}
			}

			if (!processedIndex.contains(index)) {
				backtrack = true;
				index -= 2;
			}

			System.out.println(Arrays.toString(input));

		}
	}

	private static boolean isValid(int[] input) {

		Set<Integer> row = new HashSet<>();
		for(int i=0;i<9;i++) {
			row.clear();
			for(int j=0;j<9;j++) {
				int index = (9*i)+j;
				int number = input[index];
				if(number == 0) continue;
				if(row.contains(number)) {
					return false;
				}
				
				row.add(number);
			}
		}
		
		Set<Integer> column = new HashSet<>();
		for(int i=0;i<9;i++) {
			column.clear();
			for(int j=0;j<9;j++) {
				int index = (9*j)+i;
				int number = input[index];
				if(number == 0) continue;
				if(column.contains(number)) {
					return false;
				}
				
				column.add(number);
			}
		}

		Set<Integer> block = new HashSet<>();
		for (int i = 0; i < 27;) {
			block.clear();
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					int index = (i * 3) + (9 * j) + (k);
					int number = input[index];
					if(number == 0) continue;
					if(block.contains(number)) {
						return false;
					}
					
					block.add(number);
				}
			}
			if ((i + 1) % 3 == 0) {
				i = i + 7;
			} else {
				i++;
			}
		}
		
		return true;
	}

}
