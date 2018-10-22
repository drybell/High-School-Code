//Daniel R
//CS3
//Assignment 11
//TileManager

import java.util.*;
import java.awt.*;
public class TileManager
{
   /*
   * the arraylist of tiles
   */
   private java.util.List<Tile> Tilelist;
   
   /*
   * initializes the arraylist 
   */
   public TileManager()
   {
      Tilelist=new LinkedList<Tile>();
   }
   
   /*
   * generates a new random circletile or rectangletile and returns it
   * @param rand the random object 
   * @param x the x value 
   * @param y the y value 
   * @param width the width of the tile 
   * @param height the height of the tile 
   * @param color the color of the tile
   * @return the tile 
   */
   public Tile generateNewTile(Random rand,int x,int y,int width,int height,Color color)
   {  
      int new1=rand.nextInt(2);
      if (new1==1)
      {
         Tile tile=new RectangleTile(x,y,width,height,color);
         return tile;
      }
      Tile tile=new CircleTile(x,y,width,height,color);
      return tile;
   }
   
   /*
   * Adds the tile to the list.
   * @param tile the Tile  
   * @return true if the tile is added, false if the tile is null
   */
   public boolean addTile(Tile tile)
   {
      if (tile==null)
      {
         return false;
      }
      else
      {
         return Tilelist.add(tile);
      }  
   }
   
   /*
   * draws every single tile in the list
   * @param g the Graphics object 
   */
   public void drawAll(Graphics g)
   {
      for (Tile tile:Tilelist)
      {
         tile.draw(g);
      }
   }
   
   /*
   * raises the tile to the top of the list, lowering everything by one to the bottom.
   * @param x the x value that the cursor is at
   * @param y the y value that the cursor is at
   */
   public void raise(int x,int y)
   {
      for (int z=Tilelist.size()-1;z>=0;z--)
      {
         if (Tilelist.get(z).isHit(x,y))
         {  
            Tile t=Tilelist.get(z);
            Tilelist.remove(t);
            Tilelist.add(Tilelist.size()-1,t);
            return;
         }   
      }
   }
   
   /*
   * lowers the top tile to the bottom of the list, raising all of the other ones to the top.
   * @param x the x value that the cursor is at
   * @param y the y value that the cursor is at
   */
   public void lower(int x,int y)
   {
      for (int z=Tilelist.size()-1;z>=0;z--)
      {
         if (Tilelist.get(z).isHit(x,y))
         {  
            Tile t=Tilelist.get(z);
            Tilelist.remove(t);
            Tilelist.add(0,t);
            return;
         }
      }
   }
   /*
   * deletes the top tile that the cursor hits
   * @param x the x value that the cursor is at
   * @param y the y value that the cursor is at 
   */
   public void delete(int x,int y)
   {
      for (int z=Tilelist.size()-1;z>=0;z--)
      {
         Tile t=Tilelist.get(z);
         if (t.isHit(x,y))
         {  
            if (z==0)
            {
               Tilelist.remove(t);
            }
            Tilelist.remove(t);
            break;
         }
      }
   }
   /*
   * deletes all of the tiles that the cursor hits
   * @param x the x value
   * @param y the y value
   */
   public void deleteAll(int x,int y)
   {
      for (int z=Tilelist.size()-1;z>=0;z--)
      {
         Tile t=Tilelist.get(z);
         if (t.isHit(x,y))
         {  
            Tilelist.remove(t);
         }
      }
   }  
   
   /*
   * shuffles all of the tiles positions and their ordering
   * @param the width of the tile
   * @param the height of the tile 
   */
   public void shuffle(int width, int height)
   {
      Random r=new Random();
      Collections.shuffle(Tilelist);
      for (Tile t:Tilelist)
      {
         int xbound=TileMain.WIDTH-t.getWidth();
         int ybound=TileMain.HEIGHT-t.getHeight();
         t.setX(r.nextInt(xbound+1));
         t.setY(r.nextInt(ybound+1));     
      }  
   }
}