/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_6;

public class Main {
    public static void main(String[] args) {
        KeranjangBelanja keranjang = new KeranjangBelanja();
        System.out.println("--- Input Produk ---");
        keranjang.tambahProduk(new Buku("Novel Fiksi Ilmiah", 150000));
        keranjang.tambahProduk(new Elektronik("Smartwatch V2", 1200000));
        keranjang.tambahProduk(new Pakaian("Jaket Bomber", 350000));

        System.out.println(); 
        keranjang.tampilkanStrukBelanja();
    }
}