public class RecordWithTies extends Record
{
   private int ties;
   
   public RecordWithTies()
   {
      wins=losses=ties=0;
   }
   
   public RecordWithTies(int wins, int losses, int ties)
   {
      this.wins=wins;
      this.losses=losses;
      this.ties=ties;
   }
   
   @Override
   public String toString()
   {
      return super.toString()+", "+ties+" ties";
   }
   
   @Override
   public boolean equals(Object other)
   {
      if (other instanceof Record)
      {
         RecordWithTies r = (RecordWithTies)other; 
         return wins == r.getWins() && losses == r.getLosses() && ties==r.getTies();
      }
      return false;
   }
   
   public int getTies()
   {
      return ties;
   }
   
   public void setTies(int t)
   {
      ties=t;
   }
   
   public void tied()
   {
      ties++;
   }
}