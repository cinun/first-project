package wazza;

import java.util.Random;
import java.util.Scanner;

import wazza.UnoProj.Node;

public class CreateDeck {

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
		Node current = head ; 
		
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
	
	public void shuffle(int cards_in_the_deck) {
		Random r = new Random();
		Node xyz = head; 
		int temp; 
		String change_color; 
		
		for (int i = 0; i < cards_in_the_deck; i++) {
			temp = xyz.data;
			change_color = xyz.color; 
			
			int index = r.nextInt((cards_in_the_deck-0)+1);
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
		Scanner scanf = new Scanner(System.in); 
		int deck_count; 
		 
		System.out.println("How many decks do you want to use?\n"); 
		deck_count = scanf.nextInt(); 
		int cards_present = deck_count *108; 
		 
		CreateDeck list = new CreateDeck(); 
		int index = 0, card_count = 13; 
		String color = "";
		for (int j = 0; j< deck_count; j++) {
			int count = 1; 
			while(count!= 5) {
				if (count == 1)
					color = "Blue"; 
				else if (count == 2)
					color = "Red"; 
				else if (count == 3)
					color = "Yellow"; 
				else
					color = "Green"; 
				for (int i = 0; i< card_count; i++) {
					 if (i==0) {
						 list.addNode(0, index, color);
						 index = index+1; 
					}
					 else if (i>=1 && i<=12) {
						 	list.addNode(i, index, color);
						 	list.addNode(i, index+1, color);
						 	index = index+2; 
						 }
					 }
					count = count +1; 
				}
				for(int y = 0; y<8; y++) {
					//Adding wild card and +4 to the stack.
					if(y>=0 &&y<4) {
						list.addNode(13, index, "Wild");
						index = index+1; 
					}
					else {
						list.addNode(14, index, "+4 Wild");
						index = index+1; 
					}
						
				}
			}
		System.out.println("Deck before shuffling is");
		list.display(); 
		System.out.println("Deck After shuffling is");
		list.shuffle(cards_present); 
		list.display();
		 
	}

}
