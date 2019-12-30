package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

public class QuanlyDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public QuanlyDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableSinhVienSelect(JTable table) {
		// Clear table
		table.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Sinh Vien");
		model.addColumn("Ho Ten");
		model.addColumn("ID Lop");
		model.addColumn("ID Khoa");
		model.addColumn("He Dao Tao");
		model.addColumn("Ngay Sinh");
		model.addColumn("Dia Chi");
		model.addColumn("Gioi Tinh");
		model.addColumn("So Dien Thoai");
		String sql = "SELECT * FROM  project.sinhvien";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idsv"), row, 1);
				model.setValueAt(rs.getString("hoten"), row, 2);
				model.setValueAt(rs.getString("idlop"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				model.setValueAt(rs.getString("hedt"), row, 5);
				model.setValueAt(rs.getDate("ngaysinh"), row, 6);
				model.setValueAt(rs.getString("diachi"), row, 7);
				model.setValueAt(rs.getString("gioitinh"), row, 8);
				model.setValueAt(rs.getString("sdt"), row, 9);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableSinhVienSort(JTable table, String group, String sort) {
		// Clear table
		table.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Sinh Vien");
		model.addColumn("Ho Ten");
		model.addColumn("ID Lop");
		model.addColumn("ID Khoa");
		model.addColumn("He Dao Tao");
		model.addColumn("Ngay Sinh");
		model.addColumn("Dia Chi");
		model.addColumn("Gioi Tinh");
		model.addColumn("So Dien Thoai");
		String sql = "SELECT * FROM  project.sinhvien ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idsv"), row, 1);
				model.setValueAt(rs.getString("hoten"), row, 2);
				model.setValueAt(rs.getString("idlop"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				model.setValueAt(rs.getString("hedt"), row, 5);
				model.setValueAt(rs.getDate("ngaysinh"), row, 6);
				model.setValueAt(rs.getString("diachi"), row, 7);
				model.setValueAt(rs.getString("gioitinh"), row, 8);
				model.setValueAt(rs.getString("sdt"), row, 9);
				row++;
			}
		} catch (Exception e) {
		}
	}

	/*
	 * Giao vien
	 */
	public void showTableGiaoVienSelect(JTable table_1) {
		// Clear table
		table_1.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_1.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Giao Vien");
		model.addColumn("Ho Ten");
		model.addColumn("ID Mon Day");
		model.addColumn("ID Khoa");
		model.addColumn("ID Lop");
		model.addColumn("Ngay Sinh");
		model.addColumn("Gioi Tinh");
		model.addColumn("Email");
		model.addColumn("So Dien Thoai");
		String sql = "SELECT * FROM  project.giaovien";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idgv"), row, 1);
				model.setValueAt(rs.getString("hoten"), row, 2);
				model.setValueAt(rs.getString("idmon"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				model.setValueAt(rs.getString("idlop"), row, 5);
				model.setValueAt(rs.getDate("ngaysinh"), row, 6);
				model.setValueAt(rs.getString("gioitinh"), row, 7);
				model.setValueAt(rs.getString("email"), row, 8);
				model.setValueAt(rs.getString("sdt"), row, 9);
				row++;
			}
		} catch (Exception e) {
		}
	}

	public void showTableGiaoVienSort(JTable table_1, String group, String sort) {
		// Clear table
		table_1.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_1.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Giao Vien");
		model.addColumn("Ho Ten");
		model.addColumn("ID Mon Day");
		model.addColumn("ID Khoa");
		model.addColumn("ID Lop");
		model.addColumn("Ngay Sinh");
		model.addColumn("Gioi Tinh");
		model.addColumn("Email");
		model.addColumn("So Dien Thoai");
		String sql = "SELECT * FROM  project.giaovien ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idgv"), row, 1);
				model.setValueAt(rs.getString("hoten"), row, 2);
				model.setValueAt(rs.getString("idmon"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				model.setValueAt(rs.getString("idlop"), row, 5);
				model.setValueAt(rs.getDate("ngaysinh"), row, 6);
				model.setValueAt(rs.getString("gioitinh"), row, 7);
				model.setValueAt(rs.getString("email"), row, 8);
				model.setValueAt(rs.getString("sdt"), row, 9);
				row++;
			}
		} catch (Exception e) {
		}
	}

	/*
	 * Diem
	 */
	public void showTableDiemSelect(JTable table_2) {
		// Clear table
		table_2.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_2.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Lop");
		model.addColumn("ID Sinh Vien");
		model.addColumn("ID Mon Hoc");
		model.addColumn("Mon Hoc");
		model.addColumn("Diem 15p");
		model.addColumn("Diem 45p");
		model.addColumn("Diem thi");
		model.addColumn("Tong Ket");
		model.addColumn("Ket Qua");
		model.addColumn("ID Giao Vien");
		String sql = "SELECT * FROM  project.diem";
		try {

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idlop"), row, 1);
				model.setValueAt(rs.getString("idsv"), row, 2);
				model.setValueAt(rs.getString("idmon"), row, 3);
				model.setValueAt(rs.getString("mon"), row, 4);
				model.setValueAt(rs.getFloat("diem15"), row, 5);
				model.setValueAt(rs.getFloat("diem45"), row, 6);
				model.setValueAt(rs.getFloat("diemthi"), row, 7);
				model.setValueAt(rs.getFloat("tongket"), row, 8);
				model.setValueAt(rs.getString("ketqua"), row, 9);
				model.setValueAt(rs.getString("idgv"), row, 10);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableDiemSort(JTable table_2, String group, String sort) {
		// Clear table
		table_2.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_2.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Lop");
		model.addColumn("ID Sinh Vien");
		model.addColumn("ID Mon Hoc");
		model.addColumn("Mon Hoc");
		model.addColumn("Diem 15p");
		model.addColumn("Diem 45p");
		model.addColumn("Diem thi");
		model.addColumn("Tong Ket");
		model.addColumn("Ket Qua");
		model.addColumn("ID Giao Vien");
		String sql = "SELECT * FROM  project.diem ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idlop"), row, 1);
				model.setValueAt(rs.getString("idsv"), row, 2);
				model.setValueAt(rs.getString("idmon"), row, 3);
				model.setValueAt(rs.getString("mon"), row, 4);
				model.setValueAt(rs.getFloat("diem15"), row, 5);
				model.setValueAt(rs.getFloat("diem45"), row, 6);
				model.setValueAt(rs.getFloat("diemthi"), row, 7);
				model.setValueAt(rs.getFloat("tongket"), row, 8);
				model.setValueAt(rs.getString("ketqua"), row, 9);
				model.setValueAt(rs.getString("idgv"), row, 10);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Lop
	 */
	public void showTableLopSelect(JTable table_3) {
		// Clear table
		table_3.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_3.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Lop");
		model.addColumn("Ten Lop");
		model.addColumn("ID Khoa");
		model.addColumn("Khoa Hoc");
		String sql = "SELECT * FROM  project.lop";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idlop"), row, 1);
				model.setValueAt(rs.getString("lop"), row, 2);
				model.setValueAt(rs.getString("idkhoa"), row, 3);
				model.setValueAt(rs.getString("khoahoc"), row, 4);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableLopSort(JTable table_3, String group, String sort) {
		// Clear table
		table_3.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_3.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Lop");
		model.addColumn("Ten Lop");
		model.addColumn("ID Khoa");
		model.addColumn("Khoa Hoc");
		String sql = "SELECT * FROM  project.lop ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idlop"), row, 1);
				model.setValueAt(rs.getString("lop"), row, 2);
				model.setValueAt(rs.getString("idkhoa"), row, 3);
				model.setValueAt(rs.getString("khoahoc"), row, 4);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Khoa
	 */
	public void showTableKhoaSelect(JTable table_4) {
		// Clear table
		table_4.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_4.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Khoa");
		model.addColumn("Ten Khoa");
		String sql = "SELECT * FROM  project.khoa";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idkhoa"), row, 1);
				model.setValueAt(rs.getString("khoa"), row, 2);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableKhoaSort(JTable table_4, String group, String sort) {
		// Clear table
		table_4.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_4.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("ID Khoa");
		model.addColumn("Ten Khoa");
		String sql = "SELECT * FROM  project.khoa ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idkhoa"), row, 1);
				model.setValueAt(rs.getString("khoa"), row, 2);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Mon - select and sort
	 */
	public void showTableMonSelect(JTable table_5) {
		// Clear table
		table_5.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_5.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("Ma Mon Hoc");
		model.addColumn("Ten Mon Hoc");
		model.addColumn("So Tin Chi");
		model.addColumn("Ma Khoa");
		String sql = "SELECT * FROM  project.mon";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(true, row, 0); // Checkbox
				model.setValueAt(rs.getString("idmon"), row, 1);
				model.setValueAt(rs.getString("mon"), row, 2);
				model.setValueAt(rs.getString("tinchi"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showTableMonSort(JTable table_5, String group, String sort) {
		// Clear table
		table_5.setModel(new DefaultTableModel());
		// Model for Table
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_5.setModel(model);
		// Add Column
		model.addColumn("Select");
		model.addColumn("Ma Mon Hoc");
		model.addColumn("Ten Mon Hoc");
		model.addColumn("So Tin Chi");
		model.addColumn("Ma Khoa");
		String sql = "SELECT * FROM  project.mon ORDER BY " + group + " " + sort + "";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			int row = 0;
			while ((rs != null) && (rs.next())) {
				model.addRow(new Object[0]);
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idmon"), row, 1);
				model.setValueAt(rs.getString("mon"), row, 2);
				model.setValueAt(rs.getString("tinchi"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
