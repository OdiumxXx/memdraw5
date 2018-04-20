package memdraw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import memdraw3.Frame1;


public class CSVReader {

  //    public static void func3(String s) {
  //    Frame1.memDrawWinner(s);
  //  }

  ArrayList<clubMember> clubMemberList = new ArrayList<>();
  static Integer randomNumber;
  static int n = 0;

  public static void main(String[] args) {

    String csvFile = "memdraw.csv";
    String cvsSplitBy = ",";    

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


      List<String> lines = new ArrayList<String>();
      String line = br.readLine();

      while( line != null ) {
        if (line.contains("FINANCIAL")) {
          line = br.readLine();
        } else {
          lines.add(line+"\n ");
          line = br.readLine();
        }
      }
      // String Array list has been created, and had the inital title bars removed.

      // Create the clubMember Arraylist to be populated
      ArrayList<clubMember> clubMemberList = new ArrayList<>();


      // add the strings from the ArrayList<String> Lines to the ArrayList<clubMember> clubMemberList in the int, string, string format.
      for (int i=0; i<lines.size(); i++) {
        String currentLine = lines.get(i);
        String[] currentMember = currentLine.split(cvsSplitBy);

        String firstName = currentMember[5];
        String lastName = currentMember[4];
        int ID = Integer.parseInt(currentMember[0]);

        clubMember newClubMemberForArray = new clubMember(ID, lastName, firstName);
        clubMemberList.add(newClubMemberForArray);
        //System.out.println(newClubMemberForArray);        
      }

      // Sort the new clubMember Array - the sorted list will be known as 'sortedclubMember'
      memberSorter ArraySorter = new memberSorter(clubMemberList);
      ArrayList<clubMember> sortedclubMember = ArraySorter.getSortedclubMemberByID();         
      //      System.out.println("-----Sorted clubMember by ID: Ascending-----");
      //      int h = 0;
      //      for (clubMember clubMember : sortedclubMember) {
      //        h++;
      //        System.out.println(h+" "+clubMember);
      //        
      //      }       



      // WE NOW HAVE OUR ARRAYS, HERE WE WILL USE THEM TO SELECT A RANDOM CLUBMEMBER AND THEN ALTERNATE UP AND DOWN THE ID NUMBERS FOR THE FOLLOWING DRAW CLICKS....somehow

      // RANDOM MEMBER FIRST
      if (Frame1.winner == "No memdraw.csv") {       

        // Choose a random member from the sorted array
        Random r = new Random();
        randomNumber = r.nextInt(lines.size());
        clubMember randomMember = sortedclubMember.get(randomNumber);

        String winnerID = Integer.toString(randomMember.getID());
        String winnerFirstName = randomMember.getfirstName(); 
        String winnerLastName = randomMember.getlastName();

        // show winner
        Frame1.winner = winnerFirstName+" "+winnerLastName;
        Frame1.winnerNum = winnerID;
        System.out.println(Frame1.winner +" - "+ Frame1.winnerNum);

        n++;
        System.out.println("N = "+n);
        System.out.println(randomNumber);

      } else {

        // FOLLOWING NUMBER CYCLE
        if (n % 2 == 0) {
          randomNumber = new Integer(randomNumber.intValue() - n);
        } else {
          randomNumber = new Integer(randomNumber.intValue() + n);
        }

        // Check randomNumber hasn't exceeded the size of our array  ITS ALL FUCKED UP RIGHT HERE
        if (randomNumber > sortedclubMember.size()-1) {          
          randomNumber = new Integer(2);          
        }
        if (randomNumber == 0) {
          randomNumber = new Integer(sortedclubMember.size()-1);          
        }


        // go ahead and get the next lucky member
        clubMember randomMember = sortedclubMember.get(randomNumber);



        //int IDint = randomMember.getID();
        String winnerID = Integer.toString(randomMember.getID());
        String winnerFirstName = randomMember.getfirstName(); 
        String winnerLastName = randomMember.getlastName();

        // show winner
        Frame1.winner = winnerFirstName+" "+winnerLastName;
        Frame1.winnerNum = winnerID;
        System.out.println(Frame1.winner);
        System.out.println(Frame1.winnerNum); 
        n++;
        System.out.println("N = "+n);
        System.out.println("randomNumber = "+randomNumber);        
        //System.out.println("MADE IT" + sortedclubMember.get(randomNumber));

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  //  public String csvFunc(String s) {   
  //    System.out.println(s);
  //    return s;
  //    
  //  }


}