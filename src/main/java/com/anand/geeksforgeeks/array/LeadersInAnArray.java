package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeadersInAnArray {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] stringNumbers = br.readLine().split(" ");

				int[] numbers = Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();

				String output = numbers[numbers.length - 1] + " ";
				int max = numbers[numbers.length - 1];
				for (int i = numbers.length - 2; i >= 0; i--) {
					if (numbers[i] > max) {
						output = numbers[i] + " " + output;
						max = numbers[i];
					}
				}
				System.out.println(output.trim());
			}
		} catch (IOException e) {
		}

	}

}
