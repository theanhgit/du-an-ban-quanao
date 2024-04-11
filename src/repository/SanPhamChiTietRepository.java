/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.SanPhamChiTietModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class SanPhamChiTietRepository {

    public List<SanPhamChiTietModel> getAll() {
        String qery = """
                   SELECT [ID]
                          ,[MA]
                          ,[MAVACH]
                          ,[MOTA]
                          ,[SOLUONG]
                          ,[ID_SP]
                          ,[ID_TH]
                          ,[ID_LTT]
                          ,[ID_KC]
                          ,[ID_MS]
                          ,[ID_CL]
                          ,[GIANHAP]
                          ,[GIABAN]
                          ,[TRANGTHAI]
                      FROM [dbo].[SAN_PHAM_CHI_TIET]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<SanPhamChiTietModel> listSPCT = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTietModel sanPhamCT = new SanPhamChiTietModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                listSPCT.add(sanPhamCT);
            }
            return listSPCT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getAdd(SanPhamChiTietModel spct) {
        int check = 0;
        String qery = """
                    INSERT INTO [dbo].[SAN_PHAM_CHI_TIET]
                               ([MA]
                               ,[MAVACH]
                               ,[MOTA]
                               ,[SOLUONG]
                               ,[ID_SP]
                               ,[ID_TH]
                               ,[ID_LTT]
                               ,[ID_KC]
                               ,[ID_MS]
                               ,[ID_CL]
                               ,[GIANHAP]
                               ,[GIABAN]
                               ,[TRANGTHAI])
                         VALUES
                               (?,?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, spct.getMa());
            pr.setObject(2, spct.getMaVach());
            pr.setObject(3, spct.getMoTa());
            pr.setObject(4, spct.getSoLuong());
            pr.setObject(5, spct.getIdSP());
            pr.setObject(6, spct.getIdTH());
            pr.setObject(7, spct.getIdLTT());
            pr.setObject(8, spct.getIdKC());
            pr.setObject(9, spct.getIdMS());
            pr.setObject(10, spct.getIdCL());
            pr.setObject(11, spct.getGiaNhap());
            pr.setObject(12, spct.getGiaBan());
            pr.setObject(13, spct.isTrangThai());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getUpdate(SanPhamChiTietModel spct,int id) {
        int check = 0;
        String qery = """
                    UPDATE [dbo].[SAN_PHAM_CHI_TIET]
                       SET [MA] = ?
                          ,[MAVACH] = ?
                          ,[MOTA] =?
                          ,[SOLUONG] = ?
                          ,[ID_SP] =?
                          ,[ID_TH] =?
                          ,[ID_LTT] =?
                          ,[ID_KC] =?
                          ,[ID_MS] = ?
                          ,[ID_CL] =?
                          ,[GIANHAP] = ?
                          ,[GIABAN] = ?
                          ,[TRANGTHAI] = ?
                     WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, spct.getMa());
            pr.setObject(2, spct.getMaVach());
            pr.setObject(3, spct.getMoTa());
            pr.setObject(4, spct.getSoLuong());
            pr.setObject(5, spct.getIdSP());
            pr.setObject(6, spct.getIdTH());
            pr.setObject(7, spct.getIdLTT());
            pr.setObject(8, spct.getIdKC());
            pr.setObject(9, spct.getIdMS());
            pr.setObject(10, spct.getIdCL());
            pr.setObject(11, spct.getGiaNhap());
            pr.setObject(12, spct.getGiaBan());
            pr.setObject(13, spct.isTrangThai());
            pr.setObject(14, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                    DELETE FROM [dbo].[SAN_PHAM_CHI_TIET]
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
    
    public List<SanPhamChiTietModel> getSeachrch(String ma) {
        int check=0;
        String qery = """
                   SELECT [ID]
                          ,[MA]
                          ,[MAVACH]
                          ,[MOTA]
                          ,[SOLUONG]
                          ,[ID_SP]
                          ,[ID_TH]
                          ,[ID_LTT]
                          ,[ID_KC]
                          ,[ID_MS]
                          ,[ID_CL]
                          ,[GIANHAP]
                          ,[GIABAN]
                          ,[TRANGTHAI]
                      FROM [dbo].[SAN_PHAM_CHI_TIET]
                      WHERE ma like %?%
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1,ma);        
            check=pr.executeUpdate();     
            ResultSet rs = pr.executeQuery();
            List<SanPhamChiTietModel> listSearch = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTietModel sanPhamCT = new SanPhamChiTietModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getFloat(12), rs.getFloat(13), rs.getBoolean(14));
                listSearch.add(sanPhamCT);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getUpdateSoLuong(int soLuong,int id,int giaNhap) {
        int check = 0;
        String qery = """
                    UPDATE [dbo].[SAN_PHAM_CHI_TIET]
                       SET
                          [SOLUONG] = ?
                          ,[GIANHAP]=?
                     WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            
            pr.setObject(1,soLuong);
            pr.setObject(3, id);
            pr.setObject(2,giaNhap);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getUpdateSLKhiMua(int soLuong,int id) {
        int check = 0;
        String qery = """
                    UPDATE [dbo].[SAN_PHAM_CHI_TIET]
                       SET
                          [SOLUONG] = ?
                     WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            
            pr.setObject(1,soLuong);
            pr.setObject(2, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
}
