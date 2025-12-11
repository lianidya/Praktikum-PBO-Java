/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum6;

public class MainOverriding {
    public static void main(String[] args) {
        Hewan hewanPeliharaan = new Kucing(); 
        
        System.out.println("--- Uji Coba Overriding ---");
        System.out.print("Suara Kucing: ");
        hewanPeliharaan.bersuara(); 
        Anjing anjingPeliharaan = new Anjing();
        System.out.print("Suara Anjing: ");
        anjingPeliharaan.bersuara(); 
        
        System.out.print("Aktivitas Anjing: ");
        anjingPeliharaan.makan("Tulang", 1);
    }
}
