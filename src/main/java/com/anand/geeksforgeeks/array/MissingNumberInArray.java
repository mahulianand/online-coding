package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingNumberInArray {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int size = Integer.parseInt(br.readLine());
				String[] numbers = br.readLine().split(" ");
				int expected = (size * (size+1))/2;
				int sum = Arrays.stream(numbers).parallel().mapToInt(Integer::parseInt).sum();
				System.out.println(expected - sum);
			}
			
		} catch (IOException e) {
		}
	}

}
