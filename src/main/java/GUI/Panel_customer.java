/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.Rank;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MyPC
 */
public class Panel_customer extends javax.swing.JPanel {
 private KhachHang_DAO kh_dao = new KhachHang_DAO();
    /**
     * Creates new form Panel_KhachHang
     */
    public Panel_customer() {
        initComponents();
        
//        DocuLieuLenTable();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_ThongTin = new javax.swing.JPanel();
        panel_ThongTin = new javax.swing.JPanel();
        thongTin1 = new javax.swing.JPanel();
        panel_maKH = new javax.swing.JPanel();
        label_maKH = new javax.swing.JLabel();
        text_maKH = new javax.swing.JTextField();
        panel_diaChi = new javax.swing.JPanel();
        label_diaChi = new javax.swing.JLabel();
        text_diaChi = new javax.swing.JTextField();
        thongTin2 = new javax.swing.JPanel();
        panel_tenKH = new javax.swing.JPanel();
        label_tenKH = new javax.swing.JLabel();
        text_tenKH = new javax.swing.JTextField();
        panel_email = new javax.swing.JPanel();
        label_email = new javax.swing.JLabel();
        text_email = new javax.swing.JTextField();
        thongTin3 = new javax.swing.JPanel();
        panel_rank = new javax.swing.JPanel();
        label_rank = new javax.swing.JLabel();
        txt_Rank = new javax.swing.JTextField();
        panel_tichDiem = new javax.swing.JPanel();
        label_tichDiem = new javax.swing.JLabel();
        text_tichDiem = new javax.swing.JTextField();
        thongTin4 = new javax.swing.JPanel();
        panel_sĐT = new javax.swing.JPanel();
        label_sĐT = new javax.swing.JLabel();
        text_sĐT = new javax.swing.JTextField();
        panel_tieuPhi = new javax.swing.JPanel();
        label_tieuPhiTichLuy = new javax.swing.JLabel();
        text_tieuPhiTichLuy = new javax.swing.JTextField();
        panel_btn = new javax.swing.JPanel();
        pnl_tim = new javax.swing.JPanel();
        text_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        pnl_LocTheoRank = new javax.swing.JPanel();
        cbb_locTheoRank = new javax.swing.JComboBox<>();
        pnl_center = new javax.swing.JPanel();
        panel_bangThongTin = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();
        pnl_CRUD = new javax.swing.JPanel();
        btn_capNhat = new javax.swing.JButton();
        btn_xoaTrang = new javax.swing.JButton();
        btn_ThemMoi = new javax.swing.JButton();
        btn_NhapFile = new javax.swing.JButton();
        btn_XuatFile = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(100, 500));
        setLayout(new java.awt.BorderLayout());

        Panel_ThongTin.setMinimumSize(new java.awt.Dimension(600, 85));
        Panel_ThongTin.setPreferredSize(new java.awt.Dimension(903, 250));
        Panel_ThongTin.setLayout(new java.awt.BorderLayout());

        panel_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        panel_ThongTin.setPreferredSize(new java.awt.Dimension(750, 160));
        panel_ThongTin.setLayout(new java.awt.GridLayout(1, 3));

        thongTin1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        thongTin1.setPreferredSize(new java.awt.Dimension(300, 350));
        thongTin1.setLayout(new java.awt.GridLayout(2, 1));

        panel_maKH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_maKH.setLayout(new java.awt.BorderLayout());

        label_maKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_maKH.setText("Mã KH:");
        label_maKH.setPreferredSize(new java.awt.Dimension(60, 20));
        panel_maKH.add(label_maKH, java.awt.BorderLayout.LINE_START);

        text_maKH.setEditable(false);
        text_maKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_maKH.setPreferredSize(new java.awt.Dimension(300, 40));
        text_maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_maKHActionPerformed(evt);
            }
        });
        panel_maKH.add(text_maKH, java.awt.BorderLayout.CENTER);

        thongTin1.add(panel_maKH);

        panel_diaChi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_diaChi.setLayout(new java.awt.BorderLayout());

        label_diaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_diaChi.setText("Địa chỉ:");
        label_diaChi.setPreferredSize(new java.awt.Dimension(60, 20));
        panel_diaChi.add(label_diaChi, java.awt.BorderLayout.LINE_START);

        text_diaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_diaChi.setPreferredSize(new java.awt.Dimension(300, 40));
        panel_diaChi.add(text_diaChi, java.awt.BorderLayout.CENTER);
        text_diaChi.getAccessibleContext().setAccessibleName("");

        thongTin1.add(panel_diaChi);

        panel_ThongTin.add(thongTin1);

        thongTin2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        thongTin2.setLayout(new java.awt.GridLayout(2, 1));

        panel_tenKH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_tenKH.setLayout(new java.awt.BorderLayout());

        label_tenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_tenKH.setText("Tên KH:");
        label_tenKH.setPreferredSize(new java.awt.Dimension(60, 25));
        panel_tenKH.add(label_tenKH, java.awt.BorderLayout.LINE_START);

        text_tenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_tenKH.setPreferredSize(new java.awt.Dimension(300, 40));
        panel_tenKH.add(text_tenKH, java.awt.BorderLayout.CENTER);

        thongTin2.add(panel_tenKH);

        panel_email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_email.setLayout(new java.awt.BorderLayout());

        label_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_email.setText("Email:");
        label_email.setPreferredSize(new java.awt.Dimension(60, 25));
        panel_email.add(label_email, java.awt.BorderLayout.LINE_START);

        text_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_email.setPreferredSize(new java.awt.Dimension(300, 40));
        text_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_emailActionPerformed(evt);
            }
        });
        panel_email.add(text_email, java.awt.BorderLayout.CENTER);

        thongTin2.add(panel_email);

        panel_ThongTin.add(thongTin2);

        thongTin3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        thongTin3.setLayout(new java.awt.GridLayout(2, 1));

        panel_rank.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_rank.setLayout(new java.awt.BorderLayout());

        label_rank.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_rank.setText("Rank:");
        label_rank.setPreferredSize(new java.awt.Dimension(100, 25));
        panel_rank.add(label_rank, java.awt.BorderLayout.LINE_START);

        txt_Rank.setEditable(false);
        txt_Rank.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_Rank.setPreferredSize(new java.awt.Dimension(300, 40));
        panel_rank.add(txt_Rank, java.awt.BorderLayout.CENTER);

        thongTin3.add(panel_rank);

        panel_tichDiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_tichDiem.setLayout(new java.awt.BorderLayout());

        label_tichDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_tichDiem.setText("Điểm tích lũy:");
        label_tichDiem.setPreferredSize(new java.awt.Dimension(100, 20));
        panel_tichDiem.add(label_tichDiem, java.awt.BorderLayout.LINE_START);

        text_tichDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_tichDiem.setPreferredSize(new java.awt.Dimension(300, 40));
        text_tichDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tichDiemActionPerformed(evt);
            }
        });
        panel_tichDiem.add(text_tichDiem, java.awt.BorderLayout.CENTER);

        thongTin3.add(panel_tichDiem);

        panel_ThongTin.add(thongTin3);

        thongTin4.setLayout(new java.awt.GridLayout(2, 1));

        panel_sĐT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_sĐT.setLayout(new java.awt.BorderLayout());

        label_sĐT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_sĐT.setText("SĐT:");
        label_sĐT.setPreferredSize(new java.awt.Dimension(70, 25));
        panel_sĐT.add(label_sĐT, java.awt.BorderLayout.LINE_START);

        text_sĐT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_sĐT.setPreferredSize(new java.awt.Dimension(300, 40));
        panel_sĐT.add(text_sĐT, java.awt.BorderLayout.CENTER);

        thongTin4.add(panel_sĐT);

        panel_tieuPhi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        panel_tieuPhi.setLayout(new java.awt.BorderLayout());

        label_tieuPhiTichLuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_tieuPhiTichLuy.setText("Tiêu Phí:");
        label_tieuPhiTichLuy.setPreferredSize(new java.awt.Dimension(70, 20));
        panel_tieuPhi.add(label_tieuPhiTichLuy, java.awt.BorderLayout.LINE_START);

        text_tieuPhiTichLuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_tieuPhiTichLuy.setPreferredSize(new java.awt.Dimension(300, 40));
        text_tieuPhiTichLuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tieuPhiTichLuyActionPerformed(evt);
            }
        });
        panel_tieuPhi.add(text_tieuPhiTichLuy, java.awt.BorderLayout.CENTER);

        thongTin4.add(panel_tieuPhi);

        panel_ThongTin.add(thongTin4);

        Panel_ThongTin.add(panel_ThongTin, java.awt.BorderLayout.CENTER);

        panel_btn.setPreferredSize(new java.awt.Dimension(903, 100));
        panel_btn.setLayout(new java.awt.GridLayout(1, 2));

        pnl_tim.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        pnl_tim.setLayout(new java.awt.BorderLayout());

        text_timKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        text_timKiem.setPreferredSize(new java.awt.Dimension(100, 22));
        pnl_tim.add(text_timKiem, java.awt.BorderLayout.CENTER);

        btn_timKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_timKiem.setPreferredSize(new java.awt.Dimension(55, 50));
        btn_timKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timKiemMouseClicked(evt);
            }
        });
        pnl_tim.add(btn_timKiem, java.awt.BorderLayout.EAST);

        panel_btn.add(pnl_tim);

        pnl_LocTheoRank.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc Theo Rank"));
        pnl_LocTheoRank.setLayout(new java.awt.GridLayout(1, 1));

        cbb_locTheoRank.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbb_locTheoRank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Chọn Rank --", "Đồng", "Bạc", "Vàng", "Kim Cương" }));
        cbb_locTheoRank.setPreferredSize(new java.awt.Dimension(140, 35));
        cbb_locTheoRank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_locTheoRankItemStateChanged(evt);
            }
        });
        cbb_locTheoRank.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cbb_locTheoRankCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        pnl_LocTheoRank.add(cbb_locTheoRank);

        panel_btn.add(pnl_LocTheoRank);

        Panel_ThongTin.add(panel_btn, java.awt.BorderLayout.SOUTH);

        add(Panel_ThongTin, java.awt.BorderLayout.NORTH);

        pnl_center.setPreferredSize(new java.awt.Dimension(1350, 500));
        pnl_center.setLayout(new java.awt.BorderLayout());

        panel_bangThongTin.setPreferredSize(new java.awt.Dimension(1000, 350));
        panel_bangThongTin.setLayout(new java.awt.BorderLayout());

        table_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Địa Chỉ", "SĐT", "Email", "Tiêu Phí", "Rank", "Điển tích Lũy"
            }
        ));
        table_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_khMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_kh);

        panel_bangThongTin.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnl_CRUD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_capNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_capNhat.setText("Cập Nhật");
        btn_capNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_capNhat.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_capNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_capNhatMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_capNhat);

        btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoaTrang.setText("Xóa Trắng");
        btn_xoaTrang.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_xoaTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoaTrangMouseClicked(evt);
            }
        });
        pnl_CRUD.add(btn_xoaTrang);

        btn_ThemMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ThemMoi.setText("Thêm mới");
        btn_ThemMoi.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_ThemMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMoiMouseClicked(evt);
            }
        });
        btn_ThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemMoiActionPerformed(evt);
            }
        });
        pnl_CRUD.add(btn_ThemMoi);

        btn_NhapFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_NhapFile.setText("Nhập File");
        btn_NhapFile.setPreferredSize(new java.awt.Dimension(130, 50));
        btn_NhapFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NhapFileMouseClicked(evt);
            }
        });
        btn_NhapFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapFileActionPerformed(evt);
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
        btn_XuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatFileActionPerformed(evt);
            }
        });
        pnl_CRUD.add(btn_XuatFile);

        panel_bangThongTin.add(pnl_CRUD, java.awt.BorderLayout.PAGE_END);

        pnl_center.add(panel_bangThongTin, java.awt.BorderLayout.CENTER);

        add(pnl_center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void text_maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_maKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_maKHActionPerformed

    private void text_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_emailActionPerformed

    private void text_tieuPhiTichLuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tieuPhiTichLuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tieuPhiTichLuyActionPerformed

    private void text_tichDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tichDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tichDiemActionPerformed

    private void table_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_khMouseClicked
        // TODO add your handling code here:
        int r = table_kh.getSelectedRow();
        
        if(r >= 0){
            text_maKH.setText(table_kh.getValueAt(r, 0).toString());
            text_diaChi.setText(table_kh.getValueAt(r, 2) == null ? "" : table_kh.getValueAt(r, 2).toString());
            text_tenKH.setText(table_kh.getValueAt(r, 1).toString());
            text_sĐT.setText(table_kh.getValueAt(r, 3).toString());
            text_email.setText(table_kh.getValueAt(r, 4).toString());
            text_tieuPhiTichLuy.setText(table_kh.getValueAt(r, 5) == null 
                    ? "" : table_kh.getValueAt(r, 5).toString());
            txt_Rank.setText(table_kh.getValueAt(r, 6).toString());
            text_tichDiem.setText(table_kh.getValueAt(r, 7).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng muốn thao tác!");
        }
        
        
    }//GEN-LAST:event_table_khMouseClicked

    private void btn_xoaTrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaTrangMouseClicked
        // TODO add your handling code here:
        text_maKH.setText("");
        text_tenKH.setText("");
        text_diaChi.setText("");
        text_email.setText("");
        text_sĐT.setText("");
        text_tieuPhiTichLuy.setText("");
        text_tichDiem.setText("");
    }//GEN-LAST:event_btn_xoaTrangMouseClicked

    private void btn_timKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timKiemMouseClicked
        // TODO add your handling code here:
        if(text_timKiem.getText().trim().equals("")) {
            XoaDuLieuTableSP();
            DocuLieuLenTable();
        } else {
            KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
            String maKH_tim = text_timKiem.getText();
            KhachHang kh = khachHang_DAO.getKH_TheoMa(maKH_tim);
            if(kh != null){
    //            JOptionPane.showMessageDialog(this, "Đã tìm thấy khách hàng!");
                XoaDuLieuTableSP();
                DefaultTableModel tmp = (DefaultTableModel) table_kh.getModel();
                Object[] obj = {kh.getMaKH(), kh.getLast_name() ,kh.getSDT(), kh.getEmail(),
                                kh.getTieuPhiTichLuy(), kh.getRank(), kh.getTichDiem()};

                tmp.addRow(obj);
            }else{
                JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!");
            }
        }
    }//GEN-LAST:event_btn_timKiemMouseClicked

    private void btn_ThemMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMoiMouseClicked
        // TODO add your handling code here:
        if(validData_KhachHang()){
            KhachHang kh = createKH();
            ArrayList<KhachHang> dsKH = kh_dao.getAllKH();
            
            if(true){
                if(kh_dao.Them_KH(kh)){
                    XoaDuLieuTableSP();
                    DocuLieuLenTable();
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                }else{
                    JOptionPane.showMessageDialog(this, "Thêm thất bại! Có lỗi xảy ra");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại! Vui lòng kiểm tra lại");
            }
        }
    }//GEN-LAST:event_btn_ThemMoiMouseClicked

    private void btn_capNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_capNhatMouseClicked
        // TODO add your handling code here:
        int r = table_kh.getSelectedRow();
        if(r < 0){
            JOptionPane.showMessageDialog(this, "Cần chọn sản phẩm cần cập nhật!");
        }
        
        if(validData_KhachHang()){
            KhachHang kh = createKH();
            
            if(kh_dao.Update_customer(kh)){
                DefaultTableModel temp = (DefaultTableModel) table_kh.getModel();
                temp.removeRow(r);
                Object[] obj = {kh.getMaKH(), kh.getLast_name(),kh.getSDT(), kh.getEmail(),
                                kh.getTieuPhiTichLuy(), kh.getRank(), kh.getTichDiem()};
                temp.insertRow(r, obj);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!!!");
            }else{
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!Có lỗi xảy ra!!");
            }
        }
    }//GEN-LAST:event_btn_capNhatMouseClicked

    private void cbb_locTheoRankCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cbb_locTheoRankCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_locTheoRankCaretPositionChanged

    private void cbb_locTheoRankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_locTheoRankItemStateChanged
        // TODO add your handling code here:
        int n = cbb_locTheoRank.getSelectedIndex();
        
        if(n != 0) {
            String maRank = n == 1 ? "R001" 
                    : n == 2 ? "R002"
                    : n == 3 ? "R003"
                    : "R004";

            ArrayList<KhachHang> dsKH_TheoRnk = kh_dao.getKH_TheoRank(maRank);

            XoaDuLieuTableSP();

            DefaultTableModel tmp = (DefaultTableModel) table_kh.getModel();
            for(KhachHang kh : dsKH_TheoRnk) {
                String a = kh.getRank().getMaRank();
                 String Rank = a.equals("R001") ? "Đồng"
                        : a.equals("R002") ? "Bạc"
                        : a.equals("R003") ? "Vàng"
                        : "Kim Cương";

                Object[] obj = {kh.getMaKH(), kh.getLast_name(),kh.getSDT(), kh.getEmail(),
                                kh.getTieuPhiTichLuy(), Rank, kh.getTichDiem()};

                tmp.addRow(obj);
            }
        } else {
            XoaDuLieuTableSP();
            DocuLieuLenTable();
        }
    }//GEN-LAST:event_cbb_locTheoRankItemStateChanged

    private void btn_ThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemMoiActionPerformed

    private void btn_NhapFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NhapFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NhapFileMouseClicked

    private void btn_NhapFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NhapFileActionPerformed

    private void btn_XuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XuatFileMouseClicked

    private void btn_XuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XuatFileActionPerformed

    public void DocuLieuLenTable() {
        ArrayList<KhachHang> dsKH = kh_dao.getAllKH();
        
        


        DefaultTableModel tmp = (DefaultTableModel) table_kh.getModel();
        for(KhachHang kh : dsKH) {
            String a = kh.getRank().getMaRank();
            String Rank = a.equals("R001") ? "Đồng"
                    : a.equals("R002") ? "Bạc"
                    : a.equals("R003") ? "Vàng"
                    : "Kim Cương";
            
            Object[] obj = {kh.getMaKH(), kh.getLast_name(), kh.getSDT(), kh.getEmail(),
                            kh.getTieuPhiTichLuy(), Rank, kh.getTichDiem()};

            tmp.addRow(obj);
        }
    }
    
    public void XoaDuLieuTableSP(){
            DefaultTableModel temp = (DefaultTableModel) table_kh.getModel();
            temp.getDataVector().removeAllElements();
    }

    public boolean validData_KhachHang(){
        String maKH = text_maKH.getText().toString().trim();
        String tenKH = text_tenKH.getText().toString().trim();
        String diaChi = text_diaChi.getText().toString().trim();
        String email = text_email.getText().toString().trim();
        String sDT = text_sĐT.getText().toString().trim();
        String tieuPhi = text_tieuPhiTichLuy.getText().toString().trim();
        String đTL = text_tichDiem.getText().toString().trim();
        if(maKH.isEmpty() || (!maKH.matches("^KH\\d{3}$"))){
            JOptionPane.showMessageDialog(this, "Mã khách hàng phải theo mẫu KH001");
            return false;
        }
        if(tenKH.isEmpty()){
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng!");
            return false;
        }

        if(diaChi.isEmpty()){
            JOptionPane.showMessageDialog(this, "Địa  chỉ không được rỗng!");
            return false;
        }
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Email không được rỗng!");
            return false;
        }
        if(sDT.isEmpty()){
            JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
            return false;
        }
        double tichDiem = Double.parseDouble(đTL);
        if(tichDiem <= 0 || đTL.isEmpty()){
            JOptionPane.showMessageDialog(this, "Điểm tích lũy phải lớn hơn 0");
            return false;
        }
        double tieuPhiTichLuy = Double.parseDouble(tieuPhi);
        if(tieuPhiTichLuy <= 0 || tieuPhi.isEmpty()){
            JOptionPane.showMessageDialog(this, "Điểm tích lũy phải lớn hơn 0");
            return false;
        }

        return true;
    }
    
    public KhachHang createKH(){
        String maKH = text_maKH.getText();
        String tenKH = text_tenKH.getText();
        String diaChi = text_diaChi.getText();
        String sDT = text_sĐT.getText();
        String email = text_email.getText();
        double tieuPhiTichLuy = Double.parseDouble(text_tieuPhiTichLuy.getText());
        String cb_rank = "R001";
        double tichDiem = Double.parseDouble(text_tichDiem.getText());
        
        KhachHang kh = null;
        return kh;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_ThongTin;
    private javax.swing.JButton btn_NhapFile;
    private javax.swing.JButton btn_ThemMoi;
    private javax.swing.JButton btn_XuatFile;
    private javax.swing.JButton btn_capNhat;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoaTrang;
    private javax.swing.JComboBox<String> cbb_locTheoRank;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_diaChi;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_maKH;
    private javax.swing.JLabel label_rank;
    private javax.swing.JLabel label_sĐT;
    private javax.swing.JLabel label_tenKH;
    private javax.swing.JLabel label_tichDiem;
    private javax.swing.JLabel label_tieuPhiTichLuy;
    private javax.swing.JPanel panel_ThongTin;
    private javax.swing.JPanel panel_bangThongTin;
    private javax.swing.JPanel panel_btn;
    private javax.swing.JPanel panel_diaChi;
    private javax.swing.JPanel panel_email;
    private javax.swing.JPanel panel_maKH;
    private javax.swing.JPanel panel_rank;
    private javax.swing.JPanel panel_sĐT;
    private javax.swing.JPanel panel_tenKH;
    private javax.swing.JPanel panel_tichDiem;
    private javax.swing.JPanel panel_tieuPhi;
    private javax.swing.JPanel pnl_CRUD;
    private javax.swing.JPanel pnl_LocTheoRank;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_tim;
    private javax.swing.JTable table_kh;
    private javax.swing.JTextField text_diaChi;
    private javax.swing.JTextField text_email;
    private javax.swing.JTextField text_maKH;
    private javax.swing.JTextField text_sĐT;
    private javax.swing.JTextField text_tenKH;
    private javax.swing.JTextField text_tichDiem;
    private javax.swing.JTextField text_tieuPhiTichLuy;
    private javax.swing.JTextField text_timKiem;
    private javax.swing.JPanel thongTin1;
    private javax.swing.JPanel thongTin2;
    private javax.swing.JPanel thongTin3;
    private javax.swing.JPanel thongTin4;
    private javax.swing.JTextField txt_Rank;
    // End of variables declaration//GEN-END:variables
}
