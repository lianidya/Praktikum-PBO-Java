/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_10;


public class Makanan implements Pembayaran {
    private String namaBarang;
    private double harga;
    
    // Konstruktor
    public Makanan(String namaBarang, double harga) {
        this.namaBarang = namaBarang;
        this.harga = harga;
    }
    
    // Getter
    public String getNamaBarang() {
        return namaBarang;
    }
    
    public double getHarga() {
        return harga;
    }
    
    @Override
    public double hitungPajak(double harga) {
        return harga * 0.05; // Pajak 5%
    }
}
