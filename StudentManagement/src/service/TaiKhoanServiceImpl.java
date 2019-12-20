/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TaiKhoanDAO;
import dao.TaiKhoanDAOImpl;
import model.TaiKhoan;

/**
 *
 * @author micha
 */
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private TaiKhoanDAO taiKhoanDAO = null;
 
    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }
 
    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);
    }
}
