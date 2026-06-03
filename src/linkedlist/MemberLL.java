package linkedlist;

import node.*;

public class MemberLL {

    MemberNode tail, head;

    public void addMember(String id, String name, String phone, String address, String password, String membershipLevel) {
        MemberNode newNode = new MemberNode(id, name, phone, address, password, membershipLevel);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void deleteService(String id) {
        MemberNode current = head;
        while (current != null) {
            if (current.id.equals(id)) {
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
        MemberNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }

    public MemberNode verifLogin(String name, String password) {
        MemberNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name) && current.password.equals(password)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

}
