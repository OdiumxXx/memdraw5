package memdraw3;

import java.util.ArrayList;
import java.util.Collections;

// ---------- Members Sorter
public class memberSorter {     
  ArrayList<clubMember> clubMember = new ArrayList<>();       
  public memberSorter(ArrayList<clubMember> clubMember) {         
    this.clubMember = clubMember;     
  }       
  public ArrayList<clubMember> getSortedclubMemberByID() {         
    Collections.sort(clubMember);         
    return clubMember;     
  } 
}

// ---------------