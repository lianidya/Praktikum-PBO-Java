/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_10;


public class Main_Tugas {
    public static void main(String[] args) {
        // Membuat objek Elektronik
        Elektronik laptop = new Elektronik("Laptop Asus", 15000000);
        Elektronik smartphone = new Elektronik("Smartphone Samsung", 8500000);
        
        // Membuat objek Makanan
        Makanan roti = new Makanan("Roti Coklat", 25000);
        Makanan susu = new Makanan("Susu Segar", 15000);
        
        // Menghitung pajak menggunakan objek langsung
        System.out.println("===== Menggunakan objek langsung =====");
        System.out.println(laptop.getNamaBarang() + " - Harga: Rp " + laptop.getHarga());
        System.out.println("Pajak: Rp " + laptop.hitungPajak(laptop.getHarga()));
        
        System.out.println("\n" + smartphone.getNamaBarang() + " - Harga: Rp " + smartphone.getHarga());
        System.out.println("Pajak: Rp " + smartphone.hitungPajak(smartphone.getHarga()));
        
        System.out.println("\n" + roti.getNamaBarang() + " - Harga: Rp " + roti.getHarga());
        System.out.println("Pajak: Rp " + roti.hitungPajak(roti.getHarga()));
        
        System.out.println("\n" + susu.getNamaBarang() + " - Harga: Rp " + susu.getHarga());
        System.out.println("Pajak: Rp " + susu.hitungPajak(susu.getHarga()));
        
        // Menghitung pajak menggunakan polimorfisme (tipe interface)
        System.out.println("\n===== Menggunakan polimorfisme (tipe interface) =====");
        Pembayaran pembayaran1 = new Elektronik("Kamera DSLR", 12000000);
        System.out.println("Pajak Kamera DSLR (Harga Rp 12.000.000): Rp " + pembayaran1.hitungPajak(12000000));
        
        Pembayaran pembayaran2 = new Makanan("Mie Instan", 3000);
        System.out.println("Pajak Mie Instan (Harga Rp 3.000): Rp " + pembayaran2.hitungPajak(3000));
    }
}