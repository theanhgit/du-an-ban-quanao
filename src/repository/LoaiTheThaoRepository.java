/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.LoaiTheThaoModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class LoaiTheThaoRepository {
    public List<LoaiTheThaoModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[TEN]
                     FROM [dbo].[LOAITHETHAO]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<LoaiTheThaoModel> listLTT = new ArrayList<>();
            while (rs.next()) {
                LoaiTheThaoModel ltt = new LoaiTheThaoModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listLTT.add(ltt);
            }
            return listLTT;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getAdd(LoaiTheThaoModel ltt) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[LOAITHETHAO]
                              ([MA]
                              ,[TEN])
                        VALUES
                              (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ltt.getMa());
            pr.setObject(2, ltt.getTen());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(LoaiTheThaoModel ltt, int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[LOAITHETHAO]
                      SET [MA] =?
                         ,[TEN] =?
                    WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, ltt.getMa());
            pr.setObject(2, ltt.getTen());
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
                  DELETE FROM [dbo].[LOAITHETHAO]
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
