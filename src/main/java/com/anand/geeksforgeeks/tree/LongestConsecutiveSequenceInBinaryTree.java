package com.anand.geeksforgeeks.tree;

public class LongestConsecutiveSequenceInBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n4;

        n2.left = n3;

        n4.left = n5;
        n4.right = n6;
        n6.left = n7;

        System.out.println(longestConsecutive(n1));

    }

    public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = longestConsecutive(root, root.left);
        int right = longestConsecutive(root, root.right);

        if (left == -1 && right == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }

    public static int longestConsecutive(TreeNode prev, TreeNode current) {
        if (prev == null || current == null) {
            return -1;
        }

        int max = Math.max(longestConsecutive(current, current.left), longestConsecutive(current, current.right));
        if (prev.key + 1 == current.key) {
            if (max < 0) max = 0;
            return max + 1;
        }

        return max;
    }
}

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }

    @Override
    public String toString() {
        return "[key= " + key + ", left= " + left + ", right= " + right + "]";
    }
}