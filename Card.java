public class Card{

	public static String[] RANKS = {"0","1","1","2","2","3","3","4","4","5",
							"5","6","6","7","7","8","8","9","9","Skip","Skip",
							"Reverse","Reverse","Draw 2","Draw 2","Wild","Wild 4"};

	public static String[] COLORS = {"","RED","BLUE","GREEN","YELLOW"};

	private final int rank;
	private final int color;

	public static Card[] cards = new Card[108];

	public Card (int rank, int color){
		this.rank = rank;
		this.color = color;
	}

	public String get_unoCard(){
		if (rank <= 24)
			return RANKS[this.rank] + " of " + COLORS[this.color];
		else
			return RANKS[this.rank];
	}

	public int getRank(){
		return this.rank;
	}

	public int getColor(){
		return this.color;
	}

	public static int search(Card[] cards, Card target){
		for(int i = 0; i< cards.length; i++){
			if (cards[i].equals(target)){
				return i;
			}
		}
		return -1;
	}

	public static void printDeck(Card[] cards){
		for (int i = 0; i < cards.length; i++){
			System.out.println(cards[i].get_unoCard());
		}
	}

	public static void init_cards(){
		int index = 0;
		for (int color = 1; color <= 4; color++){
			for (int rank = 0; rank <= 26; rank++){
				if (rank <= 24)
					cards[index] = new Card(rank, color);
				else
					cards[index] = new Card(rank, 0);
				index++;
			}
		}
	}

	public static void main(String[] args){
		init_cards();
		printDeck(cards);
	}
}


