/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// entity/Anggota.java
package entity;

import java.io.Serializable;

public class Anggota implements Serializable {
    private String id;
    private String nama;
    private String alamat;
    
    public Anggota(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nama: " + nama + " | Alamat: " + alamat;
    }
}