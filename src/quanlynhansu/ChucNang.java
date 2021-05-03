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
    DefaultTableModel modeltemp = null;
    //<editor-fold defaultstate="collapsed" desc="Form Login">
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
    public boolean FirstLogin(String user, String pass) throws NoSuchAlgorithmException{
        user = MD5(user);
        if(user.equals(NhanVien.getInstance().getMatkhau())) return true;
        return false;
    }
//</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="show nhân viên lên jtable">
    
    public void shownhanvien_Admin(DefaultTableModel modeltemp){
        connect();
        //Statement stmt1 = conn.createStatement();
        // query get nhân viên từ database sắp sếp theo chức vụ và Active
        String query = "select * from nhanvien \n" +
                        "order by " +
                        "trangthainhanvien desc"; 
        modeltemp.setRowCount(0); // clear jtable
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
                    modeltemp.addRow(tbData);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormChinh.class.getName()).log(Level.SEVERE, null, ex);
            }      
    }
    public void shownhanvien_PM(DefaultTableModel modeltemp){
        connect();
        //Statement stmt1 = conn.createStatement();
        // query get nhân viên từ database sắp sếp theo chức vụ và Active
        String query = "select * from nhanvien \n" +
                        "order by " +
                        "manhanvien asc,trangthainhanvien desc"; 
        modeltemp.setRowCount(0); // clear jtable
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
                    if(chucvu.equals("Admin") || chucvu.equals("Project Manager") ) continue;
                    String tbData[] = {ma,ten,chucvu}; 
                    modeltemp.addRow(tbData);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormChinh.class.getName()).log(Level.SEVERE, null, ex);
            }      
    }
    public void shownhanvien(DefaultTableModel model) throws SQLException{
        modeltemp = model;
        if(NhanVien.getInstance().machucvu == 1) shownhanvien_Admin(modeltemp);
        else shownhanvien_PM(modeltemp);
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
    public void showcomboboxchucvu(DefaultComboBoxModel aBoxModel) throws SQLException{
        connect();
        String query = "Select * from chucvu";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {                
            aBoxModel.addElement(rs.getString("Tenchucvu"));
        }
    } 
    public void SearchNhanVienTheoMa(DefaultTableModel modeltemp,String manhanvien){
        connect();
        String query = "select * from dbo.timnhanvientheoma(N'"+manhanvien+"')";
        modeltemp.setRowCount(0);
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
                    modeltemp.addRow(tbData);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormChinh.class.getName()).log(Level.SEVERE, null, ex);
            }      
    }
    public void SearchNhanVienTheoTen(DefaultTableModel modeltemp,String tennhanvien){
        connect();
        String query = "select * from dbo.timnhanvientheoten(N'"+tennhanvien+"')";
        modeltemp.setRowCount(0);
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
                    modeltemp.addRow(tbData);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormChinh.class.getName()).log(Level.SEVERE, null, ex);
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
    //<editor-fold defaultstate="collapsed" desc="Form Nhân Sự - Quyền Admin">
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
            "Update nhanvien set machucvu = '"+machucvu+"',"
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
        
        String query = "insert into nhanvien values('"+ma+"',N'"+ten+"','"+ngaysinh+"',N'"+diachi+"','"+sdt+"',"+sex+",'"+matkhau+"',1,'"+machucvu+"')";
        //String query1 = "insert into THOIGIANNHANVIEC values('"+ma+"',"+machucvu+",current_timestamp)";
        stmt.execute(query);//chạy query
        addTHOIGIANNHANVIEC(ma, machucvu);// add thơi gian nhận việc cho nhân viên
        JOptionPane.showMessageDialog(null, "Add Nhân Viên Thành Công \n Tài Khoản : "+ma+"\n Mật Khẩu : "+ma+"");
    }
    public void DeleteNhanVien(String ma) throws SQLException{
        connect();
        Statement stmt1 = conn.createStatement();
        String querycheck = "select trangthainhanvien from nhanvien where manhanvien = '"+ma+"'";
        ResultSet rs = stmt.executeQuery(querycheck);
        while (rs.next()) {            
            if(!rs.getBoolean("trangthainhanvien")) JOptionPane.showMessageDialog(null, "Bạn Đã Xóa Nhân Viên Này!!!");
            else {
                String query = "update nhanvien set trangthainhanvien = 0 where manhanvien = '"+ma+"'";
                stmt1.execute(query);
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
    //<editor-fold defaultstate="collapsed" desc="Hàm Dùng Lại Nhiều Lần">
    public ResultSet getTHOIGIANNHANVIEC(String ma) throws SQLException{
        connect();
        String querychucvu = "select top 1 * from THOIGIANNHANVIEC where manhanvien = '"+ma+"' order by ngaynhancv desc";
        ResultSet rs = stmt.executeQuery(querychucvu);
        return rs;
    }
    public void addTHOIGIANNHANVIEC(String ma, int machucvu) throws SQLException{
        connect();
        Statement stmt1 = conn.createStatement();
        String checkmakhongdoi = "select top 1 * from THOIGIANNHANVIEC where manhanvien = '"+ma+"' order by ngaynhancv desc";
        ResultSet rs = stmt1.executeQuery(checkmakhongdoi); // nếu không đổi chức vụ thì không add thời gian nhận việc mới
        if (!rs.next()) {            
            String query1 = "insert into THOIGIANNHANVIEC values('"+ma+"',"+machucvu+",current_timestamp)";
            stmt.execute(query1);
        }else if(!(rs.getInt("machucvu") == machucvu)){
            Statement stmt2 = conn.createStatement();
            String query1 = "insert into THOIGIANNHANVIEC values('"+ma+"',"+machucvu+",current_timestamp)";
            stmt2.execute(query1);
        }
    }
    public int CheckChucVu_TruyenMaNhanvien(String manhanvien) throws SQLException{
        connect();
        String query = "select machucvu from nhanvien where manhanvien = '"+manhanvien+"'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            return rs.getInt(1);
        }
        return 0;
    }
    public int KiemTraKieuDuLieuCuaChuoi(String chuoi){
        Character c = chuoi.charAt(0);
        int flag;
        if(Character.isDigit(c)) flag = 1; 
        else flag = 2;
        int kytuhientai = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if(Character.isDigit(chuoi.charAt(i))) kytuhientai = 1;
            else kytuhientai = 2;
            if(flag != kytuhientai) return 3;
        }
        return kytuhientai;
    }
    //</editor-fold>
    //==========================================================================================================
    //<editor-fold defaultstate="collapsed" desc="Form Phòng - Quyền Admin">
    public void showcomboboxphong(DefaultComboBoxModel aBoxModel) throws SQLException{
        connect();
        String query = "Select * from phong";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {                
            aBoxModel.addElement(rs.getString("tenphong"));
        }
    }
    public void CreateRoom(String maphong, String tenphong, String maLeader) throws SQLException{
        if(checkLeader(maLeader)) JOptionPane.showMessageDialog(null, "Người Này Đang Làm Leader cho 1 phòng khác");
        else if(!checkroom(maphong)){
           connect();
           String query = "insert into PHONG values('"+maphong+"',N'"+tenphong+"','"+maLeader+"')";
           stmt.execute(query);
           nhanphong(maLeader, maphong);
           JOptionPane.showMessageDialog(null, "Add Thành Công"); 
        }else JOptionPane.showMessageDialog(null, "Mã Phòng Đã Tồn Tại");
    }
    public void DeleteNhanVienRaKhoiPhong_FormPhong(String manhanvien,String tenphong) throws SQLException{
        connect();
        String maphong = getMaphong(tenphong);
        String query = "update THOIGIANNHANPHONG\n" +
                        "set ngayroiphong = CURRENT_TIMESTAMP\n" +
                        "where manhanvien = N'"+manhanvien+"' and maphong = '"+maphong+"'";
        stmt.execute(query);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Add nhân viên vào THOIGIANNHANPHONG">
    public void nhanphong(String manhanvien,String maphong) throws SQLException{
        connect();
        if(!DaCoPhong(manhanvien,maphong)){ // kiểm tra nhân viên đã có phòng chưa
            String query = "insert into THOIGIANNHANPHONG values('"+manhanvien+"','"+maphong+"',current_timestamp,null)";
            stmt.execute(query);
            System.out.println("Insert manhanvien : " + manhanvien);
        }
        else System.out.println("Mã nhân viên : " +manhanvien+ " đã có phòng");
    }
    public boolean DaCoPhong(String manhanvien, String maphong) throws SQLException{
        connect();
        //SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String query = "select top 1 * from THOIGIANNHANPHONG\n" +
                        "where manhanvien = '"+manhanvien+"' and maphong = '"+maphong+"'" +
                         "order by ngaynhanphong desc";
        ResultSet rs = stmt.executeQuery(query);
        Statement stmt1 = conn.createStatement();
        ResultSet rs1 = stmt1.executeQuery(query);
        if(!rs.next()) return false;
        while(rs1.next()) {                
            if(rs1.getDate("ngayroiphong") != null) return false;
        }
        return true;
    }
    public void AddNhanVienVaoPhong(ArrayList<String> chuoimanhanvien, String tenphong) throws SQLException{
        String maphong = getMaphong(tenphong); // lấy mã phòng từ tên phòng
        for (String obj : chuoimanhanvien){
            nhanphong(obj, maphong);
        }
        JOptionPane.showMessageDialog(null, "Lưu Thành Công");
    }
    public String getMaphong(String tenphong) throws SQLException{
        connect();
        String query = "select maphong from phong where tenphong = N'"+tenphong+"'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            return rs.getString(1);
        }
        return null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Xuất nhân viên vào 2 jtable">
    public void tableshownhanvien_FormPhong(DefaultTableModel model, String tenphong) throws SQLException{
        connect();
        String maphong = getMaphong(tenphong);
        String query = "select distinct nv.manhanvien,tennhanvien,machucvu\n" +
                        "from nhanvien nv\n" +
                        "where machucvu > 3 and manhanvien not in \n" +
                        "	( select distinct manhanvien \n" +
                        "		from THOIGIANNHANPHONG\n" +
                        "		where maphong = '"+maphong+"' and ngayroiphong is null\n" +
                        "	) ";
        ResultSet rs = stmt.executeQuery(query);
        model.setRowCount(0); // set số dòng bằng 0
        while(rs.next()){
            String manhanvien = rs.getString(1);
            String tennhanvien = rs.getString(2);
            
            String dataString[] = {manhanvien,tennhanvien};
            model.addRow(dataString);
        }
    }
    public void tableluunhanvien_FormPhong(DefaultTableModel model, String tenphong) throws SQLException{
        connect();
        String maphong = getMaphong(tenphong);
        String query = "select distinct nv.manhanvien,tennhanvien,machucvu\n" +
                        "from nhanvien nv\n" +
                        "where machucvu > 2 and manhanvien in \n" +
                        "	( select distinct manhanvien \n" +
                        "		from THOIGIANNHANPHONG\n" +
                        "		where maphong = '"+maphong+"' and ngayroiphong is null\n" +
                        "	) ";
        ResultSet rs = stmt.executeQuery(query);
        model.setRowCount(0); // set số dòng bằng 0
        while(rs.next()){
            String manhanvien = rs.getString(1);
            String tennhanvien = rs.getString(2);
            
            String dataString[] = {manhanvien,tennhanvien};
            model.addRow(dataString);
        }
    }
    //</editor-fold>
    
    public boolean checkroom(String maphong) throws SQLException{
        connect();
        String query = "select * from phong where maphong = '"+maphong+"'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            return true;
        }
        return false;
    }
    public boolean checkLeader(String maLeader) throws SQLException{
        connect();
        String query = "select * from phong where manhanvien = '"+maLeader+"'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            return true;
        }
        return false;
    } 
    public String TenLeader(String tenphong) throws SQLException{
        connect();
        String query = "select tennhanvien from NHANVIEN nv, PHONG p\n" +
                        "where nv.manhanvien=p.manhanvien and tenphong = N'"+tenphong+"'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            return rs.getString(1);
        }
        return "Không Tồn Tại";
    }
//    public String queryshowLeader(){
//        return "select nv.* \n" +
//                "from NHANVIEN nv  left join THOIGIANNHANPHONG tgnp on nv.manhanvien = tgnp.manhanvien\n" +
//                "where tgnp.manhanvien is null and nv.machucvu = 3";
//    }
    public void showLeader(DefaultTableModel model) throws SQLException{
        connect();
        String query = "select * from nhanvien where machucvu = 3";
        model.setRowCount(0);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {            
            String maLeader = rs.getString("manhanvien");
            String tenLeader = rs.getString("tennhanvien");
            String tbData[] = {maLeader,tenLeader}; 
            model.addRow(tbData);
        }
    }
    //</editor-fold>
}

