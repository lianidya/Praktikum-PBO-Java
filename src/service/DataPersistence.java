/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import entity.*;
import java.io.*;
import java.util.*;

public class DataPersistence {
    private static final String FILE_ANGGOTA = "data_anggota.dat";
    private static final String FILE_PINJAMAN = "data_peminjaman.dat";
    
    public static void simpanData(List<Anggota> anggotaList, List<Peminjaman> peminjamanList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_ANGGOTA))) {
            oos.writeObject(anggotaList);
            System.out.println("💾 Data anggota berhasil disimpan.");
        } catch (IOException e) {
            System.err.println("❌ Error menyimpan data anggota: " + e.getMessage());
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PINJAMAN))) {
            oos.writeObject(peminjamanList);
            System.out.println("💾 Data peminjaman berhasil disimpan.");
        } catch (IOException e) {
            System.err.println("❌ Error menyimpan data peminjaman: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Anggota> bacaDataAnggota() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_ANGGOTA))) {
            return (List<Anggota>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("⚠️ Data anggota tidak ditemukan atau rusak. Membuat baru.");
            return new ArrayList<>();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Peminjaman> bacaDataPeminjaman() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PINJAMAN))) {
            return (List<Peminjaman>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("⚠️ Data peminjaman tidak ditemukan atau rusak. Membuat baru.");
            return new ArrayList<>();
        }
    }
}