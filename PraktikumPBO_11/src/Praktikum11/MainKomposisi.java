/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum11;

/**
 *
 * @author LENOVO
 */
public class MainKomposisi {
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        Buku buku1 = new Buku("Bahasa Inggris Lanjut");
        Buku buku2 = new Buku("Dasar PBO Part 1");
        Buku buku3 = new Buku("Laskar Pelangi");
        Buku buku4 = new Buku("Animal Farm");
        perpustakaan.tambahBuku(buku1);
        perpustakaan.tambahBuku(buku2);
        perpustakaan.tambahBuku(buku3);
        perpustakaan.tambahBuku(buku4);

        System.out.println("Daftar Buku di Perpustakaan:");
        perpustakaan.infoPerpustakaan();
    }
}