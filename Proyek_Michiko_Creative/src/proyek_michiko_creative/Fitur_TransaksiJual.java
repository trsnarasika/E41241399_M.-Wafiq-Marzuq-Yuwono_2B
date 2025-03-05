/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek_michiko_creative;

/**
 *
 * @author wafiq
 */
import koneksi.Koneksi;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;



public class Fitur_TransaksiJual extends javax.swing.JFrame {
    private Connection conn;

    /**
     * Creates new form Fitur_TransaksiJual
     */
    public Fitur_TransaksiJual() {
        initComponents();
        conn = Koneksi.getConnection();
        getData();
    } 
    private void getData() {
    DefaultTableModel model = (DefaultTableModel) jTabelTransaksiJual.getModel();
    model.setRowCount(0); // Reset tabel

    try { 
        String sql = "SELECT * FROM Transaksi_jual"; 
        PreparedStatement st = conn.prepareStatement(sql); 
        ResultSet rs = st.executeQuery();
        
        // Memproses hasil kueri
        while (rs.next()) { 
            String idtransaksi = rs.getString("id_transaksi_jual"); 
            String namabarang = rs.getString("nama_barang");
            String jumlah = rs.getString("jumlah");
            String tanggal = rs.getString("tanggal");
            String totalharga = rs.getString("total_harga");
            String idbarang = rs.getString("id_barang");
            String username = rs.getString("username");
            
            // Menambahkan baris data ke model tabel
            Object[] rowData = {idtransaksi, namabarang, jumlah, tanggal, totalharga, idbarang, username}; 
            model.addRow(rowData);
        }
        
        // Menutup resources setelah selesai digunakan
        rs.close(); 
        st.close(); 
    } catch (Exception e) { 
        Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(Level.SEVERE, null, e); 
        JOptionPane.showMessageDialog(this, "Error saat mengambil data: " + e.getMessage());
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

        tidtransaksijual = new javax.swing.JTextField();
        tnamabarang = new javax.swing.JTextField();
        ttanggal = new javax.swing.JTextField();
        tjumlah = new javax.swing.JTextField();
        ttotalharga = new javax.swing.JTextField();
        tidbarang = new javax.swing.JTextField();
        tusername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelTransaksiJual = new javax.swing.JTable();
        jubah = new javax.swing.JButton();
        jhapus = new javax.swing.JButton();
        jberanda = new javax.swing.JButton();
        jbarang = new javax.swing.JButton();
        jpenjualan = new javax.swing.JButton();
        jpembelian = new javax.swing.JButton();
        jsuplier = new javax.swing.JButton();
        jlaporan = new javax.swing.JButton();
        jkeluar = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        jcari = new javax.swing.JButton();
        jTambah1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tidtransaksijual.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        tidtransaksijual.setBorder(null);
        tidtransaksijual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidtransaksijualActionPerformed(evt);
            }
        });
        getContentPane().add(tidtransaksijual, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 30));

        tnamabarang.setBackground(new java.awt.Color(0, 0, 0, 0));
        tnamabarang.setBorder(null);
        tnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamabarangActionPerformed(evt);
            }
        });
        getContentPane().add(tnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 232, 210, 30));

        ttanggal.setBackground(new java.awt.Color(0, 0, 0, 0));
        ttanggal.setBorder(null);
        getContentPane().add(ttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 210, 30));

        tjumlah.setBackground(new java.awt.Color(0, 0, 0, 0));
        tjumlah.setBorder(null);
        tjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumlahActionPerformed(evt);
            }
        });
        getContentPane().add(tjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 210, 30));

        ttotalharga.setBackground(new java.awt.Color(0, 0, 0, 0));
        ttotalharga.setBorder(null);
        getContentPane().add(ttotalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 210, 30));

        tidbarang.setBackground(new java.awt.Color(0, 0, 0, 0));
        tidbarang.setBorder(null);
        getContentPane().add(tidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 210, 30));

        tusername.setBackground(new java.awt.Color(0, 0, 0, 0));
        tusername.setBorder(null);
        getContentPane().add(tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 210, 30));

        jTabelTransaksiJual.setBackground(new java.awt.Color(255, 204, 102));
        jTabelTransaksiJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id transaksi jual", "Nama barang", "Jumlah", "Tanggal", "Total harga", "Id barang", "Penjual"
            }
        ));
        jTabelTransaksiJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelTransaksiJualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelTransaksiJual);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 840, 270));

        jubah.setBackground(new java.awt.Color(255, 204, 51));
        jubah.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jubah.setText("ubah");
        jubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jubahActionPerformed(evt);
            }
        });
        getContentPane().add(jubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, -1));

        jhapus.setBackground(new java.awt.Color(255, 204, 51));
        jhapus.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jhapus.setText("hapus");
        jhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhapusActionPerformed(evt);
            }
        });
        getContentPane().add(jhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 100, -1));

        jberanda.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jberanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jberanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jberandaActionPerformed(evt);
            }
        });
        getContentPane().add(jberanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 110, 30));

        jbarang.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jbarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbarangActionPerformed(evt);
            }
        });
        getContentPane().add(jbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 140, 30));

        jpenjualan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jpenjualan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(jpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 180, 30));

        jpembelian.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jpembelian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpembelianActionPerformed(evt);
            }
        });
        getContentPane().add(jpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 180, 30));

        jsuplier.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jsuplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jsuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsuplierActionPerformed(evt);
            }
        });
        getContentPane().add(jsuplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 410, 230, 30));

        jlaporan.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jlaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlaporanActionPerformed(evt);
            }
        });
        getContentPane().add(jlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 490, 160, 40));

        jkeluar.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(jkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 750, 130, 40));

        jButton9.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, 100, 70));

        tcari.setBackground(new java.awt.Color(0, 0, 0, 0));
        tcari.setBorder(null);
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        getContentPane().add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 240, 20));

        jcari.setBackground(new java.awt.Color(0, 0, 0, 0));
        jcari.setBorder(null);
        jcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcariActionPerformed(evt);
            }
        });
        getContentPane().add(jcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 40, 40));

        jTambah1.setBackground(new java.awt.Color(255, 204, 51));
        jTambah1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jTambah1.setText("masuk");
        jTambah1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTambah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTambah1MouseClicked(evt);
            }
        });
        jTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambah1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fitur penjualan sayang.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelTransaksiJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelTransaksiJualMouseClicked
        int selectedRow = jTabelTransaksiJual.getSelectedRow();
if (selectedRow != -1) {
    String idtransaksijual = jTabelTransaksiJual.getValueAt(selectedRow, 0).toString();
    String namabarang = jTabelTransaksiJual.getValueAt(selectedRow, 1).toString();
    int jumlah = Integer.parseInt(jTabelTransaksiJual.getValueAt(selectedRow, 2).toString());
    String tanggal = jTabelTransaksiJual.getValueAt(selectedRow, 3).toString(); 
    double totalharga = Double.parseDouble(jTabelTransaksiJual.getValueAt(selectedRow, 4).toString()); 
    String idbarang = jTabelTransaksiJual.getValueAt(selectedRow, 5).toString();
    String penjual = jTabelTransaksiJual.getValueAt(selectedRow, 6).toString();
    
    tidtransaksijual.setText(idtransaksijual);
    tnamabarang.setText(namabarang);
    tjumlah.setText(String.valueOf(jumlah));
    ttanggal.setText(tanggal); 
    ttotalharga.setText(String.valueOf(totalharga)); 
    tidbarang.setText(idbarang);
    tusername.setText(penjual);
}
    }//GEN-LAST:event_jTabelTransaksiJualMouseClicked

    private void tnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamabarangActionPerformed

    private void jubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jubahActionPerformed
        // TODO add your handling code here:
       int selectedRow = jTabelTransaksiJual.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih transaksi yang akan diubah");
        return;
    }

    String idtransaksi = jTabelTransaksiJual.getValueAt(selectedRow, 0).toString();

    String namabarang = tnamabarang.getText();
    String jumlah = tjumlah.getText();
    String tanggal = ttanggal.getText();
    String totalharga = ttotalharga.getText();
    String idbarang = tidbarang.getText();
    String penjual = tusername.getText();

    if (namabarang.isEmpty() || jumlah.isEmpty() || tanggal.isEmpty() || totalharga.isEmpty() || idbarang.isEmpty() || penjual.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap lengkapi semua field sebelum mengubah data.");
        return;
    }

    int jumlahBarang = 0;
    double totalHarga = 0;
    try {
        jumlahBarang = Integer.parseInt(jumlah); 
        totalHarga = Double.parseDouble(totalharga);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Jumlah dan Total Harga harus berupa angka yang valid.");
        return;
    }

    String sql = " UPDATE transaksi_jual SET jumlah = ?, total_harga = ? WHERE id_transaksi_jual = ?";

    try (PreparedStatement st = conn.prepareStatement(sql)) {
        st.setInt(1, jumlahBarang); 
        st.setDouble(2, totalHarga); 
        st.setString(3, idtransaksi);

        int rowsUpdated = st.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            getData(); 
            resetForm(); 
        } else {
            JOptionPane.showMessageDialog(this, "Data dengan ID tersebut tidak ditemukan atau gagal diperbarui.");
        }
    } catch (SQLException e) {
        Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(this, "Error saat mengubah data: " + e.getMessage());
    }


    }//GEN-LAST:event_jubahActionPerformed

    private void jhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhapusActionPerformed
        // TODO add your handling code here:
        int selectedRow= jTabelTransaksiJual.getSelectedRow();
            if(selectedRow == 1){
                JOptionPane.showMessageDialog(this,"Pilih tabel yang akan di ubah");
                return;
            }
            String id_barang = jTabelTransaksiJual.getValueAt(selectedRow, 0).toString(); 
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus item ini?", 
            "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            
            String sql = "DELETE FROM transaksi_jual WHERE id_transaksi_jual = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id_barang);
            int rowsDeleted = st.executeUpdate();
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                getData();
                resetForm(); 
                
            } 
            
            st.close();
        } catch (Exception e)  {
            Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error saat menghapus data: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jhapusActionPerformed

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

    private void jlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlaporanActionPerformed
        // TODO add your handling code here:
        Laporan_Pemasukan laporan = new Laporan_Pemasukan();
        laporan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jlaporanActionPerformed

    private void jkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkeluarActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        System.exit(0); 
    } else {
    }
    }//GEN-LAST:event_jkeluarActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        MenuFitur fitur = new MenuFitur();
        fitur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjumlahActionPerformed
        // TODO add your handling code here:
         try { 
    int jumlah = Integer.parseInt(tjumlah.getText());
    int hargaSatuan = 25000; 
    int total = jumlah * hargaSatuan;
    String namaBarang = "jaddah";
    String pembeli = "bayu";
    int idbarang = 1;

    ttotalharga.setText(String.valueOf(total)); 
    tnamabarang.setText(namaBarang);
    tusername.setText(pembeli);
    tidbarang.setText(String.valueOf(idbarang));

} catch (NumberFormatException e) { 
    ttotalharga.setText("Input tidak valid");
    tnamabarang.setText("");
    tusername.setText("");
    tidbarang.setText("");
}
 
    
    }//GEN-LAST:event_tjumlahActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void jcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcariActionPerformed
        // TODO add your handling code here:
        String keyword = tcari.getText().trim();
    if (!keyword.isEmpty()) {
        searchData(keyword); 
    } else {
        getData(); 
    }
}

private void searchData(String keyword) {
    DefaultTableModel model = (DefaultTableModel) jTabelTransaksiJual.getModel();
    model.setRowCount(0);

    String sql = "SELECT * FROM transaksi_jual WHERE id_transaksi_jual LIKE ? OR nama_barang LIKE ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Ambil data dari result set
                String id_transaksi = rs.getString("id_transaksi_jual");
                String nama_barang = rs.getString("nama_barang");
                String jumlah = rs.getString("jumlah");
                String tanggal = rs.getString("tanggal");
                String harga = rs.getString("total_harga");
                String id_barang = rs.getString("id_barang");
                String username = rs.getString("username");
               
                Object[] rowData = {
                   id_transaksi,nama_barang,jumlah,tanggal,harga,id_barang,username
                };
                model.addRow(rowData);
            }
        }
    } catch (Exception e) {
        Logger.getLogger(Fitur_TransaksiBeli.class.getName()).log(Level.SEVERE, "Error saat mencari data", e);
        JOptionPane.showMessageDialog(this, 
            "Error saat mencari data: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jcariActionPerformed

    private void tidtransaksijualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidtransaksijualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidtransaksijualActionPerformed

    private void jTambah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTambah1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTambah1MouseClicked

    private void jTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambah1ActionPerformed
        // TODO add your handling code here:
        

String nama_barang = tnamabarang.getText();
String jumlahStr = tjumlah.getText();
String totalhargaStr = ttotalharga.getText();
String idbarang = tidbarang.getText();
String username = tusername.getText();

// Validasi input untuk memastikan semua field telah diisi
if (nama_barang.isEmpty() || jumlahStr.isEmpty() || totalhargaStr.isEmpty() || idbarang.isEmpty() || username.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Harap lengkapi semua field sebelum menambahkan data.");
    return;
}

try {
    int jumlah = Integer.parseInt(jumlahStr);
    double totalharga = Double.parseDouble(totalhargaStr);

    // Menambahkan transaksi tanpa memeriksa stok barang
    String sqlInsert = "INSERT INTO transaksi_jual (nama_barang, jumlah, total_harga, id_barang, username) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);
    pstInsert.setString(1, nama_barang);
    pstInsert.setInt(2, jumlah);
    pstInsert.setDouble(3, totalharga);
    pstInsert.setString(4, idbarang);
    pstInsert.setString(5, username);
    
    int rowInserted = pstInsert.executeUpdate();
    if (rowInserted > 0) {
        JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
        resetForm();
        getData();
    }

    pstInsert.close();

} catch (Exception e) {
    Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(Level.SEVERE, null, e);
    JOptionPane.showMessageDialog(this, "Error saat menambahkan data: " + e.getMessage());
}
    }//GEN-LAST:event_jTambah1ActionPerformed

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
            java.util.logging.Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fitur_TransaksiJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fitur_TransaksiJual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelTransaksiJual;
    private javax.swing.JButton jTambah1;
    private javax.swing.JButton jbarang;
    private javax.swing.JButton jberanda;
    private javax.swing.JButton jcari;
    private javax.swing.JButton jhapus;
    private javax.swing.JButton jkeluar;
    private javax.swing.JButton jlaporan;
    private javax.swing.JButton jpembelian;
    private javax.swing.JButton jpenjualan;
    private javax.swing.JButton jsuplier;
    private javax.swing.JButton jubah;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tidbarang;
    private javax.swing.JTextField tidtransaksijual;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tnamabarang;
    private javax.swing.JTextField ttanggal;
    private javax.swing.JTextField ttotalharga;
    private javax.swing.JTextField tusername;
    // End of variables declaration//GEN-END:variables
private void resetForm() {
        tidtransaksijual.setText("");
        tnamabarang.setText("");
        tjumlah.setText("");
        ttanggal.setText("");
        ttotalharga.setText("");
        tidbarang.setText(""); 
        tusername.setText("");
}
}