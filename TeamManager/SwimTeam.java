//Daniel R
//SwimTeam

import java.util.*;
public class SwimTeam extends Team
{
   private ArrayList<TeamPlayer> roster;
   
   public SwimTeam(String name)
   {
      super(name,50,1);
      roster =new ArrayList<TeamPlayer>();
   }
   
   public void addPlayer(TeamPlayer p)
   {
      roster.add(p);
   }
   
   @Override
   public boolean shouldFieldATeam()
   {
      int count=0;
      for (TeamPlayer p:roster)
      {
         if (p.getPosition()=="Backstroke")
         {
            count++;
         }
         else if (p.getPosition()=="Butterfly")
         {
            count++;
         }
      }
      if (count>5)
      {
         return true;
      }
      return false;
   }
   
   public void updatePosition(String name, String newPosition)
   {
      int count=-1;
      for (TeamPlayer p : roster)
      {
         count++;
         String check=p.getName();
         if (name==check)
         {
            p.setPosition(newPosition);
         }
      }
   }
}