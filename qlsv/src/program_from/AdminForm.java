package program_from;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;
import model.Login;

public class AdminForm {

	public JFrame frmAdministrator;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private JTable table;
	private JTextField txt_user_admin;
	private JTextField txt_pass_admin;
	private JTextField txt_ID_admin;
	private JTable table_1;
	private JTextField txt_ID_giaovien;
	private JTextField txt_user_giaovien;
	private JTextField txt_pass_giaovien;

	private JPanel panel;
	private JTextField txtIDgiaovu;
	private JTextField txtUsergiaovu;
	private JTextField txtPassgiaovu;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm window = new AdminForm();
					window.frmAdministrator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminForm() {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showAdmin();
		showGiaovien();
		showGiaovu();
	}

	public AdminForm(Login a) {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		showAdmin();
		showGiaovien();
		showGiaovu();
		JLabel lblAdmin = new JLabel();
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblAdmin);
		lblAdmin.setText(a.getUser());
	}

	public void showAdmin() {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID Admin");
		cols.addElement("Username");
		cols.addElement("Password");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.admin";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int row = 0;
			while (rs.next()) {
				Vector admin = new Vector();
				admin.addElement(rs.getString("idad"));
				admin.addElement(rs.getString("user"));
				admin.addElement(rs.getString("pass"));

				data.add(admin);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table.setModel(new DefaultTableModel(data, cols));
	}

	public void showGiaovien() {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID Giáo Viên");
		cols.addElement("Username");
		cols.addElement("Password");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.giaovien";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int row = 0;
			while (rs.next()) {
				Vector giaovien = new Vector();
				giaovien.addElement(rs.getString("idgv"));
				giaovien.addElement(rs.getString("hoten"));
				giaovien.addElement(rs.getString("pass"));

				data.add(giaovien);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table_1.setModel(new DefaultTableModel(data, cols));
	}

	public void showGiaovu() {
		// Name Column table
		Vector cols = new Vector();
		cols.addElement("ID Giáo vụ");
		cols.addElement("Username");
		cols.addElement("Password");

		// Data table
		Vector data = new Vector();
		String sql = "SELECT * FROM project.giaovu";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int row = 0;
			while (rs.next()) {
				Vector admin = new Vector();
				admin.addElement(rs.getString("idgvu"));
				admin.addElement(rs.getString("user"));
				admin.addElement(rs.getString("pass"));

				data.add(admin);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		table_2.setModel(new DefaultTableModel(data, cols));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministrator = new JFrame();
		frmAdministrator.setResizable(false);
		frmAdministrator.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./icon/Apps-kdevelop-icon.png"));
		frmAdministrator.setTitle("Administrator");
		frmAdministrator.getContentPane().setBackground(SystemColor.menu);
		frmAdministrator.setBounds(300, 100, 774, 452);
		frmAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministrator.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
		panel.setBounds(10, 11, 185, 92);
		frmAdministrator.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblDuongHuuDai = new JLabel("");
		lblDuongHuuDai.setIcon(new ImageIcon("./icon/Cookies-icon (1).png"));
		panel.add(lblDuongHuuDai);

		JLabel lblXinChoAdmin = new JLabel("Xin ch\u00E0o Admin");
		lblXinChoAdmin.setIcon(null);
		lblXinChoAdmin.setForeground(new Color(255, 20, 147));
		lblXinChoAdmin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(lblXinChoAdmin);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(new Color(135, 206, 235), 1, true));
		panel_1.setBounds(205, 11, 544, 92);
		frmAdministrator.getContentPane().add(panel_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./icon/admin_banner.gif"));
		panel_1.add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 114, 739, 294);
		frmAdministrator.getContentPane().add(tabbedPane);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.menu);
		tabbedPane.addTab("Tài Khoản Admin", (Icon) null, panel_3, null);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 714, 120);
		panel_3.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				txt_ID_admin.setText(table.getValueAt(row, 0).toString());
				txt_user_admin.setText(table.getValueAt(row, 1).toString());
				txt_pass_admin.setText(table.getValueAt(row, 2).toString());
			}
		});
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_2.setBounds(10, 142, 714, 113);
		panel_3.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(248, 26, 75, 14);
		panel_2.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(475, 24, 75, 19);
		panel_2.add(lblPassword);

		txt_user_admin = new JTextField();
		txt_user_admin.setBounds(341, 24, 117, 19);
		panel_2.add(txt_user_admin);
		txt_user_admin.setColumns(10);

		txt_pass_admin = new JTextField();
		txt_pass_admin.setBounds(557, 24, 117, 19);
		panel_2.add(txt_pass_admin);
		txt_pass_admin.setColumns(10);

		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO project.admin (idad, user, pass) VALUES (?, ?, ?)";
				try {
					if(txt_ID_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "ID admin không được để trống !");
					}else if(txt_user_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					}else if(txt_pass_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					}else{
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txt_ID_admin.getText());
					stmt.setString(2, txt_user_admin.getText());
					stmt.setString(3, txt_pass_admin.getText());
					stmt.executeUpdate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ID đã tồn tại !");
				}
				showAdmin();
			}
		});
		btnThm.setBounds(80, 68, 89, 23);
		panel_2.add(btnThm);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE project.admin SET user=?, pass=? WHERE idad=?";
				try {
					if(txt_ID_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "ID admin không được để trống !");
					}else if(txt_user_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					}else if(txt_pass_admin.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					}else{
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txt_user_admin.getText());
					stmt.setString(2, txt_pass_admin.getText());
					stmt.setString(3, txt_ID_admin.getText());
					stmt.executeUpdate();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				showAdmin();
			}
		});
		btnSa.setBounds(223, 68, 89, 23);
		panel_2.add(btnSa);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM project.admin WHERE idad=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txt_ID_admin.getText());
					int reponse = JOptionPane.showConfirmDialog(frmAdministrator,
							"Bạn có chắc chắn admin " + txt_user_admin.getText() + " không?", "Delete person",
							JOptionPane.YES_NO_OPTION);
					String message = "?";
					switch (reponse) {
					case JOptionPane.YES_OPTION:
						message = "Xóa admin " + txt_user_admin.getText() + " thành công!";
						stmt.executeUpdate();
						break;
					case JOptionPane.NO_OPTION:
						message = "Không xóa admin " + txt_user_admin.getText();
						break;
					}
					JOptionPane.showMessageDialog(frmAdministrator, message);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				showAdmin();
			}
		});
		btnXa.setBounds(376, 68, 89, 23);
		panel_2.add(btnXa);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ID_admin.setText(null);
				txt_user_admin.setText(null);
				txt_pass_admin.setText(null);
			}
		});
		btnReset.setBounds(538, 68, 89, 23);
		panel_2.add(btnReset);

		JLabel lblIdAdmin = new JLabel("ID Admin:");
		lblIdAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdAdmin.setBounds(22, 24, 75, 14);
		panel_2.add(lblIdAdmin);

		txt_ID_admin = new JTextField();
		txt_ID_admin.setBounds(107, 22, 117, 20);
		panel_2.add(txt_ID_admin);
		txt_ID_admin.setColumns(10);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Tài Khoản Giáo Vụ", null, panel_6, null);
		panel_6.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_8.setBackground(new Color(230, 230, 250));
		panel_8.setBounds(10, 142, 714, 113);
		panel_6.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblIdGiaoVu = new JLabel("ID Giáo Vụ:");
		lblIdGiaoVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdGiaoVu.setBounds(22, 24, 75, 14);
		panel_8.add(lblIdGiaoVu);

		txtIDgiaovu = new JTextField();
		txtIDgiaovu.setBounds(107, 22, 117, 20);
		panel_8.add(txtIDgiaovu);
		txtIDgiaovu.setColumns(10);

		JLabel lblUsername_2 = new JLabel("Username:");
		lblUsername_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername_2.setBounds(248, 26, 75, 14);
		panel_8.add(lblUsername_2);

		txtUsergiaovu = new JTextField();
		txtUsergiaovu.setBounds(341, 24, 117, 19);
		panel_8.add(txtUsergiaovu);
		txtUsergiaovu.setColumns(10);

		JLabel lblPassword_2 = new JLabel("Password:");
		lblPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword_2.setBounds(475, 24, 75, 19);
		panel_8.add(lblPassword_2);

		txtPassgiaovu = new JTextField();
		txtPassgiaovu.setBounds(557, 24, 117, 19);
		panel_8.add(txtPassgiaovu);
		txtPassgiaovu.setColumns(10);

		JButton btnThm_2 = new JButton("Thêm");
		btnThm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO project.giaovu (idgvu, user, pass) VALUES (?, ?, ?)";
				try {
					if(txtIDgiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "ID giáo vụ không được để trống !");
					}else if(txtUsergiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					}else if(txtPassgiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					}else{
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtIDgiaovu.getText());
					stmt.setString(2, txtUsergiaovu.getText());
					stmt.setString(3, txtPassgiaovu.getText());
					stmt.executeUpdate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ID đã tồn tại !");
				}
				showGiaovu();
			}
		});
		btnThm_2.setBounds(80, 68, 89, 23);
		panel_8.add(btnThm_2);

		JButton btnSa_2 = new JButton("Sửa");
		btnSa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE project.giaovu SET user=?, pass=? WHERE idgvu=?";
				try {
					if(txtIDgiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "ID giáo vụ không được để trống !");
					}else if(txtUsergiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					}else if(txtPassgiaovu.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					}else{
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtUsergiaovu.getText());
					stmt.setString(2, txtPassgiaovu.getText());
					stmt.setString(3, txtIDgiaovu.getText());
					stmt.executeUpdate();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				showGiaovu();
			}
		});
		btnSa_2.setBounds(223, 68, 89, 23);
		panel_8.add(btnSa_2);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM project.giaovu WHERE idgvu=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtIDgiaovu.getText());
					int reponse = JOptionPane.showConfirmDialog(frmAdministrator,
							"Bạn có chắc chắn giáo vụ " + txtUsergiaovu.getText() + " không?", "Delete person",
							JOptionPane.YES_NO_OPTION);
					String message = "?";
					switch (reponse) {
					case JOptionPane.YES_OPTION:
						message = "Xóa giáo vụ " + txtUsergiaovu.getText() + " thành công!";
						stmt.executeUpdate();
						break;
					case JOptionPane.NO_OPTION:
						message = "Không xóa giáo vụ " + txtUsergiaovu.getText();
						break;
					}
					JOptionPane.showMessageDialog(frmAdministrator, message);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				showGiaovu();
			}
		});
		btnXoa.setBounds(376, 68, 89, 23);
		panel_8.add(btnXoa);

		JButton btnReset_2 = new JButton("Reset");
		btnReset_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDgiaovu.setText(null);
				txtPassgiaovu.setText(null);
				txtUsergiaovu.setText(null);
			}
		});
		btnReset_2.setBounds(538, 68, 89, 23);
		panel_8.add(btnReset_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 714, 120);
		panel_6.add(scrollPane_2);

		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_2.getSelectedRow();
				txtIDgiaovu.setText(table_2.getValueAt(row, 0).toString());
				txtUsergiaovu.setText(table_2.getValueAt(row, 1).toString());
				txtPassgiaovu.setText(table_2.getValueAt(row, 2).toString());
			}
		});
		scrollPane_2.setViewportView(table_2);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Tài Khoản Giáo Viên", null, panel_5, null);
		panel_5.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 714, 120);
		panel_5.add(scrollPane_1);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				try {
					txt_ID_giaovien.setText(table_1.getValueAt(row, 0).toString());
					txt_user_giaovien.setText(table_1.getValueAt(row, 1).toString());
					txt_pass_giaovien.setText(table_1.getValueAt(row, 2).toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Nhập password cho giáo viên " + table_1.getValueAt(row, 1).toString());
				}
			}
		});
		scrollPane_1.setViewportView(table_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_4.setBounds(10, 142, 714, 113);
		panel_5.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblIdGioVin = new JLabel("ID Giáo Viên:");
		lblIdGioVin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdGioVin.setBounds(22, 24, 75, 14);
		panel_4.add(lblIdGioVin);

		txt_ID_giaovien = new JTextField();
		txt_ID_giaovien.setBounds(107, 22, 117, 20);
		panel_4.add(txt_ID_giaovien);
		txt_ID_giaovien.setColumns(10);

		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername_1.setBounds(248, 26, 75, 14);
		panel_4.add(lblUsername_1);

		txt_user_giaovien = new JTextField();
		txt_user_giaovien.setBounds(341, 24, 117, 19);
		panel_4.add(txt_user_giaovien);
		txt_user_giaovien.setColumns(10);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword_1.setBounds(475, 24, 75, 19);
		panel_4.add(lblPassword_1);

		txt_pass_giaovien = new JTextField();
		txt_pass_giaovien.setBounds(557, 24, 117, 19);
		panel_4.add(txt_pass_giaovien);
		txt_pass_giaovien.setColumns(10);

		JButton btnThm_1 = new JButton("Thêm");
		btnThm_1.setEnabled(false);
		btnThm_1.setBounds(80, 68, 89, 23);
		panel_4.add(btnThm_1);

		JButton btnSa_1 = new JButton("Sửa");
		btnSa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "UPDATE project.giaovien SET pass=? WHERE idgv=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txt_pass_giaovien.getText());
					stmt.setString(2, txt_ID_giaovien.getText());
					stmt.executeUpdate();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Cập nhật lỗi !");
				}
				showGiaovien();
			}
		});
		btnSa_1.setBounds(223, 68, 89, 23);
		panel_4.add(btnSa_1);

		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.setEnabled(false);
		btnXa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE project.giaovien WHERE idgv=?";
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, txt_ID_giaovien.getText());
					stmt.executeUpdate();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				showGiaovien();
			}
		});
		btnXa_1.setBounds(376, 68, 89, 23);
		panel_4.add(btnXa_1);

		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ID_giaovien.setText(null);
				txt_pass_giaovien.setText(null);
				txt_user_giaovien.setText(null);
			}
		});
		btnReset_1.setBounds(538, 68, 89, 23);
		panel_4.add(btnReset_1);
	}
}
