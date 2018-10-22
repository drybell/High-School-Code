//Daniel R
//Record

public class Record implements Comparable<Record>
{
   protected int wins; 
   protected int losses; 
   
   public Record()
   {
      wins = losses = 0; 
   }
   
   public Record(int wins,int losses)
   {
      this.wins=wins;
      this.losses=losses;
   }
   
   public int getWins()
   {
      return wins; 
   }
   
   public void setWins(int w)
   {
      wins = w; 
   }
   
   public void won()
   {
      wins++; 
   }
   
   public int getLosses()
   {
      return losses; 
   }
   
   public void setLosses(int l)
   {
      losses = l;
   }
   
   public void lost()
   {
      losses++;
   }
   
   public double getPercent()
   {
      return (double)((this.wins/(this.wins+this.losses))*100);
   } 
   
   public String toString()
   {
      return  wins + " wins, " + losses + " losses"; 
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Record)
      {
         Record r = (Record)other; 
         return wins == r.getWins() && losses == r.getLosses();
      }
      return false; 
   }
   
   public Record getRecord()
   {
      return this; 
   }
  
   public int isBetterThan(Record r)
   {  
      double percent = getPercent();
      double opercent = r.getPercent();
      if ( Math.abs(percent - opercent ) < 0.01)
         return 0; 
      else if ( percent > opercent)
         return 1; 
      else 
         return -1; 
   } 
   public int compareTo(Record other)
   {
      return (int)(getPercent() - other.getPercent());
   }
}
