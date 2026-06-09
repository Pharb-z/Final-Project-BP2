package queue;

import node.*;

public class OrderQueue {

    QueueNode front, rear;
    int count;
    double total;

    public OrderQueue() {

    }

    public boolean isEmpty() {
        return front == null;
    }

    public double getTotal() {
        return total;
    }

    public void enqueue(QueueNode OrderNode) {
        if (rear == null) {
            front = rear = OrderNode;
        } else {
            rear.next = OrderNode;
            rear = OrderNode;
        }
        total = total + (OrderNode.order.price * OrderNode.order.qty);
        // total = total + (OrderNode.order.price * OrderNode.order.qty);
    }

    public void dequeue() {
        QueueNode t = front;
        if (t == null) {
            System.out.println("Antrian kosong!");
        } else if (t.next == null) {
            front = rear = null;
        } else {
            front = front.next;
            t.next = null;
        }
        System.out.println(t);
        if (t == null) {
            System.out.println("Antrian kosong!");
        } else {

            System.out.println(t.order.service + " out...");
        }
    }

    public void displayQueue() {

        if (front == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        QueueNode temp = front;

        String currentBuyer = "";
        double totalBuyer = 0;

        System.out.println("\n===== DAFTAR TRANSAKSI =====");

        while (temp != null) {

            if (!temp.order.buyer.equals(currentBuyer)) {

                if (!currentBuyer.equals("")) {
                    System.out.println(
                            "Total " + currentBuyer +
                                    " : Rp" + totalBuyer);
                    System.out.println("-----------------------");
                }

                currentBuyer = temp.order.buyer;
                totalBuyer = 0;

                System.out.println(
                        "\nPembeli : " + currentBuyer);
            }

            System.out.println(
                    temp.order.idOrder
                            + " | "
                            + temp.order.service
                            + " | Qty : "
                            + temp.order.qty
                            + " | Rp"
                            + temp.order.getSubtotal());

            totalBuyer += temp.order.getSubtotal();

            temp = temp.next;
        }

        System.out.println(
                "Total Customer " + currentBuyer +
                        " : Rp" + totalBuyer);

        System.out.println("=======================");
        System.out.println("Grand Total : Rp" + total);
    }

    public void displayQueueWithoutTitle() {

        if (front == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        QueueNode temp = front;

        while (temp != null) {

            System.out.println(
                    temp.order.idOrder
                            + " | "
                            + temp.order.buyer
                            + " | "
                            + temp.order.service
                            + " | Qty : "
                            + temp.order.qty
                            + " | Rp"
                            + temp.order.getSubtotal());

            temp = temp.next;
        }

        System.out.println("Grand Total : Rp" + total);
    }

    public void clearQueue() {

        front = null;
        rear = null;
        total = 0;

        System.out.println("Transaksi berhasil dihapus.");
    }

    public QueueNode getFront() {
        return front;
    }

    public void transferTo(OrderQueue target) {

        QueueNode temp = front;

        while (temp != null) {

            QueueNode newNode = new QueueNode(temp.order);

            target.enqueue(newNode);

            temp = temp.next;
        }

        clearQueue();
    }

    public QueueNode dequeueReturn() {

        if (front == null) {
            return null;
        }

        QueueNode temp = front;

        total -= temp.order.getSubtotal();

        front = front.next;

        if (front == null) {
            rear = null;
        }

        temp.next = null;

        return temp;
    }
}
