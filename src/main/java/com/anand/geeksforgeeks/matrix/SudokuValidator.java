package com.anand.geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
|-----------------------------------------------|
|	0	1	2	|	3	4	5	|	6	7	8	|
|	9 	10 	11 	|	12	13	14	|	15	16	17	|
|	18	19	20	|	21	22	23	|	24	25	26	|
|-----------------------------------------------|
|	27	28	29	|	30	31	32	|	33	34	35	|
|	36	37	38	|	39	40	41	|	42	43	44	|
|	45	46	47	|	48	49	50	|	51	52	53	|
|-----------------------------------------------|
|	54	55	56	|	57	58	59	|	60	61	62	|
|	63	64	65	|	66	67	68	|	69	70	71	|
|	72	73	74	|	75	76	77	|	78	79	80
|-----------------------------------------------|


 * 
 * */
public class SudokuValidator {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] input = Arrays.stream(br.readLine().trim().split(" ")).filter(a -> !a.isEmpty()).map(String::trim).mapToInt(Integer::parseInt).toArray();
				
				if(isValid(input)) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean isValid(int[] input) {
		Set<Integer> row = new HashSet<>();
		Set<Integer> column = new HashSet<>();
		Set<Integer> block = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			row.clear();
			column.clear();
			for (int j = 0; j < 9; j++) {
				int rowindex = (9 * i) + j;
				int rownumber = input[rowindex];

				if (rownumber == 0) {
					continue;
				}

				if (row.contains(rownumber)) {
					return false;
				}
				row.add(rownumber);

				int columnindex = (9 * j) + i;
				int columnnumber = input[columnindex];

				if (columnnumber == 0) {
					continue;
				}

				if (column.contains(columnnumber)) {
					return false;
				}
				column.add(columnnumber);
			}
		}

		for (int k = 0; k < 27;) {
			block.clear();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					int blockindex = (3 * k) + (9 * i) + j;
					int blocknumber = input[blockindex];
					
					if (blocknumber == 0) {
						continue;
					}

					if (block.contains(blocknumber)) {
						return false;
					}
					block.add(blocknumber);
				}
			}
			if ((k + 1) % 3 == 0) {
				k += 7;
			} else {
				k++;
			}
		}

		return true;
	}

}
