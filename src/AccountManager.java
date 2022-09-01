import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager  {

    private static TreeSet<Account> accounts = new TreeSet<>();
    private static Scanner input = new Scanner(System.in);

    public static void populateAccounts(){
        Address address = new HomeAddress("İstanbul", "Maltepe", "EMEK CADDESİ", "ZÜMRÜTEVLER MAHALLESİ EMEK CADDESİ NO: 91 MALTEPE- İSTANBUL");
        User user1 = new User("John", "Doe",23, "johndoe@gmail.com", "123", "engineer",  new Date());
        Account account = new Individual(user1);

        Address address2 = new HomeAddress("Van", "Merkez", "Lale Sokak", "lale sokak no 46 van merkez");
        User user2 = new User("Holding", "Holding", 5, "holding@gmail.com", "holdingAŞ",   "this is a holding",  new Date());
        Account account2 = new Enterprise(user2);
        accounts.add(account);
        accounts.add(account2);
    }

    public static Account login(String email,String password){
        try {
            for(Account account : accounts){
                if (account.getUser().getPassword().equals(password) && account.getUser().getEmail().equals(email)){
                   return account.login(email,password);
                }
            }
        } catch (InvalidAuthenticationException e){
            System.out.println(e.toString());
        }
        return null;
    }


}
