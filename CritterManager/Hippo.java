//Daniel R
//CS3
//Assignment 10
//Hippo

import java.awt.*;
import java.util.*;
public class Hippo extends Critter
{
   /*
   * the variable used to change the direction every 5 moves
   */
   private int count;
   
   /*
   * the variable used to determine the amount of times the hippo will eat
   */
   private int hunger;
   
   /*
   *  variable used to determine what direction the hippo will move
   */
   private int directionCount;
   
   /*
   * The constructor, initializes the hungry variable
   * @param h number of times the hippo will eat.
   */
   public Hippo(int h)
   {
      this.hunger=h;
      this.count=-1;
      this.directionCount=0;
   }
   
   /*
   * The attack method, overrides the critter attack and returns scratch when hungry. If not hungry return pounce
   * @param the string of the opponent (found by its toString)
   * @return Scratch if hungry, pounce if not. 
   */
   @Override
   public Attack fight(String opponent)
   {
      if (hunger>0)
      {
         return Attack.SCRATCH;
      }
      return Attack.POUNCE;
   }
   
   /*
   * gets the color of the hippo, which is always white when hungry, and gray when not.
   * @return the color white if hungry, and gray when not.
   */
   @Override
   public Color getColor()
   { 
      if (hunger>0)
      {
         return Color.WHITE;
      }
      else
      {
         return Color.GRAY;
      }   
   }  
   
   /*
   * the eat method, overwrites the critter eat and makes it so the hippo will always eat food as long as hunger is above 0
   * @return true if hungry, false if not.
   */
   @Override
   public boolean eat()
   {
      if (hunger>0)
      {  
         hunger--;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /*
   * moves the hippo in a random direction every 5 moves
   * @return the random direction 
   */
   @Override
   public Direction getMove()
   {  
      count++;
      Random r=new Random();
      if (count%5==0)
      {
         directionCount=r.nextInt(4);    //since there are 4 directions, 0,1,2,and 3 
      }
      if (directionCount==0)
      {
         return Direction.NORTH;
      }
      else if (directionCount==1)
      {
         return Direction.WEST;
      }
      else if (directionCount==2)
      {
         return Direction.EAST;
      }
      else if (directionCount==3)
      {
         return Direction.SOUTH;
      }
      else
      {
         return Direction.CENTER;
      }
   }
   
   /*
   * the overwritten toString method. 
   * @return the number of hunger left for the hippo 
   */
   @Override 
   public String toString()
   {
      return ""+hunger;
   }
}