//Daniel R
//CS3
//Assignment 10
//Lion
import java.util.*;
import java.awt.*;
public class Lion extends Critter
{ 
   /*
   * used to count the red in rgb 
   */
   private int red;
   
   /*
   * used to count the green in rgb
   */
   private int green;
   
   /*
   * used to count the blue in rgb
   */
   private int blue;
   
   /*
   * the random object used in many methods
   */
   private Random r;
   
   /*
   * the attack number used to determine the attack value
   */
   private int attacknum;
   
   /*
   * used to determine the direction
   */
   private int directionCount;
   
   /*
   * used to change the direction every 8 ticks
   */
   private int count;
   
   /*
   * the constructor, initializes the color variables, the move variable, the count variable, and the random object.
   *
   */
   public Lion()
   {
      this.red=0;
      this.green=0;
      this.blue=0;
      this.attacknum=0;
      this.directionCount=0;
      this.count=0;
      this.r=new Random();
   }
   
   /*
   * The lion will take in the String of the hippo and ant and based off of it try to always win.
   * If there is a different string, use RNG to randomly pick between the three ATTACK methods
   * @param opponent the opponent that it will be fighting
   */
   @Override
   public Attack fight(String opponent)
   {
      attacknum=r.nextInt(3);
      if (opponent.equals("%"))
      {
         return Attack.ROAR;
      }
      else if ((opponent.equals("1"))||(opponent.equals("2"))||(opponent.equals("3"))||(opponent.equals("4")))
      {
         return Attack.ROAR;
      }
      else if ((opponent.equals("0")))
      {
         return Attack.SCRATCH;
      }
      if (attacknum==0)
      {
         return Attack.POUNCE;
      }
      else if (attacknum==1)
      {
         return Attack.ROAR;
      }
      else
      {
         return Attack.SCRATCH;
      }
   }
   
   /*
   * changes the color of the lion (random style) 
   * @return the new color
   */
   @Override
   public Color getColor()
   {
      red=r.nextInt(256);
      green=r.nextInt(256);
      blue=r.nextInt(256);
      Color newColor=new Color(red,green,blue);
      return newColor;
   }
   
   /*
   * The lion will never eat, and will never sleep.
   * @return always false
   */
   @Override
   public boolean eat()
   {
      return false;
   }
  
   /*
   * Prints out the lion's picture.
   * @return the great lion
   */
   @Override
   public String toString()
   {
      return "ʖ";
   }
   
   /*
   * the lion will move in a randomly generated pattern every 8 ticks.
   *
   * @return the direction
   */
   public Direction getMove()
   {
      count++;
      if (count%8==0)
      {
         directionCount=r.nextInt(4);
      }
      else if (count%8==2)
      {
         return Direction.SOUTH;
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
}