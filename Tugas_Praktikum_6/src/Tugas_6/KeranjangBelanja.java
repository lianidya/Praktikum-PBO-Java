/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_6;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class KeranjangBelanja {
    private List<Produk> daftarProduk = new ArrayList<>();
    private NumberFormat rupiahFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
        System.out.println("[OK] '" + produk.getNama() + "' ditambahkan ke keranjang.");
    }

    public void tampilkanStrukBelanja() {
        System.out.println("--- Isi Keranjang Belanja ---");
        double total = 0;

        for (Produk p : daftarProduk) {
            double hargaDiskon = p.hitungHargaSetelahDiskon();
            total += hargaDiskon;

            // Mencetak detail per item
            System.out.println("Nama: " + String.format("%-20s", p.getNama()) + 
                               " | Harga Asli: " + rupiahFormatter.format(p.getHarga()) + 
                               " | Harga Diskon: " + rupiahFormatter.format(hargaDiskon));
        }
        
        System.out.println("Total Pembayaran: " + rupiahFormatter.format(total));
    }
    
    public double hitungTotalHarga() {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.hitungHargaSetelahDiskon();
        }
        return total;
    }
}