package database;

import linkedlist.*;

public class ServiceData {

    public static void service() {
        ServiceLL serviceKiloan = new ServiceLL(); //Object Service Kiloan
        ServiceLL serviceSatuan = new ServiceLL(); //Object Service Satuan
        //Service Kiloan
        serviceKiloan.addService("SRV1", "Cuci Basah", 4000, "Kiloan");
        serviceKiloan.addService("SRV2", "Cuci Kering", 6000, "Kiloan");
        serviceKiloan.addService("SRV3", "Cuci Kering + Setrika", 7000, "Kiloan");
        serviceKiloan.addService("SRV4", "Setrika", 5000, "Kiloan");
        //Service Satuan
        serviceSatuan.addService("SRV1", "Cuci Kering", 10000, "Satuan");
        serviceSatuan.addService("SRV2", "Cuci Kering + Setrika", 15000, "Satuan");
        serviceSatuan.addService("SRV3", "Setrika", 10000, "Satuan");
    }
}
