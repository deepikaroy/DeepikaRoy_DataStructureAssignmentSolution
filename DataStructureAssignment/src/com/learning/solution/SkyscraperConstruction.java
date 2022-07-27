package com.learning.solution;

import java.util.LinkedList;
import java.util.Scanner;

public class SkyscraperConstruction 
{	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int numOfFloors = sc.nextInt();

		LinkedList<Integer> floorSizeList = new LinkedList<Integer>();
		for(int i=1; i<=numOfFloors; i++)
		{
			System.out.println("enter the floor size given on day : " + i);
			floorSizeList.add(sc.nextInt());
		}
		
		System.out.println("The order of construction is as follows:");
		generateOrderOfConstruction(floorSizeList, numOfFloors);

	}

	private static void generateOrderOfConstruction(LinkedList<Integer> floorSizeList, int max)
	{
		int i=max;
		int j=1;
		LinkedList<Integer> skippedList = new LinkedList<Integer>();
		
		while(!floorSizeList.isEmpty())
		{
			int ele = floorSizeList.poll();
			
			System.out.println("Day: " + j);
			
			if(ele != max)
			{
				skippedList.add(ele);				
				System.out.println();
			}
			else
			{
				System.out.print(max + " ");				
				max--;
				
				while(skippedList.size()> 0)
				{
					if(skippedList.contains(max))
					{ 
						skippedList.remove(Integer.valueOf(max));
						System.out.print(max + " ");		
						max--;
					}
					else if(i<=max)
					{
						break;
					}
				}
				
				System.out.println();				
			}
			i--; 
			j++;
		}
	}
}
