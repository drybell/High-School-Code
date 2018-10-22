//Daniel R
//IndividualPlayer

public class IndividualPlayer extends Player //implements Comparable<IndividualPlayer>
{
   private Record playerRecord;
   
   public IndividualPlayer()
   {
      super("",false);
   }
   
   public IndividualPlayer(String name,Record winsLosses)
   {
      playerName=name;
      playerStatus=false;
      playerRecord=winsLosses;
   }
   
   public IndividualPlayer(String name, boolean status, Record winsLosses)
   {
      playerName=name;
      playerStatus=status;
      playerRecord=winsLosses;
   }
   
   @Override
   public boolean equals(Object other)
   {
      if (other instanceof Player)
      {
         IndividualPlayer p = (IndividualPlayer) other;
         return p.playerName.equals(playerName) && p.playerStatus == playerStatus && p.playerRecord==playerRecord;
      }
      return false;
   }
   
   @Override
   public String toString()
   {
      return super.toString()+", Record: "+getWins()+" wins, "+getLosses()+" losses";
   }
   
   public Record getRecord()
   {
      return playerRecord;
   }
   
   public void setRecord(Record r)
   {
      playerRecord=r;
   }
   
   public int getWins()
   {
      return playerRecord.getWins();
   }
   
   public int getLosses()
   {
      return playerRecord.getLosses();
   }
   
   public void setWins(int w)
   {
      playerRecord.setWins(w);
   }
   
   public void setLosses(int l)
   {
      playerRecord.setLosses(l);
   }
   
   public void won()
   {
      playerRecord.won();
   }
   
   public void lost()
   {
      playerRecord.lost();
   }
   
   public double getPercent()
   {
      return playerRecord.getPercent();
   }
}