/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HocVienDAO;
import dao.HocVienDAOImpl;
import java.util.List;
import model.HocVien;

/**
 *
 * @author micha
 */
public class HocVienServiceImpl implements HocVienService{
    private HocVienDAO hocVienDAO = null;
 
    public HocVienServiceImpl() {
        this.hocVienDAO = new HocVienDAOImpl();
    }
 
    @Override
    public List<HocVien> getList() {
        return hocVienDAO.getList();
    }
    
    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }
}
