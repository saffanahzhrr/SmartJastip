package com.mycompany.smartjastip;

public class Photocard extends BarangJastip implements DapatDiinspeksi{
    private String namaMember;
    private String jenisEvent; // Misal: Lucky Draw Soundwave, Fansign, Broadcast

    public Photocard(String kodeBarang, String namaBarang, String namaGrup,
                         double hargaRupiah, int beratGram,
                         String namaMember, String jenisEvent) {
        super(kodeBarang, namaBarang, namaGrup, hargaRupiah, beratGram);
        this.namaMember = namaMember;
        this.jenisEvent = jenisEvent;
    }

    public String getNamaMember() {
        return this.namaMember;
    }

    public void setNamaMember(String namaMember) {
        if (namaMember != null && !namaMember.trim().isEmpty()) {
            this.namaMember = namaMember;
        } else {
            System.out.println("[Peringatan] Nama member tidak boleh kosong!");
        }
    }

    public String getJenisEvent() {
        return this.jenisEvent;
    }

    public void setJenisEvent(String jenisEvent) {
        if (jenisEvent != null && !jenisEvent.trim().isEmpty()) {
            this.jenisEvent = jenisEvent;
        } else {
            System.out.println("[Peringatan] Jenis event tidak boleh kosong!");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("PHOTOCARD: %-10s | Grup: %-10s | Rp%,10.0f | Berat: %4d g | Member: %-11s | Event: %s%n",
                getNamaBarang(), getNamaGrup(), getHargaRupiah(), getBeratGram(), this.namaMember, this.jenisEvent);
    }

    @Override
    public void rincianPengiriman() {
        System.out.println("    Standar Kirim PC: Inner sleeve + hard toploader + yellow board sandwich + bubble mailer (anti tekuk).");
    }
    
    @Override
    public void hitungPajakBeaCukai() {
        System.out.println("    [BEA CUKAI] Kategori Kertas Koleksi: Bea masuk 5% + PPN 11%.");
    }
    
    @Override
    public void inspeksiKondisi() {
        System.out.println("    [INSPEKSI] Pengetesan tombol saklar LED dan fungsi pairing Bluetooth konser.");
    }
}