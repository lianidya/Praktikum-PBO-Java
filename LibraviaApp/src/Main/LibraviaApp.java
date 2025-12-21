/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// LibraviaApp.java
package Main;

import entity.*;
import service.*;
import util.InputValidator;
import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

public class LibraviaApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Anggota> daftarAnggota = new ArrayList<>();
    private static List<Peminjaman> daftarPeminjaman = new ArrayList<>();
    private static PeminjamanService peminjamanService = new PeminjamanService();

    public static void main(String[] args) {
        muatData();
        tampilkanSplashScreen();

        while (true) {
            tampilkanMenuUtama();
            int pilihan = bacaInt("Pilih menu (1-3): ");

            switch (pilihan) {
                case 1:
                    tambahPeminjaman();
                    break;
                case 2:
                    lihatSemuaPeminjaman();
                    break;
                case 3:
                    simpanDanKeluar();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tampilkanSplashScreen() {
        System.out.println("===============================================");
        System.out.println("      LIBRAVIA - PERPUSTAKAAN DIGITAL");
        System.out.println("===============================================");
        System.out.println("   Selamat datang di dunia pengetahuan digital!");
        System.out.println("   Tempat buku dan majalah disimpan secara aman.");
        System.out.println("===============================================");
        System.out.println();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambah Peminjaman Baru");
        System.out.println("2. Lihat Semua Riwayat Peminjaman");
        System.out.println("3. Simpan & Keluar");
        System.out.println("==================");
    }

    private static void tambahPeminjaman() {
        System.out.println("\n--- TAMBAH PEMINJAMAN BARU ---");

        String idAnggota = "";
        do {
            idAnggota = bacaString("ID Anggota: ");
            if (!InputValidator.isValidId(idAnggota)) {
                System.out.println("Error: ID Anggota harus berupa angka.");
            }
        } while (!InputValidator.isValidId(idAnggota));

        LocalDate tanggalPinjam = null;
        do {
            String tglStr = bacaString("Tanggal Pinjam (YYYY-MM-DD): ");
            try {
                tanggalPinjam = InputValidator.parseDate(tglStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (true);

        LocalDate tanggalKembali = null;
        do {
            String tglStr = bacaString("Tanggal Kembali (YYYY-MM-DD): ");
            try {
                tanggalKembali = InputValidator.parseDate(tglStr);
                if (tanggalKembali.isBefore(tanggalPinjam)) {
                    System.out.println("Error: Tanggal kembali tidak boleh sebelum tanggal pinjam.");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (true);

        Peminjaman peminjaman = new Peminjaman(idAnggota, tanggalPinjam, tanggalKembali);

        while (true) {
            System.out.println("\nTambahkan Item (Buku/Majalah)");
            System.out.print("Jenis (b/m): ");
            String jenis = scanner.nextLine().trim().toLowerCase();

            String idItem = bacaString("ID Item: ");
            String judul = bacaString("Judul: ");
            String penulis = bacaString("Penulis: ");

            if ("b".equals(jenis)) {
                int halaman = bacaInt("Jumlah Halaman: ");
                peminjaman.tambahItem(new Buku(idItem, judul, penulis, halaman));
            } else if ("m".equals(jenis)) {
                String edisi = bacaString("Edisi: ");
                peminjaman.tambahItem(new Majalah(idItem, judul, penulis, edisi));
            } else {
                System.out.println("Jenis tidak dikenali. Masukkan 'b' untuk buku atau 'm' untuk majalah.");
                continue;
            }

            System.out.print("Tambah item lagi? (y/n): ");
            if (!"y".equalsIgnoreCase(scanner.nextLine().trim()))
                break;
        }

        peminjamanService.pinjam(peminjaman);
        daftarPeminjaman.add(peminjaman);
        System.out.println("Peminjaman berhasil ditambahkan!");
    }

    private static void lihatSemuaPeminjaman() {
        System.out.println("\n--- RIWAYAT SEMUA PEMINJAMAN ---");
        if (daftarPeminjaman.isEmpty()) {
            System.out.println("Belum ada peminjaman.");
            return;
        }

        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            System.out.println("\n=== PINJAMAN #" + (i + 1) + " ===");
            System.out.println(daftarPeminjaman.get(i));
        }
    }

    private static void simpanDanKeluar() {
        DataPersistence.simpanData(daftarAnggota, daftarPeminjaman);
        System.out.println("\n===============================================");
        System.out.println("   TERIMA KASIH TELAH MENGGUNAKAN LIBRAVIA");
        System.out.println("   Membaca adalah petualangan tanpa batas.");
        System.out.println("   Sampai jumpa di dunia pengetahuan berikutnya!");
        System.out.println("===============================================");
        scanner.close();
    }

    private static void muatData() {
        daftarAnggota = DataPersistence.bacaDataAnggota();
        daftarPeminjaman = DataPersistence.bacaDataPeminjaman();
        System.out.println("Data berhasil dimuat dari file.");
    }

    private static String bacaString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int bacaInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka yang valid.");
            }
        }
    }
}