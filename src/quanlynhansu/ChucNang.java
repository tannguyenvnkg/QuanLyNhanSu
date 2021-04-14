/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<editor-fold defaultstate="collapsed" desc="Ghi Chú">
//</editor-fold>
package quanlynhansu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanng
 */
public class ChucNang extends Database{
    
    //<editor-fold defaultstate="collapsed" desc="Login">
    public  boolean login(String user, String pass) throws SQLException, NoSuchAlgorithmException{
        connect(); // kết nối database
        pass = MD5(pass);
        String query = "select * from NHANVIEN where manhanvien= '"+user+"' and matkhau = '"+pass+"'";
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
            NhanVien.getInstance().LuuNhanVien(rs);
            return true;
        }
        else return false;
    }
    public boolean checktrangthai() {
        return NhanVien.getInstance().getTrangthai();
    }
//</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc=" show nhân viên lên jtable">
     public void shownhanvien(DefaultTableModel model){
        connect();
        // query get nhân viên từ database sắp sếp theo chức vụ và Active
        String query = "select * from nhanvien \n" +
                        "order by (case manhanvien\n" +
                        "when 'AD%' then 1\n" +
                        "when 'PM%' then 2\n" +
                        "when 'LD%' then 3\n" +
                        "when 'NV%' then 4\n" +
                        "end) desc, trangthainhanvien desc"; 
        model.setRowCount(0); // clear jtable
            try {
                String trangthai = "";
                String chucvu = "";
                String gioitinh = "";
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                String ma = rs.getString("manhanvien");
                String ten = rs.getString("tennhanvien");
                String ngaysinh = date.format(rs.getDate("ngaysinh"));
                String address = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                if(rs.getBoolean("gioitinh")) gioitinh = "Nam"; else gioitinh = "Nữ";
                String matkhau = rs.getString("matkhau");
                
                if(rs.getBoolean("trangthainhanvien")) trangthai = "Active";
                else trangthai = "Deactive";
                
                chucvu = laytenchucvu(rs.getInt("machucvu"));
                String tbData[] = {ma,ten,gioitinh,ngaysinh,SDT,address,chucvu,trangthai}; 
                model.addRow(tbData);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormChinh.class.getName()).log(Level.SEVERE, null, ex);
            }                   
    
    }
     public String laytenchucvu(int ma) throws SQLException{
        connect();
        String query = "select tenchucvu from chucvu where machucvu = "+ma+"";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            return rs.getString(1);
        }
        return null;
     }
     // add combobox tại quản lý
    public void showcombobox(DefaultComboBoxModel aBoxModel) throws SQLException{
        connect();
        String query = "Select * from chucvu";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {                
            aBoxModel.addElement(rs.getString("Tenchucvu"));
        }
    } 
    //</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="Đổi Pass">
    // đổi pass
    public boolean checkpass(String passString){
        return passString.equals(NhanVien.getInstance().matkhau);
    }
    public void ChangePass(String newpass,String confirmpass) throws SQLException{
        if(newpass.equals(confirmpass)){
            if (newpass.equals("") || confirmpass.equals("") ) {
                JOptionPane.showMessageDialog(null, "Mật Khẩu Không Được Để Trống !!!");
            } else {
                connect();
                String query = "update NHANVIEN set MatKhau = '"+newpass+"' where manhanvien = '"+NhanVien.getInstance().manhanvien+"'";
                stmt.execute(query);
                NhanVien.getInstance().setMatkhau(newpass);
                JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Mật Khẩu Không Khớp!!!");
        }
    }
//</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="Thêm Xóa Sửa Active Nhân Viên">
    //Thêm Xóa Sửa Nhân Viên
    public void UpdateNhanVien(String ma,String ten,String ngaysinh,String diachi,String sdt,boolean gioitinh,String matkhau,String chucvu) throws SQLException, NoSuchAlgorithmException{
        connect();
        int machucvu = 0;
        int sex = 0;
        if(gioitinh) sex = 1; // set giới tính
        String getidchucvu = "select machucvu from chucvu where tenchucvu = N'"+chucvu+"'"; // lấy mã nhân viên
        ResultSet rs = stmt.executeQuery(getidchucvu);
        while(rs.next()){
            machucvu = rs.getInt(1); // set mã nhân viên
        }
        matkhau = MD5(matkhau);
        String query = 
            "Update nhanvien set machucvu = '"+machucvu+"',"
                + "tennhanvien = N'"+ten+"' , sdt='"+sdt+"', ngaysinh = '"+ngaysinh+"',"
                + "diachi=N'"+diachi+"',matkhau='"+matkhau+"', gioitinh = "+sex+" where manhanvien='"+ma+"'";
        stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Update Nhân Viên Thành Công");
    }
    public void AddNhanVien(String ten,String ngaysinh,String diachi,String sdt,boolean gioitinh, String chucvu) throws SQLException, NoSuchAlgorithmException{
        connect();
        // tạo tài khoản=========================================================================================
        int count = 0;
        int machucvu = 0;
        int sex = 0;
        if(gioitinh) sex = 1;
        String getidchucvu = "select machucvu from chucvu where tenchucvu = N'"+chucvu+"'";
        ResultSet rs = stmt.executeQuery(getidchucvu);
        while(rs.next()){
            machucvu = rs.getInt(1);
        }
        // đếm số lượng nhân viên theo mã chức vụ
        String demnhanvien = "Select count(*) from nhanvien";
        ResultSet rs1 = stmt.executeQuery(demnhanvien);
        while(rs1.next()){
            count = rs1.getInt(1);
        }
        String ma = String.valueOf(count + 1); // khởi tạo tài khoản
        //======================================================================================
        String matkhau = MD5(ma); // cho mật khẩu và tài khoản trùng nhau
        String query = "insert into nhanvien values('"+ma+"',N'"+ten+"','"+ngaysinh+"',N'"+diachi+"','"+sdt+"',"+sex+",'"+matkhau+"',1,"+machucvu+")";
        stmt.execute(query);//chạy query
        JOptionPane.showMessageDialog(null, "Add Nhân Viên Thành Công \n Tài Khoản : "+ma+"\n Mật Khẩu : "+ma+"");
    }
    public void DeleteNhanVien(String ma) throws SQLException{
        connect();
        String query = "update nhanvien set trangthainhanvien = 0 where manhanvien = '"+ma+"'";
        stmt.execute(query);
        JOptionPane.showMessageDialog(null, "Delete Nhân Viên Thành Công");
    }
    public void ActiveNhanVien(String ma) throws SQLException{
        connect();
        String query = "update nhanvien set trangthainhanvien = 1 where manhanvien = '"+ma+"'";
        stmt.execute(query);
        JOptionPane.showMessageDialog(null, "Active Nhân Viên Thành Công");
    }
      
    public boolean checkma(String ma) throws SQLException{
        connect();
        String query = "Select* from NhanVien";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            if(rs.getString("manhanvien").equals(ma)) return true; // tồn tại mã nhân viên thì update
        }
        return false; // không tồn tại thì add
    }
    //</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="mã hóa MD5">
     public String MD5(String pass) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] byteData = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
           sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
         return sb.toString();
     }
     //</editor-fold>
    //==========================================================================================================
}

