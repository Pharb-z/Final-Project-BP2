package model;

public class Member extends Customer {

    public String membershipLevel;
    public String password;

    public Member(String id, String name, String phone, String address, String password, String membershipLevel) {
        super(id, name, phone, address);
        this.password = password;
        this.membershipLevel = membershipLevel;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Membership Level: " + membershipLevel);
    }
    
}
