/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

/**
 *
 * @author patha
 */
public class sortRank {
    public void  sortRank() {
		CreateDeck.Node current; 
                CreateDeck.Node head = null;
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
}
