/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.util.List;
import viewmodel.KichCoViewModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.KichCoModel;

/**
 *
 * @author pc
 */
public class KichCoRepository {

    public List<KichCoModel> getAll() {
        String query = """
                        SELECT [ID]
                              ,[MA]      
                              ,[KICHCO]
                              
                          FROM [dbo].[KICH_CO]
                     """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(query)) {
            ResultSet rs = pr.executeQuery();
            List<KichCoModel> listKC = new ArrayList<>();
            while (rs.next()) {
                KichCoModel kc = new KichCoModel(rs.getInt(1), rs.getString(2), rs.getString(3));
                listKC.add(kc);
            }
            return listKC;
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return null;
    }

    public boolean getAdd(KichCoModel kc) {
        int check = 0;
        String qery = """
                  INSERT INTO [dbo].[KICH_CO]
                             ([MA]
                            
                             ,[KICHCO]
                             
                      
                       VALUES
                             (?,?)
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, kc.getMa());
          
            pr.setObject(2, kc.getKichCo());
           


            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }

    public boolean getUpdate(KichCoModel kc, int id) {
        int check = 0;
        String qery = """
                  UPDATE [dbo].[KICH_CO]
                     SET [MA] = ?
                        
                        ,[KICHCO] =?
                        
                   WHERE id=?
                    """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement pr = con.prepareStatement(qery)) {
            pr.setObject(1, kc.getMa());
            
            pr.setObject(2, kc.getKichCo());
          
            pr.setObject(3, id);

            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
        return check > 0;
    }
    public boolean getDelete( int id) {
        int check = 0;
        String qery = """
                  DELETE FROM [dbo].[KICH_CO]
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
