/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author micha
 */
public class KhoaHocBean {
    private String ten_khoa_hoc;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;
 
    public String getTen_khoa_hoc() {
        return ten_khoa_hoc;
    }
 
    public void setTen_khoa_hoc(String ten_khoa_hoc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
    }
 
    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }
 
    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }
 
    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }
 
    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
