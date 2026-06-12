package linkedlist;

import model.*;
import node.*;

public class OrderLL {

    OrderNode tail, head;

    public OrderNode getHead() {
        return head;
    }

    public void addOrder(Order order) {
        OrderNode newNode = new OrderNode(order);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void deleteOrder(String orderId) {
        OrderNode current = head;
        while (current != null) {
            if (current.order.getId().equals(orderId)) {
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

    public void displayOrders() {
        OrderNode current = head;
        while (current != null) {
            System.out.println(current.order.toString());
            current = current.getNext();
        }
    }

    public String generateOrderId() {

        if (tail == null) {
            return "ORD001";
        }

        String lastId = tail.order.getId();

        int number = Integer.parseInt(
                lastId.replace("ORD", ""));

        return String.format("ORD%03d", number + 1);
    }

    public void createOrder(
            String buyer,
            String service,
            double price,
            String type,
            int qty) {

        System.out.println("Buyer yang disimpan : " + buyer);

        String id = generateOrderId();

        Order order = new Order(
                id,
                buyer,
                service,
                price,
                type,
                qty);

        addOrder(order);
    }

}
