/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author micha
 */
public class HocVien implements Serializable {
    private int ma_hoc_vien;
    private String ho_ten;
    private Date ngay_sinh;
    private boolean gioi_tinh;
    private String so_dien_thoai;
    private boolean tinh_trang;
    private String dia_chi;

    public int getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setMa_hoc_vien(int ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }
    

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
