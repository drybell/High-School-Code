//Daniel Ryaboshapka
//CS3
//March 2016
//Melody

import java.util.*;

public class Melody
{
   /*
   * the melody/song that is a queue of notes 
   */
   private Queue<Note> song;
   
   /*
   * the constructor. initializes song and checks if it is null to throw an IllegalArgumentException
   * @param song the melody of notes 
   */
   public Melody(Queue<Note> song)
   {
      if (song==null)
      { 
         throw new IllegalArgumentException();
      }
      this.song=song;
   }
   
   /*
   * returns the list of notes in the queue
   */
   public String toString() 
   {
      String total="";
      for(int x=0;x<song.size();x++)
      {
         Note a=song.remove();
         total=total+a.toString()+"\n";
         song.add(a);
      }
      return total;
   }
   
   /*
   * adds the melody of one song to the loaded song 
   * @param other the Melody object of the other song
   */
   public void append(Melody other)
   {
      if(other==null)
      {
         throw new IllegalArgumentException();
      }
      int a=other.song.size();
      for(int x=0;x<a;x++)
      {
         Note n=other.song.remove();
         song.add(n);
         other.song.add(n);
      }
   }
   
   /*
   * reverses the notes in the melody (front is now last note)
   */
   public void reverse()
   {
      Stack<Note> temp=new Stack<Note>();
      while (!song.isEmpty())
      {
         temp.push(song.remove());
      }
      while (!temp.isEmpty())
      {
         Note a=temp.pop();
         song.add(a);
      }
   }
   
   /*
   * Plays the notes and repeats when there is a section of two true notes.
   */
   public void play()
   {
      Queue<Note> repeat=new LinkedList<Note>();
      boolean r=false;
      for(int x=0;x<song.size();x++)
      {
         Note a=song.remove();
         a.play();
         if(r)
         {
            repeat.add(a);
            if(a.isRepeat())
            {
               int length=repeat.size();
               for (int ii=0;ii<length;ii++)
               {
                  Note b=repeat.remove();
                  b.play();
               }
               repeat=new LinkedList<Note>();
            }
         }  
         if(a.isRepeat())
         {
            if (!r)
            {
               repeat.add(a);
            }
            r=!r;
         }
         song.add(a);
      }
   }
   
   /*
   * returns the length in seconds of the song
   */
   public double getLength()
   {  
      Queue<Note> repeat=new LinkedList<Note>();
      boolean r=false;
      double total=0;
      for(int x=0;x<song.size();x++)
      {
         Note a=song.remove();
         total=total+a.getDuration();
         if(r)
         {
            repeat.add(a);
            if(a.isRepeat())
            {
               int length=repeat.size();
               for (int ii=0;ii<length;ii++)
               {
                  Note b=repeat.remove();
                  total=total+b.getDuration();
               }
               repeat=new LinkedList<Note>();
            }
         }  
         if(a.isRepeat())
         {
            if (!r)
            {
               repeat.add(a);
            }
            r=!r;
         }
         song.add(a);
      }
      return total;
   }
   
   /*
   * changes the tempo of the song to the speed of the parameter
   * @param tempo the new tempo of the song 
   */
   public void changeTempo(double tempo)
   {
      if (tempo<=0)
      {
         throw new IllegalArgumentException();
      }
      for (int x=0;x<song.size();x++)
      {
         Note a=song.remove();
         a.setDuration(a.getDuration()/tempo);
         song.add(a);
      }
   }
}