package method;

import java.util.Scanner;
import linkedlist.*;
import model.*;
import node.*;
import queue.*;

public class MemberMethod {

    public static int tambahBarang(
            Scanner sc,
            ServiceLL serviceKiloan,
            ServiceLL serviceSatuan,
            OrderQueue memberCart,
            String memberName,
            int transactionCounter) {

        int pilih;

        do {

            System.out.println("1. Kiloan");
            System.out.println("2. Satuan");
            System.out.println("3. Kembali");
            System.out.print("Pilih : ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                case 1:

                    serviceKiloan.displayService();

                    System.out.print("Masukkan ID Service (SRV1-4) : ");
                    String idKiloan = sc.nextLine();

                    ServiceNode service1 = serviceKiloan.searchService(idKiloan);

                    if (service1 != null) {

                        System.out.print("Jumlah(Kg) : ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        double diskon = service1.price * 0.05;

                        double hargaAkhir = service1.price - diskon;

                        Order order = new Order(
                                "ORD" + transactionCounter,
                                memberName,
                                service1.nameService,
                                hargaAkhir,
                                service1.serviceType,
                                qty);

                        memberCart.enqueue(
                                new QueueNode(order));

                        transactionCounter++;

                        System.out.println(
                                "Pesanan berhasil ditambah!");
                    }

                    break;

                case 2:

                    serviceSatuan.displayService();

                    System.out.print("Masukkan ID Service (SRV1-3) : ");
                    String idSatuan = sc.nextLine();

                    ServiceNode service2 = serviceSatuan.searchService(idSatuan);

                    if (service2 != null) {

                        System.out.print("Jumlah Item : ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        double diskon = service2.price * 0.05;

                        double hargaAkhir = service2.price - diskon;

                        Order order = new Order(
                                "ORD" + transactionCounter,
                                memberName,
                                service2.nameService,
                                hargaAkhir,
                                service2.serviceType,
                                qty);

                        memberCart.enqueue(
                                new QueueNode(order));

                        transactionCounter++;

                        System.out.println(
                                "Pesanan berhasil ditambah!");
                    }

                    break;
            }

        } while (pilih != 3);

        return transactionCounter;
    }

    public static void hapusTransaksi(
            OrderQueue memberCart) {

        memberCart.clearQueue();
    }

    public static void lihatBelanja(
            OrderQueue memberCart) {

        memberCart.displayQueue();
    }

    public static void konfirmasiBelanja(
            Scanner sc,
            OrderQueue memberCart,
            OrderQueue adminQueue) {

        if (memberCart.isEmpty()) {

            System.out.println(
                    "Belum ada pesanan!");

            return;
        }

        System.out.print(
                "Yakin konfirmasi pesanan? (Y/N): ");

        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {

            memberCart.transferTo(adminQueue);

            System.out.println(
                    "Pesanan berhasil dikirim ke Admin.");

        } else {

            System.out.println(
                    "Konfirmasi dibatalkan.");
        }
    }

    public static void ubahPassword(
            Scanner sc,
            node.MemberNode memberLogin) {

        System.out.print(
                "Masukkan Password Baru : ");

        String passwordBaru = sc.nextLine();

        memberLogin.password = passwordBaru;

        System.out.println(
                "Password berhasil diubah.");
    }
}
