package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

public class TimkiemDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public TimkiemDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableSinhVienTimKiem(JTable table, String key) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Lớp");
		cols.addElement("Hệ Đào Tạo");
		cols.addElement("Ngày Sinh");
		cols.addElement("Địa Chỉ");
		cols.addElement("Giới Tính");
		cols.addElement("Số Điện Thoại");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.sinhvien";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector sinhvien = new Vector();
				sinhvien.addElement(rs.getString("idsv"));
				sinhvien.addElement(rs.getString("hoten"));
				sinhvien.addElement(rs.getString("idlop"));
				sinhvien.addElement(rs.getString("hedt"));
				sinhvien.addElement(rs.getDate("ngaysinh"));
				sinhvien.addElement(rs.getString("diachi"));
				sinhvien.addElement(rs.getString("gioitinh"));
				sinhvien.addElement(rs.getString("sdt"));

				if (sinhvien.toString().contains(key)) {
					data.addElement(sinhvien);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableGiaoVienTimKiem(JTable table, String key) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID");
		cols.addElement("Họ Tên");
		cols.addElement("ID Môn Dạy");
		cols.addElement("ID Khoa");
		cols.addElement("Ngày Sinh");
		cols.addElement("Giới Tính");
		cols.addElement("Email");
		cols.addElement("Số Điện Thoại");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.giaovien";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector giaovien = new Vector();
				giaovien.addElement(rs.getString("idgv"));
				giaovien.addElement(rs.getString("hoten"));
				giaovien.addElement(rs.getString("idmon"));
				giaovien.addElement(rs.getString("idkhoa"));
				giaovien.addElement(rs.getDate("ngaysinh"));
				giaovien.addElement(rs.getString("gioitinh"));
				giaovien.addElement(rs.getString("email"));
				giaovien.addElement(rs.getString("sdt"));

				if (giaovien.toString().contains(key)) {
					data.addElement(giaovien);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableKhoaTimKiem(JTable table, String key) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("Mã Khoa");
		cols.addElement("Tên Học");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.khoa";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int row = 0;
			while (rs.next()) {
				Vector khoa = new Vector();
				khoa.addElement(rs.getString("idkhoa"));
				khoa.addElement(rs.getString("khoa"));

				if (khoa.toString().contains(key)) {
					data.addElement(khoa);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableLopTimKiem(JTable table, String key) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("Mã Lớp");
		cols.addElement("Tên Lớp");
		cols.addElement("Mã Khoa");
		cols.addElement("Khóa Học");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.lop";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector lop = new Vector();
				lop.addElement(rs.getString("idlop"));
				lop.addElement(rs.getString("lop"));
				lop.addElement(rs.getString("idkhoa"));
				lop.addElement(rs.getString("khoahoc"));

				if (lop.toString().contains(key)) {
					data.addElement(lop);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showTableMonTimKiem(JTable table, String key) {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("Mã Môn Học");
		cols.addElement("Tên Môn Học");
		cols.addElement("Số Tín Chỉ");
		cols.addElement("Mã Khoa");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.mon";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector mon = new Vector();
				mon.addElement(rs.getString("idmon"));
				mon.addElement(rs.getString("mon"));
				mon.addElement(rs.getString("tinchi"));
				mon.addElement(rs.getString("idkhoa"));

				if (mon.toString().contains(key)) {
					data.addElement(mon);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(data, cols));
	}
}
