package main;

import java.util.Scanner;
import linkedlist.*;
import model.*;
public class OwnerApp {

    public static void main(String[] args) {
        String name = "";
        String pass = "";
        Scanner sc = new Scanner(System.in);
        ServiceLL serviceLL = new ServiceLL();
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
            System.out.println("1. Tambahkan Layanan");
            System.out.println("2. Tampilkan Layanan");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan id layanan: ");
                    String idService = sc.nextLine();
                    System.out.print("Masukkan nama layanan: ");
                    String serviceName = sc.nextLine();
                    System.out.print("Masukkan harga layanan: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Masukkan tipe layanan: ");
                    String type = sc.nextLine();
                    serviceLL.addService(idService, serviceName, price, type);
                    break;
                case 2:
                    serviceLL.displayService();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}
