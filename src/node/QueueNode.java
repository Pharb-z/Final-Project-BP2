package node;

import model.*;

public class QueueNode {

    public Order order;
    public QueueNode next;

    public QueueNode(Order order) {
        this.order = order;
        this.next = null;
    }

    public String toString() {
        return order.idOrder + " " + order.buyer + " " + order.service + " " + order.price;
    }
}
