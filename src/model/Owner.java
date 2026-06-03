package model;

public class Owner extends User {

    public String password;

    public Owner(String id, String name, String phone, String password) {
        super(id, name, phone);
        this.password = password;
    }


    @Override
    public void showInfo() {
        super.showInfo();
    }
}
