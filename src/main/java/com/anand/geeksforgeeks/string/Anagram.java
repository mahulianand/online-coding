package com.anand.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 
 * Given two strings, check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, �act� and �tac� are anagram of each other.

Input:

The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, in a separate line.

Output:

Print "YES" without quotes if the two strings are anagram else print "NO".

Constraints:

1 <= T <= 30

1 <= |s| <= 100

Example:

Input:
2
geeksforgeeks
forgeeksgeeks
allergy
allergic

1
jkhksahlkj
skhjklj

Output:
YES
NO
 * */
public class Anagram {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				String firstString = br.readLine().trim();
				String secondString = br.readLine().trim();

				Map<String, Integer> charCount = new HashMap<>();
				for (int charIndex = 0; charIndex < firstString.length(); charIndex++) {
					String charAt = firstString.charAt(charIndex) + "";
					if (charCount.containsKey(charAt)) {
						charCount.put(charAt, charCount.get(charAt) + 1);
					} else {
						charCount.put(charAt, 1);
					}
				}

				boolean anagram = true;

				for (int charIndex = 0; charIndex < secondString.length(); charIndex++) {
					String charAt = secondString.charAt(charIndex) + "";
					if (charCount.containsKey(charAt) && charCount.get(charAt) > 0) {
						int count = charCount.get(charAt) - 1;
						if(count < 1) {
							charCount.remove(charAt);
						}else {
							charCount.put(charAt, count);
						}
					} else {
						anagram = false;
					}
				}

				System.out.println(anagram && charCount.isEmpty() ? "YES" : "NO");

			}
		} catch (Exception e) {

		}
	}
}
