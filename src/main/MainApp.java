package main;

import java.util.Scanner;
import linkedlist.MemberLL;
import method.*;
import node.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, choice2;
        String name, password;
        MemberLL membership = new MemberLL();
        membership.addMember("M1", "Rava", "085788812399", "Kalijudan", "123", "Bronze");
        membership.addMember("M2", "Farhan", "081234567890", "Kepuh Kemiri", "123", "Bronze");
        membership.addMember("M3", "Bhinar", "082737762367", "Tambaksari", "123", "Bronze");
        membership.addMember("M4", "Farrel", "082334778343", "Sirapan", "123", "Bronze");
        do {
            System.out.println("\n=== Laundry Bu Yuli ===");
            System.out.println("1. Member");
            System.out.println("2. Pembeli");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n-- Login Member --");

                    System.out.print("Nama : ");
                    name = sc.nextLine();

                    System.out.print("Password : ");
                    password = sc.nextLine();

                    //cek verifikasi login ke linked list member
                    MemberNode memberLogin = membership.verifLogin(name, password);
                    if (memberLogin != null) {
                        System.out.println("Login berhasil!\nSelamat datang, " + name + "!");
                        do {
                            System.out.println("\n===== MENU MEMBER =====");
                            System.out.println("1. Pesan Layanan");
                            System.out.println("2. Hapus Transaksi");
                            System.out.println("3. Lihat Belanja");
                            System.out.println("4. Ubah Password");
                            System.out.println("5. Selesai");
                            System.out.print("Pilih : ");

                            choice2 = sc.nextInt();
                            sc.nextLine();

                            switch (choice2) {
                                case 1:
                                    MemberMethod.tambahBarang();
                                    break;
                                case 2:
                                    MemberMethod.hapusTransaksi();
                                    break;
                                case 3:
                                    MemberMethod.lihatBelanja();
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    MemberMethod.selesaiBelanja();
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }

                        } while (choice2 != 5);
                        break;
                    } else {
                        System.out.println("Nama atau password salah!");
                    }
                    break;
                case 2:
                    System.out.println("\n-- Halaman Pembeli --");

                    System.out.print("Nama Pembeli : ");
                    name = sc.nextLine();

                    System.out.println("Selamat datang, " + name + "!");

                    do {
                        System.out.println("\n===== MENU PEMBELI =====");
                        System.out.println("1. Tambah Barang");
                        System.out.println("2. Hapus Transaksi");
                        System.out.println("3. Lihat Belanja");
                        System.out.println("4. Selesai");
                        System.out.print("Pilih : ");

                        choice2 = sc.nextInt();
                        sc.nextLine();

                        switch (choice2) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }

                    } while (choice2 != 4);
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
