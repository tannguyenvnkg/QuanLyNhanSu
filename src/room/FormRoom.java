/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

import room.FormCreateRoom;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import main.ChucNang;
import main.FormMain;

/**
 *
 * @author tanng
 */
public class FormRoom extends javax.swing.JFrame {
    
    //<editor-fold defaultstate="collapsed" desc=" Khởi Tạo Model combobox ">
    public DefaultComboBoxModel comboBoxModel = null;
    public DefaultComboBoxModel getComboBoxModel(){
        return comboBoxModel = (DefaultComboBoxModel)cboPhong.getModel();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Khởi Tạo Model Table ">
    public DefaultTableModel modelShowStaff_OutRoom = null;
    public DefaultTableModel getModelShowNhanVien(){
        return modelShowStaff_OutRoom = (DefaultTableModel)tableShowStaff_OutRoom.getModel();
    }
    public DefaultTableModel modelShowStaff_InRoom = null;
    public DefaultTableModel getModelLuuNhanVien(){
        return modelShowStaff_InRoom = (DefaultTableModel)tableShowStaff_InRoom.getModel();
    }
//</editor-fold>
    /**
     * Creates new form FormCreateProject
     */
    public FormRoom() {
        initComponents();
        tableShowStaff_OutRoom.setDefaultEditor(Object.class , null); // không được phép sửa trên jtable
        tableShowStaff_InRoom.setDefaultEditor(Object.class , null);
        tableShowStaff_OutRoom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // chỉ được phép chọn 1 dòng trong Jtable
        tableShowStaff_InRoom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //txtLeader.setEditable(false);
        JTableHeader header = tableShowStaff_InRoom.getTableHeader();    
        header.setForeground(Color.black);
        header.setBackground(Color.red);
        header.setFont(new Font("Times New Roman", Font.BOLD , 18));
        
        JTableHeader theader = tableShowStaff_OutRoom.getTableHeader();    
        theader.setForeground(Color.black);
        theader.setBackground(Color.red);
        theader.setFont(new Font("Times New Roman", Font.BOLD , 18));
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
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowStaff_OutRoom = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableShowStaff_InRoom = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCreateRoom = new javax.swing.JButton();
        cboPhong = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnTimKiemNhanVien = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLeader = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Quản Lý Phòng");

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tableShowStaff_OutRoom.setBackground(new java.awt.Color(236, 255, 255));
        tableShowStaff_OutRoom.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tableShowStaff_OutRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên"
            }
        ));
        tableShowStaff_OutRoom.setGridColor(new java.awt.Color(0, 0, 0));
        tableShowStaff_OutRoom.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tableShowStaff_OutRoom.setSelectionForeground(new java.awt.Color(255, 0, 0));
        tableShowStaff_OutRoom.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableShowStaff_OutRoom);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-add-user-female-30.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-denied-30.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-checked-user-male-30.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tableShowStaff_InRoom.setBackground(new java.awt.Color(236, 255, 255));
        tableShowStaff_InRoom.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tableShowStaff_InRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên"
            }
        ));
        tableShowStaff_InRoom.setGridColor(new java.awt.Color(0, 0, 0));
        tableShowStaff_InRoom.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tableShowStaff_InRoom.setSelectionForeground(new java.awt.Color(255, 0, 0));
        tableShowStaff_InRoom.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableShowStaff_InRoom);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-undo-30.png"))); // NOI18N
        btnBack.setText("Trở Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        btnCreateRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnCreateRoom.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnCreateRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-add-user-group-man-woman-30.png"))); // NOI18N
        btnCreateRoom.setText("Tạo Phòng");
        btnCreateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRoomActionPerformed(evt);
            }
        });

        cboPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboPhongMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboPhongMouseReleased(evt);
            }
        });
        cboPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhongActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setText("Chọn Phòng :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnCreateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        btnTimKiemNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKiemNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btnTimKiemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-find-user-male-30.png"))); // NOI18N
        btnTimKiemNhanVien.setText("Tìm Kiếm");
        btnTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemNhanVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Leader :");

        txtLeader.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(116, 116, 116)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FormMain frmChinh = new FormMain();
        frmChinh.show();
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        getModelShowNhanVien();
        TableModel tb1 = tableShowStaff_OutRoom.getModel();
        DefaultTableModel tb2 = (DefaultTableModel)tableShowStaff_InRoom.getModel();
        
        int indexs[] = tableShowStaff_OutRoom.getSelectedRows();
        
        Object[] row = new Object[3];
        for (int i = 0; i < indexs.length; i++) {
            row[0] = tb1.getValueAt(indexs[i], 0);
            row[1] = tb1.getValueAt(indexs[i], 1);
            //row[2] = tb1.getValueAt(indexs[i], 2);
            
            tb2.addRow(row);
            modelShowStaff_OutRoom.removeRow(indexs[i]);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
//        DefaultTableModel tb = (DefaultTableModel)tableluunhanvien.getModel();
//        DefaultTableModel tb2 = (DefaultTableModel)tableshownhanvien.getModel();

            getModelShowNhanVien();
            getModelLuuNhanVien();
            TableModel tb1 = tableShowStaff_InRoom.getModel();
            ChucNang cn = new ChucNang();
            int indexs[] = tableShowStaff_InRoom.getSelectedRows();
            String tennhanvien = tb1.getValueAt(indexs[0], 1).toString();
            String tenphong = cboPhong.getSelectedItem().toString();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogresult = JOptionPane.showConfirmDialog (null, "Bạn Muốn Xóa Nhân Viên \""+tennhanvien+"\" Ra Khỏi Phòng \""+tenphong+"\" ?","Warning",dialogButton);
            if (dialogresult == 0){
                Object[] row = new Object[3];
                for (int i = 0; i < indexs.length; i++) {
                row[0] = tb1.getValueAt(indexs[i], 0);
                row[1] = tb1.getValueAt(indexs[i], 1);
                //row[2] = tb1.getValueAt(indexs[i], 2);
                String manhanvien = tb1.getValueAt(indexs[i], 0).toString();
                
                if(cn.CheckChucVu_TruyenMaNhanvien(manhanvien) != 3){
                    cn.DeleteNhanVienRaKhoiPhong_FormPhong(manhanvien,tenphong);
                    // show lại 2 table sao khi delete
                    cn.showStaffInRoom_OutRoom(modelShowStaff_OutRoom, tenphong);
                    cn.showStaffInRoom_InRoom(modelShowStaff_InRoom, tenphong);
                    JOptionPane.showMessageDialog(null, "Xóa Nhân Viên Thành Công");
                }else if(cn.CheckChucVu_TruyenMaNhanvien(manhanvien) == 0) JOptionPane.showMessageDialog(null, "Lỗi");
                else JOptionPane.showMessageDialog(null, "Không Thể Xóa Leader");
            }
            }
            
        } catch (SQLException ex) {
                Logger.getLogger(FormRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            getModelLuuNhanVien();
            getModelShowNhanVien();
            String tenphong = cboPhong.getSelectedItem().toString();
            ChucNang cn = new ChucNang();
            ArrayList<String> chuoi = new ArrayList<String>();
            for (int i = 0; i < modelShowStaff_InRoom.getRowCount(); i++) {
                chuoi.add(modelShowStaff_InRoom.getValueAt(i, 0).toString());
            }
            cn.AddNhanVienVaoPhong(chuoi,tenphong);
            cn.showStaffInRoom_OutRoom(modelShowStaff_OutRoom, tenphong);
            cn.showStaffInRoom_InRoom(modelShowStaff_InRoom, tenphong);
            JOptionPane.showMessageDialog(null, "Lưu Thành Công");
        } catch (SQLException ex) {
            Logger.getLogger(FormRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRoomActionPerformed
        try {
            FormCreateRoom fcr = new FormCreateRoom();
            ChucNang cn = new ChucNang();
            fcr.setVisible(true);
            fcr.model();
            cn.showLeader(fcr.model);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(FormRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateRoomActionPerformed

    private void btnTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
        try {
        String chuoi = txttimkiem.getText();
        getModelShowNhanVien();
        ChucNang cn = new ChucNang();
        String tenphong = (String) cboPhong.getSelectedItem(); // lấy tên phòng để tìm leader
        if (chuoi.equals("")) { // trống thì xuất hết
            cn.showStaffInRoom_OutRoom(modelShowStaff_OutRoom,tenphong);
        }else {
            if(cn.KiemTraKieuDuLieuCuaChuoi(chuoi) == 1)  cn.SearchNhanVienTheoMa_CoMaPhong(modelShowStaff_OutRoom,chuoi,tenphong);
            else if(cn.KiemTraKieuDuLieuCuaChuoi(chuoi) == 2) cn.SearchNhanVienTheoTen_CoMaPhong(modelShowStaff_OutRoom,chuoi,tenphong);
            else if(cn.KiemTraKieuDuLieuCuaChuoi(chuoi) == 3) 
                JOptionPane.showMessageDialog(null, "Bạn chỉ có thể nhập số hoặc chữ\n Tìm theo mã : Nhập Số \n Tìm theo tên : Nhập Tên");
            txttimkiem.setText("");
        }
        } catch (SQLException ex) {
            Logger.getLogger(FormRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemNhanVienActionPerformed

    private void cboPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhongMousePressed
        
    }//GEN-LAST:event_cboPhongMousePressed

    private void cboPhongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhongMouseReleased
        
    }//GEN-LAST:event_cboPhongMouseReleased

    private void cboPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhongActionPerformed
       try {
            ChucNang cn = new ChucNang();
            String roomName = (String) cboPhong.getSelectedItem(); // lấy tên phòng để tìm leader
            txtLeader.setText(cn.TenLeader(roomName)); // set tên leader cho text
            
            getModelShowNhanVien();
            getModelLuuNhanVien();
            cn.showStaffInRoom_OutRoom(modelShowStaff_OutRoom,roomName);
            cn.showStaffInRoom_InRoom(modelShowStaff_InRoom,roomName);
        } catch (SQLException ex) {
            Logger.getLogger(FormRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboPhongActionPerformed

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
            java.util.logging.Logger.getLogger(FormRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateRoom;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimKiemNhanVien;
    private javax.swing.JComboBox<String> cboPhong;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tableShowStaff_InRoom;
    private javax.swing.JTable tableShowStaff_OutRoom;
    private javax.swing.JTextField txtLeader;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
