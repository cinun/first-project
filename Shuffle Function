package wazza;

import java.math.*;
import java.util.Random;
public class UnoProj {
	
	class Node{
		int data;
		int index; 
		String color; 
		Node next; 
		
		public Node (int data, int index, String color) {
			this.data = data; 
			this.index = index; 
			this.color = color;
			this.next = null;
			}
		}
	
	public Node head = null; 
	public Node tail = null; 
	
	public void addNode(int data, int index, String color) {
		Node newNode = new Node(data, index, color);
		
		if (head == null) {
			head = newNode; 
			tail = newNode; 
		}
		else {
			tail.next = newNode; 
			tail = newNode;
		}
	}
	
	public void display() {
		Node current = head; 
		
		if (current == null) {
			System.out.println("List is empty.\n");
			return; 
		}
		System.out.println("Nodes of singly linked list:\n");
		while (current != null) {
			System.out.print(current.data + "<>"+current.index+"<>"+current.color+"  ");
			current = current.next; 
		}
		System.out.println(); 
	}
	
	
	public void shuffle() {
		Random r = new Random();
		Node xyz = head; 
		int temp; 
		String change_color; 
		
		for (int i = 0; i<53; i--) {
			temp = xyz.data;
			change_color = xyz.color; 
			
			int index = r.nextInt((52-0)+1);
			//System.out.println("Your random index is:"+index+"\n");
			Node current = head; 
			while(current!= null) { 
				if (current.index == index) {
					int x = current.data; 
					String y = current.color; 
					current.data = temp;
					current.color = change_color; 
					xyz.data = x;
					xyz.color = y; 
				}
				current = current.next; 
			}
			if(xyz.next==null)
				break;
			xyz = xyz.next; 
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnoProj list = new UnoProj(); 
		 for (int i = 0; i< 52; i++) {
			 if(i>=0 &&i<12)
				 list.addNode(i, i, "Blue");
			 else if (i>=13 && i<33)
				 list.addNode(i, i, "Red");
			 else
				 list.addNode(i, i, "Yellow");
			 System.out.println("Adding "+i+" to the list.\n"); 
		 }
		 System.out.println("Before shuffling list is:\n");
		 list.display(); 
		 System.out.println("After shuffling list is:\n");
		 list.shuffle();
		 list.display();
	}

}

