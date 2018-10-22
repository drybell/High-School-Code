import java.util.*; 

public class RecordTester
{

   /** How many records to test */
   private static final int MAX_RECORDS = 4; 
   
   /** Maxiumum number of games in the "season" for a record (for testing) */
   private static final int MAX_GAMES = 100; 
   
   /**
    * Entry point for the program 
    */
   public static void main(String[] args)
   {
      Random r = new Random(99); 
      testRecords(r); 
   }
   
   /**
    *  Method to test plain ol' records with wins and losses. 
    *  @param r A random object to create random wins and losses
    */
   public static void testRecords(Random r)
   {
      System.out.println("Testing Record");
      Record[] records = new Record[MAX_RECORDS]; 
      
      // Randomly set the wins and losses. 
      for ( int ii = 0; ii < records.length; ii++)
      {
         records[ii] = new Record();
         int wins = r.nextInt(MAX_GAMES);
         int losses = MAX_GAMES - wins; 
         records[ii].setWins(wins);
         records[ii].setLosses(losses);
      }
      
      // Print out the records just to see what's there. 
      printRecords("Initial records", records); 
   
      // See if the wins and losses works
      // The first half won and the second half lost. 
      for ( int ii = 0; ii < records.length / 2; ii++)
      {
         records[ii].won(); 
         records[records.length - ii - 1].lost(); 
      }  
      
      // Print out the records just to see what's there. Did it work? 
      printRecords("\nRecords after winning and losing", records); 

      printBetterThan(records);
      
      // last test: check for equality
      Record newRecord = new Record(); 
      newRecord.setWins(records[0].getWins()); // tests get and set at the same time
      newRecord.setLosses(records[0].getLosses()); // tests get and set at the same time
      printEquals(newRecord, records[0]); 
   }
   
      
      
   /** 
    * Helper method to print out the records, first showing an informational string
    * @param information A string telling giving some information about the state of the records
    * @param records The records to be tested
    */
   public static void printRecords(String information, Record[] records)
   {
      System.out.println(information); 
      for ( int ii = 0; ii < records.length; ii++)
      {
         System.out.println("Record " + ii + " is " + records[ii]); 
      }   
      
   }
   
   /**
    *  A method to test the "isBetterThan" method in a record
    *  @param records The records to be tested
    */
   public static void printBetterThan(Record[] records)
   {
      // Now check if one is better than the other
      // Print out the records just to see what's there. Did it work? 
      System.out.println("\nChecking if \"isBetterThan\" works"); 
      for ( int ii = 0; ii < records.length - 1; ii++)
      {
         System.out.print("Record " + records[ii] + " is " );
         int rating = records[ii].isBetterThan(records[ii + 1]);
         if ( rating < 0 )
            System.out.print("not better than "); 
         else if ( rating > 0 )
            System.out.print("better than "); 
         else if ( rating == 0 )
            System.out.print("tied with "); 
         System.out.println("record " + records[ii+1]); 
      }    
   }

   public static void printEquals(Record record1, Record record2)
   {
      System.out.println("\nChecking if \".equals\" works");     
      if ( record1.equals(record2) ) // they should be equivalent
         System.out.println("The records are equal"); 
      else
         System.out.println("The records aren't equal, something went wrong...");
   }

}