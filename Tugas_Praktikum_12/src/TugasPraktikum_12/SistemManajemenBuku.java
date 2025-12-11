/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum_12;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemManajemenBuku {
    private static final String TEXT_FILE = "buku.txt";
    private static final String SERIAL_FILE = "buku.ser";
    private static List<Buku> daftarBuku = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Simpan ke File Teks (buku.txt)");
            System.out.println("3. Simpan Objek ke File Serial (buku.ser)");
            System.out.println("4. Tampilkan Daftar Buku (dari Memory)");
            System.out.println("5. Tampilkan Isi File buku.txt (Baca File I/O)");
            System.out.println("6. Tampilkan Isi File buku.ser (Deserialisasi)");
            System.out.println("7. Keluar");
            System.out.print("Pilihan: ");
            
            int pilihan = 0;
            try {
                 pilihan = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input harus angka!");
                scanner.nextLine(); // clear buffer
                continue;
            }
            
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> simpanKeFileTeks();
                case 3 -> simpanKeFileSerial();
                case 4 -> tampilkanDariMemory();
                case 5 -> bacaDariFileTeks();
                case 6 -> bacaDariFileSerial();
                case 7 -> {
                    System.out.println("Terima kasih. Keluar program.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // Fitur 1: Tambah Buku
    private static void tambahBuku() {
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit: ");
        int tahun = scanner.nextInt();
        
        // Karena class Buku ada di package yang sama, kita bisa langsung pakai
        daftarBuku.add(new Buku(judul, pengarang, tahun));
        System.out.println("Buku berhasil ditambahkan ke daftar sementara.");
    }

    // Fitur 2: Simpan Text
    private static void simpanKeFileTeks() {
        try (FileWriter writer = new FileWriter(TEXT_FILE)) {
            for (Buku b : daftarBuku) {
                writer.write(b.toString() + "\n");
            }
            System.out.println("Daftar buku berhasil disimpan ke " + TEXT_FILE);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file teks.");
            e.printStackTrace();
        }
    }

    // Fitur 3: Simpan Serial
    private static void simpanKeFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(daftarBuku);
            System.out.println("Objek daftar buku berhasil diserialisasi ke " + SERIAL_FILE);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file serial.");
            e.printStackTrace();
        }
    }

    // Fitur 4: Tampil Memory
    private static void tampilkanDariMemory() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            System.out.println("--- Buku di Memory ---");
            for (Buku b : daftarBuku) {
                b.tampilkanInfo();
            }
        }
    }

    // Fitur 5: Membaca file txt
    private static void bacaDariFileTeks() {
        System.out.println("--- Membaca dari " + TEXT_FILE + " ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File tidak ditemukan atau gagal dibaca.");
        }
    }

    // Fitur 6: Membaca file ser
    @SuppressWarnings("unchecked")
    private static void bacaDariFileSerial() {
        System.out.println("--- Membaca dari " + SERIAL_FILE + " ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            List<Buku> bukuDariFile = (List<Buku>) ois.readObject();
            for (Buku b : bukuDariFile) {
                b.tampilkanInfo();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal membaca file serial (mungkin file belum ada).");
        }
    }
}