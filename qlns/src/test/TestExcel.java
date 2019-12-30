/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import model.HocVien;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.HocVienService;
import service.HocVienServiceImpl;

/**
 *
 * @author micha
 */
public class TestExcel {
    public static void main(String[] args) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Học viên");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH HỌC VIÊN");

            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ và tên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            HocVienService hocVienService = new HocVienServiceImpl();

            List<HocVien> listItem = hocVienService.getList();

            for (int i = 0; i < listItem.size(); i++) {
                HocVien hocVien = listItem.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(hocVien.getHo_ten());
                row.createCell(2).setCellValue(hocVien.getNgay_sinh().toString());
                row.createCell(3).setCellValue(hocVien.isGioi_tinh() ? "Nam" : "Nữ");
                row.createCell(4).setCellValue(hocVien.getSo_dien_thoai());
                row.createCell(5).setCellValue(hocVien.getDia_chi());
            }

            FileOutputStream out = new FileOutputStream(new File("C:/Users/micha/Documents/hv.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
