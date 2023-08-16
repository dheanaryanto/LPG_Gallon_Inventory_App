/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;

/**
 *
 * @author LENOVO
 */
public class inner_join extends javax.swing.JDialog {

    /**
     * Creates new form data_supplier
     */
    public final Connection conn = new koneksi().connect();
    
    private DefaultTableModel tabmode;
    
    
        public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }
    
        protected void reset() {
        txtId.setText(null);
    }
        
    public void lebarKolom(){
        TableColumn kolom;
        tabelinner.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelinner.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(20);

        kolom = tabelinner.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        
        kolom = tabelinner.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        
        kolom = tabelinner.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(100);

    }
    
    public void dataTableInner(){
        Object[] Baris = {"No", "ID Bm", "Kode Barang", "Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelinner.setModel(tabmode);
        String sql = "SELECT * FROM tb_bm INNER JOIN tb_dt_bm ON tb_bm.id_bm = tb_dt_bm.id_bm "
                + " ORDER BY tb_bm.id_bm ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String total = hasil.getString("total");
                String[] data = {"", id_bm, kode_barang, total};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }
    
    public void dataTableLeft(){
        Object[] Baris = {"No", "ID Bm", "Kode Barang", "Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tabeleft.setModel(tabmode);
        String sql = "SELECT * FROM tb_bm LEFT JOIN tb_dt_bm ON tb_bm.id_bm = tb_dt_bm.id_bm "
                + "WHERE tb_dt_bm.id_bm IS NULL";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String total = hasil.getString("total");
                String[] data = {"", id_bm, kode_barang, total};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }
    
    /*public void dataTableRight(){
        Object[] Baris = {"No", "ID Bm", "Kode Barang", "Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelinner.setModel(tabmode);
        String sql = "SELECT * FROM tb_bm RIGHT JOIN tb_dt_bm ON tb_bm.id_bm = tb_dt_bm.id_bm "
                + "WHERE tb_bm.id_bm IS NULL";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String total = hasil.getString("total");
                String[] data = {"", id_bm, kode_barang, total};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }*///hasilnya sama seperti inner join
    
    /*public void dataTableFull(){
        Object[] Baris = {"No", "ID Bm", "Kode Barang", "Total"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelinner.setModel(tabmode);
        String sql = "SELECT * FROM tb_bm FULL JOIN tb_dt_bm ON tb_bm.id_bm = tb_dt_bm.id_bm ";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String total = hasil.getString("total");
                String[] data = {"", id_bm, kode_barang, total};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }*/
    
    public inner_join(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lebarKolom();
        dataTableInner();
        dataTableLeft();
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelinner = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeleft = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Supplier");
        setModalityType(null);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hapus)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addComponent(hapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelinner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelinner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelinner.setRowHeight(25);
        tabelinner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinnerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelinner);

        jLabel2.setText("DATA BELANJA TRANSAKSI UANG KELUAR");

        tabeleft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabeleft.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabeleft.setRowHeight(25);
        tabeleft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeleftMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabeleft);

        jLabel3.setText("DATA BELANJA TRANSAKSI 0 Rupiah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(313, 313, 313))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(296, 296, 296))))
                    .addComponent(jScrollPane1)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinnerMouseClicked
        int baris1 = tabelinner.getSelectedRow();
        String a = tabmode.getValueAt(baris1, 0).toString();
        String b = tabmode.getValueAt(baris1, 1).toString();
        txtId.setText(b);
    }//GEN-LAST:event_tabelinnerMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int yakinhapus = JOptionPane.showConfirmDialog(null, "Apakah yakin menghapus data?", "Warning", JOptionPane.YES_NO_OPTION);
        if (yakinhapus == 0) {
            String sql = "DELETE FROM tb_bm WHERE id_bm ='" + txtId.getText() + "'";
            String sqlDetail = "DELETE FROM tb_dt_bm WHERE id_bm ='" + txtId.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                PreparedStatement statDetail = conn.prepareStatement(sqlDetail);
                stat.executeUpdate();
                statDetail.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus " + e);
            }
        }
        dataTableInner();
        dataTableLeft();
        reset();
    }//GEN-LAST:event_hapusActionPerformed

    private void tabeleftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeleftMouseClicked
        int baris = tabeleft.getSelectedRow();
        String a = tabmode.getValueAt(baris, 0).toString();
        String b = tabmode.getValueAt(baris, 1).toString();
        txtId.setText(b);
    }//GEN-LAST:event_tabeleftMouseClicked

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
            java.util.logging.Logger.getLogger(inner_join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inner_join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inner_join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inner_join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inner_join dialog = new inner_join(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabeleft;
    private javax.swing.JTable tabelinner;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
