import java.util.*;

public class Deck {
   
   
   /** This variable is an array that holds the deck of Card.MAX_CARDS cards */
   public Card[] deckHold=new Card[Card.MAX_CARDS];
	
	/** This variable holds the number of cards that are left in the deck, after they have been dealt.
	 *  Can only go up to Card.MAX_CARDS */
   public int cardsLeft=0;
   
   /** 
	 *  Constructor.  Creates and initializes an unshuffled deck of cards using a doubly nested for loop over the 
	 *  the card suits (Card.Suit.SPADES .. Card.Suit.CLUBS) and the values (Card.ACE.. Card.KING). 
    *  For example, the Ace of Spades comes first, then the 2 of Spades, etc.
    *  Hint: Consider using a foreach loop for the suits - for each Card.Suit in Card.Suit.values()
	 *  Then it adds the two jokers to the end, giving them value 1 and 2 respectively. 
	 *  The variable holding the number of cards left is set appropriately, then 
	 *  Finally it shuffles the deck using the DeckShuffler.shuffle method, if the parameter passed in is true. 
	 *  @param shuffle determines whether or not the deck should be shuffled. 
	 */
   public Deck(boolean shuffle)
   {
      Card newcard=null;
      for (Card.Suit suit : Card.Suit.values())
      {
         if (suit!=Card.Suit.JOKER)
         {
            for (int x=Card.ACE;x<=Card.KING;x++)
            {
               newcard=new Card(x,suit);
               addCard(newcard);
            }
         }
      }
      newcard=new Card();
      addCard(newcard);
      newcard=new Card(2,Card.Suit.JOKER);
      addCard(newcard);
      if (shuffle)
      {
         DeckShuffler.shuffle(deckHold,cardsLeft);
      }
      
   }
	
	/**
	 * Adds a card to the top of the deck. This adds the card to the array and increments the 
	 * total number of cards. It will throw an IllegalArgumentException if the maxiumum 
	 * number of cards has already been added or if the card being passed in is null
	 * @param c The card to be added. 
	 */
	public void addCard(Card c) 
	{
      if ((c==null)||(cardsLeft>Card.MAX_CARDS))
      {
         throw new IllegalArgumentException();
      }
      deckHold[cardsLeft]=c;
      cardsLeft++;
	}

   
   /**
	 * As cards are dealt from the deck, the number of 
    * cards left decreases.  This function returns the 
    * number of cards that are still left in the deck.
	 * @return the number of cards still left in the deck
	 */ 
   public int cardsLeft() 
	{
      return cardsLeft;
   }
   
   /**
	 * Deals one card from the "top" of the deck and returns it. (The bottom of the deck is 0, 
	 * The top of the deck is the highest card). Sets the "top" card in the deck to null, 
	 * and decrements the number of cardsLeft to keep track. 
    * Throws an IllegalArgumentException if no more cards are left.
	 */
   public Card dealCard()
   {
      if (cardsLeft<=0)
      {
         throw new IllegalArgumentException();
      }
      cardsLeft--;
      Card currentCard=deckHold[cardsLeft];
      deckHold[cardsLeft]=null;
      return currentCard;
   }
   
   /**
	 * Returns a string representation of the current state of the deck, what's left of it. 
	 * each card is separated by a new line. 
    * The cards are printed in order from the bottom first of the deck to the top of the deck last. 
	 * @return a string representation of the current state what's left of the deck - 
    * with each card on a new line
	 */
	 
   public String toString()
   {  
      String s="";
      for (int x=0;x<cardsLeft;x++)
      {
         s=s+deckHold[x]+"\n";
      }
      return s;
   }
}
