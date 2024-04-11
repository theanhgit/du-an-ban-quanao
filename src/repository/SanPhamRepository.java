/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import model.SanPhamModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import viewmodel.SanPhamThongKe;

/**
 *
 * @author pc
 */
public class SanPhamRepository {

    public List<SanPhamModel> getAll() {
        String qery = """
                    SELECT [ID]
                          ,[MA]
                          ,[TEN]
                          ,[LOAISANPHAM]
                          ,[SOLUONG]
                      FROM [dbo].[SAN_PHAM]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<SanPhamModel> listSP = new ArrayList<>();
            while (rs.next()) {
                SanPhamModel sanPham = new SanPhamModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listSP.add(sanPham);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getAdd(SanPhamModel sp) {
        int check = 0;
        String qery = """
                    INSERT INTO [dbo].[SAN_PHAM]
                               ([MA]
                               ,[TEN]
                               ,[LOAISANPHAM]
                               ,[SOLUONG])
                         VALUES
                               (?,?,?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, sp.getMa());
            pr.setObject(2, sp.getTen());
            pr.setObject(3, sp.getLoaiSanPham());
            pr.setObject(4, sp.getSoLuong());
            
            check=pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check>0;
    }
    public boolean getUpdate(SanPhamModel sp,int id) {
        int check = 0;
        String qery = """
                    UPDATE [dbo].[SAN_PHAM]
                       SET [MA] = ?
                          ,[TEN] = ?
                          ,[LOAISANPHAM] = ?
                          ,[SOLUONG] =?
                     WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, sp.getMa());
            pr.setObject(2, sp.getTen());
            pr.setObject(3, sp.getLoaiSanPham());
            pr.setObject(4, sp.getSoLuong());
            pr.setObject(5, id);

            check=pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check>0;
    }
    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                    DELETE FROM [dbo].[SAN_PHAM]
                          WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {

            pr.setObject(1, id);

            check = pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public Integer tongSpTC() {
        String sql = "select sum(ct.SOLUONG) as soluong from SAN_PHAM_CHI_TIET ct ";
        
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("soluong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Integer tongSp(Object id, int type) {
        String sql = "select sum(ct.SOLUONG) as soluong from SAN_PHAM_CHI_TIET ct where ct.Ma= ?";
        if(type == 1){
            sql = "select sum(ct.SOLUONG) as soluong from SAN_PHAM_CHI_TIET ct \n" +
        "inner join SAN_PHAM s on s.ID = ct.ID_SP where s.LOAISANPHAM = ?";
        }
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            if(type == 1){
                ps.setString(1, (String) id);
            }
            else{
                ps.setString(1, (String) id);
            }
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("soluong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Integer tongSpDaBan(String ma, Date start, Date end, int type) {
        String sql = "select sum(ct.SOLUONG) as soluong from HOA_DON_CT ct\n" +
                    "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                    "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                    "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                    "where spct.MA = ? and h.NGAYTAO >= ? and h.NGAYTAO <= ? and h.TRANGTHAI=1";
        if(type == 1){
            sql = "select sum(ct.SOLUONG) as soluong from HOA_DON_CT ct\n" +
                "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                "where sp.LOAISANPHAM = ? and h.NGAYTAO >= ? and h.NGAYTAO <= ? and h.TRANGTHAI=1";
        }
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.setString(1, ma);
            ps.setDate(2, start);
            ps.setDate(3, end);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("soluong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Integer tongSpDaBanTC() {
        String sql = "select sum(ct.SOLUONG) as soluong from HOA_DON_CT ct\n" +
                    "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                    "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                    "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                    "where h.TRANGTHAI=1";
        
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("soluong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<SanPhamThongKe> sanPhamThongKeTC() {
        List<SanPhamThongKe> list = new ArrayList<>();
        String sql = "select spct.MA, sp.TEN, ct.KICHCO,ct.SOLUONG,spct.GIABAN, ct.DONGIA as doanhthu \n" +
                    "from HOA_DON_CT ct\n" +
                    "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                    "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                    "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                    "where h.TRANGTHAI = 1 ";
        
         try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                list.add(new SanPhamThongKe(rs.getString("MA"), rs.getString("TEN"),
                        rs.getString("KICHCO"), rs.getInt("SOLUONG"), rs.getInt("GIABAN"), rs.getInt("doanhthu")));
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<SanPhamThongKe> sanPhamThongKe(String ma, Date start, Date end, int type) {
        List<SanPhamThongKe> list = new ArrayList<>();
        String sql = "select spct.MA, sp.TEN, ct.KICHCO,ct.SOLUONG,spct.GIABAN, ct.DONGIA  as doanhthu \n" +
                    "from HOA_DON_CT ct\n" +
                    "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                    "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                    "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                    "where spct.MA = ? and h.NGAYTHANHTOAN >= ? and h.NGAYTHANHTOAN <= ? and h.TRANGTHAI=1";
        if(type == 1){
            sql = "select spct.MA, sp.TEN, ct.KICHCO,ct.SOLUONG,spct.GIABAN, ct.DONGIA as doanhthu \n" +
                "from HOA_DON_CT ct\n" +
                "inner join SAN_PHAM_CHI_TIET spct on spct.ID = ct.ID_SPCT\n" +
                "inner join SAN_PHAM sp on sp.ID = spct.ID_SP\n" +
                "inner join HOA_DON h on h.ID = ct.ID_HD\n" +
                "where sp.LOAISANPHAM = ? and h.NGAYTHANHTOAN >= ? and h.NGAYTHANHTOAN <= ? and h.TRANGTHAI=1";
        }
         try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            if(type == 1){
                ps.setString(1,ma);
            }
            else{
                ps.setString(1,ma);
            }
            ps.setDate(2, start);
            ps.setDate(3, end);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                list.add(new SanPhamThongKe(rs.getString("MA"), rs.getString("TEN"),
                        rs.getString("KICHCO"), rs.getInt("SOLUONG"), rs.getInt("GIABAN"), rs.getInt("doanhthu")));
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Integer tinhDoanhThu(Date start, Date end) {
        String sql = "select SUM(h.TIENKHACHPHAITRA ) as tong from HOA_DON h \n" +
                    "where h.NGAYTHANHTOAN >= ? and h.NGAYTHANHTOAN <= ? and h.TRANGTHAI=1";
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("tong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Integer tinhDoanhThu1(Date date) {
        String sql = "select SUM(h.TIENKHACHPHAITRA ) as tong from HOA_DON h \n" +
                    "where h.NGAYTHANHTOAN = ? and h.TRANGTHAI=1 ";
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDate(1, date);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("tong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Integer tinhDoanhThu2(int month) {
         String sql = "select SUM(h.TIENKHACHPHAITRA ) as tong from HOA_DON h\n" +
                    "where MONTH(h.NGAYTHANHTOAN) = ? and YEAR(h.NGAYTHANHTOAN) = YEAR(GETDATE()) and h.TRANGTHAI=1";
        try {
            Connection cnn = DBConnect.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, month);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                return rs.getInt("tong");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
