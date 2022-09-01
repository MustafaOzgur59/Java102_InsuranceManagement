import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract  class Account implements  Comparable<Account> {
    private User user;
    private ArrayList<Insurance> insurances = new ArrayList<>();
    private AuthenticationStatus status=AuthenticationStatus.FAIL;



    enum AuthenticationStatus{
        FAIL,
        SUCCESS;
    }

    private static Scanner input = new Scanner(System.in);
    public Account(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public final void showUserInfo(){
        System.out.println("User name : "+user.getName()+" "+user.getLastName());
        System.out.println("E-mail : "+user.getEmail()+" Mesleği : "+ user.getJob());
        System.out.println("Age : "+ user.getAge()+" Last Entry Date : "+ user.getLastEntry()
                + "Account Type : " + user.getClass().getSimpleName());
        System.out.println("Addresses");
        for(Address a : this.user.getAddresses()){
            a.showAddressInfo();
        }
    }
    public Account login(String email,String password) throws InvalidAuthenticationException {
        if(this.getUser().getEmail().equals(email) && this.getUser().getPassword().equals(password)){
            status=AuthenticationStatus.SUCCESS;
            return this;
        }
        else throw new InvalidAuthenticationException("Giriş işlemi başarısız.");
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public void addAddress(){
        AddressManager.addAddress(this.user);
    }

    public abstract void addInsurance();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return user.equals(account.user) && Objects.equals(insurances, account.insurances) && status == account.status;
    }

    public boolean containsInsurance(String insuranceClassName){
        for(Insurance i : insurances){
            if (i.getClass().getSimpleName().equals(insuranceClassName)){
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insurances, status);
    }
}
