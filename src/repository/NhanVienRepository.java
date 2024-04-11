/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import viewmodel.QLNhanVien;
import java.sql.*;
import model.NhanVien;

/**
 *
 * @author adm
 */
public class NhanVienRepository {
    
    DBConnect con;
    
    public ArrayList<QLNhanVien> getListFromDB(){
        ArrayList<QLNhanVien> list = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUVU, TRANGTHAI from NHAN_VIEN";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setCccd(rs.getString(6));
                nv.setNgaySinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getInt(10));
                nv.setTrangThai(rs.getInt(11));
                list.add(nv);
            }
        }catch(Exception ex){
            
        }
    return list;
    }
    
    public Boolean Them(NhanVien nhanVien){
        String sql = "insert into NHAN_VIEN(MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUVU, TRANGTHAI)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getCccd());
            ps.setObject(6, nhanVien.getNgaySinh());
            ps.setObject(7, nhanVien.getDiaChi());
            ps.setObject(8, nhanVien.getEmail());
            ps.setObject(9, nhanVien.getChucVu());
            ps.setObject(10, nhanVien.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean Xoa(int id){
        String sql = "Delete NHAN_VIEN where ID = ?";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean Sua(int id, NhanVien nhanVien){
        String sql = "update NHAN_VIEN set MA =?, HOTEN=?, GIOTINH=?, SDT=?, CCCD=?, NGAYSINH=?, DIACHI=?,"
                + " EMAIL =?, CHUVU =?, TRANGTHAI =? where ID = ?" ;
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, nhanVien.getMa());
            ps.setObject(2, nhanVien.getTen());
            ps.setObject(3, nhanVien.getGioiTinh());
            ps.setObject(4, nhanVien.getSdt());
            ps.setObject(5, nhanVien.getCccd());
            ps.setObject(6, nhanVien.getNgaySinh());
            ps.setObject(7, nhanVien.getDiaChi());
            ps.setObject(8, nhanVien.getEmail());
            ps.setObject(9, nhanVien.getChucVu());
            ps.setObject(10, nhanVien.getTrangThai());
            ps.setObject(11, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<QLNhanVien> TimKiemTheoMa(String name){
        ArrayList<QLNhanVien> listNV = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUVU, TRANGTHAI from NHAN_VIEN "
                + "where MA like '%"+name+"%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLNhanVien nv = new QLNhanVien();
                nv.setId(rs.getInt(1));
                nv.setMa(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setSdt(rs.getString(5));
                nv.setCccd(rs.getString(6));
                nv.setNgaySinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getInt(10));
                nv.setTrangThai(rs.getInt(11));
                listNV.add(nv);
                
            }
        } catch (Exception e) {
        }
        return listNV;
    }
}
