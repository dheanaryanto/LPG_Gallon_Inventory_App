/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import com.sun.istack.internal.logging.Logger;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import java.util.logging.Level;

/**
 *
 * @author LENOVO
 */
public class transaksi_bm extends javax.swing.JDialog {

    /**
     * Creates new form data_barang
     */
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmodeSupplier;
    private DefaultTableModel tabmodeDetail;
    private DefaultTableModel tabmodeBarang;
    
    

    public void tanggal() {
        Date tgl = new Date();
        dateBm.setDate(tgl);
    }

    public void auto_id_bm() {
        try {
            Connection con = new koneksi().connect();
            java.sql.Statement stat = con.createStatement();
            Date tanggal_update = new Date();
            String tampilan = "yyMM";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(dateBm.getDate()));
            String sql = "SELECT MAX(right(id_bm,4)) as no from tb_bm where id_bm like'%" + "BM" + tanggal.toString() + "%'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    txtIdBm.setText("BM" + tanggal.toString() + "0001");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int no_id = no.length();
                    // jumlah nomor 0
                    for (int j = 0; j < 4 - no_id; j++) {
                        no = "0" + no;
                    }
                    txtIdBm.setText("BM" + tanggal.toString() + no);
                }
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan " + e);
        }
    }

    public void auto_id_dt_bm() {
        try {
            Connection con = new koneksi().connect();
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT MAX(right(id_dt_bm,2)) as no from tb_dt_bm where id_dt_bm like'%" + txtIdBmDetailBm.getText() + "%'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    txtIdDetailBm.setText(txtIdBmDetailBm.getText() + "01");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int no_id = no.length();
                    // jumlah nomor 0
                    for (int j = 0; j < 2 - no_id; j++) {
                        no = "0" + no;
                    }
                    txtIdDetailBm.setText(txtIdBmDetailBm.getText() + no);
                }
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan " + e);
        }
    }

    protected void reset() {
        tanggal();
        auto_id_bm();
//        txtIdBm.setText(null);
        txtKodeSupplierBm.setText(null);
        txtNamaSupplierBm.setText(null);
        txtKeteranganBm.setText(null);
        txtKodeSupplierBm.requestFocus();
        txtTotBlanBm.setText(noll);
    }

    protected void resetDetail() {
        auto_id_dt_bm();
//        txtIdBm.setText(null);
        txtKodeBarangDetailBm.setText(null);
        txtNamaBarangDetailBm.setText(null);
        txtJumlahBarangDetailBm.setText(null);
        txtHargaDetailBm.setText(null);
        txtTotalDetailBm.setText(null);
        txtKodeBarangDetailBm.requestFocus();
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void noTableSupplier() {
        int Baris = tabmodeSupplier.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmodeSupplier.setValueAt(nomor + ".", a, 0);
        }
    }

    public void noTableDetail() {
        int Baris = tabmodeDetail.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmodeDetail.setValueAt(nomor + ".", a, 0);
        }
    }

    public void noTableBarang() {
        int Baris = tabmodeBarang.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmodeBarang.setValueAt(nomor + ".", a, 0);
        }
    }

    public void lebarKolom() {
        TableColumn kolom;
        tabelBm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelBm.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(20);

        kolom = tabelBm.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);

        kolom = tabelBm.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);

        kolom = tabelBm.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(100);

        kolom = tabelBm.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(100);

        kolom = tabelBm.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(60);
    }

    public void lebarKolomSupplier() {
        TableColumn kolom;
        tabelSupplier.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelSupplier.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(20);

        kolom = tabelSupplier.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(20);

        kolom = tabelSupplier.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);

        kolom = tabelSupplier.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(200);
    }

    public void lebarKolomDetail() {
        TableColumn kolom;
        tabelDetailBm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelDetailBm.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);

        kolom = tabelDetailBm.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);

        kolom = tabelDetailBm.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(80);

        kolom = tabelDetailBm.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(100);

        kolom = tabelDetailBm.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(100);

        kolom = tabelDetailBm.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(50);

        kolom = tabelDetailBm.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(70);
    }

    public void lebarKolomBarang() {
        TableColumn kolom;
        tabelBarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        kolom = tabelBarang.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(10);

        kolom = tabelBarang.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(10);

        kolom = tabelBarang.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);

        kolom = tabelBarang.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(200);
    }

    public void dataTable() {
        Object[] Baris = {"No", "Tanggal", "ID Bm", "Kode Supplier", "Nama Supplier", "Keterangan", "Total Belanja"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBm.setModel(tabmode);
        String sql = "SELECT * FROM tb_bm JOIN tb_supplier ON tb_supplier.kode_supplier = tb_bm.kode_supplier "
                + " ORDER BY tb_bm.id_bm ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String tanggal = hasil.getString("tanggal");
                String id_bm = hasil.getString("id_bm");
                String kode_supplier = hasil.getString("kode_supplier");
                String nama_supplier = hasil.getString("nama_supplier");
                String keterangan = hasil.getString("keterangan");
                String total_belanja = hasil.getString("total_belanja");
                String[] data = {"", tanggal, id_bm, kode_supplier, nama_supplier, keterangan, total_belanja};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }

    public void dataTableSupplier() {
        Object[] Baris = {"No", "ID", "Kode Supplier", "Supplier"};
        tabmodeSupplier = new DefaultTableModel(null, Baris);
        tabelSupplier.setModel(tabmodeSupplier);
        String sql = "SELECT * FROM tb_supplier ORDER BY id_supplier ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_supplier = hasil.getString("id_supplier");
                String kode_supplier = hasil.getString("kode_supplier");
                String nama_supplier = hasil.getString("nama_supplier");
                String[] data = {"", id_supplier, kode_supplier, nama_supplier};
                tabmodeSupplier.addRow(data);
                noTableSupplier();
                lebarKolomSupplier();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }
    
    int total, uharga;
    
    
    public void dataTableDetail() {
        
        Object[] Baris = {"No", "ID Detail", "ID Bm", "Kode Barang", "Nama Barang", "Jumlah", "Harga", "Total"};
        tabmodeDetail = new DefaultTableModel(null, Baris);
        tabelDetailBm.setModel(tabmodeDetail);
        String sql = "SELECT * FROM tb_dt_bm "
                + " JOIN tb_bm ON tb_bm.id_bm = tb_dt_bm.id_bm "
                + " JOIN tb_barang ON tb_barang.kode_barang = tb_dt_bm.kode_barang "
                + " WHERE tb_dt_bm.id_bm = '" + txtIdBmDetailBm.getText() + "'"
                + " GROUP BY tb_dt_bm.id_dt_bm"
                + " ORDER BY tb_bm.id_bm ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_dt_bm = hasil.getString("id_dt_bm");
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String jumlah = hasil.getString("jumlah");
                String harga = hasil.getString("harga");
                String total = hasil.getString("total");
                String[] data = {"", id_dt_bm, id_bm, kode_barang, nama_barang, jumlah, harga, total};
                tabmodeDetail.addRow(data);
                noTableDetail();
                lebarKolomDetail();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dituaaaampilkan");
        }
    }

    public void dataTableBarang() {
        Object[] Baris = {"No", "ID", "Kode Barang", "Nama Barang"};
        tabmodeBarang = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmodeBarang);
        String sql = "SELECT * FROM tb_barang ORDER BY id_barang ASC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_barang = hasil.getString("id_barang");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String[] data = {"", id_barang, kode_barang, nama_barang};
                tabmodeBarang.addRow(data);
                noTableBarang();
                lebarKolomBarang();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat ditampilkan");
        }
    }

    public void cari(String sql) {
        Object[] Baris = {"No", "Tanggal", "ID Bm", "Kode Supplier", "Nama Supplier", "Keterangan", "Total Belanja"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBm.setModel(tabmode);
        int baris = tabelBm.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmode.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String tanggal = hasil.getString("tanggal");
                String id_bm = hasil.getString("id_bm");
                String kode_supplier = hasil.getString("kode_supplier");
                String nama_supplier = hasil.getString("nama_supplier");
                String keterangan = hasil.getString("keterangan");
                String total_belanja = hasil.getString("total_belanja");
                String[] data = {"", tanggal, id_bm, kode_supplier, nama_supplier, keterangan, total_belanja};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat DITAMPILKAN");
        }
    }

    public void cariSupplier(String sql) {
        Object[] Baris = {"No", "ID", "Kode Supplier", "Supplier"};
        tabmodeSupplier = new DefaultTableModel(null, Baris);
        tabelSupplier.setModel(tabmodeSupplier);
        int baris = tabelSupplier.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmodeSupplier.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_kategori = hasil.getString("id_supplier");
                String kode = hasil.getString("kode_supplier");
                String nama = hasil.getString("nama_supplier");
                String[] data = {"", id_kategori, kode, nama};
                tabmodeSupplier.addRow(data);
                noTableSupplier();
                lebarKolomSupplier();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat DITAMPILKA");
        }
    }

    public void cariDetail(String sql) {
        Object[] Baris = {"No", "ID Detail", "ID Bm", "Kode Barang", "Nama Barang", "Jumlah", "Harga", "Total"};
        tabmodeDetail = new DefaultTableModel(null, Baris);
        tabelDetailBm.setModel(tabmodeDetail);
        int baris = tabelDetailBm.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmodeDetail.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_dt_bm = hasil.getString("id_dt_bm");
                String id_bm = hasil.getString("id_bm");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String jumlah = hasil.getString("jumlah");
                String harga = hasil.getString("harga");
                String total = hasil.getString("total");
                String[] data = {"", id_dt_bm, id_bm, kode_barang, nama_barang, jumlah, harga, total};
                tabmodeDetail.addRow(data);
                noTableDetail();
                lebarKolomDetail();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat DITAMPILKAN");
        }
    }

    public void cariBarang(String sql) {
        Object[] Baris = {"No", "ID", "Kode Barang", "Nama Barang"};
        tabmodeBarang = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmodeBarang);
        int baris = tabelBarang.getRowCount();
        for (int x = 0; 1 < baris; x++) {
            tabmodeBarang.removeRow(x);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id_barang = hasil.getString("id_barang");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String[] data = {"", id_barang, kode_barang, nama_barang};
                tabmodeBarang.addRow(data);
                noTableBarang();
                lebarKolomBarang();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat DITAMPILKA");
        }
    }

    public transaksi_bm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tanggal();
        auto_id_bm();
        dataTable();
        lebarKolom();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listSupplier = new javax.swing.JDialog();
        txtCariSupplier = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelSupplier = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        detailBm = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKodeBarangDetailBm = new javax.swing.JTextField();
        btnTambahDetailBm = new javax.swing.JButton();
        btnResetDetailBm = new javax.swing.JButton();
        btnBatalDetailBm = new javax.swing.JButton();
        btnKodeBarangDetailBm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtIdBmDetailBm = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNamaBarangDetailBm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHargaDetailBm = new javax.swing.JTextField();
        txtIdDetailBm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtJumlahBarangDetailBm = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTotalDetailBm = new javax.swing.JTextField();
        btnCekDetailBm = new javax.swing.JButton();
        btnUbahDetailBm = new javax.swing.JButton();
        btnHapusDetailBm = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelDetailBm = new javax.swing.JTable();
        txtCariDetailBm = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TotAmt = new javax.swing.JLabel();
        TotAmt1 = new javax.swing.JLabel();
        listBarang = new javax.swing.JDialog();
        txtCariBarang = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeSupplierBm = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKodeSupplier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIdBm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNamaSupplierBm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKeteranganBm = new javax.swing.JTextField();
        dateBm = new com.toedter.calendar.JDateChooser();
        btnDetail = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTotBlanBm = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBm = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        listSupplier.setMinimumSize(new java.awt.Dimension(420, 400));
        listSupplier.setModalityType(null);

        txtCariSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariSupplierActionPerformed(evt);
            }
        });
        txtCariSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariSupplierKeyTyped(evt);
            }
        });

        tabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSupplier.setRowHeight(30);
        tabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelSupplier);

        jLabel3.setText("Cari");

        javax.swing.GroupLayout listSupplierLayout = new javax.swing.GroupLayout(listSupplier.getContentPane());
        listSupplier.getContentPane().setLayout(listSupplierLayout);
        listSupplierLayout.setHorizontalGroup(
            listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(listSupplierLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        listSupplierLayout.setVerticalGroup(
            listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCariSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        detailBm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        detailBm.setTitle("Detail Barang Masuk");
        detailBm.setMinimumSize(new java.awt.Dimension(1099, 537));
        detailBm.setModalityType(null);
        detailBm.setPreferredSize(new java.awt.Dimension(1099, 537));

        jPanel4.setBackground(new java.awt.Color(0, 204, 51));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("ID Detail");

        jLabel9.setText("Kode Bar");

        btnTambahDetailBm.setText("Tambah");
        btnTambahDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDetailBmActionPerformed(evt);
            }
        });

        btnResetDetailBm.setText("Reset");
        btnResetDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDetailBmActionPerformed(evt);
            }
        });

        btnBatalDetailBm.setText("Selesai");
        btnBatalDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalDetailBmActionPerformed(evt);
            }
        });

        btnKodeBarangDetailBm.setText("jButton1");
        btnKodeBarangDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKodeBarangDetailBmActionPerformed(evt);
            }
        });

        jLabel10.setText("ID BM");

        txtIdBmDetailBm.setEditable(false);
        txtIdBmDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBmDetailBmKeyPressed(evt);
            }
        });

        jLabel11.setText("Nama Bar");

        txtNamaBarangDetailBm.setEditable(false);
        txtNamaBarangDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangDetailBmKeyPressed(evt);
            }
        });

        jLabel12.setText("Harga");

        txtHargaDetailBm.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtHargaDetailBmInputMethodTextChanged(evt);
            }
        });
        txtHargaDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaDetailBmActionPerformed(evt);
            }
        });
        txtHargaDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHargaDetailBmKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaDetailBmKeyTyped(evt);
            }
        });

        txtIdDetailBm.setEditable(false);
        txtIdDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdDetailBmKeyPressed(evt);
            }
        });

        jLabel14.setText("Jumlah Bar");

        txtJumlahBarangDetailBm.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtJumlahBarangDetailBmInputMethodTextChanged(evt);
            }
        });
        txtJumlahBarangDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahBarangDetailBmKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahBarangDetailBmKeyTyped(evt);
            }
        });

        jLabel16.setText("Total");

        txtTotalDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDetailBmActionPerformed(evt);
            }
        });
        txtTotalDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalDetailBmKeyPressed(evt);
            }
        });

        btnCekDetailBm.setText("Cek");
        btnCekDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDetailBmActionPerformed(evt);
            }
        });

        btnUbahDetailBm.setText("Ubah");
        btnUbahDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahDetailBmActionPerformed(evt);
            }
        });

        btnHapusDetailBm.setText("Hapus");
        btnHapusDetailBm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDetailBmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdBmDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtKodeBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnKodeBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtIdDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtNamaBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHargaDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtJumlahBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCekDetailBm)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtTotalDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnUbahDetailBm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTambahDetailBm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnResetDetailBm, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(btnHapusDetailBm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBatalDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtIdBmDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKodeBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnKodeBarangDetailBm)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNamaBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtJumlahBarangDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtHargaDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTotalDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCekDetailBm)
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahDetailBm)
                    .addComponent(btnResetDetailBm))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbahDetailBm)
                    .addComponent(btnHapusDetailBm))
                .addGap(18, 18, 18)
                .addComponent(btnBatalDetailBm)
                .addGap(38, 38, 38))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelDetailBm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDetailBm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelDetailBm.setRowHeight(25);
        tabelDetailBm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDetailBmMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelDetailBm);

        txtCariDetailBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariDetailBmKeyTyped(evt);
            }
        });

        jLabel13.setText("Cari");

        TotAmt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotAmt.setText("Total ");

        TotAmt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TotAmt1.setText("Tota: Rp. ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TotAmt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotAmt)
                .addGap(81, 81, 81))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariDetailBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotAmt)
                    .addComponent(TotAmt1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout detailBmLayout = new javax.swing.GroupLayout(detailBm.getContentPane());
        detailBm.getContentPane().setLayout(detailBmLayout);
        detailBmLayout.setHorizontalGroup(
            detailBmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        detailBmLayout.setVerticalGroup(
            detailBmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        listBarang.setTitle("List Barang Masuk");
        listBarang.setMinimumSize(new java.awt.Dimension(420, 400));
        listBarang.setModalityType(null);

        txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariBarangKeyTyped(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.setRowHeight(30);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelBarang);

        jLabel15.setText("Cari");

        javax.swing.GroupLayout listBarangLayout = new javax.swing.GroupLayout(listBarang.getContentPane());
        listBarang.getContentPane().setLayout(listBarangLayout);
        listBarangLayout.setHorizontalGroup(
            listBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listBarangLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariBarang))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addContainerGap())
        );
        listBarangLayout.setVerticalGroup(
            listBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Barang Masuk");
        setModalityType(null);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Tanggal");

        jLabel2.setText("Kode Supp");

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

        btnKodeSupplier.setText("jButton1");
        btnKodeSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKodeSupplierActionPerformed(evt);
            }
        });

        jLabel5.setText("ID BM");

        txtIdBm.setEditable(false);
        txtIdBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdBmKeyPressed(evt);
            }
        });

        jLabel6.setText("Nama supp");

        txtNamaSupplierBm.setEditable(false);
        txtNamaSupplierBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaSupplierBmKeyPressed(evt);
            }
        });

        jLabel7.setText("Keterangan");

        txtKeteranganBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeteranganBmKeyPressed(evt);
            }
        });

        dateBm.setDateFormatString("dd-MM-yyyy");

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        jLabel17.setText("Total Belanja");

        txtTotBlanBm.setEditable(false);
        txtTotBlanBm.setText("0");
        txtTotBlanBm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotBlanBmKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(txtKeteranganBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdBm, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(149, 149, 149)
                                        .addComponent(btnKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dateBm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTambah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetail)))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(txtTotBlanBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKodeSupplierBm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaSupplierBm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dateBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtIdBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKodeSupplierBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnKodeSupplier)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNamaSupplierBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTotBlanBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKeteranganBm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal)
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelBm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelBm.setRowHeight(25);
        tabelBm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBm);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
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
                .addContainerGap(67, Short.MAX_VALUE))
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

    private void tabelBmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBmMouseClicked
        int baris = tabelBm.getSelectedRow();
        String a = tabmode.getValueAt(baris, 0).toString();

        String b = tabmode.getValueAt(baris, 1).toString();

        String c = tabmode.getValueAt(baris, 2).toString();

        String d = tabmode.getValueAt(baris, 3).toString();

        String e = tabmode.getValueAt(baris, 4).toString();

        String f = tabmode.getValueAt(baris, 5).toString();
        
        String g = tabmode.getValueAt(baris, 6).toString();

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelBm.getValueAt(baris, 1));

        } catch (ParseException ex) {
//            Logger.getLogger(transaksi_bm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data tidak dapat DITAMPILKAN " + ex);
        }

        dateBm.setDate(dateValue);
        txtIdBm.setText(c);
        txtKodeSupplierBm.setText(d);
        txtNamaSupplierBm.setText(e);
        txtKeteranganBm.setText(f);
        txtTotBlanBm.setText(g);
        
    }//GEN-LAST:event_tabelBmMouseClicked

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sql = "SELECT * FROM tb_bm JOIN tb_supplier ON tb_supplier.kode_supplier = tb_bm.kode_supplier "
                + " WHERE tb_bm.id_bm LIKE '%" + txtCari.getText() + "%' or "
                + " tb_bm.kode_supplier LIKE '%" + txtCari.getText() + "%' or "
                + " tb_supplier.nama_supplier LIKE '%" + txtCari.getText() + "%' or "
                + " tb_bm.keterangan LIKE '%" + txtCari.getText() + "%' or "
                + " tb_bm.total_belanja LIKE '%" + txtCari.getText() + "%'";
                
        cari(sql);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void tabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupplierMouseClicked
        int baris = tabelSupplier.getSelectedRow();
        String a = tabmodeSupplier.getValueAt(baris, 0).toString();

        String b = tabmodeSupplier.getValueAt(baris, 1).toString();

        String c = tabmodeSupplier.getValueAt(baris, 2).toString();

        String d = tabmodeSupplier.getValueAt(baris, 3).toString();

        txtKodeSupplierBm.setText(c);
        txtNamaSupplierBm.setText(d);
        listSupplier.setVisible(false);
    }//GEN-LAST:event_tabelSupplierMouseClicked

    private void txtCariSupplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariSupplierKeyTyped
        String sql = "SELECT * FROM tb_supplier "
                + " WHERE kode_supplier LIKE '%" + txtCariSupplier.getText() + "%' or "
                + " nama_supplier LIKE '%" + txtCariSupplier.getText() + "%'";
        cariSupplier(sql);
        lebarKolomSupplier();
    }//GEN-LAST:event_txtCariSupplierKeyTyped
    int Uharga, Tot;
    private void btnTambahDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDetailBmActionPerformed
        if (txtIdDetailBm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else if (txtKodeBarangDetailBm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else if (txtJumlahBarangDetailBm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else {
            String sql = "INSERT INTO tb_dt_bm (id_dt_bm, id_bm, kode_barang, jumlah, harga, total) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txtIdDetailBm.getText());
                stat.setString(2, txtIdBmDetailBm.getText());
                stat.setString(3, txtKodeBarangDetailBm.getText());
                stat.setString(4, txtJumlahBarangDetailBm.getText());
                stat.setString(5, txtHargaDetailBm.getText());
                stat.setString(6, txtTotalDetailBm.getText());
                stat.executeUpdate();
                dataTableDetail();
                resetDetail();
//                auto_id_bm();
                txtKodeBarangDetailBm.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal ditambah " + e);
            }
        }
        autosum();
    }//GEN-LAST:event_btnTambahDetailBmActionPerformed

    private void btnResetDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDetailBmActionPerformed
        resetDetail();
    }//GEN-LAST:event_btnResetDetailBmActionPerformed

    private void btnBatalDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalDetailBmActionPerformed
        String sql = "UPDATE tb_bm set tanggal=?, id_bm=?, kode_supplier=?, keterangan=?, total_belanja=? WHERE id_bm ='" + txtIdBm.getText() + "'";
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(dateBm.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal);
            stat.setString(2, txtIdBm.getText());
            stat.setString(3, txtKodeSupplierBm.getText());
            stat.setString(4, txtKeteranganBm.getText());
            stat.setString(5, TotAmt.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diubah ");
            dataTable();
            reset();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah " + e);
        }
        detailBm.setVisible(false);

    }//GEN-LAST:event_btnBatalDetailBmActionPerformed

    private void btnKodeBarangDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKodeBarangDetailBmActionPerformed
        dataTableBarang();
        lebarKolomBarang();
        listBarang.setVisible(true);
        listBarang.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnKodeBarangDetailBmActionPerformed

    private void txtIdBmDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBmDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBmDetailBmKeyPressed

    private void txtNamaBarangDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangDetailBmKeyPressed

    private void txtHargaDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaDetailBmKeyPressed

    private void tabelDetailBmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDetailBmMouseClicked
        int baris = tabelDetailBm.getSelectedRow();
        String a = tabmodeDetail.getValueAt(baris, 0).toString();

        String b = tabmodeDetail.getValueAt(baris, 1).toString();

        String c = tabmodeDetail.getValueAt(baris, 2).toString();

        String d = tabmodeDetail.getValueAt(baris, 3).toString();

        String e = tabmodeDetail.getValueAt(baris, 4).toString();

        String f = tabmodeDetail.getValueAt(baris, 5).toString();

        String g = tabmodeDetail.getValueAt(baris, 6).toString();
        
        String h = tabmodeDetail.getValueAt(baris, 7).toString();

        txtIdDetailBm.setText(b);
        txtIdBmDetailBm.setText(c);
        txtKodeBarangDetailBm.setText(d);
        txtNamaBarangDetailBm.setText(e);
        txtJumlahBarangDetailBm.setText(f);
        txtHargaDetailBm.setText(g);
        txtTotalDetailBm.setText(h);
    }//GEN-LAST:event_tabelDetailBmMouseClicked

    private void txtCariDetailBmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariDetailBmKeyTyped
        String sql = "SELECT * FROM tb_dt_bm "
                + " JOIN tb_bm ON tb_bm.id_bm = tb_dt_bm.id_bm "
                + " JOIN tb_barang ON tb_barang.kode_barang = tb_dt_bm.kode_barang "
                + " WHERE tb_dt_bm.id_bm = '" + txtIdBmDetailBm.getText() + "' AND tb_dt_bm.kode_barang LIKE'%" + txtCariDetailBm.getText() + "%' OR "
                + " tb_dt_bm.id_bm = '" + txtIdBmDetailBm.getText() + "' AND tb_dt_bm.id_dt_bm LIKE'%" + txtCariDetailBm.getText() + "%' OR "
                + " tb_dt_bm.id_bm = '" + txtIdBmDetailBm.getText() + "' AND tb_barang.nama_barang LIKE'%" + txtCariDetailBm.getText() + "%' OR "
                + " tb_dt_bm.id_bm = '" + txtIdBmDetailBm.getText() + "' AND tb_dt_bm.jumlah LIKE'%" + txtCariDetailBm.getText() + "%'"
                + " GROUP BY tb_dt_bm.id_dt_bm"
                + " ORDER BY tb_bm.id_bm ASC";
        cariDetail(sql);
        lebarKolomDetail();
    }//GEN-LAST:event_txtCariDetailBmKeyTyped

    private void txtIdDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDetailBmKeyPressed

    private void txtJumlahBarangDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahBarangDetailBmKeyPressed

    private void txtCariBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyTyped
        String sql = "SELECT * FROM tb_barang "
                + " WHERE kode_barang LIKE '%" + txtCariBarang.getText() + "%' or "
                + " nama_barang LIKE '%" + txtCariBarang.getText() + "%'";
        cariBarang(sql);
        lebarKolomBarang();
    }//GEN-LAST:event_txtCariBarangKeyTyped

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int baris = tabelBarang.getSelectedRow();
        String a = tabmodeBarang.getValueAt(baris, 0).toString();

        String b = tabmodeBarang.getValueAt(baris, 1).toString();

        String c = tabmodeBarang.getValueAt(baris, 2).toString();

        String d = tabmodeBarang.getValueAt(baris, 3).toString();

        txtKodeBarangDetailBm.setText(c);
        txtNamaBarangDetailBm.setText(d);
        txtJumlahBarangDetailBm.requestFocus();
        listBarang.setVisible(false);
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void txtHargaDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaDetailBmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaDetailBmActionPerformed

    private void txtTotalDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDetailBmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDetailBmActionPerformed

    private void txtTotalDetailBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalDetailBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDetailBmKeyPressed

    private void btnCekDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDetailBmActionPerformed
        Uharga = Integer.valueOf(txtHargaDetailBm.getText());
        Tot = Uharga * Integer.valueOf(txtJumlahBarangDetailBm.getText());
        txtTotalDetailBm.setText(String.valueOf(Tot));
        
    }//GEN-LAST:event_btnCekDetailBmActionPerformed

    public void autosum(){
        int total =0;
        for (int i=0; i < tabelDetailBm.getRowCount(); i++){
            int amount = Integer.parseInt((String)tabelDetailBm.getValueAt(i, 7));
            total +=amount;
        }
        TotAmt.setText(""+total);
    }
    
    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        detailBm.setVisible(true);
        detailBm.setLocationRelativeTo(this);
        txtIdBmDetailBm.setText(txtIdBm.getText());
        dataTableDetail();
        lebarKolomDetail();
        auto_id_dt_bm();
        autosum();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void txtKeteranganBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeteranganBmKeyPressed

    private void txtNamaSupplierBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaSupplierBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaSupplierBmKeyPressed

    private void txtIdBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBmKeyPressed

    private void btnKodeSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKodeSupplierActionPerformed
        dataTableSupplier();
        lebarKolomSupplier();
        listSupplier.setVisible(true);
        listSupplier.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnKodeSupplierActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int yakinhapus = JOptionPane.showConfirmDialog(null, "Apakah yakin menghapus data?", "Warning", JOptionPane.YES_NO_OPTION);
        if (yakinhapus == 0) {
            String sql = "DELETE FROM tb_bm WHERE id_bm ='" + txtIdBm.getText() + "'";
            String sqlDetail = "DELETE FROM tb_dt_bm WHERE id_bm ='" + txtIdBm.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                PreparedStatement statDetail = conn.prepareStatement(sqlDetail);
                stat.executeUpdate();
                statDetail.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                dataTable();
                reset();
                txtKodeSupplierBm.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus " + e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "UPDATE tb_bm set tanggal=?, id_bm=?, kode_supplier=?, keterangan=?, total_belanja=? WHERE id_bm ='" + txtIdBm.getText() + "'";
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(dateBm.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal);
            stat.setString(2, txtIdBm.getText());
            stat.setString(3, txtKodeSupplierBm.getText());
            stat.setString(4, txtKeteranganBm.getText());
            stat.setString(5, txtTotBlanBm.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diubah ");
            dataTable();
            reset();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah " + e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed
    String noll = "0";
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtIdBm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else if (txtKodeSupplierBm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh kosong");
        } else {
            String sql = "INSERT INTO tb_bm (tanggal, id_bm, kode_supplier, keterangan, total_belanja) VALUES (?, ?, ?, ?, ?)";
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(dateBm.getDate()));
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tanggal);
                stat.setString(2, txtIdBm.getText());
                stat.setString(3, txtKodeSupplierBm.getText());
                stat.setString(4, txtKeteranganBm.getText());
                stat.setString(5, txtTotBlanBm.getText());
                stat.executeUpdate();
                dataTable();
                detailBm.setVisible(true);
                detailBm.setLocationRelativeTo(this);
                txtIdBmDetailBm.setText(txtIdBm.getText());
                dataTableDetail();
                lebarKolomDetail();
                auto_id_dt_bm();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal ditambah " + e);
            }
        }
        TotAmt.setText(noll);
        resetDetail();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtTotBlanBmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotBlanBmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotBlanBmKeyPressed

    private void txtCariSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariSupplierActionPerformed

    private void btnUbahDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahDetailBmActionPerformed
        String sql = "UPDATE tb_dt_bm set id_dt_bm=?, id_bm=?, kode_barang=?, jumlah=?, harga=?, total=? WHERE id_dt_bm ='" + txtIdDetailBm.getText() + "'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtIdDetailBm.getText());
            stat.setString(2, txtIdBmDetailBm.getText());
            stat.setString(3, txtKodeBarangDetailBm.getText());
            stat.setString(4, txtJumlahBarangDetailBm.getText());
            stat.setString(5, txtHargaDetailBm.getText());
            stat.setString(6, txtTotalDetailBm.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diubah ");
            dataTableDetail();
            resetDetail();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah " + e);
        }
        autosum();
    }//GEN-LAST:event_btnUbahDetailBmActionPerformed

    private void btnHapusDetailBmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDetailBmActionPerformed
        int yakinhapus = JOptionPane.showConfirmDialog(null, "Apakah yakin menghapus data?", "Warning", JOptionPane.YES_NO_OPTION);
        if (yakinhapus == 0) {
            String sql = "DELETE FROM tb_dt_bm WHERE id_dt_bm ='" + txtIdDetailBm.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                dataTableDetail();
                resetDetail();
                txtKodeBarangDetailBm.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus " + e);
            }
        }
        autosum();
    }//GEN-LAST:event_btnHapusDetailBmActionPerformed

    private void txtJumlahBarangDetailBmInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtJumlahBarangDetailBmInputMethodTextChanged

    }//GEN-LAST:event_txtJumlahBarangDetailBmInputMethodTextChanged

    private void txtHargaDetailBmInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtHargaDetailBmInputMethodTextChanged

    }//GEN-LAST:event_txtHargaDetailBmInputMethodTextChanged

    private void txtJumlahBarangDetailBmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangDetailBmKeyTyped

    }//GEN-LAST:event_txtJumlahBarangDetailBmKeyTyped

    private void txtHargaDetailBmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaDetailBmKeyTyped

    }//GEN-LAST:event_txtHargaDetailBmKeyTyped

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
            java.util.logging.Logger.getLogger(transaksi_bm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi_bm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi_bm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi_bm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                transaksi_bm dialog = new transaksi_bm(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel TotAmt;
    private javax.swing.JLabel TotAmt1;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalDetailBm;
    private javax.swing.JButton btnCekDetailBm;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusDetailBm;
    private javax.swing.JButton btnKodeBarangDetailBm;
    private javax.swing.JButton btnKodeSupplier;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetDetailBm;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahDetailBm;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnUbahDetailBm;
    private com.toedter.calendar.JDateChooser dateBm;
    private javax.swing.JDialog detailBm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JDialog listBarang;
    private javax.swing.JDialog listSupplier;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelBm;
    private javax.swing.JTable tabelDetailBm;
    private javax.swing.JTable tabelSupplier;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariBarang;
    private javax.swing.JTextField txtCariDetailBm;
    private javax.swing.JTextField txtCariSupplier;
    private javax.swing.JTextField txtHargaDetailBm;
    private javax.swing.JTextField txtIdBm;
    private javax.swing.JTextField txtIdBmDetailBm;
    private javax.swing.JTextField txtIdDetailBm;
    private javax.swing.JTextField txtJumlahBarangDetailBm;
    private javax.swing.JTextField txtKeteranganBm;
    private javax.swing.JTextField txtKodeBarangDetailBm;
    private javax.swing.JTextField txtKodeSupplierBm;
    private javax.swing.JTextField txtNamaBarangDetailBm;
    private javax.swing.JTextField txtNamaSupplierBm;
    private javax.swing.JTextField txtTotBlanBm;
    private javax.swing.JTextField txtTotalDetailBm;
    // End of variables declaration//GEN-END:variables
}
