package Jasa;

public class Barang {

    String nama, harga, stok;
    int namaBarang, hargaBarang, stokBarang;

    public Barang() {}

    public void inputNamaBarang(String nama) {
        this.nama = nama;
    }

    public int namabarang() {
        this.namaBarang = 0;
        if (this.nama.equals("1")) {
            this.namaBarang = 1; // 1 mewakili SAMSUNG A15S
        } else if (this.nama.equals("2")) {
            this.namaBarang = 2; // 2 mewakili SAMSUNG A54 5G
        } else if (this.nama.equals("3")) {
            this.namaBarang = 3; // 3 mewakili INFINIX NOTE40
        } else if (this.nama.equals("4")) {
            this.namaBarang = 4; // 4 mewakili REALME C65
        }
        return this.namaBarang;
    }

    public void hargabarang(String harga) {
        this.harga = harga;
    }

    public int hargaBarang() {
        this.hargaBarang = 0;
        if (this.nama.equals("1")) {
            this.hargaBarang = 3000000;
        } else if (this.nama.equals("2")) {
            this.hargaBarang = 5000000;
        } else if (this.nama.equals("3")) {
            this.hargaBarang = 2700000;
        } else if (this.nama.equals("4")) {
            this.hargaBarang = 2300000;
        }
        return this.hargaBarang;
    }

    public void stokbarang(String stok) {
        this.stok = stok;
    }

    // Mengambil stok barang berdasarkan nomor barang
    public int stokBarang(String nomorBarang) {
        if (nomorBarang.equals("1")) {
            return 100;
        } else if (nomorBarang.equals("2")) {
            return 50;
        } else if (nomorBarang.equals("3")) {
            return 60;
        } else if (nomorBarang.equals("4")) {
            return 40;
        } else {
            return 0; // Barang tidak terdaftar
        }
    }

    public String getNamaBarangString() {
        switch (this.namaBarang) {
            case 1:
                return "SAMSUNG A15S";
            case 2:
                return "SAMSUNG A54 5G";
            case 3:
                return "INFINIX NOTE40";
            case 4:
                return "REALME C65";
            default:
                return "Unknown";
        }
    }
}
