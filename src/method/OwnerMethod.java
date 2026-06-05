package method;

import queue.*;

public class OwnerMethod {

    public static void lihatSudahDiproses(
            OrderQueue processedQueue) {

        System.out.println(
                "\n===== ORDER SUDAH DIPROSES =====");

        processedQueue.displayQueueWithoutTitle();

        System.out.println(
                "Total Penjualan : Rp"
                        + processedQueue.getTotal());
    }

    public static void lihatBelumDiproses(
            OrderQueue adminQueue) {

        System.out.println(
                "\n===== ORDER BELUM DIPROSES =====");

        adminQueue.displayQueueWithoutTitle();

        System.out.println(
                "Total Penjualan : Rp"
                        + adminQueue.getTotal());
    }
}