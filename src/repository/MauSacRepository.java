/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.MauSacModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class MauSacRepository {

    public List<MauSacModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[TEN]
                     FROM [dbo].[MAU_SAC]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<MauSacModel> listMS = new ArrayList<>();
            while (rs.next()) {
                MauSacModel ms = new MauSacModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listMS.add(ms);
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getAdd(MauSacModel ms) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[MAU_SAC]
                              ([MA]
                              ,[TEN])
                        VALUES
                              (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ms.getMa());
            pr.setObject(2, ms.getTen());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(MauSacModel ms, int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[MAU_SAC]
                      SET [MA] = ?
                         ,[TEN] =?
                    WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ms.getMa());
            pr.setObject(2, ms.getTen());
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
                   DELETE FROM [dbo].[MAU_SAC]
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
