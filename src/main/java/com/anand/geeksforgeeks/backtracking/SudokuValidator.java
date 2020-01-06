package com.anand.geeksforgeeks.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
|-----------------------------------------------|
|	0	1	2	|	3	4	5	|	6	7	8	|
|	9	10	11	|	12	13	14	|	15	16	17	|
|	18	19	20	|	21	22	23	|	24	25	26	|
|-----------------------------------------------|
|	27	28	29	|	30	31	32	|	33	34	35	|
|	36	37	38	|	39	40	41	|	42	43	44	|
|	45	46	47	|	48	49	50	|	51	52	53	|
|-----------------------------------------------|
|	54	55	56	|	57	58	59	|	60	61	62	|
|	63	64	65	|	66	67	68	|	69	70	71	|
|	72	73	74	|	75	76	77	|	78	79	80	|
|-----------------------------------------------|

 * */
public class SudokuValidator {

	public static void main(String[] args) {
//		int[] input = new int[] {3,1,6,5,7,8,4,9,2,5,2,9,1,3,4,7,6,8,4,8,7,6,2,9,5,3,1,2,6,3,4,1,5,9,8,7,9,7,4,8,6,3,1,2,5,8,5,1,7,9,2,6,4,3,1,3,8,9,4,7,2,5,6,6,9,2,3,5,1,8,7,4,7,4,5,2,8,6,3,1,9,};
		int[] input = new int[] { 3, 0, 6, 5, 0, 8, 4, 0, 0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 8, 7, 0, 0, 0, 0, 3, 1, 0, 0,
				3, 0, 1, 0, 0, 8, 0, 9, 0, 0, 8, 6, 3, 0, 0, 5, 0, 5, 0, 0, 9, 0, 6, 0, 0, 1, 3, 0, 0, 0, 0, 2, 5, 0, 0,
				0, 0, 0, 0, 0, 0, 7, 4, 0, 0, 5, 2, 0, 6, 3, 0, 0 };

		if(isValid(input)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}

	}

	private static boolean isValid(int[] input) {

		Set<Integer> row = new HashSet<>();
		for(int i=0;i<9;i++) {
//			System.out.println();
			row.clear();
			for(int j=0;j<9;j++) {
				int index = (9*i)+j;
				int number = input[index];
				if(number == 0) continue;
				if(row.contains(number)) {
					return false;
				}
				
				row.add(number);
//				System.out.print(index+ "\t");
			}
		}
		
		Set<Integer> column = new HashSet<>();
		for(int i=0;i<9;i++) {
//			System.out.println();
			column.clear();
			for(int j=0;j<9;j++) {
				int index = (9*j)+i;
				int number = input[index];
				if(number == 0) continue;
				if(column.contains(number)) {
					return false;
				}
				
				column.add(number);
//				System.out.print(index+ "\t");
			}
		}

		Set<Integer> block = new HashSet<>();
		for (int i = 0; i < 27;) {
			//System.out.println();
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
//					System.out.print(index + "\t");
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
