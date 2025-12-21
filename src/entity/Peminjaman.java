/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// entity/Peminjaman.java
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Peminjaman implements Serializable {
    private String idAnggota;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private List<AbstractItem> daftarItem; // Komposisi
    
    public Peminjaman(String idAnggota, LocalDate tanggalPinjam, LocalDate tanggalKembali) {
        this.idAnggota = idAnggota;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.daftarItem = new ArrayList<>();
    }
    
    public void tambahItem(AbstractItem item) {
        daftarItem.add(item);
    }
    
    public String getIdAnggota() { return idAnggota; }
    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public LocalDate getTanggalKembali() { return tanggalKembali; }
    public List<AbstractItem> getDaftarItem() { return daftarItem; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Peminjaman oleh: ").append(idAnggota).append("\n");
        sb.append("Tanggal Pinjam: ").append(tanggalPinjam).append("\n");
        sb.append("Tanggal Kembali: ").append(tanggalKembali).append("\n");
        sb.append("Daftar Item:\n");
        for (AbstractItem item : daftarItem) {
            sb.append("  - ").append(item.getJenis()).append(": ").append(item.getJudul()).append("\n");
        }
        return sb.toString();
    }
}