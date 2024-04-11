/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import viewmodel.QLBangTichDiem;
import java.sql.*;
import model.BangTichDiem;

/**
 *
 * @author adm
 */
public class BangTichDiemRepository {
    
    public ArrayList<QLBangTichDiem> getListFromDB(){
        ArrayList<QLBangTichDiem> list = new ArrayList<>();
        String sql = "select ID, ID_KH, MA, DIEMTICH, TIENDUOCGIAN from BANG_TICH_DIEM";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLBangTichDiem bt = new QLBangTichDiem();
                bt.setId(rs.getInt(1));
                bt.setIdKH(rs.getInt(2));
                bt.setMa(rs.getString(3));
                bt.setDiemTich(rs.getInt(4));
                bt.setTienDuocGiam(rs.getInt(5));
                list.add(bt);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Boolean Them(BangTichDiem bangTichDiem){
        String sql = "insert into  BANG_TICH_DIEM(ID_KH, MA, DIEMTICH, TIENDUOCGIAN) VALUES(?,?,?,?)";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, bangTichDiem.getIdKH());
            ps.setObject(2, bangTichDiem.getMa());
            ps.setObject(3, bangTichDiem.getDiemTich());
            ps.setObject(4, bangTichDiem.getTienDuocGiam());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean Xoa(int id){
        String sql = "Delete BANG_TICH_DIEM where ID = ?";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean Sua(int id, BangTichDiem bangTichDiem){
        String sql = "update BANG_TICH_DIEM set ID_KH = ?, MA = ?, DIEMTICH = ?, TIENDUOCGIAN = ? where ID = ?";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, bangTichDiem.getIdKH());
            ps.setObject(2, bangTichDiem.getMa());
            ps.setObject(3, bangTichDiem.getDiemTich());
            ps.setObject(4, bangTichDiem.getTienDuocGiam());
            ps.setObject(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<QLBangTichDiem> TimTheoIDKH(int idKH){
        ArrayList<QLBangTichDiem> listBTD = new ArrayList<>();
        String sql = "select ID, ID_KH, MA, DIEMTICH, TIENDUOCGIAN from BANG_TICH_DIEM where ID_KH = "+idKH+" ";
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLBangTichDiem bt = new QLBangTichDiem();
                bt.setId(rs.getInt(1));
                bt.setIdKH(rs.getInt(2));
                bt.setMa(rs.getString(3));
                bt.setDiemTich(rs.getInt(4));
                bt.setTienDuocGiam(rs.getInt(5));
                listBTD.add(bt);
            }
        } catch (Exception e) {
        }
        return listBTD;
    }
    
    public Boolean updateBangDIem(int id, QLBangTichDiem bangTichDiem){
        int check=0;
        String sql = """
                     UPDATE [dbo].[BANG_TICH_DIEM]
                        SET
                           [DIEMTICH] = ?
                           ,[TIENDUOCGIAN] = ?
                      WHERE ID=?
                     """;
        try (Connection connection = DBConnect.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setObject(1, bangTichDiem.getDiemTich());
            ps.setObject(2, bangTichDiem.getTienDuocGiam());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check>0;
    }
}
