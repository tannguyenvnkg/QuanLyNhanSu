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
       // Statement stmt1 = conn.createStatement();
        pass = MD5(pass);
        String query = "select * from NHANVIEN where manhanvien= '"+user+"' and matkhau = '"+pass+"'";
        //String querychucvu = "select * from THOIGIANNHANVIEC where manhanvien = '"+user+"'";
        ResultSet rs = stmt.executeQuery(query);
        ResultSet rs1 = getTHOIGIANNHANVIEC(user);
        if(rs.next() && rs1.next()){
            NhanVien.getInstance().LuuNhanVien(rs,rs1);
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
     public void shownhanvien(DefaultTableModel model) throws SQLException{
        connect();
        //Statement stmt1 = conn.createStatement();
        // query get nhân viên từ database sắp sếp theo chức vụ và Active
        String query = "select * from nhanvien \n" +
                        "order by " +
                        "trangthainhanvien desc"; 
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
                    //String matkhau = rs.getString("matkhau");

                    if(rs.getBoolean("trangthainhanvien")) trangthai = "Active";
                    else trangthai = "Deactive";

                    ResultSet rs1 = getTHOIGIANNHANVIEC(ma);
                    while (rs1.next()) {                        
                        chucvu = laytenchucvu(rs1.getInt("machucvu"));
                    }
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
    public boolean checkpass(String passString) throws NoSuchAlgorithmException{
        passString = MD5(passString);
        return passString.equals(NhanVien.getInstance().matkhau);
    }
    public boolean ChangePass(String newpass,String confirmpass) throws SQLException, NoSuchAlgorithmException{
        if(newpass.equals(confirmpass)){   //check pass mới giống nhau
            //<editor-fold defaultstate="collapsed" desc="Giữ code này">

//            if (newpass.equals("") || confirmpass.equals("") ) {
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
//            } else {}
//</editor-fold>
            connect();
            newpass = MD5(newpass);
            String checktrungpass = NhanVien.getInstance().getManhanvien();
            checktrungpass = MD5(checktrungpass);
            if(checktrungpass.equals(newpass)){
                JOptionPane.showMessageDialog(null, "Mật Khẩu Không Được Trùng Với Tài Khoản");
                return false;
            }
            else {
                String query = "update NHANVIEN set MatKhau = '"+newpass+"' where manhanvien = '"+NhanVien.getInstance().manhanvien+"'";
                stmt.execute(query);
                NhanVien.getInstance().setMatkhau(newpass);
                JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công");
                return true;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Mật Khẩu Không Khớp!!!");  //check mật khẩu mới khác nhau
        }
        return false;
    }
//</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="Thêm Xóa Sửa Active Nhân Viên">
    //Thêm Xóa Sửa Nhân Viên
    public void UpdateNhanVien(String ma,String ten,String ngaysinh,String diachi,String sdt,boolean gioitinh,String chucvu) throws SQLException, NoSuchAlgorithmException{
        connect();
        //Statement stmt1 = conn.createStatement();
        int machucvu = 0;
        int sex = 0;
        if(gioitinh) sex = 1; // set giới tính
        //<editor-fold defaultstate="collapsed" desc="Set Chức Vụ">
        String getidchucvu = "select machucvu from chucvu where tenchucvu = N'"+chucvu+"'"; // lấy mã chức vụ
        ResultSet rs = stmt.executeQuery(getidchucvu);
        while(rs.next()){
            machucvu = rs.getInt(1); // set mã nhân viên gán với chức vụ
        }
        //</editor-fold>
        String query = 
            "Update nhanvien set "
                + "tennhanvien = N'"+ten+"' , sdt='"+sdt+"', ngaysinh = '"+ngaysinh+"',"
                + "diachi=N'"+diachi+"', gioitinh = "+sex+" where manhanvien='"+ma+"'";
        stmt.execute(query);
        addTHOIGIANNHANVIEC(ma, machucvu);
            JOptionPane.showMessageDialog(null, "Update Nhân Viên Thành Công");
    }
    public void AddNhanVien(String ten,String ngaysinh,String diachi,String sdt,boolean gioitinh, String chucvu) throws SQLException, NoSuchAlgorithmException{
        connect();
        // tạo tài khoản=========================================================================================
        //int count = 0;
        int machucvu = 0;
        int sex = 0;
        if(gioitinh) sex = 1;
        String getidchucvu = "select machucvu from chucvu where tenchucvu = N'"+chucvu+"'";
        ResultSet rs = stmt.executeQuery(getidchucvu);
        while(rs.next()){
            machucvu = rs.getInt(1);
        }
//        // đếm số lượng nhân viên theo mã chức vụ
//        String demnhanvien = "Select count(*) from nhanvien";
//        ResultSet rs1 = stmt.executeQuery(demnhanvien);
//        while(rs1.next()){
//            count = rs1.getInt(1);
//        }
        String ma = "";
        // kiểm tra tồn tại mã
        do {
            int code = (int) Math.floor(((Math.random() * 899999) + 100000));
            ma = String.valueOf(code); // khởi tạo tài khoản
        } while (checkma(ma));
        //======================================================================================
        String matkhau = MD5(ma); // cho mật khẩu và tài khoản trùng nhau
        String query = "insert into nhanvien values('"+ma+"',N'"+ten+"','"+ngaysinh+"',N'"+diachi+"','"+sdt+"',"+sex+",'"+matkhau+"',1)";
        //String query1 = "insert into THOIGIANNHANVIEC values('"+ma+"',"+machucvu+",current_timestamp)";
        stmt.execute(query);//chạy query
        addTHOIGIANNHANVIEC(ma, machucvu);
        //stmt.execute(query1);
        JOptionPane.showMessageDialog(null, "Add Nhân Viên Thành Công \n Tài Khoản : "+ma+"\n Mật Khẩu : "+ma+"");
    }
    public void DeleteNhanVien(String ma) throws SQLException{
        connect();
        String querycheck = "select trangthainhanvien from nhanvien where manhanvien = '"+ma+"'";
        ResultSet rs = stmt.executeQuery(querycheck);
        while (rs.next()) {            
            if(!rs.getBoolean("trangthainhanvien")) JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Nhân Viên Này!!!");
            else {
                String query = "update nhanvien set trangthainhanvien = 0 where manhanvien = '"+ma+"'";
                stmt.execute(query);
                JOptionPane.showMessageDialog(null, "Delete Nhân Viên Thành Công");
            }
        }
        
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
    public void resetpassword(String ma) throws NoSuchAlgorithmException, SQLException{
        connect();
        String matkhau = ma;
        String matkhaumd5 = MD5(ma);
        String query = "update nhanvien set matkhau = '"+matkhaumd5+"' where manhanvien = '"+ma+"'";
        stmt.execute(query);
        JOptionPane.showMessageDialog(null, "Reset mật khẩu thành công \n Mật khẩu mới : "+matkhau+"");
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
    //<editor-fold defaultstate="collapsed" desc="Linh Tinh">
    public ResultSet getTHOIGIANNHANVIEC(String ma) throws SQLException{
        connect();
        String querychucvu = "select top 1 * from THOIGIANNHANVIEC where manhanvien = '"+ma+"' order by ngaynhancv desc";
        ResultSet rs = stmt.executeQuery(querychucvu);
        return rs;
    }
    public void addTHOIGIANNHANVIEC(String ma, int machucvu) throws SQLException{
        connect();
        String query1 = "insert into THOIGIANNHANVIEC values('"+ma+"',"+machucvu+",current_timestamp)";
        stmt.execute(query1);
    }
    //</editor-fold>
}

