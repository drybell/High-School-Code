//Daniel Ryaboshapka
//February 10
//CS 3
//Section B
//School
import java.util.*;
public class School
{
   /**                          
   * the maximum grade
   */
   public static final int MAXGRADE=12;
   
   /**                          
   * the maximum amount of classes
   */
   public static final int MAXCLASSES=8;
   
   /**                          
   *the minimum grade
   */
   public static final int MINGRADE=9;
   
   /**
   * The main method: integrating all of the methods and creating the two student objects in order to compare them
   *
   * @param args Console Input
   */
   public static void main(String[] args)
   {
      Scanner console=new Scanner(System.in);
      Student s=getStudent(console);
      Student s2=getStudent(console);
      System.out.println("Student "+s.getFullName()+" is taking courses "+Arrays.toString(s.getCourses()));
      System.out.println("Student "+s2.getFullName()+" is taking courses "+Arrays.toString(s2.getCourses()));
      
      String[] course1=s.getCourses();
      String[] course2=s2.getCourses();
      int counter=0;
      String conc="";
      for (int ii=0;ii<MAXCLASSES;ii++)
      {
         if (course1[ii].equals(course2[ii]))
         {
            conc=(conc+(ii+1)+" - "+course1[ii]+"\n   ");
            counter++;
         }
      }
      if (counter==0)
      {
         System.out.println("The students have no shared classes.");
      }
      else
      {
         System.out.println("The students have the following classes in common: ");
         System.out.println("   "+conc);
      }
   }
   
   /**
   * Gets the Student object by asking robustly for classes, name, grade, etc.
   *
   * @param console the Scanner object 
   * @return the Student object with the information gained after using the method
   */
   public static Student getStudent(Scanner console)
   {
      System.out.print("What is the student's name (firstname lastname)? ");
      String name=Inputter.getName(console);
      Scanner lineScan=new Scanner(name);
      String firstname=lineScan.next();
      String lastname="";
      if (lineScan.hasNext())
      {
         lastname=lineScan.nextLine();
         lastname=lastname.trim();
      }
      System.out.print("What is the student's grade (9-12)? ");     //should use min and max grade but ran out of time
      int grade=Inputter.getGrade(console);
      System.out.print("How many courses is this student taking (1-8)? ");   //should use maxclasses and 1 but ran out of time
      int numcourse=Inputter.getNumCourses(console,"How many courses is this student taking (1-8)? ");    //should use maxclasses and 1 but ran out of time
      Student s= new Student(firstname,lastname,grade,MAXCLASSES);
      getCourses(console,numcourse,s);
      return s;
   }
   
   /**
   * Adds the courses to the Student object and checks to see if that is possible
   *
   * @param console the Scanner Object
   * @param numcourse the number of courses that the student takes
   * @param s the Student Object
   */
   public static void getCourses(Scanner console,int numcourse,Student s)
   {
      for (int x=0;x<numcourse;x++)
      {
         System.out.print("Course "+(x+1)+" name? ");
         String course=Inputter.getCourseName(console,(x+1));
         System.out.print("Period for "+course+" (1-8)? ");
         int coursenum=Inputter.getNumCourses(console,"Period for "+course+" (1-8)? " );
         boolean test=s.addCourse(course,coursenum);
         while (test==false)
         {
             System.out.println(s.getFullName()+" is already taking a course in period "+coursenum);
             System.out.print("Course "+(x+1)+" name? ");
             course=Inputter.getCourseName(console,(x+1));
             System.out.print("Period for "+course+" (1-8)? ");
             coursenum=Inputter.getNumCourses(console,"Period for "+course+" (1-8)? " );
             test=s.addCourse(course,coursenum);
         }
      }
      System.out.println();
   }
}  