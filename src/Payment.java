import java.io.FileWriter;
import java.io.IOException;

public class Payment {

    // variables

    private String active;

    private int passive = 500;

    private int underAge = 1000;

    private int overAge = 1600;
    private int over60 = 1200;
    private double rent = 0.75;

    // calling initializing Membership class
    Membership membership = new Membership();

    // constructor
    public Payment(String active, int passive, int underAge, int overAge, int over60, int rent) {
        setActive();
        setPassive();
        setUnderAge();
        setOverAge();
        setOver60();
        setRent();
    }

    // getter
    public String getActive() {
        return active;
    }

    public int getPassive() {
        return passive;
    }

    public int getUnderAge() {
        return underAge;
    }

    public int getOverAge() {
        return overAge;
    }

    public int getOver60() {
        return over60;
    }

    public double getRent() {
        return rent;
    }

    // setter
    public void setActive() {
        this.active = active;
    }

    public void setPassive() {
        this.passive = passive;
    }

    public void setUnderAge() {
        this.underAge = underAge;
    }

    public void setOverAge() {
        this.overAge = overAge;
    }
    public void setOver60() {
        this.over60 = over60;
    }

    public void setRent() {
        this.rent = rent;
    }

    // method for debt and payment
    public void paymentNowOrDebt() {
        Membership membership = new Membership();
        if  (membership.getInputLine().equals("passive".toLowerCase())) {
            System.out.println(membership.getInputLine() + " your price is " + passive);
        }
        if (membership.getAge() < 18) {
            System.out.println(" your junior price is " + underAge);
        } else if (membership.getAge() >= 18 && membership.getAge() < 60) {
            System.out.println(" your senior price is " + overAge);
        } else {
        System.out.println(" your senior discount is " + over60);
        }


    }


    // method for delete member
    public void delete() {

    }

    // method for print the payment to a text file
    public void paymentTextFile() {
        try {
            FileWriter paymentFile = new FileWriter("payment.txt");
            paymentFile.write("Payment success");
            paymentFile.close();
            System.out.println("Payment success!");
        } catch (IOException e) {
            System.out.println("An error in Payment file.");
            e.printStackTrace();
        }
    }
}