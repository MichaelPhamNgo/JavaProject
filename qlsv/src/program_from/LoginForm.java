package program_from;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.alee.laf.WebLookAndFeel;

import controller.DBUtil;
import model.Login;

public class LoginForm {

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				WebLookAndFeel.install();
				try {
					LoginForm window = new LoginForm();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void giaovien() {
		String sqlgv = "SELECT * FROM project.giaovien WHERE hoten=? AND pass=?";
		try {
			stmt = conn.prepareStatement(sqlgv);
			stmt.setString(1, txtUsername.getText());
			stmt.setString(2, txtPassword.getText());
			rs = stmt.executeQuery();
			if (rs.next()) {
				String a = txtUsername.getText(), b = rs.getString("hoten");
				if (a.equals(b)) {
					Login login = new Login(rs.getString("hoten"), rs.getString("idgv"), "Xin chào giáo viên ");
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
					MainForm window = new MainForm(login);
					frmLogin.dispose();
					window.frmMarkManagerSystem.setVisible(true);
					window.btnqlgiaovien.setEnabled(false); // Tat ql gv
					window.btnqllop.setEnabled(false); // Tat quan ly lop
					window.btnqlkhoa.setEnabled(false); // Tat quan ly khoa
					window.btnqlmon.setEnabled(false); // Tat quan ly mon
				} else {
					JOptionPane.showMessageDialog(null, "Username giáo viên gần đúng !");
				}
			} else {
				giaovu();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập \n");
		}

	}

	public void giaovu() {
		String sqlad = "SELECT * FROM project.giaovu WHERE user=? AND pass=?";
		try {
			stmt = conn.prepareStatement(sqlad);
			stmt.setString(1, txtUsername.getText());
			stmt.setString(2, txtPassword.getText());
			rs = stmt.executeQuery();
			if (rs.next()) {
				String a = txtUsername.getText(), b = rs.getString("user");
				if (a.equals(b)) {
				Login login = new Login(rs.getString("user"), rs.getString("idgvu"), "Xin chào Giáo Vụ");
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
				MainForm window = new MainForm(login);
				frmLogin.dispose();
				window.frmMarkManagerSystem.setVisible(true);
				window.btnqldiem.setEnabled(false);
				}else{
					JOptionPane.showMessageDialog(null, "Username giáo vụ gần đúng !");
				}
			} else {
				admin();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập");
		}
	}

	public void admin() {
		String sqlad = "SELECT * FROM project.admin WHERE user=? AND pass=?";
		try {
			stmt = conn.prepareStatement(sqlad);
			stmt.setString(1, txtUsername.getText());
			stmt.setString(2, txtPassword.getText());
			rs = stmt.executeQuery();
			if (rs.next()) {
				String a = txtUsername.getText(), b = rs.getString("user");
				if (a.equals(b)) {
				Login login = new Login(rs.getString("user"), "", "");
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
				AdminForm window = new AdminForm(login);
				frmLogin.dispose();
				window.frmAdministrator.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Username admin gần đúng !");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Đăng nhập không thành công!");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Lỗi đăng nhập");
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login Mark Manager System 2016");
		frmLogin.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./icon/Apps-preferences-system-login-icon.png"));
		frmLogin.setBounds(460, 210, 420, 240);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"./icon/Apps-preferences-system-login-icon (1).png"));
		label.setBounds(10, 22, 142, 128);
		frmLogin.getContentPane().add(label);

		txtUsername = new JTextField();
		txtUsername.setBounds(244, 39, 129, 20);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(162, 42, 72, 14);
		frmLogin.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(162, 89, 72, 14);
		frmLogin.getContentPane().add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(244, 86, 129, 20);
		frmLogin.getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlsv = "SELECT * FROM project.sinhvien WHERE hoten=? AND idsv=? ";
				try {
					stmt = conn.prepareStatement(sqlsv);
					if (txtUsername.getText().toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					} else if (txtPassword.getText().toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					} else {
						stmt.setString(1, txtUsername.getText());
						stmt.setString(2, txtPassword.getText());
						rs = stmt.executeQuery();
						if (rs.next()) {
							String a = txtUsername.getText(), b = rs.getString("hoten");
							if (a.equals(b)) {
							Login login = new Login(rs.getString("hoten"), rs.getString("idsv"), "Xin chào sinh viên");
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
							MainForm window = new MainForm(login);
							frmLogin.dispose();
							window.frmMarkManagerSystem.setVisible(true);
							window.tabbedPane.remove(window.quan_ly); //Xoa tab ql
							window.panel_3.removeAll(); // Xoa moi chay duoc loi chao xem diem panel_1
							}else{
								JOptionPane.showMessageDialog(null, "Username sinh viên gần đúng !");
							}
						} else {
							giaovien();
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi đăng nhập \n" + e2);
				}
			}
		});
		btnLogin.setIcon(
				new ImageIcon("./icon/User-Interface-Login-icon (1).png"));
		btnLogin.setBounds(162, 141, 96, 30);
		frmLogin.getContentPane().add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
			}
		});
		btnExit.setIcon(new ImageIcon("./icon/Delete-icon (1).png"));
		btnExit.setBounds(277, 141, 96, 30);
		frmLogin.getContentPane().add(btnExit);
	}
}
