package node;

import model.*;

public class QueueNode {

    public Order order;
    public QueueNode next;

    public QueueNode(Order order) {
        this.order = order;
        this.next = null;
    }

    @Override
    public String toString() {
        return order.idOrder + " | "
                + order.buyer + " | "
                + order.service + " | Qty: "
                + order.qty + " | Rp"
                + order.getSubtotal()
                + " | Status: "
                + (order.status == 0 ? "Belum Diproses" : "Diproses");
    }
}
