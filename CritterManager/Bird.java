//Daniel R
//CS3
//Assignment 10
//Bird

import java.awt.*;
public class Bird extends Critter
{
   /*
   * int called in order to change the direction every 3 ticks
   */
   protected int count;
   
   /*
   * used to determine the direction 
   */
   protected int directionCount=0;
  
   /*
   * the last move of the bird
   */
   protected Direction move;
   
   
   /*
   * The constructor, initializes the move variable and the count variable
   */
   public Bird()
   {
      this.move=Direction.NORTH;
      this.count=0;
   }
   
   /*
   * The attack method, overrides the critter attack and always returns roar if enemy is an ant, pounce otherwise
   * @param the string of the opponent (found by its toString)
   * @return roar if ant, else pounce
   */
   @Override
   public Attack fight(String opponent)
   {
      if (opponent.equals("%"))
      {
         return Attack.ROAR;
      }
      return Attack.POUNCE;
   }
   
   /*
   * gets the color of the bird, which is always blue
   * @return the color blue
   */
   @Override
   public Color getColor()
   {
      return Color.BLUE;
   }  
   
   /*
   * the eat method, overwrites the critter eat and makes it so the bird will never eat food
   * @return false always, meaning that the ant will never eat food
   */
   @Override
   public boolean eat()
   {
      return false;
   }
   
   /*
   * Moves the bird in a clockwise square direction
   * @return the direction, changing every three ticks
   */
   @Override
   public Direction getMove()
   {
      
      count++;
      if (count%3==0)
      {
         directionCount++;
      }
      if (directionCount>4)
      {
         directionCount=1;
      }
      if (directionCount==1)
      {
         move=Direction.NORTH;
         return move;
      }
      else if (directionCount==2)
      {
         move=Direction.EAST;
         return move;
      }
      else if (directionCount==3)
      {
         move=Direction.SOUTH;
         return move;
      }
      else
      {
         move=Direction.WEST;
         return move;
      }
      
   }
   
   /*
   * the overwritten toString method. 
   * @return  a ^ if direction is north, > if east, < if west, and V if south
   */
   @Override 
   public String toString()
   {
      if ((move==Direction.NORTH)||(move==Direction.CENTER))
      {
         return "^";
      }
      else if (move==Direction.EAST)
      {
         return ">";
      }  
      else if (move==Direction.SOUTH)
      {
         return "V";
      }
      else
      {
         return "<";
      }
   }
}



