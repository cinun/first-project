/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;
import java.util.Scanner;

import java.io.*;
/**
 *
 * @author patha
 */
public class main {
    
    public static CreateDeck list = new CreateDeck(); 
    public static CreateDeck hand = new CreateDeck();
    public static CreateDeck pen = new CreateDeck();
    public CreateDeck.Node head = null;
    
    
    
    public void play_cards(){
		CreateDeck.Node current = head; 
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
						num = findIndex.findIndex(suits, current.color);
						exerciseCount[num] += exerciseCount[num]; 
					}
					else if (remainder == 2) {
						int count = 0, add; 
						//Except the reverse card all the other cards are added to the bottom of the pile;
						add = findIndex.findIndex(suits, current.color); 
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
