/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangggggg;

/**
 *
 * @author hiep nguyen
 */
public class KhuyenMai {

    private String ma;
    private String ten;
    private String ngayBD;
    private String ngayKT;
    private String dieuKien;
    private int soLuong;
    private String vaiTro;
    private int giam;

    public KhuyenMai() {
    }

    public KhuyenMai(String ma, String ten, String ngayBD, String ngayKT, String dieuKien, int soLuong, String vaiTro, int giam) {
        this.ma = ma;
        this.ten = ten;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.dieuKien = dieuKien;
        this.soLuong = soLuong;
        this.vaiTro = vaiTro;
        this.giam = giam;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public int getGiam() {
        return giam;
    }

    public void setGiam(int giam) {
        this.giam = giam;
    }

}
