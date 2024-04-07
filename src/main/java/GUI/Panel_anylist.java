/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Panel_anylist extends javax.swing.JPanel {
    private HoaDon_DAO hd_dao = new HoaDon_DAO();
    private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
   
    public Panel_anylist() {
        initComponents();
        
//        DoculieuLenTable_TKDT();
//        DocuLieuLenTable_SPBC();
    }
    
//    public void DocuLieuLenTable_SPBC() {
//        ArrayList<ChiTietHoaDon> dsCTHD = cthd_dao.ThongKe_SP_BanChay();
//        DefaultTableModel temp = (DefaultTableModel) table_SP_BanChay.getModel();
//        
//        for(ChiTietHoaDon cthd : dsCTHD) {
//            Object[] obj = {cthd.getSanPham().getMaSP(), cthd.getSanPham().getTenSP(), 
//                cthd.getSoLuong(), cthd.getTong_tien(),cthd.getSanPham().getGiaNhapHang(), 
//                cthd.getTong_tien()- cthd.getSanPham().getGiaNhapHang() };
//            
//            temp.addRow(obj);
//        }
//    }
    
    public void DoculieuLenTable_TKDT() {
        double tongDoanhThu = 0;
        double tongVon = 0;
        
        ArrayList<HoaDon> dsHD = hd_dao.getAllHD();
        DefaultTableModel temp = (DefaultTableModel) table_DSHD.getModel();
        
        for(HoaDon hd : dsHD) {
            Object[] obj = {hd.getMaHD(), hd.getDate(), hd.getTien_von(), hd.getTong_tien(), 
                hd.getTong_tien()- hd.getTien_von()};
            temp.addRow(obj);
            tongDoanhThu += hd.getTong_tien();
            tongVon += hd.getTien_von();
        }
        
        lbl_TongHD.setText(dsHD.size() + "");
        lbl_DoanhThu.setText(tongDoanhThu + "");
        lbl_TongVon.setText(tongVon + "");
        lbl_LoiNhuan.setText(tongDoanhThu - tongVon + "");
    }
    
    public void XoaHetDuLieu() {
        DefaultTableModel temp = (DefaultTableModel) table_DSHD.getModel();
        temp.getDataVector().removeAllElements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_ThongKeDoanhThu = new javax.swing.JPanel();
        pnl_top = new javax.swing.JPanel();
        pnl_TKDT_info = new javax.swing.JPanel();
        pnl_NgayBatDau = new javax.swing.JPanel();
        lbl_NgayBatDau = new javax.swing.JLabel();
        date_NgayBatDau = new com.toedter.calendar.JDateChooser();
        pnl_NgayKetThuc = new javax.swing.JPanel();
        lbl_NgayKetThuc = new javax.swing.JLabel();
        date_NgayKetThuc = new com.toedter.calendar.JDateChooser();
        pn_LoaiThongKe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_LoaiThongKe = new javax.swing.JComboBox<>();
        pnl_btn_TimKiem = new javax.swing.JPanel();
        btn_TimKiem = new javax.swing.JButton();
        pnl_center = new javax.swing.JPanel();
        pnl_SoLieu_TKDT = new javax.swing.JPanel();
        pnl_TongHD = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_TongHD_title = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_TongHD = new javax.swing.JLabel();
        pnl_DoanhThu = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbl_DoanhThu_title1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_DoanhThu = new javax.swing.JLabel();
        pnl_TongVon = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbl_TongVon_title = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbl_TongVon = new javax.swing.JLabel();
        pnl_LoiNhuan = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lbl_LoiNhuan_title = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_LoiNhuan = new javax.swing.JLabel();
        pnl_tabel_TKDT = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_DSHD = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnl_ThongKeDoanhThu.setLayout(new java.awt.BorderLayout());

        pnl_top.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc"));
        pnl_top.setPreferredSize(new java.awt.Dimension(0, 150));
        pnl_top.setLayout(new java.awt.BorderLayout());

        pnl_TKDT_info.setPreferredSize(new java.awt.Dimension(0, 60));
        pnl_TKDT_info.setLayout(new java.awt.GridLayout(1, 3));

        pnl_NgayBatDau.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 20));
        pnl_NgayBatDau.setLayout(new java.awt.BorderLayout());

        lbl_NgayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_NgayBatDau.setText("Ngày bắt đầu:");
        pnl_NgayBatDau.add(lbl_NgayBatDau, java.awt.BorderLayout.LINE_START);

        date_NgayBatDau.setPreferredSize(new java.awt.Dimension(220, 40));
        pnl_NgayBatDau.add(date_NgayBatDau, java.awt.BorderLayout.CENTER);

        pnl_TKDT_info.add(pnl_NgayBatDau);

        pnl_NgayKetThuc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 20));
        pnl_NgayKetThuc.setLayout(new java.awt.BorderLayout());

        lbl_NgayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_NgayKetThuc.setText("Ngày kết thúc:");
        pnl_NgayKetThuc.add(lbl_NgayKetThuc, java.awt.BorderLayout.LINE_START);

        date_NgayKetThuc.setPreferredSize(new java.awt.Dimension(220, 40));
        pnl_NgayKetThuc.add(date_NgayKetThuc, java.awt.BorderLayout.CENTER);

        pnl_TKDT_info.add(pnl_NgayKetThuc);

        pn_LoaiThongKe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        pn_LoaiThongKe.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thống Kê Theo:");
        pn_LoaiThongKe.add(jLabel2, java.awt.BorderLayout.LINE_START);

        cb_LoaiThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cb_LoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doanh Thu", "Sản Phẩm" }));
        pn_LoaiThongKe.add(cb_LoaiThongKe, java.awt.BorderLayout.CENTER);

        pnl_TKDT_info.add(pn_LoaiThongKe);

        pnl_top.add(pnl_TKDT_info, java.awt.BorderLayout.NORTH);

        pnl_btn_TimKiem.setPreferredSize(new java.awt.Dimension(1068, 80));

        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setPreferredSize(new java.awt.Dimension(500, 40));
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });
        pnl_btn_TimKiem.add(btn_TimKiem);

        pnl_top.add(pnl_btn_TimKiem, java.awt.BorderLayout.CENTER);

        pnl_ThongKeDoanhThu.add(pnl_top, java.awt.BorderLayout.NORTH);

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_SoLieu_TKDT.setPreferredSize(new java.awt.Dimension(0, 150));
        pnl_SoLieu_TKDT.setLayout(new java.awt.GridLayout(1, 4));

        pnl_TongHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnl_TongHD.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        lbl_TongHD_title.setBackground(new java.awt.Color(255, 255, 102));
        lbl_TongHD_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TongHD_title.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongHD_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TongHD_title.setText("Tổng số hóa đơn");
        jPanel1.add(lbl_TongHD_title);

        pnl_TongHD.add(jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 102));

        lbl_TongHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TongHD.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TongHD.setText("150");
        jPanel5.add(lbl_TongHD);

        pnl_TongHD.add(jPanel5);

        pnl_SoLieu_TKDT.add(pnl_TongHD);

        pnl_DoanhThu.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnl_DoanhThu.setLayout(new java.awt.GridLayout(2, 1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 102));

        lbl_DoanhThu_title1.setBackground(new java.awt.Color(255, 255, 102));
        lbl_DoanhThu_title1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_DoanhThu_title1.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DoanhThu_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_DoanhThu_title1.setText("Doanh Thu");
        jPanel6.add(lbl_DoanhThu_title1);

        pnl_DoanhThu.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 102));

        lbl_DoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_DoanhThu.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_DoanhThu.setText(" 10.000.000");
        jPanel7.add(lbl_DoanhThu);

        pnl_DoanhThu.add(jPanel7);

        pnl_SoLieu_TKDT.add(pnl_DoanhThu);

        pnl_TongVon.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnl_TongVon.setLayout(new java.awt.GridLayout(2, 1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 102));

        lbl_TongVon_title.setBackground(new java.awt.Color(255, 255, 102));
        lbl_TongVon_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TongVon_title.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongVon_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TongVon_title.setText("Tổng vốn");
        jPanel8.add(lbl_TongVon_title);

        pnl_TongVon.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 102));

        lbl_TongVon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TongVon.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TongVon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TongVon.setText("4.000.000");
        jPanel9.add(lbl_TongVon);

        pnl_TongVon.add(jPanel9);

        pnl_SoLieu_TKDT.add(pnl_TongVon);

        pnl_LoiNhuan.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnl_LoiNhuan.setLayout(new java.awt.GridLayout(2, 1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 102));

        lbl_LoiNhuan_title.setBackground(new java.awt.Color(255, 255, 102));
        lbl_LoiNhuan_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_LoiNhuan_title.setForeground(new java.awt.Color(0, 0, 0));
        lbl_LoiNhuan_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LoiNhuan_title.setText("Lợi Nhuận");
        jPanel10.add(lbl_LoiNhuan_title);

        pnl_LoiNhuan.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 102));

        lbl_LoiNhuan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_LoiNhuan.setForeground(new java.awt.Color(0, 0, 0));
        lbl_LoiNhuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LoiNhuan.setText("6.000.000");
        jPanel11.add(lbl_LoiNhuan);

        pnl_LoiNhuan.add(jPanel11);

        pnl_SoLieu_TKDT.add(pnl_LoiNhuan);

        pnl_center.add(pnl_SoLieu_TKDT, java.awt.BorderLayout.NORTH);

        pnl_tabel_TKDT.setLayout(new java.awt.BorderLayout());

        table_DSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Ngày Tạo", "Tiền vốn", "Doanh Thu", "Lợi Nhuận"
            }
        ));
        jScrollPane1.setViewportView(table_DSHD);

        pnl_tabel_TKDT.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnl_center.add(pnl_tabel_TKDT, java.awt.BorderLayout.CENTER);

        pnl_ThongKeDoanhThu.add(pnl_center, java.awt.BorderLayout.CENTER);

        add(pnl_ThongKeDoanhThu, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBatDau = df.format(date_NgayBatDau.getDate());
        String ngayKetThuc = df.format(date_NgayKetThuc.getDate());
        
        XoaHetDuLieu();
        
        ArrayList<HoaDon> dsHD = hd_dao.TimHoaDonTheoThoiGian(ngayBatDau, ngayKetThuc);
        double tongDoanhThu = 0;
        double tongVon = 0;
        DefaultTableModel temp = (DefaultTableModel) table_DSHD.getModel();
        for(HoaDon hd : dsHD) {
            Object[] obj = {hd.getMaHD(), hd.getDate(), hd.getTien_von(), hd.getTong_tien(), 
                hd.getTong_tien()- hd.getTien_von()};
            temp.addRow(obj);
            tongDoanhThu += hd.getTong_tien();
            tongVon += hd.getTien_von();
        }
        lbl_TongHD.setText(dsHD.size() + "");
        lbl_DoanhThu.setText(tongDoanhThu + "");
        lbl_TongVon.setText(tongVon + "");
        lbl_LoiNhuan.setText(tongDoanhThu - tongVon + "");
    }//GEN-LAST:event_btn_TimKiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JComboBox<String> cb_LoaiThongKe;
    private com.toedter.calendar.JDateChooser date_NgayBatDau;
    private com.toedter.calendar.JDateChooser date_NgayKetThuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DoanhThu;
    private javax.swing.JLabel lbl_DoanhThu_title1;
    private javax.swing.JLabel lbl_LoiNhuan;
    private javax.swing.JLabel lbl_LoiNhuan_title;
    private javax.swing.JLabel lbl_NgayBatDau;
    private javax.swing.JLabel lbl_NgayKetThuc;
    private javax.swing.JLabel lbl_TongHD;
    private javax.swing.JLabel lbl_TongHD_title;
    private javax.swing.JLabel lbl_TongVon;
    private javax.swing.JLabel lbl_TongVon_title;
    private javax.swing.JPanel pn_LoaiThongKe;
    private javax.swing.JPanel pnl_DoanhThu;
    private javax.swing.JPanel pnl_LoiNhuan;
    private javax.swing.JPanel pnl_NgayBatDau;
    private javax.swing.JPanel pnl_NgayKetThuc;
    private javax.swing.JPanel pnl_SoLieu_TKDT;
    private javax.swing.JPanel pnl_TKDT_info;
    private javax.swing.JPanel pnl_ThongKeDoanhThu;
    private javax.swing.JPanel pnl_TongHD;
    private javax.swing.JPanel pnl_TongVon;
    private javax.swing.JPanel pnl_btn_TimKiem;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_tabel_TKDT;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTable table_DSHD;
    // End of variables declaration//GEN-END:variables
}
