package model;

public class Service {

    public String idService;
    public String nameService;
    public double hargaService;

    public Service(String idService, String nameService, double hargaService) {
        this.idService = idService;
        this.nameService = nameService;
        this.hargaService = hargaService;
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
