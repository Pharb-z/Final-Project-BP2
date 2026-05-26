package node;

import model.Member;

public class MemberNode extends Member {

    private MemberNode next, prev;

    public MemberNode(String id, String name, String phone, String address, String password, String membershipLevel) {
        super(id, name, phone, address, password, membershipLevel);
        this.next = null;
        this.prev = null;
    }

    public MemberNode getNext() {
        return next;
    }

    public void setNext(MemberNode next) {
        this.next = next;
    }

    public MemberNode getPrev() {
        return prev;
    }

    public void setPrev(MemberNode prev) {
        this.prev = prev;
    }
}
