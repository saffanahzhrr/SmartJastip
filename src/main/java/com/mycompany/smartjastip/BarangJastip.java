package com.mycompany.smartjastip;

public abstract class BarangJastip {
    private String kodeBarang;
    private String namaBarang;
    private String namaGrup;
    private double hargaRupiah;
    private int beratGram;
    
    private static int totalBarangTerdaftar = 0;
    
    public BarangJastip(String kodeBarang, String namaBarang, String namaGrup, double hargaRupiah, int beratGram) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.namaGrup = namaGrup;
        setHargaRupiah(hargaRupiah);
        setBeratGram(beratGram);
        
        totalBarangTerdaftar++;
    }
    
    public static int getTotalBarangTerdaftar() {
        return totalBarangTerdaftar;
    }
    
    public String kodeBarang(String kodeBarang) {
        return this.kodeBarang;
    }
    
    public void setkodeBarang(String kodeBarang) {
        if (kodeBarang != null && !kodeBarang.trim().isEmpty()) {
            this.kodeBarang = kodeBarang;
        } else {
            System.out.println("Peringatan! Kode Barang tidak boleh kosong.");
        }
    }
    
    public String getNamaBarang() {
        return this.namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        if (namaBarang != null && !namaBarang.trim().isEmpty()) {
            this.namaBarang = namaBarang;
        } else {
            System.out.println("Peringatan! Nama barang tidak boleh kosong.");
        }
    }
    
    public String getNamaGrup() {
        return this.namaGrup;
    }
    
    public void setNamaGrup(String namaGrup) {
        if (namaGrup != null && !namaGrup.trim().isEmpty()) {
            this.namaGrup = namaGrup;
        } else {
            System.out.println("Peringatan! Nama grup tidak boleh kosong.");
        }
    }
    
    public double getHargaRupiah() {
        return this.hargaRupiah;
    }
    
    public void setHargaRupiah(double hargaRupiah) {
        if (hargaRupiah > 0) {
            this.hargaRupiah = hargaRupiah;
        } else {
            System.out.println("Peringatan! Harga barang harus bernilai positif. Nilai default Rp 50.000 digunakan.");
            this.hargaRupiah = 50000;
        }
    }
    
    public int getBeratGram() {
        return this.beratGram;
    }
    
    public void setBeratGram(int beratGram) {
        if (beratGram > 0) {
            this.beratGram = beratGram;
        } else {
            System.out.println("Peringatan! Berat barang minimal 10 gram. Nilai default digunakan.");
            this.beratGram = 50;
        }
    }
    
    public void tampilkanInfo() {
        System.out.printf("[%s] %-12s | Grup: %-12s | Harga: Rp%,10.0f | Berat: %4d g%n",
                this.kodeBarang, this.namaBarang, this.namaGrup, this.hargaRupiah, this.beratGram);
    }
    
    public void rincianPengiriman() {
        System.out.println("    Standar Pengiriman: Bubble wrap tebal dan box karton.");
    }
    
    public double hitungTotalBiaya() {
        double feeJastip = 50000;
        return this.hargaRupiah + feeJastip;
    }
    
    public double hitungTotalBiaya(double diskonPersen) {
        double feeJastip = 50000;
        double potongan = this.hargaRupiah * (diskonPersen / 100.0);
        return (this.hargaRupiah - potongan) + feeJastip;
    }
    
    public abstract void hitungPajakBeaCukai();
}
