/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCHelper {
    public  static ResultSet excuteQuery(String sql, Object ...args){
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        
        cn = DBConnect.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            rs = pr.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public  static Integer excuteUpdate(String sql, Object ...args){
        Connection cn = null;
        Integer row = 0;
        PreparedStatement pr = null;
        
        cn = DBConnect.getConnection();
        try {
            pr = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            row = pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
