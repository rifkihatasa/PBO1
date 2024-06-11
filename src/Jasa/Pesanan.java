package Jasa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pesanan extends Barang {

    String nomor, tanggal, jumlah, barang, customer;

    public Pesanan() {}

    public Pesanan(String nomor, String tanggal, String jumlah, String barang) {
        this.nomor = nomor;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.barang = barang;
    }

    public void inputNomor(String nomor) {
        this.nomor = nomor;
    }

    public String NomorPesanan() {
        return "ORD" + (int)(Math.random() * 100000);
    }

    public void inputTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String TanggalPesanan() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    public void inputJumlahBarang(String jumlah) {
        this.jumlah = jumlah;
    }

    public String JumlahPesanan() {
        return this.jumlah;
    }

    public void inputNoBarang(String barang) {
        this.barang = barang;
    }

    public String Barang() {
        return this.barang;
    }

    public void inputNama(String customer) {
        this.customer = customer;
    }

    public String Nama() {
        return this.customer;
    }
}
