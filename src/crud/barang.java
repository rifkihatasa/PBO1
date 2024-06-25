package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class barang {
    private String database_name = "muhammad_rifki_hatasa_2210010245";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public barang() {
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
    
public void Simpan_Barang(String nama_harga, String harga, String stok) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO barang (nama_barang, harga, stok) VALUES (?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama_harga);
                perintah.setString(2, harga);
                perintah.setString(3, stok);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Ubah_Barang(String nama_barang, String harga, String stok) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE barang SET harga=?, stok=? WHERE nama_barang=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, harga);
                perintah.setString(2, stok);
                perintah.setString(3, nama_barang);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_Barang(String nama_barang) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM barang WHERE nama_barang=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama_barang);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void GetBarang(String nama_barang) {
        try{
            String sql ="select * from barang where nama_barang=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama_barang);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()){
                System.out.println("nama_barang : " + data.getString("nama_barang"));
                System.out.println("harga : " + data.getString("harga"));
                System.out.println("stok : " + data.getString("stok"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void Getrecord() {
        try {
            String sql = "select * from barang order by harga asc";
            Statement perintah = koneksiDB.createStatement();

            ResultSet data = perintah.executeQuery(sql);

                while(data.next()) {
                    System.out.println(
                    data.getString("nama_barang") + " | " +
                    data.getString("harga") + " | " +
                    data.getString("stok")
                    );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    
    public int JumlahRecord() {
        int jumlah = 0;
        try {
            String sql = "select * from barang order by nama_barang asc";
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

