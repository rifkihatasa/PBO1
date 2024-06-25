package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class garansi {
    private String database_name = "muhammad_rifki_hatasa_2210010245";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public garansi() {
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

    public void Simpan_Garansi(int pesanan_id, String keterangan) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO garansi (tanggal_garansi, pesanan_id, keterangan) VALUES (CURRENT_DATE, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setInt(1, pesanan_id);
                perintah.setString(2, keterangan);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Ubah_Garansi(int garansi_id, int pesanan_id, String keterangan) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE garansi SET pesanan_id=?, keterangan=? WHERE garansi_id=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setInt(1, garansi_id);
                perintah.setInt(2, pesanan_id);
                perintah.setString(3, keterangan);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_Garansi(int garansi_id) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM garansi WHERE garansi_id=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setInt(1, garansi_id);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
    
        public void GetGaransi(String tanggal_garansi) {
        try{
            String sql ="select * from garansi where tanggal_garansi=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, tanggal_garansi);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()){
                System.out.println("tanggal_garansi : " + data.getString("tanggal_garansi"));
                System.out.println("pesanan_id : " + data.getString("pesanan_id"));
                System.out.println("keterangan : " + data.getString("keterangan"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void Getrecord() {
        try {
            String sql = "select * from garansi order by tanggal_garansi asc";
            Statement perintah = koneksiDB.createStatement();

            ResultSet data = perintah.executeQuery(sql);

                while(data.next()) {
                    System.out.println(
                    data.getString("tanggal_garansi") + " | " +
                    data.getString("pesanan_id") + " | " +
                    data.getString("keterangan")
                    );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    
    public int JumlahRecord() {
        int jumlah = 0;
        try {
            String sql = "select * from garansi order by tanggal_garansi asc";
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
