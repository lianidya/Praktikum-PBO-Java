/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import entity.Peminjaman;

public interface IPinjamKembali {
    void pinjam(Peminjaman peminjaman);
    void kembalikan(Peminjaman peminjaman);
}
