/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.GioHangModel;
import model.HDCTModel;

/**
 *
 * @author pc
 */
public class HDCTRepository {

    public List<HDCTModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[ID_HD]
                         ,[ID_SPCT]
                         ,[KICHCO]
                         ,[SOLUONG]
                         ,[DONGIA]
                     FROM [dbo].[HOA_DON_CT]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<HDCTModel> listMS = new ArrayList<>();
            while (rs.next()) {
                HDCTModel ms = new HDCTModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getFloat(6));
                listMS.add(ms);
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getAdd(HDCTModel hd) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[HOA_DON_CT]
                              ([ID_HD]
                              ,[ID_SPCT]
                              ,[KICHCO]
                              ,[SOLUONG]
                              ,[DONGIA])
                        VALUES
                              (?,?,?,?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, hd.getIdHD());
            pr.setObject(2, hd.getIdSPCT());
            pr.setObject(3, hd.getKichCo());
            pr.setObject(4, hd.getSoLuong());
            pr.setObject(5, hd.getDonGia());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(HDCTModel hd, int id) {
        int check = 0;
        String qery = """
                      UPDATE [dbo].[HOA_DON_CT]
                      SET [ID_HD] = ?
                            ,[ID_SPCT] =? 
                            ,[KICHCO] =?
                            ,[SOLUONG] =?
                            ,[DONGIA] =? 
                       WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, hd.getIdHD());
            pr.setObject(2, hd.getIdSPCT());
            pr.setObject(3, hd.getKichCo());
            pr.setObject(4, hd.getSoLuong());
            pr.setObject(5, hd.getDonGia());
            pr.setObject(6, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                      DELETE FROM [dbo].[HOA_DON_CT]
                      WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {

            pr.setObject(1, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public List<GioHangModel> getAllTable() {
        String qery = """
                   SELECT GioHang.[ID]
                         ,GioHang.[MA]
                         ,SAN_PHAM.TEN 
                         ,GioHang.[KICHCO]
                         ,GioHang.[SOLUONG]
                         ,GioHang.[DONGIA]
                     FROM (SELECT HOA_DON_CT.[ID]
                         ,HOA_DON.[MA]
                         ,SAN_PHAM_CHI_TIET.[ID_SP] as TenSP
                         ,[KICHCO]
                         ,HOA_DON_CT.[SOLUONG]
                         ,[DONGIA]
                     FROM [dbo].[HOA_DON_CT]
                     join HOA_DON on HOA_DON.ID=HOA_DON_CT.ID_HD
                     join SAN_PHAM_CHI_TIET on SAN_PHAM_CHI_TIET.ID=HOA_DON_CT.ID_SPCT
                     join SAN_PHAM on SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP) as GioHang
                     join SAN_PHAM on SAN_PHAM.ID=GioHang.TenSP
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<GioHangModel> listGH = new ArrayList<>();
            while (rs.next()) {
                GioHangModel gh = new GioHangModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6));
                listGH.add(gh);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getUpdateSoLuong(int id, int soLuong, Float donGia) {
        int check = 0;
        String qery = """
                      UPDATE [dbo].[HOA_DON_CT]
                      SET 
                            [SOLUONG] =?
                           ,[DONGIA] =? 
                            
                       WHERE ID=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {

            pr.setObject(1, soLuong);
            pr.setObject(2, donGia);
            pr.setObject(3, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
}
