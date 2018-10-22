//Daniel R
//CS3
//RectangleTile

import java.awt.*;
public class RectangleTile extends Tile
{ 
   /*
   * Initializes the rectangle tile
   * @param x the x value
   * @param y the y value
   * @param w the width
   * @param h the height
   * @param c the color
   */
   public RectangleTile(int x, int y, int w, int h, Color c) 
   {
      super(x, y, w, h, c);
   }
    
   /** 
    * Draws this tile using the given graphics pen. 
    * @param g The graphics context on which to draw this tile. 
    */
   @Override
   public void draw(Graphics g) 
   {    
      g.setColor(getColor());
      g.fillRect(getX(), getY(), getWidth(), getHeight());
      g.setColor(Color.BLACK);
      g.drawRect(getX(), getY(), getWidth(), getHeight());
   }

    
   /** 
    * Determines if this rectangle tile has been "hit" - This method 
    * takes into account the rectangle inside this bounding box is smaller
    * than the bounding box itself. 
    * @param x The x coordinate of the potential hit
    * @param y The y coordinate of the potential hit
    * @return Returns whether this rectangle tile was hit.  
    */
   @Override
   public boolean isHit(int x, int y) 
   { 
      int centerx = getX() + getWidth(); 
      int centery = getY() + getHeight(); 
      
      return (x>getX() && x<centerx && y>getY() && y<centery);
   }
   
   /**
    * Return the distance between two points
    * @param x1 The x coordinate of the first point
    * @param y1 The y coordinate of the first point
    * @param x2 The x coordinate of the second point
    * @param y2 The y coordinate of the second point 
    * @return The distance between the two points
    */ 
   private double distance(int x1, int y1, int x2, int y2)
   {
      int xdist = x2 - x1; 
      int ydist = y2 - y1; 
      return Math.sqrt(xdist * xdist + ydist * ydist); 
   }
   
   
    /** Returns a text representation of this tile, such as "Rectangle: (x=57,y=148,w=26,h=53)". */
   @Override
   public String toString() {
      return "Rectangle " + super.toString(); 
   }
}

