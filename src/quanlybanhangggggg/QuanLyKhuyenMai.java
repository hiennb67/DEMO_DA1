/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangggggg;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author hiep nguyen
 */
public class QuanLyKhuyenMai {

    ArrayList<KhuyenMai> listKM = new ArrayList<>();

    public ArrayList<KhuyenMai> getAllKM() {
        listKM.clear();
        try {
            String sql = "select * from KhuyenMai";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(rs.getString("MaKM"));
                km.setTen(rs.getString("TenKM"));
                km.setNgayBD(rs.getString("NgayBatDau"));
                km.setNgayKT(rs.getString("NgayKetThuc"));
                km.setDieuKien(rs.getString("DieuKien"));
                km.setSoLuong(rs.getInt("SoLuong"));
                km.setVaiTro(rs.getString("VaiTro"));
                km.setGiam(rs.getInt("Giam"));
                listKM.add(km);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }

    public Boolean them(KhuyenMai km) {
        listKM.clear();
        try {
            String sql = "insert into KhuyenMai(MaKM,TenKM,NgayBatDau,NgayKetThuc,DieuKien,SoLuong,VaiTro,Giam)values(?,?,?,?,?,?,?,?)";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, km.getMa());
            ps.setString(2, km.getTen());
            ps.setString(3, km.getNgayBD());
            ps.setString(4, km.getNgayKT());
            ps.setString(5, km.getDieuKien());
            ps.setInt(6, km.getSoLuong());
            ps.setString(7, km.getVaiTro());
            ps.setInt(8, km.getGiam());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void truSoLuongKhuyenMai(String ma) {

        try {
            String sql = "update KhuyenMai set SoLuong=SoLuong-1 where MaKM=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean xoaMaKM(String ma) {
        try {
            String sql = "delete KhuyenMai where MaKM=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
