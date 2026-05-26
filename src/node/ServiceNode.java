package node;

import model.Service;

public class ServiceNode extends Service {

    private ServiceNode next, prev;

    public ServiceNode(String idService, String nameService, double price) {
        super(idService, nameService, price);
        this.next = null;
        this.prev = null;
    }

    public ServiceNode getNext() {
        return next;
    }

    public void setNext(ServiceNode next) {
        this.next = next;
    }

    public ServiceNode getPrev() {
        return prev;
    }

    public void setPrev(ServiceNode prev) {
        this.prev = prev;
    }

}
