//Daniel R  
//February 10
//Assignment 9
//CS 3
//Section B
//Student
import java.util.*;
public class Student
{
   /**                          
   * the first name of the student 
   */
   private String firstname;
   
   /**                          
   * the last name of the student 
   */
   private String lastname;
   
   /**                          
   * the grade of the student set to 0
   */
   private int grade=0;
   
   /**                          
   * the max number of classes/courses
   */
   private int max;
   
   /**                          
   * the courses array, the list of classes for the student
   */
   private String[] courses;
   
   /**                          
   * the number of courses that the student will take, set to 0
   */
   private int numcourses=0;
   
   /**
   * the constructor method, setting up the student
   *
   * @param first the first name
   * @param last the last name
   * @param grade the grade of the student
   * @param max the max number of classes 
   */
   public Student(String first,String last,int grade,int max)
   {
      if ((first==null)||(last==null)||(grade<=0)||(grade>=13)||(max<=0))
      {
         throw new IllegalArgumentException();
      }
      this.firstname=first;
      this.lastname=last;
      this.grade=grade;
      this.max=max;
      this.courses=new String[this.max];
      for (int x=0;x<max;x++)
      {
         this.courses[x]="Free";
      }
   }
   
   /**
   * gets the first name of the student
   * 
   * @return the first name 
   */
   public String getFirstName()
   {
      return firstname;
   }
   
   /**
   * gets the last name of the student 
   *
   * @return the lastname 
   */
   public String getLastName()
   {
      return lastname;
   }
   
   /**
   * get the first name plus the lastname with a space in the middle
   *
   * @return the fullname of the student
   */
   public String getFullName()
   {
      return firstname+" "+lastname;
   }  
   
   /**
   * gets the grade of the student 
   *
   * @return the grade
   */
   public int getGrade()
   {
      return grade;
   }
   
   /**
   * sets the current grade of the student to the integer of the parameter
   *
   * @param grade the new grade that will be changed 
   */
   public void setGrade(int grade)
   {
      if (grade<0)
      {
         throw new IllegalArgumentException();
      }
      this.grade=grade;
   }  
   
   /**
   * Returns the array of courses that the student is currently enrolled in
   *
   * @return the array of courses
   */
   public String[] getCourses()
   {
      return this.courses;
   }
   
   /**
   * gets the number of courses that the student will be taking 
   *
   * @return the amount of courses that the student will be taking (no frees)
   */
   public int getCourseCount()
   {
      return numcourses;
   }
   
   /**
   * Gets some information on the student and returns it as a string
   *
   * @return the grade, full name, and class list of the student
   */
   public String toString()
   {
      return grade+": "+getFullName()+" "+Arrays.toString(courses);
   }  
   
   /**
   * Checks to see if two student objects are exactly equal
   *
   * @param o the other Student Object
   * @return true if the two objects are equal, false if they are not.
   */
   public boolean equals(Object o)
   {
      if (o instanceof Student)
      {
         Student s=(Student) o;
         return (this.firstname.equals(s.getFirstName()))&&(this.lastname.equals(s.getLastName()))&&(this.grade==s.getGrade())&&(Arrays.equals(this.courses,s.getCourses()));
      }
      return false;
   }
   
   /**
   * adds a course to an existing free period and checks if the course already has a different one in it.
   *
   * @param course the course name
   * @param period the period number (not the array index)
   * @return true if the course added successfully, false if otherwise
   */
   public boolean addCourse(String course, int period)
   {
      if (course==null||period<1||period>this.max||!courses[period-1].equals("Free"))
      {
         return false;
      }
      
      this.courses[period-1]=course;
      this.numcourses+=1;
      return true;
   }
}