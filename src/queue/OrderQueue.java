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

        System.out.println("\n===== DAFTAR BELANJA =====");

        while (temp != null) {

            System.out.println(
                    temp.order.getId() +
                            " | " +
                            temp.order.getService() +
                            " | Qty : " +
                            temp.order.getQty() +
                            " | Total : Rp" +
                            temp.order.getSubtotal());

            temp = temp.next;
        }

        System.out.println("---------------------");
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

        front = front.next;

        if (front == null) {
            rear = null;
        }

        temp.next = null;

        return temp;
    }
}
