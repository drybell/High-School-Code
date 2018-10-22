//Daniel R
//CS3
//Assignment 10
//Ant

import java.awt.*;
public class Ant extends Critter
{
   /*
   * indicator telling if the ant will start walking south or north
   */
   private boolean walkSouth;
   
   /*
   * int called in order to alternate between north/south and east
   */
   private int count;
   
   /*
   * The constructor, initializes the walkSouth variable
   * @param walkSouth if true walks south if false walks north
   */
   public Ant(boolean walkSouth)
   {
      this.walkSouth=walkSouth;
      this.count=-1;
   }
   
   /*
   * The attack method, overrides the critter attack and always returns scratch
   * @param the string of the opponent (found by its toString)
   * @return Scratch always as its attack
   */
   @Override
   public Attack fight(String opponent)
   {
      return Attack.SCRATCH;
   }
   
   /*
   * gets the color of the ant, which is always red
   * @return the color red
   */
   @Override
   public Color getColor()
   {
      return Color.RED;
   }  
   
   /*
   * the eat method, overwrites the critter eat and makes it so the ant will always eat food
   * @return true always, meaning that the ant will always eat food
   */
   @Override
   public boolean eat()
   {
      return true;
   }
   
   /*
   * moves the ant south/north or east, based on the counter number. if count is even, moves the ant south/north, else it moves east.
   * @return the direction after finding out the tick number
   */
   @Override
   public Direction getMove()
   {
      count++;
      if (walkSouth)
      {
         if (count%2==0)
         {
            return Direction.SOUTH;
         }
         else
         {
            return Direction.EAST;
         }
      }
      else
      {
         if (count%2==0)
         {
            return Direction.NORTH;
         }
         else
         {
            return Direction.EAST;
         }
      }
   }
   
   /*
   * the overwritten toString method. always returns a % 
   */
   @Override 
   public String toString()
   {
      return "%";
   }
}