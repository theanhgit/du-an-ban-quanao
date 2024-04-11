/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import viewmodel.QLTaiKhoan;
import java.sql.*;
import javax.swing.JOptionPane;
import model.TaiKhoan;

/**
 *
 * @author adm
 */
public class TaiKhoanRepository {
    DBConnect con;
    
    public ArrayList<QLTaiKhoan> getListFromDB(){
        ArrayList<QLTaiKhoan> list = new ArrayList<>();
        String sql = "select ID, ID_NV, TENDANGNHAP, MATKHAU from TAI_KHOAN";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLTaiKhoan tk = new QLTaiKhoan();
                tk.setId(rs.getInt(1));
                tk.setIdNV(rs.getInt(2));
                tk.setTaiKhoan(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                list.add(tk);
            }
        }catch(Exception ex){
            
        }
        return list;
    }
    
    public Boolean Them(TaiKhoan taiKhoan){
        String sql = "insert into TAI_KHOAN(ID_NV,TENDANGNHAP,MATKHAU) values(?,?,?)";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, taiKhoan.getIdNV());
            ps.setObject(2, taiKhoan.getTaiKhoan());
            ps.setObject(3, taiKhoan.getMatKhau());
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    
    public Boolean Xoa(int id){
        String sql = "delete TAI_KHOAN where ID = ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    
    public Boolean Sua(int id, TaiKhoan taiKhoan){
        String sql = "update TAI_KHOAN set ID_NV = ?, TENDANGNHAP = ?, MATKHAU = ? where ID = ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, taiKhoan.getIdNV());
            ps.setObject(2, taiKhoan.getTaiKhoan());
            ps.setObject(3, taiKhoan.getMatKhau());
            ps.setObject(4, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    
    public ArrayList<QLTaiKhoan> TimKiem(int idNV){
        ArrayList<QLTaiKhoan> listTK = new ArrayList<>();
        String sql = "select ID,ID_NV, TENDANGNHAP, MATKHAU from TAI_KHOAN where ID_NV ="+idNV+" ";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLTaiKhoan tk = new QLTaiKhoan();
                tk.setId(rs.getInt(1));
                tk.setIdNV(rs.getInt(2));
                tk.setTaiKhoan(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                listTK.add(tk);
            }
        } catch (Exception e) {
        }
        return listTK;
    }
}
