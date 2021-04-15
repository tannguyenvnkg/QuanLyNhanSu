/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhansu;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanSu extends javax.swing.JFrame {

    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    //<editor-fold defaultstate="collapsed" desc=" Khởi Tạo Model Table ">
    DefaultTableModel model = null;
    public DefaultTableModel model(){
        return model = (DefaultTableModel)tablenhanvien.getModel();
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Khởi Tạo Model combobox ">
    DefaultComboBoxModel comboBoxModel = null;
    public DefaultComboBoxModel comboBoxModel(){
        return comboBoxModel = (DefaultComboBoxModel)cboChucVu.getModel();
    }
    //</editor-fold>
    /**
     * Creates new form NhanSu
     */
    public NhanSu() {
        initComponents();
        tablenhanvien.setDefaultEditor(Object.class , null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtngioitinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmanhanvien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttennhanvien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox<>();
        txtdiachi = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablenhanvien = new javax.swing.JTable();
        btnActive = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btngetback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        txtngaysinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(236, 255, 255));

        jLabel3.setText("SĐT : ");
        jLabel3.setToolTipText("");

        jLabel4.setText("Ngày Sinh :");

        jLabel5.setText("Địa Chỉ :");

        jLabel6.setText("Chức Vụ :");

        jLabel7.setText("Mật Khẩu :");

        cboChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuActionPerformed(evt);
            }
        });

        tablenhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Họ Tên", "Giới Tính", "Ngày Sinh", "SDT", "Địa Chỉ", "Chức Vụ", "Trạng Thái"
            }
        ));
        tablenhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablenhanvien);

        btnActive.setBackground(new java.awt.Color(255, 255, 255));
        btnActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-key-2-30.png"))); // NOI18N
        btnActive.setText("Active");
        btnActive.setToolTipText("");
        btnActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiveActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã Nhân Viên :");

        jLabel2.setText("Họ Tên :");

        btngetback.setBackground(new java.awt.Color(255, 255, 255));
        btngetback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-undo-30.png"))); // NOI18N
        btngetback.setText("Trở Lại");
        btngetback.setMinimumSize(new java.awt.Dimension(91, 25));
        btngetback.setPreferredSize(new java.awt.Dimension(109, 40));
        btngetback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngetbackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(236, 255, 255));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-denied-30.png"))); // NOI18N
        btnDelete.setText(" Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(91, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-checked-user-male-30.png"))); // NOI18N
        btnSave.setText(" Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(91, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAddNew.setBackground(new java.awt.Color(255, 255, 255));
        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-add-user-female-30.png"))); // NOI18N
        btnAddNew.setText("Thêm Mới");
        btnAddNew.setPreferredSize(new java.awt.Dimension(91, 40));
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnSapXep.setBackground(new java.awt.Color(255, 255, 255));
        btnSapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-change-30.png"))); // NOI18N
        btnSapXep.setText("Sắp Xếp");
        btnSapXep.setPreferredSize(new java.awt.Dimension(91, 40));
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-find-user-male-30.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setPreferredSize(new java.awt.Dimension(91, 40));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Quản Lý Nhân Sự");

        rbtngioitinh.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnNam.setText("Nam");

        rbtngioitinh.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtnNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btngetback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                            .addComponent(txttennhanvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                            .addComponent(txtmatkhau, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                            .addComponent(cboChucVu, 0, 229, Short.MAX_VALUE)
                                            .addComponent(txtngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbtnNam)
                                            .addComponent(rbtnNu))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnNam))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttennhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnNu))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActive, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngetback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
       enable();
       clear();
       txtmanhanvien.disable();
       txtmatkhau.disable();
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void cboChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuActionPerformed
        
    }//GEN-LAST:event_cboChucVuActionPerformed

    private void btngetbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngetbackActionPerformed
            //<editor-fold defaultstate="collapsed" desc="Xác Nhận Đóng Form "> 
            int x = JOptionPane.showConfirmDialog(this, "Bạn muốn quay lại?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
            FormChinh frmC = new FormChinh();
            frmC.setVisible(true);
            dispose();
            } 
            //</editor-fold>
    }//GEN-LAST:event_btngetbackActionPerformed

    private void tablenhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhanvienMouseClicked
        try {
            enable();
            model();
            txtmanhanvien.disable();
            txtmatkhau.enable();
            txtngaysinh.enable();;
            int a = tablenhanvien.getSelectedRow();
            txtmanhanvien.setText(model.getValueAt(a, 0).toString());
            txttennhanvien.setText(model.getValueAt(a, 1).toString());
            if((model.getValueAt(a, 2).toString()).equals("Nam")) rbtnNam.setSelected(true); else rbtnNu.setSelected(true);
            
            txtngaysinh.setDate(date.parse((model.getValueAt(a, 3)).toString()));
            txtsdt.setText(model.getValueAt(a, 4).toString());
            txtdiachi.setText(model.getValueAt(a, 5).toString());
          //  txtmatkhau.setText(model.getValueAt(a, 6).toString());
            cboChucVu.setSelectedItem(model.getValueAt(a, 7).toString());
        } catch (ParseException ex) {
            Logger.getLogger(NhanSu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tablenhanvienMouseClicked

    private void btnActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiveActionPerformed
        try {
            ChucNang cn = new ChucNang();
            String ma = txtmanhanvien.getText();
            if (!ma.equals("")) {
            cn.ActiveNhanVien(ma);
            }else JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Nhân Viên Để Active");
            clear();
            cn.shownhanvien(model);
        } catch (SQLException ex) {
               Logger.getLogger(NhanSu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnActiveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       try {
            ChucNang cn = new ChucNang();
            String ma = txtmanhanvien.getText();
            if(!ma.equals("")){
                cn.DeleteNhanVien(ma);
            }else JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Nhân Viên Để Xóa");
            clear();
            cn.shownhanvien(model);
        } catch (SQLException ex) {
            Logger.getLogger(NhanSu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            boolean gioitinh = true;
            ChucNang cn = new ChucNang();
            String ma = txtmanhanvien.getText();
            String ten = txttennhanvien.getText();
            if(rbtnNu.isSelected()) gioitinh = false;
            String ngaysinh = date.format(txtngaysinh.getDate());
            String sdt = txtsdt.getText();
            String diachi = txtdiachi.getText();
            String matkhau = txtmatkhau.getText();
            String chucvu = (String) cboChucVu.getSelectedItem();
            if(!ten.equals("")){
                if(!cn.checkma(ma)) cn.AddNhanVien(/*ma,*/ten,ngaysinh,diachi,sdt,gioitinh,/*,matkhau*/chucvu);
                else cn.UpdateNhanVien(ma,ten,ngaysinh,diachi,sdt,gioitinh,matkhau,chucvu);
                clear();
                cn.shownhanvien(model);
            }else JOptionPane.showMessageDialog(null, "Tên Nhân Viên Không Được Để trống!!!");
            
        } catch (SQLException ex) {
            Logger.getLogger(NhanSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NhanSu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed
    public void clear(){
        txtmanhanvien.disable();
        txtmanhanvien.setText("");
        txttennhanvien.setText(""); 
        txtsdt.setText(""); 
        txtdiachi.setText(""); 
        txtmatkhau.setText("");
        cboChucVu.setSelectedItem("");
        txtngaysinh.cleanup();
        //cboChucVu.disable();
    }
    public void disable(){
        txtmanhanvien.disable();
        txtmatkhau.disable();
//        txttennhanvien.disable();
//        txtsdt.disable();
//        txtdiachi.disable();
//        cboChucVu.disable();
//        txtngaysinh.disable();
    }
    public void enable(){
        txtmanhanvien.enable();
        txtngaysinh.enable(true);
        txttennhanvien.enable();
        txtsdt.enable();
        txtdiachi.enable();
        txtmatkhau.enable();
        cboChucVu.enable();
    }
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
            java.util.logging.Logger.getLogger(NhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanSu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActive;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btngetback;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.ButtonGroup rbtngioitinh;
    private javax.swing.JTable tablenhanvien;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtmanhanvien;
    private javax.swing.JTextField txtmatkhau;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttennhanvien;
    // End of variables declaration//GEN-END:variables
}
