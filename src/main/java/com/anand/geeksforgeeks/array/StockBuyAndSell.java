package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 

Input:
First line contains number of test cases T. Each test case contain the integer value 'N' denoting days followed by an array of stock prices in N days.
Output:
The maximum profit is displayed as shown below. And if there is no profit then print "No Profit".


Constraints:
1 <=T<= 100
2 <=N<= 100
1 <=arr[i]<= 10000


Example

Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:

(0 3) (4 6) 
(1 4) (5 9) 
Notice: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.

** For More Input/Output Examples Use 'Expected Output' option **

 * */
public class StockBuyAndSell {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				boolean buy = false;
				StringBuilder output = new StringBuilder();
				for (int i = 0; i < numbers.length; i++) {
					if (!buy) {
						if (i + 1 < numbers.length) {
							if (numbers[i] > numbers[i + 1]) {
								continue;
							} else {
								output.append("(").append(i).append(" ");
								buy = true;
							}
						}
					} else {
						if (!((i + 1) == numbers.length) && (numbers[i] < numbers[i + 1])) {
							continue;
						} else {
							output.append(i).append(")").append(" ");
							buy = false;
						}
					}
				}
				String profit = output.toString().trim();
				if(profit.isEmpty()){
					System.out.println("No Profit");
				}else{
					System.out.println(profit);	
				}
				
			}

		} catch (IOException e) {
		}
	}

}
