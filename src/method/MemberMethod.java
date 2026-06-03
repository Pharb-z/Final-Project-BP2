package method;

import java.util.Scanner;

public class MemberMethod {

    public static void showMemberMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== MENU MEMBER =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Transaksi");
            System.out.println("3. Lihat Belanja");
            System.out.println("4. Ubah Password");
            System.out.println("5. Selesai");
            System.out.print("Pilih Menu : ");

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
                    ubahPassword(sc);
                    break;
                case 5:
                    selesaiBelanja();
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (choice != 5);
    }

    public static void tambahBarang(Scanner sc) {

    }

    public static void hapusTransaksi() {

    }

    public static void lihatBelanja() {

    }

    public static void ubahPassword(Scanner sc) {

    }

    public static void selesaiBelanja() {

    }
}