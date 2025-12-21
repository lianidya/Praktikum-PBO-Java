/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import entity.Peminjaman;

public class PeminjamanService implements IPinjamKembali {
    @Override
    public void pinjam(Peminjaman peminjaman) {
        System.out.println("✅ Peminjaman berhasil dicatat:");
        System.out.println(peminjaman);
    }

    @Override
    public void kembalikan(Peminjaman peminjaman) {
        System.out.println("✅ Pengembalian berhasil dicatat:");
        System.out.println(peminjaman);
    }
}