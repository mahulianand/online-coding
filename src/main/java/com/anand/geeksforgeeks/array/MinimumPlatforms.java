package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;

/*
 * 
Given arrival and departure times of all trains that reach a railway station, 
find the minimum number of platforms required for the railway station so that no train waits.

Input:

First line will contain a number T, the number of test cases.
Each test case will contain a number N, the number of trains.
Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
NOTE: Time intervals are in 24 hour format(hhmm),preceding zeros are insignificant.
Consider the example for better understanding of input.

Output:

Print the required answer in separated line.

Constraints:

1<=T<=80
1<=N<=5000

1<=A[i]<=5000

Example:

INPUT:

1
6 
900  940 950  1100 1500 1800
910 1200 1120 1130 1900 2000

OUTPUT:

3

** For More Input/Output Examples Use 'Expected Output' option **

 * */
public class MinimumPlatforms {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] inTimes = Arrays.stream(br.readLine().replaceAll("  ", " ").split(" ")).map(String::trim)
						.mapToInt(Integer::parseInt).toArray();
				int[] outTimes = Arrays.stream(br.readLine().replaceAll("  ", " ").split(" ")).map(String::trim)
						.mapToInt(Integer::parseInt).toArray();

				int[] time = new int[2880];
				for (int i = 0; i < 2880; i++) {
					time[i] = 0;
				}

				Calendar inTimeCal = Calendar.getInstance();
				Calendar outTimeCal = Calendar.getInstance();
				
				for (int train = 0; train < inTimes.length; train++) {
					
					int inTime = inTimes[train];
					inTimeCal.set(Calendar.HOUR_OF_DAY, inTime/100);
					inTimeCal.set(Calendar.MINUTE, inTime%100);
					inTime = inTimeCal.get(Calendar.HOUR_OF_DAY) *60 + inTimeCal.get(Calendar.MINUTE);
					
					int outTime = outTimes[train];
					outTimeCal.set(Calendar.HOUR_OF_DAY, outTime/100);
					outTimeCal.set(Calendar.MINUTE, outTime%100);
					outTime = outTimeCal.get(Calendar.HOUR_OF_DAY) *60 + outTimeCal.get(Calendar.MINUTE);
					
//					System.out.println("InTime : " + inTimes[train] + " Out : " + outTimes[train]);
//					System.out.println("InTime : " + inTime + " Out : " + outTime);
					if(inTime > outTime){
						outTime += 1440;
					}
					
					for (int i = inTime; i <= outTime; i++) {
						time[i]++;
					}
				}

				int noOfPlatforms = 0;
				for (int i = 0; i < time.length; i++) {
					if (time[i] > noOfPlatforms) {
						noOfPlatforms = time[i];
					}
				}
//				System.out.println(Arrays.toString(time));
				System.out.println(noOfPlatforms);

			}

		} catch (IOException e) {
		}

	}

}