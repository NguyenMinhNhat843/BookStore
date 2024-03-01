/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import dao.NhanVien_DAO;
import java.awt.HeadlessException;
import javax.mail.*;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class QuenMatKhau extends javax.swing.JFrame {
    private NhanVien_DAO nv_dao = new NhanVien_DAO();
    /**
     * Creates new form QuenMatKhau
     */
    public QuenMatKhau() {
        initComponents();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);
        setSize(790, 350);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_Center = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_XacNhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_top.setBackground(new java.awt.Color(153, 153, 0));
        pnl_top.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 15, 1));
        pnl_top.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Vui lòng nhập email để lấy lại mật khẩu");
        pnl_top.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_top, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_username.setPreferredSize(new java.awt.Dimension(114, 45));

        btn_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_XacNhan.setText("Gửi Mật khẩu mới tới email");
        btn_XacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XacNhanMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nhập Email tại đây:");

        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Email.setText("nhatnguyen15062019@gmail.com");
        txt_Email.setPreferredSize(new java.awt.Dimension(114, 45));

        javax.swing.GroupLayout pnl_CenterLayout = new javax.swing.GroupLayout(pnl_Center);
        pnl_Center.setLayout(pnl_CenterLayout);
        pnl_CenterLayout.setHorizontalGroup(
            pnl_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CenterLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_CenterLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_CenterLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CenterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        pnl_CenterLayout.setVerticalGroup(
            pnl_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CenterLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnl_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnl_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(pnl_Center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    private static void sendEmail(String toEmail) {
//        final String username = "nhatpkl3256@gmail.com"; // Replace with your email
//        final String password = "frehyd@#%"; // Replace with your password
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            message.setSubject("Password Reset");
//            message.setText("Your new password is: 1111");
//
//            Transport.send(message);
//
//            System.out.println("GUI.QuenMatKhau.sendEmail() " + "có lỗi");
//            System.out.println("Email sent successfully.");
//
//        } catch (MessagingException e) {
//            Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, e);
//                
////            System.out.println("GUI.QuenMatKhau.sendEmail() " + "có lỗi sâsdas");
//        }
//    }
//    
    
    public void sendEmail(String toEmail) {
//        Properties props = new Properties();
//        final String EMAIL_USERNAME = "khoinguyeniuh@gmail.com"; // Replace with your email
//        final String EMAIL_PASSWORD = "cjcf uclv eyig akeq"; // Replace with your password
//
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.starttls.enable", "true");
//
//        // Tạo một TrustManager tạm thời
//        TrustManager[] trustAllCerts = new TrustManager[]{
//            new X509TrustManager() {
//                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//
//                public void checkClientTrusted(
//                    java.security.cert.X509Certificate[] certs, String authType) {
//                }
//
//                public void checkServerTrusted(
//                    java.security.cert.X509Certificate[] certs, String authType) {
//                }
//            }
//        };
//
//        // Set TrustManager vào SSLContext
//        try {
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
//
//            // Sử dụng SSLContext trong Session
//            props.put("mail.smtp.ssl.socketFactory", sc.getSocketFactory());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
//                    }
//                }
//        );
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(EMAIL_USERNAME));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            message.setSubject("Khôi phục mật khẩu");
//
//
//            // PHẦN NỘI DUNG
//            Multipart multiPart = new MimeMultipart();
//            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
//            messageBodyPart1.setText("Mật khẩu mới của bạn là: 1111");
//
//            multiPart.addBodyPart(messageBodyPart1);
//
//
//            // Đặt nội dung email là tổ hợp của các phần thân
//            message.setContent(multiPart);
//
//
//            Transport.send(message);
//            
//            TaiKhoan tk = tk_dao.getTK_Theousername(txt_username.getText());
//            if(tk != null) {
//                tk_dao.CapNhatTK(tk.getMaTK(), "1111");
//            }
//            
//            JOptionPane.showMessageDialog(null, "gửi email thành công");
//        } catch (MessagingException | HeadlessException e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, e);
//        }
    }
    private void btn_XacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XacNhanMouseClicked
        // TODO add your handling code here:
        String email = txt_Email.getText();
        
        sendEmail(email);
        
        
    }//GEN-LAST:event_btn_XacNhanMouseClicked

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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_XacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnl_Center;
    private javax.swing.JPanel pnl_top;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
