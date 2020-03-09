package wazza;


//Need to make a remove hand and pop method
//Insert at the bottom of the deck.
//In this case head is the top of the deck and tail is the bottom


import java.util.Random;
import java.util.Scanner;

import wazza.UnoProj.Node;

public class CreateDeck {

	class Node{
		int data;
		int index; 
		String color; 
		Node next, prev; 
		
		public Node (int data, int index, String color) {
			this.data = data; 
			this.index = index; 
			this.color = color;
			this.next = null;
			this.prev = null; 
			}
		}
	
	public Node head = null; 
	public Node tail = null; 
	
	public static CreateDeck list = new CreateDeck(); 
	public static CreateDeck hand = new CreateDeck();
	
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
		String above[] = {"+4", "Wild", "Reverse", "+2", "Skip"};
		if (current == null) {
			System.out.println("List is empty.\n");
			return; 
		}
		//System.out.println("Nodes of singly linked list:\n");
		while (current != null) {
			if(current.data > 9)
				System.out.print(above[14-current.data]+"<>"+current.color+" "); 
			else
				System.out.print(current.data+"<>"+current.color+" ");
			current = current.next; 
		}
		System.out.println(); 
	}
	
	public void shuffle(int deck_count) {
		Random r = new Random();
		Node xyz = head; 
		int temp, cards_in_the_deck = deck_count *108; 
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
	
	public void create_deck(int deck_count) {
		
		int cards_present = deck_count *108; 
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
						 addNode(0, index, color);
						 index = index+1; 
					}
					 else if (i>=1 && i<=12) {
						 	addNode(i, index, color);
						 	addNode(i, index+1, color);
						 	index = index+2; 
						 }
					 }
					count = count +1; 
				}
				for(int y = 0; y<8; y++) {
					//Adding wild card and +4 to the stack.
					if(y>=0 &&y<4) {
						addNode(13, index, "");
						index = index+1; 
					}
					else {
						addNode(14, index, "");
						index = index+1; 
					}
						
				}
			}
	}
	
	public static int findIndex(String arr[], String t) 
    { 
        if (arr == null) { 
            return -1; 
        } 

        int len = arr.length; 
        int i = 0; 
 
        while (i < len) { 
            if (arr[i] == t) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    } 

	public void sortBubble(String check_color[]) {
		Node current; 
		for (int i = 0 ;i <7; i++) {
			current = head; 
			for (int j = 0; j < 6; j++){
				if (findIndex(check_color, current.color) < findIndex(check_color, current.next.color)) {
					int temp_data = current.data;
					String temp_color = current.color; 
					int temp_index = i; 	//current.index; 
					current.data = current.next.data; 
					current.color = current.next.color; 
					current.index = current.next.index; 
					current.next.data = temp_data; 
					current.next.color = temp_color; 
					current.next.index = temp_index; 
				}
				current = current.next; 
			}
		}
	}
	public void sortRank() {
		Node current; 
		for (int i = 0 ;i <7; i++) {
			current = head; 
			for (int j = 0; j < 6; j++){
				if ((current.data > current.next.data) && (current.color == current.next.color)) {
					int temp_data = current.data;
					current.data = current.next.data; 
					current.next.data = temp_data; 
				}
				current = current.next; 
			}
		}
	}
	public void pop(String del) {
		Node current = head; 
		//Delete one elem
	}
	public void delete_hand() {
		//Method that removes 7 card from the deck to form a hand
		
	}
	public static void add_start(int data, int index, String color) {
		//Node current = list.head; 
		Node newNode = list.new Node(data, index, color);
		newNode.prev = list.tail; 
		list.tail.next = newNode; 
		list.tail = newNode;
		
	}
	
	public void play_cards(){
		Node current = head; 
		if (current == null )
			System.out.println("Current is null");
		System.out.print("Inside the play_cards method.\n");
		String above[] = {"+4", "Wild", "Reverse", "+2", "Skip"};
		int exerciseCount[] = {0,0,0,0,0}; //Last element for the  
		String suits[] = {"Blue", "Yellow", "Red", "Green", ""}; 
		String punishment[] = {"Push Ups", "Squat", "Sit Ups", "Lunges", "Burpees"};
		while(current!=null){
			for (int i = 0; i<4; i++) {
				if (current.data <= 9 && current.color == suits[i])
					exerciseCount[i] = exerciseCount[i] + current.data;
				if (current.data > 9 && current.color == suits[i]) {
					int remainder = 14-current.data; 
					int num;
					if (remainder == 3) {
						num = findIndex(suits, current.color);
						System.out.println("Working on the " + above[remainder]+" Card"+" color "+suits[num]);
						exerciseCount[num] += exerciseCount[num]; 
					}
					if (remainder == 0){
						for (int j = 0; j<4; i++)
							exerciseCount[j] = exerciseCount[j]*4;
						exerciseCount[4] = 10; 
					}
					//if (remainder == 1)
						//Do nothing, Wild card
					if (remainder == 2) {
						//Except the reverse card all the other cards are discarded
						
					}
						
				}
						
			}
			current = current.next; 
		}
		
		for (int i = 0; i<5; i++) {
			if (exerciseCount[i] > 0)
				System.out.println("For the : "+suits[i] + " card, you total is " + exerciseCount[i] +" "+punishment[i]);
			else
				System.out.println("No "+punishment[i] +" for this round, since you don't have the card.");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*
		CreateDeck list = new CreateDeck(); 
		CreateDeck hand = new CreateDeck();
		*/
		Scanner scanf = new Scanner(System.in); 
		int deck_count; 
		 
		System.out.println("How many decks do you want to use?\n"); 
		deck_count = scanf.nextInt(); 
		
		list.create_deck(deck_count);
		Node current = list.head; 
		System.out.println("Deck before shuffling is");
		list.display(); 
		System.out.println("Deck After shuffling is");
		list.shuffle(deck_count); 
		list.display();
		for (int i = 0; i< 7; i++) {
			hand.addNode(current.data, current.index, current.color);
			current = current.next; 
		}
		System.out.println("Your hand is :\n"); 
		hand.display(); 
		 
		String color_prec[] = {"+4","Wild","Green", "Red", "Yellow", "Blue"}; 
		 
		
		System.out.println("Sorting the list.");
		
		hand.sortBubble(color_prec);
		hand.sortRank(); 
		
		
		hand.display(); 
		
		hand.play_cards();
		//Sort end
	}

}
