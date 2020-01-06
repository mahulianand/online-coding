package com.anand.geeksforgeeks.array;
/*
 Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 such that the integers in the subsequence are sorted in increasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[].

Output:

Print the sum of maximum sum sequence of the given array.

Constraints:

1 <= T <= 100
1 <= N <= 100
1 <= A[] <= 1000

Example:

Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
For input:
7
1 101 2 3 100 4 5
All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106. 
Hence the output is stated as 106.

Input:
42
468 335 501 170 725 479 359 963 465 706 146 282 828 962 492 996 943 828 437 392 605 903 154 293 383 422 717 719 896 448 727 772 539 870 913 668 300 36 895 704 812 323 

Its Correct output is:
6974

And Your Code's Output is:
3868
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				br.readLine();
				String[] stringNumbers = br.readLine().split(" ");

				int[] numbers = Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();

				int maxSum = 0;

				Node prevNode = null;
				Node[] allNodes = new Node[numbers.length];
				for (int i = 0; i < numbers.length; i++) {
					int currentNumber = numbers[i];
					Node node = new Node(null, currentNumber);
					allNodes[i] = node;
					if(prevNode == null) {
						prevNode = node;
					}else if (prevNode.number < node.number) {
						prevNode.child.add(node);
						node.parent = prevNode;
						node.sum += prevNode.sum;
						prevNode = node;
					}else {
						
						while(prevNode != null && (prevNode.number > node.number)) {
							prevNode = prevNode.parent;
						}
						if(prevNode!=null) {
							prevNode.child.add(node);
							node.parent = prevNode;
							node.sum += prevNode.sum;
							prevNode = node;
						}
					}
					
					if(maxSum < node.sum) {
						maxSum = node.sum;
					}
				}
				
				System.out.println(maxSum);
			}

		} catch (IOException e) {
		}

	}

}

class Node{
	Node parent;
	List<Node> child = new ArrayList<Node>();
	int number;
	int sum;
	
	public Node(Node parent, int number) {
		super();
		this.parent = parent;
		this.number = number;
		this.sum = number;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", sum=" + sum + "]";
	}
	
	
}
