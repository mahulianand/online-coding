package com.anand.geeksforgeeks.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given a linked list, check if the the linked list has a loop. Linked list can contain self loop.

Input:

In this problem, method takes one argument: the head of the linked list. The function should not read any input from stdin/console.
The node structure has a data part which stores the data and a next pointer which points to the next element of the linked list. 
There are multiple test cases. For each test case, this method will be called individually.

Output:

Return 1 if linked list has a loop else 0.

Constraints:

1<=T<=50
1<=N<=300

Example:

Input:

2
3
1 3 4
2
4
1 8 3 4
0

Output:

True
False

Explaination:

In above test case N = 3

The linked list with nodes N = 3 is given. Then value of x=2 is given which means last node is connected with xth node of linked list. Therefore, there exists a loop. 

For N = 4
x = 0 means then lastNode->next = NULL, then the Linked list does not contains any loop.
 * */
public class DetectLoopInLinkedList {

	/*
	 * Please note that it's Function problem i.e. you need to write your solution
	 * in the form of Function(s) only. Driver Code to call/invoke your function is
	 * mentioned above.
	 */

	/*
	 * Node is defined as class Node { int data; Node next; Node(int d) {data = d;
	 * next = null; } }
	 */

	int detectLoop(Node head) {
		Set<Node> nodes = new HashSet<>();
		int returnValue = 1;
		try {
			while (head.next != null) {
				System.out.println(head.data);
				if (nodes.contains(head.next)) {
					head.next = head.next.next;
					returnValue = 0;
				}
				nodes.add(head.next);
				head = head.next;
			}
		} catch (Exception e) {
			returnValue = 0;
		}
		return returnValue;
		// Add code here
	}

}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}
