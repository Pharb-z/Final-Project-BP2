package node;

import model.*;

public class OrderNode {

    public Order order;
    public OrderNode next, prev;

    public OrderNode(Order order) {
        this.order = order;
        this.next = null;
        this.prev = null;
    }

    public OrderNode getNext() {
        return next;
    }

    public void setNext(OrderNode next) {
        this.next = next;
    }

    public OrderNode getPrev() {
        return prev;
    }

    public void setPrev(OrderNode prev) {
        this.prev = prev;
    }
}
