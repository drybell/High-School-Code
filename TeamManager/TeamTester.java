/** 
 * Program to unit test the functionality in the Team Class
 * Version 1.0
 * 1/25/2016
 * 
 */

import java.util.*;

public class TeamTester
{   
   public static void main(String[] args)
   {
      // 40 = max roster for baseball, min 9 playing on the field
      Team t1 = new SwimTeam("Mariners");   
      // 53 = max roster for football, min 11 playing on the field
      Team t2 = new SwimTeam("Seahawks"); 
      Team t3 = new SwimTeam("Mariners"); 
      Team t4 = new SwimTeam("Small Team");

      Player p1 = new Player("Brad Miller", true);
      Player p2 = new Player("Mike Zunino", false);
      Player p3 = new Player("Russell Wilson", true);
      Player p4 = new Player("Marshawn Lynch", false);  
      TeamPlayer superstar = new TeamPlayer();
      System.out.println(superstar);

      int testWins = 8; 
      int testLosses = 4;       
      Record testRecord = new Record(); 
      testRecord.setWins(testWins);
      testRecord.setLosses(testLosses);
      testRecordMethods(t1, testRecord); 
      // Have to run this on t3 too to keep them equal
      setRecord(t3, testWins, testLosses); 
      System.out.println();
      
      Player[] players =  {p1, p2};
      // first test an error case
      testAddPlayerAndRosterMethods(t4, players);
      // now test an ok case. 
      testAddPlayerAndRosterMethods(t1, players);
      System.out.println();
      
      // Setting up the two other teams for testing later. 
      t3.addPlayer(p1); 
      t3.addPlayer(p2);
      t2.addPlayer(p3); 
      t2.addPlayer(p4);
      
      // Some code should be written here to test remove if it has been written
      // testRemovePlayer(t1);
      //System.out.println();
      
      testFindPlayer(t1, p3);
      testFindPlayer(t2, p3);
      System.out.println();
      
      
   }

   /**
   *   Method to test record setters and getters of a team. The method 
   *   will print out true if the Team Record correctly reflects the number
   *   of wins and losses.  
   *   @param t The team to modify the Record on
   *   @param testRecord the Record to test with. 
   */  
   public static void testRecordMethods(Team t, Record testRecord)
   {
      int wins = testRecord.getWins(); 
      int losses = testRecord.getLosses();
      setRecord(t, wins, losses);
      //Record teamRecord=t.getRecord();
      System.out.println("Testing Record methods with " + wins + " wins and " +
                         losses + " losses.");
      System.out.println("   Team record set correctly -> ");
      //                   teamRecord.equals(testRecord));
   }
   

   /** 
    *  Helper method for setting wins and losses on a team
    *
    *  @param t The Team to set the record on
    *  @param wins The number of wins the team has
    *  @param losses The number of losses the team has
    */
   private static void setRecord(Team t, int wins, int losses)
   {
      for (int ii = 0; ii < wins; ii++)
         t.won();
      for (int ii = 0; ii < losses; ii++)
         t.lost();
   }
   
   
   /**
   *   Method to test whether adding players to a team works correctly. The method 
   *   will print out true if the Team correct presents the number of players
   *   after adding  
   *   
   *   Note: this also tests the getRoster and getRosterSize methods as a side effect. 
   *   Usually we'd test these separately. 
   * 
   *   Assumes the .equals method on Players works correctly.
   *  
   *   @param t The team to add a player to
   *   @param players an array containing players to add to the team. 
   */ 
   public static void testAddPlayerAndRosterMethods(Team t, Player[] players)
   {
      System.out.println("Testing addPlayer method on " + t.getName());
      boolean success = true; 
      for (int ii = 0; ii < players.length; ii++)
      {
         try
         {
            System.out.print("   adding player: " + players[ii].getName() + "...");
            t.addPlayer(players[ii]);
            System.out.println("player added");
         }
         catch (IllegalArgumentException e)
         {
            System.out.println();
            System.out.println(" Correctly caught error adding player " + 
                                 players[ii].getName() +
                               " because the roster is already full ");
            success = false; 
            break;
         }
      }

      if ( success )
      {
         // First check if getRosterSize is working
         int size = t.getRosterSize();
         System.out.println("Checking getRosterSize, method returns: " + size + 
                             " equals " + players.length + " added -> " + (size == players.length));
      
         // Now test if the roster is what we expect
         // also tests getRoster
       //  ArrayList<Player> teamPlayers = t.getRoster(); 
        // System.out.println("Got Roster: " + teamPlayers);
         
         // have to check if the two rosters are equal manually 
         // because the roster in the Team is padded with null
         boolean equal = true;
         // 
        /// for (int ii = 0; ii < players.length && ii < size; ii++)
        // {
        //    if ( !players[ii].equals(teamPlayers[ii]) )
        //       equal = false;
      //   }
         System.out.println(" Correctly added all players to the roster -> " + 
                            equal);
      }
   }
   
   
   /**
   *   Method to test whether removing a player from a team works correctly. The method 
   *   will print out true if the Team correct presents the number of players
   *   after removing   
   * 
   *   Assumes the .equals method on Players works correctly. 
   * 
   *   @param t The team to remove the player from
   *   @param p The player to find on the team. 
   */    
   //  public static void testRemovePlayer(Team t, Player p);
   //{
   //}
     
  /**
   *   Method to test whether finding a player on the team works correctly. The method 
   *   will print out true if the player is found based of the name
   *
   *   Assumes the .equals method on Players works correctly.
   *  
   *   @param t The team to attempt to find the player on 
   *   @param p The player to find on the team.  
   */
   public static void testFindPlayer(Team t, Player p)
   {
      String name = p.getName(); 
      Player foundPlayer = t.findPlayer(p.getName()); 
      System.out.println("Testing findPlayer on team " + t.getName() + 
                         " with name " + name + 
                         " return player " + foundPlayer); 
      if (foundPlayer != null)
         System.out.println("   returned expected player -> " + p.equals(foundPlayer)); 
   }
   
   
  /**
   *   Method to test whether updating a player's status on the team works correctly. The method 
   *   will print out true if the player's status is updated appropriately
   *  
   *   @param t The team to update the status of the player on
   *   @param p The player to find on the team.  
   */

     
   



}