/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_4;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args){
        Pekerja pekerja1 = new Pekerja("Lia", 20, "Software Engineer", 500000.0);
        System.out.println("Informasi Awal: " + pekerja1.toString());
        pekerja1.setNama("Lia Nidya");
        
        System.out.println("Informasi Setelah Nama Diubah: " + pekerja1.toString());
        System.out.println("\n--- Percobaan Mengakses Atribut Langsung ---");
        
        System.out.println("Akses pekerja1.nama: GAGAL (Atribut 'nama' bersifat private)");
        System.out.println("Akses pekerja1.usia: " + pekerja1.usia);
        System.out.println("Akses pekerja1.gaji: GAGAL (Atribut 'gaji' bersifat private)");
    }
}
