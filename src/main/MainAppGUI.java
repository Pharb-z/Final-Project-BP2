package main;

import gui.*;
import javax.swing.*;
import linkedlist.*;
import model.*;

public class MainAppGUI {

    static JFrame frame = new JFrame("Laundry Bu Yuli");
    static AppData data = new AppData();

    public static void main(String[] args) {

        // Membership
        data.memberList = new MemberLL();
        
        data.memberList.addMember("M1", "Rava", "085788812399", "Kalijudan", "123", "Bronze");
        data.memberList.addMember("M2", "Farhan", "081234567890", "Kepuh Kemiri", "123", "Bronze");
        data.memberList.addMember("M3", "Bhinar", "082737762367", "Tambaksari", "123", "Bronze");
        data.memberList.addMember("M4", "Farrel", "082334778343", "Sirapan", "123", "Bronze");

        // Service Kiloan
        data.serviceKiloan = new ServiceLL();
        data.serviceKiloan.addService("SK1", "Cuci Basah", 4000, "Kiloan");
        data.serviceKiloan.addService("SK2", "Cuci Kering", 6000, "Kiloan");
        data.serviceKiloan.addService("SK3", "Cuci Kering + Setrika", 7000, "Kiloan");
        data.serviceKiloan.addService("SK4", "Setrika", 5000, "Kiloan");

        // Service Satuan
        data.serviceSatuan = new ServiceLL();
        data.serviceSatuan.addService("SS1", "Cuci Kering", 10000, "Satuan");
        data.serviceSatuan.addService("SS2", "Cuci Kering + Setrika", 15000, "Satuan");
        data.serviceSatuan.addService("SS3", "Setrika", 10000, "Satuan");

        // Owner
        data.owner = new Owner("OWN", "Yuli", "0821398438434", "owner123");

        // Admin
        data.admin = new Admin("ADM1", "Radit", "0821923887323", "Sirapan", "admin123");

        // OrderList
        data.orderList = new OrderLL();

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showLandingPage();
        frame.setVisible(true);
    }

    public static void showLandingPage() {
        frame.setContentPane(new LandingPage(data));
        frame.revalidate();
        frame.repaint();
    }

    // Customer
    public static void showCustomerLogin() {
        frame.setContentPane(new CustomerLoginPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showCustomerMenu() {
        frame.setContentPane(new CustomerMenuPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showCustomerOrder() {
        frame.setContentPane(new CustomerOrderPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showCustomerDisplay() {
        frame.setContentPane(new CustomerDisplayPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    // Admin
    public static void showAdminLogin() {
        frame.setContentPane(new AdminLoginPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showAdminMenu() {
        frame.setContentPane(
                new AdminMenuPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showAdminDisplay() {

        frame.setContentPane(
                new AdminDisplayPanel(data));

        frame.revalidate();
        frame.repaint();
    }

    public static void showAdminProcess() {

        frame.setContentPane(
                new AdminProcessPanel(data));

        frame.revalidate();
        frame.repaint();
    }

    // Member
    public static void showMemberLogin() {
        frame.setContentPane(new MemberLoginPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showMemberMenu() {
        frame.setContentPane(new MemberMenuPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showMemberDisplay() {
        frame.setContentPane(new MemberDisplayPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showMemberOrder() {
        frame.setContentPane(new MemberOrderPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    // Owner
    public static void showOwnerLogin() {
        frame.setContentPane(new OwnerLoginPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showOwnerMenu() {

        frame.setContentPane(
                new OwnerMenuPanel(data));

        frame.revalidate();
        frame.repaint();
    }

    public static void showOwnerDisplay() {
        frame.setContentPane(
                new OwnerDisplayPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showOwnerEditPrice() {

        frame.setContentPane(
                new OwnerEditPricePanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showOwnerSalesReport() {

        frame.setContentPane(
                new OwnerSalesReportPanel(data));
        frame.revalidate();
        frame.repaint();
    }

    public static void showMemberSpendingReport() {

        frame.setContentPane(
                new MemberSpendingReportPanel(data));

        frame.revalidate();
        frame.repaint();
    }
}
