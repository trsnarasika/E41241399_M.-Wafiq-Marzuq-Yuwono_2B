/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

/**
 *
 * @author wafiq
 */

import java.awt.Window;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.jbarcodebean.model.AbstractBarcodeStrategy;
import net.sourceforge.jbarcodebean.model.Codabar;
import net.sourceforge.jbarcodebean.model.Code11;
import net.sourceforge.jbarcodebean.model.Code128;
import net.sourceforge.jbarcodebean.model.Code39;
import net.sourceforge.jbarcodebean.model.Code93;
import net.sourceforge.jbarcodebean.model.Ean13;
import net.sourceforge.jbarcodebean.model.Ean8;
import net.sourceforge.jbarcodebean.model.Interleaved25;
import net.sourceforge.jbarcodebean.model.MSI;
import path.to.JbareedeBean;

public class Barcode extends javax.swing.JFrame {
    
//    public GenerateBarcode extends javax.swing.JFrame {
//    
//    private BufferedImage image = null;   


    /**
     * Creates new form Barcode
     */
    public Barcode() {
        initComponents();
    }

    private AbstractBarcodeStrategy getCodeType(String codeType){
    AbstractBarcodeStrategy mCodeType = null;
    switch (codeType) {
        case "code11":
            mCodeType = new Code11();
            break;
        case "Code39":
            mCodeType = new Code39();
            break;
        case "Code93":
            mCodeType = new Code93();
            break;
        case "Code128":
            mCodeType = new Code128();
            break;
        case "Codebar":
            mCodeType = new Codabar();
            break;
        case "Ean8":
            mCodeType = new Ean8();
            break;
        case "Ean13":
            mCodeType = new Ean13();
            break;
        case "Intervaleaved25":
            mCodeType = new Interleaved25();
            break;
        case "MSI":
            mCodeType = new MSI();
            break;
        default:
            mCodeType = null;     
    }
    return mCodeType;
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
        jTextField1 = new javax.swing.JTextField();
        cbcode = new javax.swing.JComboBox<>();
        tBuat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbarcode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTextField1.setText("jTextField1");

        cbcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Code11", "Code39", "Code93", "Code128", "Codebar", "Ean8", "Ean13", "Interleaved25", "MSI" }));

        tBuat.setText("Buat");
        tBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBuatActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        lbarcode.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tBuat)
                        .addGap(99, 99, 99)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(cbcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tBuat)
                    .addComponent(jButton2))
                .addGap(26, 26, 26)
                .addComponent(lbarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuatActionPerformed
        // TODO add your handling code here:
       private void tBuatActionPerformed(java.awt.event.ActionEvent evt) {                                      
    // Mengambil kode input
    String id = tBuat.getText().trim();
    
    // Keluar jika input kosong
    if (id.equals("")) {
        JOptionPane.showMessageDialog(this, "Harap masukkan kode yang valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Membuat objek barcode
    JbareedeBean barcodeBean = new JbareedeBean();
    AbstractBarcodeStrategy codeType = getCodeType(cbcode.getSelectedItem().toString());
    
    // Memeriksa apakah tipe kode valid
    if (codeType == null) {
        JOptionPane.showMessageDialog(this, "Tipe barcode yang dipilih tidak valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Menetapkan tipe barcode dan kode
    barcodeBean.setCodeType(codeType);
    barcodeBean.setCode(id);

    // Mendefinisikan dimensi barcode
    int barcodeWidth = 200;
    int barcodeHeight = 100;

    try {
        // Menggambar gambar barcode
        image = barcodeBean.draw(new BufferedImage(barcodeWidth, barcodeHeight, BufferedImage.TYPE_INT_BGR));

        // Menyesuaikan ukuran dan menampilkan gambar barcode
        ImageIcon iconBarcode = new ImageIcon(image.getScaledInstance(lbarcode.getWidth(), lbarcode.getHeight(), java.awt.Image.SCALE_SMOOTH));
        lbarcode.setIcon(iconBarcode);
    } catch (Exception e) {
        // Menangani kesalahan selama pembuatan barcode
        JOptionPane.showMessageDialog(this, "Gagal membuat barcode: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_tBuatActionPerformed

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
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbcode;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbarcode;
    private javax.swing.JButton tBuat;
    // End of variables declaration//GEN-END:variables
}
