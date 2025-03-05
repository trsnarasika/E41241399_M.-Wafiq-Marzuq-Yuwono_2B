/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import koneksi.Koneksi;
import java.sql.ResultSet;


/**
 *
 * @author wafiq
 */
public class Login extends javax.swing.JFrame {
private Connection conn;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        conn = Koneksi.getConnection();
//       getData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtxtusername = new javax.swing.JTextField();
        jtxtpassword = new javax.swing.JPasswordField();
        jbkeluar = new javax.swing.JButton();
        jmasuk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtusername.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jtxtusername.setBorder(null);
        jtxtusername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtusernameActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 130, 30));

        jtxtpassword.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jtxtpassword.setBorder(null);
        jtxtpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jtxtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, 30));

        jbkeluar.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jbkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jbkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 3, 30, 30));

        jmasuk.setBackground(new java.awt.Color(255, 255, 204));
        jmasuk.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jmasuk.setText("Masuk");
        jmasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmasukActionPerformed(evt);
            }
        });
        getContentPane().add(jmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 120, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.jpg"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtusernameActionPerformed

    private void jbkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbkeluarActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    // Memeriksa pilihan pengguna
    if (response == JOptionPane.YES_OPTION) {
        System.exit(0); 
    } else {
    }
    }//GEN-LAST:event_jbkeluarActionPerformed

    private void jmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmasukActionPerformed
        // TODO add your handling code here:
        {  String username = jtxtusername.getText();
        String password = new String(jtxtpassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password tidak boleh kosong!");
            return;
        }

        try {
            String sql = "SELECT * FROM akun WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               
                JOptionPane.showMessageDialog(this, "Anda Log in sebagai  " +username);
                
                Menu halut = new Menu();
                halut.setVisible(true);
                this.dispose();  
            } else {
                JOptionPane.showMessageDialog(this, "Username atau Password salah!");
                JOptionPane.showMessageDialog(this, "Coba Lagi Yaaaa!");
            }

            rs.close();
            stmt.close();


} catch (Exception e) {
    System.err.println("General Error: " + e.getMessage());
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan. Silakan coba lagi.");
}
}
    }//GEN-LAST:event_jmasukActionPerformed
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbkeluar;
    private javax.swing.JButton jmasuk;
    private javax.swing.JPasswordField jtxtpassword;
    private javax.swing.JTextField jtxtusername;
    // End of variables declaration//GEN-END:variables
} 
