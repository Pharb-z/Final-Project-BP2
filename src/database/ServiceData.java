package database;

import node.*;

public class ServiceData {

    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }

    public static void simpanLayanan(ServiceNode service) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter("service.txt", true);
            fw.write(service.idService + "|" + service.nameService + "|" + service.hargaService + "|" + service.serviceType + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Gagal simpan customer!");
        }
    }
}
