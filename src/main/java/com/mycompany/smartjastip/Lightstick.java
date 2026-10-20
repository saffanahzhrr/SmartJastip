package com.mycompany.smartjastip;

public class Lightstick extends BarangJastip implements DapatDiinspeksi, DapatDiasuransikan {
    private String versiGenerasi;
    private boolean adaFiturBluetooth; // Fitur sinkronisasi konser via Bluetooth

    public Lightstick(String kodeBarang, String namaBarang, String namaGrup,
                          double hargaRupiah, int beratGram,
                          String versiGenerasi, boolean adaFiturBluetooth) {
        super(kodeBarang, namaBarang, namaGrup, hargaRupiah, beratGram);
        this.versiGenerasi = versiGenerasi;
        this.adaFiturBluetooth = adaFiturBluetooth;
    }

    public String getVersiGenerasi() {
        return this.versiGenerasi;
    }

    public void setVersiGenerasi(String versiGenerasi) {
        if (versiGenerasi != null && !versiGenerasi.trim().isEmpty()) {
            this.versiGenerasi = versiGenerasi;
        } else {
            System.out.println("[Peringatan] Versi generasi lightstick tidak boleh kosong!");
        }
    }

    public boolean isAdaFiturBluetooth() {
        return this.adaFiturBluetooth;
    }

    public void setAdaFiturBluetooth(boolean adaFiturBluetooth) {
        this.adaFiturBluetooth = adaFiturBluetooth;
    }

    @Override
    public void tampilkanInfo() {
        String statusBt = this.adaFiturBluetooth ? "Support Bluetooth (Konser Sync)" : "Manual Mode Saja";
        System.out.printf("LIGHTSTICK: %-10s | Grup: %-10s | Rp%,10.0f | Berat: %4d g | Gen: %-14s | Mode: %s%n",
                getNamaBarang(), getNamaGrup(), getHargaRupiah(), getBeratGram(), this.versiGenerasi, statusBt);
    }

    @Override
    public void rincianPengiriman() {
        System.out.println("    Standar Kirim Lightstick: Baterai dilepas sesuai regulasi kargo udara bandara Incheon. Hardbox + stiker Fragile.");
    }
    
    @Override
    public void hitungPajakBeaCukai() {
        System.out.println("    [BEA CUKAI] Kategori Barang Elektronik: Bea masuk 10% + PPN 11%.");
    }
    
    @Override
    public void inspeksiKondisi() {
        System.out.println("    [INSPEKSI] Pengetesan tombol saklar LED dan fungsi pairing Bluetooth konser.");
    }
    
    @Override
    public void klaimGaransi() {
        System.out.println("    [ASURANSI] Garansi proteksi unit elektronik: Penggantian unit jika lampu mati saat unboxing.");
    }
}
