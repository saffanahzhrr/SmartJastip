package com.mycompany.smartjastip;

public class Album extends BarangJastip implements DapatDiinspeksi {
    private String versiAlbum;
    private boolean dapatBenefitPo;
    
    public Album(String kodeBarang, String namaBarang, String namaGrup, 
            double hargaRupiah, int beratGram, String versiAlbum, boolean dapatBenefitPo) {
        super (kodeBarang, namaBarang, namaGrup, hargaRupiah, beratGram);
        this.versiAlbum = versiAlbum;
        this.dapatBenefitPo = dapatBenefitPo;
    }
    
    public String getVersiAlbum(){
        return this.versiAlbum;
    }
    
    public void setVersiAlbum(String versiAlbum) {
        if (versiAlbum != null && !versiAlbum.trim().isEmpty()) {
            this.versiAlbum = versiAlbum;
        } else {
            System.out.println("Peringatan! Versi album tidak boleh kosong.");
        }
    }
    
    public boolean isDapatBenefitPo() {
        return this.dapatBenefitPo;
    }
    
    public void setDapatBenefitPo() {
        this.dapatBenefitPo = dapatBenefitPo;
    }
    
    @Override
    public void tampilkanInfo() {
        String statusPob = this.dapatBenefitPo ? "Ya (Inc. POB Web)" : "Tidak (No POB)";
        System.out.printf("ALBUM: %-10s | Grup: %-10s | Rp%,10.0f | Berat: %4d g | Versi: %-12s | POB: %s%n",
                getNamaBarang(), getNamaGrup(), getHargaRupiah(), getBeratGram(), this.versiAlbum, statusPob);
    }
    
    @Override
    public void rincianPengiriman() {
        System.out.println("    Standar Kirim Album: Wajib kardus tebal dan triple bubble wrap agar outbox tidak damage. ");
    }
    
    @Override
    public void hitungPajakBeaCukai() {
        System.out.println("    [BEA CUKAI] Kategori Buku/CD Musik: Bebas bea masuk, dikenakan PPN 11%.");
    }
    
    @Override
    public void inspeksiKondisi() {
        System.out.println("    [INSPEKSI] Cek segel plastik unsealed/sealed dan kelengkapan photocard di dalam album.");
    }
}
