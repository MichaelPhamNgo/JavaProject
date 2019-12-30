/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HocVien;

/**
 *
 * @author micha
 */
public class ClassTableModel {
    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
 
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HocVien hocVien = null;
        for (int i = 0; i < num; i++) {
            hocVien = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hocVien.getMa_hoc_vien();
            obj[1] = (i + 1);
            obj[2] = hocVien.getHo_ten();
            obj[3] = hocVien.getNgay_sinh();
            obj[4] = hocVien.isGioi_tinh() == true ? "Nam" : "Nữ";
            obj[5] = hocVien.getSo_dien_thoai();
            obj[6] = hocVien.getDia_chi();
            obj[7] = hocVien.isTinh_trang();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
