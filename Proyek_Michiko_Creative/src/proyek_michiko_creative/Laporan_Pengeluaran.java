/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

/**
 *
 * @author wafiq
 */
import java.math.BigDecimal;
import koneksi.Koneksi;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.sql.SQLException;
public class Laporan_Pengeluaran extends javax.swing.JFrame {

    private Connection conn;
    /**
     * Creates new form pengeluaran
     */
    public Laporan_Pengeluaran() {
        initComponents();
        conn = Koneksi.getConnection();
        getData();
    }
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
    model.setRowCount(0); 

    try {
        // SQL Query
        String sql = "SELECT tb.id_transaksi_beli, tb.tanggal, tb.id_suplier, s.nama_suplier, "
                   + "tb.id_barang, b.nama_barang, tb.jumlah, b.harga, "
                   + "(b.harga * tb.jumlah) AS total_harga "
                   + "FROM transaksi_beli tb "
                   + "INNER JOIN barang b ON tb.id_barang = b.id_barang "
                   + "INNER JOIN suplier s ON tb.id_suplier = s.id_suplier "
                   + "ORDER BY tb.id_transaksi_beli";

        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        BigDecimal totalPengeluaran = BigDecimal.ZERO;
        DecimalFormat df = new DecimalFormat("#,###.##");

        
        Object[] columnNames = {"ID Transaksi Beli", "Tanggal", "ID Suplier", "Nama Suplier", 
                                "ID Barang", "Nama Barang", "Jumlah", "Harga", "Total Harga"};
        model.setColumnIdentifiers(columnNames);

        while (rs.next()) {
            
            String idtransaksibeli = rs.getString("id_transaksi_beli");
            String tanggal = rs.getString("tanggal");
            String idSuplier = rs.getString("id_suplier");
            String namaSuplier = rs.getString("nama_suplier");
            String idBarang = rs.getString("id_barang");
            String namaBarang = rs.getString("nama_barang");
            int jumlah = rs.getInt("jumlah");
            BigDecimal harga = rs.getBigDecimal("harga");

            
            BigDecimal total_harga = harga.multiply(new BigDecimal(jumlah));

            
            Object[] rowData = {idtransaksibeli, tanggal, idSuplier, namaSuplier, 
                                idBarang, namaBarang, jumlah, df.format(harga), df.format(total_harga)};
            model.addRow(rowData);
            totalPengeluaran = totalPengeluaran.add(total_harga);
        }
        if (totalPengeluaran.compareTo(BigDecimal.ZERO) > 0) {
                jlabelpengeluaran.setText("Rp " + df.format(totalPengeluaran));
            } else {
                jlabelpengeluaran.setText("Rp 0");
            }

        rs.close();
        st.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}



    private void tampilkanLaporan() {
        DefaultTableModel model = (DefaultTableModel) jtabel.getModel();
        model.setRowCount(0); 

        try {
            
            String bulan = (String) cbulan.getSelectedItem();  
            String tahun = (String) ctahun.getSelectedItem();  
            String startDay = (String) ctanggalawal.getSelectedItem(); 
            String endDay = (String) ctanggalakhir.getSelectedItem(); 

           
            String tanggalMulai = tahun + "-" + bulan + "-" + startDay;
            String tanggalAkhir = tahun + "-" + bulan + "-" + endDay;

            
            String sql = "SELECT tb.id_transaksi_beli, tb.tanggal, tb.id_suplier, s.nama_suplier, "
                       + "tb.id_barang, b.nama_barang, tb.jumlah, b.harga, "
                       + "(b.harga * tb.jumlah) AS total_harga "
                       + "FROM transaksi_beli tb "
                       + "INNER JOIN barang b ON tb.id_barang = b.id_barang "
                       + "INNER JOIN suplier s ON tb.id_suplier = s.id_suplier "
                       + "WHERE tb.tanggal BETWEEN ? AND ? "
                       + "ORDER BY tb.id_transaksi_beli";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, tanggalMulai); 
            st.setString(2, tanggalAkhir); 

            ResultSet rs = st.executeQuery();
            BigDecimal totalPengeluaran = BigDecimal.ZERO;
            DecimalFormat df = new DecimalFormat("#,###.##");

            
            Object[] columnNames = {"ID Transaksi Beli", "Tanggal", "ID Suplier", "Nama Suplier", 
                                    "ID Barang", "Nama Barang", "Jumlah","Harga", "Total Harga"};
            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                
                String idtransaksibeli = rs.getString("id_transaksi_beli");
                String tanggal = rs.getString("tanggal");
                String idSuplier = rs.getString("id_suplier");
                String namaSuplier = rs.getString("nama_suplier");
                String idBarang = rs.getString("id_barang");
                String namaBarang = rs.getString("nama_barang");
                int jumlah = rs.getInt("jumlah");
                BigDecimal harga = rs.getBigDecimal("harga");

                
                BigDecimal total_harga = harga.multiply(new BigDecimal(jumlah));

               
                Object[] rowData = {idtransaksibeli, tanggal, idSuplier, namaSuplier, 
                                    idBarang, namaBarang, jumlah, df.format(harga), df.format(total_harga)};
                model.addRow(rowData);

                
                totalPengeluaran = totalPengeluaran.add(total_harga);
            }

            
            if (totalPengeluaran.compareTo(BigDecimal.ZERO) > 0) {
                jlabelpengeluaran.setText("Total Pengeluaran: Rp " + df.format(totalPengeluaran));
            } else {
                jlabelpengeluaran.setText("Total Pengeluaran: Rp 0");
            }

            
            rs.close();
            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void updateHargaTransaksi(String idTransaksi, double newHarga) {
        try {
            String sql = "UPDATE transaksi_beli SET harga = ? WHERE id_transaksi_beli = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDouble(1, newHarga);
            st.setString(2, idTransaksi);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Harga berhasil diupdate.");
                tampilkanLaporan(); 
            }

            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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

        cbulan = new javax.swing.JComboBox<>();
        ctahun = new javax.swing.JComboBox<>();
        jcari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        jlabelpengeluaran = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jberanda = new javax.swing.JButton();
        jbarang = new javax.swing.JButton();
        jpenjualan = new javax.swing.JButton();
        jpembelian = new javax.swing.JButton();
        jsuplier = new javax.swing.JButton();
        jlaporan = new javax.swing.JButton();
        jkeluar = new javax.swing.JButton();
        ctanggalakhir = new javax.swing.JComboBox<>();
        ctanggalawal = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jpengeluaran = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbulan.setBackground(new java.awt.Color(255, 204, 102));
        cbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        cbulan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 90, -1));

        ctahun.setBackground(new java.awt.Color(255, 204, 102));
        ctahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        ctahun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(ctahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 90, -1));

        jcari.setBackground(new java.awt.Color(255, 204, 102));
        jcari.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jcari.setText("Tampilkan Laporan");
        jcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcariActionPerformed(evt);
            }
        });
        getContentPane().add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 170, 40));

        jtabel.setBackground(new java.awt.Color(255, 204, 102));
        jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi Beli", "Tanggal", "ID Suplier", "Nama Suplier", "ID Barang", "Nama Barang", "Jumlah", "Harga", "Total Pembelian"
            }
        ));
        jScrollPane1.setViewportView(jtabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 850, 380));
        getContentPane().add(jlabelpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 216, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, 80, 60));

        jberanda.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jberanda.setBorder(null);
        jberanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jberanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jberandaActionPerformed(evt);
            }
        });
        getContentPane().add(jberanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 110, 40));

        jbarang.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jbarang.setBorder(null);
        jbarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbarangActionPerformed(evt);
            }
        });
        getContentPane().add(jbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 140, 30));

        jpenjualan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jpenjualan.setBorder(null);
        jpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(jpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 180, 30));

        jpembelian.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jpembelian.setBorder(null);
        jpembelian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpembelianActionPerformed(evt);
            }
        });
        getContentPane().add(jpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 180, 30));

        jsuplier.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jsuplier.setBorder(null);
        jsuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jsuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsuplierActionPerformed(evt);
            }
        });
        getContentPane().add(jsuplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, 220, 30));

        jlaporan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jlaporan.setBorder(null);
        jlaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 490, 170, 30));

        jkeluar.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jkeluar.setBorder(null);
        jkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 750, 130, 30));

        ctanggalakhir.setBackground(new java.awt.Color(255, 204, 102));
        ctanggalakhir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ctanggalakhir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(ctanggalakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 90, -1));

        ctanggalawal.setBackground(new java.awt.Color(255, 204, 102));
        ctanggalawal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ctanggalawal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(ctanggalawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 100, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton1.setText("pemasukan");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 160, 30));

        jpengeluaran.setBackground(new java.awt.Color(255, 153, 0));
        jpengeluaran.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jpengeluaran.setText("pengeluaran");
        jpengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fitur pengeluaran sayang.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcariActionPerformed
        // TODO add your handling code here:
        tampilkanLaporan();
    }//GEN-LAST:event_jcariActionPerformed

    private void jberandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jberandaActionPerformed
        // TODO add your handling code here:
        MenuFitur fitur = new MenuFitur();
        fitur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jberandaActionPerformed

    private void jbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbarangActionPerformed
        // TODO add your handling code here:
        Fitur_Barang barang = new Fitur_Barang();
        barang.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbarangActionPerformed

    private void jpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpenjualanActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiJual penjualan = new Fitur_TransaksiJual();
        penjualan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jpenjualanActionPerformed

    private void jpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpembelianActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiBeli pembelian = new Fitur_TransaksiBeli();
        pembelian.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jpembelianActionPerformed

    private void jsuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsuplierActionPerformed
        // TODO add your handling code here:
        Fitur_Suplier suplier = new Fitur_Suplier();
        suplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jsuplierActionPerformed

    private void jkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkeluarActionPerformed
        // TODO add your handling code here:
    int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        System.exit(0); 
    } else {
    }
    }//GEN-LAST:event_jkeluarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Laporan_Pemasukan pemasukan = new Laporan_Pemasukan();
        pemasukan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MenuFitur fitur = new MenuFitur();
        fitur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Pengeluaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbulan;
    private javax.swing.JComboBox<String> ctahun;
    private javax.swing.JComboBox<String> ctanggalakhir;
    private javax.swing.JComboBox<String> ctanggalawal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbarang;
    private javax.swing.JButton jberanda;
    private javax.swing.JButton jcari;
    private javax.swing.JButton jkeluar;
    private javax.swing.JLabel jlabelpengeluaran;
    private javax.swing.JButton jlaporan;
    private javax.swing.JButton jpembelian;
    private javax.swing.JButton jpengeluaran;
    private javax.swing.JButton jpenjualan;
    private javax.swing.JButton jsuplier;
    private javax.swing.JTable jtabel;
    // End of variables declaration//GEN-END:variables
}
