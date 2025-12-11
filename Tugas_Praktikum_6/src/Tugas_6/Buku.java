/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_6;

public class Buku extends Produk {
    public Buku(String n, double h) { super(n, h); }
    @Override
    public double hitungHargaSetelahDiskon() { return harga - (harga * 0.15); } // Diskon 15%
}
