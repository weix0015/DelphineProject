import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class Membership {

    // variables
    private String firstName;

    private String surname;

    private int age;

    private String birtInput;

    private String inputLine;

    private int input;

    private String userInput;

    private static int nextMember = 1;

    private int memberNumber;

    // constructor

    public Membership() {
        memberNumber = nextMember++;
    }

    // Arraylist

    private ArrayList <String> member = new ArrayList<>();

    // Scanner
    Scanner sc = new Scanner(System.in);

    // getter

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
    public int getMemberNumber() {
        return memberNumber;
    }

    public String getInputLine() {
        return inputLine;
    }


    //setter -----------------
    public void setSurname() {
        this.surname = surname;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public void setAge() {
        this.age = age;
    }

    // method for the membership

    public void membershipInformation() {
        System.out.println("What is your first name ?");
        firstName = sc.nextLine();
        System.out.println("What is your surname ?");
        surname = sc.nextLine();
        activeOrPassiveMember();
    }

    // method for member information

    public void membersBirth() {
        System.out.println("Enter your date of birth in the following format 'YYYY-MM-DD':");
        birtInput = sc.nextLine();
    }

    // method for calculating age

    public void calculatingAge() {
        try {
            LocalDate birth = LocalDate.parse(birtInput);
            LocalDate presentDate = LocalDate.now();
            if (Period.between(birth, presentDate).getYears() < 18 ) {
                System.out.println("Because you are under 18, so you will be set on the junior team");
            }
            else if (Period.between(birth, presentDate).getYears() >= 18) {
                System.out.println("Because you are 18 or above so you will be set on the senior team");
            }
        } catch (Exception e) {
            System.err.println("something went wrong");
        }
    }

    // method for active membership or passive membership
    public void activeOrPassiveMember () {
        System.out.println("Do you want a active or passive membership?");
        System.out.print("Enter : ");
        inputLine = sc.nextLine();
        member.add(inputLine + "Member");
        if (inputLine.equals("passive".toLowerCase())) {
            membersBirth();
            System.out.println("Your membership is set to a passive membership from "
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " "))
                    + "Your member number is " + getMemberNumber());
        } else if (inputLine.equals("active".toLowerCase())) {
            System.out.println("Your membership is now ready and is a active membership from following date: "
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " "))
                    + "Your member number is " + getMemberNumber());
            membersBirth();
            exerciserOrCompetitionSwimmer();
        }
    }

    // method for register exerciser or competition swimmer
    public void exerciserOrCompetitionSwimmer() {
        System.out.println("Do you want to be registered as a competition swimmer or exerciser");
        System.out.println("Choose '1' (competition swimmer) \nChooose '2' (exerciser) ");
        input = sc.nextInt();
        if (input == 1)  {
            System.out.println("You are now registered as a competition swimmer");
            calculatingAge();
        }
        else if (input == 2) {
            System.out.println("You are now registered as a exerciser");
        }
    }

    // method for changing membership
    public void changeMembership () {
        System.out.println("You want to change your membership");
        System.out.println("write your membership ID: ");
        userInput = sc.nextLine();
        if (userInput.equals(memberNumber)) {
            member.remove(inputLine);
            changeOutcome();
        }
    }

    // method for after changing membership
    public void changeOutcome() {
        if (userInput.equals("active".toLowerCase())) {
            System.out.println("Your membership is change to a passive membership");
            inputLine = "Passive Member";
            member.add(inputLine);
        } else if (userInput.equals("passive".toLowerCase())) {
            System.out.println("Your membership is change to a active membership");
            inputLine = "active member";
            member.add("active member");
        }
    }

    // method for delete membership
    public void deleteMembership () {
        try {
            System.out.println(" Write the number for the line you want to delete");
            input = sc.nextInt();
            if (input == memberNumber) {
                member.remove(input);
                System.out.println(input + " is not a member from"
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss" + " ")));
            }
        }catch (Exception e) {
            System.out.println("Something went wrong while deleting a member");
        }
    }
}