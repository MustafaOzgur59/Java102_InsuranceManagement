import java.util.Scanner;

public class LoginOperations {
    private static final Scanner scanner=new Scanner(System.in);
    public static void login(){
        AccountManager.populateAccounts();
        System.out.println("Welcome to the login manager");
        System.out.print("Enter email : ");
        String email=scanner.nextLine();
        System.out.print("Enter password : ");
        String password=scanner.nextLine();
        Account loginAccount = AccountManager.login(email,password);
        if(loginAccount!=null){
            loginAccount.showUserInfo();
            run(loginAccount);
        }
        else System.out.println("Invalid email or password");

    }
    private static void run(Account account){
        while (true){
            System.out.println("Operation List");
            System.out.println("0- Exit.\n"+
                    "1- Show account info\n" +
                    "2- Add new insurance\n" +
                    "3- Add new address\n" +
                    "4- Remove existing address\n");
            System.out.print("Enter the operation number : ");
            int value=scanner.nextInt();
            switch (value) {
                case 1:
                    account.showUserInfo();
                    break;
                case 2:
                    account.addInsurance();
                    break;
                case 3:
                    account.addAddress();
                    break;
                case 4:
                    account.getUser().deleteAddres();
                    break;
                case 9:
                default:
                    System.exit(0);
            }
        }
    }
}
