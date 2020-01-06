package com.anand.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DefaultTemplate {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int size = Integer.parseInt(br.readLine());
				String[] numbers = br.readLine().split(" ");
			}
			
		} catch (IOException e) {
		}
	}

}
