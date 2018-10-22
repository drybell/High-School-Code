//Daniel R
//Player

public class Player
{
   protected String playerName; 
   protected boolean playerStatus;
   
   
   public Player()
   {
      this("", false);
   }
   
   public Player(String name)
   {
      this(name, false);
   }
   
   public Player(String name, boolean status)
   {
      playerName = name; 
      playerStatus = status; 
   }
   
   public void setName(String name)
   {
      playerName = name; 
   }
   
   public String getName()
   {
      return playerName;
   }
   
   public void setStatus(boolean status)
   {
      playerStatus = status; 
   }
   
   public boolean getStatus()
   {
      return playerStatus;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         Player p = (Player) other;
         return p.playerName.equals(playerName) && p.playerStatus == playerStatus;
      }
      return false; 
   }
   
   public String toString()
   {
      return "Name: " + playerName + ", Availability: " + playerStatus; 
   }
}