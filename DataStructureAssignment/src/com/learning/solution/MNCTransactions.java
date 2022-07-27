package com.learning.solution;

/*
sort the BST, i.e. do an inorder traversal
insert the inorder elements in Right Skewed BST
*/


public class MNCTransactions 
{
	static Node rightSkewedRoot = null;
	
	static class Node
	{
		int data; 
		Node left, right;
	}

	static Node newNode(int data)
	{
		Node node = new Node();
		node.data = data; 
		node.left = null;
		node.right = null;

		return node;		
	}

	static Node insert(Node root, int data)
	{
		if(root == null)
		{
			root = newNode(data); return root;
		}

		if(data < root.data)
		{
			root.left = insert(root.left, data);
		}
		else if (data > root.data)
		{
			root.right = insert(root.right, data);
		}
		else 
		{
			System.out.println("Cannot insert Duplicate values");
		}

		return root;
	}

	static Node insertRightNode(Node root, int data)
	{
		if(root == null)
		{
			root = newNode(data); 
			return root;
		}

		root.right = insert(root.right, data);
		return root;
	}


	static void inOrder(Node root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);		
		rightSkewedRoot = insertRightNode(rightSkewedRoot, root.data);
		inOrder(root.right);
	}

	static void print(Node root)
	{
		if(root == null)
			return;
		
		while(root !=null)
		{
			System.out.print(root.data + "  ");
			root = root.right;
		}
	}

	public static void main(String[] args) 
	{
		int[] transactions = {50, 30, 60, 10, 55};		
		Node root = null;
		
		for (int i = 0; i < transactions.length; i++)
		{
			root = insert(root, transactions[i]);
		}
		
		inOrder(root);
		System.out.println("Right Skewed BST");
		print(rightSkewedRoot);

	}

}
