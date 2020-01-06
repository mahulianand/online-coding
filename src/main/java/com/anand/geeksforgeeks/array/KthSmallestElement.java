package com.anand.geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 Given an array and a number k where k is smaller than size of array, the task is to find the k�th smallest element in the given array. 
 It is given that all array elements are distinct.

Input:

First Line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. Each test case consists of three lines. 
First line of each test case contains an integer N denoting size of the array. 
Second line contains N space separated integer denoting elements of the array. 
Third line of the test case contains an integer K.

Output:

Corresponding to each test case, print the desired output in a new line.

Constraints:

1<=T<=200
1<=N<=1000
K

Expected Time Complexity: O(n)

Example:

INPUT
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:

7
15
 * */
public class KthSmallestElement {
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int size = Integer.parseInt(br.readLine());
				int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int k = Integer.parseInt(br.readLine());

				MinHeap minHeap = new MinHeap(size + 1);
				for (int index = 0; index < numbers.length; index++) {
					minHeap.insert(numbers[index]);
				}

				int kthElement = 0;
				for (int i = 0; i < k; i++) {
					kthElement = minHeap.remove();
				}
				System.out.println(kthElement);
			}

		} catch (IOException e) {
		}
	}

}

class MinHeap {

	/*
	 * Use array to store the data. Start storing from index 1, not 0. For any
	 * given node at position i: Its Left Child is at [2*i] if available. Its
	 * Right Child is at [2*i+1] if available. Its Parent Node is at [i/2]if
	 * available
	 */
	int[] heap = null;
	int currentSize = 0;

	public MinHeap(int heapSize) {
		heap = new int[heapSize];
	}

	public void insert(int number) {

		currentSize++;
		heap[currentSize] = number;

		for (int index = currentSize; index > 0; index = index / 2) {
			int parentIndex = index / 2;
			if (heap[index] < heap[parentIndex]) {
				int temp = heap[parentIndex];
				heap[parentIndex] = heap[index];
				heap[index] = temp;
			}
		}
	}

	public int remove() {

		int returnValue = heap[1];
		heap[1] = heap[currentSize];
		heap[currentSize] = 0;
		currentSize--;
		int leftChild = -1;
		int rightChild = -1;
		for (int index = 1; index <= currentSize;) {
			int rightChildIndex = 2 * index + 1;
			int leftChildIndex = 2 * index;

			int childIndex = 0;
			if (rightChildIndex <= currentSize) {
				rightChild = heap[rightChildIndex];
				childIndex = rightChildIndex;
			}

			if (leftChildIndex <= currentSize) {
				leftChild = heap[leftChildIndex];
				if (rightChild < 1 || rightChild > leftChild)
					childIndex = leftChildIndex;
			}

			if (childIndex != 0 && childIndex <= currentSize && heap[index] > heap[childIndex]) {
				int temp = heap[childIndex];
				heap[childIndex] = heap[index];
				heap[index] = temp;
				index = childIndex;
			} else {
				break;
			}
		}
		return returnValue;
	}

	@Override
	public String toString() {
		return Arrays.toString(heap);
	}
}