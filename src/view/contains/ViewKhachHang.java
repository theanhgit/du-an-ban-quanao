/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangTichDiem;
import model.KhachHang;
import repository.KhachHangRepository;
import service.BangTichDiemService;
import service.KhachHangService;
import service.impl.BangTichDiemImpl;
import service.impl.KhachHangServiceImpl;
import viewmodel.QLBangTichDiem;
import viewmodel.QLKhachHang;

/**
 *
 * @author pc
 */
public class ViewKhachHang extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel;
    KhachHangRepository repository = new KhachHangRepository();
    KhachHangService service = new KhachHangServiceImpl();
    BangTichDiemService bangTichDiemService = new BangTichDiemImpl();
    QLKhachHang kh = new QLKhachHang();
    String ma = "";
    String ten = "";
    String email = "";
    String sdt = "";

    /**
     * Creates new form ViewKhachHang
     */
    public ViewKhachHang() {
        initComponents();
        loadDataTable(service.getList());
    }

    public void loadDataTable(ArrayList<QLKhachHang> listKH) {
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : listKH) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }

    }

    private boolean validateThem() {
//        if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
//                || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Thông tin không để trống");
//            return false;
//        }
//        for (QLKhachHang kh : service.getList()) {
//            if (txtMa.getText().trim().equals(kh.getMa())) {
//                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
//                return false;
//            }
//        }
//        return true;


 // Kiểm tra trường thông tin có trống không
    if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
            || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Thông tin không để trống");
        return false;
    }

    // Kiểm tra định dạng email
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    if (!txtEmail.getText().trim().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Email không hợp lệ");
        return false;
    }

    // Kiểm tra định dạng số điện thoại
    String sdtRegex = "^[0][0-9]{9}$";
    if (!txtSDT.getText().trim().matches(sdtRegex)) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
        return false;
    }

    // Kiểm tra mã khách hàng đã tồn tại
    for (QLKhachHang kh : service.getList()) {
        if (txtMa.getText().trim().equals(kh.getMa())) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
            return false;
        }
    }

    // Nếu tất cả đều hợp lệ
    return true;
    }

    private boolean validateSua() {
//        if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
//                || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Thông tin không để trống");
//            return false;
//        }
//
//        return true;


          // Kiểm tra trường thông tin có trống không
    if (txtMa.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
            || txtSDT.getText().trim().isEmpty() || dateNgaySinh.getDate().equals("") || txtDiaChi.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Thông tin không để trống");
        return false;
    }

    // Kiểm tra định dạng email
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    if (!txtEmail.getText().trim().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Email không hợp lệ");
        return false;
    }

    // Kiểm tra định dạng số điện thoại
    String sdtRegex = "^[0][0-9]{9}$";
    if (!txtSDT.getText().trim().matches(sdtRegex)) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
        return false;
    }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        cbTrangThai = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbDiemTich = new javax.swing.JLabel();
        lbMaTichDiem = new javax.swing.JLabel();
        lbTiemDuocGiam = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Bảng tích điểm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Họ tên", "Email", "SDT", "Giới tính", "Ngày sinh", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("TÌm khách hàng: ");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Họ Tên", "Email", "SDT" }));

        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btnSearch.setText("Lọc");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnSearch)))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Thông tin khách hàng");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Mã");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Email");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Họ tên");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Giới tính");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Ngày sinh");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Địa Chỉ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Số điện thoại");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Trạng thái");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNu.setText("Nữ");

        dateNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dateNgaySinh.setDateFormatString("yyyy-MM-dd");

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel22.setText("Đã Thanh Toán");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(rdNam)
                        .addGap(44, 44, 44)
                        .addComponent(rdNu))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cbTrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTrangThai)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Danh sách khách hàng");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Mã :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Điểm tích được : ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Tiền được giảm :");

        lbDiemTich.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbDiemTich.setForeground(new java.awt.Color(51, 0, 255));
        lbDiemTich.setText("Điểm tích");

        lbMaTichDiem.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbMaTichDiem.setForeground(new java.awt.Color(51, 0, 255));
        lbMaTichDiem.setText("Mã");

        lbTiemDuocGiam.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbTiemDuocGiam.setForeground(new java.awt.Color(51, 0, 255));
        lbTiemDuocGiam.setText("Tiền giảm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17))
                    .addComponent(jLabel18))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaTichDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiemTich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTiemDuocGiam, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbMaTichDiem))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbDiemTich))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbTiemDuocGiam))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Chức năng");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        btnThem.setBackground(new java.awt.Color(0, 0, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnThem.setText("Thêm khách hàng ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 0, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pencil-20.png"))); // NOI18N
        btnSua.setText("Sửa thông tin KH");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-trash-20.png"))); // NOI18N
        btnXoa.setText("Xóa khách hàng");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClearForm.setBackground(new java.awt.Color(0, 0, 0));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-available-updates-20 (1).png"))); // NOI18N
        btnClearForm.setText("Làm mới");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang kh = new KhachHang();
        if (validateThem()) {
            kh.setMa(txtMa.getText().trim());
            kh.setTen(txtTen.getText().trim());
            kh.setEmail(txtEmail.getText().trim());
            kh.setSdt(txtSDT.getText().trim());
            int gioiTinh = 0;
            if (rdNam.isSelected() == true) {
                gioiTinh = 1;
            }
            kh.setGioiTinh(gioiTinh);
            kh.setNgaySinh(dateNgaySinh.getDate());
            kh.setDiaChi(txtDiaChi.getText().trim());
            int trangThai = 0;
            if (cbTrangThai.isSelected() == true) {
                trangThai = 1;
            }
            kh.setTrangThai(trangThai);
            service.Them(kh);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataTable(service.getList());
            int id = 0;
            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
                if (txtMa.getText().equalsIgnoreCase(tblKhachHang.getValueAt(i, 1).toString())) {
                    id = (int) tblKhachHang.getValueAt(i, 0);
                }
            }

            BangTichDiem bd = new BangTichDiem();
            bd.setIdKH(id);
            bd.setMa("BTD" + id);
            bd.setDiemTich(0);
            bd.setTienDuocGiam(0);
            bangTichDiemService.Them(bd);
            lbMaTichDiem.setText(bd.getMa());
            lbDiemTich.setText(String.valueOf(bd.getDiemTich()));
            lbTiemDuocGiam.setText(String.valueOf(bd.getTienDuocGiam()));
            Clear();
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    public void ThemBangTichDiem() {

    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn khách hàng cần sửa thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int id = (int) tblKhachHang.getValueAt(selectedRow, 0);
            if (validateSua()) {
                KhachHang kh = new KhachHang();
                kh.setMa(txtMa.getText().trim());
                kh.setTen(txtTen.getText().trim());
                kh.setEmail(txtEmail.getText().trim());
                kh.setSdt(txtSDT.getText().trim());
                int gioiTinh = 0;
                if (rdNam.isSelected()) {
                    gioiTinh = 1;
                }
                kh.setGioiTinh(gioiTinh);
                kh.setNgaySinh(dateNgaySinh.getDate());
                kh.setDiaChi(txtDiaChi.getText().trim());
                int trangThai = 0;
                if (cbTrangThai.isSelected()) {
                    trangThai = 1;
                }
                kh.setTrangThai(trangThai);
                service.Sua(id, kh);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadDataTable(service.getList());
                Clear();
            }
          
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblKhachHang.getSelectedRow();
        if (index == -1) {
            // No row selected, display a message
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
        // A row is selected, ask for confirmation before deletion
        int confirmResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        
        if (confirmResult == JOptionPane.YES_OPTION) {
            // User confirmed deletion, proceed with deletion
            int id = (int) tblKhachHang.getValueAt(index, 0);
            service.Xoa(id);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadDataTable(service.getList());
            Clear();
        }
    }
       
    }//GEN-LAST:event_btnXoaActionPerformed

    public void TimTheoMa() {
        String ma = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoMa(ma)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoTen() {
        String ten = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoTen(ten)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoEmail() {
        String email = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoEmail(email)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }

    public void TimTheoSDT() {
        String sdt = jTextField1.getText();
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (QLKhachHang kh : repository.TimKiemTheoSDT(sdt)) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getTen(), kh.getEmail(), kh.getSdt(),
                (kh.getGioiTinh() == 1) ? "Nam" : "Nữ", kh.getNgaySinh(), kh.getDiaChi(),
                (kh.getTrangThai() == 1) ? "Đã thanh toán" : "Chưa thanh toán"
            });
        }
    }
    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        Clear();
    }//GEN-LAST:event_btnClearFormActionPerformed

    public void Clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        buttonGroup1.clearSelection();
        dateNgaySinh.setDate(null);
        cbTrangThai.setSelected(false);
    }
    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
//        int index = tblKhachHang.getSelectedRow();
//        txtMa.setText(tblKhachHang.getValueAt(index, 1).toString());
//        txtTen.setText(tblKhachHang.getValueAt(index, 2).toString());
//        txtEmail.setText(tblKhachHang.getValueAt(index, 3).toString());
//        txtSDT.setText(tblKhachHang.getValueAt(index, 4).toString());
//        if (tblKhachHang.getValueAt(index, 5).toString().equalsIgnoreCase("Nam")) {
//            rdNam.setSelected(true);
//        }
//        if (tblKhachHang.getValueAt(index, 5).toString().equalsIgnoreCase("Nữ")) {
//            rdNu.setSelected(true);
//        }
//        String NgaySinh = tblKhachHang.getValueAt(index, 6).toString();
//        DateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date ngSinh = dateFomat.parse(NgaySinh);
//            dateNgaySinh.setDate(ngSinh);
//        } catch (Exception e) {
//        }
//        txtDiaChi.setText(tblKhachHang.getValueAt(index, 7).toString());
//        if (tblKhachHang.getValueAt(index, 8).toString().equalsIgnoreCase("Đã thanh toán")) {
//            cbTrangThai.setSelected(true);
//        }
//        if (tblKhachHang.getValueAt(index, 8).toString().equalsIgnoreCase("Chưa thanh toán")) {
//            cbTrangThai.setSelected(false);
//        }
//
//        int id = (int) tblKhachHang.getValueAt(index, 0);
//        for (QLBangTichDiem btd : bangTichDiemService.getList()) {
//            if (btd.getIdKH() == id) {
//                lbMaTichDiem.setText(btd.getMa());
//                lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
//                lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
//            }
//        }
//         int index = tblKhachHang.getSelectedRow();
//
//        if (index != -1) { // Kiểm tra xem đã chọn hàng nào chưa
//        txtMa.setText(getCellValue(index, 1));
//        txtTen.setText(getCellValue(index, 2));
//        txtEmail.setText(getCellValue(index, 3));
//        txtSDT.setText(getCellValue(index, 4));
//
//        String gioiTinhValue = getCellValue(index, 5);
//        if (gioiTinhValue != null) {
//            if (gioiTinhValue.equalsIgnoreCase("Nam")) {
//                rdNam.setSelected(true);
//            } else if (gioiTinhValue.equalsIgnoreCase("Nữ")) {
//                rdNu.setSelected(true);
//            }
//        }
//
//        String ngaySinhValue = getCellValue(index, 6);
//        if (ngaySinhValue != null) {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                Date ngSinh = dateFormat.parse(ngaySinhValue);
//                dateNgaySinh.setDate(ngSinh);
//            } catch (Exception e) {
//                e.printStackTrace(); // Xử lý nếu có lỗi parse ngày
//            }
//        }
//
//        txtDiaChi.setText(getCellValue(index, 7));
//
//        String trangThaiValue = getCellValue(index, 8);
//        if (trangThaiValue != null) {
//            cbTrangThai.setSelected(trangThaiValue.equalsIgnoreCase("Đã thanh toán"));
//        }
//
//        int id = (int) tblKhachHang.getValueAt(index, 0);
//        for (QLBangTichDiem btd : bangTichDiemService.getList()) {
//            if (btd.getIdKH() == id) {
//                lbMaTichDiem.setText(btd.getMa());
//                lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
//                lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
//            }
//        }
//    }

       int index = tblKhachHang.getSelectedRow();
        if (index != -1) {  // Kiểm tra xem một dòng có được chọn không
            Object maValue = tblKhachHang.getValueAt(index, 1);
            Object tenValue = tblKhachHang.getValueAt(index, 2);
            Object emailValue = tblKhachHang.getValueAt(index, 3);
            Object sdtValue = tblKhachHang.getValueAt(index, 4);
            Object gioiTinhValue = tblKhachHang.getValueAt(index, 5);
            Object ngaySinhValue = tblKhachHang.getValueAt(index, 6);
            Object diaChiValue = tblKhachHang.getValueAt(index, 7);
            Object trangThaiValue = tblKhachHang.getValueAt(index, 8);

            // Kiểm tra và đặt giá trị cho ô text
            txtMa.setText((maValue != null) ? maValue.toString() : "");
            txtTen.setText((tenValue != null) ? tenValue.toString() : "");
            txtEmail.setText((emailValue != null) ? emailValue.toString() : "");
            txtSDT.setText((sdtValue != null) ? sdtValue.toString() : "");

            if (gioiTinhValue != null) {
                String gioiTinh = gioiTinhValue.toString();
                if (gioiTinh.equalsIgnoreCase("Nam")) {
                    rdNam.setSelected(true);
                } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
                    rdNu.setSelected(true);
                }
            }
        if (ngaySinhValue != null) {
                String NgaySinh = ngaySinhValue.toString();
                if (!NgaySinh.isEmpty()) {
                    // Kiểm tra xem ngày sinh có giá trị không trống
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date ngSinh = dateFormat.parse(NgaySinh);
                        dateNgaySinh.setDate(ngSinh);
                    } catch (Exception e) {
                        e.printStackTrace();  // Thực hiện xử lý nếu có lỗi parse ngày sinh
                    }
                } else {
                    // Nếu giá trị là rỗng, đặt JCalendar về trạng thái không chọn ngày nào
                    dateNgaySinh.setDate(null);
                }
            } else {
                // Nếu giá trị là null, đặt JCalendar về trạng thái không chọn ngày nào
                dateNgaySinh.setDate(null);
            }
            txtDiaChi.setText((diaChiValue != null) ? diaChiValue.toString() : "");

            if (trangThaiValue != null) {
                String trangThai = trangThaiValue.toString();
                cbTrangThai.setSelected(trangThai.equalsIgnoreCase("Đã thanh toán"));
            }

            int id = (int) tblKhachHang.getValueAt(index, 0);
            for (QLBangTichDiem btd : bangTichDiemService.getList()) {
                if (btd.getIdKH() == id) {
                    lbMaTichDiem.setText(btd.getMa());
                    lbDiemTich.setText(String.valueOf(btd.getDiemTich()));
                    lbTiemDuocGiam.setText(String.valueOf(btd.getTienDuocGiam()));
                }
            }
            }
    }//GEN-LAST:event_tblKhachHangMouseClicked
   
    private String getCellValue(int rowIndex, int colIndex) {
        Object value = tblKhachHang.getValueAt(rowIndex, colIndex);
        return (value != null) ? value.toString() : null;
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (jComboBox1.getSelectedItem().equals("Mã")) {
            TimTheoMa();
        } else if (jComboBox1.getSelectedItem().equals("Họ Tên")) {
            TimTheoTen();
        } else if (jComboBox1.getSelectedItem().equals("Email")) {
            TimTheoEmail();
        } else if (jComboBox1.getSelectedItem().equals("SDT")) {
            TimTheoSDT();
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbTrangThai;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbDiemTich;
    private javax.swing.JLabel lbMaTichDiem;
    private javax.swing.JLabel lbTiemDuocGiam;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
