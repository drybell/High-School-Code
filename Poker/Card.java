//Daniel R
//CS3
//Card

public class Card {
   
   /** This enumeration lists all of the possible suits that a Card object can be
    *  You can use Suit.<nameofsuit>.ordinal() to get the position in the enumeration
    *    so Suit.SPADES.ordinal() == 0, Suit.HEARTS.ordinal() = 1 ... 
    *  And you can use Suit.<nameofsuit>.name() to the the "name" of the enum
    *    so Suit.SPADES.name() is "SPADES" and Suit.CLUBS.name() is "CLUBS"
    */
   public enum Suit
   {
      SPADES,
      HEARTS,
      DIAMONDS,
      CLUBS,
      JOKER
   }
   
   // Codes for non numeric cards. 
   // Cards 2 through 10 have their numerical values for their codes.
   
   /** The numeric value for an Ace */
   public final static int ACE = 1;      
   
   /** The numeric value for a Jack */
   public final static int JACK = 11; 
   
   /** The numeric value for a Queen */   
   public final static int QUEEN = 12;   
   
   /** The numeric value for a King */
   public final static int KING = 13;

   /** Calculation of the total number of cards in the deck */
	public final static int MAX_CARDS = (Suit.CLUBS.ordinal() - Suit.SPADES.ordinal() + 1) * (Card.KING - Card.ACE + 1) + 2; 
	
   
   
   
   
   /**
    * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
    * CLUBS, or JOKER.  The suit cannot be changed after the card is
    * constructed.
    */
   private final Suit suit;
   
   /**
    * The card's value.  For a normal cards, this is one of the values
    * 1 through 13, with 1 representing ACE.  For a JOKER, the value
    * can be anything (usually 1 or 2).  The value cannot be changed 
    * after the card is constructed.
    */
   private final int value;

   /**
    * Creates a Joker, with 1 as the associated value. Uses the 
    * other constructor to actual set the suit and value. 
    */
   public Card() 
	{
      this(1,Suit.JOKER);
   }
   
   /**
    * Creates a card with a specified suit and value.
    * @param theValue the value of the new card.  For a regular card (non-joker),
    * the value must be in the range 1 through 13, with 1 representing an Ace.
    * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.
    * For a Joker, the value can be anything.
    * @param theSuit the suit of the new card.
    * @throws IllegalArgumentException if the parameter values are not in the
    * permissible ranges
   */
   public Card(int theValue, Suit theSuit) 
	{
      if (theSuit!=Suit.JOKER)
      {
         if ((theValue<ACE)||(theValue>KING))
         {  
            throw new IllegalArgumentException();
         }  
      }
      
      this.value=theValue;
      this.suit=theSuit;
   }
   
   /**
    * Returns the suit of this card.
    * @returns the suit of the card
    */
   public Suit getSuit() 
	{
      return this.suit;
   }
   
   /**
    * Returns the value of this card.
    * @return the value, which is one the numbers 1 through 13, inclusive for
    * a regular card, and which can be any value for a Joker.
    */
   public int getValue() 
	{
      return this.value;
   }
   
   /**
    * Returns a String representation of the card's suit.
    * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
    * or "Joker". You might consider using the <enum>.name() method with
    * string manipulation.  
    */
   public String getSuitAsString() 
	{
      if (suit==Suit.SPADES)
      {
         return "Spades";
      }
      else if (suit==Suit.CLUBS)
      {
         return "Clubs";
      }
      else if (suit==Suit.HEARTS)
      {
         return "Hearts";
      }
      else if (suit==Suit.DIAMONDS)
      {
         return "Diamonds";
      }
      else
      {
         return "Joker";
      }
   }
   
   /**
    * Returns a String representation of the card's value.
    * @return for a regular card, one of the strings "Ace", "2",
    * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the
    * string is always a numerical.
    * @return the value of the card as a String
    */
   public String getValueAsString() 
   {
      if (this.suit!=Suit.JOKER)
      {
         if (this.value==ACE)
         {
            return "Ace";
         }
         else if (this.value==JACK)
         {
            return "Jack";
         }
         else if (this.value==QUEEN)
         {
            return "Queen";
         }
         else if (this.value==KING)
         {
            return "King";
         }  
         else
         {
            return ""+this.value;
         }
      }
      else
      {  
         return ""+this.value;
      }


   }
	
	/**
	 * Checks to see if two cards are equal
	 * @param Card other
    * @return returns whether the two objects are equal. 
	 */
	public boolean equals(Object other)
	{
	   if (other instanceof Card)
      {
         Card s=(Card) other;
         return (this.value==s.getValue())&&(this.suit.equals(s.getSuit()));
      }
      return false;
	
	
	}
	 
   
   /**
    * Returns a string representation of this card, including both
    * its suit and its value.  Sample return values
    * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
    * "Joker #1", "Joker #2" (meaning "Joker #<value>")
    * @return a string representation of this card, 
    */
   public String toString() 
   {
      if (this.suit==Suit.JOKER)
      {
         return getSuitAsString()+" #"+getValueAsString();
      }
      else
      {
         return getValueAsString()+" of "+getSuitAsString();
      }
    }
   
   
} // end class Card
