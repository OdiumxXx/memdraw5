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

    String cvsSplitBy = ",";    
    
    if (Frame1.filePath == null) {
      System.out.println("Load Member's Databse First!");
      Frame1.lblMemNum.setText("Setup Draw First!");
    }
    
    try (BufferedReader br = new BufferedReader(new FileReader(Frame1.filePath))) {

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
      // String Array list has been created, and had the initial title bars removed.

      // Create the clubMember Arraylist to be populated
      ArrayList<clubMember> clubMemberList = new ArrayList<>();


      // add the strings from the ArrayList<String> Lines to the ArrayList<clubMember> clubMemberList in the int, string, string format.
      for (int i=0; i<lines.size(); i++) {
        String currentLine = lines.get(i);
        System.out.println(lines.get(i));
        String[] currentMember = currentLine.split(cvsSplitBy);

        int ID = Integer.parseInt(currentMember[0]);
        String firstName = currentMember[5];
        String lastName = currentMember[4];


        clubMember newClubMemberForArray = new clubMember(ID, lastName, firstName);
        clubMemberList.add(newClubMemberForArray);
        //System.out.println(newClubMemberForArray);        
      }

      // Sort the new clubMember Array - the sorted list will be known as 'sortedclubMember'
      memberSorter ArraySorter = new memberSorter(clubMemberList);
      ArrayList<clubMember> sortedclubMemberStart = ArraySorter.getSortedclubMemberByID();     
      ArrayList<clubMember> sortedclubMember = ArraySorter.getSortedclubMemberByID();
      // add the array to itself, then add that doubled array to itself again.
      sortedclubMember.addAll(sortedclubMemberStart);
      sortedclubMember.addAll(sortedclubMemberStart);


      //      System.out.println(sortedclubMember);
      //            System.out.println("-----Sorted clubMember by ID: Ascending-----");
      //            int h = 0;
      //            for (clubMember clubMember : sortedclubMember) {
      //              h++;
      //              System.out.println(h+" "+clubMember);              
      //            }       



      // WE NOW HAVE OUR ARRAYS, HERE WE WILL USE THEM TO SELECT A RANDOM CLUBMEMBER AND THEN ALTERNATE UP AND DOWN THE ID NUMBERS FOR THE FOLLOWING DRAW CLICKS....somehow

      // Select a random member first
      if (Frame1.winner == "No memdraw.csv") {       

        // Choose a random member from the sorted array
        Random r = new Random();

        // set the random number to choose only from the last entry of the first array iteration, and the first entry of the third iteration
        // Note: Meaning the second iteration of the sortedClubMembers array will be where the random number is chosen initially chosen from 
        int z = lines.size();
        int y = lines.size();
        randomNumber  = r.nextInt(z) + y;


        // Select the lucky winner!
        clubMember randomMember = sortedclubMember.get(randomNumber);

        String winnerID = Integer.toString(randomMember.getID());
        String winnerFirstName = randomMember.getfirstName(); 
        String winnerLastName = randomMember.getlastName();

        // show winner
        Frame1.winner = winnerFirstName+" "+winnerLastName;
        Frame1.winnerNum = winnerID;
        //        System.out.println(Frame1.winner +" - "+ Frame1.winnerNum);
        n++;
        //        System.out.println("N = "+n);
        //        System.out.println(randomNumber);


      } else {

        // now the first member has been chosen cycle up and down members either side of that number
        // (As club standard is 10 iterations, extra arrays have been added to avoid 'Out Of Bounds' Exceptions)
        if (n % 2 == 0) {
          randomNumber = new Integer(randomNumber.intValue() + n); // if n is odd +
        } else {
          randomNumber = new Integer(randomNumber.intValue() - n); // if n is even -
        }

        // go ahead and get the next lucky member
        clubMember randomMember = sortedclubMember.get(randomNumber);


        String winnerID = Integer.toString(randomMember.getID());
        String winnerFirstName = randomMember.getfirstName(); 
        String winnerLastName = randomMember.getlastName();

        // show winner
        Frame1.winner = winnerFirstName+" "+winnerLastName;
        Frame1.winnerNum = winnerID;
        //        System.out.println(Frame1.winner);
        //        System.out.println(Frame1.winnerNum); 
        n++;
        //        System.out.println("N = " + n);
        //        System.out.println("randomNumber = "+randomNumber);
        //        System.out.println("------------");


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