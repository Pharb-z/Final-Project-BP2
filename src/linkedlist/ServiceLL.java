package linkedlist;

import javax.swing.table.DefaultTableModel;
import node.*;

public class ServiceLL {

    ServiceNode tail, head;

    public ServiceNode getHead() {
        return head;
    }

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

    public ServiceNode searchService(String id) {
        ServiceNode current = head;

        while (current != null) {

            if (current.idService.equalsIgnoreCase(id)) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    public DefaultTableModel getTableModel() {

        String[] kolom = {
            "ID",
            "Layanan",
            "Harga",
            "Tipe"
        };

        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        ServiceNode current = head;

        while (current != null) {

            model.addRow(new Object[]{
                current.idService,
                current.nameService,
                current.price,
                current.serviceType
            });

            current = current.getNext();
        }

        return model;
    }
}
