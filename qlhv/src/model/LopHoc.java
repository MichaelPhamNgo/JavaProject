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
public class LopHoc implements Serializable{
    private int ma_lop_hoc;
    private int ma_khoa_hoc;
    private int ma_hoc_vien;
    private Date ngay_dang_ky;
    private boolean tinh_trang;

    public int getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public int getMa_khoa_hoc() {
        return ma_khoa_hoc;
    }

    public int getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public Date getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setMa_lop_hoc(int ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }

    public void setMa_khoa_hoc(int ma_khoa_hoc) {
        this.ma_khoa_hoc = ma_khoa_hoc;
    }

    public void setMa_hoc_vien(int ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public void setNgay_dang_ky(Date ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    @Override
    public String toString() {
        return "LopHoc{" + "ma_lop_hoc=" + ma_lop_hoc + ", ma_khoa_hoc=" + ma_khoa_hoc + ", ma_hoc_vien=" + ma_hoc_vien + ", ngay_dang_ky=" + ngay_dang_ky + ", tinh_trang=" + tinh_trang + '}';
    }
    
    
}
