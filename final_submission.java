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
		Sent prev; 
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
			//System.out.println(current.sentence);
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
			newText.prev = text_tail ;
			text_tail = newText;
		}
	}
	
	public void display() {
		Node current = head ; 
		String above[] = {"+4", "Wild", "Reverse", "+2", "Skip"};
		String final_hand = ""; 
		if (current == null) {
			System.out.println("List is empty.\n");
			return; 
		}
		//System.out.println("Nodes of singly linked list:\n");
		while (current != null) {
			if(current.data > 9) {
				//System.out.print(above[14-current.data]+"<>"+current.color+" "); 
				String card = above[14-current.data]+"<>"+current.color+" ";
				final_hand = final_hand + card; 
			}
			else {
				//System.out.print(current.data+"<>"+current.color+" ");
				String card = current.data+"<>"+current.color+" ";
				final_hand = final_hand + card;
			}
			current = current.next; 
		}
		
		//System.out.println(final_hand); 
		pen.create_sentence(final_hand);
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
						addNode(14, index, "N");
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
				if (current!= null && current.next != null && findIndex(check_color, current.color) < findIndex(check_color, current.next.color)) { //checks the color of the card distributed
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
				if (current!=null)
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
	
	public void display_text() throws FileNotFoundException{
		try {
			File file = new File("yathartha.html"); 
			Writer output = new BufferedWriter(new FileWriter(file));
			Sent current = text_head; 
			output.write("<html class=\"UNO GAME OUTPUT MODEL\" lang=\"en-us\">\n" + "<head>\n" + "   <title>UNO GAME MODEL | GAME OUTPUT </title>\n" +
                    "</head>\n" +" <body>\n" +"<h1>UNO GAME MODEL | GAME OUTPUT</h1>\n"+
                    "<p><img src=\"https://github.com/cinun/first-project/blob/master/header.jpg?raw=true\" alt=\"Workouts\" width=\"500\" height=\"500\" style=\"float:right; margin: 0 0 10px 10px;\" /></p>\n" +                  
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
		String suits[] = {"Blue", "Yellow", "Red", "Green", "N"}; 
		String punishment[] = {"Push Ups", "Squat", "Sit Ups", "Lunges", "Burpees"};
		int present = 0;
		//int i = 0; 
		while(current!=null ){
			int remainder = 14-current.data;
			for (int i = 0; i<4; i++) {
				//int remainder = 14-current.data; 
				//System.out.println("Working on the" + above[remainder]+" Card"+" color ");
				if (i < 4 && current.data <= 9 && current.color == suits[i] ) {
					exerciseCount[i] = exerciseCount[i] + current.data;
					if (current.data == 0)
						pen.create_sentence("You got a Zero YOOO!!! Enjoy a 1 min break");
					i++;
				}
				else if (current.data > 9) {
					//int remainder = 14-current.data; 
					//remainder = (14-current.data);
					int num;
					if (remainder == 0){ 
						//System.out.println("+4 thap");
						present = 1; /*
						for (int s = 0 ; s< 4; s++) {
							exerciseCount[s] *=4; 
						}
						exerciseCount[4] += 10; */
						
					} 
					if (remainder == 3) {
						num = findIndex(suits, current.color);
						exerciseCount[num] += exerciseCount[num]; 
					}
					else if (remainder == 2) {
						int count = 0, add; 
						//Except the reverse card all the other cards are added to the bottom of the pile;
						add = findIndex(suits, current.color); 
						exerciseCount[add] = 0; 
						while( i< 4 && suits[i] == current.color && current.prev!=null) {
							current = current.prev;
							count++; 
						}
						for (int c = 0; c <= count; c++) {
							if (current.next != null && current.data <=9) {
								list.addNode(current.data, current.index, current.color);	
								current = current.next; 
							}
						}
						
					}
						
				}
						
			}
				//i++;
			current = current.next; 
		}
		int total = 0; 
		String paper = "";
		if (present==1)
			exerciseCount[4] += 10; 
		for (int x = 0; x<5; x++) {
			total = exerciseCount[x];
			if (exerciseCount[x] > 0) {
				if (present == 1 ) {
					paper  = "For the : "+suits[x] + " card, you total is "+(total*4) + " "+punishment[x];
					}
				else
					paper = "For the : "+suits[x] + " card, you total is "+(total) + " "+punishment[x];
				 
				pen.create_sentence(paper);
			}
			else {
				paper = "No "+punishment[x] +" for this round, since you don't have the card.";
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
		 
		
		/*
		//list.create_deck(deck_count);
		Node current = list.head; 
		System.out.println("Deck before shuffling is");
		list.display(); 
		System.out.println("Deck After shuffling is");
		list.shuffle(deck_count); 
		list.display();
		for (int i = 0; i< 7; i++) {
			hand.addNode(current.data, current.index, current.color);
			list.head  = list.head.next; 
		}
		System.out.println("Your hand is :\n"); 
		hand.display(); 
		 
		String color_prec[] = {"+4","Wild","Green", "Red", "Yellow", "Blue"}; 
		 
		//System.out.println("Sorting the list.");
		
		hand.sortBubble(color_prec);
		hand.sortRank(); 
		
		
		hand.display(); 
		
		hand.play_cards();
		
		//pen.display_xyz();
		pen.display_text();
		
		list.display();
		*/
		//pen.display();
		//Sort end
		
		
		//Loop to read all the cards
		System.out.println("How many decks do you want to use?\n"); 
		deck_count = scanf.nextInt(); 
		list.create_deck(deck_count);
		int shuf_deck = 1; 
		while(list.head!= null && shuf_deck>=0) {
			//list.display();
			//int shuf_deck; 
			System.out.println("Do you want to shuffle the deck? (Press -1 to exit)"); 
			shuf_deck = scanf.nextInt();
			if (shuf_deck == -1)
				break; 
			if (shuf_deck == 1) {
				list.shuffle(deck_count);
				System.out.println("List has been Shuffled");
				//list.display();
			}
			//Creating a hand for a round
			int end = 1; 
			while(list.head!=null && end <= 7) {
				hand.addNode(list.head.data, list.head.index, list.head.color);
				end = end +1; 
				list.head = list.head.next;
			}
			
		
			String color_prec[] = {"+4","Wild","Green", "Red", "Yellow", "Blue"}; 
			hand.sortBubble(color_prec);
			int show_list = 0; 
			System.out.println("Do you want to view the deck.(1 or 0)\n");
			show_list = scanf.nextInt();
			if (show_list == 1) {
				list.display();
			}
			hand.display(); 
			hand.play_cards();
			hand.display();
			
			hand.head = hand.tail = null; 
			
			pen.display_text();
			if(list.head!=null)
				list.head = list.head.next;
			
			
			
		}
		
		
	}

}
