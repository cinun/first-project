package wazza;


//Need to make a remove hand and pop method
//Insert at the bottom of the deck.
//In this case head is the top of the deck and tail is the bottom


import java.util.Random;
import java.util.Scanner;

import wazza.UnoProj.Node;
import java.io.*;
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
	class Sent{
		String sentence; 
		Sent next; 
		public Sent(String sentence) {
			this.sentence = sentence; 
		}
			
	}
	
	public Node head = null; 
	public Node tail = null; 
	public Sent text_head = null; 
	public Sent text_tail = null; 
	
	public static CreateDeck list = new CreateDeck(); 
	public static CreateDeck hand = new CreateDeck();
	public static CreateDeck pen = new CreateDeck(); 
	
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
	
	public void display_xyz() {
		Sent current = text_head; 
		while(current!=null) {
			System.out.println(current.sentence);
			//output.write(current.sentence);
			current = current.next;
		}
	}
	
	public void create_sentence(String sentence) {
		Sent newText = new Sent(sentence); 
		
		if (text_head == null) {
			text_head = newText; 
			text_tail = newText; 
		}
		else {
			text_tail.next = newText; 
			text_tail = newText;
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
	/* Project 2 UNO Game 
	 * class Hand
	 *By: Sushil G C
	 *Professor: Mario Pitalua Rodriguez
	 *Object Oriented Programming CS 2365-003 Spring 2020
	 *This class is used to create hand and distribute seven cards to individual player in the UNO Game
	 */
	public void sortBubble(String check_color[]) {
		Node current; 
		for (int i = 0 ;i <7; i++) { // loops until an individual gets seven cards
			current = head; 
			for (int j = 0; j < 6; j++){
				if (findIndex(check_color, current.color) < findIndex(check_color, current.next.color)) { //checks the color of the card distributed
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
		for (int i = 0 ;i <7; i++) {  // cards are ranked in ascending order
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
		//Delete one element
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
	/*
	public void display_text() throws FileNotFoundException {
		Sent current = text_head; 
		PrintWriter output =  new PrintWriter(new File("output.txt"));
		output.write("<html>"); 
		output.println("<head>"); 
		output.println("<title>"); 
		output.println("Uno Game in Html </title>"); 
		output.println("</head>"); 
		output.println("<body>"); 
		while(current!=null) {
			String table = "<p>"+current.sentence+"</p>";
			System.out.print("k cha bro?\n"); 
			output.println(table); 
			current = current.next; 
		}
		output.println("</body>"); 
		output.println("</html>"); 
	}*/
	
	void display_text() throws FileNotFoundException{
                try {
            File file = new File("Dataout.html"); 
            Writer output = new BufferedWriter(new FileWriter(file));
            Sent current = text_head; 
            output.write("<html class=\"UNO GAME OUTPUT MODEL\" lang=\"en-us\">\n" + "<head>\n" + "   <title>UNO GAME MODEL | GAME OUTPUT </title>\n" +
                          "</head>\n" +" <body>\n" +"<h1>UNO GAME MODEL | GAME OUTPUT</h1>\n"+
                          "<p><img src=\"header.jpg?raw=true\" alt=\"Workouts\" width=\"500\" height=\"500\" style=\"float:right; margin: 0 0 10px 10px;\" /></p>\n" +                  
                          "<h2> UNO GAME</h2>\n");
            output.write("<html>"); 
            output.write("<head>"); 
            output.write("<title>"); 
            output.write("Uno Game in Html </title>"); 
            output.write("</head>"); 
            output.write("<body>"); 
            while(current!=null) {
                String table = "<p>"+current.sentence+"</p>";
                output.write(table);
                current = current.next;
            }
            output.write("</body>"); 
            output.write("</html>"); 
            output.close();
        }catch (IOException e) {
            System.out.println("Couldn't find any file.\n");
        }
        
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
						//System.out.println("Working on the " + above[remainder]+" Card"+" color "+suits[num]);
						//String opi=  "Working on the " + above[remainder]+" Card"+" color "+suits[num];
						//pen.create_sentence(opi); 
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
			if (exerciseCount[i] > 0) {
				String paper = "For the : "+suits[i] + " card, you total is " + exerciseCount[i] +" "+punishment[i];
				pen.create_sentence(paper);
			}
			else {
				String paper = "No "+punishment[i] +" for this round, since you don't have the card.";
				pen.create_sentence(paper);
			}
		}
	}
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
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
		 
		
		//System.out.println("Sorting the list.");
		
		hand.sortBubble(color_prec);
		hand.sortRank(); 
		
		
		hand.display(); 
		
		hand.play_cards();
		
		pen.display_xyz();
		pen.display_text();
		//Sort end
	}

}
