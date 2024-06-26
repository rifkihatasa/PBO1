package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class pesanan {
    private String database_name = "muhammad_rifki_hatasa_2210010245";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public pesanan() {
        try {
            String lokasi = "jdbc:mysql://localhost:3306/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }

    public void Simpan_Pesanan(String nomor_pesanan, int jumlah_pesanan, int barang_id, int customer_id) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO pesanan (nomor_pesanan, tanggal_pesanan, jumlah_pesanan, barang_id, customer_id) VALUES (?, CURRENT_DATE, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nomor_pesanan);
                perintah.setInt(2, jumlah_pesanan);
                perintah.setInt(3, barang_id);
                perintah.setInt(4, customer_id);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Ubah_Pesanan(int pesanan_id, String nomor_pesanan, int jumlah_pesanan, int barang_id, int customer_id) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE pesanan SET nomor_pesanan=?, jumlah_pesanan=?, barang_id=?, customer_id=? WHERE pesanan_id=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nomor_pesanan);
                perintah.setInt(2, jumlah_pesanan);
                perintah.setInt(3, barang_id);
                perintah.setInt(4, customer_id);
                perintah.setInt(5, pesanan_id);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_Pesanan(int nomor_pesanan) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM pesanan WHERE nomor_pesanan=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setInt(1, nomor_pesanan);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
    
       public void GetPesanan(String nomor_pesanan) {
        try{
            String sql ="select * from pesanan where nomor_pesanan=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nomor_pesanan);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()){
                System.out.println("nomor : " + data.getString("nomor_pesanan"));
                System.out.println("tanggal : " + data.getString("tanggal_pesanan"));
                System.out.println("jumlah : " + data.getString("jumlah_pesanan"));
                System.out.println("barang : " + data.getString("barang_id"));
                System.out.println("customer : " + data.getString("customer_id"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void Getrecord() {
        try {
            String sql = "select * from pesanan order by nomor_pesanan asc";
            Statement perintah = koneksiDB.createStatement();

            ResultSet data = perintah.executeQuery(sql);

                while(data.next()) {
                    System.out.println(
                    data.getString("nomor_pesanan") + " | " +
                    data.getString("tanggal_pesanan") + " | " +
                    data.getString("jumlah_pesanan") + " | " +
                    data.getString("barang_id") + " | " +
                    data.getString("customer_id")
                    );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    
    public int JumlahRecord() {
        int jumlah = 0;
        try {
            String sql = "select * from pesanan order by nomor_pesanan asc";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()) {
                jumlah = jumlah + 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     return jumlah;
    }

    }
