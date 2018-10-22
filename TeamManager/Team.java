//Daniel R
//Team 

import java.util.*;
public abstract class Team //implements Comparable<Team>
{
   private String name;
   protected ArrayList<Player> roster;

   private final int MIN_PLAYING_NUM;
   protected RecordWithTies record;
   
   public Team(String name, int mostOnRoster, int mintoPlay)
   {
      if ( name.equals(null) || mostOnRoster<=0 || mintoPlay<=0)
      {
         throw new IllegalArgumentException();
      }
      this.name = name;
      this.MIN_PLAYING_NUM = mintoPlay;
      this.record = new RecordWithTies();
      this.roster = new ArrayList<Player>();
   }
  
   public boolean equals(Object other)
   {
      if (other instanceof Team)
      {
         Team t = (Team) other;
         if (t.equals(other))
         {
            return true;
         }
      }
      return false;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String n)
   {
      name=n;
   }
   
   public String toString()
   {
      return "Team: " +name+" Record: "+record.toString();  
   }
   
   public Object getRecord()
   {
      return record;
   }
   
   public void setRecord(RecordWithTies newRecord)
   {
      this.record = newRecord;
   }
   
   public void won()
   {
      record.won();
   } 
   
   public void lost()
   {
      record.lost();
   }
   public void tied()
   {  
      
      record.tied();
   }
   
   public void addPlayer(Player p)
   {
      roster.add(p);
   }
   
   public Player findPlayer(String name)
   {
      for (Player p : roster)
      {
         String check=p.getName();
         if (name==check)
         {
            return p;
         }
      }
      return null;
   }
   
   public boolean removePlayer(String name)
   {
      int count=-1;
      for (Player p : roster)
      {
         count++;
         String check=p.getName();
         if (name==check)
         {
            roster.remove(count);
            return true;
         }
      }
      return false;
   }
   
   public int getRosterSize()
   {
      return this.roster.size();
   }
   
   public abstract boolean shouldFieldATeam();
   
   public boolean canFieldATeam()
   {  
      if (this.roster.size()>=5)
      {
         return true;
      }
      return false;
   }
   
   public void updatePlayerStatus(String name, boolean status)
   {
      int count=-1;
      for (Player p : roster)
      {
         count++;
         String check=p.getName();
         boolean check2=p.getStatus();
         if ((name==check)&&(status==check2))
         {
            p.setName(name);
            p.setStatus(status);
         }
      }
   }
}
