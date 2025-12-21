/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum_12;
import java.io.Serializable;

public class Buku implements Serializable {
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Method untuk menampilkan info buku
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul + " | Pengarang: " + pengarang + " | Tahun: " + tahunTerbit);
    }

    // Format string untuk penyimpanan Text File
    @Override
    public String toString() {
        return judul + "," + pengarang + "," + tahunTerbit;
    }
}
