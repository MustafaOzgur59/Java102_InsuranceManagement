import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance() {
        System.out.println("AddInsurance from individual");
        Scanner input = new Scanner(System.in);
        System.out.println("Insurance Types");
        System.out.println("1- Health Insurance\n" +
                "2- Resident Insurance\n" +
                "3- Travel Insurance\n" +
                "4- Car Insurance");
        System.out.print("Enter insurance type : ");
        Date start = new Date();
        switch (input.nextInt()) {
            case 1:
                if (!containsInsurance("HealthInsurance")){
                    Calendar c = Calendar.getInstance();
                    c.setTime(start);
                    c.add(Calendar.YEAR,4);
                    this.getInsurances().add(new HealthInsurance("Health Insurance",7200,start,c.getTime()));
                    System.out.println("Insurance has been made.");

                }else System.out.println("You already have this type of insurance.");

                break;
            case 2:
                if (!containsInsurance("ResidenceInsurance")){
                    Calendar c = Calendar.getInstance();
                    c.setTime(start);
                    c.add(Calendar.YEAR,10);
                    this.getInsurances().add(new ResidenceInsurance("Residence Insurance",15000,start,c.getTime()));
                    System.out.println("Insurance has been made.");

                }else System.out.println("You already have this type of insurance.");

                break;
            case 3:
                if (!containsInsurance("TravelInsurance")){
                    Calendar c = Calendar.getInstance();
                    c.setTime(start);
                    c.add(Calendar.YEAR,1);
                    this.getInsurances().add(new TravelInsurance("TravelInsurance",4000,start,c.getTime()));
                    System.out.println("Insurance has been made.");

                }else System.out.println("You already have this type of insurance.");

                break;
            case 4:
                if (!containsInsurance("CarInsurance")){
                    Calendar c = Calendar.getInstance();
                    c.setTime(start);
                    c.add(Calendar.YEAR,5);
                    this.getInsurances().add(new CarInsurance("Car Insurance",10000,start,c.getTime()));
                    System.out.println("Insurance has been made.");

                }else System.out.println("You already have this type of insurance.");

                break;
            default:
                System.out.println("Invalid insurance type!");
                break;
        }
    }


    @Override
    public int compareTo(Account o) {
        return this.getUser().getName().compareTo(o.getUser().getName());
    }
}
