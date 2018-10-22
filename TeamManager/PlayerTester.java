public class PlayerTester
{
   public static void main(String[] args)
   {
      testPlayers();
   }
   
   /** Method to test the Player class
    *
    */
   public static void testPlayers()
   {
      // Create a blank Player, 
      // then set the name and status using mutator methods.
      // Print out the result. 
      Player footballPlayer = new Player(); 
      footballPlayer.setName("Russell Wilson"); 
      footballPlayer.setStatus(false); 
      System.out.println(footballPlayer); 
      
      // Create a new Player with the one parameter constructor
      // do not set the status
      // print the result. 
      Player ultimatePlayer = new Player("Khalif El-salaam"); 
      System.out.println(ultimatePlayer);       
            
      // Create a new Player with the one parameter constructor
      // set the status to true. 
      // print the result. 
      Player soccerPlayer = new Player("Lionel Messi"); 
      soccerPlayer.setStatus(true); 
      System.out.println(soccerPlayer); 
      
      // Create a new Player with the two parameter constructor
      // print the result. 
      Player baseballPlayer = new Player("Edgar Martinez", false); 
      System.out.println(baseballPlayer); 
      
      // Create a new Player using the accessor methods to get the name and status from another Player. 
      // Print whether two objects are identical. 
      Player testPlayer = new Player(baseballPlayer.getName(), baseballPlayer.getStatus()); 
      System.out.print(testPlayer + " is"); 
      if ( !testPlayer.equals(baseballPlayer) )
         System.out.print(" not"); 
      System.out.println(" equal to " + baseballPlayer); 
      
      TeamPlayer a=new TeamPlayer();
      System.out.println(a);
      TeamPlayer b=new TeamPlayer("Dan Marcus",true,"tactical support");
      System.out.println(b);
      TeamPlayer testPlayer1 = new TeamPlayer(a.getName(), a.getStatus(),a.getPosition()); 
      System.out.print(testPlayer1 + " is"); 
      if ( !testPlayer.equals(a) )
         System.out.print(" not"); 
      System.out.println(" equal to " + a); 
      b.setPosition("tryhard");
      System.out.println(b);
      
      IndividualPlayer c=new IndividualPlayer();
      Record r=new Record();
      IndividualPlayer d=new IndividualPlayer("Doodle Boodle",true,r);
      System.out.println(d.getRecord());
      Record new1=new Record(1,3);
      d.setRecord(new1);
      System.out.println(d.getRecord());
      System.out.println(d.getWins()+d.getLosses());
      d.setWins(100);
      d.setLosses(10);
      System.out.println(d.getRecord());
      d.won();
      d.won();
      d.lost();
      System.out.println(d.getRecord()+" Percent: "+d.getPercent());
      
   }    
}