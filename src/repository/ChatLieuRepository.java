/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import model.ChatLieuModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class ChatLieuRepository {
 
    public List<ChatLieuModel> getAll() {
        String qery = """
                   SELECT [ID]
                         ,[MA]
                         ,[TEN]
                     FROM [dbo].[CHAT_LIEU]
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            ResultSet rs = pr.executeQuery();
            List<ChatLieuModel> listCL = new ArrayList<>();
            while (rs.next()) {
                ChatLieuModel cl = new ChatLieuModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listCL.add(cl);
            }
            return listCL;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }
    public boolean getAdd(ChatLieuModel cl) {
        int check = 0;
        String qery = """
                   INSERT INTO [dbo].[CHAT_LIEU]
                              ([MA]
                              ,[TEN])
                        VALUES
                              (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, cl.getMa());
            pr.setObject(2, cl.getTen());

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(ChatLieuModel cl, int id) {
        int check = 0;
        String qery = """
                   UPDATE [dbo].[CHAT_LIEU]
                      SET [MA] = ?
                         ,[TEN] =?
                    WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, cl.getMa());
            pr.setObject(2, cl.getTen());
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
                   DELETE FROM [dbo].[CHAT_LIEU]
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
