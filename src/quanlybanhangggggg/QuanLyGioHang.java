/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangggggg;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hiep nguyen
 */
public class QuanLyGioHang {

    ArrayList<GioHang> listGioHang = new ArrayList<>();

    public ArrayList<GioHang> getGioHang(String maHD) {
        listGioHang.clear();
        try {
            String sql = "select HoaDonChiTiet.MaHD,HoaDonChiTiet.MaSP,TenSP,HoaDonChiTiet.SoLuong,SanPham.DonGia from HoaDonChiTiet"
                    + "  join SanPham on SanPham.MaSP = HoaDonChiTiet.MaSP"
                    + " where MaHD = " + "'" + maHD + "'";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang gh = new GioHang();
                gh.setMa(rs.getString("MaSP"));
                gh.setTen(rs.getString("TenSP"));
                gh.setSoLuong(rs.getInt("SoLuong"));
                gh.setDonGia(rs.getInt("DonGia"));
                listGioHang.add(gh);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    public Boolean themGioHang(GioHang gh, String maHD) {
        try {
            String sql = "insert into HoaDonChiTiet(MaHD,MaSP,SoLuong) values(?,?,?)";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, gh.getMa());
            ps.setInt(3, gh.getSoLuong());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean xoa(String ma) {
        try {
            String sql = "delete HoaDonChiTiet where MaSP=?";
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
