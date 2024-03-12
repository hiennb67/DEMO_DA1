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
public class QuanLyHoaDon {

    ArrayList<HoaDon> listHD = new ArrayList<>();

    public ArrayList<HoaDon> getHD() {
        listHD.clear();
        try {
            String sql = "Select * from HoaDon";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setNgay(rs.getString("NgayTao"));
                hd.setTrangThai(rs.getString("TrangThai"));
                listHD.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public Boolean taHD(HoaDon hd) {
        try {
            String sql = "insert into HoaDon(MaHD,TenNV,NgayTao,TrangThai) values(?,?,?,?)";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getTenNV());
            ps.setString(3, hd.getNgay());
            ps.setString(4, hd.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean tt(String ma) {
        listHD.clear();
        try {
            String sql = "update HoaDon set TrangThai=? where MaHD=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Da thanh toan");
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean HuyHD(String ma) {
        listHD.clear();
        try {
            String sql = "update HoaDon set TrangThai=? where MaHD=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Huy hoa don");
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<HoaDon> searchHD(String tkkm) {
        ArrayList<HoaDon> ll = new ArrayList<>();
        try {
            String sql = "select * from HoaDon where MaHD like ? or TrangThai like ?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tkkm + "%");
            ps.setString(2, "%" + tkkm + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon h = new HoaDon();
                h.setMaHD(rs.getString("MaHD"));
                h.setTenNV(rs.getString("TenNV"));
                h.setNgay(rs.getString("NgayTao"));
                h.setTrangThai(rs.getString("TrangThai"));
                ll.add(h);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ll;
    }
}
