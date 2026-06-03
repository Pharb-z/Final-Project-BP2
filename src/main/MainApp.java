package main;

import java.util.Scanner;
import method.MemberMethod;
import method.CustomerMethod;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Laundry Bu Yuli ===");
            System.out.println("1. Member");
            System.out.println("2. Pembeli");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    MemberMethod.showMemberMenu(sc);
                    break;

                case 2:
                    CustomerMethod.showCustomerMenu(sc);
                    break;

                case 3:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 3);

        sc.close();
    }
}