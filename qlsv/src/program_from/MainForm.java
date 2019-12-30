package program_from;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.alee.laf.WebLookAndFeel;
import com.toedter.calendar.JDateChooser;

import controller.DBUtil;
import model.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

public class MainForm {

	public JFrame frmMarkManagerSystem;

	private JTable table;
	private JTextField txtIDsinhvien;
	private JTextField txtTensinhvien;
	private JTextField txtDiachisinhvien;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtSdtsinhvien;
	private JTable table_1;
	private JTextField txtIDgiaovien;
	private JTextField txtTengiaovien;
	private JTextField txtEmailgiaovien;
	private JTextField txtSdtgiaovien;
	private JTable table_2;
	private JTextField txtDiemthi;
	private JTextField txtDiemthi15p;
	private JTextField txtDiemthi45p;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table_3;
	private JTextField txtIDlop;
	private JTextField txtLop;
	private JTextField txtKhoahoc;
	private JTextField txtIDkhoa;
	private JTextField txtKhoa;
	private JTable table_4;
	private JTextField txtIDmon;
	private JTextField txtMon;
	private JTable table_5;

	private JComboBox comboBox_hedaotao;
	private JDateChooser txtNgaysinhsinhvien;
	private JRadioButton radioNam;
	private JRadioButton radioNu;

	private JComboBox comboBox_IDmon;
	private JDateChooser txtNgaysinhgv;
	private JRadioButton radioNamGV;
	private JRadioButton radioNuGV;

	private JComboBox comboBox_IDsvdiem;
	private JComboBox comboBox_Mondiem;
	private JComboBox comboBox_IDlop;
	private JComboBox comboBox_IDkhoa;
	private JComboBox comboBox_IDkhoamon;
	private JComboBox comboBox_IDkhoasv;
	private JComboBox comboBox_IDkhoagv;
	private JComboBox comboBox_IDlopgv;
	private JComboBox comboBox_IDlopdiem;
	public JPanel panel_3;

	private JInternalFrame internalFrame;

	// Phan quyen
	public JButton btnqlsinhvien;
	public JButton btnqlgiaovien;
	public JButton btnqldiem;
	public JButton btnqllop;
	public JButton btnqlkhoa;
	public JButton btnqlmon;

	// Dieu khien tab - xoa tab quan ly khi sinh vien dung pm
	public JTabbedPane tabbedPane;
	public JPanel quan_ly;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField txtIDmondiem;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JTable table_Bangdiem;
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	// Xem bang diem
	private JComboBox comboBox_Theomon;
	private JComboBox comboBox_Theolop;
	private JComboBox comboBox_Theokhoa;
	private JTextField textField;

	public JPanel panel_1; // Bang diem
	public JPanel panel_32; // Tim kiem
	// Tab Tim kiem
	private JTextField txtSearch;
	private JTable table_Searchsinhvien;
	private JTable table_Searchgiaovien;
	private JTable table_Searchkhoa;
	private JTable table_Searchlop;
	private JTable table_Searchmon;
	// Dong ho va lich ngay
	private JLabel timeSystem;
	private JLabel timeSystemBD;
	private JLabel timeSystemTK;
	private JLabel calendarBD;
	private JLabel calendarTK;
	private JTextField txtTongket;
	// Tinh diem tong ket
	private float a, b, c;
	// Login
	private String user, id, hello;
	// Web trinh duyet
	private JPanel panel_36;
	private JFXPanel javafxPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 WebLookAndFeel.install();
				try {
					MainForm window = new MainForm();
					window.frmMarkManagerSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showTableSinhVien();
		showTableGiaoVien();
		showTableDiem();
		showTableLop();
		showTableKhoa();
		showTableMon();
		showTableBangDiem();
		showTableSinhVienSearch();
		showTableGiaoVienSearch();
		showTableKhoaSearch();
		showTableLopSearch();
		showTableMonSearch();
		clock();
		// Web trinh duyet
		initSwingComponents();
		loadJavaFXScene();
	}

	public MainForm(Login a) {
		/* Loading khi dang nhap tu login vao */
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showTableSinhVien();
		showTableGiaoVien();
		showTableDiem();
		showTableLop();
		showTableKhoa();
		showTableMon();
		showTableBangDiem();
		showTableSinhVienSearch();
		showTableGiaoVienSearch();
		showTableKhoaSearch();
		showTableLopSearch();
		showTableMonSearch();
		clock();
		// Web trinh duyet
		initSwingComponents();
		loadJavaFXScene();

		user = a.getUser();
		id = a.getId();
		hello = a.getHello();

		JLabel txtManager = new JLabel("");
		txtManager.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtManager.setForeground(new Color(220, 20, 60));
		panel_3.add(txtManager);
		txtManager.setText(hello);
		// Quan ly
		JLabel txtUser = new JLabel("");
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtUser.setForeground(new Color(0, 0, 128));
		panel_3.add(txtUser);
		txtUser.setText(user + " " + id);
		// Bang diem
		JLabel txtChaobanBD = new JLabel("");
		txtChaobanBD.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtChaobanBD.setForeground(new Color(220, 20, 60));
		txtChaobanBD.setBounds(24, 11, 308, 35);
		panel_1.add(txtChaobanBD);
		txtChaobanBD
				.setIcon(new ImageIcon("./icon/community-users-icon-1.png"));
		txtChaobanBD.setText(hello);

		JLabel txtTenBD = new JLabel("");
		txtTenBD.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTenBD.setForeground(new Color(0, 0, 128));
		txtTenBD.setBounds(22, 40, 256, 26);
		panel_1.add(txtTenBD);
		txtTenBD.setText(user + " " + id);
		// Tim kiem
		JLabel txtChaobanTK = new JLabel("");
		txtChaobanTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtChaobanTK.setForeground(new Color(220, 20, 60));
		txtChaobanTK.setBounds(24, 11, 308, 35);
		panel_32.add(txtChaobanTK);
		txtChaobanTK
				.setIcon(new ImageIcon("./icon/community-users-icon-1.png"));
		txtChaobanTK.setText(hello);

		JLabel txtTenTK = new JLabel("");
		txtTenTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTenTK.setForeground(new Color(0, 0, 128));
		txtTenTK.setBounds(22, 40, 256, 26);
		panel_32.add(txtTenTK);
		txtTenTK.setText(user + " " + id);

		internalFrame.setVisible(true);
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						Calendar cal = new GregorianCalendar();
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						String thu;
						int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
						if(dayOfWeek==1){thu ="Chủ nhật"; }
						else{thu ="Thứ "+ Integer.toString(dayOfWeek);}
						int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						timeSystem.setText(hour + ":" + minute + ":" + second);
						timeSystemBD.setText(hour + ":" + minute + ":" + second);
						timeSystemTK.setText(hour + ":" + minute + ":" + second);
						calendarBD.setText(thu + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
						calendarTK.setText(thu + dayOfWeek + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	// /*
	// * Show table student co checkbox
	// * */
	private void showTableSinhVien() {
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
			e.printStackTrace();
		}
	}

	// Tim kiem - Sinh vien
	private void showTableSinhVienSearch() {
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

				data.add(sinhvien);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchsinhvien.setModel(new DefaultTableModel(data, cols));
	}

	/*
	 * Show table teacher co checkbox
	 */
	private void showTableGiaoVien() {
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

	// Tim kiem - giao vien
	public void showTableGiaoVienSearch() {
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
				data.add(giaovien);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchgiaovien.setModel(new DefaultTableModel(data, cols));
	}

	/*
	 * Show table diem
	 */
	private void showTableDiem() {
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
	 * Show table Lop
	 */
	private void showTableLop() {
		comboBox_IDlop.removeAllItems();
		comboBox_Theolop.removeAllItems();
		comboBox_IDlopgv.removeAllItems();
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
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idlop"), row, 1);
				model.setValueAt(rs.getString("lop"), row, 2);
				model.setValueAt(rs.getString("idkhoa"), row, 3);
				model.setValueAt(rs.getString("khoahoc"), row, 4);
				row++;
				// Display comboBox set from databse
				comboBox_IDlop.addItem(rs.getString("idlop"));
				comboBox_Theolop.addItem(rs.getString("lop"));
				comboBox_IDlopgv.addItem(rs.getString("idlop"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tim kiem - Lop
	public void showTableLopSearch() {
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
				data.add(lop);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table_Searchlop.setModel(new DefaultTableModel(data, cols));
	}

	/*
	 * Show table Khoa
	 */
	private void showTableKhoa() {
		comboBox_IDkhoa.removeAllItems();
		comboBox_IDkhoamon.removeAllItems();
		comboBox_IDkhoasv.removeAllItems();
		comboBox_Theokhoa.removeAllItems();
		comboBox_IDkhoagv.removeAllItems();
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
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idkhoa"), row, 1);
				model.setValueAt(rs.getString("khoa"), row, 2);
				row++;
				comboBox_IDkhoa.addItem(rs.getString("idkhoa"));
				comboBox_IDkhoamon.addItem(rs.getString("idkhoa"));
				comboBox_IDkhoasv.addItem(rs.getString("idkhoa"));
				comboBox_Theokhoa.addItem(rs.getString("khoa"));
				comboBox_IDkhoagv.addItem(rs.getString("idkhoa"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tim kiem - Khoa
	public void showTableKhoaSearch() {
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

				data.add(khoa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table_Searchkhoa.setModel(new DefaultTableModel(data, cols));
	}

	/*
	 * Show table Mon
	 */
	private void showTableMon() {
		comboBox_IDmon.removeAllItems();
		comboBox_Theomon.removeAllItems();
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
				model.setValueAt(false, row, 0); // Checkbox
				model.setValueAt(rs.getString("idmon"), row, 1);
				model.setValueAt(rs.getString("mon"), row, 2);
				model.setValueAt(rs.getString("tinchi"), row, 3);
				model.setValueAt(rs.getString("idkhoa"), row, 4);
				row++;
				// Display comboBox set from databse
				comboBox_IDmon.addItem(rs.getString("idmon"));
				comboBox_Theomon.addItem(rs.getString("mon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tim kiem - Mon
	public void showTableMonSearch() {
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
				data.add(mon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		table_Searchmon.setModel(new DefaultTableModel(data, cols));
	}

	/*
	 * Xem Bang diem table_bangdiem
	 */
	public void showTableBangDiem() {
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
					"Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop");
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarkManagerSystem = new JFrame();
		frmMarkManagerSystem.setResizable(false);
		frmMarkManagerSystem.setTitle("Mark Manager System 2016");
		frmMarkManagerSystem.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./icon/Apps-Aegisub-icon (1).png"));
		frmMarkManagerSystem.setBounds(80, -1, 1191, 715);
		frmMarkManagerSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarkManagerSystem.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 128));
		tabbedPane.setBounds(0, 0, 1189, 694);
		frmMarkManagerSystem.getContentPane().add(tabbedPane);

		JPanel trang_chu = new JPanel();
		tabbedPane.addTab("Trang Ch\u1EE7", new ImageIcon("C:\\Users\\Lonely\\workspace\\icon\\Home-icon.png"),
				trang_chu, null);
		trang_chu.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 656);
		trang_chu.add(panel);
		panel.setLayout(null);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(690, 39, 484, 140);
		panel.add(label_3);
		label_3.setIcon(new ImageIcon("./icon/fpt-logo.png"));

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("./icon/aptech-logo.png"));
		label_4.setBounds(885, 214, 256, 104);
		panel.add(label_4);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 1183, 656);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon("./icon/background-trong.png"));

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("./icon/cloud-2.gif"));
		label_5.setBounds(0, 0, 1183, 464);
		panel.add(label_5);

		quan_ly = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n L\u00FD",
				new ImageIcon("C:\\Users\\Lonely\\workspace\\icon\\Control-Panel-icon (1).png"), quan_ly, null);
		quan_ly.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBounds(10, 11, 216, 106);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quan_ly.add(panel_3);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("./icon/BarTender.png"));
		panel_3.add(label_2);

		timeSystem = new JLabel();
		timeSystem.setForeground(new Color(128, 0, 0));
		timeSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_3.add(timeSystem);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 255));
		panel_4.setBounds(10, 128, 216, 517);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		quan_ly.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(236, 128, 938, 517);
		quan_ly.add(panel_5);
		panel_5.setLayout(null);

		internalFrame = new JInternalFrame("Quản Lý Sinh Viên");
		internalFrame.setClosable(true);
		internalFrame.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame.setBounds(0, 0, 938, 517); // 0, 0, 938, 517 SVTABLE

		panel_5.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(0, 29, 934, 35);
		internalFrame.getContentPane().add(panel_6);

		JLabel lblThngTinSinh = new JLabel("Nhập Sinh Viên");
		lblThngTinSinh.setForeground(new Color(0, 0, 0));
		lblThngTinSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_6.add(lblThngTinSinh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 914, 173);
		internalFrame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow();
					txtIDsinhvien.setText(table.getValueAt(row, 1).toString());
					txtTensinhvien.setText(table.getValueAt(row, 2).toString());
					comboBox_IDlop.setSelectedItem(table.getValueAt(row, 3).toString());
					comboBox_IDkhoasv.setSelectedItem(table.getValueAt(row, 4).toString());
					comboBox_hedaotao.setSelectedItem(table.getValueAt(row, 5).toString());
					txtNgaysinhsinhvien.setDate((Date) table.getValueAt(row, 6));
					txtDiachisinhvien.setText(table.getValueAt(row, 7).toString());
					txtSdtsinhvien.setText(table.getValueAt(row, 9).toString());
					if (table.getValueAt(row, 8).toString().equals("Nam")) {
						radioNam.setSelected(true);
					}
					if (table.getValueAt(row, 8).toString().equals("Nu")) {
						radioNu.setSelected(true);
					}
				} catch (Exception e) {}

			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 204, 255));
		panel_7.setBounds(730, 257, 194, 220);
		internalFrame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		// Them sinh vien
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sinhvien sinhvien = new Sinhvien();
				if (txtIDsinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Mã sinh viên không đươc để trống !");
				} else if (txtTensinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
				} else if (comboBox_IDlop.getSelectedItem().toString() == null
						|| comboBox_IDkhoasv.getSelectedItem().toString() == null
						|| comboBox_hedaotao.getSelectedItem().toString() == null) {
					JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
				} else if (txtDiachisinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
				} else if (radioNam.isSelected() == false && radioNu.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
				} else if (txtSdtsinhvien.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
				} else if (txtSdtsinhvien.getText().length() <= 9 || txtSdtsinhvien.getText().length() >= 11) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
				} else {
					Date datesv = txtNgaysinhsinhvien.getDate();
					String datesvinput = new SimpleDateFormat("yyyy-MM-dd").format(datesv);
					sinhvien.setIDsinhvien(txtIDsinhvien.getText());
					sinhvien.setHoten(txtTensinhvien.getText());
					sinhvien.setIDlop(comboBox_IDlop.getSelectedItem().toString());
					sinhvien.setIDkhoa(comboBox_IDkhoasv.getSelectedItem().toString());
					sinhvien.setHedaotao(comboBox_hedaotao.getSelectedItem().toString());
					sinhvien.setNgaysinh(datesvinput);
					sinhvien.setDiachi(txtDiachisinhvien.getText());
					if (radioNam.isSelected()) {
						sinhvien.setGioitinh("Nam");
					} else {
						sinhvien.setGioitinh("Nu");
					}
					sinhvien.setSdt(txtSdtsinhvien.getText());
					SinhvienDAO sinhvienDAO = new SinhvienDAO();
					sinhvienDAO.addSinhVien(sinhvien);
				}
				showTableSinhVien(); // Refresh
			}
		});
		btnThm.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThm.setForeground(new Color(0, 0, 0));
		btnThm.setBounds(33, 24, 116, 30);
		panel_7.add(btnThm);
		// Sua sinh vien
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sinhvien sinhvien = new Sinhvien();
				if (txtIDsinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Mã sinh viên không đươc để trống !");
				} else if (txtTensinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
				} else if (comboBox_IDlop.getSelectedItem().toString() == null
						|| comboBox_IDkhoasv.getSelectedItem().toString() == null
						|| comboBox_hedaotao.getSelectedItem().toString() == null) {
					JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
				} else if (txtDiachisinhvien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
				} else if (radioNam.isSelected() == false && radioNu.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Giới tính vui lòng chọn Nam hoặc Nữ !");
				} else if (txtSdtsinhvien.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
				} else if (txtSdtsinhvien.getText().length() <= 9 || txtSdtsinhvien.getText().length() >= 11) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
				} else {
					sinhvien.setIDsinhvien(txtIDsinhvien.getText());
					sinhvien.setHoten(txtTensinhvien.getText());
					sinhvien.setIDlop(comboBox_IDlop.getSelectedItem().toString());
					sinhvien.setIDkhoa(comboBox_IDkhoasv.getSelectedItem().toString());
					sinhvien.setHedaotao(comboBox_hedaotao.getSelectedItem().toString());
					Date datesv = txtNgaysinhsinhvien.getDate();
					String datesvinput = new SimpleDateFormat("yyyy-MM-dd").format(datesv);
					sinhvien.setNgaysinh(datesvinput);
					sinhvien.setDiachi(txtDiachisinhvien.getText());
					if (radioNam.isSelected()) {
						sinhvien.setGioitinh("Nam");
					} else {
						sinhvien.setGioitinh("Nu");
					}
					sinhvien.setSdt(txtSdtsinhvien.getText());
					SinhvienDAO sinhvienDAO = new SinhvienDAO();
					sinhvienDAO.editSinhVien(sinhvien);
				}
				showTableSinhVien(); // Refresh
			}
		});
		btnSa.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa.setForeground(new Color(0, 0, 0));
		btnSa.setBounds(33, 73, 116, 30);
		panel_7.add(btnSa);
		// Xoa sinh vien
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhvienDAO sinhvienDAO = new SinhvienDAO();
				sinhvienDAO.deleteSinhVien(table);
				showTableSinhVien();
			}
		});
		btnXa.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa.setForeground(new Color(0, 0, 0));
		btnXa.setBounds(33, 120, 116, 30);
		panel_7.add(btnXa);
		// Reset sinh vien
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDsinhvien.setText(null);
				txtTensinhvien.setText(null);
				txtNgaysinhsinhvien.setDate(null);
				txtDiachisinhvien.setText(null);
				txtSdtsinhvien.setText(null);
			}
		});
		btnReset.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBounds(33, 168, 116, 30);
		panel_7.add(btnReset);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 204, 255));
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(10, 289, 706, 188);
		internalFrame.getContentPane().add(panel_8);
		panel_8.setLayout(null);

		txtIDsinhvien = new JTextField();
		txtIDsinhvien.setBounds(135, 25, 188, 20);
		panel_8.add(txtIDsinhvien);
		txtIDsinhvien.setColumns(10);

		txtTensinhvien = new JTextField();
		txtTensinhvien.setBounds(135, 56, 188, 20);
		panel_8.add(txtTensinhvien);
		txtTensinhvien.setColumns(10);

		JLabel lblHTn = new JLabel("Họ Tên:");
		lblHTn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHTn.setForeground(new Color(0, 0, 128));
		lblHTn.setBounds(25, 58, 100, 14);
		panel_8.add(lblHTn);

		comboBox_IDlop = new JComboBox();
		comboBox_IDlop.setMaximumRowCount(6);
		comboBox_IDlop.setBounds(135, 87, 131, 20);
		panel_8.add(comboBox_IDlop);

		JLabel lblMSinhVin = new JLabel("Mã Sinh Viên:");
		lblMSinhVin.setForeground(new Color(0, 0, 128));
		lblMSinhVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMSinhVin.setBounds(25, 27, 100, 14);
		panel_8.add(lblMSinhVin);

		JLabel lblHoTo = new JLabel("Hệ Đào Tạo:");
		lblHoTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoTo.setForeground(new Color(0, 0, 128));
		lblHoTo.setBounds(25, 149, 100, 14);
		panel_8.add(lblHoTo);

		JLabel lblLp = new JLabel("Mã Lớp:");
		lblLp.setForeground(new Color(0, 0, 128));
		lblLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLp.setBounds(25, 89, 100, 14);
		panel_8.add(lblLp);

		comboBox_hedaotao = new JComboBox();
		comboBox_hedaotao.setMaximumRowCount(4);
		comboBox_hedaotao.setBounds(135, 147, 131, 20);
		panel_8.add(comboBox_hedaotao);
		comboBox_hedaotao
				.setModel(new DefaultComboBoxModel(new String[] { "Dai Hoc", "Tai Chuc", "Cao Dang", "Trung Cap" }));

		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setForeground(new Color(0, 0, 128));
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgySinh.setBounds(355, 25, 112, 14);
		panel_8.add(lblNgySinh);

		txtNgaysinhsinhvien = new JDateChooser();
		txtNgaysinhsinhvien.setBounds(477, 23, 131, 20);
		panel_8.add(txtNgaysinhsinhvien);

		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setForeground(new Color(0, 0, 128));
		lblaCh.setBounds(355, 69, 112, 14);
		panel_8.add(lblaCh);

		txtDiachisinhvien = new JTextField();
		txtDiachisinhvien.setBounds(477, 70, 188, 20);
		panel_8.add(txtDiachisinhvien);
		txtDiachisinhvien.setColumns(10);

		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setForeground(new Color(0, 0, 128));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh.setBounds(355, 113, 112, 14);
		panel_8.add(lblGiiTnh);

		radioNam = new JRadioButton("Nam");
		radioNam.setBackground(new Color(204, 204, 255));
		radioNam.setBounds(477, 113, 78, 23);
		panel_8.add(radioNam);
		buttonGroup.add(radioNam);

		radioNu = new JRadioButton("Nữ");
		radioNu.setBackground(new Color(204, 204, 255));
		radioNu.setBounds(557, 113, 78, 23);
		panel_8.add(radioNu);
		buttonGroup.add(radioNu);

		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinThoi.setForeground(new Color(0, 0, 128));
		lblSinThoi.setBounds(355, 152, 112, 14);
		panel_8.add(lblSinThoi);

		txtSdtsinhvien = new JTextField();
		txtSdtsinhvien.setBounds(479, 149, 186, 20);
		panel_8.add(txtSdtsinhvien);
		txtSdtsinhvien.setColumns(10);

		comboBox_IDkhoasv = new JComboBox();
		comboBox_IDkhoasv.setBounds(135, 116, 131, 20);
		panel_8.add(comboBox_IDkhoasv);

		JLabel lblMaKhoa = new JLabel("Mã Khoa:");
		lblMaKhoa.setForeground(new Color(0, 0, 128));
		lblMaKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaKhoa.setBounds(25, 118, 100, 20);
		panel_8.add(lblMaKhoa);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "idsv", "hoten", "idlop", "idkhoa","hedt", "ngaysinh", "diachi", "gioitinh", "sdt" }));
		comboBox.setBounds(348, 253, 119, 20);
		internalFrame.getContentPane().add(comboBox);

		JLabel lblSort = new JLabel("Sắp Xếp");
		lblSort.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSort.setBounds(273, 256, 65, 14);
		internalFrame.getContentPane().add(lblSort);

		JButton btnOk = new JButton("A-Z");
		btnOk.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String group = "ASC";
				String sort_SV = comboBox.getSelectedItem().toString();
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableSinhVienSort(table, sort_SV, group);
			}
		});
		btnOk.setBounds(493, 252, 95, 23);
		internalFrame.getContentPane().add(btnOk);

		JButton btnZa = new JButton("Z-A");
		btnZa.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		btnZa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String group = "DESC";
				String sort_SV = comboBox.getSelectedItem().toString();
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableSinhVienSort(table, sort_SV, group);
			}
		});
		btnZa.setBounds(618, 253, 95, 23);
		internalFrame.getContentPane().add(btnZa);

		JButton btnSelectAll = new JButton("Select All");
		btnSelectAll.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableSinhVienSelect(table);
			}
		});
		btnSelectAll.setBounds(20, 253, 112, 23);
		internalFrame.getContentPane().add(btnSelectAll);

		JButton btnUnselect = new JButton("Unselect");
		btnUnselect.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableSinhVien();
			}
		});
		btnUnselect.setBounds(142, 253, 110, 23);
		internalFrame.getContentPane().add(btnUnselect);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBounds(0, 0, 934, 21);
		internalFrame.getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnFile.setIcon(new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar.add(mnFile);

		JMenu mnExport = new JMenu("Export");
		mnExport.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile.add(mnExport);

		JMenuItem mntmExcel = new JMenuItem("Excel ");
		mntmExcel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table);
			}
		});
		mntmExcel.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnExport.add(mntmExcel);

		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table, "Danh Sách Sinh Viên");
			}
		});
		mntmPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile.add(mntmPrint);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JInternalFrame internalFrame_1 = new JInternalFrame("Quản Lý Giáo Viên");
		internalFrame_1.setClosable(true);
		internalFrame_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame_1.setBounds(0, 0, 938, 517); // (0, 0, 938, 517) GVTABLE
		panel_5.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 73, 914, 173);
		internalFrame_1.getContentPane().add(scrollPane_1);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table_1.getSelectedRow();
					txtIDgiaovien.setText(table_1.getValueAt(row, 1).toString());
					txtTengiaovien.setText(table_1.getValueAt(row, 2).toString());
					comboBox_IDmon.setSelectedItem(table_1.getValueAt(row, 3).toString());
					comboBox_IDkhoagv.setSelectedItem(table_1.getValueAt(row, 4).toString());
					comboBox_IDlopgv.setSelectedItem(table_1.getValueAt(row, 5).toString());
					txtNgaysinhgv.setDate((Date) table_1.getValueAt(row, 6));
					if (table_1.getValueAt(row, 7).toString().equals("Nam")) {
						radioNamGV.setSelected(true);
					} else if (table_1.getValueAt(row, 7).toString().equals("Nu")) {
						radioNuGV.setSelected(true);
					}
					txtEmailgiaovien.setText(table_1.getValueAt(row, 8).toString());
					txtSdtgiaovien.setText(table_1.getValueAt(row, 9).toString());

				} catch (Exception e) {}
			}
		});
		scrollPane_1.setViewportView(table_1);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(204, 204, 255));
		panel_9.setBounds(10, 289, 706, 188);
		internalFrame_1.getContentPane().add(panel_9);
		panel_9.setLayout(null);

		JLabel lblMGioVin = new JLabel("Mã Giáo Viên:");
		lblMGioVin.setForeground(new Color(0, 0, 128));
		lblMGioVin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMGioVin.setBounds(32, 28, 114, 14);
		panel_9.add(lblMGioVin);

		txtIDgiaovien = new JTextField();
		txtIDgiaovien.setBounds(154, 26, 144, 20);
		panel_9.add(txtIDgiaovien);
		txtIDgiaovien.setColumns(10);

		JLabel lblHTn_1 = new JLabel("Họ Tên:");
		lblHTn_1.setForeground(new Color(0, 0, 128));
		lblHTn_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHTn_1.setBounds(32, 59, 114, 14);
		panel_9.add(lblHTn_1);

		txtTengiaovien = new JTextField();
		txtTengiaovien.setBounds(154, 57, 144, 20);
		panel_9.add(txtTengiaovien);
		txtTengiaovien.setColumns(10);

		JLabel lblMnDy = new JLabel("Mã Môn Dạy:");
		lblMnDy.setForeground(new Color(0, 0, 128));
		lblMnDy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMnDy.setBounds(32, 90, 105, 14);
		panel_9.add(lblMnDy);

		JLabel lblNgySinh_1 = new JLabel("Ngày Sinh:");
		lblNgySinh_1.setForeground(new Color(0, 0, 128));
		lblNgySinh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgySinh_1.setBounds(339, 26, 114, 14);
		panel_9.add(lblNgySinh_1);

		txtNgaysinhgv = new JDateChooser();
		txtNgaysinhgv.setBounds(448, 22, 144, 20);
		panel_9.add(txtNgaysinhgv);

		comboBox_IDmon = new JComboBox();
		comboBox_IDmon.setMaximumRowCount(6);
		comboBox_IDmon.setBounds(154, 88, 142, 20);
		panel_9.add(comboBox_IDmon);

		JLabel lblGiiTnh_1 = new JLabel("Giới Tính:");
		lblGiiTnh_1.setForeground(new Color(0, 0, 128));
		lblGiiTnh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh_1.setBounds(338, 63, 88, 14);
		panel_9.add(lblGiiTnh_1);

		radioNamGV = new JRadioButton("Nam");
		buttonGroup_2.add(radioNamGV);
		radioNamGV.setBackground(new Color(204, 204, 255));
		radioNamGV.setBounds(448, 58, 66, 23);
		panel_9.add(radioNamGV);

		radioNuGV = new JRadioButton("Nữ");
		buttonGroup_2.add(radioNuGV);
		radioNuGV.setBackground(new Color(204, 204, 255));
		radioNuGV.setBounds(516, 58, 66, 23);
		panel_9.add(radioNuGV);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(339, 103, 89, 14);
		panel_9.add(lblEmail);

		txtEmailgiaovien = new JTextField();
		txtEmailgiaovien.setBounds(448, 99, 144, 20);
		panel_9.add(txtEmailgiaovien);
		txtEmailgiaovien.setColumns(10);

		JLabel lblaCh_1 = new JLabel("Mã Khoa:");
		lblaCh_1.setForeground(new Color(0, 0, 128));
		lblaCh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh_1.setBounds(32, 121, 88, 14);
		panel_9.add(lblaCh_1);

		JLabel lblSinThoi_1 = new JLabel("Số Điện Thoại:");
		lblSinThoi_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSinThoi_1.setForeground(new Color(0, 0, 128));
		lblSinThoi_1.setBounds(336, 140, 92, 14);
		panel_9.add(lblSinThoi_1);

		txtSdtgiaovien = new JTextField();
		txtSdtgiaovien.setText("+84");
		txtSdtgiaovien.setBounds(446, 138, 146, 20);
		panel_9.add(txtSdtgiaovien);
		txtSdtgiaovien.setColumns(10);

		comboBox_IDkhoagv = new JComboBox();
		comboBox_IDkhoagv.setMaximumRowCount(6);
		comboBox_IDkhoagv.setBounds(154, 115, 142, 20);
		panel_9.add(comboBox_IDkhoagv);

		JLabel lblMLp = new JLabel("Mã Lớp:");
		lblMLp.setForeground(new Color(0, 0, 128));
		lblMLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMLp.setBounds(32, 152, 88, 14);
		panel_9.add(lblMLp);

		comboBox_IDlopgv = new JComboBox();
		comboBox_IDlopgv.setMaximumRowCount(6);
		comboBox_IDlopgv.setBounds(154, 146, 142, 20);
		panel_9.add(comboBox_IDlopgv);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.activeCaption);
		panel_10.setBounds(0, 29, 935, 35); // size title
		internalFrame_1.getContentPane().add(panel_10);

		JLabel lblQunLSinh = new JLabel("Nhập Giáo Viên");
		lblQunLSinh.setForeground(new Color(0, 0, 0));
		lblQunLSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_10.add(lblQunLSinh);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(204, 204, 255));
		panel_11.setBounds(730, 257, 194, 220);
		internalFrame_1.getContentPane().add(panel_11);
		panel_11.setLayout(null);

		JButton btnThm_1 = new JButton("Thêm"); // Them giao vien
		btnThm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Giaovien giaovien = new Giaovien();
				if (txtIDgiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Mã giáo viên không được để trống !");
				} else if (txtTengiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên giáo viên không được để trống !");
				} else if (radioNamGV.isSelected() == false && radioNuGV.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Giới tinh vui lòng chọn Nam hoặc Nữ");
				} else if (txtEmailgiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Email không được để trống !");
				} else if (txtEmailgiaovien.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$") == false) {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \n vd: demo123.@gmail.com");
				} else if (txtSdtgiaovien.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
				} else {
					giaovien.setIDgiaovien(txtIDgiaovien.getText());
					giaovien.setHoten(txtTengiaovien.getText());
					giaovien.setIDmonday(comboBox_IDmon.getSelectedItem().toString());
					giaovien.setIDkhoa(comboBox_IDkhoagv.getSelectedItem().toString());
					giaovien.setIDlop(comboBox_IDlopgv.getSelectedItem().toString());
					Date dategv = txtNgaysinhgv.getDate();
					String dategvinput = new SimpleDateFormat("yyyy-MM-dd").format(dategv);
					giaovien.setNgaysinh(dategvinput);
					if (radioNamGV.isSelected()) {
						giaovien.setGioitinh("Nam");
					} else {
						giaovien.setGioitinh("Nu");
					}
					giaovien.setEmail(txtEmailgiaovien.getText());
					giaovien.setSdt(txtSdtgiaovien.getText());
					
					GiaovienDAO giaovienDAO = new GiaovienDAO();
					System.out.println("test");
					giaovienDAO.addGiaoVien(giaovien);
				}

				showTableGiaoVien();
			}
		});
		btnThm_1.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThm_1.setForeground(new Color(0, 0, 0));
		btnThm_1.setBounds(33, 24, 118, 30);
		panel_11.add(btnThm_1);

		JButton btnSa_1 = new JButton("Sửa");
		btnSa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Giaovien giaovien = new Giaovien();
				if (txtIDgiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Mã giáo viên không được để trống !");
				} else if (txtTengiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên giáo viên không được để trống !");
				} else if (radioNamGV.isSelected() == false && radioNuGV.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Giới tinh vui lòng chọn Nam hoặc Nữ");
				} else if (txtEmailgiaovien.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Email không được để trống !");
				} else if (txtEmailgiaovien.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$") == false) {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \n vd: demo123.@gmail.com");
				} else if (txtSdtgiaovien.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được nhập kí tự chữ !");
				} else {
					giaovien.setIDgiaovien(txtIDgiaovien.getText());
					giaovien.setHoten(txtTengiaovien.getText());
					giaovien.setIDmonday(comboBox_IDmon.getSelectedItem().toString());
					giaovien.setIDkhoa(comboBox_IDkhoagv.getSelectedItem().toString());
					giaovien.setIDlop(comboBox_IDlopgv.getSelectedItem().toString());
					Date dategv = txtNgaysinhgv.getDate();
					String dategvinput = new SimpleDateFormat("yyyy-MM-dd").format(dategv);
					giaovien.setNgaysinh(dategvinput);
					if (radioNamGV.isSelected()) {
						giaovien.setGioitinh("Nam");
					} else {
						giaovien.setGioitinh("Nu");
					}
					giaovien.setEmail(txtEmailgiaovien.getText());
					giaovien.setSdt(txtSdtgiaovien.getText());

					GiaovienDAO giaovienDAO = new GiaovienDAO();
					giaovienDAO.editGiaoVien(giaovien);
				}
				showTableGiaoVien();
			}
		});
		btnSa_1.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa_1.setForeground(new Color(0, 0, 0));
		btnSa_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa_1.setBounds(33, 73, 118, 30);
		panel_11.add(btnSa_1);

		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaovienDAO giaovienDAO = new GiaovienDAO();
				giaovienDAO.deleteGiaoVien(table_1);
				showTableGiaoVien();
			}
		});
		btnXa_1.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa_1.setForeground(new Color(0, 0, 0));
		btnXa_1.setBounds(33, 120, 118, 30);
		panel_11.add(btnXa_1);

		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDgiaovien.setText(null);
				txtTengiaovien.setText(null);
				txtNgaysinhgv.setDate(null);
				txtEmailgiaovien.setText(null);
				txtSdtgiaovien.setText("+84");
			}
		});
		btnReset_1.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset_1.setForeground(new Color(0, 0, 0));
		btnReset_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_1.setBounds(33, 168, 118, 30);
		panel_11.add(btnReset_1);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 935, 21);
		internalFrame_1.getContentPane().add(menuBar_1);

		JMenu mnFile_1 = new JMenu("File");
		mnFile_1.setIcon(
				new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar_1.add(mnFile_1);

		JMenu mnExport_1 = new JMenu("Export");
		mnExport_1.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile_1.add(mnExport_1);

		JMenuItem mntmExcelxls = new JMenuItem("Excel ");
		mntmExcelxls.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcelxls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_1);
			}
		});
		mntmExcelxls.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnExport_1.add(mntmExcelxls);

		JMenuItem mntmPrint_1 = new JMenuItem("Print");
		mntmPrint_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_1, "Danh Sách Giáo Viên");
			}
		});
		mntmPrint_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint_1.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile_1.add(mntmPrint_1);

		JMenuItem mntmExit_1 = new JMenuItem("Exit");
		mnFile_1.add(mntmExit_1);

		JButton btnSelectAll_1 = new JButton("Select All");
		btnSelectAll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableGiaoVienSelect(table_1);
			}
		});
		btnSelectAll_1.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll_1.setBounds(20, 257, 115, 23);
		internalFrame_1.getContentPane().add(btnSelectAll_1);

		JButton btnUnselect_1 = new JButton("Unselect");
		btnUnselect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableGiaoVien();
			}
		});
		btnUnselect_1.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect_1.setBounds(150, 257, 108, 23);
		internalFrame_1.getContentPane().add(btnUnselect_1);

		JLabel lblSort_1 = new JLabel("Sắp Xếp");
		lblSort_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSort_1.setBounds(281, 257, 62, 21);
		internalFrame_1.getContentPane().add(lblSort_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "idgv", "hoten", "idmon", "idkhoa", "idlop", "ngaysinh", "gioitinh", "email" ,"sdt"}));
		comboBox_1.setBounds(353, 258, 123, 20);
		internalFrame_1.getContentPane().add(comboBox_1);

		JButton btnAz = new JButton("A-Z");
		btnAz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableGiaoVienSort(table_1, comboBox_1.getSelectedItem().toString(), "ASC");
			}
		});
		btnAz.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnAz.setBounds(500, 257, 89, 23);
		internalFrame_1.getContentPane().add(btnAz);

		JButton btnZa_1 = new JButton("Z-A");
		btnZa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableGiaoVienSort(table_1, comboBox_1.getSelectedItem().toString(), "DESC");
			}
		});
		btnZa_1.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		btnZa_1.setBounds(608, 257, 89, 23);
		internalFrame_1.getContentPane().add(btnZa_1);

		JInternalFrame internalFrame_2 = new JInternalFrame("Quản Lý Điểm");
		internalFrame_2.setClosable(true);
		internalFrame_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame_2.setBounds(0, 0, 938, 517); // 0, 0, 938, 517 DTABLE
		panel_5.add(internalFrame_2);
		internalFrame_2.getContentPane().setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaption);
		panel_12.setBounds(0, 29, 935, 35);
		internalFrame_2.getContentPane().add(panel_12);

		JLabel lblQunLim = new JLabel("Nhập Điểm");
		lblQunLim.setForeground(new Color(0, 0, 0));
		lblQunLim.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_12.add(lblQunLim);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(204, 204, 255));
		panel_13.setBounds(10, 68, 707, 177);
		internalFrame_2.getContentPane().add(panel_13);
		panel_13.setLayout(null);

		comboBox_IDsvdiem = new JComboBox();
		comboBox_IDsvdiem.setBounds(157, 67, 157, 20);
		panel_13.add(comboBox_IDsvdiem);

		comboBox_Mondiem = new JComboBox();
		comboBox_Mondiem.setBounds(156, 102, 158, 20);
		panel_13.add(comboBox_Mondiem);

		JLabel lblLnThi = new JLabel("Điểm 15'p");
		lblLnThi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLnThi.setForeground(new Color(0, 0, 128));
		lblLnThi.setBounds(347, 31, 78, 14);
		panel_13.add(lblLnThi);

		txtDiemthi15p = new JTextField();
		txtDiemthi15p.setBounds(463, 28, 51, 20);
		panel_13.add(txtDiemthi15p);
		txtDiemthi15p.setColumns(10);

		JLabel lblHS = new JLabel("Điểm 45'p");
		lblHS.setForeground(new Color(0, 0, 128));
		lblHS.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHS.setBounds(347, 66, 78, 14);
		panel_13.add(lblHS);

		txtDiemthi45p = new JTextField();
		txtDiemthi45p.setBounds(463, 63, 51, 20);
		panel_13.add(txtDiemthi45p);
		txtDiemthi45p.setColumns(10);

		JLabel lblim = new JLabel("Điểm thi");
		lblim.setForeground(new Color(0, 0, 128));
		lblim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblim.setBounds(347, 101, 78, 14);
		panel_13.add(lblim);

		txtDiemthi = new JTextField();
		txtDiemthi.setBounds(463, 98, 51, 20);
		panel_13.add(txtDiemthi);
		txtDiemthi.setColumns(10);

		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_15.setBackground(new Color(204, 255, 204));
		panel_15.setBounds(546, 28, 139, 121);
		panel_13.add(panel_15);
		panel_15.setLayout(null);

		JLabel lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setBounds(32, 22, 97, 14);
		panel_15.add(lblTrngThi);
		lblTrngThi.setForeground(new Color(0, 0, 153));
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 13));

		JRadioButton radioDat = new JRadioButton("Đạt");
		radioDat.setEnabled(false);
		buttonGroup_1.add(radioDat);
		radioDat.setBounds(27, 48, 57, 23);
		panel_15.add(radioDat);
		radioDat.setBackground(new Color(204, 255, 204));

		JRadioButton radioKhongdat = new JRadioButton("Không Đạt");
		radioKhongdat.setEnabled(false);
		buttonGroup_1.add(radioKhongdat);
		radioKhongdat.setBounds(27, 74, 102, 23);
		panel_15.add(radioKhongdat);
		radioKhongdat.setBackground(new Color(204, 255, 204));

		txtIDmondiem = new JTextField();
		txtIDmondiem.setBackground(SystemColor.textHighlightText);
		txtIDmondiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIDmondiem.setBounds(157, 135, 158, 20);
		panel_13.add(txtIDmondiem);
		txtIDmondiem.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 252, 914, 194);
		internalFrame_2.getContentPane().add(scrollPane_2);

		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				comboBox_IDlopdiem.removeAllItems();
				comboBox_Mondiem.removeAllItems();
				comboBox_IDsvdiem.removeAllItems();
				int row = table_2.getSelectedRow();
				comboBox_IDlopdiem.addItem(table_2.getValueAt(row, 1));
				comboBox_IDsvdiem.addItem(table_2.getValueAt(row, 2).toString());
				txtIDmondiem.setText(table_2.getValueAt(row, 3).toString());
				comboBox_Mondiem.addItem(table_2.getValueAt(row, 4).toString());
				txtDiemthi15p.setText(table_2.getValueAt(row, 5).toString());
				txtDiemthi45p.setText(table_2.getValueAt(row, 6).toString());
				txtDiemthi.setText(table_2.getValueAt(row, 7).toString());
				txtTongket.setText(table_2.getValueAt(row, 8).toString());
				if (table_2.getValueAt(row, 9).toString().equals("Dat")) {
					radioDat.setSelected(true);
				} else {
					radioKhongdat.setSelected(true);
				}
				} catch (Exception e) {}
			}
		});
		scrollPane_2.setViewportView(table_2);

		JButton btnLayTenMon = new JButton("Lấy Mã Môn");
		btnLayTenMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT idmon FROM project.mon WHERE mon=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, comboBox_Mondiem.getSelectedItem().toString());
					rs = stmt.executeQuery();
					while (rs.next()) {
						txtIDmondiem.setText(rs.getString("idmon"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy mã môn\n");
				}
			}
		});
		btnLayTenMon.setIcon(
				new ImageIcon("./icon/Step-Forward-Normal-Blue-icon.png"));
		btnLayTenMon.setBounds(10, 134, 137, 23);
		panel_13.add(btnLayTenMon);

		JButton btnLayMaMon = new JButton("Lấy Tên Môn");
		btnLayMaMon.setIcon(
				new ImageIcon("./icon/Step-Forward-Normal-Blue-icon.png"));
		btnLayMaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_Mondiem.removeAllItems(); // Reset comboBox
				String sql = "SELECT * FROM project.giaovien JOIN project.mon ON giaovien.idmon = mon.idmon WHERE giaovien.idgv='" + id + "'";
				try {
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					while (rs.next()) {
						comboBox_Mondiem.addItem(rs.getString("mon"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy tên môn\n");
				}
			}
		});
		btnLayMaMon.setBounds(10, 101, 137, 23);
		panel_13.add(btnLayMaMon);

		txtTongket = new JTextField();
		txtTongket.setEnabled(false);
		txtTongket.setBounds(463, 134, 51, 20);
		panel_13.add(txtTongket);
		txtTongket.setColumns(10);

		JButton btnTngKt = new JButton("Tổng kết");
		btnTngKt.setIcon(
				new ImageIcon("./icon/Step-Forward-Normal-Red-icon.png"));
		btnTngKt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					a = Float.parseFloat(txtDiemthi15p.getText());
					b = Float.parseFloat(txtDiemthi45p.getText());
					c = Float.parseFloat(txtDiemthi.getText()) * 2;
					txtTongket.setText(Float.toString((a + b + c) / 4));
					if ((a + b + c) / 4 >= 5 && a >= 1 && b >= 1 && c >= 1) {
						radioDat.setSelected(true);
					} else {
						radioKhongdat.setSelected(true);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Để lấy được điểm tổng kết \nBạn phải nhập đầy đủ 3 loại điểm \nVà chỉ được nhập điểm số ");
				}
			}
		});
		btnTngKt.setBounds(341, 132, 112, 23);
		panel_13.add(btnTngKt);

		comboBox_IDlopdiem = new JComboBox();
		comboBox_IDlopdiem.setBounds(158, 28, 157, 20);
		panel_13.add(comboBox_IDlopdiem);

		JButton btnTnGioVin = new JButton("Lấy Mã Lớp");
		btnTnGioVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_IDlopdiem.removeAllItems();
				String sql = "SELECT idlop FROM project.giaovien WHERE idgv='" + id + "'";
				try {
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					while (rs.next()) {
						comboBox_IDlopdiem.addItem(rs.getString("idlop"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy tên ID lop\n");
				}
			}
		});
		btnTnGioVin
				.setIcon(new ImageIcon("./icon/Step-Forward-Normal-icon.png"));
		btnTnGioVin.setBounds(10, 27, 137, 23);
		panel_13.add(btnTnGioVin);

		JButton btnMSinhVin = new JButton("Mã Sinh Viên");
		btnMSinhVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_IDsvdiem.removeAllItems();
				String sql = "SELECT idsv FROM project.sinhvien WHERE idlop=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, comboBox_IDlopdiem.getSelectedItem().toString());
					rs = stmt.executeQuery();
					while (rs.next()) {
						comboBox_IDsvdiem.addItem(rs.getString("idsv"));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi khi lấy ID sinh viên\n");
				}
			}
		});
		btnMSinhVin
				.setIcon(new ImageIcon("./icon/Step-Forward-Normal-icon.png"));
		btnMSinhVin.setBounds(10, 66, 137, 23);
		panel_13.add(btnMSinhVin);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(204, 204, 255));
		panel_14.setBounds(727, 68, 197, 177);
		internalFrame_2.getContentPane().add(panel_14);
		panel_14.setLayout(null);

		JButton btnThm_2 = new JButton("Thêm"); // Them diem
		btnThm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matcher m = null;
				Diem diem = new Diem();
				// Bat loi nguoi dung nhap diem
				if (comboBox_IDlopdiem.getSelectedItem() == null || comboBox_Mondiem.getSelectedItem() == null
						|| comboBox_IDsvdiem.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng lấy đầy đủ thông tin hộp chọn");
				} else if (txtIDmondiem.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID môn không được để trống !");
				} else if (txtDiemthi15p.getText().length() == 0 || txtDiemthi45p.getText().length() == 0
						|| txtDiemthi.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô điểm!");

				} else if (txtDiemthi15p.getText().matches("(.*)[a-zA-Z](.*)")
						|| txtDiemthi45p.getText().matches("(.*)[a-zA-Z](.*)")
						|| txtDiemthi.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Không được nhập chữ vào ô điểm!");
				} else if (Float.parseFloat(txtDiemthi15p.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm 15p không được lớn hơn 10!");
				} else if (Float.parseFloat(txtDiemthi45p.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm 45p không được lớn hơn 10!");
				} else if (Float.parseFloat(txtDiemthi.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm thi không được lớn hơn 10!");
				} else if (txtTongket.getText().length() == 0 || txtTongket.getText() == null) {
					JOptionPane.showMessageDialog(null, "Điểm tổng kết không được để trống!");
				} else {
					diem.setIDlop(comboBox_IDlopdiem.getSelectedItem().toString());
					diem.setMonhoc(comboBox_Mondiem.getSelectedItem().toString());
					diem.setIDMonhoc(txtIDmondiem.getText().toString());
					diem.setIDsinhvien(comboBox_IDsvdiem.getSelectedItem().toString());
					diem.setDiem15(Float.parseFloat(txtDiemthi15p.getText()));
					diem.setDiem45(Float.parseFloat(txtDiemthi45p.getText()));
					diem.setDiemthi(Float.parseFloat(txtDiemthi.getText()));
					diem.setTongket(Float.parseFloat(txtTongket.getText()));
					if (radioDat.isSelected()) {
						diem.setKetqua("Dat");
					} else {
						diem.setKetqua("Khong Dat");
					}
					diem.setIDgiaovien(id);
					DiemDAO diemDAO = new DiemDAO();
					diemDAO.addDiem(diem, comboBox_IDsvdiem.getSelectedItem().toString(),
							txtIDmondiem.getText().toString());
				}
				showTableDiem();
			}
		});
		btnThm_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThm_2.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm_2.setBounds(35, 11, 116, 30);
		panel_14.add(btnThm_2);

		JButton btnSa_2 = new JButton("Sửa"); // Sua diem
		btnSa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matcher m = null;
				Diem diem = new Diem();
				// Bat loi nguoi dung nhap diem
				if (comboBox_IDlopdiem.getSelectedItem() == null || comboBox_Mondiem.getSelectedItem() == null
						|| comboBox_IDsvdiem.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng lấy đầy đủ thông tin hộp chọn");
				} else if (txtIDmondiem.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID môn không được để trống !");
				} else if (txtDiemthi15p.getText().length() == 0 || txtDiemthi45p.getText().length() == 0
						|| txtDiemthi.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Không được để trống ô điểm!");

				} else if (txtDiemthi15p.getText().matches("(.*)[a-zA-Z](.*)")
						|| txtDiemthi45p.getText().matches("(.*)[a-zA-Z](.*)")
						|| txtDiemthi.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Không được nhập chữ vào ô điểm!");
				} else if (Float.parseFloat(txtDiemthi15p.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm 15p không được lớn hơn 10!");
				} else if (Float.parseFloat(txtDiemthi45p.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm 45p không được lớn hơn 10!");
				} else if (Float.parseFloat(txtDiemthi.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Điểm thi không được lớn hơn 10!");
				} else if (txtTongket.getText().length() == 0 || txtTongket.getText() == null) {
					JOptionPane.showMessageDialog(null, "Điểm tổng kết không được để trống!");
				} else {
					diem.setIDlop(comboBox_IDlopdiem.getSelectedItem().toString());
					diem.setMonhoc(comboBox_Mondiem.getSelectedItem().toString());
					diem.setIDMonhoc(txtIDmondiem.getText().toString());
					diem.setIDsinhvien(comboBox_IDsvdiem.getSelectedItem().toString());
					diem.setDiem15(Float.parseFloat(txtDiemthi15p.getText()));
					diem.setDiem45(Float.parseFloat(txtDiemthi45p.getText()));
					diem.setDiemthi(Float.parseFloat(txtDiemthi.getText()));
					diem.setTongket(Float.parseFloat(txtTongket.getText()));
					if (radioDat.isSelected()) {
						diem.setKetqua("Dat");
					} else {
						diem.setKetqua("Khong Dat");
					}
					diem.setIDgiaovien(id);
					DiemDAO diemDAO = new DiemDAO();
					diemDAO.editDiem(diem);
				}
				showTableDiem();
			}
		});
		btnSa_2.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa_2.setBounds(35, 52, 116, 30);
		panel_14.add(btnSa_2);

		JButton btnXa_2 = new JButton("Xóa"); // Xoa diem
		btnXa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiemDAO diemDAO = new DiemDAO();
				diemDAO.deleteDiem(table_2);
				showTableDiem();
			}
		});
		btnXa_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa_2.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa_2.setBounds(35, 88, 116, 30);
		panel_14.add(btnXa_2);

		JButton btnReset_2 = new JButton("Reset");
		btnReset_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDmondiem.setText(null);
				txtDiemthi15p.setText(null);
				txtDiemthi45p.setText(null);
				txtDiemthi.setText(null);
				txtTongket.setText(null);
			}
		});
		btnReset_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_2.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset_2.setBounds(35, 129, 116, 30);
		panel_14.add(btnReset_2);

		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 935, 21);
		internalFrame_2.getContentPane().add(menuBar_2);

		JMenu mnFile_2 = new JMenu("File");
		mnFile_2.setIcon(
				new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar_2.add(mnFile_2);

		JMenu mnExport_2 = new JMenu("Export");
		mnExport_2.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile_2.add(mnExport_2);

		JMenuItem mntmExcelxls_1 = new JMenuItem("Excel ");
		mntmExcelxls_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcelxls_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_2);
			}
		});
		mntmExcelxls_1.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnExport_2.add(mntmExcelxls_1);

		JMenuItem mntmPrint_2 = new JMenuItem("Print");
		mntmPrint_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_2, "Bảng Điểm Lớp Dạy");
			}
		});
		mntmPrint_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint_2.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile_2.add(mntmPrint_2);

		JMenuItem mntmExit_2 = new JMenuItem("Exit");
		mnFile_2.add(mntmExit_2);

		JButton btnSelectAll_2 = new JButton("Select All");
		btnSelectAll_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableDiemSelect(table_2);
			}
		});
		btnSelectAll_2.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll_2.setBounds(97, 457, 112, 23);
		internalFrame_2.getContentPane().add(btnSelectAll_2);

		JButton btnUnselect_2 = new JButton("Unselect");
		btnUnselect_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableDiem();
			}
		});
		btnUnselect_2.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect_2.setBounds(240, 457, 112, 23);
		internalFrame_2.getContentPane().add(btnUnselect_2);

		JLabel lblSort_2 = new JLabel("Sắp Xếp");
		lblSort_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSort_2.setBounds(369, 461, 56, 14);
		internalFrame_2.getContentPane().add(lblSort_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumRowCount(6);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "idlop", "idsv" ,"idmon", "mon", "diem15", "diem45",
				"diemthi", "tongket", "ketqua", "idgv" }));
		comboBox_2.setBounds(435, 458, 137, 20);
		internalFrame_2.getContentPane().add(comboBox_2);

		JButton btnAz_1 = new JButton("A-Z");
		btnAz_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableDiemSort(table_2, comboBox_2.getSelectedItem().toString(), "ASC");
			}
		});
		btnAz_1.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnAz_1.setBounds(604, 457, 89, 23);
		internalFrame_2.getContentPane().add(btnAz_1);

		JButton btnZa_2 = new JButton("Z-A");
		btnZa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableDiemSort(table_2, comboBox_2.getSelectedItem().toString(), "DESC");
			}
		});
		btnZa_2.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		btnZa_2.setBounds(733, 457, 89, 23);
		internalFrame_2.getContentPane().add(btnZa_2);

		JInternalFrame internalFrame_3 = new JInternalFrame("Qu\u1EA3n L\u00FD L\u1EDBp");
		internalFrame_3.getContentPane().setBackground(SystemColor.menu);
		internalFrame_3.getContentPane().setLayout(null);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.activeCaption);
		panel_19.setBounds(0, 29, 935, 35);
		internalFrame_3.getContentPane().add(panel_19);

		JLabel lblQunLLp = new JLabel("Nhập Lớp");
		lblQunLLp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLLp.setForeground(new Color(0, 0, 0));
		panel_19.add(lblQunLLp);

		JPanel panel_17 = new JPanel();
		panel_17.setBounds(293, 75, 631, 345);
		internalFrame_3.getContentPane().add(panel_17);
		panel_17.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 631, 345);
		panel_17.add(scrollPane_3);

		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_3.getSelectedRow();
				txtIDlop.setText(table_3.getValueAt(row, 1).toString());
				txtLop.setText(table_3.getValueAt(row, 2).toString());
				txtKhoahoc.setText(table_3.getValueAt(row, 4).toString());
			}
		});
		scrollPane_3.setViewportView(table_3);

		JPanel panel_18 = new JPanel();
		panel_18.setBounds(10, 75, 271, 207);
		internalFrame_3.getContentPane().add(panel_18);
		panel_18.setBackground(new Color(204, 204, 255));
		panel_18.setLayout(null);

		comboBox_IDkhoa = new JComboBox();
		comboBox_IDkhoa.setBounds(122, 106, 123, 20);
		panel_18.add(comboBox_IDkhoa);

		JLabel lblMLp_1 = new JLabel("Mã Lớp:");
		lblMLp_1.setForeground(new Color(0, 0, 128));
		lblMLp_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMLp_1.setBounds(24, 27, 88, 14);
		panel_18.add(lblMLp_1);

		JLabel lblTnLp = new JLabel("Tên Lớp:");
		lblTnLp.setForeground(new Color(0, 0, 128));
		lblTnLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnLp.setBounds(24, 68, 88, 14);
		panel_18.add(lblTnLp);

		txtIDlop = new JTextField();
		txtIDlop.setBackground(SystemColor.textHighlightText);
		txtIDlop.setBounds(122, 25, 123, 20);
		panel_18.add(txtIDlop);
		txtIDlop.setColumns(10);

		txtLop = new JTextField();
		txtLop.setBackground(SystemColor.textHighlightText);
		txtLop.setBounds(122, 66, 123, 20);
		panel_18.add(txtLop);
		txtLop.setColumns(10);

		JLabel lblMKhoa = new JLabel("Mã Khoa:");
		lblMKhoa.setForeground(new Color(0, 0, 128));
		lblMKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhoa.setBounds(24, 112, 88, 14);
		panel_18.add(lblMKhoa);

		JLabel lblKhaHc = new JLabel("Khóa Học:");
		lblKhaHc.setForeground(new Color(0, 0, 128));
		lblKhaHc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKhaHc.setBounds(24, 153, 88, 14);
		panel_18.add(lblKhaHc);

		txtKhoahoc = new JTextField();
		txtKhoahoc.setBackground(SystemColor.textHighlightText);
		txtKhoahoc.setBounds(122, 147, 123, 20);
		panel_18.add(txtKhoahoc);
		txtKhoahoc.setColumns(10);

		JPanel panel_20 = new JPanel();
		panel_20.setBounds(10, 293, 270, 127);
		internalFrame_3.getContentPane().add(panel_20);
		panel_20.setBackground(new Color(204, 204, 255));
		panel_20.setLayout(null);

		JButton btnThm_3 = new JButton("Thêm"); // Them lop
		btnThm_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lop lop = new Lop();
				if (txtIDlop.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID lớp không được để trống !");
				} else if (txtLop.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên lớp không được để trống !");
				} else if (txtKhoahoc.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Khóa học không được để trống !");
				} else if (txtKhoahoc.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Khóa học không được nhập kí tự chữ !");
				} else if (Integer.parseInt(txtKhoahoc.getText()) > 99) {
					JOptionPane.showMessageDialog(null, "Khóa học không được nhập quá 2 số !");
				} else {
					lop.setIDlop(txtIDlop.getText());
					lop.setTenlop(txtLop.getText());
					lop.setIDkhoa(comboBox_IDkhoa.getSelectedItem().toString());
					lop.setKhoahoc(txtKhoahoc.getText());
					LopDAO lopDAO = new LopDAO();
					lopDAO.addLop̣̣̣(lop);
				}
				showTableLop();
			}
		});
		btnThm_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThm_3.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm_3.setBounds(10, 21, 115, 30);
		panel_20.add(btnThm_3);

		JButton btnSa_3 = new JButton("Sửa"); // Sua lop
		btnSa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lop lop = new Lop();
				if (txtIDlop.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID lớp không được để trống !");
				} else if (txtLop.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên lớp không được để trống !");
				} else if (txtKhoahoc.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Khóa học không được để trống !");
				} else if (txtKhoahoc.getText().matches("(.*)[a-zA-Z](.*)")) {
					JOptionPane.showMessageDialog(null, "Khóa học không được nhập kí tự chữ !");
				} else if (Integer.parseInt(txtKhoahoc.getText()) > 99) {
					JOptionPane.showMessageDialog(null, "Khóa học không được nhập quá 2 số !");
				} else {
					lop.setIDlop(txtIDlop.getText());
					lop.setTenlop(txtLop.getText());
					lop.setIDkhoa(comboBox_IDkhoa.getSelectedItem().toString());
					lop.setKhoahoc(txtKhoahoc.getText());
					LopDAO lopDAO = new LopDAO();
					lopDAO.editLop(lop);
				}
				showTableLop();
			}
		});
		btnSa_3.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa_3.setBounds(135, 21, 115, 30);
		panel_20.add(btnSa_3);

		JButton btnXa_3 = new JButton("Xóa"); // Xoa lop
		btnXa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LopDAO lopDAO = new LopDAO();
				lopDAO.deleteLop(table_3);
				showTableLop();
			}
		});
		btnXa_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa_3.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa_3.setBounds(10, 74, 115, 30);
		panel_20.add(btnXa_3);

		JButton btnReset_3 = new JButton("Reset");
		btnReset_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDlop.setText(null);
				txtLop.setText(null);
				comboBox_IDkhoa.setSelectedItem(null);
				txtKhoahoc.setText(null);
			}
		});
		btnReset_3.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_3.setBounds(135, 75, 115, 29);
		panel_20.add(btnReset_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(294, 426, 630, 51);
		internalFrame_3.getContentPane().add(panel_2);

		JLabel lblSort_3 = new JLabel("Xắp xếp");
		lblSort_3.setBounds(59, 11, 66, 29);
		lblSort_3.setFont(new Font("Tahoma", Font.BOLD, 13));

		JComboBox comboBox_Sortlop = new JComboBox();
		comboBox_Sortlop.setModel(new DefaultComboBoxModel(new String[] { "idlop", "lop", "idkhoa", "khoahoc" }));
		comboBox_Sortlop.setBounds(143, 16, 112, 20);

		JButton btnAz_2 = new JButton("A-Z");
		btnAz_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableLopSort(table_3, comboBox_Sortlop.getSelectedItem().toString(), "ASC");
			}
		});
		btnAz_2.setBounds(307, 15, 97, 25);
		btnAz_2.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));

		JButton btnZa_3 = new JButton("Z-A");
		btnZa_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableLopSort(table_3, comboBox_Sortlop.getSelectedItem().toString(), "DESC");
			}
		});
		btnZa_3.setBounds(444, 15, 91, 25);
		btnZa_3.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		panel_2.setLayout(null);
		panel_2.add(lblSort_3);
		panel_2.add(comboBox_Sortlop);
		panel_2.add(btnAz_2);
		panel_2.add(btnZa_3);

		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 0, 935, 21);
		internalFrame_3.getContentPane().add(menuBar_3);

		JMenu mnFile_3 = new JMenu("File");
		mnFile_3.setIcon(
				new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar_3.add(mnFile_3);

		JMenu mnExport_3 = new JMenu("Export");
		mnExport_3.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile_3.add(mnExport_3);

		JMenuItem mntmExcelxls_2 = new JMenuItem("Excel ");
		mntmExcelxls_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcelxls_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_3);
			}
		});
		mntmExcelxls_2.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnExport_3.add(mntmExcelxls_2);

		JMenuItem mntmPrint_3 = new JMenuItem("Print");
		mntmPrint_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_3, "Danh Sách Lớp");
			}
		});
		mntmPrint_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint_3.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile_3.add(mntmPrint_3);

		JMenuItem mntmExit_3 = new JMenuItem("Exit");
		mnFile_3.add(mntmExit_3);

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(204, 204, 255));
		panel_30.setBounds(10, 426, 271, 51);
		internalFrame_3.getContentPane().add(panel_30);
		panel_30.setLayout(null);

		JButton btnSelectAll_5 = new JButton("Select All");
		btnSelectAll_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableLopSelect(table_3);
			}
		});
		btnSelectAll_5.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll_5.setBounds(10, 17, 112, 23);
		panel_30.add(btnSelectAll_5);

		JButton btnUnselect_5 = new JButton("Unselect");
		btnUnselect_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableLop();
			}
		});
		btnUnselect_5.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect_5.setBounds(136, 17, 112, 23);
		panel_30.add(btnUnselect_5);
		internalFrame_3.setClosable(true);
		internalFrame_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame_3.setBounds(0, 0, 938, 517); // 0, 0, 938, 517 LTABLE
		panel_5.add(internalFrame_3);

		JInternalFrame internalFrame_4 = new JInternalFrame("Quản Lý Khoa");
		internalFrame_4.getContentPane().setBackground(SystemColor.menu);
		internalFrame_4.setClosable(true);
		internalFrame_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame_4.setBounds(0, 0, 938, 517); // 0, 0, 938, 517 KTABLE
		panel_5.add(internalFrame_4);
		internalFrame_4.getContentPane().setLayout(null);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(SystemColor.activeCaption);
		panel_23.setBounds(0, 29, 935, 35);
		internalFrame_4.getContentPane().add(panel_23);

		JLabel lblQunLKhoa = new JLabel("Nhập Khoa");
		lblQunLKhoa.setForeground(new Color(0, 0, 0));
		lblQunLKhoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_23.add(lblQunLKhoa);

		JPanel panel_21 = new JPanel();
		panel_21.setBounds(552, 75, 372, 126);
		internalFrame_4.getContentPane().add(panel_21);
		panel_21.setBackground(new Color(204, 204, 255));
		panel_21.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_21.setLayout(null);

		JLabel lblMKhoa_1 = new JLabel("Mã Khoa:");
		lblMKhoa_1.setForeground(new Color(0, 0, 128));
		lblMKhoa_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhoa_1.setBounds(38, 29, 95, 14);
		panel_21.add(lblMKhoa_1);

		txtIDkhoa = new JTextField();
		txtIDkhoa.setBackground(SystemColor.textHighlightText);
		txtIDkhoa.setBounds(143, 27, 190, 20);
		panel_21.add(txtIDkhoa);
		txtIDkhoa.setColumns(10);

		JLabel lblTnKhoa = new JLabel("Tên Khoa:");
		lblTnKhoa.setForeground(new Color(0, 0, 128));
		lblTnKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnKhoa.setBounds(38, 88, 99, 14);
		panel_21.add(lblTnKhoa);

		txtKhoa = new JTextField();
		txtKhoa.setBackground(SystemColor.textHighlightText);
		txtKhoa.setBounds(143, 85, 190, 20);
		panel_21.add(txtKhoa);
		txtKhoa.setColumns(10);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 75, 532, 402);
		internalFrame_4.getContentPane().add(scrollPane_4);

		table_4 = new JTable();
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_4.getSelectedRow();
				txtIDkhoa.setText(table_4.getValueAt(row, 1).toString());
				txtKhoa.setText(table_4.getValueAt(row, 2).toString());
			}
		});
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_4.setViewportView(table_4);

		JMenuBar menuBar_4 = new JMenuBar();
		menuBar_4.setBounds(0, 0, 935, 21);
		internalFrame_4.getContentPane().add(menuBar_4);

		JMenu mnFile_4 = new JMenu("File");
		mnFile_4.setIcon(
				new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar_4.add(mnFile_4);

		JMenu mnEport = new JMenu("Export");
		mnEport.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile_4.add(mnEport);

		JMenuItem mntmExcelxls_3 = new JMenuItem("Excel ");
		mntmExcelxls_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcelxls_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_4);
			}
		});
		mntmExcelxls_3.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnEport.add(mntmExcelxls_3);

		JMenuItem mntmPrint_4 = new JMenuItem("Print");
		mntmPrint_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_4, "Danh Sách Khoa");
			}
		});
		mntmPrint_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint_4.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile_4.add(mntmPrint_4);

		JMenuItem mntmExit_4 = new JMenuItem("Exit");
		mnFile_4.add(mntmExit_4);

		JPanel panel_22 = new JPanel();
		panel_22.setBounds(552, 411, 372, 66);
		internalFrame_4.getContentPane().add(panel_22);
		panel_22.setBackground(new Color(204, 204, 255));
		panel_22.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_22.setLayout(null);

		JComboBox comboBox_Sortkhoa = new JComboBox();
		comboBox_Sortkhoa.setModel(new DefaultComboBoxModel(new String[] { "idkhoa", "khoa" }));
		comboBox_Sortkhoa.setBounds(28, 20, 105, 20);
		panel_22.add(comboBox_Sortkhoa);

		JButton btnAz_3 = new JButton("A-Z");
		btnAz_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableKhoaSort(table_4, comboBox_Sortkhoa.getSelectedItem().toString(), "ASC");
			}
		});
		btnAz_3.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnAz_3.setBounds(154, 20, 89, 23);
		panel_22.add(btnAz_3);

		JButton btnZa_4 = new JButton("Z-A");
		btnZa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableKhoaSort(table_4, comboBox_Sortkhoa.getSelectedItem().toString(), "DESC");
			}
		});
		btnZa_4.setBounds(253, 20, 97, 23);
		panel_22.add(btnZa_4);
		btnZa_4.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));

		JPanel panel_16 = new JPanel();
		panel_16.setBounds(552, 212, 372, 126);
		internalFrame_4.getContentPane().add(panel_16);
		panel_16.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_16.setBackground(new Color(204, 204, 255));
		panel_16.setLayout(null);

		JButton btnSa_4 = new JButton("Sửa"); // Sua khoa
		btnSa_4.setBounds(217, 35, 97, 25);
		panel_16.add(btnSa_4);
		btnSa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khoa khoa = new Khoa();
				if (txtIDkhoa.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID khoa không được để trống !");
				} else if (txtKhoa.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên khoa không được để trống !");
				} else if (txtKhoa.getText().matches("(.*)[0-9](.*)")) {
					JOptionPane.showMessageDialog(null, "Tên khoa hông được nhập số !");
					khoa.setIDkhoa(txtIDkhoa.getText());
					khoa.setTenkhoa(txtKhoa.getText());
					KhoaDAO khoaDAO = new KhoaDAO();
					khoaDAO.editKhoa(khoa);
				}
				showTableKhoa();
			}
		});
		btnSa_4.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa_4.setForeground(new Color(0, 0, 0));
		btnSa_4.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnXa_4 = new JButton("Xóa"); // Xoa khoa
		btnXa_4.setBounds(66, 71, 97, 25);
		panel_16.add(btnXa_4);
		btnXa_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhoaDAO khoaDAO = new KhoaDAO();
				khoaDAO.deleteKhoa(table_4);
				showTableKhoa();
			}
		});
		btnXa_4.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa_4.setForeground(new Color(0, 0, 0));

		JButton btnReset_4 = new JButton("Reset");
		btnReset_4.setBounds(215, 71, 99, 25);
		panel_16.add(btnReset_4);
		btnReset_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDkhoa.setText(null);
				txtKhoa.setText(null);
			}
		});
		btnReset_4.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset_4.setForeground(new Color(0, 0, 0));
		btnReset_4.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnThm_4 = new JButton("Thêm"); // Them khoa
		btnThm_4.setBounds(66, 35, 97, 25);
		panel_16.add(btnThm_4);
		btnThm_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khoa khoa = new Khoa();
				if (txtIDkhoa.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ID khoa không được để trống !");
				} else if (txtKhoa.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Tên khoa không được để trống !");
				} else if (txtKhoa.getText().matches("(.*)[0-9](.*)")) {
					JOptionPane.showMessageDialog(null, "Tên khoa hông được nhập số !");
				} else {
					khoa.setIDkhoa(txtIDkhoa.getText());
					khoa.setTenkhoa(txtKhoa.getText());
					KhoaDAO khoaDAO = new KhoaDAO();
					khoaDAO.addKhoa(khoa);
				}
				showTableKhoa();
			}
		});
		btnThm_4.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm_4.setForeground(new Color(0, 0, 0));
		btnThm_4.setFont(new Font("Tahoma", Font.BOLD, 13));

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(204, 204, 255));
		panel_28.setBounds(552, 349, 372, 53);
		internalFrame_4.getContentPane().add(panel_28);
		panel_28.setLayout(null);

		JButton btnSelectAll_3 = new JButton("Select All");
		btnSelectAll_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableKhoaSelect(table_4);
			}
		});
		btnSelectAll_3.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll_3.setBounds(60, 11, 107, 23);
		panel_28.add(btnSelectAll_3);

		JButton btnUnselect_3 = new JButton("Unselect");
		btnUnselect_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableKhoa();
			}
		});
		btnUnselect_3.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect_3.setBounds(211, 11, 107, 23);
		panel_28.add(btnUnselect_3);

		JInternalFrame internalFrame_5 = new JInternalFrame("Qu\u1EA3n L\u00FD M\u00F4n");
		internalFrame_5.getContentPane().setBackground(SystemColor.menu);
		internalFrame_5.getContentPane().setLayout(null);

		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(204, 204, 255));
		panel_25.setBorder(new LineBorder(new Color(230, 230, 250), 2, true));
		panel_25.setBounds(10, 76, 334, 199);
		internalFrame_5.getContentPane().add(panel_25);
		panel_25.setLayout(null);

		JLabel lblTnMnHc = new JLabel("Tên Môn Học:");
		lblTnMnHc.setBounds(24, 66, 100, 14);
		panel_25.add(lblTnMnHc);
		lblTnMnHc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnMnHc.setForeground(new Color(0, 0, 128));

		txtMon = new JTextField();
		txtMon.setBounds(145, 64, 159, 20);
		panel_25.add(txtMon);
		txtMon.setColumns(10);

		JLabel lblMKhoa_2 = new JLabel("Mã Khoa:");
		lblMKhoa_2.setBounds(24, 149, 100, 14);
		panel_25.add(lblMKhoa_2);
		lblMKhoa_2.setForeground(new Color(0, 0, 128));
		lblMKhoa_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		comboBox_IDkhoamon = new JComboBox();
		comboBox_IDkhoamon.setMaximumRowCount(4);
		comboBox_IDkhoamon.setBounds(141, 146, 143, 20);
		panel_25.add(comboBox_IDkhoamon);

		JComboBox comboBox_Tinchi = new JComboBox();
		comboBox_Tinchi.setMaximumRowCount(4);
		comboBox_Tinchi.setBounds(141, 105, 65, 20);
		panel_25.add(comboBox_Tinchi);
		comboBox_Tinchi
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

		JLabel lblSTnCh = new JLabel("Số Tín Chỉ:");
		lblSTnCh.setBounds(24, 107, 100, 14);
		panel_25.add(lblSTnCh);
		lblSTnCh.setForeground(new Color(0, 0, 128));
		lblSTnCh.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtIDmon = new JTextField();
		txtIDmon.setBounds(144, 26, 160, 20);
		panel_25.add(txtIDmon);
		txtIDmon.setColumns(10);

		JLabel lblMMnHc_1 = new JLabel("Mã Môn Học:");
		lblMMnHc_1.setBounds(24, 29, 110, 17);
		panel_25.add(lblMMnHc_1);
		lblMMnHc_1.setForeground(new Color(0, 0, 128));
		lblMMnHc_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new LineBorder(new Color(230, 230, 250), 2, true));
		panel_26.setBackground(new Color(204, 204, 255));
		panel_26.setBounds(9, 283, 334, 115);
		internalFrame_5.getContentPane().add(panel_26);
		panel_26.setLayout(null);

		JButton btnThm_5 = new JButton("Thêm"); // Them mon
		btnThm_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mon mon = new Mon();
				if(txtIDmon.getText().length()==0){
					JOptionPane.showMessageDialog(null, "ID môn không được để trống !");
				}else if(txtMon.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Tên môn không được để trống !");
				}else{
				mon.setIDmon(txtIDmon.getText());
				mon.setTenmon(txtMon.getText());
				mon.setTinchi(comboBox_Tinchi.getSelectedItem().toString());
				mon.setIDkhoa(comboBox_IDkhoamon.getSelectedItem().toString());
				MonDAO monDAO = new MonDAO();
				monDAO.addMoṇ(mon);
				}
				showTableMon();
			}
		});
		btnThm_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThm_5.setIcon(new ImageIcon("./icon/add-icon.png"));
		btnThm_5.setBounds(36, 25, 105, 23);
		panel_26.add(btnThm_5);

		JButton btnSa_5 = new JButton("Sửa"); // Sua mon
		btnSa_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mon mon = new Mon();
				if(txtIDmon.getText().length()==0){
					JOptionPane.showMessageDialog(null, "ID môn không được để trống !");
				}else if(txtMon.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Tên môn không được để trống !");
				}else{
				mon.setIDmon(txtIDmon.getText());
				mon.setTenmon(txtMon.getText());
				mon.setTinchi(comboBox_Tinchi.getSelectedItem().toString());
				mon.setIDkhoa(comboBox_IDkhoamon.getSelectedItem().toString());
				MonDAO monDAO = new MonDAO();
				monDAO.editMon(mon);
				}
				showTableMon();
			}
		});
		btnSa_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSa_5.setIcon(new ImageIcon("./icon/update-icon.png"));
		btnSa_5.setBounds(181, 25, 105, 23);
		panel_26.add(btnSa_5);

		JButton btnXa_5 = new JButton("Xóa"); // Xoa mon
		btnXa_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonDAO monDAO = new MonDAO();
				monDAO.deleteMon(table_5);
				showTableMon();
			}
		});
		btnXa_5.setIcon(new ImageIcon("./icon/delete-icon.png"));
		btnXa_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXa_5.setBounds(36, 69, 105, 23);
		panel_26.add(btnXa_5);

		JButton btnReset_5 = new JButton("Reset");
		btnReset_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDmon.setText(null);
				txtMon.setText(null);
				comboBox_Tinchi.setSelectedItem(null);
				comboBox_IDkhoamon.setSelectedItem(null);
			}
		});
		btnReset_5.setIcon(new ImageIcon("./icon/Actions-edit-redo-icon.png"));
		btnReset_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_5.setBounds(181, 69, 105, 23);
		panel_26.add(btnReset_5);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(354, 75, 570, 337);
		internalFrame_5.getContentPane().add(scrollPane_5);

		table_5 = new JTable();
		table_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_5.getSelectedRow();
				txtIDmon.setText(table_5.getValueAt(row, 1).toString());
				txtMon.setText(table_5.getValueAt(row, 2).toString());
				comboBox_Tinchi.setSelectedItem(table_5.getValueAt(row, 3));
				comboBox_IDkhoamon.setSelectedItem(table_5.getValueAt(row, 4));
			}
		});
		scrollPane_5.setViewportView(table_5);

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(SystemColor.activeCaption);
		panel_27.setBounds(0, 29, 935, 35);
		internalFrame_5.getContentPane().add(panel_27);

		JLabel lblQunLMn = new JLabel("Nhập Môn Học");
		lblQunLMn.setForeground(new Color(0, 0, 0));
		lblQunLMn.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_27.add(lblQunLMn);

		JMenuBar menuBar_5 = new JMenuBar();
		menuBar_5.setBounds(0, 0, 935, 21);
		internalFrame_5.getContentPane().add(menuBar_5);

		JMenu mnFile_5 = new JMenu("File");
		mnFile_5.setIcon(
				new ImageIcon("./icon/folder-documents-icon (1).png"));
		menuBar_5.add(mnFile_5);

		JMenu mnExport_4 = new JMenu("Export");
		mnExport_4.setIcon(new ImageIcon("./icon/Save-icon.png"));
		mnFile_5.add(mnExport_4);

		JMenuItem mntmExcelxls_4 = new JMenuItem("Excel ");
		mntmExcelxls_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mntmExcelxls_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Export export = new Export();
				export.exportExcel(table_5);
			}
		});
		mntmExcelxls_4.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));
		mnExport_4.add(mntmExcelxls_4);

		JMenuItem mntmPrint_5 = new JMenuItem("Print");
		mntmPrint_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_5, "Danh Sách Môn");
			}
		});
		mntmPrint_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrint_5.setIcon(new ImageIcon("./icon/Print-icon.png"));
		mnFile_5.add(mntmPrint_5);

		JMenuItem mntmExit_5 = new JMenuItem("Exit");
		mnFile_5.add(mntmExit_5);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(204, 204, 255));
		panel_24.setBounds(11, 409, 331, 68);
		internalFrame_5.getContentPane().add(panel_24);
		panel_24.setLayout(null);

		JButton btnSelectAll_4 = new JButton("Select All"); // select mon
		btnSelectAll_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableMonSelect(table_5);
			}
		});
		btnSelectAll_4.setIcon(new ImageIcon("./icon/Select-icon.png"));
		btnSelectAll_4.setBounds(36, 22, 102, 23);
		panel_24.add(btnSelectAll_4);

		JButton btnUnselect_4 = new JButton("Unselect");
		btnUnselect_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableMon();
			}
		});
		btnUnselect_4.setIcon(new ImageIcon("./icon/close-icon.png"));
		btnUnselect_4.setBounds(179, 22, 107, 23);
		panel_24.add(btnUnselect_4);

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(204, 204, 255));
		panel_29.setBounds(354, 424, 570, 53);
		internalFrame_5.getContentPane().add(panel_29);
		panel_29.setLayout(null);

		JComboBox comboBox_SortMon = new JComboBox();
		comboBox_SortMon.setModel(new DefaultComboBoxModel(new String[] { "idmon", "mon", "tinchi", "idkhoa" }));
		comboBox_SortMon.setBounds(134, 18, 136, 20);
		panel_29.add(comboBox_SortMon);

		JLabel lblSpXp = new JLabel("Sắp Xếp");
		lblSpXp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSpXp.setBounds(53, 22, 71, 14);
		panel_29.add(lblSpXp);

		JButton btnAz_4 = new JButton("A-Z"); // Sort mon
		btnAz_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableMonSort(table_5, comboBox_SortMon.getSelectedItem().toString(), "ASC");
			}
		});
		btnAz_4.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnAz_4.setBounds(303, 17, 89, 23);
		panel_29.add(btnAz_4);

		JButton btnZa_5 = new JButton("Z-A"); // Sort mon
		btnZa_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanlyDAO quanlyDAO = new QuanlyDAO();
				quanlyDAO.showTableMonSort(table_5, comboBox_SortMon.getSelectedItem().toString(), "DESC");
			}
		});
		btnZa_5.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		btnZa_5.setBounds(426, 17, 89, 23);
		panel_29.add(btnZa_5);
		internalFrame_5.setClosable(true);
		internalFrame_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		internalFrame_5.setBounds(0, 0, 938, 517); // 938, 517 MTABLE
		panel_5.add(internalFrame_5);

		// Button Quản lý
		btnqlsinhvien = new JButton("Qu\u1EA3n L\u00FD Sinh Vi\u00EAn");
		btnqlsinhvien.setIcon(new ImageIcon("./icon/Buddypress-icon (1).png"));
		btnqlsinhvien.setBackground(UIManager.getColor("Button.darkShadow"));
		btnqlsinhvien.setForeground(Color.BLACK);
		btnqlsinhvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrame.setVisible(true);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
				showTableSinhVien();
			}
		});
		btnqlsinhvien.setBounds(10, 44, 196, 43);
		panel_4.add(btnqlsinhvien);

		btnqlgiaovien = new JButton("Quản Lý Giáo Viên");
		btnqlgiaovien.setIcon(new ImageIcon("./icon/Carbonmade-icon (1).png"));
		btnqlgiaovien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(true);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
			}
		});
		btnqlgiaovien.setBounds(10, 115, 196, 43);
		panel_4.add(btnqlgiaovien);

		btnqldiem = new JButton("Quản Lý Điểm       ");
		btnqldiem.setIcon(new ImageIcon("./icon/Arto-icon.png"));
		btnqldiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(true);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
				showTableDiem();
			}
		});
		btnqldiem.setBounds(10, 183, 196, 43);
		panel_4.add(btnqldiem);

		btnqllop = new JButton("Quản Lý Lớp         ");
		btnqllop.setIcon(new ImageIcon("./icon/Aim-icon.png"));
		btnqllop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(true);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(false);
				comboBox_IDlop.removeAllItems();
				showTableLop();
			}
		});
		btnqllop.setBounds(10, 330, 196, 43);
		panel_4.add(btnqllop);

		btnqlkhoa = new JButton("Quản Lý Khoa       ");
		btnqlkhoa.setIcon(new ImageIcon("./icon/Dribbble-icon.png"));
		btnqlkhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(true);
				internalFrame_5.setVisible(false);
				showTableKhoa();
			}
		});
		btnqlkhoa.setBounds(10, 255, 196, 43);
		panel_4.add(btnqlkhoa);

		btnqlmon = new JButton("Quản Lý Môn         ");
		btnqlmon.setIcon(new ImageIcon("./icon/Delicious-icon.png"));
		btnqlmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame_1.setVisible(false);
				internalFrame_2.setVisible(false);
				internalFrame_3.setVisible(false);
				internalFrame_4.setVisible(false);
				internalFrame_5.setVisible(true);
				showTableMon();
			}
		});
		btnqlmon.setBounds(10, 411, 196, 43);
		panel_4.add(btnqlmon);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./icon/banner.gif"));
		label.setBounds(236, 11, 938, 106);
		quan_ly.add(label);

		JPanel xem_diem = new JPanel();
		tabbedPane.addTab("Xem Điểm",
				new ImageIcon("./icon/Apps-Aegisub-icon (6).png"), xem_diem,
				null);
		xem_diem.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 0, 1184, 122);
		xem_diem.add(panel_1);
		panel_1.setLayout(null);

		comboBox_Theolop = new JComboBox();
		comboBox_Theolop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_Theolop.setBounds(528, 88, 135, 20);
		panel_1.add(comboBox_Theolop);

		JCheckBox chckbxTheolop = new JCheckBox("Theo lớp");
		buttonGroup_7.add(chckbxTheolop);
		chckbxTheolop.setBackground(new Color(204, 204, 255));
		chckbxTheolop.setBounds(433, 87, 89, 23);
		panel_1.add(chckbxTheolop);
		chckbxTheolop.setFont(new Font("Tahoma", Font.BOLD, 13));

		JCheckBox chckbxTheoMon = new JCheckBox("Theo môn");
		buttonGroup_7.add(chckbxTheoMon);
		chckbxTheoMon.setBackground(new Color(204, 204, 255));
		chckbxTheoMon.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTheoMon.setBounds(182, 87, 97, 23);
		panel_1.add(chckbxTheoMon);

		comboBox_Theomon = new JComboBox();
		comboBox_Theomon.setBounds(285, 89, 128, 20);
		panel_1.add(comboBox_Theomon);

		JCheckBox chckbxTheoKhoa = new JCheckBox("Theo khoa");
		buttonGroup_7.add(chckbxTheoKhoa);
		chckbxTheoKhoa.setBackground(new Color(204, 204, 255));
		chckbxTheoKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTheoKhoa.setBounds(684, 87, 97, 23);
		panel_1.add(chckbxTheoKhoa);

		comboBox_Theokhoa = new JComboBox();
		comboBox_Theokhoa.setBounds(792, 89, 135, 20);
		panel_1.add(comboBox_Theokhoa);

		JToggleButton diemCuaToi = new JToggleButton("Xem điểm của tôi");
		diemCuaToi.setBounds(22, 88, 140, 23);
		panel_1.add(diemCuaToi);

		JCheckBox chckbxTatCa = new JCheckBox("Tất cả");
		buttonGroup_7.add(chckbxTatCa);
		chckbxTatCa.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTatCa.setBackground(new Color(204, 204, 255));
		chckbxTatCa.setBounds(946, 87, 83, 23);
		panel_1.add(chckbxTatCa);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 133, 1164, 471);
		xem_diem.add(scrollPane_6);

		table_Bangdiem = new JTable();
		table_Bangdiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_6.setViewportView(table_Bangdiem);

		Panel panel_31 = new Panel();
		panel_31.setBackground(new Color(204, 204, 255));
		panel_31.setBounds(0, 610, 1184, 41);
		xem_diem.add(panel_31);
		panel_31.setLayout(null);

		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Export export = new Export();
				export.exportExcel(table_Bangdiem);
			}
		});
		btnExport.setBounds(944, 11, 102, 25);
		panel_31.add(btnExport);
		btnExport.setIcon(
				new ImageIcon("./icon/MS-Office-2003-Excel-icon.png"));

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon("./icon/Print-icon.png"));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print print = new Print();
				print.Print(table_Bangdiem, "Bảng Điểm"); // In bang diem
			}
		});
		btnPrint.setBounds(1065, 12, 89, 23);
		panel_31.add(btnPrint);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop";
				BangdiemDAO bangdiemDAO = new BangdiemDAO();
				bangdiemDAO.showTableBangDiemSearch(table_Bangdiem, sql, textField.getText());
			}
		});
		textField.setBounds(612, 10, 290, 24);
		panel_31.add(textField);
		textField.setColumns(10);

		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKim.setBounds(528, 16, 74, 14);
		panel_31.add(lblTmKim);

		JComboBox comboBox_XemDiemSort = new JComboBox();
		comboBox_XemDiemSort.setMaximumRowCount(6);
		comboBox_XemDiemSort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_XemDiemSort.setModel(new DefaultComboBoxModel(new String[] { "Mã sinh viên", "Họ tên sinh viên",
				"Điểm 15 phút", "Điểm 45 phút", "Điểm thi", "Tổng kết", "Kết quả", "Môn" ,"Lớp","Khoa", "Mã giáo viên"}));
		comboBox_XemDiemSort.setBounds(63, 13, 131, 20);
		panel_31.add(comboBox_XemDiemSort);

		JButton btnAz_5 = new JButton("A-Z");
		btnAz_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sort;
				if (comboBox_XemDiemSort.getSelectedItem().toString() == "Mã sinh viên") {
					sort = "diem.idsv";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Họ tên sinh viên") {
					sort = "sinhvien.hoten";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Điểm 15 phút") {
					sort = "diem.diem15";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Điểm 45 phút") {
					sort = "diem.diem45";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Điểm thi") {
					sort = "diem.diemthi";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Tổng kết") {
					sort = "diem.tongket";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Kết quả") {
					sort = "diem.ketqua";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Môn") {
					sort = "diem.mon";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Lớp") {
					sort = "lop.lop";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Khoa") {
					sort = "khoa.khoa";
				} else {
					sort = "diem.idgv";
				}
				BangdiemDAO bangdiemDAO = new BangdiemDAO();
				bangdiemDAO.showTableXemDiemSort(table_Bangdiem, sort, "ASC");
			}
		});
		btnAz_5.setIcon(new ImageIcon("./icon/sort-ascending-icon.png"));
		btnAz_5.setBounds(252, 11, 89, 23);
		panel_31.add(btnAz_5);

		JButton btnZa_6 = new JButton("Z-A");
		btnZa_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sort;
				if (comboBox_XemDiemSort.getSelectedItem().toString() == "Ma Sinh Vien") {
					sort = "diem.idsv";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Ho Ten Sinh Vien") {
					sort = "sinhvien.hoten";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Ngay Sinh") {
					sort = "sinhvien.ngaysinh";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Diem") {
					sort = "diem.diem";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Ket Qua") {
					sort = "diem.ketqua";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Mon") {
					sort = "mon.mon";
				} else if (comboBox_XemDiemSort.getSelectedItem().toString() == "Lop") {
					sort = "lop.lop";
				} else {
					sort = "khoa.khoa";
				}
				BangdiemDAO bangdiemDAO = new BangdiemDAO();
				bangdiemDAO.showTableXemDiemSort(table_Bangdiem, sort, "DESC");
			}
		});
		btnZa_6.setIcon(new ImageIcon("./icon/sort-descending-icon.png"));
		btnZa_6.setBounds(377, 11, 89, 23);
		panel_31.add(btnZa_6);

		JPanel tim_kiem = new JPanel();
		tabbedPane.addTab("Tìm Kiếm",
				new ImageIcon("./icon/Search-icon (2).png"), tim_kiem, null);
		tim_kiem.setLayout(null);

		panel_32 = new JPanel();
		panel_32.setBackground(new Color(204, 204, 255));
		panel_32.setBounds(0, 0, 1184, 122);
		tim_kiem.add(panel_32);
		panel_32.setLayout(null);

		timeSystemTK = new JLabel("");
		timeSystemTK.setForeground(new Color(128, 0, 0));
		timeSystemTK.setFont(new Font("Tahoma", Font.BOLD, 20));
		timeSystemTK.setBounds(1011, 11, 150, 33);
		panel_32.add(timeSystemTK);

		calendarTK = new JLabel();
		calendarTK.setForeground(new Color(128, 0, 0));
		calendarTK.setFont(new Font("Tahoma", Font.BOLD, 13));
		calendarTK.setBounds(940, 35, 650, 33);
		panel_32.add(calendarTK);

		JLabel lblTmKim_1 = new JLabel("Tìm Kiếm");
		lblTmKim_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTmKim_1.setBounds(512, 11, 137, 35);
		panel_32.add(lblTmKim_1);

		JComboBox comboBox_SearchTK = new JComboBox();
		comboBox_SearchTK
				.setModel(new DefaultComboBoxModel(new String[] { "Sinh viên", "Giáo viên", "Khoa", "Lớp", "Môn" }));
		comboBox_SearchTK.setBounds(247, 63, 137, 25);
		panel_32.add(comboBox_SearchTK);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (comboBox_SearchTK.getSelectedItem().toString() == "Sinh viên") {
					TimkiemDAO timkiemDAO = new TimkiemDAO();
					timkiemDAO.showTableSinhVienTimKiem(table_Searchsinhvien, txtSearch.getText().trim());
				} else if (comboBox_SearchTK.getSelectedItem().toString() == "Giáo viên") {
					TimkiemDAO timkiemDAO = new TimkiemDAO();
					timkiemDAO.showTableGiaoVienTimKiem(table_Searchgiaovien, txtSearch.getText().trim());
				} else if (comboBox_SearchTK.getSelectedItem().toString() == "Khoa") {
					TimkiemDAO timkiemDAO = new TimkiemDAO();
					timkiemDAO.showTableKhoaTimKiem(table_Searchkhoa, txtSearch.getText().trim());
				} else if (comboBox_SearchTK.getSelectedItem().toString() == "Lớp") {
					TimkiemDAO timkiemDAO = new TimkiemDAO();
					timkiemDAO.showTableLopTimKiem(table_Searchlop, txtSearch.getText().trim());
				} else if (comboBox_SearchTK.getSelectedItem().toString() == "Môn") {
					TimkiemDAO timkiemDAO = new TimkiemDAO();
					timkiemDAO.showTableMonTimKiem(table_Searchmon, txtSearch.getText().trim());
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại cách tìm kiếm khác");
				}
			}
		});
		txtSearch.setBounds(411, 60, 340, 30);
		panel_32.add(txtSearch);
		txtSearch.setColumns(10);

		JPanel panel_33 = new JPanel();
		panel_33.setBackground(new Color(204, 204, 255));
		panel_33.setBounds(0, 609, 1184, 40);
		tim_kiem.add(panel_33);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 133, 1164, 465);
		tim_kiem.add(tabbedPane_1);

		JPanel panel_34 = new JPanel();
		tabbedPane_1.addTab("Sinh Viên",
				new ImageIcon("./icon/Buddypress-icon (1).png"), panel_34,
				null);
		panel_34.setLayout(null);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(0, 0, 1159, 437);
		panel_34.add(scrollPane_7);

		table_Searchsinhvien = new JTable();
		scrollPane_7.setViewportView(table_Searchsinhvien);

		JPanel panel_35 = new JPanel();
		tabbedPane_1.addTab("Giáo Viên",
				new ImageIcon("./icon/Carbonmade-icon (1).png"), panel_35,
				null);
		panel_35.setLayout(null);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(0, 0, 1159, 437);
		panel_35.add(scrollPane_8);

		table_Searchgiaovien = new JTable();
		scrollPane_8.setViewportView(table_Searchgiaovien);

		JPanel panel_37 = new JPanel();
		tabbedPane_1.addTab("Khoa", new ImageIcon("./icon/Aim-icon.png"),
				panel_37, null);
		panel_37.setLayout(null);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(0, 0, 1159, 437);
		panel_37.add(scrollPane_10);

		table_Searchkhoa = new JTable();
		scrollPane_10.setViewportView(table_Searchkhoa);

		JPanel panel_38 = new JPanel();
		tabbedPane_1.addTab("Lớp", new ImageIcon("./icon/Dribbble-icon.png"),
				panel_38, null);
		panel_38.setLayout(null);

		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(0, 0, 1159, 437);
		panel_38.add(scrollPane_11);

		table_Searchlop = new JTable();
		scrollPane_11.setViewportView(table_Searchlop);

		JPanel panel_39 = new JPanel();
		tabbedPane_1.addTab("Môn", new ImageIcon("./icon/Delicious-icon.png"),
				panel_39, null);
		panel_39.setLayout(null);

		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(0, 0, 1159, 437);
		panel_39.add(scrollPane_12);

		table_Searchmon = new JTable();
		scrollPane_12.setViewportView(table_Searchmon);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("./icon/Search-icon (7).png"));
		label_6.setBounds(774, 56, 43, 35);
		panel_32.add(label_6);

		JButton btnXem = new JButton("Xem");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BangdiemDAO bangdiemDAO = new BangdiemDAO();
				try {
					if (diemCuaToi.isSelected() && chckbxTheoMon.isSelected() == false) {
						String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop WHERE diem.idsv=?";
						bangdiemDAO.showTableBangDiem(table_Bangdiem, sql, id);
					} else if (diemCuaToi.isSelected() && chckbxTheoMon.isSelected()) {
						String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop WHERE diem.idsv=? AND diem.mon=?";
						bangdiemDAO.showTableBangDiem(table_Bangdiem, sql, id,
								comboBox_Theomon.getSelectedItem().toString());
					} else if (chckbxTheoMon.isSelected()) {
						String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop WHERE mon.mon=?";
						bangdiemDAO.showTableBangDiem(table_Bangdiem, sql,
								comboBox_Theomon.getSelectedItem().toString()); // mon
					} else if (chckbxTheolop.isSelected()) {
						String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop WHERE lop.lop=?";
						bangdiemDAO.showTableBangDiem(table_Bangdiem, sql,
								comboBox_Theolop.getSelectedItem().toString()); // lop
					} else if (chckbxTheoKhoa.isSelected()) {
						String sql = "Select * From  project.diem INNER JOIN project.sinhvien ON diem.idsv = sinhvien.idsv INNER JOIN project.mon ON diem.mon = mon.mon INNER JOIN project.khoa ON khoa.idkhoa =mon.idkhoa INNER JOIN project.lop ON sinhvien.idlop = lop.idlop WHERE khoa.khoa=?";
						bangdiemDAO.showTableBangDiem(table_Bangdiem, sql,
								comboBox_Theokhoa.getSelectedItem().toString()); // khoa
					} else {
						showTableBangDiem(); // ta ca
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xem điểm !\n" + e);
				}
			}
		});
		btnXem.setIcon(new ImageIcon("./icon/Apps-Aegisub-icon (7).png"));
		btnXem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXem.setBounds(1035, 87, 105, 23);
		panel_1.add(btnXem);

		JLabel lblNewLabel_1 = new JLabel("Bảng Điểm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1.setBounds(510, 11, 169, 33);
		panel_1.add(lblNewLabel_1);

		timeSystemBD = new JLabel("");
		timeSystemBD.setForeground(new Color(128, 0, 0));
		timeSystemBD.setFont(new Font("Tahoma", Font.BOLD, 20));
		timeSystemBD.setBounds(1011, 11, 150, 33);
		panel_1.add(timeSystemBD);

		calendarBD = new JLabel();
		calendarBD.setForeground(new Color(128, 0, 0));
		calendarBD.setFont(new Font("Tahoma", Font.BOLD, 13));
		calendarBD.setBounds(940, 35, 650, 33);
		panel_1.add(calendarBD);
		// Popup menu tren tabel_Bangdiem
		table_Bangdiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table_Bangdiem.rowAtPoint(e.getPoint());
				if (r >= 0 && r < table_Bangdiem.getRowCount()) {
					table_Bangdiem.setRowSelectionInterval(r, r);
				} else {
					table_Bangdiem.clearSelection();
				}
				// row index is found...
				int rowindex = table_Bangdiem.getSelectedRow();
				if (rowindex < 0)
					return;
				if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
					JPopupMenu popup = createBangDiemPopUp(rowindex, table_Bangdiem);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table_2.rowAtPoint(e.getPoint());
				if (r >= 0 && r < table_2.getRowCount()) {
					table_2.setRowSelectionInterval(r, r);
				} else {
					table_2.clearSelection();
				}
				// row index is found...
				int rowindex = table_2.getSelectedRow();
				if (rowindex < 0)
					return;
				if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
					JPopupMenu popup = createQLDiemPopUp(rowindex, table_2);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});
	}

	// JPopupMenu Bang diem
	public static JPopupMenu createBangDiemPopUp(int rowindex, JTable table_Bangdiem) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem thongtinbosung = new JMenuItem("Thông tin bổ sung");
		JMenuItem chitietketqua = new JMenuItem("Biểu đồ chi tiết kết quả");
		JMenuItem exit = new JMenuItem("Exit");
		thongtinbosung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DetailsDAO detailsDAO = new DetailsDAO();
					Details details = new Details();
					int row = table_Bangdiem.getSelectedRow();
					String idsinhvien = table_Bangdiem.getValueAt(row, 1).toString();
					String idgv = table_Bangdiem.getValueAt(row, 11).toString();
					detailsDAO.chiTiet(details, idsinhvien, idgv);
				} catch (Exception e2) {
				}
			}
		});
		chitietketqua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table_Bangdiem.getSelectedRow();
				DetailsKQForm detailsKQform = new DetailsKQForm(table_Bangdiem.getValueAt(row, 2).toString(),
						table_Bangdiem.getValueAt(row, 1).toString());
				detailsKQform.frmTh.setVisible(true);
			}
		});
		popup.add(thongtinbosung);
		popup.add(chitietketqua);
		popup.add(exit);
		return popup;
	}

	// JPopupMenu Quan ly diem
		public JPopupMenu createQLDiemPopUp(int rowindex, JTable table_2) {
			JPopupMenu popup = new JPopupMenu();
			JMenuItem nhapsai = new JMenuItem("Nhập điểm sai");
			JMenuItem exit = new JMenuItem("Exit");
			nhapsai.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ToiSuaDiemSai nhapsaidiem = new ToiSuaDiemSai();
						int row = table_2.getSelectedRow();
						nhapsaidiem.frmPhnNhpSai.setVisible(true);
						nhapsaidiem.showTableToiSuaDiemSai(id);
					} catch (Exception e2) {
					}
				}
			});
			popup.add(nhapsai);
			popup.add(exit);
			return popup;
		}
	// Tab trinh duyet internet + tab huong dan
	private void initSwingComponents() {
		javafxPanel = new JFXPanel();
		javafxPanel.setBounds(0, 0, 1184, 656);
		panel_36 = new JPanel();
		panel_36.setLayout(null);
		panel_36.add(javafxPanel);
		tabbedPane.addTab("Google",
				new ImageIcon("./icon/Google-Chrome-icon.png"), panel_36);

		JPanel huong_dan = new JPanel();
		tabbedPane.addTab("H\u01B0\u1EDBng D\u1EABn",
				new ImageIcon("./icon/tv-guide-2-icon.png"), huong_dan, null);
		huong_dan.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./icon/2016-06-30_162845.png"));
		lblNewLabel.setBounds(0, 0, 1174, 656);
		huong_dan.add(lblNewLabel);
	}

	private void loadJavaFXScene() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				BorderPane borderPane = new BorderPane();
				WebView webComponent = new WebView();
				webComponent.getEngine().load("http://google.vn");
				borderPane.setCenter(webComponent);
				Scene scene = new Scene(borderPane);
				javafxPanel.setScene(scene);
				webComponent.autosize();
			}
		});
	}
}
