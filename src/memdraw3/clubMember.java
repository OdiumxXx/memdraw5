package memdraw3;

//  CREATE NEW OBJECT 'CLUB MEMBER'


public class clubMember implements Comparable<clubMember> {     
  private int ID;     
  private String lastName;
  private String firstName;

  public clubMember(int ID, String lastName, String firstName) {         
    this.ID = ID;         
    this.lastName = lastName;         
    this.firstName = firstName;     
  }       
  public int getID() {         
    return ID;     
  }       
  public String getlastName() {         
    return lastName;     
  }                      
  public String getfirstName() {         
    return firstName;     
  }       
  @Override     
  public int compareTo(clubMember candidate) {          
    return (this.getID() < candidate.getID() ? -1 : 
      (this.getID() == candidate.getID() ? 0 : 1));     
  }       
  @Override     
  public String toString() {         
    return this.ID+ ", " + this.lastName+ ", " + this.firstName;     
  } 
}


