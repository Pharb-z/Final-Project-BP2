package main;

import java.util.Scanner;
import linkedlist.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceLL serviceLL = new ServiceLL();
        int choice;
        do{
            System.out.println("1. Add a node");
            System.out.println("2. Display the list");
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
    }
}
