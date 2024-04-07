/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.NhaCungCap_DAO;
import dao.SanPham_DAO;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.SanPham;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.neo4j.driver.Driver;

import ConnectDB.connectDB;
import dao.KhuyenMai_DAO;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Panel_Product extends javax.swing.JPanel {

    private SanPham_DAO sp_dao = new SanPham_DAO();
    private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
    private List<SanPham> dsSP;
    private List<KhuyenMai> dsKM;
    private KhuyenMai_DAO km_dao = new KhuyenMai_DAO();

    /**
     * Creates new form Panel_Product
     */
    public Panel_Product() {
        connect();
        initComponents();
        loadCmbKM();
        DocLieuLenTableSanPham();
//        DocDuLieuLenCBoBoxNCC();

    }

    public void connect() {
        try {
            Driver driver = connectDB.getInstance().getDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void DocDuLieuLenCBoBoxNCC() {
//        ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNCC();
//        
//        for(NhaCungCap ncc : dsNCC) {
//            cbo_NCC_field.addItem(ncc);
//            cbo_LocTheoNCC.addItem(ncc.getTenNCC());
//        }
//    }
    public void LocTheoLSP() {
        int lsp_selected = cbo_LocTheoLoai.getSelectedIndex();
        if (lsp_selected == 0) {
            DocLieuLenTableSanPham();
            return;
        }
        ArrayList<SanPham> locTheoLSP = new ArrayList<SanPham>();

        XoaDuLieuTableSP();
        for (SanPham sp : dsSP) {
            if (Integer.parseInt(sp.getLoaiSP().charAt(sp.getLoaiSP().length() - 1) + "") == lsp_selected) {
                locTheoLSP.add(sp);
            }
        }
        if (!locTheoLSP.isEmpty()) {
            DefaultTableModel temp = (DefaultTableModel) table_sanPham.getModel();
            for (SanPham sp : locTheoLSP) {
                char loaiSP = sp.getLoaiSP().charAt(sp.getLoaiSP().length() - 1);
                Object[] obj = {sp.getMaSP(), sp.getTenSP(), cbo_loaiSP_field.getItemAt(loaiSP - '0' - 1),
                    sp.getGiaNhapHang(), sp.getGiaBan(), sp.getkM().getMuc_giam_gia()};
                temp.addRow(obj);
            }
        }
    }

//    public void LocTheoNCC() {
//        int ncc_selected = cbo_LocTheoNCC.getSelectedIndex();
//        ArrayList<SanPham> locTheoNCC = new ArrayList<>();
//        
//        for(SanPham sp : dsSP) {
//           if(Integer.parseInt(sp.getnCC().getMaNCC().charAt(sp.getnCC().getMaNCC().length() - 1) + "") == ncc_selected) {
//               locTheoNCC.add(sp);
//           }
//        }
//        
//        
//        
//        XoaDuLieuTableSP();
//        
//        if(locTheoNCC.size() != 0) {
//            DefaultTableModel temp = (DefaultTableModel) tbl_sanPham.getModel();
//            for(SanPham sp : locTheoNCC){
//                Object[] obj = {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(), 
//                    sp.getGiaNhapHang(), sp.getGiaBan(), sp.getnCC().getMaNCC(), sp.getkM().getMaKM()};
//                temp.addRow(obj);
//            }       
//        } else {
//            System.out.println("GUI.Panel_Product.LocTheoNCC()");
//        }
//    }
    public void DocDuLieuLenCBoBoxLoaiSP() {
        List<SanPham> dsSP = sp_dao.getDSSP();

        for (SanPham sp : dsSP) {
            cbo_loaiSP_field.addItem(sp.getLoaiSP());
        }
    }

    public boolean validData_SanPham() {
//        String maSP = maSP_field.getText().toString().trim();
        String tenSP = tenSP_field.getText().toString().trim();
        String giaNhap = giaNhap_field.getText().toString().trim();
        String giaBan = giaBan_field.getText().toString().trim();
        String khuyenMai = cmb_KM.getSelectedItem().toString();

//        if(maSP.isEmpty() || (!maSP.matches("^SP\\d{3}$"))){
//            JOptionPane.showMessageDialog(this, "Mã sản phẩm phải theo mẫu SP001");
//            return false;
//        }
        if (tenSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được rỗng!");
            return false;
        }
        double giaNhapHang = Double.parseDouble(giaNhap);
        if (giaNhapHang <= 0 || giaNhap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gía nhập hàng phải lớn hơn 0");
            return false;
        }
        double giaBanHang = Double.parseDouble(giaBan);
        if (giaBanHang <= 0 || giaBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gía bán hàng phải lớn hơn 0");
            return false;
        }
//        int slBayBan = bayBan.length() == 0 ? 0 : Integer.parseInt(bayBan);
//        if(slBayBan <= 0){
//            JOptionPane.showMessageDialog(this, "Số lượng bày bán phải lớn hơn 0");
//            return false;
//        }
//        int slTonKho = Integer.parseInt(tonKho);
//        if(slTonKho <= 0){
//            JOptionPane.showMessageDialog(this, "Số lượng tồn kho phải lớn hơn 0");
//            return false;
//        }
        return true;
    }

    public void loadCmbKM() {
        dsKM = km_dao.getDSKM();

        for (KhuyenMai i : dsKM) {
            cmb_KM.addItem(i.getMaKM());
        }
    }

    public void DocLieuLenTableSanPham() {
        dsSP = sp_dao.getDSSP();
        DefaultTableModel temp = (DefaultTableModel) table_sanPham.getModel();

        for (SanPham sp : dsSP) {
            char loaiSP = sp.getLoaiSP().charAt(sp.getLoaiSP().length() - 1);
            Object[] obj = {sp.getMaSP(), sp.getTenSP(), cbo_loaiSP_field.getItemAt(loaiSP - '1'),
                sp.getGiaNhapHang(), sp.getGiaBan(), sp.getkM().getMuc_giam_gia()};
            temp.addRow(obj);
        }
    }

    public void XoaDuLieuTableSP() {
        DefaultTableModel temp = (DefaultTableModel) table_sanPham.getModel();
        temp.setRowCount(0);
    }

    public SanPham createSP() {
        String maSP = sp_dao.phatSinhMaTuDong();
        String tenSP = tenSP_field.getText();
//        String cbo_loaiSP = String.valueOf(cbo_loaiSP_field.getSelectedItem());
        String cbo_loaiSP = "LSP00" + (cbo_loaiSP_field.getSelectedIndex() + 1);
        double giaNhap = Double.parseDouble(giaNhap_field.getText());
        double giaBan = Double.parseDouble(giaBan_field.getText());
//        int tonKho = Integer.parseInt(tonKho_field.getText());
//        String cbo_NCC = String.valueOf(cbo_NCC_field.getSelectedItem());
//        String cbo_NCC = "NCC00" + (cbo_NCC_field.getSelectedIndex() + 1);
        String khuyenMai = cmb_KM.getSelectedItem().toString();
        KhuyenMai km = null;
        for (KhuyenMai i : dsKM) {
            if (i.getMaKM().equals(khuyenMai)) {
                km = i;
                break;
            }
        }
        SanPham sp = new SanPham(maSP, km,
                tenSP, cbo_loaiSP, giaNhap,
                giaBan, 0);
        return sp;
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
        pnl_sanPham = new javax.swing.JPanel();
        pnl_Top = new javax.swing.JPanel();
        pnl_info = new javax.swing.JPanel();
        pnl_info1 = new javax.swing.JPanel();
        pnl_maSP = new javax.swing.JPanel();
        lbl_masp = new javax.swing.JLabel();
        maSP_field = new javax.swing.JTextField();
        pnl_KhuyenMai = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmb_KM = new javax.swing.JComboBox<>();
        pnl_info2 = new javax.swing.JPanel();
        pnl_TenSP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tenSP_field = new javax.swing.JTextField();
        pnl_GiaNhap = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        giaNhap_field = new javax.swing.JTextField();
        pnl_info3 = new javax.swing.JPanel();
        pnl_Loai = new javax.swing.JPanel();
        lbl_loai = new javax.swing.JLabel();
        cbo_loaiSP_field = new javax.swing.JComboBox<>();
        pnl_GiaBan = new javax.swing.JPanel();
        lbl_giaBan = new javax.swing.JLabel();
        giaBan_field = new javax.swing.JTextField();
        pnl_btn = new javax.swing.JPanel();
        pnl_Tim = new javax.swing.JPanel();
        maSP_txt = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        pn_Loc = new javax.swing.JPanel();
        pn_LocTheo_Loai = new javax.swing.JPanel();
        cbo_LocTheoLoai = new javax.swing.JComboBox<>();
        pnl_Center = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pn_table_SanPham = new javax.swing.JPanel();
        scroll_SanPham = new javax.swing.JScrollPane();
        table_sanPham = new javax.swing.JTable();
        pn_btn_Nhap_Xuat = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        btn_NhapFile = new javax.swing.JButton();
        btn_XuatFile = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnl_sanPham.setPreferredSize(new java.awt.Dimension(0, 220));
        pnl_sanPham.setLayout(new java.awt.BorderLayout());

        pnl_Top.setPreferredSize(new java.awt.Dimension(0, 220));
        pnl_Top.setLayout(new java.awt.BorderLayout());

        pnl_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        pnl_info.setForeground(new java.awt.Color(30, 30, 30));
        pnl_info.setPreferredSize(new java.awt.Dimension(0, 140));
        pnl_info.setLayout(new java.awt.GridLayout(1, 3));

        pnl_info1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        pnl_info1.setPreferredSize(new java.awt.Dimension(371, 100));
        pnl_info1.setLayout(new java.awt.GridLayout(2, 1));

        pnl_maSP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_maSP.setMinimumSize(new java.awt.Dimension(133, 35));
        pnl_maSP.setPreferredSize(new java.awt.Dimension(370, 35));
        pnl_maSP.setLayout(new java.awt.BorderLayout());

        lbl_masp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_masp.setText("Mã SP: ");
        lbl_masp.setPreferredSize(new java.awt.Dimension(106, 25));
        pnl_maSP.add(lbl_masp, java.awt.BorderLayout.LINE_START);

        maSP_field.setEditable(false);
        maSP_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maSP_field.setPreferredSize(new java.awt.Dimension(250, 40));
        maSP_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSP_fieldActionPerformed(evt);
            }
        });
        pnl_maSP.add(maSP_field, java.awt.BorderLayout.CENTER);

        pnl_info1.add(pnl_maSP);

        pnl_KhuyenMai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_KhuyenMai.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khuyến mãi:");
        jLabel5.setPreferredSize(new java.awt.Dimension(106, 25));
        pnl_KhuyenMai.add(jLabel5, java.awt.BorderLayout.LINE_START);

        cmb_KM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_KM.setPreferredSize(new java.awt.Dimension(250, 40));
        pnl_KhuyenMai.add(cmb_KM, java.awt.BorderLayout.CENTER);

        pnl_info1.add(pnl_KhuyenMai);

        pnl_info.add(pnl_info1);

        pnl_info2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20));
        pnl_info2.setLayout(new java.awt.GridLayout(2, 1));

        pnl_TenSP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_TenSP.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên SP:");
        jLabel3.setPreferredSize(new java.awt.Dimension(106, 25));
        pnl_TenSP.add(jLabel3, java.awt.BorderLayout.LINE_START);

        tenSP_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenSP_field.setPreferredSize(new java.awt.Dimension(250, 40));
        tenSP_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenSP_fieldActionPerformed(evt);
            }
        });
        pnl_TenSP.add(tenSP_field, java.awt.BorderLayout.CENTER);

        pnl_info2.add(pnl_TenSP);

        pnl_GiaNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_GiaNhap.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Giá nhập:");
        jLabel4.setPreferredSize(new java.awt.Dimension(106, 25));
        pnl_GiaNhap.add(jLabel4, java.awt.BorderLayout.LINE_START);

        giaNhap_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        giaNhap_field.setPreferredSize(new java.awt.Dimension(250, 40));
        giaNhap_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaNhap_fieldActionPerformed(evt);
            }
        });
        pnl_GiaNhap.add(giaNhap_field, java.awt.BorderLayout.CENTER);

        pnl_info2.add(pnl_GiaNhap);

        pnl_info.add(pnl_info2);

        pnl_info3.setPreferredSize(new java.awt.Dimension(350, 150));
        pnl_info3.setLayout(new java.awt.GridLayout(2, 1));

        pnl_Loai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_Loai.setLayout(new java.awt.BorderLayout());

        lbl_loai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_loai.setText("Loại:");
        lbl_loai.setPreferredSize(new java.awt.Dimension(74, 25));
        pnl_Loai.add(lbl_loai, java.awt.BorderLayout.LINE_START);

        cbo_loaiSP_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbo_loaiSP_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SGK", "Truyện", "Tiểu thuyết", "Văn phòng phẩm", "Dụng cụ học tập" }));
        cbo_loaiSP_field.setPreferredSize(new java.awt.Dimension(250, 40));
        pnl_Loai.add(cbo_loaiSP_field, java.awt.BorderLayout.CENTER);

        pnl_info3.add(pnl_Loai);

        pnl_GiaBan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pnl_GiaBan.setLayout(new java.awt.BorderLayout());

        lbl_giaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_giaBan.setText("Giá bán:");
        lbl_giaBan.setPreferredSize(new java.awt.Dimension(74, 25));
        pnl_GiaBan.add(lbl_giaBan, java.awt.BorderLayout.LINE_START);

        giaBan_field.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        giaBan_field.setPreferredSize(new java.awt.Dimension(250, 40));
        giaBan_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaBan_fieldActionPerformed(evt);
            }
        });
        pnl_GiaBan.add(giaBan_field, java.awt.BorderLayout.CENTER);

        pnl_info3.add(pnl_GiaBan);

        pnl_info.add(pnl_info3);

        pnl_Top.add(pnl_info, java.awt.BorderLayout.NORTH);

        pnl_btn.setPreferredSize(new java.awt.Dimension(1112, 70));
        pnl_btn.setLayout(new java.awt.GridLayout(1, 2));

        pnl_Tim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        pnl_Tim.setLayout(new java.awt.BorderLayout());

        maSP_txt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maSP_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSP_txtActionPerformed(evt);
            }
        });
        pnl_Tim.add(maSP_txt, java.awt.BorderLayout.CENTER);

        btn_timKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timKiem.setText("Tìm kiếm");
        btn_timKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timKiemMouseClicked(evt);
            }
        });
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });
        pnl_Tim.add(btn_timKiem, java.awt.BorderLayout.EAST);

        pnl_btn.add(pnl_Tim);

        pn_Loc.setPreferredSize(new java.awt.Dimension(940, 150));
        pn_Loc.setLayout(new java.awt.GridLayout(1, 3));

        pn_LocTheo_Loai.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo loại sản phẩm"));
        pn_LocTheo_Loai.setLayout(new java.awt.BorderLayout());

        cbo_LocTheoLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbo_LocTheoLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn loại sản phẩm --", "SGK", "Truyện", "Tiểu thuyết", "Văn phòng phẩm", "Dụng cụ học tập" }));
        cbo_LocTheoLoai.setPreferredSize(new java.awt.Dimension(150, 35));
        cbo_LocTheoLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_LocTheoLoaiItemStateChanged(evt);
            }
        });
        cbo_LocTheoLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_LocTheoLoaiActionPerformed(evt);
            }
        });
        pn_LocTheo_Loai.add(cbo_LocTheoLoai, java.awt.BorderLayout.CENTER);

        pn_Loc.add(pn_LocTheo_Loai);

        pnl_btn.add(pn_Loc);

        pnl_Top.add(pnl_btn, java.awt.BorderLayout.CENTER);

        pnl_sanPham.add(pnl_Top, java.awt.BorderLayout.NORTH);

        pnl_Center.setLayout(new java.awt.BorderLayout());
        pnl_sanPham.add(pnl_Center, java.awt.BorderLayout.CENTER);

        add(pnl_sanPham, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(1000, 200));
        jPanel9.setLayout(new java.awt.BorderLayout());

        pn_table_SanPham.setPreferredSize(new java.awt.Dimension(940, 200));
        pn_table_SanPham.setLayout(new java.awt.BorderLayout());

        table_sanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Giá Nhập", "Giá Bán", "Khuyến Mãi"
            }
        ));
        table_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sanPhamMouseClicked(evt);
            }
        });
        scroll_SanPham.setViewportView(table_sanPham);

        pn_table_SanPham.add(scroll_SanPham, java.awt.BorderLayout.CENTER);

        pn_btn_Nhap_Xuat.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.setPreferredSize(new java.awt.Dimension(130, 50));
        pn_btn_Nhap_Xuat.add(btn_Them);

        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        pn_btn_Nhap_Xuat.add(btn_Xoa);

        btn_CapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_CapNhat.setText("Cập Nhật");
        btn_CapNhat.setPreferredSize(new java.awt.Dimension(130, 50));
        pn_btn_Nhap_Xuat.add(btn_CapNhat);

        btn_NhapFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_NhapFile.setText("Nhập File");
        btn_NhapFile.setPreferredSize(new java.awt.Dimension(130, 50));
        pn_btn_Nhap_Xuat.add(btn_NhapFile);

        btn_XuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XuatFile.setText("Xuất File");
        btn_XuatFile.setPreferredSize(new java.awt.Dimension(130, 50));
        pn_btn_Nhap_Xuat.add(btn_XuatFile);

        pn_table_SanPham.add(pn_btn_Nhap_Xuat, java.awt.BorderLayout.SOUTH);

        jPanel9.add(pn_table_SanPham, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel9, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void maSP_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSP_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSP_fieldActionPerformed

    private void giaNhap_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaNhap_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giaNhap_fieldActionPerformed

    private void tenSP_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenSP_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenSP_fieldActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void maSP_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSP_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSP_txtActionPerformed

    private void giaBan_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaBan_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giaBan_fieldActionPerformed

    private void table_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sanPhamMouseClicked
        // TODO add your handling code here:
        int r = table_sanPham.getSelectedRow();

        if (r >= 0) {
            maSP_field.setText(table_sanPham.getValueAt(r, 0).toString());
            tenSP_field.setText(table_sanPham.getValueAt(r, 1).toString());
            giaNhap_field.setText(table_sanPham.getValueAt(r, 3).toString());
            giaBan_field.setText(table_sanPham.getValueAt(r, 4).toString());
            String maKM = "";
            for (KhuyenMai i : dsKM) {
                if (i.getMuc_giam_gia() == Double.parseDouble(table_sanPham.getValueAt(r, 5).toString())) {
                    maKM = i.getMaKM();
                    break;
                }
            }
            cmb_KM.setSelectedItem(maKM);
            cbo_loaiSP_field.setSelectedItem(table_sanPham.getValueAt(r, 2).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng muốn thao tác!");
        }
    }//GEN-LAST:event_table_sanPhamMouseClicked

    private void btn_timKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timKiemMouseClicked
        // TODO add your handling code here:
        String maSP_searched = maSP_txt.getText().toString();

        if (!maSP_searched.trim().equals("")) {
            XoaDuLieuTableSP();

            SanPham sp = sp_dao.getSP_TheoMa(maSP_searched);
            DefaultTableModel temp = (DefaultTableModel) table_sanPham.getModel();
            if (sp == null) {
                return;
            }
            Object[] obj = {sp.getMaSP(), sp.getTenSP(), sp.getLoaiSP(),
                sp.getGiaNhapHang(), sp.getGiaBan(), sp.getkM().getMaKM()};
            temp.addRow(obj);
        } else {
            XoaDuLieuTableSP();
            DocLieuLenTableSanPham();
        }

    }//GEN-LAST:event_btn_timKiemMouseClicked

    private void cbo_LocTheoLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_LocTheoLoaiItemStateChanged
        // TODO add your handling code here:
        LocTheoLSP();
    }//GEN-LAST:event_cbo_LocTheoLoaiItemStateChanged

    private void cbo_LocTheoLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_LocTheoLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_LocTheoLoaiActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_NhapFile;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XuatFile;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_LocTheoLoai;
    private javax.swing.JComboBox<String> cbo_loaiSP_field;
    private javax.swing.JComboBox<String> cmb_KM;
    private javax.swing.JTextField giaBan_field;
    private javax.swing.JTextField giaNhap_field;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_loai;
    private javax.swing.JLabel lbl_masp;
    private javax.swing.JTextField maSP_field;
    private javax.swing.JTextField maSP_txt;
    private javax.swing.JPanel pn_Loc;
    private javax.swing.JPanel pn_LocTheo_Loai;
    private javax.swing.JPanel pn_btn_Nhap_Xuat;
    private javax.swing.JPanel pn_table_SanPham;
    private javax.swing.JPanel pnl_Center;
    private javax.swing.JPanel pnl_GiaBan;
    private javax.swing.JPanel pnl_GiaNhap;
    private javax.swing.JPanel pnl_KhuyenMai;
    private javax.swing.JPanel pnl_Loai;
    private javax.swing.JPanel pnl_TenSP;
    private javax.swing.JPanel pnl_Tim;
    private javax.swing.JPanel pnl_Top;
    private javax.swing.JPanel pnl_btn;
    private javax.swing.JPanel pnl_info;
    private javax.swing.JPanel pnl_info1;
    private javax.swing.JPanel pnl_info2;
    private javax.swing.JPanel pnl_info3;
    private javax.swing.JPanel pnl_maSP;
    private javax.swing.JPanel pnl_sanPham;
    private javax.swing.JScrollPane scroll_SanPham;
    private javax.swing.JTable table_sanPham;
    private javax.swing.JTextField tenSP_field;
    // End of variables declaration//GEN-END:variables
}
