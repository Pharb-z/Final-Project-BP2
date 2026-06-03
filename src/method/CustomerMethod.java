package method;

import java.util.Scanner;

public class CustomerMethod {

    public static void showCustomerPage(Scanner sc) {

        System.out.println("\n-- Halaman Pembeli --");

        System.out.print("Nama Pembeli : ");
        String name = sc.nextLine();

        System.out.println("Selamat datang, " + name + "!");

        int choice;

        do {
            System.out.println("\n===== MENU PEMBELI =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Transaksi");
            System.out.println("3. Lihat Belanja");
            System.out.println("4. Selesai");
            System.out.print("Pilih : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    tambahBarang(sc);
                    break;
                case 2:
                    hapusTransaksi();
                    break;
                case 3:
                    lihatBelanja();
                    break;
                case 4:
                    selesaiBelanja();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 4);
    }

    public static void tambahBarang(Scanner sc) {

    }

    public static void hapusTransaksi() {

    }

    public static void lihatBelanja() {

    }

    public static void selesaiBelanja() {

    }
}