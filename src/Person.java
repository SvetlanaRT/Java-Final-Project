import java.util.Scanner;

public class Person {
    //var
    public String id;
    public String firstName;
    public String lastName;
    public MaritalStatus status;

//constructor

    public Person(String id, String firstName, String lastName, MaritalStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public Person(){
        id = "unknown";
        firstName = "unknown";
        lastName  = "unknown";
        status = null;
    }
//methods
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
         id = sc.next();

        System.out.println("Enter FIRST name: ");
        firstName = sc.next();

        System.out.println("Enter LAST name: ");
        lastName = sc.next();

        System.out.println("Enter status (SINGLE/MARRIED/DIVORCED):");
        String enteredStatus = sc.next().toUpperCase();
        status = MaritalStatus.valueOf(enteredStatus);
    }
    public  String getId(){
        return id;
    }
    @Override
    public String toString() {

        return String.format("ID: %-7s  First Name: %-7s  Last Name: %-7s  Status: %-7s  ",
                               id,  firstName,      lastName,        status.toString().toLowerCase()
        );
    }
}
