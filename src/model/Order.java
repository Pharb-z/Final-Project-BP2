package model;

public class Order {

    public String idOrder;
    public String buyer;
    public String service;
    public double price;
    public String type;
    public int qty;
    public int status;

    public Order(String id, String buyer, String service,
            double price, String type, int qty) {

        this.idOrder = id;
        this.buyer = buyer;
        this.service = service;
        this.price = price;
        this.type = type;
        this.qty = qty;
        this.status = 0;
    }

    public String getId() {
        return idOrder;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQty() {
        return qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getSubtotal() {
        return price * qty;
    }
}