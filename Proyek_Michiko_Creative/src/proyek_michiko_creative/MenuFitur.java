/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

/**
 *
 * @author wafiq
 */


import javax.swing.JOptionPane;

public class MenuFitur extends javax.swing.JFrame {

    /**
     * Creates new form MenuFitur
     */
    public MenuFitur() {
        initComponents();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbfitur = new javax.swing.JButton();
        jbbarang = new javax.swing.JButton();
        jbpenjualan = new javax.swing.JButton();
        jbpembelian = new javax.swing.JButton();
        jbdatasuplier = new javax.swing.JButton();
        jbkeluar = new javax.swing.JButton();
        jblaporan = new javax.swing.JButton();
        jbberanda1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbfitur.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jbfitur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbfitur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbfiturActionPerformed(evt);
            }
        });
        getContentPane().add(jbfitur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, 80, 70));

        jbbarang.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbbarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbarangActionPerformed(evt);
            }
        });
        getContentPane().add(jbbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 150, 40));

        jbpenjualan.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbpenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(jbpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 180, 30));

        jbpembelian.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbpembelian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbpembelianActionPerformed(evt);
            }
        });
        getContentPane().add(jbpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 330, 180, 30));

        jbdatasuplier.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbdatasuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbdatasuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdatasuplierActionPerformed(evt);
            }
        });
        getContentPane().add(jbdatasuplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, 230, 40));

        jbkeluar.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jbkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 750, 140, 40));

        jblaporan.setBackground(new java.awt.Color(0, 0, 0, 0));
        jblaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblaporanActionPerformed(evt);
            }
        });
        getContentPane().add(jblaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 480, 170, 40));

        jbberanda1.setBackground(new java.awt.Color(0, 0, 0, 0));
        jbberanda1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbberanda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbberanda1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbberanda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fitur sayang.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbdatasuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdatasuplierActionPerformed
        // TODO add your handling code here:
        Fitur_Suplier suplier = new Fitur_Suplier();
        suplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbdatasuplierActionPerformed

    private void jbkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbkeluarActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
        System.exit(0); 
    } else {
            
        }
    }//GEN-LAST:event_jbkeluarActionPerformed

    private void jbfiturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbfiturActionPerformed
        // TODO add your handling code here:
        Menu mnu = new Menu ();
            mnu.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jbfiturActionPerformed

    private void jbbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbarangActionPerformed
        // TODO add your handling code here:
        Fitur_Barang barang = new Fitur_Barang();
        barang.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbbarangActionPerformed

    private void jbpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbpenjualanActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiJual penjualan = new Fitur_TransaksiJual();
        penjualan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbpenjualanActionPerformed

    private void jblaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblaporanActionPerformed
        // TODO add your handling code here:
        Laporan_Pemasukan laporan = new Laporan_Pemasukan();
        laporan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblaporanActionPerformed

    private void jbberanda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbberanda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbberanda1ActionPerformed

    private void jbpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbpembelianActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiBeli pembelian = new Fitur_TransaksiBeli();
        pembelian.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jbpembelianActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFitur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFitur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFitur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFitur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFitur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbbarang;
    private javax.swing.JButton jbberanda1;
    private javax.swing.JButton jbdatasuplier;
    private javax.swing.JButton jbfitur;
    private javax.swing.JButton jbkeluar;
    private javax.swing.JButton jblaporan;
    private javax.swing.JButton jbpembelian;
    private javax.swing.JButton jbpenjualan;
    // End of variables declaration//GEN-END:variables

    
}
