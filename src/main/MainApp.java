package main;

import java.util.Scanner;
import linkedlist.MemberLL;
import linkedlist.ServiceLL;
import method.MemberMethod;
import node.MemberNode;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, choice2, srvChoice;
        String name, password;
        //Objek member
        MemberLL membership = new MemberLL();
        membership.addMember("M1", "Rava", "085788812399", "Kalijudan", "123", "Bronze");
        membership.addMember("M2", "Farhan", "081234567890", "Kepuh Kemiri", "123", "Bronze");
        membership.addMember("M3", "Bhinar", "082737762367", "Tambaksari", "123", "Bronze");
        membership.addMember("M4", "Farrel", "082334778343", "Sirapan", "123", "Bronze");
        //Objek layanan
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
        //Main
        do {
            System.out.println("\n=== Laundry Bu Yuli ===");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Owner");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                //Menu pembeli
                case 1:
                    System.out.println("\n-- Halaman Pembeli --");

                    System.out.print("Nama Pembeli : ");
                    name = sc.nextLine();

                    System.out.println("Selamat datang, " + name + "!");

                    do {
                        System.out.println("\n===== MENU PEMBELI =====");
                        System.out.println("1. Pesan Layanan");
                        System.out.println("2. Hapus Transaksi");
                        System.out.println("3. Lihat Belanja");
                        System.out.println("4. Selesai");
                        System.out.print("Pilih : ");

                        choice2 = sc.nextInt();
                        sc.nextLine();

                        switch (choice2) {
                            case 1:
                                do {
                                    System.out.println("Pilih layanan");
                                    System.out.println("1. Kiloan \n2. Satuan \n3. Kembali");
                                    System.out.print("Pilih: ");
                                    srvChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (srvChoice) {
                                        case 1:
                                            serviceKiloan.displayService();
                                            break;
                                        case 2:
                                            serviceSatuan.displayService();
                                            break;
                                        case 3:
                                            System.out.println("Kembali ke menu");
                                        default:
                                            System.out.println("Pilihan tidak valid.");
                                    }
                                } while (srvChoice != 3);
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
                //Menu member
                case 2:
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
                //Menu admin
                case 3:

                    break;
                //Menu owner
                case 4:

                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 5);

        sc.close();
    }
}
