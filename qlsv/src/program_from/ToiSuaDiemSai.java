package program_from;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.Toolkit;
import java.awt.Color;

public class ToiSuaDiemSai {

	public JFrame frmPhnNhpSai;
	private JTable table;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String idmon;
	private JLabel txtLoiKhuyen;
	private JLabel txtThongBao;
	private int i=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToiSuaDiemSai window = new ToiSuaDiemSai();
					window.frmPhnNhpSai.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ToiSuaDiemSai() {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ToiSuaDiemSai(String idgv) {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showTableToiSuaDiemSai(idgv);
	}


	public void showTableToiSuaDiemSai(String idgv) {
		String sqlmon = "SELECT * FROM project.giaovien WHERE idgv=?";
		try {
			stmt = conn.prepareStatement(sqlmon);
			stmt.setString(1, idgv);
			rs = stmt.executeQuery();
			while (rs.next()) {
				idmon = rs.getString("idmon");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID Sinh Vien");
		cols.addElement("ID Mon");
		cols.addElement("Ten Mon");
		cols.addElement("Ten Giao Vien");
		cols.addElement("So Dien Thoai");
		cols.addElement("Email");
		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.diem JOIN project.giaovien ON giaovien.idmon = diem.idmon WHERE diem.idgv=? And diem.idmon <> ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idgv);
			stmt.setString(2, idmon);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vector sinhvien = new Vector();
				sinhvien.addElement(rs.getString("diem.idsv"));
				sinhvien.addElement(rs.getString("diem.idmon"));
				sinhvien.addElement(rs.getString("diem.mon"));
				sinhvien.addElement(rs.getString("giaovien.hoten"));
				sinhvien.addElement(rs.getString("giaovien.sdt"));
				sinhvien.addElement(rs.getString("giaovien.email"));
				
				data.addElement(sinhvien);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
		if(i==0){
			txtThongBao.setText("Chúc mừng bạn không có điểm môn nào nhập sai!");
		}else{
			txtThongBao.setText("Bạn nhập sai điểm: "+i+" môn !");
			txtLoiKhuyen.setText("Vui lòng liên hệ với giáo viên các môn trên để được sửa điểm ngay !");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhnNhpSai = new JFrame();
		frmPhnNhpSai.setIconImage(Toolkit.getDefaultToolkit().getImage("./icon/Chat-icon (1).png"));
		frmPhnNhpSai.setTitle("Phần nhập sai điểm");
		frmPhnNhpSai.setBounds(320, 210, 547, 228);
		frmPhnNhpSai.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 531, 122);
		frmPhnNhpSai.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtThongBao = new JLabel();
		txtThongBao.setForeground(new Color(255, 51, 153));
		txtThongBao.setBounds(100, 11, 401, 19);
		txtThongBao.setFont(new Font("Tahoma", Font.BOLD, 13));
		frmPhnNhpSai.getContentPane().add(txtThongBao);
		
		txtLoiKhuyen = new JLabel();
		txtLoiKhuyen.setForeground(new Color(51, 0, 204));
		txtLoiKhuyen.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtLoiKhuyen.setBounds(56, 165, 465, 18);
		frmPhnNhpSai.getContentPane().add(txtLoiKhuyen);
		
	}
}
