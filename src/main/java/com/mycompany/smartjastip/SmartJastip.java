package com.mycompany.smartjastip;
import java.util.Scanner;

public class SmartJastip {
    
    public static void cariBarang(String kataKunci, BarangJastip[] daftar, int jumlah) {
        System.out.println("\n[Hasil Pencarian] Kata Kunci (Teks): \"" + kataKunci + "\"");
        System.out.println("------------------------------------------------------------");
        boolean ditemukan = false;
        
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNamaBarang().toLowerCase().contains(kataKunci.toLowerCase()));
            if (daftar[i].getNamaGrup().toLowerCase().contains(kataKunci.toLowerCase())) {
                
                System.out.printf("%d. ", (i + 1));
                daftar[i].tampilkanInfo();
                daftar[i].rincianPengiriman();
                System.out.printf("   Biaya Standar Jastip: Rp%,.0f | Promo Diskon 10%%: Rp%,.0f%n%n",
                        daftar[i].hitungTotalBiaya(), daftar[i].hitungTotalBiaya(10.0));
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("(!) Tidak ada barang jastip yang cocok dengan kata kunci: " + kataKunci);
        }
    }
    
    public static void cariBarang(double budgetMaksimal, BarangJastip[]daftar, int jumlah) {
        System.out.printf("%n[Hasil Pencarian] Filter Budget Maksimal: <= Rp%,.0f%n", budgetMaksimal);
        System.out.println("-----------------------------------------------------------------------");
        boolean ditemukan = false;
        
        for (int i = 0 ; i < jumlah; i++) {
            if (daftar[i].getHargaRupiah() <= budgetMaksimal) {
                System.out.printf("%d. ", (i + 1));
                daftar[i].tampilkanInfo();
                daftar[i].rincianPengiriman();
                System.out.printf(" Biaya Standar Jastip: Rp%,.0f%n%n", daftar[i].hitungTotalBiaya());
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.printf("(!) Tidak ada barang jastip dengan harga di bawah Rp%,.0f%n", budgetMaksimal);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        
            BarangJastip[] daftarBarang = new BarangJastip[50];
            int jumlahBarang = 0;
        
            daftarBarang[jumlahBarang++] = new Album("ALB-01", "New Wave", "TREASURE", 285000, 650, "Ice Ver.", true);
            daftarBarang[jumlahBarang++] = new Album("ALB-02", "Choom", "BABYMONSTER", 240000, 420, "Metallic Ver.", true);
            daftarBarang[jumlahBarang++] = new Lightstick("LS-01", "Teulight", "TREASURE", 850000, 480, "Ver 2", true);
            daftarBarang[jumlahBarang++] = new Lightstick("LS-02", "Bbyongbong", "BLACKPINK", 990000, 390, "Special Edition", true);
            daftarBarang[jumlahBarang++] = new Photocard("PC-01", "Choom", "BABYMONSTER", 175000, 25, "Ahyeon", "Plushie Keyring Ver.");
        
            boolean isRunning = true;
        
            System.out.println("================================================================");
            System.out.println("   SELAMAT DATANG DI SISTEM JASTIP K-POP MERCH (SOUL TO INDO)   ");
            System.out.println("================================================================");
            
            while (isRunning) {
                System.out.println("\n>>> MENU UTAMA APLIKASI SMARTJASTIP <<<");
                System.out.println("1. Tambah Data Barang (Album / Lighstick / Photocard)");
                System.out.println("2. Tampilkan Daftar Barang ");
                System.out.println("3. Cari Barang ");
                System.out.println("4. Keluar dari Program");
                System.out.print("Pilih opsi menu (1-4): ");
                
                int pilihan;
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Error! Input harus berupa angka. Silahkan coba lagi.");
                    scanner.nextLine();
                    continue;
                }
                
                switch (pilihan) {
                    case 1 -> {
                        if (jumlahBarang >= daftarBarang.length) {
                            System.out.println("Peringatan! Kapasitas kuota sudah penuh!");
                            break;
                        }
                        
                        System.out.println("\n--- Pilih Kategori Barang ---");
                        System.out.println("1. Album");
                        System.out.println("2. Official Lighstick");
                        System.out.println("3. Photocard");
                        System.out.print("Masukkan Pilihan Anda (1/2/3): ");
                        
                        int tipeSubclass = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Masukkan Kode Barang (AL-03 / LS-03 / PC-02): ");
                        String kode = scanner.nextLine();
                        
                        System.out.print("Masukkan Nama Album / Lighstick / Photocard: ");
                        String nama = scanner.nextLine();
                        
                        System.out.print("Masukkan Nama Grup/Member: ");
                        String grup = scanner.nextLine();
                        
                        System.out.print("Masukkan Harga Barang (Rp): ");
                        double harga = scanner.nextInt();
                        
                        System.out.print("Masukkan Estimasi Berat (Gram): ");
                        int berat = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (tipeSubclass == 1) {
                            System.out.print("Masukkan Versi Album (Standar / Limited): ");
                            String versi = scanner.nextLine();
                            
                            System.out.print("Dengan benefit Pre-Order / POB? (y/n): ");
                            String pobInput = scanner.nextLine();
                            boolean adaPob = pobInput.equalsIgnoreCase("y");
                            
                            daftarBarang[jumlahBarang] = new Album(kode, nama, grup, harga, berat, versi, adaPob);
                            jumlahBarang++;
                            System.out.println("Sukses! Album berhasil ditambahkan ke dalam keranjang.");
                        }
                        else if (tipeSubclass == 2) {
                            System.out.print("Masukkan Versi Lighstick (Ver 1 / Ver 2/ Limitied Edition): ");
                            String versiGen = scanner.nextLine();
                            
                            System.out.print("Apakah memiliki fitur Bluetooth Sync Konser? (y/n): ");
                            String btInput = scanner.nextLine();
                            boolean adaBt = btInput.equalsIgnoreCase("y");
                            
                            daftarBarang[jumlahBarang] = new Lightstick(kode, nama, grup, harga, berat, versiGen, adaBt);
                            jumlahBarang++;
                            System.out.println("Sukses! Lighstick berhasil ditambahkan ke dalam keranjang.");
                        }
                        else if (tipeSubclass == 3) {
                            System.out.print("Masukkan Nama Member: ");
                            String member = scanner.nextLine();
                            
                            System.out.print("Masukkan Jenis Event: ");
                            String event = scanner.nextLine();
                            
                            daftarBarang[jumlahBarang] = new Photocard(kode, nama, grup, harga, berat, member, event);
                            jumlahBarang++;
                            System.out.println("Sukses! Photocard berhasil ditambahkan ke dalam keranjang.");
                        }
                        else {
                            System.out.println("Gagal! Pilihan kategori barang tidak valid.");
                        }
                        System.out.print("\nTekan enter untuk kembali ke Menu Utama...");
                        scanner.nextLine();
                    }
                    
                    case 2 -> {
                        System.out.println("======================================");
                        System.out.println("  DAFTAR BARANG JASTIP YANG TERSEDIA   ");
                        System.out.println("=======================================");
                        
                        if (jumlahBarang == 0) {
                            System.out.println("Belum ada barang yang tersedia.");
                        } else {
                            for (int i = 0; i < jumlahBarang; i++) {
                                System.out.printf("%2d. ", (i + 1));
                                
                                daftarBarang[i].tampilkanInfo();
                                daftarBarang[i].rincianPengiriman();
                                System.out.printf("    Total Estimasi Biaya (Harga + Fee Jastip Rp.50.000): Rp%,.0f%n%n",
                                        daftarBarang[i].hitungTotalBiaya());
                            }
                            
                            System.out.println("    Total Keseluruhan Objek Barang Tersedia: " + BarangJastip.getTotalBarangTerdaftar() + "unit.");
                        }
                        
                        System.out.println("    Tekan Enter untuk kembali ke Menu Utama...");
                        scanner.nextLine();
                    }
                    
                    case 3 -> {
                        System.out.println("\n--- Fitur Cari Barang jastip ---");
                        System.out.println("1. Cari Berdasarkan Nama Barang / Grup: ");
                        System.out.println("2. Cari Berdasarkan Batas Maksimal Budget: ");
                        System.out.print("Masukkan Pilihan Anda (1/2): ");
                        
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (modeCari == 1) {
                            System.out.print("Masukkan kata kunci nama barang atau nama grup: ");
                            String kataKunci = scanner.nextLine();
                            
                            cariBarang(kataKunci, daftarBarang, jumlahBarang);
                        }
                        else if (modeCari == 2) {
                            System.out.print("Masukkan batas budget maksimal Anda (Rp): ");
                            double maxBudget = scanner.nextDouble();
                            scanner.nextLine();
                            
                            cariBarang(maxBudget, daftarBarang, jumlahBarang);   
                        }
                        else {
                            System.out.println("Peringatan! PIlihan metode pencarian tidak valid.");
                        }
                        
                        System.out.println("Tekan Enter untuk kembali ke Menu Utama...");
                        scanner.nextLine();
                    }
                    
                    case 4 -> {
                        System.out.println("=====================================================================");
                        System.out.println("   TERIMA KASIH TELAH MENGGUNAKAN SMART JASTIP! SAMPAI JUMPA LAGI!   ");
                        System.out.println("=====================================================================");
                    }
                    
                    default -> {
                        System.out.println("Peringatan! Opsi tidak valid! Masukkan angaka 1-4.");
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
