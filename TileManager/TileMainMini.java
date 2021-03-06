// TileMainMini.java
// This provided main program uses your TileManager class.
// Used for testing purpopses. 
// It displays a DrawingPanel, creates several random Tile objects,
// and adds them to your manager.  It also listens for mouse clicks, notifying
// your tile manager when the mouse buttons are pressed.

// A left-click raises a tile to the top of the Z-order.
// A Shift-left-click lowers a tile to the bottom of the Z-order.
// A right-click (or a Ctrl-left-click for Mac people) deletes a tile.
// A Shift-right-click (or a Shift-Ctrl-left-click for Mac people) deletes 
// all tiles touching the mouse point.
//
// Version 1.0 - Originally written by UW CSE 143, assignment 1
// Version 1.5 - Modified by Lauren Bricker ???
// Version 2.0 - Modified by Lauren Bricker 3/3/15


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class TileMainMini {
   // constants for the drawing panel size, tile sizes, and # of tiles
   /** DrawingPanel width */
   public static final int WIDTH = 300;

   /** DrawingPanel height */
   public static final int HEIGHT = 300;
   
   /** The minimum size of a tile */
   public static final int MIN_SIZE = 20;

   /** The maximum size of a tile */
   public static final int MAX_SIZE = 100;
   
   /** The number of tiles to initially have on the screen */
   public static final int TILES = 20;
   
   /** Variable that when set to true to catch and print any exceptions that occur */
   private static final boolean CATCH_EXCEPTIONS = true;
   
   public static void main(String[] args) 
   {
      Random rand = new Random();
      
      DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
      Graphics g = panel.getGraphics();
      
      // create several random tiles and put them into a manager
      TileManager list = new TileManager();
      for (int i = 0; i < TILES; i++) 
      {
         Tile tile = makeRandomTile(rand, list);
         list.addTile(tile);
      }
      list.drawAll(g);
      
      // listen for key presses
      TileKeyListener listener = new TileKeyListener(panel, list);
      panel.addKeyListener(listener);
      
      // listen for mouse clicks
      TileMouseListener listener2 = new TileMouseListener(panel, list);
      panel.addMouseListener(listener2);
   }
   
   // Creates and returns a random tile to be placed into the tile manager.
   public static Tile makeRandomTile(Random rand, TileManager list) 
   {
      // choose random coordinates
      int w = rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
      int h = rand.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
      int x = rand.nextInt(WIDTH - w);
      int y = rand.nextInt(HEIGHT - h);
      
      // choose random color (avoid very darkest range of palette)
      int red   = rand.nextInt(206) + 50;
      int green = rand.nextInt(206) + 50;
      int blue  = rand.nextInt(206) + 50;
      Color color = new Color(red, green, blue);
      
      // add random tile to manager
      // Unfortunately somewhat kludgey, 
      // For 2017 revisit this and make it automatically load the 
      // a random different kind of tile. 
      Tile tile = list.generateNewTile(rand, x, y, w, h, color);
      return tile;
   }
   
   /**
    * A class for responding to mouse clicks on the drawing panel.
    */
   public static class TileMouseListener extends MouseInputAdapter 
   {
      private DrawingPanel panel;
      private TileManager list;
      
      public TileMouseListener(DrawingPanel panel, TileManager list) 
      {
         this.panel = panel;
         this.list = list;
      }
   }
       

   /** A class for responding to key presses on the drawing panel.
    */
   public static class TileKeyListener extends KeyAdapter 
   {
      private DrawingPanel panel;
      private TileManager list;
      private Random rand; 
            
      public TileKeyListener(DrawingPanel panel, TileManager list) 
      {
         this.panel = panel;
         this.list = list;
         this.rand = new Random();
      }
      
      public void keyPressed(KeyEvent event) 
      {
         int code = event.getKeyCode();
         if (code == KeyEvent.VK_N) 
         {
            Tile newTile = makeRandomTile(rand, list);
            list.addTile(newTile);
            Graphics g = panel.getGraphics();
            list.drawAll(g);
         } 
      }
   }
}
