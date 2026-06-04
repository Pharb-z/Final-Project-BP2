package method;

import node.*;
import queue.*;

public class AdminMethod {

    public static void lihatTransaksi(OrderQueue adminQueue){

        adminQueue.displayQueue();

    }

    public static void prosesTransaksi(
            OrderQueue adminQueue,
            OrderQueue processedQueue){

        if(adminQueue.isEmpty()){

            System.out.println(
                    "Tidak ada transaksi.");

            return;
        }

        QueueNode orderNode =
                adminQueue.dequeueReturn();

        orderNode.order.setStatus(1);

        processedQueue.enqueue(orderNode);

        System.out.println(
                "Transaksi "
                + orderNode.order.getId()
                + " berhasil diproses.");
    }
}