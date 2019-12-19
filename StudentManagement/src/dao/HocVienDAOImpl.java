/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HocVien;

/**
 *
 * @author micha
 */
public class HocVienDAOImpl implements HocVienDAO{
    @Override
    public List<HocVien> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM hoc_vien";
        List<HocVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVien.setHo_ten(rs.getString("ho_ten"));
                hocVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hocVien.setDia_chi(rs.getString("dia_chi"));
                hocVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hocVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hocVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(hocVien);
            }
            ps.close();
            rs.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        HocVienDAO hocvien = new HocVienDAOImpl() {};
        System.out.println(hocvien.getList());
    }
}
