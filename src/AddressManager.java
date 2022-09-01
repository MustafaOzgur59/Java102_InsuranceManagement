import java.util.Scanner;

public class AddressManager {
    private static Scanner input = new Scanner(System.in);

    public static void addAddress(User user){
        int addressChoice;
        String cityName;
        String districtName;
        String street;
        String detail;
        System.out.println("Please chooice type of address : Home(1) / Business(2)");
        do {
            addressChoice = input.nextInt();
            if (addressChoice > 3 || addressChoice <=0){
                System.out.println("Please enter 1 or 2");
            }
        } while (addressChoice > 3 || addressChoice <=0);
        System.out.println("Enter city : ");
        cityName = input.nextLine();
        System.out.println("Enter district : ");
        districtName = input.nextLine();
        System.out.println("Enter street : ");
        street = input.nextLine();
        System.out.println("Enter detail : ");
        detail = input.nextLine();
        switch (addressChoice){
            case 1:
                user.getAddresses().add(new HomeAddress(cityName,districtName,street,detail));
                break;
            case 2:
                user.getAddresses().add(new BusinessAddress(cityName,districtName,street,detail));
                break;
        }
        System.out.println("New address added");
    }

    public static void deleteAddress(User user, String uuid){
        for(Address a: user.getAddresses()){
            if (a instanceof HomeAddress){
                if (((HomeAddress) a).getUuid().equals(uuid)){
                    user.getAddresses().remove(a);
                    System.out.println("Home address deleted successfully");
                    return;
                }
            } else {
                if (((BusinessAddress) a).getUuid().equals(uuid)){
                    user.getAddresses().remove(a);
                    System.out.println("Business address deleted successfully");
                    return;
                }
            }
        }
        System.out.println("Address deletion failed");
    }
}
