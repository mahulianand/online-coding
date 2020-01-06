package com.anand.geeksforgeeks.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver2 {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] input = Arrays.stream(br.readLine().split(" ")).filter(a -> !a.isEmpty())
						.mapToInt(Integer::parseInt).toArray();

				List<Integer> processedIndex = new ArrayList<>(input.length);
				List<Integer> ignoreIndex = new ArrayList<>(input.length);

				for (int index = 0; index < input.length; index++) {
					if (input[index] != 0) {
						ignoreIndex.add(index);
					}
				}

				boolean backtrack = false;
				int first = 1;
				int last = 9;
				for (int index = 0; index < input.length; index++) {
					if (ignoreIndex.contains(index)) {
						if (backtrack) {
							index--;
						}
						continue;
					}

					int start = input[index] == 0 ? first : input[index] + 1;
					for (int n = start; n <= last; n++) {
						input[index] = n;
						if (isValid(input)) {
							processedIndex.add(index);
							backtrack = false;
							break;
						}
					}

					if (!processedIndex.contains(index)) {
						backtrack = true;
						input[index] = 0;
						int lastProcessedIndex = processedIndex.size() - 1;
						index = processedIndex.get(lastProcessedIndex);
						processedIndex.remove(Integer.valueOf(index));// .remove(index);
						index--;
					}

				}

				StringBuilder output = new StringBuilder();
				String space = " ";
				for (int i = 0; i < input.length; i++) {
					output.append(input[i]).append(space);
				}
				System.out.println(output.toString().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isValid(int[] input) {

		Set<Integer> row = new HashSet<>(10);
		for (int i = 0; i < 9; i++) {
			row.clear();
			for (int j = 0; j < 9; j++) {
				int index = (9 * i) + j;
				int number = input[index];
				if (number == 0)
					continue;
				if (row.contains(number)) {
					return false;
				}

				row.add(number);
			}
		}

		Set<Integer> column = new HashSet<>(10);
		for (int i = 0; i < 9; i++) {
			column.clear();
			for (int j = 0; j < 9; j++) {
				int index = (9 * j) + i;
				int number = input[index];
				if (number == 0)
					continue;
				if (column.contains(number)) {
					return false;
				}

				column.add(number);
			}
		}

		Set<Integer> block = new HashSet<>(10);
		for (int i = 0; i < 27;) {
			block.clear();
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					int index = (i * 3) + (9 * j) + (k);
					int number = input[index];
					if (number == 0)
						continue;
					if (block.contains(number)) {
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
