package node;

import model.Admin;

public class AdminNode extends Admin {

    private AdminNode next, prev;

    public AdminNode(String id, String name, String phone, String address, String password) {
        super(id, name, phone, address, password);
        this.next = null;
        this.prev = null;
    }

    public AdminNode getNext() {
        return next;
    }

    public void setNext(AdminNode next) {
        this.next = next;
    }

    public AdminNode getPrev() {
        return prev;
    }

    public void setPrev(AdminNode prev) {
        this.prev = prev;
    }

}
