public class BusinessAddress implements Address{
    private String city;
    private String district;
    private String street;
    private String addressDetails;

    private String uuid;


    public BusinessAddress(String city,String district,String street,String addressDetails){
        this.city=city;
        this.district=district;
        this.street=street;
        this.addressDetails=addressDetails;
        this.uuid = java.util.UUID.randomUUID().toString();

    }

    @Override
    public void showAddressInfo() {
        System.out.println("İş adresi :");
        System.out.println("Şehir : " + this.getCity() + ", İlçe : " + this.getDistrict() + ", Sokak  : " + this.getStreet());
        System.out.println("Detaylı Adres : " + this.getAddressDetails());
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}