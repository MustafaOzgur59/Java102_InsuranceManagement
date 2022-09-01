import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User {
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private String job;
    private ArrayList<Address> addresses = new ArrayList<>();
    private Date lastEntry;

    public User(String name, String lastName, int age, String email, String password
            , String job,  Date lastEntry) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.job = job;
        this.lastEntry = lastEntry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getLastEntry() {
        return lastEntry;
    }

    public void setLastEntry(Date lastEntry) {
        this.lastEntry = lastEntry;
    }


    public void deleteAddres() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which address do you want to delete");
        for (Address a : addresses){
            System.out.println("Do you want to delete this address : ");
            a.showAddressInfo();
            System.out.println("Press <y> for yes or <no>");
            String choice = input.nextLine();
            if (choice.equals("y")){
                addresses.remove(a);
            }
        }
        System.out.println("Deletion completed");

        input.close();
    }
}
