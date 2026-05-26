package node;

import model.Customer;

public class CustomerNode extends Customer {
    
    private CustomerNode next, prev;

    public CustomerNode(String id, String name, String phone, String address) {
        super(id, name, phone, address);
        this.next = null;
        this.prev = null;
    }

    public CustomerNode getNext() {
        return next;
    }

    public void setNext(CustomerNode next) {
        this.next = next;
    }

    public CustomerNode getPrev() {
        return prev;
    }

    public void setPrev(CustomerNode prev) {
        this.prev = prev;
    }

}
