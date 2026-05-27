package model;

public class Customer extends User {

    public String address;

    public Customer(String id, String name, String phone, String address) {
        super(id, name, phone);
        this.address = address;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Address: " + address);
    }
}
