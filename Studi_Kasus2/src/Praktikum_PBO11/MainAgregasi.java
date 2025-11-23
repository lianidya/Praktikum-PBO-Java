/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum_PBO11;

/**
 *
 * @author LENOVO
 */

public class MainAgregasi {
    public static void main(String[] args) {
        Klub klub = new Klub("Klub Olahraga");
        Anggota anggota1 = new Anggota("Aulia");
        Anggota anggota2 = new Anggota("Nadine");
        klub.tambahAnggota(anggota1);
        klub.tambahAnggota(anggota2);

        klub.infoKlub();
    }
}
