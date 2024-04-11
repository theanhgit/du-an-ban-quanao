/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import model.SPCTModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pc
 */
public class SPCTRepository {
     public List<SPCTModel> getAll() {
        String qery = """
                   SELECT SAN_PHAM_CHI_TIET.[ID]
                            ,SAN_PHAM_CHI_TIET.[MA]
                            ,[MAVACH]
                            ,[MOTA]
                            ,SAN_PHAM_CHI_TIET.[SOLUONG]
                            ,SAN_PHAM.[TEN] AS LOAISANPHAM
                            ,THUONG_HIEU.[TEN] AS THUONGHIEU
                            ,LOAITHETHAO.[TEN] AS LOAITHETHAO
                            ,KICH_CO.[KICHCO] AS KICHCO
                            ,MAU_SAC.[TEN] AS MAUSAC
                            ,CHAT_LIEU.[TEN] AS CHATLIEU
                            ,[GIANHAP]
                            ,[GIABAN]
                            ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                        FROM [dbo].[SAN_PHAM_CHI_TIET]
                      	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                      	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                      	JOIN LOAITHETHAO ON LOAITHETHAO.ID=SAN_PHAM_CHI_TIET.ID_LTT
                      	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                      	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                      	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<SPCTModel> listSPCT = new ArrayList<>();
            while (rs.next()) {
                SPCTModel spct = new SPCTModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getFloat(12),rs.getFloat(13),rs.getBoolean(14));
                listSPCT.add(spct);
            }
            return listSPCT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
     
      public List<SPCTModel> getSearch(String ten) {
        String qery = """
                   SELECT SAN_PHAM_CHI_TIET.[ID]
                            ,SAN_PHAM_CHI_TIET.[MA]
                            ,[MAVACH]
                            ,[MOTA]
                            ,SAN_PHAM_CHI_TIET.[SOLUONG]
                            ,SAN_PHAM.[TEN] AS LOAISANPHAM
                            ,THUONG_HIEU.[TEN] AS THUONGHIEU
                            ,LOAITHETHAO.[TEN] AS LOAITHETHAO
                            ,KICH_CO.[KICHCO] AS KICHCO
                            ,MAU_SAC.[TEN] AS MAUSAC
                            ,CHAT_LIEU.[TEN] AS CHATLIEU
                            ,[GIANHAP]
                            ,[GIABAN]
                            ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                        FROM [dbo].[SAN_PHAM_CHI_TIET]
                      	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                      	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                      	JOIN LOAITHETHAO ON LOAITHETHAO.ID=SAN_PHAM_CHI_TIET.ID_LTT
                      	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                      	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                      	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                      WHERE SAN_PHAM.[TEN] like '%'+ ? +'%' 
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1,ten);
            ResultSet rs = pr.executeQuery();
            List<SPCTModel> listSearch = new ArrayList<>();
            while (rs.next()) {
                SPCTModel spct = new SPCTModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getFloat(12),rs.getFloat(13),rs.getBoolean(14));
                listSearch.add(spct);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
      
    
}
