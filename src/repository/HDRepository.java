/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.HDModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class HDRepository {
    
    public List<HDModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[ID_NV]
                         ,[ID_KH]
                         ,[MAPGG]
                         ,[NGAYTAO]
                         ,[NGAYTHANHTOAN]
                         ,[TIENGIAM]
                         ,[TONGTIEN]
                         ,[TIENKHACHDUA]
                         ,[TIENTHUA]
                         ,[TIENKHACHPHAITRA]
                         ,[HINHTHUCTHANHTOAN]
                         ,[MACHUYENKHOAN]
                         ,[TRANGTHAI]
                     FROM [dbo].[HOA_DON]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<HDModel> listLTT = new ArrayList<>();
            while (rs.next()) {
                HDModel ltt = new HDModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getString(14),rs.getInt(15));
                listLTT.add(ltt);
            }
            return listLTT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getAdd(HDModel hd) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[HOA_DON]
                              ([MA]
                              ,[ID_NV]
                              ,[ID_KH]
                              ,[MAPGG]
                              ,[NGAYTAO]
                              ,[NGAYTHANHTOAN]
                              ,[TIENGIAM]
                              ,[TONGTIEN]
                              ,[TIENKHACHDUA]
                              ,[TIENTHUA]
                              ,[TIENKHACHPHAITRA]
                              ,[HINHTHUCTHANHTOAN]
                              ,[MACHUYENKHOAN]
                              ,[TRANGTHAI])
                        VALUES
                              (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1,hd.getMa());
            pr.setObject(2,hd.getIdNV());
            pr.setObject(3,hd.getIdKH());
            pr.setObject(4,hd.getMaPGG());
            pr.setObject(5,hd.getNgayTao());
            pr.setObject(6,hd.getNgayThanhToan());
            pr.setObject(7,hd.getTienGiam());
            pr.setObject(8,hd.getTongTien());
            pr.setObject(9,hd.getTienKhachDua());
            pr.setObject(10,hd.getTienThua());
            pr.setObject(11,hd.getTienKhachPhaiTra());
            pr.setObject(12,hd.getHinhThucThanhToan());
            pr.setObject(13,hd.getMaChuyenKhoan());
            pr.setObject(14,hd.getTrangThai());
            

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    
    public boolean getUpdate(HDModel hd,int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[HOA_DON]
                      SET [MA] = ?
                         ,[ID_NV] = ?
                         ,[ID_KH] = ?
                         ,[MAPGG] = ?
                         ,[NGAYTAO] =?
                         ,[NGAYTHANHTOAN] =? 
                         ,[TIENGIAM] = ?
                         ,[TONGTIEN] = ?
                         ,[TIENKHACHDUA] =? 
                         ,[TIENTHUA] = ?
                         ,[TIENKHACHPHAITRA] =? 
                         ,[HINHTHUCTHANHTOAN] =? 
                         ,[MACHUYENKHOAN] =?
                         ,[TRANGTHAI] = ?
                    WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1,hd.getMa());
            pr.setObject(2,hd.getIdNV());
            pr.setObject(3,hd.getIdKH());
            pr.setObject(4,hd.getMaPGG());
            pr.setObject(5,hd.getNgayTao());
            pr.setObject(6,hd.getNgayThanhToan());
            pr.setObject(7,hd.getTienGiam());
            pr.setObject(8,hd.getTongTien());
            pr.setObject(9,hd.getTienKhachDua());
            pr.setObject(10,hd.getTienThua());
            pr.setObject(11,hd.getTienKhachPhaiTra());
            pr.setObject(12,hd.getHinhThucThanhToan());
            pr.setObject(13,hd.getMaChuyenKhoan());
            pr.setObject(14,hd.getTrangThai());
            pr.setObject(15,id);


            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    
    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                   exec xosHoaDon ?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            
            pr.setObject(1,id);


            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getThanhToan(HDModel hd,int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[HOA_DON]
                      SET 
                         [ID_KH] = ?
                         ,[MAPGG] = ?
                         ,[NGAYTHANHTOAN] = ?
                         ,[TIENGIAM] =?
                         ,[TONGTIEN] = ?
                         ,[TIENKHACHDUA] = ?
                         ,[TIENTHUA] = ?
                         ,[TIENKHACHPHAITRA] = ?
                         ,[HINHTHUCTHANHTOAN] = ?
                         ,[MACHUYENKHOAN] = ?
                         ,[TRANGTHAI] = ?
                    WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            
            pr.setObject(1,hd.getIdKH());
            pr.setObject(2,hd.getMaPGG());
            pr.setObject(3,hd.getNgayThanhToan());
            pr.setObject(4,hd.getTienGiam());
            pr.setObject(5,hd.getTongTien());
            pr.setObject(6,hd.getTienKhachDua());
            pr.setObject(7,hd.getTienThua());
            pr.setObject(8,hd.getTienKhachPhaiTra());
            pr.setObject(9,hd.getHinhThucThanhToan());
            pr.setObject(10,hd.getMaChuyenKhoan());
            pr.setObject(11,hd.getTrangThai());
            pr.setObject(12,id);


            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
}
