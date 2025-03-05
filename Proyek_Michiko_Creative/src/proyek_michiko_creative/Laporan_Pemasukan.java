/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

import java.math.BigDecimal;
import koneksi.Koneksi;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author wafiq
 */
public class Laporan_Pemasukan extends javax.swing.JFrame {

    private Connection conn;

    /**
     * Creates new form Laporan
     */
    public Laporan_Pemasukan() {
        initComponents();
        conn = Koneksi.getConnection();

      getData();
    }
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) jtabelpemasukan.getModel();
    model.setRowCount(0); 

    try {
        String sql = "SELECT tj.id_transaksi_jual, tj.tanggal, "
                   + "tj.id_barang, b.nama_barang, tj.jumlah, b.harga, tj.username, "
                   + "(b.harga * tj.jumlah) AS total_harga "
                   + "FROM transaksi_jual tj "
                   + "INNER JOIN barang b ON tj.id_barang = b.id_barang "
                   + "INNER JOIN akun a ON tj.username = a.username "
                   + "ORDER BY tj.id_transaksi_jual";

        PreparedStatement st = conn.prepareStatement(sql);
            
        
        ResultSet rs = st.executeQuery();
        BigDecimal totalPemasukan = BigDecimal.ZERO;
        DecimalFormat df = new DecimalFormat("#,###.##");

        Object[] columnNames = {"ID Transaksi", "Tanggal", 
                                "ID Barang", "Nama Barang", "Harga", "Jumlah", "Total Harga"};
        model.setColumnIdentifiers(columnNames);

        while (rs.next()) {
            String id_transaksi_jual = rs.getString("id_transaksi_jual");
            String tgl_jual = rs.getString("tanggal");
            BigDecimal harga = rs.getBigDecimal("harga");
            String id_barang = rs.getString("id_barang");
            String nama_barang = rs.getString("nama_barang");

            int jumlah = rs.getInt("jumlah");

            
            BigDecimal total_harga = harga.multiply(new BigDecimal(jumlah));

            
            Object[] rowData = {id_transaksi_jual, tgl_jual, 
                                id_barang, nama_barang, df.format(harga), jumlah, df.format(total_harga)};
            model.addRow(rowData);
            totalPemasukan = totalPemasukan.add(total_harga);
        }
        if (totalPemasukan.compareTo(BigDecimal.ZERO) > 0) {
                totallabel.setText("Rp " + df.format(totalPemasukan));
            } else {
                totallabel.setText("Rp 0");
        }

        rs.close();
        st.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
private void tampilkanLaporan() {
        DefaultTableModel model = (DefaultTableModel) jtabelpemasukan.getModel();
        model.setRowCount(0); 

        try {
            String bulan = (String) cbulan.getSelectedItem();  
            String tahun = (String) ctahun.getSelectedItem();  
            String startDay = (String) ctanggalawal.getSelectedItem(); 
            String endDay = (String) ctanggalakhir.getSelectedItem(); 

            String tanggalMulai = tahun + "-" + bulan + "-" + startDay;
            String tanggalAkhir = tahun + "-" + bulan + "-" + endDay;

            
            String sql = "SELECT tj.id_transaksi_jual, tj.tanggal, "
                       + "tj.id_barang, b.nama_barang, tj.jumlah, b.harga, tj.username, "
                       + "(b.harga * tj.jumlah) AS total_harga "
                       + "FROM transaksi_jual tj "
                       + "INNER JOIN barang b ON tj.id_barang = b.id_barang "
                       + "INNER JOIN akun a ON tj.username = a.username "
                       + "WHERE tj.tanggal BETWEEN ? AND ? "
                       + "ORDER BY tj.id_transaksi_jual";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, tanggalMulai); 
            st.setString(2, tanggalAkhir); 

            ResultSet rs = st.executeQuery();
            BigDecimal totalPemasukan = BigDecimal.ZERO;
            DecimalFormat df = new DecimalFormat("#,###.##");

            
            Object[] columnNames = {"ID Transaksi", "Tanggal", 
                                    "ID Barang", "Nama Barang", "Harga", "Jumlah", "Total Harga"};
            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                
                String id_transaksi_jual = rs.getString("id_transaksi_jual");
                String tgl_jual = rs.getString("tanggal");
                BigDecimal harga = rs.getBigDecimal("harga");
                String id_barang = rs.getString("id_barang");
                String nama_barang = rs.getString("nama_barang");
                int jumlah = rs.getInt("jumlah");
                

                
                BigDecimal total_harga = harga.multiply(new BigDecimal(jumlah));

                
                Object[] rowData = {id_transaksi_jual, tgl_jual, 
                                    id_barang, nama_barang, df.format(harga), jumlah, df.format(total_harga)};
                model.addRow(rowData);

                
                totalPemasukan = totalPemasukan.add(total_harga);
            }

            
            if (totalPemasukan.compareTo(BigDecimal.ZERO) > 0) {
                totallabel.setText("Rp " + df.format(totalPemasukan));
            } else {
                totallabel.setText("Rp 0");
            }

            
            rs.close();
            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void updateHargaTransaksi(String idTransaksi, double newHarga) {
        try {
            String sql = "UPDATE transaksi_jual SET total_harga = ? WHERE id_transaksi_jual = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDouble(1, newHarga);
            st.setString(2, idTransaksi);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Harga berhasil diupdate.");
                tampilkanLaporan(); // Refresh laporan setelah update
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

        jkeluar = new javax.swing.JButton();
        jberanda = new javax.swing.JButton();
        jbarang = new javax.swing.JButton();
        jpenjualan = new javax.swing.JButton();
        jpembelian = new javax.swing.JButton();
        jdatasuplier = new javax.swing.JButton();
        jlaporan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpemasukan = new javax.swing.JButton();
        jpengeluaran = new javax.swing.JButton();
        ctanggalawal = new javax.swing.JComboBox<>();
        ctanggalakhir = new javax.swing.JComboBox<>();
        cbulan = new javax.swing.JComboBox<>();
        ctahun = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelpemasukan = new javax.swing.JTable();
        totallabel = new javax.swing.JLabel();
        jcari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jkeluar.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jkeluar.setBorder(null);
        jkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 750, 130, 40));

        jberanda.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jberanda.setBorder(null);
        jberanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jberanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jberandaActionPerformed(evt);
            }
        });
        getContentPane().add(jberanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 110, 30));

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

        jdatasuplier.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jdatasuplier.setBorder(null);
        jdatasuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jdatasuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdatasuplierActionPerformed(evt);
            }
        });
        getContentPane().add(jdatasuplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, 220, 40));

        jlaporan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jlaporan.setBorder(null);
        jlaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlaporanActionPerformed(evt);
            }
        });
        getContentPane().add(jlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 490, 160, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 30, 70, 70));

        jpemasukan.setBackground(new java.awt.Color(255, 153, 0));
        jpemasukan.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jpemasukan.setText("Pemasukan");
        jpemasukan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpemasukan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpemasukanActionPerformed(evt);
            }
        });
        getContentPane().add(jpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 160, 30));

        jpengeluaran.setBackground(new java.awt.Color(255, 153, 0));
        jpengeluaran.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jpengeluaran.setText("Pengeluaran");
        jpengeluaran.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpengeluaranActionPerformed(evt);
            }
        });
        getContentPane().add(jpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 160, 30));

        ctanggalawal.setBackground(new java.awt.Color(255, 204, 102));
        ctanggalawal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ctanggalawal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(ctanggalawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 100, -1));

        ctanggalakhir.setBackground(new java.awt.Color(255, 204, 102));
        ctanggalakhir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ctanggalakhir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ctanggalakhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctanggalakhirActionPerformed(evt);
            }
        });
        getContentPane().add(ctanggalakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 90, -1));

        cbulan.setBackground(new java.awt.Color(255, 204, 102));
        cbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbulan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 90, -1));

        ctahun.setBackground(new java.awt.Color(255, 204, 102));
        ctahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        ctahun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(ctahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 80, -1));

        jtabelpemasukan.setBackground(new java.awt.Color(255, 204, 102));
        jtabelpemasukan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Tanggal", "Id Barang", "Nama Barang", "Harga", "Jumlah", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(jtabelpemasukan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 407, 840, 380));
        getContentPane().add(totallabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 220, 40));

        jcari.setBackground(new java.awt.Color(255, 204, 102));
        jcari.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jcari.setText("Tampilkan Laporan");
        jcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcariActionPerformed(evt);
            }
        });
        getContentPane().add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 180, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fitur pemasukan sayang.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkeluarActionPerformed
        // TODO add your handling code here:

    int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    
    if (response == JOptionPane.YES_OPTION) {
        System.exit(0); 
    } else {
    }

    }//GEN-LAST:event_jkeluarActionPerformed

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

    private void jdatasuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdatasuplierActionPerformed
        // TODO add your handling code here:
        Fitur_Suplier suplier = new Fitur_Suplier();
        suplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jdatasuplierActionPerformed

    private void jlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlaporanActionPerformed

    private void jpemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpemasukanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jpemasukanActionPerformed

    private void jpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpenjualanActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiJual suplier = new Fitur_TransaksiJual();
        suplier.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jpenjualanActionPerformed

    private void jpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpembelianActionPerformed
        // TODO add your handling code here:
        Fitur_TransaksiBeli pembelian = new Fitur_TransaksiBeli();
        pembelian.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jpembelianActionPerformed

    private void jpengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpengeluaranActionPerformed
        // TODO add your handling code here:
        Laporan_Pengeluaran pengeluaran = new Laporan_Pengeluaran();
        pengeluaran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jpengeluaranActionPerformed

    private void jcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcariActionPerformed
        // TODO add your handling code here:
        tampilkanLaporan();
    }//GEN-LAST:event_jcariActionPerformed

    private void ctanggalakhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctanggalakhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctanggalakhirActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Pemasukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbulan;
    private javax.swing.JComboBox<String> ctahun;
    private javax.swing.JComboBox<String> ctanggalakhir;
    private javax.swing.JComboBox<String> ctanggalawal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbarang;
    private javax.swing.JButton jberanda;
    private javax.swing.JButton jcari;
    private javax.swing.JButton jdatasuplier;
    private javax.swing.JButton jkeluar;
    private javax.swing.JButton jlaporan;
    private javax.swing.JButton jpemasukan;
    private javax.swing.JButton jpembelian;
    private javax.swing.JButton jpengeluaran;
    private javax.swing.JButton jpenjualan;
    private javax.swing.JTable jtabelpemasukan;
    private javax.swing.JLabel totallabel;
    // End of variables declaration//GEN-END:variables
}
