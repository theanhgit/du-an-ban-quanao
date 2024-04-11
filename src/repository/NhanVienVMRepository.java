/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utility.DBConnect;
import java.beans.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import utility.JDBCHelper;
import viewmodel.NhanVienVM;

/**
 *
 * @author User
 */
public class NhanVienVMRepository {

    private List<NhanVienVM> getNhanVienFromResultSet(ResultSet rs) {
        List<NhanVienVM> lst = new ArrayList<>();
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String hoten = rs.getString(2);
                int gioitinh = rs.getInt(3);
                String sdt = rs.getString(4);
                String cccd = rs.getString(5);
                LocalDate ngaysinh = null;
                java.sql.Date ngaysinhDate = rs.getDate(6);
                if (ngaysinhDate != null) {
                    ngaysinh = ngaysinhDate.toLocalDate();
                }
                String diachi = rs.getString(7);
                String email = rs.getString(8);
                int chucvu = rs.getInt(9);
                String tendn = rs.getString(10);
                String matkhau = rs.getString(11);
                int trangthai = rs.getInt(12);
                lst.add(new NhanVienVM(ma, hoten, gioitinh, sdt, cccd, ngaysinh, diachi, email, chucvu, tendn, matkhau, trangthai));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<NhanVienVM> getAllNVVM() {
        String sql = "select nv.MA,nv.HOTEN,nv.GIOTINH,nv.SDT,nv.CCCD,nv.NGAYSINH,nv.DIACHI,nv.EMAIL,nv.CHUVU,tk.TENDANGNHAP,tk.MATKHAU,nv.TRANGTHAI from NHAN_VIEN nv  join TAI_KHOAN tk on nv.ID = tk.ID_NV";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }
    public List<NhanVienVM> getAllNVByTrangThai() {
        String sql = "select nv.MA,nv.HOTEN,nv.GIOTINH,nv.SDT,nv.CCCD,nv.NGAYSINH,nv.DIACHI,nv.EMAIL,nv.CHUVU,tk.TENDANGNHAP,tk.MATKHAU,nv.TRANGTHAI from NHAN_VIEN nv  join TAI_KHOAN tk on nv.ID = tk.ID_NV where nv.TRANGTHAI = 1";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }


    public Integer addNhanVienVM(NhanVienVM nvvm) {
        String sql = "BEGIN TRANSACTION;\n"
                + "DECLARE @NhanVienID INT;\n"
                + "INSERT INTO NHAN_VIEN (MA, HOTEN, GIOTINH,SDT,CCCD,NGAYSINH,DIACHI,EMAIL,CHUVU,TRANGTHAI) VALUES (?, ?, ?,?,?,\n"
                + "?,?,?,?,?);\n"
                + "SET @NhanVienID = SCOPE_IDENTITY();\n"
                + "INSERT INTO TAI_KHOAN (ID_NV, TENDANGNHAP, MATKHAU) VALUES (@NhanVienID, ?, ?);\n"
                + "COMMIT;";
        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getMa(), nvvm.getHoten(), nvvm.getGioitinh(), nvvm.getSdt(),
                nvvm.getCccd(), nvvm.getNgaysinh(), nvvm.getDiachi(), nvvm.getEmail(), nvvm.getChucvu(), nvvm.getTrangthai(), nvvm.getTendn(), nvvm.getMatkhau());
        return row;
    }

    public Integer updateNhanVienVM(NhanVienVM nvvm) {
        String sql = "BEGIN TRANSACTION;\n"
                + "DECLARE @NhanVienID INT;\n"
                + "UPDATE NHAN_VIEN\n"
                + "SET HOTEN = ?, GIOTINH = ?,SDT = ?,CCCD = ?,NGAYSINH = ?,DIACHI=?,\n"
                + "EMAIL = ?,CHUVU = ?,TRANGTHAI=?\n"
                + "WHERE MA = ?;\n"
                + "SET @NhanVienID = (SELECT ID FROM NHAN_VIEN WHERE MA = ?);\n"
                + "UPDATE TAI_KHOAN\n"
                + "SET TENDANGNHAP = ?, MATKHAU = ?\n"
                + "WHERE ID_NV = @NhanVienID;\n"
                + "COMMIT;";

        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getHoten(), nvvm.getGioitinh(), nvvm.getSdt(), nvvm.getCccd(),
                nvvm.getNgaysinh(), nvvm.getDiachi(), nvvm.getEmail(), nvvm.getChucvu(), nvvm.getTrangthai(), nvvm.getMa(), nvvm.getMa(), nvvm.getTendn(), nvvm.getMatkhau());
        return row;
    }

    public Integer voHieuHoaNhanVienVM(NhanVienVM nvvm) {
        String sql = "update NHAN_VIEN set  TRANGTHAI = ? where MA = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, nvvm.getTrangthai(), nvvm.getMa());
        return row;
    }

    public List<NhanVienVM> timKiemByTen(String tennv) {
        String sql = " select*from NHAN_VIEN "
                + "where hoten like '%" + tennv + "%'";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        return getNhanVienFromResultSet(rs);
    }
//

    public List<NhanVienVM> locChucVu(int chucvu) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.CCCD, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI "
                + "FROM NHAN_VIEN nv JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV WHERE CHUVU = ?";
        try ( Connection connection = DBConnect.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chucvu);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<NhanVienVM> locTrangThai(int trangThai) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.CCCD, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI \n"
                + "                 FROM NHAN_VIEN nv JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV WHERE TRANGTHAI = ?";
        try ( Connection connection = DBConnect.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, trangThai);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<NhanVienVM> locNhanVien(int chucVu, int trangThai) {
        String sql = "SELECT nv.MA, nv.HOTEN, nv.GIOTINH, nv.SDT, nv.CCCD, nv.NGAYSINH, nv.DIACHI, nv.EMAIL, nv.CHUVU, tk.TENDANGNHAP, tk.MATKHAU, nv.TRANGTHAI\n"
                + "FROM NHAN_VIEN nv\n"
                + "JOIN TAI_KHOAN tk ON nv.ID = tk.ID_NV\n"
                + "WHERE nv.CHUVU = ? AND nv.TRANGTHAI = ?;";
        try ( Connection connection = DBConnect.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, chucVu);
            statement.setInt(2, trangThai);
            ResultSet rs = statement.executeQuery();
            return getNhanVienFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
