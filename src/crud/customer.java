package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class customer {
    private String database_name = "muhammad_rifki_hatasa_2210010245";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 

    public customer() {
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
       public void Simpan_Customer(String nama_customer, String alamat_customer, String telepon_customer, String email_customer) {
        if (koneksiDB != null) {
            try {
                String sql = "INSERT INTO customer (nama_customer, alamat_customer, telepon_customer, email_customer) VALUES (?, ?, ?, ?)";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama_customer);
                perintah.setString(2, alamat_customer);
                perintah.setString(3, telepon_customer);
                perintah.setString(4, email_customer);
                perintah.executeUpdate();
                System.out.println("Berhasil Disimpan");
            } catch (SQLException e) {
                System.out.println("Gagal menyimpan: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
    public void Ubah_Customer(String nama_customer, String alamat_customer, String telepon_customer, String email_customer) {
        if (koneksiDB != null) {
            try {
                String sql = "UPDATE customer SET alamat_customer=?, telepon_customer=?, email_customer=? WHERE nama_customer=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, alamat_customer);
                perintah.setString(2, telepon_customer);
                perintah.setString(3, email_customer);
                perintah.setString(4, nama_customer);
                perintah.executeUpdate();
                System.out.println("Berhasil Diubah");
            } catch (SQLException e) {
                System.out.println("Gagal mengubah: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }

    public void Hapus_Customer(String nama_customer) {
        if (koneksiDB != null) {
            try {
                String sql = "DELETE FROM customer WHERE nama_customer=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(sql);
                perintah.setString(1, nama_customer);
                perintah.executeUpdate();
                System.out.println("Berhasil Dihapus");
            } catch (SQLException e) {
                System.out.println("Gagal menghapus: " + e.getMessage());
            }
        } else {
            System.out.println("Koneksi ke database belum diinisialisasi.");
        }
    }
    
        public void GetCustomer(String nama_customer) {
        try{
            String sql ="select * from customer where nama_customer=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama_customer);
            ResultSet data = perintah.executeQuery();
            
            while (data.next()){
                System.out.println("nama : " + data.getString("nama_customer"));
                System.out.println("alamat : " + data.getString("alamat_customer"));
                System.out.println("telp : " + data.getString("telepon_customer"));
                System.out.println("email : " + data.getString("email_customer"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void Getrecord() {
        try {
            String sql = "select * from customer order by nama_customer asc";
            Statement perintah = koneksiDB.createStatement();

            ResultSet data = perintah.executeQuery(sql);

                while(data.next()) {
                    System.out.println(
                    data.getString("nama_customer") + " | " +
                    data.getString("alamat_customer") + " | " +
                    data.getString("telepon_customer") + " | " +
                    data.getString("email_customer")
                    );
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
    
    public int JumlahRecord() {
        int jumlah = 0;
        try {
            String sql = "select * from customer order by nama_customer asc";
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
