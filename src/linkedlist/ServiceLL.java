package linkedlist;

import node.*;

public class ServiceLL {

    ServiceNode tail, head;

    public void addService(String id, String name, double price, String type) {
        ServiceNode newNode = new ServiceNode(id, name, price, type);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void deleteService(String id) {
        ServiceNode current = head;
        while (current != null) {
            if (current.idService.equals(id)) {
                if (current == head) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                } else if (current == tail) {
                    tail = current.getPrev();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }

    public void displayService() {
        ServiceNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
