//Daniel R
//CS3
//SwimTeamTester

import java.util.*;
public class SwimTeamTester
{
   public static void main(String[] args)
   {
      SwimTeam t=new SwimTeam("Arena Aquatics");
      SwimTeam w=new SwimTeam("We are Cool Aquatics");
      Random r=new Random();
      TeamPlayer a=new TeamPlayer("Tom Brady",true,"Backstroke");
      TeamPlayer b=new TeamPlayer("Michael Flops",true,"Butterfly");
      TeamPlayer c=new TeamPlayer("Toodles McGee",true,"Breastroke");
      TeamPlayer d=new TeamPlayer("Michael Phelps",true,"Butterfly");
      TeamPlayer e=new TeamPlayer("Sissy Franklin",true,"Backstroke");
      TeamPlayer f=new TeamPlayer("Ryan Lofty",true,"Butterfly");
      TeamPlayer g=new TeamPlayer("Dan R",true,"Backstroke");
      TeamPlayer h=new TeamPlayer("Matt Grevers",true,"Butterfly");
      TeamPlayer i=new TeamPlayer("Dave",true,"Backstroke");
      TeamPlayer j=new TeamPlayer("John Paul Kuder",true,"Freestyle");
      t.addPlayer(a);
      t.addPlayer(b);
      t.addPlayer(c);
      t.addPlayer(d);
      t.addPlayer(e);
      t.addPlayer(f);
      t.addPlayer(g);
      t.addPlayer(h);
      t.addPlayer(i);
      t.addPlayer(j);
      w.addPlayer(a);
      w.addPlayer(b);
      w.addPlayer(c);
      w.addPlayer(d);
      w.addPlayer(e);
      w.addPlayer(f);
      w.addPlayer(g);
      w.addPlayer(h);
      w.addPlayer(i);
      w.addPlayer(j);
      System.out.println(t);
      t.updatePosition("Michael Flops","Backstroke");
      System.out.println(b);
      boolean test=t.canFieldATeam();
      System.out.println("Can we field a team? "+test);
      test=t.shouldFieldATeam();
      System.out.println("SHOULD we field a team? "+test);
      System.out.println("F-F-F-Fight!");
      if (t.shouldFieldATeam()&&w.shouldFieldATeam())
      {
         int tester=r.nextInt(3);
         if (tester==0)
         {
            t.tied();
            w.tied();
         }
         else if (tester==1)
         {
            t.won();
            w.lost();
         }
         else
         {
            w.won();
            t.lost();
         }
      }
      System.out.println(t+" and "+w);
      
   }
}