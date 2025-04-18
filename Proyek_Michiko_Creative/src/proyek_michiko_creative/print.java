package proyek_michiko_creative;

import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class print {
    public static void main(String[] args) {
        try {
            // Mencari daftar printer yang tersedia
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService printer = null;

            // Menampilkan daftar printer yang ditemukan
            System.out.println("Daftar Printer yang Terdeteksi:");
            for (PrintService service : services) {
                System.out.println("- " + service.getName());
                if (service.getName().contains("Desktop")) { // Ganti dengan nama printer Anda
                    printer = service;
                }
            }

            if (printer != null) {
                String data = "Laporan Transaksi\n------------------\nTotal: Rp 50.000\nTerima kasih!";
                byte[] bytes = data.getBytes();
                
                DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                Doc doc = new SimpleDoc(bytes, flavor, null);

                DocPrintJob job = printer.createPrintJob();
                job.print(doc, null);
                System.out.println("Laporan berhasil dicetak!");
            } else {
                System.out.println("Printer tidak ditemukan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}