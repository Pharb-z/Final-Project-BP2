package main;

import java.util.Scanner;
import linkedlist.*;
import method.*;
import model.*;
import node.*;
import queue.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, byrChoice, srvChoice, memChoice, admChoice, ownChoice;
        String memName, memPassword, byrName, ownName, ownPass;

        // Objek member
        MemberLL membership = new MemberLL();
        membership.addMember("M1", "Rava", "085788812399", "Kalijudan", "123", "Bronze");
        membership.addMember("M2", "Farhan", "081234567890", "Kepuh Kemiri", "123", "Bronze");
        membership.addMember("M3", "Bhinar", "082737762367", "Tambaksari", "123", "Bronze");
        membership.addMember("M4", "Farrel", "082334778343", "Sirapan", "123", "Bronze");

        // Objek layanan
        ServiceLL serviceKiloan = new ServiceLL(); // Object Service Kiloan

        int transactionCounter = 1;

        ServiceLL serviceSatuan = new ServiceLL(); // Object Service Satuan
        // Service Kiloan
        serviceKiloan.addService("SRV1", "Cuci Basah", 4000, "Kiloan");
        serviceKiloan.addService("SRV2", "Cuci Kering", 6000, "Kiloan");
        serviceKiloan.addService("SRV3", "Cuci Kering + Setrika", 7000, "Kiloan");
        serviceKiloan.addService("SRV4", "Setrika", 5000, "Kiloan");
        // Service Satuan
        serviceSatuan.addService("SRV1", "Cuci Kering", 10000, "Satuan");
        serviceSatuan.addService("SRV2", "Cuci Kering + Setrika", 15000, "Satuan");
        serviceSatuan.addService("SRV3", "Setrika", 10000, "Satuan");

        // Objek admin
        Admin admin = new Admin("ADM1", "Radit", "0821923887323", "Sirapan", "admin123");

        // Objek owner
        Owner owner = new Owner("1", "Yuli", "0821398438434", "owner123");

        // Main
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
                // Menu pembeli
                case 1:
                    System.out.println("\n-- Halaman Pembeli --");

                    System.out.print("Nama Pembeli : ");
                    byrName = sc.nextLine();

                    OrderQueue cart = new OrderQueue();

                    System.out.println("Selamat datang, " + byrName + "!");

                    do {
                        System.out.println("\n===== MENU PEMBELI =====");
                        System.out.println("1. Pesan Layanan");
                        System.out.println("2. Hapus Transaksi");
                        System.out.println("3. Lihat Belanja");
                        System.out.println("4. Selesai");
                        System.out.print("Pilih : ");

                        byrChoice = sc.nextInt();
                        sc.nextLine();

                        switch (byrChoice) {
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

                                            System.out.print("Masukkan ID Service (SRV1-4) :");
                                            String idService = sc.nextLine();

                                            ServiceNode service = serviceKiloan.searchService(idService);
                                            if (service != null) {

                                                System.out.print("Masukkan jumlah(Kg): ");
                                                int qty = sc.nextInt();
                                                sc.nextLine();

                                                Order order = new Order(
                                                        "ORD" + transactionCounter,
                                                        byrName,
                                                        service.nameService,
                                                        service.price,
                                                        service.serviceType,
                                                        qty);

                                                QueueNode node = new QueueNode(order);
                                                cart.enqueue(node);
                                                transactionCounter++;

                                                System.out.println("Pesanan berhasil ditambahkan!");
                                            } else {
                                                System.out.println("Service tidak ditemukan!");
                                            }
                                            break;
                                        case 2:
                                            serviceSatuan.displayService();
                                            System.out.print("Masukkan ID Service (SRV1-3) : ");
                                            String idServiceSatuan = sc.nextLine();

                                            ServiceNode serviceSatuanSelected = serviceSatuan
                                                    .searchService(idServiceSatuan);

                                            if (serviceSatuanSelected != null) {

                                                System.out.print("Masukkan jumlah(Item): ");
                                                int qty = sc.nextInt();
                                                sc.nextLine();

                                                Order order = new Order(
                                                        "ORD" + transactionCounter,
                                                        byrName,
                                                        serviceSatuanSelected.nameService,
                                                        serviceSatuanSelected.price,
                                                        serviceSatuanSelected.serviceType,
                                                        qty);

                                                QueueNode node = new QueueNode(order);

                                                cart.enqueue(node);

                                                transactionCounter++;

                                                System.out.println("Pesanan berhasil ditambahkan!");

                                            } else {

                                                System.out.println("Service tidak ditemukan!");

                                            }

                                            break;
                                        case 3:
                                            System.out.println("Kembali ke menu");
                                        default:
                                            System.out.println("Pilihan tidak valid.");
                                    }
                                } while (srvChoice != 3);
                                break;
                            case 2:
                                cart.clearQueue();
                                break;
                            case 3:
                                cart.displayQueue();
                                break;
                            case 4:
                                System.out.println("Transaksi berhasil disimpan.");
                                cart.displayQueue();
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }

                    } while (byrChoice != 4);
                    break;
                // Menu member
                case 2:
                    System.out.println("\n-- Login Member --");

                    System.out.print("Nama : ");
                    memName = sc.nextLine();

                    System.out.print("Password : ");
                    memPassword = sc.nextLine();

                    // cek verifikasi login ke linked list member
                    MemberNode memberLogin = membership.verifLogin(memName, memPassword);
                    if (memberLogin != null) {
                        System.out.println("Login berhasil!\nSelamat datang, " + memName + "!");
                        do {
                            System.out.println("\n===== MENU MEMBER =====");
                            System.out.println("1. Pesan Layanan");
                            System.out.println("2. Hapus Transaksi");
                            System.out.println("3. Lihat Belanja");
                            System.out.println("4. Ubah Password");
                            System.out.println("5. Selesai");
                            System.out.print("Pilih : ");

                            memChoice = sc.nextInt();
                            sc.nextLine();

                            switch (memChoice) {
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

                        } while (memChoice != 5);
                        break;
                    } else {
                        System.out.println("Nama atau password salah!");
                    }
                    break;
                // Menu admin
                case 3:

                    break;
                // Menu owner
                case 4:
                    do {
                        System.out.println("Laundry Bu Yuli (Owner)");
                        System.out.print("Masukkan username : ");
                        ownName = sc.nextLine();
                        System.out.print("Masukkan password : ");
                        ownPass = sc.nextLine();
                    } while (!ownName.equalsIgnoreCase(owner.name) && !ownPass.equals(owner.password));
                    do {
                        System.out.println("Hai " + owner.name + "!");
                        System.out.println("1. Tampilkan Order Penjualan yang sudah diproses");
                        System.out.println("2. Tampilkan Order Penjualan yang belum diproses");
                        System.out.println("3. Tampilkan Layanan");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        ownChoice = sc.nextInt();
                        sc.nextLine();
                        switch (ownChoice) {
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
                    } while (ownChoice != 4);
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
