/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Buku extends AbstractItem {
    private int halaman;
    
    public Buku(String id, String judul, String penulis, int halaman) {
        super(id, judul, penulis);
        this.halaman = halaman;
    }
    
    @Override
    public String getJenis() {
        return "Buku";
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Judul: " + judul + " | Penulis: " + penulis + " | Halaman: " + halaman;
    }
}