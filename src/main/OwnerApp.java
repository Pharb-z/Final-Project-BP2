package main;

import java.util.Scanner;
import linkedlist.*;
import model.*;

public class OwnerApp {

    public static void main(String[] args) {
        String name = "";
        String pass = "";
        Scanner sc = new Scanner(System.in);
        ServiceLL serviceKiloan = new ServiceLL(); //Object Service Kiloan
        ServiceLL serviceSatuan = new ServiceLL(); //Object Service Satuan
        //Service Kiloan
        serviceKiloan.addService("SRV1", "Cuci Basah", 4000, "Kiloan");
        serviceKiloan.addService("SRV2", "Cuci Kering", 6000, "Kiloan");
        serviceKiloan.addService("SRV3", "Cuci Kering + Setrika", 7000, "Kiloan");
        serviceKiloan.addService("SRV4", "Setrika", 5000, "Kiloan");
        //Service Satuan
        serviceSatuan.addService("SRV1", "Cuci Kering", 10000, "Satuan");
        serviceSatuan.addService("SRV2", "Cuci Kering + Setrika", 15000, "Satuan");
        serviceSatuan.addService("SRV3", "Setrika", 10000, "Satuan");
        Owner owner = new Owner("1", "Yuli", "0821398438434", "admin123");
        int choice;
        do {
            System.out.println("Laundry Bu Yuli (Owner)");
            System.out.print("Masukkan username : ");
            name = sc.nextLine();
            System.out.print("Masukkan password : ");
            pass = sc.nextLine();
        } while (!name.equalsIgnoreCase(owner.name) && !pass.equals(owner.password));
        do {
            System.out.println("Hai " + owner.name + "!");
            System.out.println("1. Tampilkan Order Penjualan yang sudah diproses");
            System.out.println("2. Tampilkan Order Penjualan yang belum diproses");
            System.out.println("3. Tampilkan Layanan");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Layanan Laundry Kiloan");
                    serviceKiloan.displayService();
                    System.out.println("Layanan Laundry Satuan");
                    serviceSatuan.displayService();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
