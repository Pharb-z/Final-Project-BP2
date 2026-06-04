package model;

public class Service {

    public String idService;
    public String nameService;
    public double price;
    public String serviceType;

    public Service(String idService, String nameService, double price, String serviceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.price = price;
        this.serviceType = serviceType;
    }

    public double countPriceKG(int quantity) {
        return price * quantity;
    }

    public double countPricePcs(int quantity) {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "[" + idService + "] |" + nameService + "| |" + price +"| |" + serviceType + "|";
    }
}
