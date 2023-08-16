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
public class data_barang extends javax.swing.JDialog {

    /**
     * Creates new form data_barang
     */
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode1;

    protected void reset() {
        txtId.setText(null);
        txtKode.setText(null);
        txtNama.setText(null);
        txtKategori.setText(null);
        txtJumlahBarang.setText(null);
        txtKode.requestFocus();
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void noTable1() {
        int Baris = tabmode1.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode1.setValueAt(nomor + ".", a, 0);
        }
    }

    public void lebarKolom() {
        TableColumn kolom;
        tabelBarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelBarang.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(10);

        kolom = tabelBarang.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(10);

        kolom = tabelBarang.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);

        kolom = tabelBarang.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(100);

        kolom = tabelBarang.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(100);

        kolom = tabelBarang.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(100);
    }

    public void lebarKolom1() {
        TableColumn kolom;
        tabelDetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelDetail.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(10);

        kolom = tabelDetail.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(10);

        kolom = tabelDetail.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);

        kolom = tabelDetail.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(200);
    }

    public void dataTable() {
        Object[] Baris = {"No", "ID", "Kode", "Nama", "Kategori", "Jumlah"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmode);
        String sql = "SELECT * FROM tb_barang ORDER BY id_barang ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_barang = hasil.getString("id_barang");
                String kode = hasil.getString("kode_barang");
                String nama = hasil.getString("nama_barang");
                String kategori = hasil.getString("kode_kategori");
                String jumlah_barang = hasil.getString("jumlah_barang");
                String[] data = {"", id_barang, kode, nama, kategori, jumlah_barang};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }

    public void dataTable1() {
        Object[] Baris = {"No", "ID", "Kode", "Nama"};
        tabmode1 = new DefaultTableModel(null, Baris);
        tabelDetail.setModel(tabmode1);
        String sql = "SELECT * FROM tb_kategori ORDER BY id_kategori ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_kategori = hasil.getString("id_kategori");
                String kode = hasil.getString("kode_kategori");
                String nama = hasil.getString("nama_kategori");
                String[] data = {"", id_kategori, kode, nama};
                tabmode1.addRow(data);
                noTable1();
                lebarKolom1();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }

    public void cari(String sql) {
        Object[] Baris = {"No", "ID", "Kode", "Nama", "Kategori", "Jumlah"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmode);
        int baris = tabelBarang.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmode.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_barang = hasil.getString("id_barang");
                String kode = hasil.getString("kode_barang");
                String nama = hasil.getString("nama_barang");
                String kategori = hasil.getString("kode_kategori");
                String jumlah_barang = hasil.getString("jumlah_barang");
                String[] data = {"", id_barang, kode, nama, kategori, jumlah_barang};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }

    public void cari1(String sql1) {
        Object[] Baris = {"No", "ID", "Kode", "Nama"};
        tabmode1 = new DefaultTableModel(null, Baris);
        tabelDetail.setModel(tabmode1);
        int baris = tabelDetail.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmode1.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql1);
            while (hasil.next()) {
                String id_kategori = hasil.getString("id_kategori");
                String kode = hasil.getString("kode_kategori");
                String nama = hasil.getString("nama_kategori");
                String[] data = {"", id_kategori, kode, nama};
                tabmode1.addRow(data);
                noTable1();
                lebarKolom1();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }

    public data_barang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lebarKolom();
        dataTable();
        txtId.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listDetail = new javax.swing.JDialog();
        txtCariDetail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelDetail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        listDetail.setMinimumSize(new java.awt.Dimension(420, 400));
        listDetail.setModalityType(null);

        txtCariDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariDetailKeyTyped(evt);
            }
        });

        tabelDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelDetail.setRowHeight(30);
        tabelDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelDetail);

        jLabel3.setText("Cari");

        javax.swing.GroupLayout listDetailLayout = new javax.swing.GroupLayout(listDetail.getContentPane());
        listDetail.getContentPane().setLayout(listDetailLayout);
        listDetailLayout.setHorizontalGroup(
            listDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(listDetailLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listDetailLayout.setVerticalGroup(
            listDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCariDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Barang");
        setModalityType(null);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Kode");

        jLabel2.setText("Kategori");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnDetail.setText("jButton1");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        txtKode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeKeyPressed(evt);
            }
        });

        jLabel5.setText("Nama");

        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKeyPressed(evt);
            }
        });

        jLabel6.setText("Jumlah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtJumlahBarang, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDetail)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelBarang.setRowHeight(25);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        jLabel4.setText("Cari");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int baris = tabelBarang.getSelectedRow();
        String a = tabmode.getValueAt(baris, 0).toString();

        String b = tabmode.getValueAt(baris, 1).toString();

        String c = tabmode.getValueAt(baris, 2).toString();

        String d = tabmode.getValueAt(baris, 3).toString();

        String e = tabmode.getValueAt(baris, 4).toString();
        
        String f = tabmode.getValueAt(baris, 5).toString();

        txtId.setText(b);
        txtKode.setText(c);
        txtNama.setText(d);
        txtKategori.setText(e);
        txtJumlahBarang.setText(f);

    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtKode.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        }else if (txtNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else if (txtKategori.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else {
            String sql = "INSERT INTO tb_barang (kode_barang, nama_barang, kode_kategori, jumlah_barang) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txtKode.getText());
                stat.setString(2, txtNama.getText());
                stat.setString(3, txtKategori.getText());
                stat.setString(4, txtJumlahBarang.getText());
                stat.executeUpdate();
                dataTable();
                txtKode.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal ditambah " + e);
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int yakinhapus = JOptionPane.showConfirmDialog(null, "Apakah yakin menghapus data?", "Warning", JOptionPane.YES_NO_OPTION);
        if (yakinhapus == 0) {
            String sql = "DELETE FROM tb_barang WHERE id_barang ='" + txtId.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                dataTable();
                reset();
                txtKode.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus " + e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "UPDATE tb_barang set kode_barang=?, nama_barang=?, kode_kategori=?, jumlah_barang=? WHERE id_barang ='" + txtId.getText() + "'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKode.getText());
            stat.setString(2, txtNama.getText());
            stat.setString(3, txtKategori.getText());
             stat.setString(4, txtJumlahBarang.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diubah ");
            dataTable();
            reset();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah " + e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sql = "SELECT * FROM tb_barang "
                + " WHERE kode_barang LIKE '%" + txtCari.getText() + "%' or "
                + " nama_barang LIKE '%" + txtCari.getText() + "%' or "
                + " kode_kategori LIKE '%" + txtCari.getText() + "%' or "
                + "jumlah_barang LIKE '%" + txtCari.getText() + "%'";
        cari(sql);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tabelDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDetailMouseClicked
        int baris = tabelDetail.getSelectedRow();
        String a = tabmode1.getValueAt(baris, 0).toString();

        String b = tabmode1.getValueAt(baris, 1).toString();

        String c = tabmode1.getValueAt(baris, 2).toString();

        String d = tabmode1.getValueAt(baris, 3).toString();

        txtKategori.setText(c);
        listDetail.setVisible(false);
    }//GEN-LAST:event_tabelDetailMouseClicked

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        dataTable1();
        lebarKolom1();
        listDetail.setVisible(true);
        listDetail.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnDetailActionPerformed

    private void txtKodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeKeyPressed

    private void txtNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKeyPressed

    private void txtCariDetailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDetailKeyTyped
        String sql1 = "SELECT * FROM tb_kategori "
                + " WHERE kode_kategori LIKE '%" + txtCariDetail.getText() + "%' or "
                + " nama_kategori LIKE '%" + txtCariDetail.getText() + "%'";
        cari1(sql1);
        lebarKolom1();
    }//GEN-LAST:event_txtCariDetailKeyTyped

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
            java.util.logging.Logger.getLogger(data_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                data_barang dialog = new data_barang(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog listDetail;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelDetail;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariDetail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKategori;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
