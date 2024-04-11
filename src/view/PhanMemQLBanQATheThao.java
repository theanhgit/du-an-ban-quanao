/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.contains.ViewThongKe;
import view.contains.ViewSanPham;
import view.contains.ViewKhachHang;
import view.contains.ViewHoaDon;
import view.contains.ViewHeThong;
import view.contains.ViewBanHang;
import javax.swing.JPanel;
import model.TaiKhoan;
import service.NhanVienService;
import service.NhanVienVMService;
import service.TaiKhoanService;
import service.impl.NhanVienServiceImpl;
import service.impl.TaiKhoanServiceImpl;
import viewmodel.NhanVienVM;
import viewmodel.QLNhanVien;
import viewmodel.QLTaiKhoan;

/**
 *
 * @author pc
 */
public class PhanMemQLBanQATheThao extends javax.swing.JFrame {

    private JPanel panel;
    private List<NhanVienVM> lstNhanVienVM;
    private NhanVienVM nhanVienVM;
    private NhanVienVMService nhanVienVMService;

    private List<QLTaiKhoan> listTaiKhoan = new ArrayList<>();
    private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
    private QLTaiKhoan taiKhoan;
    private TaiKhoan taiKhoanSua;

    private NhanVienVM nhanVien;
    private List<QLNhanVien> listnhanVien = new ArrayList<>();
    private NhanVienService serviceNV = new NhanVienServiceImpl();
    private int idNV = 0;

    /**
     * Creates new form ViewDuAn1
     * @param nv
     */
    public PhanMemQLBanQATheThao(NhanVienVM nv) {
        initComponents();
        panel = new ViewBanHang(nv);
        setPanel(panel);
        nhanVienVM = nv;

        jlbTenNhanVien.setText(nv.getHoten());
        jlbMaNV.setText(nv.getMa());
        jlbTenNV.setText(nv.getHoten());
        jlbChucVu.setText(nv.getcv());
        jlbCV.setText("("+nv.getcv()+")");
        nhanVienVMService = new NhanVienVMService();
        lstNhanVienVM = nhanVienVMService.getAllNVVM();

        listnhanVien = serviceNV.getList();
        for (QLNhanVien nv1 : listnhanVien) {
            if (nv1.getMa().trim().equals(nhanVienVM.getMa())) {
                idNV = nv1.getId();
            }
        }
        listTaiKhoan = taiKhoanService.getList();
        for (QLTaiKhoan tk : listTaiKhoan) {
            if (tk.getIdNV() == idNV) {
                taiKhoan = tk;
            }
        }
        

//        setQuyen(nv);
    }

    private boolean setQuyen(NhanVienVM nv) {
        if (nv.getChucvu() == 1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa được cấp quyền");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdlNhanVien = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbMaNV = new javax.swing.JLabel();
        jlbChucVu = new javax.swing.JLabel();
        jlbTenNV = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        doiMatKhau = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtMatKhauCu = new javax.swing.JTextField();
        txtMatKhauMoi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnHeThong = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        txtLogo = new javax.swing.JLabel();
        jlbTenNhanVien = new javax.swing.JLabel();
        btnDangxuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jlbCV = new javax.swing.JLabel();
        jplContain = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Họ Tên :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Chức Vụ :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã NV :");

        jlbMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbMaNV.setText("Mã");

        jlbChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbChucVu.setText("Chức Vụ");

        jlbTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbTenNV.setText("Tên");

        btnDangXuat.setBackground(new java.awt.Color(255, 255, 204));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(0, 153, 51));
        btnDangXuat.setText("Đằng  xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setBackground(new java.awt.Color(255, 255, 204));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(0, 153, 51));
        btnDoiMatKhau.setText(" Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnDangXuat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnDoiMatKhau)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlbMaNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbTenNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlbChucVu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangXuat)
                    .addComponent(btnDoiMatKhau))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jdlNhanVienLayout = new javax.swing.GroupLayout(jdlNhanVien.getContentPane());
        jdlNhanVien.getContentPane().setLayout(jdlNhanVienLayout);
        jdlNhanVienLayout.setHorizontalGroup(
            jdlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdlNhanVienLayout.setVerticalGroup(
            jdlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mật khẩu mới :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu cũ :");

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 51));
        jButton2.setText("Thay Đổi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtMatKhauCu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtMatKhauMoi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatKhauCu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txtMatKhauMoi)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout doiMatKhauLayout = new javax.swing.GroupLayout(doiMatKhau.getContentPane());
        doiMatKhau.getContentPane().setLayout(doiMatKhauLayout);
        doiMatKhauLayout.setHorizontalGroup(
            doiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        doiMatKhauLayout.setVerticalGroup(
            doiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        btnSanPham.setBackground(new java.awt.Color(255, 0, 51));
        btnSanPham.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(255, 0, 51));
        btnHoaDon.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(255, 0, 51));
        btnKhachHang.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnHeThong.setBackground(new java.awt.Color(255, 0, 51));
        btnHeThong.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnHeThong.setForeground(new java.awt.Color(255, 255, 255));
        btnHeThong.setText("Hệ Thống");
        btnHeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeThongActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 0, 51));
        btnThongKe.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống Kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(255, 0, 51));
        btnBanHang.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(255, 255, 255));
        btnBanHang.setText("Bán Hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        txtLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logog6hd2.png"))); // NOI18N

        jlbTenNhanVien.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jlbTenNhanVien.setText("Tên nhân viên");

        btnDangxuat.setBackground(new java.awt.Color(255, 0, 51));
        btnDangxuat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnDangxuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangxuat.setText("Đăng xuất");
        btnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangxuatActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 0, 51));
        btnThoat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        jlbCV.setFont(new java.awt.Font("SansSerif", 3, 13)); // NOI18N
        jlbCV.setText("Vai trò");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDangxuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHeThong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbCV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jlbTenNhanVien))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbCV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jplContain.setBackground(new java.awt.Color(255, 255, 255));
        jplContain.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jplContain.setLayout(new javax.swing.BoxLayout(jplContain, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplContain, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplContain, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setPanel(JPanel p) {
        jplContain.removeAll();
        jplContain.add(p);
        jplContain.updateUI();
    }
    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        panel = new ViewKhachHang();
        setPanel(panel);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        panel = new ViewBanHang(nhanVienVM);
        setPanel(panel);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        panel = new ViewSanPham();
        setPanel(panel);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        panel = new ViewHoaDon();
        setPanel(panel);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        
        if (setQuyen(nhanVienVM)) {
            panel = new ViewThongKe();
            setPanel(panel);
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnHeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeThongActionPerformed
        if (setQuyen(nhanVienVM)) {
            panel = new ViewHeThong();
            setPanel(panel);
        }
    }//GEN-LAST:event_btnHeThongActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        doiMatKhau.setSize(400, 200);
        doiMatKhau.setResizable(false);
        doiMatKhau.setLocationRelativeTo(null);
        doiMatKhau.setVisible(true);
        jdlNhanVien.setVisible(false);

    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed

    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtMatKhauCu.getText().trim().isEmpty() || txtMatKhauMoi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập đủ thông tin");
        } else if (!txtMatKhauCu.getText().equals(taiKhoan.getMatKhau())) {
            JOptionPane.showMessageDialog(this, "Mật khâu của sai");
        } else if (txtMatKhauCu.getText().equals(txtMatKhauMoi.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới trùng với mật khẩu cũ");
        } else {

            taiKhoanSua = new TaiKhoan(taiKhoan.getId(), taiKhoan.getIdNV(), taiKhoan.getTaiKhoan(), txtMatKhauMoi.getText());
            taiKhoanService.Sua(taiKhoan.getId(), taiKhoanSua);
            JOptionPane.showMessageDialog(this, "Thay đổi thành công");
            listTaiKhoan = taiKhoanService.getList();

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không ?");
        if (hoi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangxuatActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không ?");
        if (hoi == JOptionPane.YES_OPTION) {
            this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnDangxuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhanMemQLBanQATheThao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhanMemQLBanQATheThao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhanMemQLBanQATheThao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhanMemQLBanQATheThao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PhanMemQLBanQATheThao().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDangxuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHeThong;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JDialog doiMatKhau;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JDialog jdlNhanVien;
    private javax.swing.JLabel jlbCV;
    private javax.swing.JLabel jlbChucVu;
    private javax.swing.JLabel jlbMaNV;
    private javax.swing.JLabel jlbTenNV;
    private javax.swing.JLabel jlbTenNhanVien;
    private javax.swing.JPanel jplContain;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JTextField txtMatKhauCu;
    private javax.swing.JTextField txtMatKhauMoi;
    // End of variables declaration//GEN-END:variables
}
