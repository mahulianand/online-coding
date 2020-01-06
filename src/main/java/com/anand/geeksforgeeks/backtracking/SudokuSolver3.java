package com.anand.geeksforgeeks.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SudokuSolver3 {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] input = Arrays.stream(br.readLine().split(" ")).filter(a -> !a.isEmpty())
						.mapToInt(Integer::parseInt).toArray();

				Map<Integer, List<Integer>> mapOfIndexToAvailableNumbers = new HashMap<>();
				List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
				for(int index=0; index < 81; index++) {
					mapOfIndexToAvailableNumbers.put(index, new ArrayList<>(nums));
				}
				
				init(input, mapOfIndexToAvailableNumbers);
				
				List<Integer> processedIndex = new ArrayList<>(input.length);
				List<Integer> ignoreIndex = new ArrayList<>(input.length);

				int count =0;
				for (int index = 0; index < input.length; index++) {
					if (input[index] != 0) {
						ignoreIndex.add(index);
					}
				}

				boolean backtrack = false;
				int first = 1;
				int last = 9;
				for (int index = 0; index < input.length; index++) {
					count++;
					if (ignoreIndex.contains(index)) {
						if (backtrack) {
							index-=2;
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
			System.out.println(count);
				System.out.println(output.toString().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void init(int[] input, Map<Integer, List<Integer>> mapOfIndexToAvailableNumbers) {
		
	}

	private static boolean isValid(int[] input) {

		Set<Integer> row = new HashSet<>(10);
		Set<Integer> column = new HashSet<>(10);

		for (int i = 0; i < 9; i++) {
			row.clear();
			column.clear();
			for (int j = 0; j < 9; j++) {
				int rowindex = (9 * i) + j;
				int rownumber = input[rowindex];
				if (rownumber != 0) {
					if (row.contains(rownumber)) {
						return false;
					}
					row.add(rownumber);
				}

				int colindex = (9 * j) + i;
				int colnumber = input[colindex];
				if (colnumber != 0) {
					if (column.contains(colnumber)) {
						return false;
					}

					column.add(colnumber);
				}
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
