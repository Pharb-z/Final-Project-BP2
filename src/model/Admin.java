package model;

public class Admin extends User {

    public String address;
    public String password;

    public Admin(String id, String name, String phone, String address, String password) {
        super(id, name, phone);
        this.address = address;
        this.password = password;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Address: " + address);
    }

}
