/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.util.List;

/**
 *
 * @author micha
 */
public interface ThongKeDAO {
    public List<LopHocBean> getListByLopHoc();    
    public List<KhoaHocBean> getListByKhoaHoc();
}
