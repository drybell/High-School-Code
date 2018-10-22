//Daniel R
//TeamPlayer

public class TeamPlayer extends Player
{
   private String position;
   
   public TeamPlayer(String name, String position)
   {
      this(name,false,position);
   }
   
   public TeamPlayer()
   {
   
   }
   
   public TeamPlayer(String name, boolean status, String position)
   {
      playerName=name;
      playerStatus=status;
      this.position=position;
   }
   
   public void setPosition(String newPosition)
   {
      this.position=newPosition;
   }
   
   public String getPosition()
   {
      return position;
   }
   
   @Override
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         TeamPlayer p = (TeamPlayer) other;
         return p.playerName.equals(playerName) && p.playerStatus == playerStatus && p.position==position;
      }
      return false;
   }
   
   @Override
   public String toString()
   {
      return super.toString()+", Position: "+getPosition();
   }
}