//Daniel Ryaboshapka
//Assignment 9
//December 16 - Feb 11 2016
//CS3
//Section B
//Inputter

import java.io.*;

import java.util.*;

public class Inputter
{
   /*
   * The file location
   */
   public static final String DATA="dragon/";
   
   /*
   * The minimum level.
   */
   public static final int MIN=1;
   
   /*
   * The maximum level. 
   */
   public static final int MAX=25;
   
   /*
   * The smallest window size.
   */
   public static final int MINWINDOW=100;
   
   /*
   * The largest window size.
   */
   public static final int MAXWINDOW=2000;

   /*
   * Gets the level that the user wants to be used for the dragon drawing
   * @param input the scanner object
   * @return userinput the robustly user inputted number from 1-25.
   */
   public static int getSize(Scanner input) 
   {
      
      boolean test=false;
      int userinput=0;
      
      while (test==false && (userinput<MIN || userinput>MAX))
      {
         
         System.out.print("Enter the level of the fractal you'd like to see (" + MIN+ "-"+MAX+"): ");

         try
         {
            userinput=input.nextInt();
            test=true;
            if (test=true && (userinput<MIN || userinput>MAX))
            {  
               System.out.println("Your number needs to be between " + MIN+ " and "+MAX);
               test=false;
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("You must enter an *integer* between "+ MIN+" and "+ MAX+". ");
            input.next();  
         }
         
      }
      return userinput;
   } 
     
   /*
   * Gets the window size for the Drawing Panel
   * @param the scanner object
   * @return the user inputted number from 100-2000
   */
   public static int getWindow(Scanner input)
   {
      boolean test=false;
      int userinput=0;
      
      while (test==false && (userinput<MINWINDOW || userinput>MAXWINDOW))
      {
         
         System.out.print("Enter the size of your drawing panel, in pixels (" + MINWINDOW+ "-"+MAXWINDOW+"): ");

         try
         {
            userinput=input.nextInt();
            test=true;
            if (test=true && (userinput<MINWINDOW || userinput>MAXWINDOW))
            {  
               System.out.println("Your number needs to be between " + MINWINDOW+ " and "+MAXWINDOW+".");
               test=false;
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("You must enter an *integer* between "+ MINWINDOW+" and "+ MAXWINDOW+". ");
            input.next();  
         }
         
      }
      return userinput;
   }
   
   /*
   * Robustly asks for a file to scan using user input.
   * @param input the Scanner object
   * @return fileScan the file Scanner object
   */
   public static Scanner processFile(Scanner input) 
   {
      System.out.print("Input file name? ");
      String userinput=input.nextLine();
      File f=new File(DATA+userinput);
      Scanner fileScan=null;
      boolean test=false;
      while (test==false)
      {
         try
         {
            fileScan=new Scanner(f);
            test=true;
         }
         catch (FileNotFoundException e)
         {
            System.out.print("File Not Found. Try again: Input file name? ");
            userinput=input.nextLine();
            f=new File(DATA+userinput);
         }
      }
      //PrintStream output=createOutputFile(userinput, input);
      //while (fileScan.hasNext())
      //{
        // String line=fileScan.nextLine();
         //Scanner lineScan=new Scanner(line);
        // while (lineScan.hasNext())
         //{ 
          //  String output1=lineScan.next();
           // output.println(output1);
         //} 
      //}
      return fileScan;
   } 
    
   /*
   * Robustly asks for an output file to write to.
   * @param input the file name
   * @return output the file
   */
   public static PrintStream createOutputFile(String filename)
   {
      File f=new File(filename);
      PrintStream output=null;
      try
      {
         output=new PrintStream(f);
      }
      catch (FileNotFoundException e)
      {
         System.out.print("Error opening output file for writing. Curve not drawn.");
      }
    
      return output;   
   }
   
   /**
   * Adds a space in between the first and last name in order to return the full name.
   *
   * @param input the Scanner Object 
   * @return the full name of the user
   */
   public static String getName(Scanner input)
   {
      String fullname=input.nextLine();
      return fullname;
   }  
   
   /**
   * Gets the grade of the student
   *
   * @param input the Scanner Object 
   * @return the robustly entered grade
   */
   public static int getGrade(Scanner input)
   {
      int grade=0;
      boolean test=false;
      while ((test==false)&&((grade<8)||(grade>12)))
      {
         try
         {
            grade=input.nextInt();
            input.nextLine();
            if ((grade<8)||(grade>12))
            {
               System.out.println("Your number needs to be between 9 and 12.");
               System.out.print("What is the student's grade (9-12)? ");
               test=false;
            }
            else
            {
               test=true;
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("You must enter an *integer* between 9 and 12.");
            System.out.print("What is the student's grade (9-12)? ");
            input.nextLine();
         }     
      }
      return grade;
   }
   
   /**
   * Gets the total number of courses that the student will take and checks for errors.
   *
   * @param input the Scanner object 
   * @param question the question for use in multiple methods
   * @return the number of courses that the student will take
   */
   public static int getNumCourses(Scanner input, String question)
   {
      int courses=0;
      boolean test=false;
      while ((test==false)&&((courses<8)||(courses>12)))
      {
         try
         {
            courses=input.nextInt();
            input.nextLine();
            if ((courses<1)||(courses>8))
            {
               System.out.println("Your number needs to be between 1 and 8.");
               System.out.print(question);
               test=false;
            }
            else
            {
               test=true;
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("You must enter an *integer* between 1 and 8.");
            System.out.print(question);
            input.nextLine();
         }     
      }
      return courses;
   }
   
   /**
   * Gets the course name of the student when adding, and also checks if the user inputted an empty string
   * 
   * @param input the Scanner Object 
   * @param period the number of the course (from 1-8)
   * @return the course name 
   */
   public static String getCourseName(Scanner input,int period)
   { 
      String coursename="";
      while (coursename.equals(""))
      {
         coursename=input.nextLine();
         if (coursename.equals(""))
         {
            System.out.println("Input is not valid, you need to enter some text");
            System.out.print("Course "+period+" name? ");
         }
      }
      return coursename;
   }
}