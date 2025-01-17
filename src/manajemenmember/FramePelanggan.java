/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemenmember;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FramePelanggan extends javax.swing.JFrame {

    /**
     * Creates new form FramePelanggan
     */
    
     //Buat Tabel
    private final DefaultTableModel model = new DefaultTableModel();
    
    
    public FramePelanggan() {
        initComponents();
        
        model.addColumn("No Member");
        model.addColumn("Nama");
        model.addColumn("Tahun Lahir");
        model.addColumn("Jenis");

        tabelMember.setModel(model);

        populateTable();
        this.setLocationRelativeTo(null);
    }
    
    private DbPelanggan koneksi = new DbPelanggan();

    private void populateTable() {
        model.setRowCount(0);
        try {
            ArrayList<Pelanggan> daftar = koneksi.getPelanggan();
            for (Pelanggan p : daftar) {
                Object[] isiData = {p.getId(), p.getNama(), p.getTahunLahir(), p.getJenis()};
                model.addRow(isiData);
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }

    }
    
    private void populateTable(String keyword) {
        model.setRowCount(0);
        try {
            ArrayList<Pelanggan> daftar = koneksi.cariPelanggan(keyword);
            for (Pelanggan p : daftar) {
                Object[] isiData = {p.getId(), p.getNama(), p.getTahunLahir(), p.getJenis()};
                model.addRow(isiData);
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }

    }
    
    private void kosongkan() {
        tfID.setText("");
        tfNama.setText("");
        comboJenis.setSelectedIndex(0);
        comboTahun.setSelectedIndex(0);
        tfID.setEditable(true);
        btnSimpan.setText("Simpan");
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
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        tfID = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboJenis = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboTahun = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfKeyword = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Formulir Daftar Pelanggan");

        tfID.setText("ID member");
        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        tfNama.setText("Nama");

        jLabel2.setText("ID Member:");

        jLabel3.setText("Nama:");

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silver", "Gold", "Platinum", " " }));

        jLabel4.setText("Jenis Member:");

        comboTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" }));

        jLabel5.setText("Tahun Lahir:");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nomor Member", "Nama", "Tahun Lahir", "Jenis"
            }
        ));
        tabelMember.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelMemberAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMemberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMember);

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(66, 66, 66)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfID, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(tfNama))
                            .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnSimpan)
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)
                        .addComponent(tfKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(16, 16, 16))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(jButton2)
                            .addComponent(tfKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(60, 60, 60))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nomor = tfID.getText();
        String nama = tfNama.getText();
        String jenis = comboJenis.getSelectedItem().toString();
        String tahunLahir = comboTahun.getSelectedItem().toString();
        Pelanggan p = new Pelanggan(nomor, nama, jenis, Integer.parseInt(tahunLahir));

        if (btnSimpan.getText().equals("Simpan")) {
            try {
                if (koneksi.insertPelanggan(p)) {
                    JOptionPane.showMessageDialog(this, "Berhasil Insert");
                    populateTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Insert");
                }
            } catch (SQLException ex) {
                System.out.println("Eksepsi: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
            }
        } else {
            try {
                int jawaban = JOptionPane.showConfirmDialog(this, "Ubah Data " + p.getId() + "?", "Ubah", JOptionPane.YES_NO_OPTION);
                if (jawaban == JOptionPane.YES_OPTION) {
                    if (koneksi.updatePelanggan(p)) {
                        JOptionPane.showMessageDialog(this, "Berhasil Update");
                        populateTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal Update");
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Eksepsi: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
            }
        }
        kosongkan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        kosongkan();
    }//GEN-LAST:event_ResetActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String keyword = tfKeyword.getText();
        populateTable(keyword);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = tabelMember.getSelectedRow();
        String id = model.getValueAt(selectedRow, 0).toString();
        int jawaban = JOptionPane.showConfirmDialog(this, "Hapus Data " + id + "?", "Hapus", JOptionPane.YES_NO_OPTION);
        if (jawaban == JOptionPane.YES_OPTION) {
            //hapus
            try {
                if (koneksi.deletePelanggan(id)) {
                    JOptionPane.showMessageDialog(this, "Berhasil Delete");
                    populateTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Delete");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Eksepsi: " + e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabelMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMemberMouseClicked
        int selectedRow = tabelMember.getSelectedRow();
        String id = model.getValueAt(selectedRow, 0).toString();
        String nama = model.getValueAt(selectedRow, 1).toString();
        String tahun = model.getValueAt(selectedRow, 2).toString();
        String jenis = model.getValueAt(selectedRow, 3).toString();

        tfID.setText(id);
        tfID.setEditable(false);
        tfNama.setText(nama);
        comboJenis.setSelectedItem(jenis);
        comboTahun.setSelectedItem(tahun);
        btnSimpan.setText("Ubah");
    }//GEN-LAST:event_tabelMemberMouseClicked

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void tabelMemberAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelMemberAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMemberAncestorAdded

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
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JComboBox<String> comboTahun;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Panel panel1;
    private javax.swing.JTable tabelMember;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfKeyword;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
