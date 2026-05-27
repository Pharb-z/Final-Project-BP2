package model;

public class Service {

    public String idService;
    public String nameService;
    public double hargaService;
    public String serviceType;

    public Service(String idService, String nameService, double hargaService, String serviceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.hargaService = hargaService;
        this.serviceType = serviceType;
    }

    public double countPriceKG(int quantity) {
        return hargaService * quantity;
    }

    public double countPricePcs(int quantity) {
        return hargaService * quantity;
    }

    @Override
    public String toString() {
        return "ID Service: " + idService + ", Name Service: " + nameService + ", Harga Service: " + hargaService;
    }
}
