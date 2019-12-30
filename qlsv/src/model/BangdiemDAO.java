package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

public class BangdiemDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public BangdiemDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Button xem bang diem
	public void showTableBangDiem(JTable table_Bangdiem,String sql, String where) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("Ma Sinh Vien");
		cols.addElement("Ten Sinh Vien");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		cols.addElement("Mon");
		cols.addElement("Lop");
		cols.addElement("Khoa");
		cols.addElement("Ma Giao Vien");
		// Data table
		Vector data = new Vector();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, where); // where - idsv, mon ,lop ,khoa
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Vector xemdiem = new Vector();
				xemdiem.addElement(i++);
				xemdiem.addElement(rs.getString("diem.idsv"));
				xemdiem.addElement(rs.getString("sinhvien.hoten"));
				xemdiem.addElement(rs.getFloat("diem.diem15"));
				xemdiem.addElement(rs.getFloat("diem.diem45"));
				xemdiem.addElement(rs.getFloat("diem.diemthi"));
				xemdiem.addElement(rs.getFloat("diem.tongket"));
				xemdiem.addElement(rs.getString("diem.ketqua"));
				xemdiem.addElement(rs.getString("mon.mon"));
				xemdiem.addElement(rs.getString("lop.lop"));
				xemdiem.addElement(rs.getString("khoa.khoa"));
				xemdiem.addElement(rs.getString("diem.idgv"));
				data.add(xemdiem);
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	}
	//Sap xep
	public void showTableXemDiemSort(JTable table_Bangdiem,String name, String group) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("Ma Sinh Vien");
		cols.addElement("Ten Sinh Vien");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		cols.addElement("Mon");
		cols.addElement("Lop");
		cols.addElement("Khoa");
		cols.addElement("Ma Giao Vien");
		// Data table
		Vector data = new Vector();
		try {
			stmt = conn.prepareStatement(
					"Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop ORDER BY "
							+ name + " " + group + "");
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Vector xemdiem = new Vector();
				xemdiem.addElement(i++);
				xemdiem.addElement(rs.getString("diem.idsv"));
				xemdiem.addElement(rs.getString("sinhvien.hoten"));
				xemdiem.addElement(rs.getFloat("diem.diem15"));
				xemdiem.addElement(rs.getFloat("diem.diem45"));
				xemdiem.addElement(rs.getFloat("diem.diemthi"));
				xemdiem.addElement(rs.getFloat("diem.tongket"));
				xemdiem.addElement(rs.getString("diem.ketqua"));
				xemdiem.addElement(rs.getString("mon.mon"));
				xemdiem.addElement(rs.getString("lop.lop"));
				xemdiem.addElement(rs.getString("khoa.khoa"));
				xemdiem.addElement(rs.getString("diem.idgv"));
				data.add(xemdiem);
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	}
	//Tim kiem
	public void showTableBangDiemSearch(JTable table_Bangdiem,String sql, String search) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("Ma Sinh Vien");
		cols.addElement("Ten Sinh Vien");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		cols.addElement("Mon");
		cols.addElement("Lop");
		cols.addElement("Khoa");
		cols.addElement("Ma Giao Vien");
		// Data table
		Vector data = new Vector();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Vector xemdiem = new Vector();
				xemdiem.addElement(i++);
				xemdiem.addElement(rs.getString("diem.idsv"));
				xemdiem.addElement(rs.getString("sinhvien.hoten"));
				xemdiem.addElement(rs.getFloat("diem.diem15"));
				xemdiem.addElement(rs.getFloat("diem.diem45"));
				xemdiem.addElement(rs.getFloat("diem.diemthi"));
				xemdiem.addElement(rs.getFloat("diem.tongket"));
				xemdiem.addElement(rs.getString("diem.ketqua"));
				xemdiem.addElement(rs.getString("mon.mon"));
				xemdiem.addElement(rs.getString("lop.lop"));
				xemdiem.addElement(rs.getString("khoa.khoa"));
				xemdiem.addElement(rs.getString("diem.idgv"));
				// data.add(xemdiem);
				if (xemdiem.toString().contains(search)) {
					data.addElement(xemdiem);
				}
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableBangDiem(JTable table_Bangdiem,String sql, String idsv, String mon) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("STT");
		cols.addElement("Ma Sinh Vien");
		cols.addElement("Ten Sinh Vien");
		cols.addElement("Diem 15p");
		cols.addElement("Diem 45p");
		cols.addElement("Diem thi");
		cols.addElement("Tong Ket");
		cols.addElement("Ket Qua");
		cols.addElement("Mon");
		cols.addElement("Lop");
		cols.addElement("Khoa");
		cols.addElement("Ma Giao Vien");
		// Data table
		Vector data = new Vector();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idsv);
			stmt.setString(2, mon);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Vector xemdiem = new Vector();
				xemdiem.addElement(i++);
				xemdiem.addElement(rs.getString("diem.idsv"));
				xemdiem.addElement(rs.getString("sinhvien.hoten"));
				xemdiem.addElement(rs.getFloat("diem.diem15"));
				xemdiem.addElement(rs.getFloat("diem.diem45"));
				xemdiem.addElement(rs.getFloat("diem.diemthi"));
				xemdiem.addElement(rs.getFloat("diem.tongket"));
				xemdiem.addElement(rs.getString("diem.ketqua"));
				xemdiem.addElement(rs.getString("mon.mon"));
				xemdiem.addElement(rs.getString("lop.lop"));
				xemdiem.addElement(rs.getString("khoa.khoa"));
				xemdiem.addElement(rs.getString("diem.idgv"));
				data.add(xemdiem);
			}
		} catch (Exception e) {
		}
		table_Bangdiem.setModel(new DefaultTableModel(data, cols));
	}
}
