/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.ThuongHieuModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class ThuongHieuRepository {
    public List<ThuongHieuModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[TEN]
                     FROM [dbo].[THUONG_HIEU]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<ThuongHieuModel> listTH = new ArrayList<>();
            while (rs.next()) {
                ThuongHieuModel th = new ThuongHieuModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listTH.add(th);
            }
            return listTH;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getAdd(ThuongHieuModel th) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[THUONG_HIEU]
                              ([MA]
                              ,[TEN])
                        VALUES
                              (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, th.getMa());
            pr.setObject(2, th.getTen());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(ThuongHieuModel th, int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[THUONG_HIEU]
                      SET [MA] = ?
                         ,[TEN] = ?
                    WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, th.getMa());
            pr.setObject(2, th.getTen());
            pr.setObject(3, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getDelete(int id) {
        int check = 0;
        String qery = """
                   DELETE FROM [dbo].[THUONG_HIEU]
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
}
