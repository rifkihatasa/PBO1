//package salary;
//
//import Jasa.*;
//import java.util.Scanner;
//
//public class Salary {
//
//    public static void main(String[] args) {
//
//        Pesanan saya = new Pesanan();
//        Scanner input = new Scanner(System.in);
//        Barang barang = new Barang(); // Buat objek Barang
//
//        System.out.print("Masukan Nama Anda : ");
//        saya.inputNama(input.nextLine());
//        System.out.print("Masukan No_Barang : ");
//        String noBarang = input.nextLine();
//        saya.inputNamaBarang(noBarang);
//        saya.namabarang(); // Menentukan nama barang berdasarkan nomor barang
//
//        System.out.print("Masukan Jumlah Barang : ");
//        saya.inputJumlahBarang(input.nextLine());
//
////         Mengurangi stok barang
//        int stok = barang.stokBarang(noBarang); // Dapatkan stok barang
//        if (stok == 0) {
//            System.out.println("Barang tidak terdaftar/Kosong");
//            return;
//        }
//
//        int pembelian = Integer.parseInt(saya.JumlahPesanan());
//        if (pembelian > stok) {
//            System.out.println("=============================");
//            System.out.println("Stok tidak mencukupi, menyesuaikan dengan stok yang ada.");
//            pembelian = stok;
//            saya.inputJumlahBarang(String.valueOf(pembelian)); // Sesuaikan jumlah barang dengan stok yang ada
//        }
//
//        System.out.println("=============================");
//        System.out.println("No_Pesanan    = " + saya.NomorPesanan());
//        System.out.println("Tgl_Pesanan   = " + saya.TanggalPesanan());
//        System.out.println("Nama_Barang   = " + saya.getNamaBarangString());
//
//        // Menghitung total harga berdasarkan harga barang dan jumlah barang
//        int harga = saya.hargaBarang();
//        System.out.println("Harga_Satuan  = Rp" + harga);
//        System.out.println("Jumlah_Dibeli = " + pembelian);
//        System.out.println("Total_Harga   = Rp" + harga * pembelian);
//        System.out.println("=============================");
//        System.out.println("Stok_Awal     = " + stok);
//        System.out.println("Sisa_Stok     = " + (stok - pembelian));
//        System.out.println("=============================");
//    }}
