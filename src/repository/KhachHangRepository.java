/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import utility.DBConnect;
import java.sql.Connection;
import java.util.ArrayList;
import viewmodel.QLKhachHang;
import java.sql.*;
import model.KhachHang;

/**
 *
 * @author adm
 */
public class KhachHangRepository {
    DBConnect con;
    
    public ArrayList<QLKhachHang> getListFromDB(){
        ArrayList<QLKhachHang> list = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                list.add(kh);
            }
        }catch(Exception ex){
            
        }
        return list;
    }
    
    public Boolean Them(KhachHang khachHang){
        String sql = "insert into KHACH_HANG(MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI)"
                + "values(?,?,?,?,?,?,?,?)";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getTen());
            ps.setObject(3, khachHang.getEmail());
            ps.setObject(4, khachHang.getSdt());
            ps.setObject(5, khachHang.getGioiTinh());
            ps.setObject(6, khachHang.getNgaySinh());
            ps.setObject(7, khachHang.getDiaChi());
            ps.setObject(8, khachHang.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }
    
    public Boolean Xoa(int id){
        String sql = "exec xoaKhachHang ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
    return null;    
    }
    
    public Boolean Sua(int id, KhachHang khachHang){
        String sql = "update KHACH_HANG set MA = ?, HOTEN = ?, EMAIL = ?, SDT = ?, GIOTINH = ?"
                + ", NGAYSINH = ?, DIACHI = ?, TRANGTHAI = ? where ID = ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getTen());
            ps.setObject(3, khachHang.getEmail());
            ps.setObject(4, khachHang.getSdt());
            ps.setObject(5, khachHang.getGioiTinh());
            ps.setObject(6, khachHang.getNgaySinh());
            ps.setObject(7, khachHang.getDiaChi());
            ps.setObject(8, khachHang.getTrangThai());
            ps.setObject(9, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    
    public Boolean khachHangTaoHoaDon(int id){
        String sql = 
                " update KHACH_HANG set TRANGTHAI = 0 where ID = ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setObject(1, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    public Boolean khachHangThanhToanHoaDon(int id){
        String sql = 
                " update KHACH_HANG set TRANGTHAI = 1 where ID = ?";
        try(Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setObject(1, id);
            ps.executeUpdate();
        }catch(Exception ex){
            
        }
        return null;
    }
    public ArrayList<QLKhachHang> TimKiemTheoMa(String ma){
        ArrayList<QLKhachHang> listKH = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG "
                + "where MA like '%"+ma+"%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                listKH.add(kh);
            }
        } catch (Exception e) {
        }
        return listKH;
    }
    
    public ArrayList<QLKhachHang> TimKiemTheoTen(String ten){
        ArrayList<QLKhachHang> listTimTheoTen = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG "
                + "where HOTEN like N'%"+ten+"%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                listTimTheoTen.add(kh);
            }
        } catch (Exception e) {
        }
        return listTimTheoTen;
    }
    
    public ArrayList<QLKhachHang> TimKiemTheoEmail(String email){
        ArrayList<QLKhachHang> listTimTheoEmail = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG "
                + "where EMAIL like '%"+email+"%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                listTimTheoEmail.add(kh);
            }
        } catch (Exception e) {
        }
        return listTimTheoEmail;
    }
    
    public ArrayList<QLKhachHang> TimKiemTheoSDT(String sdt){
        ArrayList<QLKhachHang> listTimTheoSDT = new ArrayList<>();
        String sql = "select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG "
                + "where SDT like '%"+sdt+"%'";
        try (Connection connection = con.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QLKhachHang kh = new QLKhachHang();
                kh.setId(rs.getInt(1));
                kh.setMa(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getDate(7));
                kh.setDiaChi(rs.getString(8));
                kh.setTrangThai(rs.getInt(9));
                listTimTheoSDT.add(kh);
            }
        } catch (Exception e) {
        }
        return listTimTheoSDT;
    }
}
