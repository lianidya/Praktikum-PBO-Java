/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistem_Manajemen_Inventori;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProdukInventory implements Serializable { // Saya ganti nama agar tidak bentrok dengan kelas Produk sebelumnya
    private String namaProduk;
    private double harga;
    private int stok;
    public ProdukInventory(String namaProduk, double harga, int stok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + namaProduk + ", Harga: " + harga + ", Stok: " + stok);
    }
    
    // Override toString untuk keperluan penyimpanan File Teks
    @Override
    public String toString() {
        return "Produk{" + "nama='" + namaProduk + '\'' + ", harga=" + harga + ", stok=" + stok + '}';
    }
}
public class InventorySystem {
    private static final String TEXT_FILE = "produk.txt";
    private static final String SERIAL_FILE = "produk.ser";
    private static List<ProdukInventory> produkList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Simpan ke File Teks");
            System.out.println("3. Simpan Objek ke File (Serialisasi)");
            System.out.println("4. Tampilkan Semua Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            switch (pilihan) {
                case 1 -> tambahProduk(scanner);
                case 2 -> simpanKeFileTeks();
                case 3 -> simpanKeFileSerial();
                case 4 -> tampilkanProduk();
                case 5 -> {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void tambahProduk(Scanner scanner) {
        System.out.print("Masukkan nama produk: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        produkList.add(new ProdukInventory(nama, harga, stok));
        System.out.println("Produk berhasil ditambahkan.");
    }
    private static void simpanKeFileTeks() {
        try (FileWriter writer = new FileWriter(TEXT_FILE)) {
            for (ProdukInventory produk : produkList) {
                writer.write(produk.toString() + "\n");
            }
            System.out.println("Data produk berhasil disimpan ke file teks.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file teks.");
            e.printStackTrace();
        }
    }
    private static void simpanKeFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(produkList);
            System.out.println("Objek produk berhasil disimpan ke file serial.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file serial.");
            e.printStackTrace();
        }
    }
    private static void tampilkanProduk() {
        System.out.println("Daftar Produk:");
        for (ProdukInventory produk : produkList) {
            produk.tampilkanInfo();
        }
    }
}
