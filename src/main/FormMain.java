
package main;

import project.FormProjectLeader;
import room.FormRoom;
import room.FormChangeLeader;
import login.profile.FormProfile;
import login.profile.FormLogin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project.FormCreateProject;
import project.FormProjectAdmin;
import messagebox.*;

public class FormMain extends javax.swing.JFrame {


    public FormMain() {
        initComponents();
        if(NhanVien.getInstance().getMachucvu()== 1) miCreateProject.setVisible(false);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnTaiKhoan = new javax.swing.JMenu();
        MnItThongTin = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MnItLogout = new javax.swing.JMenuItem();
        MnNhanVien = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MnLeader = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        MnPM = new javax.swing.JMenu();
        miCreateProject = new javax.swing.JMenuItem();
        miProjectList = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MnAdmin = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        MnItNS = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Thiết Lập Thông Tin Show lên đây.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(jLabel1)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        MnTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        MnTaiKhoan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Avartar/icons8-name-tag-50.png"))); // NOI18N
        MnTaiKhoan.setText("Tài Khoản  ");
        MnTaiKhoan.setActionCommand(" Tài Khoản  ");
        MnTaiKhoan.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        MnItThongTin.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        MnItThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-admin-settings-male-30.png"))); // NOI18N
        MnItThongTin.setText("Hồ Sơ");
        MnItThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItThongTinActionPerformed(evt);
            }
        });
        MnTaiKhoan.add(MnItThongTin);
        MnTaiKhoan.add(jSeparator1);

        MnItLogout.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        MnItLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Edit/icons8-sign-out-30.png"))); // NOI18N
        MnItLogout.setText("Đăng Xuất");
        MnItLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItLogoutActionPerformed(evt);
            }
        });
        MnTaiKhoan.add(MnItLogout);

        jMenuBar1.add(MnTaiKhoan);

        MnNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        MnNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        MnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Avartar/icons8-account-50.png"))); // NOI18N
        MnNhanVien.setText(" Nhân Viên  ");
        MnNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem3.setText("Tạo Công Việc");
        MnNhanVien.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem4.setText("Gửi Báo Cáo");
        MnNhanVien.add(jMenuItem4);

        jMenuBar1.add(MnNhanVien);

        MnLeader.setBackground(new java.awt.Color(255, 255, 255));
        MnLeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MnLeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Avartar/icons8-contact-details-50.png"))); // NOI18N
        MnLeader.setText(" Leader  ");
        MnLeader.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem2.setText("Tạo Công Việc");
        MnLeader.add(jMenuItem2);

        jMenuItem9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem9.setText("Thêm Nhân Sự");
        MnLeader.add(jMenuItem9);

        jMenuItem6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem6.setText("Gửi Báo Cáo");
        MnLeader.add(jMenuItem6);

        jMenuBar1.add(MnLeader);

        MnPM.setBackground(new java.awt.Color(255, 255, 255));
        MnPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MnPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Avartar/icons8-walter-white-50.png"))); // NOI18N
        MnPM.setText(" PM  ");
        MnPM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MnPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnPMMousePressed(evt);
            }
        });

        miCreateProject.setText("Tạo Dự Án");
        miCreateProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCreateProjectActionPerformed(evt);
            }
        });
        MnPM.add(miCreateProject);

        miProjectList.setText("Danh Sách Dự Án");
        miProjectList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProjectListActionPerformed(evt);
            }
        });
        MnPM.add(miProjectList);

        jMenuItem5.setText("Gửi Báo Cáo");
        MnPM.add(jMenuItem5);

        jMenuBar1.add(MnPM);

        MnAdmin.setBackground(new java.awt.Color(255, 255, 255));
        MnAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Favorites/Avartar/icons8-vip-50.png"))); // NOI18N
        MnAdmin.setText(" Quản Trị Viên");
        MnAdmin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MnAdminMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnAdminMousePressed(evt);
            }
        });

        jMenu7.setText("Quản Lý Nhân Sự");
        jMenu7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        MnItNS.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        MnItNS.setText("Nhân Sự");
        MnItNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItNSActionPerformed(evt);
            }
        });
        jMenu7.add(MnItNS);

        jMenu1.setText("Phòng");

        jMenuItem12.setText("Quản Lý Phòng");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Thay Đổi Leader");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenu7.add(jMenu1);

        MnAdmin.add(jMenu7);

        jMenu2.setText("Danh Sách");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem7.setText("Danh Sách Dự Án");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem15.setText("Danh Sách Nhân Sự");
        jMenu2.add(jMenuItem15);

        jMenuItem16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem16.setText("Danh Sách Báo Cáo");
        jMenu2.add(jMenuItem16);

        MnAdmin.add(jMenu2);
        MnAdmin.add(jSeparator3);

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jMenuItem1.setText("Thống kê");
        MnAdmin.add(jMenuItem1);

        jMenuBar1.add(MnAdmin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MnItThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItThongTinActionPerformed
        try {
            FormProfile frmProfile = new FormProfile();
            frmProfile.showProfile();
            frmProfile.show();
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MnItThongTinActionPerformed

    private void MnItLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItLogoutActionPerformed
            //<editor-fold defaultstate="collapsed" desc=" Xác Nhận Đóng Form "> 
            int x = JOptionPane.showConfirmDialog(this, "Xác Nhận Đăng Xuất?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
            FormLogin frmlogin = new FormLogin();
            frmlogin.setVisible(true);
            dispose();
            } 
        //</editor-fold>
    }//GEN-LAST:event_MnItLogoutActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void MnItNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItNSActionPerformed
            try {
            ChucNang cn = new ChucNang();
            if(NhanVien.getInstance().getMachucvu() > 1){
                JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập");
            }
            else {
                NhanSu ns = new NhanSu();
                dispose();
                ns.setVisible(true); // show form
                ns.model(); //lấy jtable
                ns.comboBoxModel(); // lấy combobox
                cn.shownhanvien(ns.model);  // show nhân viên vào jtable
                cn.showcomboboxchucvu(ns.comboBoxModel);
                ns.disable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MnItNSActionPerformed

    private void miProjectListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProjectListActionPerformed
        if(NhanVien.getInstance().getMachucvu() == 2){
            FormProjectLeader frmProject = new FormProjectLeader();
            frmProject.show();
        }else {
            FormProjectAdmin frmProject = new FormProjectAdmin();
            frmProject.show();
        }
        dispose();
    }//GEN-LAST:event_miProjectListActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        try {
            ChucNang cn = new ChucNang();
            if(NhanVien.getInstance().getMachucvu() > 1){
                JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập");
            }
            else {
                FormRoom frmPhong = new FormRoom();
                frmPhong.getComboBoxModel();
                cn.showcomboboxphong(frmPhong.comboBoxModel);
                frmPhong.show();
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void MnAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAdminMouseClicked
        
    }//GEN-LAST:event_MnAdminMouseClicked

    private void MnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAdminMouseEntered
       
    }//GEN-LAST:event_MnAdminMouseEntered

    private void MnAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAdminMousePressed
        if(NhanVien.getInstance().getMachucvu()>1)
           JOptionPane.showMessageDialog(null, "bạn không có quyền truy cập");
    }//GEN-LAST:event_MnAdminMousePressed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        try {
            ChucNang cn = new ChucNang();
            FormChangeLeader frmCL = new FormChangeLeader();
            frmCL.comboBoxModel();
            //frmCL.model();
            cn.showcomboboxphong(frmCL.comboBoxModel);
            //cn.showLeader(frmCL.model);
            frmCL.show();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void miCreateProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateProjectActionPerformed
        try {
            FormCreateProject fcp;
            fcp = new FormCreateProject();
            fcp.show();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miCreateProjectActionPerformed

    private void MnPMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnPMMousePressed
        if(NhanVien.getInstance().getMachucvu()>2) MessageBox.showMessageBox().showError("Bạn Không Có Quyền Truy Cập");
    }//GEN-LAST:event_MnPMMousePressed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnAdmin;
    private javax.swing.JMenuItem MnItLogout;
    private javax.swing.JMenuItem MnItNS;
    private javax.swing.JMenuItem MnItThongTin;
    private javax.swing.JMenu MnLeader;
    private javax.swing.JMenu MnNhanVien;
    private javax.swing.JMenu MnPM;
    private javax.swing.JMenu MnTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem miCreateProject;
    private javax.swing.JMenuItem miProjectList;
    // End of variables declaration//GEN-END:variables
}
