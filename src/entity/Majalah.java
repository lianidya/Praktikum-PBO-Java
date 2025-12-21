/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

public class Majalah extends AbstractItem {
    private String edisi;
    
    public Majalah(String id, String judul, String penulis, String edisi) {
        super(id, judul, penulis);
        this.edisi = edisi;
    }
    
    @Override
    public String getJenis() {
        return "Majalah";
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Judul: " + judul + " | Penulis: " + penulis + " | Edisi: " + edisi;
    }
}