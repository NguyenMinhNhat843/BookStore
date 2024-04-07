/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.NhanVien_DAO;
import entity.NhanVien;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Panel_staff extends javax.swing.JPanel {
 private NhanVien_DAO nv_dao = new NhanVien_DAO();
    /**
     * Creates new form Panel_staff
     */
    public Panel_staff() {
        initComponents();
//        DocDuLieuLenTableNhanVien();
//        DocDuLieuLenTaiKhoan();
    }
    // * Tai khoan *
    public void XoaDuLieuTK() {
        DefaultTableModel temp = (DefaultTableModel) table_TK.getModel();
        temp.getDataVector().removeAllElements();
    }
    
    public void DocDuLieuLenTaiKhoan() {
//        ArrayList<TaiKhoan> dsTK = tk_dao.getAllTK();
//        
//        DefaultTableModel temp = (DefaultTableModel) table_TK.getModel();
//        
//        for(TaiKhoan tk : dsTK){
//            Object[] obj = {tk.getMaTK(), tk.getMaNV().getMaNV(), tk.getTenNguoiDung(), tk.getUsername()
//            , tk.getPassword(), tk.getLoaiTK()};
//            temp.addRow(obj);
//        }         
    }
    
    public void ThemTaiKhoan(NhanVien nv) {
//        TaiKhoan tk = new TaiKhoan("abc", new NhanVien(nv.getMaNV()), nv.getTenNV(), 
//                nv.getsDT(), "1111", nv.getChucVu().equals("Quản Lý") ? "LTK002" : "LTK001");
//        
//        tk_dao.themTKVaoCSDL(tk);
//        
//        XoaDuLieuTK();
//        DocDuLieuLenTaiKhoan();
    }

    public boolean validData_NV() {
        String maNV = txt_MaNV.getText().toString().trim();
        String tenNV = txt_TenNV.getText().toString().trim();
        String email = txt_Email.getText().toString().trim();
        String sDT = txt_SDT.getText().toString().trim();
        String diaChi = txt_DiaChi.getText().toString().trim();
        
        
       
        if(maNV.isEmpty() || (!maNV.matches("^NV\\d{3}$"))){
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải theo mẫu NV001");
            return false;
        }
        if(tenNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên NV không được rỗng!!!");
            return false;
        }
        
        if(email.isEmpty() || !email.matches("[a-zA-Z0-9]+@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email theo mẫu abc123@gmail.com");
            return false;
        }
        
        if(sDT.isEmpty() || !sDT.matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số");
            return false;
        }
        
        if(diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được rỗng!!!");
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_NhanVien = new javax.swing.JPanel();
        pnl_info_NV = new javax.swing.JPanel();
        pnl_info_1 = new javax.swing.JPanel();
        pnl_MaNV = new javax.swing.JPanel();
        lbl_MaNV = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        pnl_TenNV = new javax.swing.JPanel();
        lbl_TenNV = new javax.swing.JLabel();
        txt_TenNV = new javax.swing.JTextField();
        pnl_info_2 = new javax.swing.JPanel();
        pnl_GioiTinh = new javax.swing.JPanel();
        lbl_GT = new javax.swing.JLabel();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        pnl_ChucVu = new javax.swing.JPanel();
        lbl_ChucVu = new javax.swing.JLabel();
        cb_ChucVu = new javax.swing.JComboBox<>();
        pnl_info_3 = new javax.swing.JPanel();
        pnl_NS = new javax.swing.JPanel();
        lbl_NS = new javax.swing.JLabel();
        date_NS = new com.toedter.calendar.JDateChooser();
        pnl_Email = new javax.swing.JPanel();
        lbl_Email = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        pnl_info_4 = new javax.swing.JPanel();
        pnl_DiaChi = new javax.swing.JPanel();
        lbl_DiaChi = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        pnl_SDT = new javax.swing.JPanel();
        lbl_SDT = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        pnl_center = new javax.swing.JPanel();
        pnl_BoLoc = new javax.swing.JPanel();
        pnl_LocTheoChucVu = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cb_LocTheoCV = new javax.swing.JComboBox<>();
        pnl_LocTheoNamSinh = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        date_NgaySinh = new com.toedter.calendar.JDateChooser();
        btn_LocTheoNgaySinh = new javax.swing.JButton();
        pnl_LocTheoGT = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        cb_LocGT = new javax.swing.JComboBox<>();
        pnl_tabel = new javax.swing.JPanel();
        pnl_Tim = new javax.swing.JPanel();
        txt_Tim = new javax.swing.JTextField();
        btn_LocTheoNgaySinh1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanVien = new javax.swing.JTable();
        pnl_CRUD = new javax.swing.JPanel();
        btn_XoaTrang = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_NhapFile = new javax.swing.JButton();
        btn_XuatFile = new javax.swing.JButton();
        pnl_TaiKhoan = new javax.swing.JPanel();
        pnl_dsTK = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_TK = new javax.swing.JTable();
        pnl_thongTK = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        pnl_NhanVien.setLayout(new java.awt.BorderLayout());

        pnl_info_NV.setPreferredSize(new java.awt.Dimension(0, 110));
        pnl_info_NV.setLayout(new java.awt.GridLayout(1, 4));

        pnl_info_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnl_info_1.setLayout(new java.awt.GridLayout(2, 1));

        pnl_MaNV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_MaNV.setLayout(new java.awt.BorderLayout());

        lbl_MaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_MaNV.setText("Mã NV:");
        lbl_MaNV.setPreferredSize(new java.awt.Dimension(60, 25));
        pnl_MaNV.add(lbl_MaNV, java.awt.BorderLayout.LINE_START);

        txt_MaNV.setEditable(false);
        txt_MaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_MaNV.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_MaNV.add(txt_MaNV, java.awt.BorderLayout.CENTER);

        pnl_info_1.add(pnl_MaNV);

        pnl_TenNV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_TenNV.setLayout(new java.awt.BorderLayout());

        lbl_TenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TenNV.setText("Tên NV:");
        lbl_TenNV.setPreferredSize(new java.awt.Dimension(60, 25));
        pnl_TenNV.add(lbl_TenNV, java.awt.BorderLayout.LINE_START);

        txt_TenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_TenNV.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_TenNV.add(txt_TenNV, java.awt.BorderLayout.CENTER);

        pnl_info_1.add(pnl_TenNV);

        pnl_info_NV.add(pnl_info_1);

        pnl_info_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnl_info_2.setLayout(new java.awt.GridLayout(2, 1));

        pnl_GioiTinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_GioiTinh.setLayout(new java.awt.BorderLayout());

        lbl_GT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_GT.setText("Giới tính:");
        lbl_GT.setPreferredSize(new java.awt.Dimension(70, 25));
        pnl_GioiTinh.add(lbl_GT, java.awt.BorderLayout.LINE_START);

        cb_GioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cb_GioiTinh.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_GioiTinh.add(cb_GioiTinh, java.awt.BorderLayout.CENTER);

        pnl_info_2.add(pnl_GioiTinh);

        pnl_ChucVu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_ChucVu.setLayout(new java.awt.BorderLayout());

        lbl_ChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ChucVu.setText("Chức vụ: ");
        lbl_ChucVu.setPreferredSize(new java.awt.Dimension(70, 25));
        pnl_ChucVu.add(lbl_ChucVu, java.awt.BorderLayout.LINE_START);

        cb_ChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên Bán Hàng" }));
        cb_ChucVu.setPreferredSize(new java.awt.Dimension(300, 40));
        cb_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ChucVuActionPerformed(evt);
            }
        });
        pnl_ChucVu.add(cb_ChucVu, java.awt.BorderLayout.CENTER);

        pnl_info_2.add(pnl_ChucVu);

        pnl_info_NV.add(pnl_info_2);

        pnl_info_3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        pnl_info_3.setLayout(new java.awt.GridLayout(2, 1));

        pnl_NS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_NS.setLayout(new java.awt.BorderLayout());

        lbl_NS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_NS.setText("Ngày Sinh:");
        lbl_NS.setPreferredSize(new java.awt.Dimension(80, 25));
        pnl_NS.add(lbl_NS, java.awt.BorderLayout.LINE_START);

        date_NS.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_NS.add(date_NS, java.awt.BorderLayout.CENTER);

        pnl_info_3.add(pnl_NS);

        pnl_Email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_Email.setLayout(new java.awt.BorderLayout());

        lbl_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Email.setText("Email:");
        lbl_Email.setPreferredSize(new java.awt.Dimension(80, 25));
        pnl_Email.add(lbl_Email, java.awt.BorderLayout.LINE_START);

        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Email.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_Email.add(txt_Email, java.awt.BorderLayout.CENTER);

        pnl_info_3.add(pnl_Email);

        pnl_info_NV.add(pnl_info_3);

        pnl_info_4.setLayout(new java.awt.GridLayout(2, 1));

        pnl_DiaChi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_DiaChi.setLayout(new java.awt.BorderLayout());

        lbl_DiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DiaChi.setText("Địa chỉ:");
        lbl_DiaChi.setPreferredSize(new java.awt.Dimension(60, 25));
        pnl_DiaChi.add(lbl_DiaChi, java.awt.BorderLayout.LINE_START);

        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_DiaChi.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_DiaChi.add(txt_DiaChi, java.awt.BorderLayout.CENTER);

        pnl_info_4.add(pnl_DiaChi);

        pnl_SDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_SDT.setLayout(new java.awt.BorderLayout());

        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_SDT.setText("SĐT:");
        lbl_SDT.setPreferredSize(new java.awt.Dimension(60, 25));
        pnl_SDT.add(lbl_SDT, java.awt.BorderLayout.LINE_START);

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_SDT.setPreferredSize(new java.awt.Dimension(300, 40));
        pnl_SDT.add(txt_SDT, java.awt.BorderLayout.CENTER);

        pnl_info_4.add(pnl_SDT);

        pnl_info_NV.add(pnl_info_4);

        pnl_NhanVien.add(pnl_info_NV, java.awt.BorderLayout.NORTH);

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_BoLoc.setPreferredSize(new java.awt.Dimension(0, 100));
        pnl_BoLoc.setLayout(new java.awt.GridLayout(1, 3));

        pnl_LocTheoChucVu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        pnl_LocTheoChucVu.setLayout(new java.awt.GridLayout(1, 1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Theo Chức Vụ"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        cb_LocTheoCV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_LocTheoCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn chức vụ --", "Quản Lý", "Nhân Viên Bán Hàng" }));
        cb_LocTheoCV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_LocTheoCVItemStateChanged(evt);
            }
        });
        jPanel7.add(cb_LocTheoCV, java.awt.BorderLayout.CENTER);

        pnl_LocTheoChucVu.add(jPanel7);

        pnl_BoLoc.add(pnl_LocTheoChucVu);

        pnl_LocTheoNamSinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        pnl_LocTheoNamSinh.setLayout(new java.awt.GridLayout(1, 1));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Theo Năm Sinh"));
        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel9.add(date_NgaySinh, java.awt.BorderLayout.CENTER);

        btn_LocTheoNgaySinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_LocTheoNgaySinh.setPreferredSize(new java.awt.Dimension(70, 43));
        btn_LocTheoNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LocTheoNgaySinhMouseClicked(evt);
            }
        });
        jPanel9.add(btn_LocTheoNgaySinh, java.awt.BorderLayout.LINE_END);

        pnl_LocTheoNamSinh.add(jPanel9);

        pnl_BoLoc.add(pnl_LocTheoNamSinh);

        pnl_LocTheoGT.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Theo Giới Tính"));
        pnl_LocTheoGT.setLayout(new java.awt.GridLayout(1, 1));

        jPanel11.setLayout(new java.awt.BorderLayout());

        cb_LocGT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_LocGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn giới tính --", "Nam", "Nữ" }));
        cb_LocGT.setPreferredSize(new java.awt.Dimension(250, 35));
        cb_LocGT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_LocGTItemStateChanged(evt);
            }
        });
        jPanel11.add(cb_LocGT, java.awt.BorderLayout.CENTER);

        pnl_LocTheoGT.add(jPanel11);

        pnl_BoLoc.add(pnl_LocTheoGT);

        pnl_center.add(pnl_BoLoc, java.awt.BorderLayout.NORTH);

        pnl_tabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Nhân Viên"));
        pnl_tabel.setLayout(new java.awt.BorderLayout());

        pnl_Tim.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txt_Tim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tim.setPreferredSize(new java.awt.Dimension(500, 50));
        txt_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimActionPerformed(evt);
            }
        });
        pnl_Tim.add(txt_Tim);

        btn_LocTheoNgaySinh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_LocTheoNgaySinh1.setPreferredSize(new java.awt.Dimension(50, 50));
        btn_LocTheoNgaySinh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LocTheoNgaySinh1MouseClicked(evt);
            }
        });
        pnl_Tim.add(btn_LocTheoNgaySinh1);

        pnl_tabel.add(pnl_Tim, java.awt.BorderLayout.PAGE_START);

        tbl_nhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Chức Vụ", "Giới Tính", "Địa Chỉ", "Email", "Ngày Sinh", "SĐT"
            }
        ));
        tbl_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanVien);

        pnl_tabel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnl_CRUD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_XoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XoaTrang.setText("Xóa trắng");
        btn_XoaTrang.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_XoaTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaTrangMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_XoaTrang);

        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SuaMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_Sua);

        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Them.setText("Thêm mới");
        btn_Them.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_Them);

        btn_NhapFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_NhapFile.setText("Nhập File");
        btn_NhapFile.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_NhapFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NhapFileMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_NhapFile);

        btn_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XuatFile.setText("Xuất File");
        btn_XuatFile.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_XuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatFileMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_XuatFile);

        pnl_tabel.add(pnl_CRUD, java.awt.BorderLayout.PAGE_END);

        pnl_center.add(pnl_tabel, java.awt.BorderLayout.CENTER);

        pnl_NhanVien.add(pnl_center, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Nhân viên", pnl_NhanVien);

        pnl_TaiKhoan.setLayout(new java.awt.BorderLayout());

        pnl_dsTK.setPreferredSize(new java.awt.Dimension(1000, 765));
        pnl_dsTK.setLayout(new java.awt.BorderLayout());

        table_TK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Mã TK", "Mã NV", "Tên NV", "Username ", "pass", "Chức vụ"
            }
        ));
        jScrollPane2.setViewportView(table_TK);

        pnl_dsTK.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnl_TaiKhoan.add(pnl_dsTK, java.awt.BorderLayout.CENTER);

        pnl_thongTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin tài khoản"));
        pnl_thongTK.setPreferredSize(new java.awt.Dimension(500, 765));
        pnl_thongTK.setLayout(new java.awt.GridLayout(10, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mã NV:");
        jLabel1.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel1.add(jLabel1);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel1.add(jTextField1);

        pnl_thongTK.add(jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tên NV:");
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel2.add(jLabel2);

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel2.add(jTextField2);

        pnl_thongTK.add(jPanel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Username:");
        jPanel3.add(jLabel3);

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel3.add(jTextField3);

        pnl_thongTK.add(jPanel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Pass:");
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel6.add(jLabel4);

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel6.add(jTextField4);

        pnl_thongTK.add(jPanel6);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Chức vụ:");
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel12.add(jLabel5);

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField5.setPreferredSize(new java.awt.Dimension(350, 40));
        jPanel12.add(jTextField5);

        pnl_thongTK.add(jPanel12);

        pnl_TaiKhoan.add(pnl_thongTK, java.awt.BorderLayout.EAST);

        jTabbedPane1.addTab("Quản Lý Tài Khoản", pnl_TaiKhoan);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
        
    
    public void DocDuLieuLenTableNhanVien(){
//        ArrayList<NhanVien> dsNV = nv_dao.getAllNV();
//        DefaultTableModel temp = (DefaultTableModel) tbl_nhanVien.getModel();
//        
//        for(NhanVien nv : dsNV){
//            Object[] obj = {nv.getMaNV(),nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(), nv.getNgaySinh(),nv.getsDT()};
//            temp.addRow(obj);
//        }         
    }
     public void XoaDuLieuTableNV(){
        DefaultTableModel temp = (DefaultTableModel) tbl_nhanVien.getModel();
        temp.getDataVector().removeAllElements();
    }
    private void cb_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_ChucVuActionPerformed

    private void txt_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimActionPerformed
        
    }//GEN-LAST:event_txt_TimActionPerformed

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked

        if(validData_NV()) {
            NhanVien nv = createNV();
            ArrayList<NhanVien> dsNCC = nv_dao.getAllNV();

            if(true) {
                if(nv_dao.ThemNV(nv)) {
                    XoaDuLieuTableNV();
                    DocDuLieuLenTableNhanVien();
                    JOptionPane.showMessageDialog(this, "Thêm thành công!!!");
                    ThemTaiKhoan(nv);
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bai!!! Có lỗi xảy ra!!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tai!!!");
            }
            }
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void tbl_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanVienMouseClicked
        int r = tbl_nhanVien.getSelectedRow();
        
        if(r >= 0){
            txt_MaNV.setText(tbl_nhanVien.getValueAt(r, 0).toString());
            txt_TenNV.setText(tbl_nhanVien.getValueAt(r, 1).toString());
            txt_DiaChi.setText(tbl_nhanVien.getValueAt(r, 4).toString());
            txt_Email.setText(tbl_nhanVien.getValueAt(r, 5).toString());
//            date_NS.setDateFormatString(tbl_nhanVien.getValueAt(r, 6).toString());
            try {
                SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");

                Date date = dtf.parse(tbl_nhanVien.getValueAt(r, 6).toString().substring(0, 10));
                date_NS.setDate(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            txt_SDT.setText(tbl_nhanVien.getValueAt(r, 7).toString());
            cb_ChucVu.addItem(tbl_nhanVien.getValueAt(r, 2).toString());
            cb_ChucVu.setSelectedIndex(tbl_nhanVien.getValueAt(r, 2).toString().equals("Quản Lý") ? 0 : 1);
            cb_GioiTinh.addItem(tbl_nhanVien.getValueAt(r, 3).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng muốn thao tác!");
        }
    }//GEN-LAST:event_tbl_nhanVienMouseClicked

    private void btn_XoaTrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTrangMouseClicked
        // TODO add your handling code here:
        txt_MaNV.setText("");
        txt_TenNV.setText("");
        txt_DiaChi.setText("");
        txt_Email.setText("");
        txt_SDT.setText("");
    }//GEN-LAST:event_btn_XoaTrangMouseClicked

    private void btn_SuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SuaMouseClicked
//        int r = tbl_nhanVien.getSelectedRow();
//        if(r < 0){
//            JOptionPane.showMessageDialog(this, "Cần chọn sản phẩm cần cập nhật!");
//        }
//        
//        if(validData_NV()){
//            String maNV = txt_MaNV.getText().toString();
//            String tenNV = txt_TenNV.getText().toString();
//            String cb_ChucVu = String.valueOf(this.cb_ChucVu.getSelectedItem());
//            String cbo_GioiTinh = String.valueOf(cb_GioiTinh.getSelectedItem());
//            String diaChi = txt_DiaChi.getText().toString();
//            String email = txt_Email.getText().toString();
//            Date ngaySinh = date_NS.getDate();
//    //        System.out.println("GUI.Panel_staff.createNV() " + ngaySinh) ;
//            Instant instant = ngaySinh.toInstant();
//            // Chuyển đổi từ Instant sang LocalDateTime
//            LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
//            String sDT = txt_SDT.getText().toString();
//            NhanVien nv = new NhanVien(maNV, tenNV, cb_ChucVu, cbo_GioiTinh, diaChi, email, localDateTime, sDT);
//        
//            
//            if(nv_dao.CapNhatNV(nv)){
//                DefaultTableModel temp = (DefaultTableModel) tbl_nhanVien.getModel();
//                temp.removeRow(r);
//                Object[] obj = {nv.getMaNV(), nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(), nv.getDiaChi(), nv.getEmail(), nv.getNgaySinh(), nv.getsDT()};
//                temp.insertRow(r, obj);
//                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
//            }else{
//                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!Có lỗi xảy ra!!");
//            }
//        }
    }//GEN-LAST:event_btn_SuaMouseClicked

    private void cb_LocTheoCVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_LocTheoCVItemStateChanged
//        int n = cb_LocTheoCV.getSelectedIndex();
//        
//        if(n != 0) {
//            ArrayList<NhanVien> dsNV = nv_dao.getAllNV();
//            ArrayList<NhanVien> dsNV_Loc = new ArrayList<>();
//            if(n == 1) {
//                for(NhanVien nv : dsNV) {
//                    if(nv.getChucVu().equals("Quản Lý")) {
//                        dsNV_Loc.add(nv);
//                    }
//                }
//            } else {
//                for(NhanVien nv : dsNV) {
//                    if(nv.getChucVu().equals("Nhân Viên")) {
//                        dsNV_Loc.add(nv);
//                    }
//                }
//            }
//
//            XoaDuLieuTableNV();
//            DefaultTableModel temp = (DefaultTableModel) tbl_nhanVien.getModel();
//
//            for(NhanVien nv : dsNV_Loc){
//                Object[] obj = {nv.getMaNV(),nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(), nv.getNgaySinh(),nv.getsDT()};
//                temp.addRow(obj);
//            }        
//        } else {
//            XoaDuLieuTableNV();
//            DocDuLieuLenTableNhanVien();
//        }
    }//GEN-LAST:event_cb_LocTheoCVItemStateChanged

    private void btn_LocTheoNgaySinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LocTheoNgaySinhMouseClicked
//         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String ngayBatDau = df.format(date_NgaySinh.getDate());
//         Date currentDate = date_NgaySinh.getDate();
//
//        // Chuyển đổi ngày thành lớp Calendar
//        Calendar calendarInstance = Calendar.getInstance();
//        calendarInstance.setTime(currentDate);
//
//        // Thêm một ngày để lấy ngày hôm sau
//        calendarInstance.add(Calendar.DAY_OF_MONTH, 1);
//
//        // Lấy ngày hôm sau
//        Date nextDay = calendarInstance.getTime();
//        String ngayKT = df.format(nextDay);
//        
//        XoaDuLieuTableNV();
//        
//        ArrayList<NhanVien> dsNV = nv_dao.getNV_TheoNgaySinh(ngayBatDau, ngayKT);
//        
//         DefaultTableModel model_dsNV = (DefaultTableModel) tbl_nhanVien.getModel();
//        
//        for(NhanVien nv : dsNV){
//            Object[] obj = {nv.getMaNV(),nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(), nv.getNgaySinh(),nv.getsDT()};
//            model_dsNV.addRow(obj);
//        }        
    }//GEN-LAST:event_btn_LocTheoNgaySinhMouseClicked

    private void cb_LocGTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_LocGTItemStateChanged
//        int n = cb_LocGT.getSelectedIndex();
//        
//        if(n != 0) {
//            ArrayList<NhanVien> dsNV = nv_dao.getAllNV();
//            ArrayList<NhanVien> dsNV_Loc = new ArrayList<>();
//            if(n == 1) {
//                for(NhanVien nv : dsNV) {
//                    if(nv.getGioiTinh().equals("Nam")) {
//                        dsNV_Loc.add(nv);
//                    }
//                }
//            } else {
//                for(NhanVien nv : dsNV) {
//                    if(nv.getGioiTinh().equals("Nữ")) {
//                        dsNV_Loc.add(nv);
//                    }
//                }
//            }
//
//            XoaDuLieuTableNV();
//            DefaultTableModel temp = (DefaultTableModel) tbl_nhanVien.getModel();
//
//            for(NhanVien nv : dsNV_Loc){
//                Object[] obj = {nv.getMaNV(),nv.getTenNV(), nv.getChucVu(), nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(), nv.getNgaySinh(),nv.getsDT()};
//                temp.addRow(obj);
//            }        
//        } else {
//            XoaDuLieuTableNV();
//            DocDuLieuLenTableNhanVien();
//        }
    }//GEN-LAST:event_cb_LocGTItemStateChanged

    private void btn_NhapFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhapFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NhapFileMouseClicked

    private void btn_XuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XuatFileMouseClicked

    private void btn_LocTheoNgaySinh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LocTheoNgaySinh1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LocTheoNgaySinh1MouseClicked
    
    public NhanVien createNV() {
//        String maNV = txt_MaNV.getText().toString();
//        String tenNV = txt_TenNV.getText().toString();
//        String cb_ChucVu = String.valueOf(this.cb_ChucVu.getSelectedItem());
//        String cbo_GioiTinh = String.valueOf(cb_GioiTinh.getSelectedItem());
//        String diaChi = txt_DiaChi.getText().toString();
//        String email = txt_Email.getText().toString();
//        Date ngaySinh = date_NS.getDate();
////        System.out.println("GUI.Panel_staff.createNV() " + ngaySinh) ;
//        Instant instant = ngaySinh.toInstant();
//        // Chuyển đổi từ Instant sang LocalDateTime
//        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
//        String sDT = txt_SDT.getText().toString();
//        NhanVien nv = new NhanVien(maNV, tenNV, cb_ChucVu, cbo_GioiTinh, diaChi, email, localDateTime, sDT);
//        
//         return nv;
            return null;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LocTheoNgaySinh;
    private javax.swing.JButton btn_LocTheoNgaySinh1;
    private javax.swing.JButton btn_NhapFile;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XoaTrang;
    private javax.swing.JButton btn_XuatFile;
    private javax.swing.JComboBox<String> cb_ChucVu;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private javax.swing.JComboBox<String> cb_LocGT;
    private javax.swing.JComboBox<String> cb_LocTheoCV;
    private com.toedter.calendar.JDateChooser date_NS;
    private com.toedter.calendar.JDateChooser date_NgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_ChucVu;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_GT;
    private javax.swing.JLabel lbl_MaNV;
    private javax.swing.JLabel lbl_NS;
    private javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TenNV;
    private javax.swing.JPanel pnl_BoLoc;
    private javax.swing.JPanel pnl_CRUD;
    private javax.swing.JPanel pnl_ChucVu;
    private javax.swing.JPanel pnl_DiaChi;
    private javax.swing.JPanel pnl_Email;
    private javax.swing.JPanel pnl_GioiTinh;
    private javax.swing.JPanel pnl_LocTheoChucVu;
    private javax.swing.JPanel pnl_LocTheoGT;
    private javax.swing.JPanel pnl_LocTheoNamSinh;
    private javax.swing.JPanel pnl_MaNV;
    private javax.swing.JPanel pnl_NS;
    private javax.swing.JPanel pnl_NhanVien;
    private javax.swing.JPanel pnl_SDT;
    private javax.swing.JPanel pnl_TaiKhoan;
    private javax.swing.JPanel pnl_TenNV;
    private javax.swing.JPanel pnl_Tim;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_dsTK;
    private javax.swing.JPanel pnl_info_1;
    private javax.swing.JPanel pnl_info_2;
    private javax.swing.JPanel pnl_info_3;
    private javax.swing.JPanel pnl_info_4;
    private javax.swing.JPanel pnl_info_NV;
    private javax.swing.JPanel pnl_tabel;
    private javax.swing.JPanel pnl_thongTK;
    private javax.swing.JTable table_TK;
    private javax.swing.JTable tbl_nhanVien;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_Tim;
    // End of variables declaration//GEN-END:variables
}
