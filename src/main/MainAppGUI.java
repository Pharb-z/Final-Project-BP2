package main;

import gui.*;
import javax.swing.*;
import model.*;

public class MainAppGUI {

    static JFrame frame = new JFrame("Laundry Bu Yuli");
    static AppData data = new AppData();

    public static void main(String[] args) {
        // Load customer dan service dari database
        //data.services = ServiceDatabase.getAllServices();
        // Load orders dari database menggunakan OrderDatabase
        //data.orders = OrderDatabase.getAllOrders();
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
}
