/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import model.HoaDonDomain;
import java.sql.Connection;

public class HoaDonRepository implements HoaDonRepo {

    @Override
    public List<HoaDonDomain> getall() {
        ArrayList<HoaDonDomain> hd = new ArrayList<>();
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = "SELECT\n"
                    + "HOA_DON.ID,\n"
                    + "HOA_DON.MA,\n"
                    + "HOA_DON.ID_NV,\n"
                    + "HOA_DON.ID_KH,\n"
                    + "HOA_DON.MAPGG,\n"
                    + "HOA_DON.NGAYTAO,\n"
                    + "HOA_DON.NGAYTHANHTOAN,\n"
                    + "HOA_DON.TIENGIAM,\n"
                    + "HOA_DON.TONGTIEN,\n"
                    + "HOA_DON.TIENKHACHDUA,\n"
                    + "HOA_DON.TIENTHUA,\n"
//                    + "HOA_DON.TIENTRATRUOC,\n"
                    + "HOA_DON.HINHTHUCTHANHTOAN,\n"
                    + "HOA_DON.MACHUYENKHOAN,\n"
//                    + "HOA_DON.TIENCHUYENKHOAN,\n"
                    + "HOA_DON.TRANGTHAI\n"
                    + "FROM\n"
                    + "HOA_DON\n";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                HoaDonDomain hdd = new HoaDonDomain(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
                        0, rs.getInt(12), rs.getString(13), 0);
                hdd.setTrangThai(rs.getString(14));
               hd.add(hdd);
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    @Override
    public boolean add(HoaDonDomain hd) {
        try {
            Connection cnn = DBConnect.getConnection();
String sql = "INSERT INTO HOA_DON( MA, ID_NV, ID_KH, MAPGG, NGAYTAO, NGAYTHANHTOAN, TIENGIAM, TONGTIEN,TIENKHACHDUA, TIENTHUA, TIENTRATRUOC, HINHTHUCTHANHTOAN, MACHUYENKHOAN, TIENCHUYENKHOAN)"
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setInt(2, hd.getIdNV());
            ps.setInt(3, hd.getIdKH());
            ps.setString(4, hd.getMaPGG());
            ps.setDate(5, hd.getNgayTao());
            ps.setDate(6, hd.getNgayThanhToan());
            ps.setInt(7, hd.getTienGiam());
            ps.setInt(8, hd.getTongTien());
            ps.setInt(9, hd.getTienKhachDua());
            ps.setInt(10, hd.getTienThua());
            ps.setInt(11, hd.getTienTraTruoc());
            ps.setInt(12, hd.getHinhThucThanhToan());
            ps.setString(13, hd.getMaChuyenKhoan());
            ps.setInt(14, hd.getTienChuyenKhoan());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public static void main(String[] args) {
//         long millis=System.currentTimeMillis();  
//        java.sql.Date date = new java.sql.Date(millis);
//        HoaDonDomain hd = new HoaDonDomain(1, 1, "Ma PGG", converterDateSql(date), converterDateSql(date), 0, 123, 123, 0, 0, 1, "CK1", 0);
//        new HoaDonRepository().add(hd);
            new HoaDonRepository().delete(3);
        System.out.println("Xoa thanh cong");
        
    }
    
      private static Date converterDateSql(java.util.Date date) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getDefault().getTimeZone("America/Los_Angeles"));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        TimeZone.setDefault(TimeZone.getTimeZone("Rome"));
        sqlDate = new java.sql.Date(date.getTime());
//        System.out.println(sqlDate);
        return sqlDate;
    }
    
    @Override
    public boolean update(int id, HoaDonDomain hd) {
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = " UPDATE HOA_DON set MA=?, MAPGG = ?, NGAYTAO = ?,  NGAYTHANHTOAN=?, TIENGIAM=?,  \n" +
"  TONGTIEN=?, TIENKHACHDUA=?, TIENTHUA=?, TIENTRATRUOC=?, HINHTHUCTHANHTOAN=?,\n" +
"  MACHUYENKHOAN=?, TIENCHUYENKHOAN=? where ID = ? ";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setString(2, hd.getMaPGG());
            ps.setDate(3, hd.getNgayTao());
            ps.setDate(4, hd.getNgayThanhToan());
            ps.setInt(5, hd.getTienGiam());
            ps.setInt(6, hd.getTongTien());
            ps.setInt(7, hd.getTienKhachDua());
            ps.setInt(8, hd.getTienThua());
            ps.setInt(9, hd.getTienTraTruoc());
            ps.setInt(10, hd.getHinhThucThanhToan());
            ps.setString(11, hd.getMaChuyenKhoan());
            ps.setInt(12, hd.getTienChuyenKhoan());
            ps.setInt(13, id);
             ps.executeUpdate() ;
             return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE HOA_DON where ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
//          e.printStackTrace();
        }
        return false;
    }

    @Override
    public HoaDonDomain findByMa(String ma) {
        HoaDonDomain hd = null;
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = "SELECT\n"
                    + "HOA_DON.ID,\n"
                    + "HOA_DON.MA,\n"
                    + "HOA_DON.ID_NV,\n"
                    + "HOA_DON.ID_KH,\n"
                    + "HOA_DON.MAPGG,\n"
                    + "HOA_DON.NGAYTAO,\n"
                    + "HOA_DON.NGAYTHANHTOAN,\n"
                    + "HOA_DON.TIENGIAM,\n"
                    + "HOA_DON.TONGTIEN,\n"
                    + "HOA_DON.TIENKHACHDUA,\n"
                    + "HOA_DON.TIENTHUA,\n"
                    //                    + "HOA_DON.TIENTRATRUOC,\n"
                    + "HOA_DON.HINHTHUCTHANHTOAN,\n"
                    + "HOA_DON.MACHUYENKHOAN,\n"
                    //                    + "HOA_DON.TIENCHUYENKHOAN,\n"
                    + "HOA_DON.TRANGTHAI\n"
                    + "FROM\n"
                    + "HOA_DON where HOA_DON.Ma = ?\n";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                hd = new HoaDonDomain(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
                        0, rs.getInt(12), rs.getString(13), 0);
                hd.setTrangThai(rs.getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    @Override
    public List<HoaDonDomain> searchByDate(Date start, Date end, int type) {
        ArrayList<HoaDonDomain> hd = new ArrayList<>();
        try {
            Connection cnn = DBConnect.getConnection();
            String sql = "SELECT\n"
                    + "HOA_DON.ID,\n"
                    + "HOA_DON.MA,\n"
                    + "HOA_DON.ID_NV,\n"
                    + "HOA_DON.ID_KH,\n"
                    + "HOA_DON.MAPGG,\n"
                    + "HOA_DON.NGAYTAO,\n"
                    + "HOA_DON.NGAYTHANHTOAN,\n"
                    + "HOA_DON.TIENGIAM,\n"
                    + "HOA_DON.TONGTIEN,\n"
                    + "HOA_DON.TIENKHACHDUA,\n"
                    + "HOA_DON.TIENTHUA,\n"
                    //                    + "HOA_DON.TIENTRATRUOC,\n"
                    + "HOA_DON.HINHTHUCTHANHTOAN,\n"
                    + "HOA_DON.MACHUYENKHOAN,\n"
                    //                    + "HOA_DON.TIENCHUYENKHOAN,\n"
                    + "HOA_DON.TRANGTHAI\n"
                    + "FROM\n"
                    + "HOA_DON\n";
            if (type == 0) {
                sql += "where HOA_DON.NGAYTAO >= ? and HOA_DON.NGAYTAO <= ?\n";
            } else if (type == 1) {
                sql += "where HOA_DON.NGAYTHANHTOAN >= ? and HOA_DON.NGAYTHANHTOAN <= ?\n";
            }
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                HoaDonDomain hdd = new HoaDonDomain(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
                        0, rs.getInt(12), rs.getString(13), 0);
                hdd.setTrangThai(rs.getString(14));
                hd.add(hdd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

}
