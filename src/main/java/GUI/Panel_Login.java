package GUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ConnectDB.connectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;

public class Panel_Login extends javax.swing.JPanel {
    private final String DB_NAME = "bookstore"; 
    private final String currentPath = System.getProperty("user.dir");
    private BufferedImage background;
    private NhanVien_DAO nv_dao = new NhanVien_DAO();

    public Panel_Login() {
        connect();
        initComponents();
        
        tao_txt_underline();
        
        // hard code
        txt_username.setText("lsimand");
        txt_password.setText("mpVTFKT4246");
    }
    
    public void tao_txt_underline() {
        JLabel underlineLabel = new JLabel("<html><u>Quên mật khẩu</u></html>");
        underlineLabel.setForeground(Color.BLUE); // Đặt màu sắc nếu cần
        
        jPanel1.add(underlineLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 270, 40));
        
        underlineLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                underlineLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                super.mouseEntered(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                underlineLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                super.mouseExited(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new QuenMatKhau().setVisible(true);
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
        });
    }
    
    public void connect() {
        try {
            Driver driver = connectDB.getInstance().getDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            background = ImageIO.read(getClass().getResource("/images/login_background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if(background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_close = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(430, 270));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 40));

        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_username.setText("admin");
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 270, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Đăng nhập");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 40));

        txt_password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_password.setText("admin");
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 270, 40));

        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_close.setText("Close");
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 110, 40));

        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_login.setText("Login");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 110, 40));

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        NhanVien nv = nv_dao.GetNV_User_Name(txt_username.getText());
        
        if(nv != null && nv.getPass_word().compareTo(txt_password.getText()) == 0) {
            // Lấy Frame cha của cái Panel này
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Panel_Login.this);
            new Panel_Main(nv).setVisible(true);
            frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect!!!");
        }
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        boolean confirmExit = JOptionPane.showConfirmDialog(
                null, 
                "Bạn có chăc chắn muốn thoát không?", 
                "Cảnh báo", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        
        if(confirmExit) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_closeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
