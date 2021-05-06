/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//<editor-fold defaultstate="collapsed" desc="Ghi Chú">
//</editor-fold>
package main;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author tanng
 */
public class NhanVien {
    
    private static NhanVien instance;
    private NhanVien(){
    }
    public static NhanVien getInstance() {
        if (instance == null) {
            instance = new NhanVien();
        }
        return instance;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Get Set ">

    public Date getNgaynhancv() {
        return ngaynhancv;
    }

    public void setNgaynhancv(Date ngaynhancv) {
        this.ngaynhancv = ngaynhancv;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(int machucvu) {
        this.machucvu = machucvu;
    }
//    </editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public void SetNhanVien(String ma,String ten,Date date,String address,String SDT,boolean Sex,String pass,boolean Trangthai,int idchucvu, Date ngaynhanviec){
        this.manhanvien = ma;
        this.tennhanvien = ten;
        this.ngaysinh = date;
        this.diachi = address;
        this.sdt = SDT;
        this.gioitinh = Sex;
        this.matkhau = pass;
        this.trangthai = Trangthai;
        this.machucvu = idchucvu;
        this.ngaynhancv = ngaynhanviec;
    }
    public void  SetEmptyNhanVien(){
        manhanvien = "";
        tennhanvien = "";
        ngaysinh = null;
        diachi = "";
        sdt = "";
        gioitinh = false;
        matkhau = "";
        trangthai = false;
        machucvu = 0;
        ngaynhancv = null;
    }
    //</editor-fold>
    // lưu nhân viên đăng nhập từ excute SQL
    public void LuuNhanVien(ResultSet rs, ResultSet rs1) throws SQLException{
        String ma = rs.getString("manhanvien");
        String ten = rs.getString("tennhanvien");
        Date date = rs.getDate("ngaysinh");
        String address = rs.getString("diachi");
        String SDT = rs.getString("sdt");
        boolean Sex = rs.getBoolean("gioitinh");
        String pass = rs.getString("matkhau");
        boolean Trangthai = rs.getBoolean("trangthainhanvien");
        int idchucvu = rs1.getInt("machucvu");
        Date ngaynhanviec = rs1.getDate("ngaynhancv");
        SetNhanVien(ma, ten, date, address, SDT, Sex, pass, Trangthai, idchucvu, ngaynhanviec);
    }
    
    String manhanvien = "";
    String tennhanvien = "";
    Date ngaysinh = null;
    String diachi = "";
    String sdt = "";
    boolean gioitinh = false;
    String matkhau = "";
    boolean trangthai = false;
    int machucvu = 0;
    Date ngaynhancv = null;
}
