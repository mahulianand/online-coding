package com.anand.geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to print a solution of the Sudoku. 
 For simplicity you may assume that there will be only one unique solution.

Example


For the above configuration the solution is
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9


Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow. 
Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case in a new line print the space separated values of the solution of the the sudoku.

Constraints:
1<=T<=10
0<=mat[]<=9

Example:
Input:
1
3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2 5 2 9 1 3 4 7 6 8 4 8 7 6 2 9 5 3 1 2 6 3 4 1 5 9 8 7 9 7 4 8 6 3 1 2 5 8 5 1 7 9 2 6 4 3 1 3 8 9 4 7 2 5 6 6 9 2 3 5 1 8 7 4 7 4 5 2 8 6 3 1 9
 * */
public class SolveTheSudoku {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int noOfTests = Integer.parseInt(br.readLine());

			for (int testNo = 0; testNo < noOfTests; testNo++) {
				int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

				Sudoku sudoku = new Sudoku(input);
				Node<Sudoku> rootParentNode = null;
				Node<Sudoku> rootNode = new Node<Sudoku>(sudoku, rootParentNode);

				Node<Sudoku> currentNode = rootNode;
				
				while(currentNode.getValue().isComplete()) {
					
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Node<T> {
	Node<T> parent;
	T value;
	List<Node<T>> childrens;

	int currentSizeIndex = 0;

	public Node(T value, Node<T> parent) {
		this.value = value;
		this.parent = parent;
		this.currentSizeIndex = 0;
	}

	public Node(Node<T> copy) {
		this.value = copy.value;
		this.parent = copy.parent;
		this.childrens = copy.childrens;
		this.currentSizeIndex = 0;
	}

	public boolean reject() {
		return false;
	}

	public boolean accept() {
		return false;
	}

	public boolean hasMoreChildren() {
		if (childrens.size() - 1 > currentSizeIndex) {
			return true;
		}
		return false;
	}

	public Node<T> getNextChildren() {
		return childrens.get(currentSizeIndex++);
	}

	public Node<T> getParent() {
		return parent;
	}

	public void addChildren(Node<T> child) {

	}

	public T getValue() {
		return value;
	}
}

class Sudoku {
	int[] grid;
	int lastUpdatedIndex = -1;

	public Sudoku(int[] grid) {
		this.grid = grid;
	}
	
	public boolean isComplete() {
		for (int index = 0; index < grid.length; index++) {
			if (grid[index] == 0) {
				return false;
			}
		}

		if (!isValid()) {
			return false;
		}

		return true;
	}

	public boolean isValid() {
		Set<Integer> row = new HashSet<>();
		Set<Integer> column = new HashSet<>();
		Set<Integer> block = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			row.clear();
			column.clear();
			for (int j = 0; j < 9; j++) {
				int rowindex = (9 * i) + j;
				int rownumber = grid[rowindex];

				if (rownumber == 0) {
					continue;
				}

				if (row.contains(rownumber)) {
					return false;
				}
				row.add(rownumber);

				int columnindex = (9 * j) + i;
				int columnnumber = grid[columnindex];

				if (columnnumber == 0) {
					continue;
				}

				if (column.contains(columnnumber)) {
					return false;
				}
				column.add(columnnumber);
			}
		}

		for (int k = 0; k < 27;) {
			block.clear();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					int blockindex = (3 * k) + (9 * i) + j;
					int blocknumber = grid[blockindex];

					if (blocknumber == 0) {
						continue;
					}

					if (block.contains(blocknumber)) {
						return false;
					}
					block.add(blocknumber);
				}
			}
			if ((k + 1) % 3 == 0) {
				k += 7;
			} else {
				k++;
			}
		}

		return true;
	}
}
