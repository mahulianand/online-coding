package com.anand.geeksforgeeks.bit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 The whitewalkers are here and the Great War is on. Each and every living being is giving their best to save the world from the dead. Arya fighting with full dedication found that whitewalkers need to be killed with a pattern or else they wont die. So that she can fight till the end of the war. She tried to understand the pattern.  She kills every  'Xth'  whitewalker by stabbing them  'N'  times .

Whitewalker approaching order ( X )         Number of times - stabbing ( N )
1                                                                1
2                                                                1
3                                                                2
.                                                                 .
.                                                                 .
55                                                              5
.                                                                 .
98                                                              3
.                                                                  .
.                                                                  .
101                                                             4
.                                                                  .
.                                                                  .
.                                                                  .

198                                                              4
 

This is the hint of the pattern that Arya needs to follow  . Help Arya !
Input:   The first line of the input contains an integer T denoting the number of test cases. The description of each testcase follows. Each test case contains a single line with one  integer ' X ' the Xth whitewalker  .
Output:    For each test case output a new line with ' N '  the number of stabs required to kill the '  Xth  ' whitewalker  .
Constraints:        1 < = T  < = 1000
                    1 < = X < = 500
Example: 

Input:
4
102
95
72
60

Output:
4
6
2
4
 * */
public class AryaAndTheGreatWar {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				Integer input = Integer.valueOf(br.readLine().trim());
				String binaryString = Integer.toBinaryString(input);
				char[] charArray = binaryString.toCharArray();
				
				int stabCount = 0;
				for (int index = 0; index < charArray.length; index++) {
					if(charArray[index] == '1') {
						stabCount++;
					}
				}

				System.out.println(stabCount);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
