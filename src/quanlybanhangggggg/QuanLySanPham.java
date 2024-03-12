/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangggggg;

import com.sun.jdi.connect.Connector;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author hiep nguyen
 */
public class QuanLySanPham {

    ArrayList<SanPham> listSanPham = new ArrayList<>();

    public ArrayList<SanPham> getAll() {
        listSanPham.clear();
        try {
            String sql = "select * from SanPham";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("MaSP"));
                sp.setTen(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("TheLoai"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setSize(rs.getString("Size"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                listSanPham.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public Boolean truSP(int i, String ma) {
        listSanPham.clear();
        try {
            String sql = "Update SanPham set SoLuong = SoLuong - ? where MaSP = ?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean nhanDoiSPtrogMa(int i, String ma) {
        try {
            String sql = "update HoaDonChiTiet set SoLuong=SoLuong+? where MaSP=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean congSP(int i, String ma) {
        try {
            String sql = "update SanPham set SoLuong=SoLuong+? where MaSP=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<SanPham> search(String timKiem) {
        listSanPham.clear();
        try {
            String sql = "select * from SanPham where MaSP like ? or TenSP like ?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + timKiem + "%");
            ps.setString(2, "%" + timKiem + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("MaSP"));
                sp.setTen(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("TheLoai"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setSize(rs.getString("Size"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia"));
                listSanPham.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public Boolean ThemSP(SanPham s) {
        listSanPham.clear();
        try {
            String sql = "insert into SanPham(MaSP,TenSP,TheLoai,ChatLieu,Size,SoLuong,DonGia) values(?,?,?,?,?,?,?)";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.setString(3, s.getTheLoai());
            ps.setString(4, s.getChatLieu());
            ps.setString(5, s.getSize());
            ps.setInt(6, s.getSoLuong());
            ps.setInt(7, s.getDonGia());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean xoaSP(String ma) {
        listSanPham.clear();
        try {
            String sql = "Delete SanPham where MaSP = ?";
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

    public Boolean caphat(SanPham sp, String ma) {
        listSanPham.clear();
        try {
            String sql = "update SanPham set MaSP=?,TenSP=?,TheLoai=?,ChatLieu=?,Size=?,SoLuong=?,DonGia=? where MaSP=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getTheLoai());
            ps.setString(4, sp.getChatLieu());
            ps.setString(5, sp.getSize());
            ps.setInt(6, sp.getSoLuong());
            ps.setInt(7, sp.getDonGia());
            ps.setString(8, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<SanPham> tk(String timKiemSP) {
        listSanPham.clear();
        try {
            String sql = "Select * from SanPham Where MaSP like ? or TenSP like ?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + timKiemSP + "%");
            ps.setString(2, "%" + timKiemSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMa(rs.getString("MaSP"));
                s.setTen(rs.getString("TenSP"));
                s.setTheLoai(rs.getString("TheLoai"));
                s.setChatLieu(rs.getString("ChatLieu"));
                s.setSize(rs.getString("Size"));
                s.setSoLuong(rs.getInt("SoLuong"));
                s.setDonGia(rs.getInt("DonGia"));
                listSanPham.add(s);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public Boolean truiSPtrogMa(int i, String ma) {
        try {
            String sql = "update HoaDonChiTiet set SoLuong=? where MaSP=?";
            Connection conn = DBConnnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setString(2, ma);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
